package com.guodong.ossservice.service;

import com.guodong.commonutils.R;
import org.springframework.web.multipart.MultipartFile;

public interface OssService {

    public String uploadFileAvatar(MultipartFile file);
}
