package com.guodong.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guodong.commonutils.R;
import com.guodong.eduservice.entity.EduCourse;
import com.guodong.eduservice.entity.vo.CoureQuery;
import com.guodong.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author guodongdong30
 * @since 2021-10-20
 */
@Api("设课程列表")
@RestController
@RequestMapping("/eduservice/edu-course")
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    @PostMapping("/getEduCourseInfo/{page}/{limit}")
    public R getEduCourseInfo(
            @ApiParam("当前页面数") @PathVariable Long page,
            @ApiParam("当前页面的数量") @PathVariable Long limit,
            @ApiParam("讲师列表") @RequestBody CoureQuery coureQuery
            ){
        Page<EduCourse> pageParam = new Page<>(page, limit);
        eduCourseService.pageQuery(pageParam, coureQuery);
        List<EduCourse> records = pageParam.getRecords();
        return R.ok().data("data",records);
    }

}

