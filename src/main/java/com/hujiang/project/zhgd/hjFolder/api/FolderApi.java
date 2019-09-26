package com.hujiang.project.zhgd.hjFolder.api;

import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjFolder.domain.HjFolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-06-28 11:34
 **/
@RestController
@RequestMapping(value = "/api/folder/")
public class FolderApi extends BaseController {

    @Autowired
    private SystemClient client;

    /**
     *创建文件夹
     * @param folder
     * @return
     */
    @PostMapping("createFolder")
    public Map<String,Object> createFolder( HjFolder folder){
        return client.createFolder(folder);
    }

    /**
     * 获取文件夹列表
     * @param folder
     * @return
     */
    @PostMapping("folderList")
    public Map<String,Object> folderList(HjFolder folder){
        return client.folderList(folder);
    }

    /**
     * 删除文件夹及文件
     * @param ids
     * @return
     */
    @PostMapping("removeFolder")
    public Map<String,Object> removeFolder(@RequestParam(value = "ids") String ids ){
       return client.removeFolder(ids);
    }
}
