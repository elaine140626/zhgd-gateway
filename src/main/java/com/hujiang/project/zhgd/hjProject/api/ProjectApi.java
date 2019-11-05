package com.hujiang.project.zhgd.hjProject.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjProject.domain.HjProject;
import com.hujiang.project.zhgd.zhNode.domain.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @program: Provider01
 * @description:
 * @author: yant
 **/
@RestController
@RequestMapping(value = "/api/project",method = RequestMethod.POST)
public class ProjectApi {
    @Autowired
    private SystemClient client;

    /**
     * 集团地图搜索项目
     */
    @RequestMapping("/selectProjects")
    public JSONObject selectProjects(HjProject hjProject){
        return client.selectProjects(hjProject);
    }

    /**
     * 集团地图搜索项目
     */
    @RequestMapping("/selectProjectRegion")
    public JSONObject selectProjectRegion(HjProject hjProject){
        return client.selectProjectRegion(hjProject);
    }

     /**
     * 集团看板统计信息
     */
    @RequestMapping(value = "/selectProjectArea")
    public Map<String, Object> selectProjectArea(@RequestParam(value = "companyId") Integer companyId, @RequestParam(value = "region") String region)
    {
        return  client.selectProjectArea(companyId,region);
    }

    /**
     * 集团看板公司列表
     */
    @RequestMapping(value = "/selectAreaProjectList")
    public AjaxResult selectAreaProjectList(@RequestParam(value = "companyId") Integer companyId,@RequestParam(value = "region") String region){
        return client.selectAreaProjectList(companyId,region);
    }
    /**
     *
     * */
    @RequestMapping(value = "/selectHjProject")
    public JSONObject selectHjProject(HjProject hjProject){
        return client.selectHjProject(hjProject);
    }

}
