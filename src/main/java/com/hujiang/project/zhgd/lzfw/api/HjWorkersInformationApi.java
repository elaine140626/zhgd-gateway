package com.hujiang.project.zhgd.lzfw.api;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.lzfw.domain.HjWorkersInformation;
import com.hujiang.project.zhgd.lzfw.domain.HjWorkersInformationPc;
import com.hujiang.project.zhgd.util.AliyunOSSClientUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/workersInformationAp")
public class HjWorkersInformationApi extends BaseController {

    @Autowired
    private SystemClient client;
    /**
     * 上传图片
     * */
    @PostMapping(value = "insteradd")
    @ResponseBody
    public JSONObject insteradd(HjWorkersInformation hjWorkersInformation) throws IOException {
        HjWorkersInformation information = new HjWorkersInformation();
        if (hjWorkersInformation.getFile()!=null && !hjWorkersInformation.getFile().equals("")) {
            String url = null;
            url = AliyunOSSClientUtil.uploadFileImg(hjWorkersInformation.getFile(), "zhgd_img", hjWorkersInformation.getFile().getOriginalFilename());
            String name = url.substring(0, url.lastIndexOf("?"));
            information.setPath(name);//路径
            information.setTypeid(hjWorkersInformation.getTypeid());
            information.setUserId(hjWorkersInformation.getUserId());
            information.setProjectId(hjWorkersInformation.getProjectId());
        }else {
            information.setTypeid(hjWorkersInformation.getTypeid());
            information.setUserId(hjWorkersInformation.getUserId());
            information.setProjectId(hjWorkersInformation.getProjectId());
        }
        return client.insteradd(information);
    }



    /**
     * 查询所有
     * */
    @PostMapping(value = "/selectall")
    @ResponseBody
    public JSONObject selectall(HjWorkersInformation hjWorkersInformation ,PageDomain pageDomain){
       return client.selectall(hjWorkersInformation,pageDomain.getPageSize(),pageDomain.getPageNum());
    }


    @PostMapping("/delete")
    public JSONObject delete(Integer id){
        return client.delete(id);
    }


    /** 统计*/
    @PostMapping("/lzfwtj")
    public JSONObject selectzhiliaoqiquan(Integer projectId){
        return client.selectzhiliaoqiquan(projectId);
    }

    /**
     * 查看详情
     * */
    @PostMapping(value = "/sele")
    public JSONObject sele (Integer userid){
        return client.sele(userid);
    }

    @GetMapping("/workersExport")
    public void export(HjWorkersInformation hjWorkersInformation, HttpServletResponse response)throws Exception{
        System.out.println("导出Excel："+hjWorkersInformation);
        List<HjWorkersInformationPc> list = client.export(hjWorkersInformation);
        ExcelUtil<HjWorkersInformationPc> util = new ExcelUtil<HjWorkersInformationPc>(HjWorkersInformationPc.class);
        //生成Excel
        AjaxResult a = util.exportExcel(list, "工人信息");
        //设置下载文件名
        String fileName = URLEncoder.encode((String)a.get("msg"), "UTF-8");
        File file = new File(Util.getPath(), (String) a.get("msg"));
        try (InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = response.getOutputStream();) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(file.exists()){
            file.delete();
        }
    }

}
