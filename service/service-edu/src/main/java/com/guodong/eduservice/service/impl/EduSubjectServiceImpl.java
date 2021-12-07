package com.guodong.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guodong.eduservice.entity.EduSubject;
import com.guodong.eduservice.entity.excel.ExcelSubjectData;
import com.guodong.eduservice.entity.subject.OneSubject;
import com.guodong.eduservice.entity.subject.TwoSubject;
import com.guodong.eduservice.listener.SubjectExcelListener;
import com.guodong.eduservice.mapper.EduSubjectMapper;
import com.guodong.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guodong.servicebase.exception.MyException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.Subject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {
//    @Override
//    public void bathImport(MultiPartFile file) {
//
//    }

    @Autowired
    private EduSubjectService eduSubjectService;


    @Override
    public void importSubjectData(MultipartFile file, EduSubjectService subjectService) {
        try{
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, ExcelSubjectData.class,  new SubjectExcelListener(subjectService)).sheet().doRead();

        }catch (Exception e){
            e.printStackTrace();
            throw  new MyException(20002, "添加课程分类失败");
        }
    }


    @Override
    public List<OneSubject> getAllTreeSubject() {
        List<OneSubject> oneSubjectListResult = new ArrayList<>(); //最后的结果


        QueryWrapper<EduSubject> eduSubjectQueryWrapperForOne = new QueryWrapper<>();
        eduSubjectQueryWrapperForOne.eq("parent_id", 0);
        List<EduSubject> oneSubjectList = baseMapper.selectList(eduSubjectQueryWrapperForOne);


        QueryWrapper<EduSubject> eduSubjectQueryWrapperForTwo = new QueryWrapper<>();
        eduSubjectQueryWrapperForTwo.ne("parent_id", 0);
        List<EduSubject> twoSubjectList = baseMapper.selectList(eduSubjectQueryWrapperForTwo);

        for(EduSubject eduSubjectone: oneSubjectList){
            OneSubject oneSubject = new OneSubject();
            BeanUtils.copyProperties(eduSubjectone, oneSubject);

            oneSubjectListResult.add(oneSubject);

            List<TwoSubject> twoSubjectsListResult = new ArrayList<>();

            for (EduSubject eduSubejctTwo: twoSubjectList){
                TwoSubject twoSubject = new TwoSubject();
                if(eduSubejctTwo.getParentId().equals(eduSubjectone.getId())){
                    BeanUtils.copyProperties(eduSubejctTwo, twoSubject);
                    twoSubjectsListResult.add(twoSubject);
                }
            }
            oneSubject.setChildren(twoSubjectsListResult);


        }
        return oneSubjectListResult;
    }
}


