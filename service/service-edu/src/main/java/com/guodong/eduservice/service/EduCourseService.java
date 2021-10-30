package com.guodong.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guodong.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guodong.eduservice.entity.vo.CoureQuery;
import com.guodong.eduservice.entity.vo.CourseInfoVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author guodongdong30
 * @since 2021-10-20
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfo(CourseInfoVo courseInfoVo);

    void pageQuery(Page pageParam, CoureQuery coureQuery);

}
