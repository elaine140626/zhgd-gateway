package com.hujiang.project.zhgd.sbDustEmission.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbDustEmission.domain.SbDustEmission;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.logging.Logger;

/**
 * @program: Consumer01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-06-18 17:49
 **/
@RestController
@RequestMapping(value = "/api/appDustEmission",method = RequestMethod.POST)
public class AppDustEmissionApi extends BaseController {
    private Logger logger = Logger.getLogger(AppDustEmissionApi.class.getName());
    @Autowired
    private SystemClient client;


    /**
     * 查询扬尘记录
     * @param sn sn编号
     * @param dateTime 时间
     * @return
     */
    @PostMapping("/getDustEmission")
    public JSONObject getDustEmission(@RequestParam(value = "sn")String sn,
                                      @RequestParam(value = "pageNum")Integer pageNum,
                                      @RequestParam(value = "pageSize")Integer pageSize,
                                      @RequestParam(value = "dateTime",required = false)String dateTime){
        return client.getDustEmission(sn, pageNum, pageSize, dateTime);
    }
    /**
     * 获取TSP界面数据
     * @param sn
     * @return
     */
    @PostMapping("getPM25AndPN10")
    public JSONObject getPM25AndPN10(@RequestParam(value = "sn") String sn,@RequestParam(value = "projectId")Integer projectId){
        return client.getAppPM25AndPN10(sn, projectId);
    }
}
