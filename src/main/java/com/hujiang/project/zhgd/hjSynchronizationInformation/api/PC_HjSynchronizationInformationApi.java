package com.hujiang.project.zhgd.hjSynchronizationInformation.api;

import com.hujiang.framework.aspectj.lang.annotation.Log;
import com.hujiang.framework.aspectj.lang.enums.BusinessType;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.framework.web.page.TableDataInfo;
import com.hujiang.project.zhgd.Constants;
import com.hujiang.project.zhgd.RestTemplateUtil;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjSynchronizationInformation.domain.HjSynchronizationInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-05-27 15:58
 **/
@RestController
@RequestMapping(value = "/api/synchronizationInformationApi",method = RequestMethod.POST)
public class PC_HjSynchronizationInformationApi extends BaseController {
    @Autowired
    private SystemClient SystemClient;
    @Autowired
    private RestTemplateUtil restTemplateUtil;

    /**
     * 查询项目两制同步列表
     */
    @PostMapping("/list")
    public AjaxResult list(HjSynchronizationInformation hjSynchronizationInformation, PageDomain pageDomain)throws Exception
    {
        return SystemClient.listIN(hjSynchronizationInformation,pageDomain.getPageSize(),pageDomain.getPageNum());
//        return (AjaxResult)restTemplateUtil.PostPage(hjSynchronizationInformation, Constants.SERVICE_NAME+"provider/synchronizationInformationApi/list",pageDomain);
    }

    /**
     * 新增保存项目两制同步
     */
    @Log(title = "项目两制同步", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public Map<String,Object> addSave(HjSynchronizationInformation hjSynchronizationInformation)
    {
        return SystemClient.addSave(hjSynchronizationInformation);
    }

    /**
     * 修改保存项目两制同步
     */
    @Log(title = "项目两制同步", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public Map<String,Object> editSave(HjSynchronizationInformation hjSynchronizationInformation)
    {
        return SystemClient.editSave(hjSynchronizationInformation);
    }

    /**
     * 删除项目两制同步
     */
    @Log(title = "项目两制同步", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    public Map<String,Object> remove(String ids)
    {
        return SystemClient.remove(ids);
    }
}
