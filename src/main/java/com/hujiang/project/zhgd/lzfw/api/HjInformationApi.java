package com.hujiang.project.zhgd.lzfw.api;


import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.project.zhgd.RestTemplateUtil;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjZhgdVehicle.api.VehicleParkingAPI;
import com.hujiang.project.zhgd.lzfw.domain.HjInformation;
import com.hujiang.project.zhgd.util.AliyunOSSClientUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/lzfw")
//@FeignClient(name = "merchant-backend")
public class HjInformationApi extends BaseController {
    private Logger logger = Logger.getLogger(VehicleParkingAPI.class.getName());
    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Autowired
    private SystemClient client;

    /**
     * 查看详情
     * */

    @RequestMapping(value = "/particulars")
    @ResponseBody
    public JSONObject particulars(HjInformation hjInformation,PageDomain pageDomain){
        return client.particulars(hjInformation,pageDomain.getPageNum(),pageDomain.getPageSize());

    }

     /**
     * 删除
     * */
    @PostMapping(value = "/deleteHjInformationById")
    public JSONObject deleteHjInformationById(@RequestParam(value ="id" )Integer id){
            return client.deleteHjInformationById(id);
    }

    /**
     * 上传
     * */
    @RequestMapping(value = "/instadd")
    @ResponseBody
    public JSONObject instadd(HjInformation hjInformation) throws IOException {
        HjInformation information = new HjInformation();
        String url = null;
        String[] q = new String[hjInformation.getFile().length];
        String[] w = new String[hjInformation.getFile().length];
        for (int i = 0;i<hjInformation.getFile().length;i++){
            q[i] = hjInformation.getFile()[i].getOriginalFilename();
            url= AliyunOSSClientUtil.uploadFileImg(hjInformation.getFile()[i],q[i],"");
            String name = url.substring(0,url.lastIndexOf("?"));
            w[i] = name;
        }
        information.setFilePaths(w);
        information.setFileNames(q);
        information.setUploadingName(hjInformation.getUploadingName());
        information.setUploadingDate(new Date());
        information.setRemark(hjInformation.getRemark());
        information.setUnitId(hjInformation.getUnitId());
        information.setProjectId(hjInformation.getProjectId());
        information.setMenuId(hjInformation.getMenuId());
        return client.instadd(information);
    }


    /**
     * 编辑
     * */
    @PostMapping(value = "/upda")
    @ResponseBody
    public JSONObject upda(HjInformation hjInformation)  {
        return client.upda(hjInformation);
    }

    /**
    * 下载
    * */
    @GetMapping("testDownload")
    public void downCfg(String imgURL, HttpServletResponse response) throws IOException {
        String fileName = imgURL.substring(imgURL.lastIndexOf("/")+1,imgURL.length());
        // 创建URL
        URL url = new URL(imgURL);
        byte[] by = new byte[1024];
        // 创建链接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        try (
                InputStream inputStream = conn.getInputStream();
                OutputStream outputStream = response.getOutputStream();) {

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

