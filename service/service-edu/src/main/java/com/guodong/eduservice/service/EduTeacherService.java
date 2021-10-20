package com.guodong.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guodong.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guodong.eduservice.entity.vo.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author guodongdong30
 * @since 2021-05-10
 */
public interface EduTeacherService extends IService<EduTeacher> {
    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);

}
