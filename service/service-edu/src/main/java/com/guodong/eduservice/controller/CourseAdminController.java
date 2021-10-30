package com.guodong.eduservice.controller;


import com.alibaba.excel.util.StringUtils;
import com.guodong.commonutils.R;
import com.guodong.eduservice.entity.vo.CourseInfoVo;
import com.guodong.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description="课程管理")
@CrossOrigin
@RestController
@RequestMapping("")
public class CourseAdminController {

    @Autowired
    private EduCourseService  eduCourseServicecourse;

    @ApiOperation(value = "新增课程")
    @PostMapping("save-course-info")
    public R saveCourseInfo(@ApiParam(name= "CourseInfoForm", value="课程基本信息", required = true)
                                @RequestBody CourseInfoVo courseInfoVo){
        String courseId = eduCourseServicecourse.saveCourseInfo(courseInfoVo);
        if (StringUtils.isEmpty(courseId)){
            return R.ok().data("courseId", courseId);
        }else
            return R.error().message("保存失败");

    };

}
