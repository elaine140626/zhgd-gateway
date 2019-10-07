package com.hujiang.project.zhgd.sbProjectElectricityBox.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbProjectElectricityBox.domain.SbProjectElectricityBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-06-24 11:52
 **/
@RestController
@RequestMapping(value = "/api/ProjectElectricityBox",method = RequestMethod.POST)
public class ProjectElectricityBoxApi {
    @Autowired
    private SystemClient client;

    /**
     * 根据项目id获取电箱设备编号
     * @param projectId
     * @return
     */
    @PostMapping("getProjectElectricityBox")
    public JSONObject getProjectElectricityBox(@RequestParam(value = "projectId") Integer projectId){
        return client.getProjectElectricityBox(projectId);
    }
    /**
     * 查询项目电箱列表
     */
    @PostMapping("/list")
    public AjaxResult list( SbProjectElectricityBox sbProjectElectricityBox,
                           @RequestParam(value = "pageNum")Integer pageNum,
                           @RequestParam(value = "pageSize")Integer pageSize)
    {
        return client.list(sbProjectElectricityBox, pageNum, pageSize);
    }

    /**
     * 添加电箱
     * @param sbProjectElectricityBox
     * @return
     */
    @PostMapping("addSave")
    public AjaxResult addSave( SbProjectElectricityBox sbProjectElectricityBox)
    {
       return client.addSave(sbProjectElectricityBox);
    }
    /**
     * 添加电箱
     * @return
     */
    @PostMapping("/addElectricityBox")
    public AjaxResult addElectricityBox(@RequestParam(value = "projectId")Integer projectId,
                                        @RequestParam(value = "electricityBoxId")String electricityBoxId,
                                        @RequestParam(value = "electricityBoxName")String electricityBoxName)
    {
        return client.addElectricityBox(projectId,electricityBoxId,electricityBoxName);
    }
    /**
     * 修改前查询
     */
    @PostMapping("/edit")
    public AjaxResult edit(@RequestParam("id") Integer id)
    {
       return client.edit(id);
    }

    /**
     * 修改保存项目电箱
     */
    @PostMapping("/editSave")
    public AjaxResult editSave(SbProjectElectricityBox sbProjectElectricityBox)
    {
        return client.editSave(sbProjectElectricityBox);
    }

    /**
     * 删除项目电箱
     */
    @PostMapping( "/remove")
    public AjaxResult remove(Integer id,String devCcrq)
    {
        return client.projectElectricityBoxRemove(id,devCcrq);
    }


}
