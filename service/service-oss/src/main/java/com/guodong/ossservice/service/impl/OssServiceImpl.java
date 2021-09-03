package com.guodong.ossservice.service.impl;

import com.aliyun.oss.OSSClient;
import com.guodong.ossservice.service.OssService;
import com.guodong.ossservice.utils.ConstantPropertiesUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;


@Service
public class OssServiceImpl implements OssService {

    @Override
    public String uploadFileAvatar(MultipartFile file){
        String endpoint = ConstantPropertiesUtil.END_POINT;
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;
        //创建OSSClient实例
        try {
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

            //获取文件输入流
            InputStream  inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString().replace("_", "");
            fileName = uuid + fileName;

            //文件按照日期分类
            String datePath = new DateTime().toString("yyyy/MM/dd");
            fileName = datePath + "/"  + fileName;
            //调用OSS方法实现上传
            ossClient.putObject(bucketName, fileName, inputStream);
            //关闭OSSClient
            ossClient.shutdown();
            //返回上传的路径
            String uploadUrl = "https://" + bucketName + "." +endpoint + "/" +fileName;
            return uploadUrl;
        }catch (Exception e) {
            e.printStackTrace();
            return  null;
        }



    }
}
