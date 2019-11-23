package com.hujiang.project.zhgd.SbProjectVideo.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.SbProjectVideo.domain.SbProjectVideo;
import com.hujiang.project.zhgd.client.SystemClient;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-06-23 14:10
 **/
@RestController
@RequestMapping(value = "/api/ProjectVideo",method = RequestMethod.POST)
public class ProjectVideo {

    @Autowired
    private SystemClient client;


    /**
     * 根据项目视频区id获取视频信息
     * @param areaId
     * @return
     */
    @PostMapping("getProjectVideo")
    public JSONObject getProjectVideo(@RequestParam(value = "areaId") Integer areaId){
        return client.getProjectVideo(areaId);
    }

    /**
     * 删除项目视频
     */
    @PostMapping( "/deleteSbProjectVideoByIds")
    public AjaxResult deleteSbProjectVideoByIds(@RequestParam(value = "ids") String ids)
    {
        return client.deleteSbProjectVideoByIds(ids);
    }
    /**
     * 查询项目所有视频列表
     */
    @PostMapping("/selectSbProjectVideoByProjectId")
    public AjaxResult selectSbProjectVideoByProjectId(@RequestParam(value = "projectId") Integer projectId,
                                                      @RequestParam(value = "pageNum")Integer pageNum,
                                                      @RequestParam(value = "pageSize")Integer pageSize)
    {
        return client.selectSbProjectVideoByProjectId(projectId, pageNum, pageSize);
    }
    /**
     * 查询工区视频列表
     */
    @PostMapping("/projectVideoList")
    public AjaxResult projectVideoList( SbProjectVideo sbProjectVideo,
                                       @RequestParam(value = "pageNum")Integer pageNum,
                                       @RequestParam(value = "pageSize")Integer pageSize)
    {
        return client.projectVideoList(sbProjectVideo,pageNum,pageSize);
    }

    /**
     * 新增保存项目视频
     */
    @PostMapping("/projectVideoAddSave")
    public AjaxResult  projectVideoAddSave( SbProjectVideo sbProjectVideo)
    {
        return client.projectVideoAddSave(sbProjectVideo);
    }

    /**
     * 根据id查询视频信息
     */
    @PostMapping("/selectProjectVideoById")
    public AjaxResult selectProjectVideoById(@RequestParam(value = "id") Integer id)
    {
       return client.selectProjectVideoById(id);
    }

    /**
     * 修改保存项目视频
     */
    @PostMapping("/projectVideoEditSave")
    public AjaxResult projectVideoEditSave( SbProjectVideo sbProjectVideo)
    {
        return client.projectVideoEditSave(sbProjectVideo);
    }
    @PostMapping("/ysCloudControldirection")
public void ysCloudControldirection(Integer pid,String deviceSerial ,Integer direction){
         client.ysCloudControldirection(pid,deviceSerial,direction);
}


}
