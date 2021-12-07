package com.guodong.ossservice.controller;


import com.guodong.commonutils.R;
import com.guodong.ossservice.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    @PostMapping("/upload")
    public R uploadOssFile(MultipartFile file){
        String url = ossService.uploadFileAvatar(file);
        Map<String,Object> data = new HashMap<>();
        data.put("url", url);
        return R.ok().message("上传成功").data((HashMap) data);
    }




}
