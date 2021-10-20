package com.guodong.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.guodong.eduservice.entity.EduSubject;
import com.guodong.eduservice.entity.excel.ExcelSubjectData;
import com.guodong.eduservice.listener.SubjectExcelListener;
import com.guodong.eduservice.mapper.EduSubjectMapper;
import com.guodong.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guodong.servicebase.exception.MyException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.Subject;
import java.io.InputStream;



@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {
//    @Override
//    public void bathImport(MultiPartFile file) {
//
//    }


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
}


