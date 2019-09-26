package com.hujiang.project.zhgd.hjProject.controller;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.aspectj.lang.annotation.Log;
import com.hujiang.framework.aspectj.lang.enums.BusinessType;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.framework.web.page.TableDataInfo;
import com.hujiang.project.zhgd.Constants;
import com.hujiang.project.zhgd.RestTemplateUtil;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjConstructionCompany.domain.HjConstructionCompany;
import com.hujiang.project.zhgd.hjProject.domain.HjProject;
import com.hujiang.project.zhgd.hjProject.service.IHjProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Provider01
 * @description: 项目接口
 * @author: Mr.LiuYong
 * @create: 2019-05-14 17:37
 **/
@RestController
@RequestMapping(value = "/api/project", method = RequestMethod.POST)
public class ProjectContnroller extends BaseController {

    @Autowired
    private RestTemplateUtil restTemplateUtil;
    @Autowired
    private IHjProjectService hjProjectService;

    @Autowired
    private SystemClient client;

    /**
     * 查询项目信息
     * @param hjProject
     * @return
     */
    @RequestMapping("selectProjectList")
    public AjaxResult list(HjProject hjProject,Integer cid, PageDomain page)throws Exception {
        Map<String,Object> map  = new HashMap<>();
        map.put("hjProject",hjProject);
        map.put("cid",cid);

        return (AjaxResult)restTemplateUtil.PostPage(map,Constants.SERVICE_NAME+"provider/project/selectProjectList",page);
    }


    /**
     * 添加项目
     *
     * @param hjProject
     * @param cid
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/addProject")
    public Map<String,Object> addSave(HjProject hjProject, Integer cid, MultipartFile file, HjConstructionCompany hjConstructionCompany,String remark1 ,String shortName1  ) throws Exception {
        System.out.println(cid);
        Map<String,Object> map  = new HashMap<>();
        map.put("hjProject",hjProject);
        map.put("cid",cid);
        map.put("remark1",remark1);
        map.put("shortName1",shortName1);
        map.put("hjConstructionCompany",hjConstructionCompany);
        return(Map<String,Object>) restTemplateUtil.PostFile(map,Constants.SERVICE_NAME+"provider/project/addProject",file);
    }

    /**
     * 修改项目
     *
     * @param hjProject
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateProject")
    public Map<String,Object> updateProject(HjProject hjProject, MultipartFile file) throws Exception {

        return(Map<String,Object>) restTemplateUtil.PostFile(hjProject,Constants.SERVICE_NAME+"provider/project/updateProject",file);
    }

    /**
     * 删除项目
     */
    @Log(title = "项目", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    public Map<String,Object> remove(String ids)throws Exception
    {
        Map<String,Object> map  = new HashMap<>();
        map.put("ids",ids);
        return (Map<String,Object>)restTemplateUtil.Post(map,Constants.SERVICE_NAME+"provider/project/remove");
    }

    /**
     * 查询项目详情
     * @param projectId
     * @return
     */
    @RequestMapping("getProject")
    public  Map<String, Object> getProject(Integer projectId)throws Exception {
        Map<String,Object> map  = new HashMap<>();
        map.put("projectId",projectId);
        return (Map<String,Object>)restTemplateUtil.Post(map,Constants.SERVICE_NAME+"provider/project/getProject");
    }
    /**
     * 集团看板

     * @return
     */
    @RequestMapping("/selectListProjectArea")
    public   Map<String, Object> selectListProjectArea(@RequestParam(value = "companyId") Integer companyId,@RequestParam(value = "region") String region) {

        return client.selectListProjectArea(companyId,region);
    }

    /**
     * 智慧工地1.0看板，工程概括
     * */
    @RequestMapping("/getXmzk")
    @ResponseBody
    public JSONObject kanban(@RequestParam("id") Integer id){
        return client.kanban(id);
    }
    /**
     * 智慧工地1.0看板，安全文明施工天数
     * */
    @RequestMapping("/day")
    @ResponseBody
    public JSONObject day(@RequestParam("id") Integer id){
        return client.day(id);
    }
}
