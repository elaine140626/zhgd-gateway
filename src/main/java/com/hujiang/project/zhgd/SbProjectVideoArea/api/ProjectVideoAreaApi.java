package com.hujiang.project.zhgd.SbProjectVideoArea.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.SbProjectVideoArea.domain.SbJTArea;
import com.hujiang.project.zhgd.SbProjectVideoArea.domain.SbProjectVideoArea;
import com.hujiang.project.zhgd.SbProjectVideoArea.domain.Video;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-06-23 14:03
 **/
@RestController
@RequestMapping(value = "/api/ProjectVideoAreaApi",method = RequestMethod.POST)
public class ProjectVideoAreaApi {
    @Autowired
    private SystemClient client;

    /**
     * 根据项目id获取项目视频区
     * @param projectId
     * @return
     */
    @PostMapping("getProjectVideoArea")
    public JSONObject getProjectVideoArea(@RequestParam(value = "projectId") Integer projectId){
        return client.getProjectVideoArea(projectId);
    }

    /**
     * 查询项目视频区列表
     */
    @PostMapping("/list")
    public AjaxResult projectVideoAreaList( SbProjectVideoArea sbProjectVideoArea,
                                           @RequestParam(value = "pageNum")Integer pageNum,
                                           @RequestParam(value = "pageSize")Integer pageSize)
    {
        return client.projectVideoAreaList(sbProjectVideoArea, pageNum, pageSize);
    }

    /**
     * 新增保存项目视频区
     */
    @PostMapping("/add")
    public AjaxResult projectVideoAreaAddSave(SbProjectVideoArea sbProjectVideoArea)
    {
        return client.projectVideoAreaAddSave(sbProjectVideoArea);
    }
    /**
     * 修改前查询
     */
    @PostMapping("/edit")
    public AjaxResult projectVideoAreaEdit(Integer id)
    {
        return client.projectVideoAreaEdit(id);
    }

    /**
     * 修改保存项目视频区
     */
    @PostMapping("/editSave")
    public AjaxResult projectVideoAreaEditSave(SbProjectVideoArea sbProjectVideoArea)
    {
        System.out.println(sbProjectVideoArea);
        return client.projectVideoAreaEditSave(sbProjectVideoArea);
    }

    /**
     * 删除项目视频区
     */
    @PostMapping( "/remove")
    public AjaxResult projectVideoAreaRemove(String ids)
    {

        return client.projectVideoAreaRemove(ids);
    }

    /**
     * 集团监控列表
     * @param cid
     * @return
     */
    @PostMapping("/getVideoListJT")
    public List<SbJTArea> getVideoListJT(Integer cid){
        return client.getVideoListJT(cid);
    }

    @PostMapping("/getVideoListImgUrl")
    public List<Video> getVideoListImgUrl(Integer cid){
        return client.getVideoListImgUrl(cid);
    }
}
