package com.hujiang.project.zhgd.hjProjectWorkers.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.aspectj.lang.annotation.Log;
import com.hujiang.framework.aspectj.lang.enums.BusinessType;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.framework.web.page.TableDataInfo;
import com.hujiang.project.zhgd.Constants;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjProjectWorkers.domain.*;
import com.hujiang.project.zhgd.hjProjectWorkers.service.IHjProjectWorkersService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 人员信息
 *
 * @author hujiang
 * @date 2019-05-20
 */
@RestController
@RequestMapping(value = "/api/pc/projectWorkersApi", method = RequestMethod.POST)
public class PC_ProjectWorkersApi extends BaseController {


    @Autowired
    private IHjProjectWorkersService hjProjectWorkersService;
    @Autowired
    private SystemClient systemClient;

    /**
     * 查询项目工人列表
     */
    @PostMapping("/list")
    public Map<String, Object> list(HjProjectWorkers hjProjectWorkers, PageDomain pageDomain) throws Exception {
        return systemClient.listProjectWorker(hjProjectWorkers,pageDomain);}
    /**
     * 查询项目工人列表
     */
    @PostMapping("/quarantineList")
    public Map<String, Object> quarantineList(HjProjectWorkers hjProjectWorkers, PageDomain pageDomain) throws Exception {
       return systemClient.quarantineList(hjProjectWorkers,pageDomain);}
    /**
     * 修改前查询
     * @param id 人员id
     * @param
     * @return
     */
    @PostMapping(value = "queryProjectWorkers")
    public  Map<String,Object> queryProjectWorkers(Integer id)throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        return systemClient.queryProjectWorkers(id);
  }
    /**
     * 同步人员 进出或退场
     * @param tag
     * @param ids
     * @return
     */
    @PostMapping(value = "outOrIn")
    public  Map<String,Object> out(Integer tag,String ids){
        return systemClient.outOrIn(tag,ids);
    }
    @PostMapping(value = "updateQuarantine")
    public  AjaxResult updateQuarantine(Integer tag,String ids){
        return systemClient.updateQuarantine(tag,ids);
    }

    /**
     * 同步人员 进出或退场
     * @return
     */
    @PostMapping(value = "outOrInTwo")
    public  Map<String,Object> outOrInTwo(@RequestBody String json){
        return systemClient.outOrInTwo(json);
    }



    @GetMapping("/export")
    public void export( HjProjectWorkers hjProjectWorkers, HttpServletResponse response)throws Exception{
        System.out.println("导出Excel："+hjProjectWorkers);
        List<ProjectWorkerPC> list = systemClient.export(hjProjectWorkers);
        ExcelUtil<ProjectWorkerPC> util = new ExcelUtil<ProjectWorkerPC>(ProjectWorkerPC.class);
        //生成Excel
        AjaxResult a = util.exportExcel(list, "项目工人");

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

//    /**
//     * 实名制录入
//     *
//     * @param hjProjectWorkers
//     * @return
//     */
//    @RequestMapping("/insertProjectWorkers")
//    public Map<String, Object> insertProjectWorkers(HjProjectWorkers hjProjectWorkers, MultipartFile face,  MultipartFile scan, MultipartFile scan2, MultipartFile bank) throws Exception {
//
//        Map<String,MultipartFile> map = new HashMap<>();
//        map.put("face",face);
//        map.put("scan",scan);
//        map.put("scan2",scan2);
//        map.put("bank",bank);
//        return ( Map<String, Object> )restTemplateUtil.PostFile(hjProjectWorkers,Constants.SERVICE_NAME +"provider/pc/projectWorkersApi/insertProjectWorkers",map);
//    }

    /**
     * 修改保存项目工人
     */
    @Log(title = "项目工人", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public Map<String, Object> editSave(HjProjectWorkers hjProjectWorkers)throws Exception
    {
        System.out.println(hjProjectWorkers);
        hjProjectWorkers.setUpdateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return systemClient.editSave(hjProjectWorkers);}

    /**
     * 获取合同统计
     * @param projectId
     * @return
     */
    @RequestMapping("/getDataCount")
    @ResponseBody
    public JSONObject projectWorkersApiGetDataCount(@RequestParam(value = "projectId")Integer projectId){
        return  systemClient.projectWorkersApiGetDataCount(projectId);
    }
    /**
     * 现场人员1.0
     * @param projectId
     * @return
     */
    @RequestMapping("/getKQCount")
    @ResponseBody
    public JSONObject projectWorkersApiGetKQCount(@RequestParam(value = "projectId") Integer projectId){
        return  systemClient.projectWorkersApiGetKQCount(projectId);
    }
}
