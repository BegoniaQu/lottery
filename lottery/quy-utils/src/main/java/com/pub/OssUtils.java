package com.pub;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.pub.exception.SCCustomRuntimeException;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;

public class OssUtils {

    public static String uploadImg2Oss(MultipartFile file, OSSClient ossClient, String bucketName) {
        if (file.getSize() > 10 * 1024 * 1024) {
            throw new SCCustomRuntimeException("上传图片大小不能超过10M！");
        }
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        String newFileName = "hp_"+System.currentTimeMillis() + suffix;
        System.out.println(newFileName);
        try {
            InputStream inputStream = file.getInputStream();
            String result = uploadFile2OSS(ossClient, bucketName, inputStream, newFileName);
            System.out.println(result);

            // 图片处理样式
            //String style = "image/resize,m_fixed,w_100,h_100/rotate,90";
            //过期时间10分钟
            Date expiration = new Date(new Date().getTime() + 1000 * 60 * 10 );
            GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(bucketName, newFileName, HttpMethod.GET);
            req.setExpiration(expiration);
            //req.setProcess(style);
            URL signedUrl = ossClient.generatePresignedUrl(req);
            System.out.println(signedUrl);
        } catch (Exception e) {
            throw new SCCustomRuntimeException(e.getMessage());
        }finally {
            ossClient.shutdown();
        }
        return newFileName;
    }

    private static String uploadFile2OSS(OSSClient ossClient, String bucketName, InputStream instream, String fileName) {
        String ret = "";
        // 创建上传Object的Metadata
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setCacheControl("no-cache");
        objectMetadata.setHeader("Pragma", "no-cache");
        // 上传文件
        PutObjectResult putResult = ossClient.putObject(bucketName, fileName, instream, objectMetadata);
        return putResult.getETag();
    }
}
