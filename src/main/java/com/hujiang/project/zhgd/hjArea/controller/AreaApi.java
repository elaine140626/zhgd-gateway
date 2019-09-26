package com.hujiang.project.zhgd.hjArea.controller;

import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.hjArea.domain.HjArea;
import com.hujiang.project.zhgd.hjArea.service.IHjAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: Provider01
 * @description: 城市接口
 * @author: Mr.LiuYong
 * @create: 2019-05-14 17:38
 **/
@RestController
@RequestMapping(value = "/api/area",method = RequestMethod.POST)
public class AreaApi extends BaseController {
    @Autowired
    private IHjAreaService hjAreaService;


    /**
     * 功能描述 :根据id获取下级市区
     * @author Mr.LiuYong
     * @date  2019/5/14 17:46
     * @param parentId
     * @return java.lang.Object
     */
    @RequestMapping("getArea")
    public AjaxResult getArea(Long parentId){
        if(parentId==null){
            return AjaxResult.error();
        }
        return hjAreaService.selectHjAreaList(parentId);
    }

}
