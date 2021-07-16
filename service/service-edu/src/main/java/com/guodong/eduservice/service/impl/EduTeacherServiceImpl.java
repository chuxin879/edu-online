package com.guodong.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guodong.eduservice.entity.EduTeacher;
import com.guodong.eduservice.entity.vo.TeacherQuery;
import com.guodong.eduservice.mapper.EduTeacherMapper;
import com.guodong.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author guodongdong30
 * @since 2021-05-10
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {


    @Override
    public void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery){
        QueryWrapper<EduTeacher> queryWrapper= new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        if (teacherQuery == null) {
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }
        if(!StringUtils.isEmpty(level)){
            queryWrapper.eq("level", level);
        }
        //大于
       if(!StringUtils.isEmpty(begin)){
           queryWrapper.ge("gmt_create", begin);
       }

       //小于
       if(!StringUtils.isEmpty(end)){
           queryWrapper.le("gmt_create",end);
       }
       baseMapper.selectPage(pageParam, queryWrapper);


    };

}
