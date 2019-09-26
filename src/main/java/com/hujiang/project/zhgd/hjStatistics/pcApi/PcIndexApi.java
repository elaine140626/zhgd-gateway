package com.hujiang.project.zhgd.hjStatistics.pcApi;


import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * pc端首页
 * @author hujiang
 * @date 2019-05-21
 */
@Controller
@RequestMapping(value = "/api/pcLzIndex" , method = RequestMethod.POST)
public class PcIndexApi extends BaseController {

    @Autowired
    private SystemClient systemClient;
    /**
     * 根据id查询项目信息
     * @param
     * @return
     */

    @RequestMapping("/selectIndex")
    @ResponseBody
    public AjaxResult selectIndex(Integer pid)
    {
       return systemClient.selectIndex(pid);
    }



}
