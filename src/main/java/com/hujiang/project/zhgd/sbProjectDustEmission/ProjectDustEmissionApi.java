package com.hujiang.project.zhgd.sbProjectDustEmission;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbProjectDustEmission.domain.SbProjectDustEmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * @program: Consumer01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-06-18 16:07
 **/
@RestController
@RequestMapping(value = "/api/ProjectDustEmission",method = RequestMethod.POST)
public class ProjectDustEmissionApi {
    private Logger logger =Logger.getLogger(ProjectDustEmissionApi.class.getName());
    @Autowired
    private SystemClient client;

    /**
     * 根据项目id查询项目扬尘设备列表
     * @param projectId
     * @return
     */
    @PostMapping("getProjectDustEmission")
    public JSONObject getProjectDustEmission(@RequestParam(value = "projectId")Long projectId){
        logger.info("com.hujiang.project.zhgd.sbProjectDustEmission.ProjectDustEmissionApi.getProjectDustEmission:projectId="+projectId);
        return client.getProjectDustEmission(projectId);
    }

    /**
     * 查询项目对应的扬尘设备SN列表
     */
    @PostMapping("/projectDustEmissionList")
    public AjaxResult projectDustEmissionList( SbProjectDustEmission sbProjectDustEmission,
                                               @RequestParam(value = "pageSize")Integer pageSize,
                                               @RequestParam(value = "pageNum")Integer pageNum)
    {
        logger.info("com.hujiang.project.zhgd.sbProjectDustEmission.ProjectDustEmissionApi.projectDustEmissionList:sbProjectDustEmission="+sbProjectDustEmission);

        return client.projectDustEmissionList(sbProjectDustEmission,pageSize,pageNum);
    }
    /**
     * 新增保存项目对应的扬尘设备SN
     */
    @PostMapping("/projectDustEmissionAddSave")
    public AjaxResult projectDustEmissionAddSave(SbProjectDustEmission sbProjectDustEmission)
    {
        logger.info("com.hujiang.project.zhgd.sbProjectDustEmission.ProjectDustEmissionApi.projectDustEmissionAddSave:sbProjectDustEmission="+sbProjectDustEmission);

        return client.projectDustEmissionAddSave(sbProjectDustEmission);
    }

    /**
     * 根据id查询
     */
    @PostMapping("/projectDustEmissionById")
    public AjaxResult projectDustEmissionById(@RequestParam(value = "id") Long id)
    {
        logger.info("com.hujiang.project.zhgd.sbProjectDustEmission.ProjectDustEmissionApi.projectDustEmissionById:id="+id);

        return client.projectDustEmissionById(id);
    }

    /**
     * 修改保存项目对应的扬尘设备SN
     */
    @PostMapping("/projectDustEmissionEditSave")
    public AjaxResult projectDustEmissionEditSave( SbProjectDustEmission sbProjectDustEmission)
    {

        logger.info("com.hujiang.project.zhgd.sbProjectDustEmission.ProjectDustEmissionApi.projectDustEmissionEditSave:sbProjectDustEmission="+sbProjectDustEmission);
        return client.projectDustEmissionEditSave(sbProjectDustEmission);
    }

    /**
     * 删除项目对应的扬尘设备SN
     */
    @PostMapping( "/remove")
    public AjaxResult projectDustEmissionRemove(@RequestParam(value = "ids") String ids)
    {
        logger.info("com.hujiang.project.zhgd.sbProjectDustEmission.ProjectDustEmissionApi.projectDustEmissionRemove :ids="+ids);
        return client.projectDustEmissionRemove(ids);
    }


}
