package com.hujiang.project.zhgd.hjTeam.pcApi;


import com.alibaba.fastjson.JSONObject;
import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.project.zhgd.Constants;
import com.hujiang.project.zhgd.RestTemplateUtil;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjAttendanceRecord.domain.Param;
import com.hujiang.project.zhgd.hjTeam.domain.HjTeam;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

/**
 * pc端班组表
 * @author hujiang
 * @date 2019-05-21
 */
@RestController
@RequestMapping(value = "/api/pcCompanyLibrary" , method = RequestMethod.POST)
public class PcTeamApi  extends BaseController {
    private Logger logger = Logger.getLogger(PcTeamApi.class.getName());
    @Autowired
    private RestTemplateUtil restTemplateUtil;
    @Autowired
    private SystemClient systemClient;
    /**
     * 新建保存班组信息
     * @param
     * @return
     */
    @RequestMapping("/insertHjTeam")
    @ResponseBody
    public  Map<String,Object> insertHjTeam( HjTeam hjTeam)throws Exception
    {
        logger.info("保存班组信息开始---insertHjTeam---start");
        return systemClient.insertHjTeam(hjTeam);
//        return ( Map<String,Object>)restTemplateUtil.Post(hjTeam, Constants.SERVICE_NAME+"/provider/pcCompanyLibrary/insertHjTeam");
    }
    /**
     * 新建保存班组信息--对外
     * @param
     * @return
     */
    @RequestMapping("/insertHjTeamTwo")
    @ResponseBody
    public AjaxResult insertHjTeamTwo(@RequestBody String json)throws Exception
    {
        logger.info("保存班组信息开始---insertHjTeam---start");
        return systemClient.insertHjTeamTwo(json);
    }

    /**
     * 查询班组信息
     * @param
     * @return
     */
    @RequestMapping("/selectHjTeamId")
    @ResponseBody
    public Map<String,Object> selectHjTeamId(Integer id)throws Exception
    {
        logger.info("查询指定班组信息开始---selectHjTeamId---start");
        Map<String,Object> map = new HashMap();
        map.put("id",id);
        return systemClient.selectHjTeamId(id);
//       return ( Map<String,Object>)restTemplateUtil.Post(map, Constants.SERVICE_NAME+"/provider/pcCompanyLibrary/selectHjTeamId");
    }

    /**
     * 导出班组数据源
     * @param hjTeam
     * @return
     */
    @GetMapping("/export")
    public void export( HjTeam hjTeam, HttpServletResponse response)throws Exception{
        System.out.println("导出Excel："+hjTeam);
        List<HjTeam> list = systemClient.export(hjTeam);
        ExcelUtil<HjTeam> util = new ExcelUtil<HjTeam>(HjTeam.class);
        //生成Excel
        AjaxResult a = util.exportExcel(list, "班组");

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
    /**
     * 查询班组信息列表
     * @param
     * @return
     */
    @RequestMapping("/selectHjTeamList")
    @ResponseBody
    public AjaxResult selectHjTeamList(HjTeam hjTeam, PageDomain pageDomain)throws Exception
    {
        logger.info("查询班组信息列表开始---selectHjTeamList---start");
//        return ( AjaxResult)restTemplateUtil.PostPage(hjTeam, Constants.SERVICE_NAME+"/provider/pcCompanyLibrary/selectHjTeamList",pageDomain);
        return systemClient.selectHjTeamList(hjTeam,pageDomain.getPageSize(),pageDomain.getPageNum());
    }
    /**
     * 修改班组信息
     * @param
     * @return
     */
    @RequestMapping("/updateHjTeam")
    @ResponseBody
    public  Map<String,Object> updateHjTeam( HjTeam hjTeam)throws Exception
    {
        logger.info("修改班组信息开始---updateHjTeam---start");
        return systemClient.updateHjTeam(hjTeam);
//        return ( Map<String,Object>)restTemplateUtil.Post(hjTeam, Constants.SERVICE_NAME+"/provider/pcCompanyLibrary/updateHjTeam");
    }
    /**
     * 删除班组信息
     * @param
     * @return
     */
    @RequestMapping("/deleteHjTeam")
    @ResponseBody
    public  Map<String,Object> deleteHjTeam(String  ids)throws Exception
    {
        logger.info("删除班组信息开始---updateHjTeam---start");
        Map<String,Object> map = new HashMap();
        map.put("ids",ids);
        return systemClient.deleteHjTeam(ids);
//        return ( Map<String,Object>)restTemplateUtil.Post(map, Constants.SERVICE_NAME+"/provider/pcCompanyLibrary/deleteHjTeam");
    }


}
