package com.guodong.eduservice.service;

import com.guodong.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guodong.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author guodongdong30
 * @since 2021-09-03
 */
public interface EduSubjectService extends IService<EduSubject> {
//    void bathImport(MultiPartFile file);

    void importSubjectData(MultipartFile file, EduSubjectService subjectService);

     List<OneSubject> getAllTreeSubject();
}
