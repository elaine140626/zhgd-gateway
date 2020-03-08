package com.hujiang.project.zhgd.hjProjectImage.api;

import com.alibaba.fastjson.JSONArray;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.Constants;
import com.hujiang.project.zhgd.RestTemplateUtil;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjProjectImage.domain.HjProjectImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 项目效果图 信息操作处理
 *
 * @author hujiang
 * @date 2019-11-15
 */
@RestController
@RequestMapping(value = "/api/projectImage", method = RequestMethod.POST)
public class HjProjectImageApi {
//    @Autowired
//    private RestTemplateUtil restTemplateUtil;
    @Autowired
    private SystemClient client;

    /**
     * 查询轮播图
     */
    @PostMapping(value = "/selectProjectImageList")
    @ResponseBody
    public AjaxResult selectProjectImageList(HjProjectImage hjProjectImage) {
        AjaxResult jsonArray = client.selectProjectImageList(hjProjectImage);
        return jsonArray;
    }

    /**
     * 新增轮播图
     *
     * @param hjProjectImage
     * @param file
     * @return
     */
    @PostMapping(value = "/insertProjectImage")
    public  Map<String, Object> insertProjectImage(HjProjectImage hjProjectImage, MultipartFile[] file) {
        Map<String, Object> result = null;
        try {
            result = client.PostFile(hjProjectImage,  file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 修改轮播图
     *
     * @param hjProjectImage
     * @param file
     * @return
     */
    @PostMapping(value = "/updateProjectImage")
    public AjaxResult updateProjectImage(HjProjectImage hjProjectImage, @RequestParam(value = "file") MultipartFile file) {
        return client.updateProjectImage(file);
    }

    /**
     * 删除轮播图
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/removeProjectImage")
    public AjaxResult removeProjectImage(@RequestParam(value = "id") Integer id) {
        return client.removeProjectImage(id);
    }
}
