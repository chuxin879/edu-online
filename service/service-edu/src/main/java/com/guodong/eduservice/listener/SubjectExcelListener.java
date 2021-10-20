package com.guodong.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guodong.eduservice.entity.EduSubject;
import com.guodong.eduservice.entity.excel.ExcelSubjectData;
import com.guodong.eduservice.service.EduSubjectService;
import com.guodong.servicebase.exception.MyException;

public class SubjectExcelListener extends AnalysisEventListener<ExcelSubjectData> {

    public EduSubjectService subjectService;

    //创建有参构造，传递subejectService 用于数据库操作


    public SubjectExcelListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }


    @Override
    public void invoke(ExcelSubjectData user, AnalysisContext context){
        if (user == null){
            throw  new MyException(20001, "添加失败");
        }

        //添加一级分类
        EduSubject existOneSubject = this.existOneSubject(subjectService, user.getOneSubjectName());
        if (existOneSubject == null){
            existOneSubject = new EduSubject();
            existOneSubject.setTitle(user.getOneSubjectName());
            existOneSubject.setParentId("0");
            subjectService.save(existOneSubject);
        }

        String pid = existOneSubject.getId();
        EduSubject existTwoSubject = this.existTwoSubject(subjectService, user.getTwoSubjectName(), pid);
        if(existTwoSubject == null){
            existTwoSubject = new EduSubject();
            existTwoSubject.setTitle(user.getTwoSubjectName());
            existOneSubject.setParentId(pid);
            subjectService.save(existTwoSubject);
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    //判断一级分类是否存在
    private EduSubject existOneSubject(EduSubjectService subjectService, String name) {
        QueryWrapper<EduSubject>  wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", 0);
        EduSubject eduSubject = subjectService.getOne(wrapper);
        return eduSubject;
    }

    //判断二级分类是都存在

    private EduSubject existTwoSubject(EduSubjectService subjectService, String name, String pid){
        QueryWrapper<EduSubject> wrpper = new QueryWrapper<>();
        wrpper.eq("title", name);
        wrpper.eq("parent_id", pid);
        EduSubject eduSubject = subjectService.getOne(wrpper);
        return eduSubject;
    }


}
