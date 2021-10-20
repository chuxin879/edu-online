package com.guodong.eduservice.controller;


import com.guodong.commonutils.R;
import com.guodong.eduservice.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author guodongdong30
 * @since 2021-09-03
 */

@Api(description="课程分类管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/eduservice/edu-subject")
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;

    @ApiOperation(value = "excel批量导入")
    @PostMapping("/addSubject")
    public R addSubject(MultipartFile multipartFile){
        eduSubjectService.importSubjectData(multipartFile, eduSubjectService);
        return R.ok();

    }



}

