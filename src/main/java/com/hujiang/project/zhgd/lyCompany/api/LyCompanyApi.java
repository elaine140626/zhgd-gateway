package com.hujiang.project.zhgd.lyCompany.api;

import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.lyCompany.domain.LyCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 楼宇公司表
 */
@RestController
@RequestMapping(value = "/api/lyCompany",method = RequestMethod.POST)
public class LyCompanyApi extends BaseController {
    @Autowired
    private SystemClient client;
    /**
     * 分页查询
     */
    @PostMapping("/selectPageList")
    public AjaxResult selectPageList(LyCompany lyCompany, PageDomain pageDomain){

        return client.lyCompanySelectPageList(lyCompany,pageDomain.getPageSize(),pageDomain.getPageNum());
    }
    /**
     * 列表查询
     */
    @PostMapping("/selectList")
    public AjaxResult selectList(LyCompany lyCompany){

        return client.lyCompanySelectList(lyCompany);
    }
    /**
     * 新增
     */
    @PostMapping("/insert")
    public AjaxResult insert(LyCompany lyCompany){
        return client.lyCompanyInsert(lyCompany);
    }
    /**
     *
     */
    @PostMapping("/selectId")
    public AjaxResult selectId(Integer id){

        return client.lyCompanySelectId(id);

    }
    /**
     * 修改
     */
    @PostMapping("/update")
    public AjaxResult update(LyCompany lyCompany){
        return client.lyCompanyUpdate(lyCompany);
    }
    /**
     * 删除
     */
    @PostMapping("/delete")
    public AjaxResult delete(String ids){

        return client.lyCompanyDelete(ids);
    }

}
