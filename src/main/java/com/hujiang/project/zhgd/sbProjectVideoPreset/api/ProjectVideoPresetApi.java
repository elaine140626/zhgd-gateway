package com.hujiang.project.zhgd.sbProjectVideoPreset.api;

import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbProjectVideoPreset.domain.SbProjectVideoPreset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-06-23 14:03
 **/
@RestController
@RequestMapping(value = "/api/ProjectVideoPresetApi",method = RequestMethod.POST)
public class ProjectVideoPresetApi extends BaseController {
    @Autowired
    private SystemClient client;

/**
 * 新增预置点
 */
    @PostMapping("/insertPreset")
    public AjaxResult insertPreset(Integer pid, String deviceSerial) {

        return client.insertPreset(pid,deviceSerial);
    }
    /**
     * 清除预置点
     */
    @PostMapping("/clearPreset")
    public AjaxResult clearPreset(Integer pid, String deviceSerial, Integer  index) {

        return  client.clearPreset(pid,deviceSerial,index);
    }
    /**
     * 查询预置点
     */
    @PostMapping("/selectPreset")
    public AjaxResult selectPreset(SbProjectVideoPreset sp)  {

        return client.selectPreset(sp);
    }
    /**
     * 调用预置点
     */
    @PostMapping("/callPreset")
    public void callPreset(Integer pid, String deviceSerial, Integer  index)  {

         client.callPreset(pid,deviceSerial,index);
    }
}
