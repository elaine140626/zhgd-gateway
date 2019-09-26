package com.hujiang.project.zhgd.common;

import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.Constants;
import com.hujiang.project.zhgd.RestConfiguration;
import com.hujiang.project.zhgd.Util;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

/**
 * @program: Consumer01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-05-24 08:32
 **/
@RestController
@RequestMapping(value = "/api/file/upload",method = RequestMethod.POST)
public class FileController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public AjaxResult upload(MultipartFile[] file,String folderName)throws Exception{
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        System.out.println(folderName);
        System.out.println(file.length);
        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);

        File[] files = new File[file.length];
        //遍历文件数组
        for(int i=0;i<file.length;i++){

            File localFile = new File(Util.getPath(),"/"+file[i].getOriginalFilename());
            file[i].transferTo(localFile);
            files[i]=localFile;
            //多个MultipartFile同时添加进 MultiValueMap  key为file
            //MultiValueMap可以让一个key对应多个value
            param.add("file", new FileSystemResource(localFile));
        }

        param.add("folderName", folderName);
        //用HttpEntity封装整个请求报文
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(param, headers);
        AjaxResult reult = restTemplate.postForObject(Constants.SERVICE_NAME+"provider/fileApi/upload", httpEntity, AjaxResult.class);
        //删除临时文件
        for(int i=0;i<files.length;i++){
            if(files[i].exists()){
                System.out.println("删除临时文件"+files[i].getName());
                files[i].delete();
            }

        }
        return reult;
    }



}
