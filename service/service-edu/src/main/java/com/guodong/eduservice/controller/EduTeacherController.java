package com.guodong.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guodong.commonutils.R;
import com.guodong.eduservice.entity.EduTeacher;
import com.guodong.eduservice.service.EduTeacherService;
import com.guodong.eduservice.entity.vo.TeacherQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author guodongdong30
 * @since 2021-05-10
 */

@Api("讲师列表")
@CrossOrigin
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {


    @Autowired
    private EduTeacherService eduTeacherService;

//    @ApiOperation("查找所有讲师")
//    @GetMapping("/findAll")
//    public List<EduTeacher> findALl(){
//        List<EduTeacher> eduTeachers = eduTeacherService.list(null);
//               return eduTeachers;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    urn  eduTeachers;
//    }

    /**
     * 联系自己测试
     * @param id
     * @return
     */
//    @DeleteMapping("/{id}"
//    public boolean removeTeacher(@PathVariable String id){
//
//        eduTeacherService.removeById(id);
//        return false;
//


    @GetMapping("/removeTeacher")
    @ApiParam(name = "id", value = "讲师ID", required = true )
    public R removeTeacher(@RequestParam("id") String id){
        Boolean bool = eduTeacherService.removeById(id);
        if(bool){
          return R.ok();
        }else {
            return R.error().message("id不存在");
        }
    }

    @ApiOperation("查找所有讲师")
    @PostMapping("/getTeacher/{page}/{limit}")
    public R getTeacher(@ApiParam(name = "page", value ="当前页码", required = true) @PathVariable Long page,
                        @ApiParam(name = "limit", value ="限制条数", required = true )@PathVariable Long limit,
                        @ApiParam(name = "teacher", value = "查询条件", required = false)
                        @RequestBody TeacherQuery teacherQuery){
        Page<EduTeacher> pageParam = new Page<>(page, limit);
//        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper();
        eduTeacherService.pageQuery(pageParam, teacherQuery);
        List<EduTeacher> records = pageParam.getRecords();
        Long total = pageParam.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping("/save")
    public R save(
        @ApiParam(name = "eduTeacher", value = "讲师对象", required = true)  @RequestBody EduTeacher eduTeacher){
        eduTeacherService.save(eduTeacher);
        return R.ok();
    }

    @ApiOperation(value = "根据ID获取讲师")
    @GetMapping("/getTeacher/{id}")
    public R getById(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id){
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return R.ok().data("item", eduTeacher);
    }

    @ApiOperation(value = "根据ID修改")
    @PostMapping("/modify/{id}")
    public R modifyById(@ApiParam(name= "id", value = "讲师ID", required = true) @PathVariable String id,
                        @ApiParam(name="eduTeacher", value = "讲师对象", required = true) @RequestBody EduTeacher eduteacher
                        ){
        eduteacher.setId(id);
        eduTeacherService.updateById(eduteacher);
        return R.ok();
    }


}

