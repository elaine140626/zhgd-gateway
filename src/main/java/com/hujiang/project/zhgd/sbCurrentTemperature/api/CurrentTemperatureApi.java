package com.hujiang.project.zhgd.sbCurrentTemperature.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbCurrentTemperature.domain.SbCurrentTemperature;
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

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-06-24 10:54
 **/
@RestController
@RequestMapping(value = "/api/currentTemperatureApi",method = RequestMethod.POST)
public class CurrentTemperatureApi extends BaseController {

    @Autowired
    private SystemClient client;

    /**
     * 电箱数据分页
     * @param electricityBoxId
     * @param startTime
     * @param endTime
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping("/list")
    public JSONObject list(@RequestParam(value = "electricityBoxId")String electricityBoxId,
                           @RequestParam(value = "startTime",required = false)String startTime,
                           @RequestParam(value = "endTime",required = false)String endTime,
                           @RequestParam(value = "pageNum")Integer pageNum,
                           @RequestParam(value = "pageSize")Integer pageSize)
    {
        return client.currentTemperatureList(electricityBoxId, startTime, endTime,pageNum,pageSize);
    }

    /**
     * 电箱导出Excel
     * @param electricityBoxId
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping(value = "getExcel")
    public void getSbCurrentTemperatureExcel(@RequestParam(value = "electricityBoxId")String electricityBoxId,
                                                                   @RequestParam(value = "startTime",required = false)String startTime,
                                                                   @RequestParam(value = "endTime",required = false)String endTime,
                                                                   HttpServletResponse response)throws Exception{
        List<SbCurrentTemperature> excel = client.getSbCurrentTemperatureExcel(electricityBoxId, startTime, endTime);
        ExcelUtil<SbCurrentTemperature> util = new ExcelUtil<SbCurrentTemperature>(SbCurrentTemperature.class);
        //生成Excel
        AjaxResult a = util.exportExcel(excel, "电箱监测记录");

        //设置下载文件名
        String fileName = URLEncoder.encode((String)a.get("msg"), "UTF-8");
        File file = new File(Util.getPath(), (String) a.get("msg"));
        try (InputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = response.getOutputStream();) {

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);

            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(file.exists()){
            file.delete();
        }
    }

    /**
     * 智能电箱界面数据
     * @param electricityBoxId
     * @param projectId
     * @return
     */
    @PostMapping(value = "getEquipmentInformation")
    public JSONObject getEquipmentInformation(@RequestParam(value = "electricityBoxId")String electricityBoxId,
                                              @RequestParam(value = "projectId")Integer projectId){
        return client.getEquipmentInformation(electricityBoxId, projectId);
    }

    /**
     *  看板1.0，电箱数据
     * @param projectId
     * @return
     */
    @PostMapping(value = "/kanban")
    public JSONObject currentTemperatureApiKanban( @RequestParam(value = "projectId")Integer projectId){
        return client.currentTemperatureApiKanban(projectId);
    }
}
