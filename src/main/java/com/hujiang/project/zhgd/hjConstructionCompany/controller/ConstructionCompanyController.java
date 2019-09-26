package com.hujiang.project.zhgd.hjConstructionCompany.controller;


import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.aspectj.lang.annotation.Log;
import com.hujiang.framework.aspectj.lang.enums.BusinessType;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.project.zhgd.Constants;
import com.hujiang.project.zhgd.RestTemplateUtil;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjConstructionCompany.domain.HjConstructionCompany;

import com.hujiang.project.zhgd.hjProjectWorkers.domain.HjProjectWorkers;
import com.hujiang.project.zhgd.hjProjectWorkers.domain.ProjectWorkerPC;
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
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 参建单位
 *
 * @author hujiang
 * @date 2019-05-19
 */
@RestController
@RequestMapping(value = "/api/constructionCompanyApi",method = RequestMethod.POST)
public class ConstructionCompanyController extends BaseController {
    private Logger logger = Logger.getLogger(ConstructionCompanyController.class.getName());
    @Autowired
    private RestTemplateUtil restTemplateUtil;
    @Autowired
    private SystemClient systemClient;

    /**
     *  新建保存参建单位--对外
     *  返回参见单位ID
     * @param
     * @return
     */
    @RequestMapping("/insertConstructionCompanyTwo")
    @ResponseBody
    public AjaxResult insertConstructionCompanyTwo(@RequestBody String json)throws Exception
    {
        return systemClient.insertConstructionCompanyTwo(json);
    }

    /**
     * 新建保存参建单位
     * @param projectId 项目id
     * @return
     */
    @Log(title = "参建单位", businessType = BusinessType.INSERT)
    @RequestMapping("/insertConstructionCompany")
    public Map<String,Object> insertConstructionCompany( HjConstructionCompany hjConstructionCompany, Integer projectId)throws Exception
    {
        Map<String,Object> map = new HashMap<>();
        map.put("projectId",projectId);
        for (Field f : hjConstructionCompany.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if(f.get(hjConstructionCompany)!=null){
                map.put(f.getName(), String.valueOf(f.get(hjConstructionCompany)));
            }
        }
        return (Map<String,Object>)restTemplateUtil.Post(map, Constants.SERVICE_NAME+"/provider/constructionCompanyApi/insertConstructionCompany");
    }
    /**
     * 修改保存参建单位
     * @param hjConstructionCompany 参建单位信息
     * @return
     */
    @RequestMapping("/updateConstructionCompany")
    public Map<String,Object> updateConstructionCompany( HjConstructionCompany hjConstructionCompany)throws Exception
    {
        return (Map<String,Object>)restTemplateUtil.Post(hjConstructionCompany, Constants.SERVICE_NAME+"/provider/constructionCompanyApi/updateConstructionCompany");
    }
    /**
     * 查询参建单位列表
     * @param projectId 项目id
     * @param param 项目名或简称
     * @return
     */
    @RequestMapping("/selectConstructionCompanyList")
    public Map<String,Object> selectHjConstructionCompanyListTwo(String param ,String suid, Integer projectId, PageDomain pageDomain)throws Exception
    {
        if(projectId==null){
            return AjaxResult.error(-1,"projectId为空");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("param",param);
        map.put("projectId",projectId);
        map.put("suid",suid);
        return (Map<String,Object>)restTemplateUtil.PostPage(map, Constants.SERVICE_NAME+"/provider/constructionCompanyApi/selectConstructionCompanyList",pageDomain);
    }

    /**
     * 导出参建单位
     * @throws Exception
     */
    @GetMapping("/export")
    public void export(String param , String suid, Integer projectId,HttpServletResponse response)throws Exception{
        List<HjConstructionCompany> list = systemClient.export(param,suid,projectId);
        ExcelUtil<HjConstructionCompany> util = new ExcelUtil<HjConstructionCompany>(HjConstructionCompany.class);
        //生成Excel
        AjaxResult a = util.exportExcel(list, "参建单位");

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
     * 根据id查询参建单位
     * @param id 参建单位id
     * @return
     */
    @RequestMapping("/selectConstructionCompanyId")
    public Map<String,Object> selectHjConstructionCompanyIds(Integer id)throws Exception
    {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        return (Map<String,Object>)restTemplateUtil.Post(map, Constants.SERVICE_NAME+"/provider/constructionCompanyApi/selectConstructionCompanyId");
    }



    /**
     * 参建单位
     * @param projectId 项目id
     * @return
     */
    @RequestMapping("/selectConstructionCompany")
    @ResponseBody
    public Map<String, Object> selectConstructionCompany(Integer projectId)throws Exception
    {
        Map<String,Object> map = new HashMap<>();
        map.put("projectId",projectId);
//        return (Map<String, Object>)restTemplateUtil.Post(map, Constants.SERVICE_NAME+"/provider/constructionCompanyApi/selectConstructionCompany");
        return systemClient.selectConstructionCompany(projectId);
    }


    /**
     * 删除参建单位
     * @param ids 参建单位id
     * @return
     */
    @RequestMapping("/deleteConstructionCompanyIds")
    @ResponseBody
    public Map<String, Object>  deleteHjConstructionCompanyIds(String ids)throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("ids",ids);
        return (Map<String, Object> )restTemplateUtil.Post(map, Constants.SERVICE_NAME+"/provider/constructionCompanyApi/deleteConstructionCompanyIds");
    }




}
