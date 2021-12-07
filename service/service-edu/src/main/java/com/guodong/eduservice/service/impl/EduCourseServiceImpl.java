package com.guodong.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guodong.eduservice.entity.EduCourse;
import com.guodong.eduservice.entity.vo.CoureQuery;
import com.guodong.eduservice.entity.vo.CourseInfoVo;
import com.guodong.eduservice.mapper.EduCourseMapper;
import com.guodong.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author guodongdong30
 * @since 2021-10-20
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {
    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse = new EduCourse();
//        eduCourse.setStatus(Couin)
        return null;
    }

    @Override
    public void pageQuery(Page pageParam, CoureQuery coureQuery) {
        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        if (coureQuery == null){
            baseMapper.selectPage(pageParam, queryWrapper);
        }
        baseMapper.selectPage(pageParam, queryWrapper);

    }


}
