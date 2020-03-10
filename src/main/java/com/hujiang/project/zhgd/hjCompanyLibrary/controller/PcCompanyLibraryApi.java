package com.hujiang.project.zhgd.hjCompanyLibrary.controller;



import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.framework.web.page.TableDataInfo;
import com.hujiang.project.zhgd.Constants;
import com.hujiang.project.zhgd.RestTemplateUtil;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjCompanyLibrary.domain.HjCompanyLibrary;
import com.hujiang.project.zhgd.hjCompanyLibrary.service.IHjCompanyLibraryService;
import com.hujiang.project.zhgd.hjProject.domain.HjProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * pc端公司库表
 * @author hujiang
 * @date 2019-05-21
 */
@RestController
@RequestMapping(value = "/api/pcCompanyLibrary" , method = RequestMethod.POST)
public class PcCompanyLibraryApi {
    private Logger logger = Logger.getLogger(PcCompanyLibraryApi.class.getName());
    @Autowired
    private IHjCompanyLibraryService hjCompanyLibraryService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RestTemplateUtil restTemplateUtil;
    @Autowired
    private SystemClient client;
    /**
     * 公司列表 分页
     * @param hjCompanyLibrary
     * @param page
     * @return
     * @throws Exception
     */
    @RequestMapping("companyLibraryList")
    public AjaxResult list(HjCompanyLibrary hjCompanyLibrary,Integer companyId, PageDomain pageDomain)throws Exception {
        System.out.println(hjCompanyLibrary);
        Map<String,Object> map = new HashMap<>();
        map.put("hjCompanyLibrary",hjCompanyLibrary);
        map.put("companyId",companyId);
        return client.listLibarary(hjCompanyLibrary,companyId,pageDomain.getPageSize(),pageDomain.getPageNum());
//        return (AjaxResult) restTemplateUtil.PostPage(map, Constants.SERVICE_NAME+"provider/pcCompanyLibrary/companyLibraryList",page);
    }
    /**
     * 保存公司库信息
     * @param
     * @return
     */
    @RequestMapping("/insertHjCompanyLibrary")
    public AjaxResult insertHjCompanyLibrary(HjCompanyLibrary hjCompanyLibrary, Integer pid)
    {
        logger.info("添加公司com.hujiang.project.zhgd.hjCompanyLibrary.controller.PcCompanyLibraryApi.insertHjCompanyLibrary");
        logger.info("公司信息："+hjCompanyLibrary);
        logger.info("公司id："+pid);
        return hjCompanyLibraryService.insertHjCompanyLibrary(hjCompanyLibrary, pid);
    }

    /**
     * 根据id查询公司库信息
     * @param
     * @return
     */
    @RequestMapping("/selectHjCompanyLibrary")
    public AjaxResult selectHjCompanyLibraryIds(Integer id)
    {
        logger.info("根据id查询公司库信息");
        return hjCompanyLibraryService.selectHjCompanyLibraryIds(id);
    }

    /**
     * 修改保存公司库信息
     * @param
     * @return
     */
    @RequestMapping("/updateHjCompanyLibrary")
    public AjaxResult updateHjCompanyLibrary(HjCompanyLibrary hjCompanyLibrary)
    {
        logger.info("修改保存公司库信息");
        System.out.println(hjCompanyLibrary);
        return hjCompanyLibraryService.updateHjCompanyLibrary(hjCompanyLibrary);
    }
    /**
     * 根据单位类型查询公司库信息列表
     * @param
     * @return
     */
    @RequestMapping("/selectHjCompanyLibraryList")
    public AjaxResult selectHjCompanyLibraryList(HjCompanyLibrary hjCompanyLibrary){
        logger.info("根据单位类型查询公司库信息列表");
        System.out.println(hjCompanyLibrary);
        return hjCompanyLibraryService.selectHjCompanyLibraryList(hjCompanyLibrary);
    }

    /**
     * 查询指定公司下公司和项目信息
     * @param
     * @return
     */
    @RequestMapping("/selectHjCompanyProjectList")
    public Map<String,Object> selectHjCompanyProjectList(Integer companyId)throws Exception{
//        Map<String,Object> map = new HashMap<>();
//        map.put("companyId",companyId);
        System.out.println(companyId);
        return AjaxResult.success(hjCompanyLibraryService.selectHjCompanyProjectList(companyId));
//        return ( Map<String,Object>)restTemplateUtil.Post(map,Constants.SERVICE_NAME+"/provider/pcCompanyLibrary/selectHjCompanyProjectList");

    }
    /**
     * 删除公司库信息
     * @param
     * @return
     */
    @RequestMapping("/deleteHjCompanyLibrary")
    public Map<String,Object> deleteHjCompanyLibraryIds(String ids)throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("ids",ids);
        return client.deleteHjCompanyLibraryIds(ids);
//        return (Map<String,Object>)restTemplateUtil.Post(map,Constants.SERVICE_NAME+"provider/pcCompanyLibrary/deleteHjCompanyLibrary");
    }
    /**
     * 查询子公司列表
     * @param
     * @return
     */
    @RequestMapping("/selectHjCompanyList")
    public  List<HjCompanyLibrary> selectHjCompanyList(@RequestParam(value = "companyId") Integer companyId){

        return client.selectHjCompanyList(companyId);
    }
}
