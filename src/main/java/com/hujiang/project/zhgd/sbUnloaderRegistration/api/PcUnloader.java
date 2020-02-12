package com.hujiang.project.zhgd.sbUnloaderRegistration.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbUnloaderRegistration.domain.ExportUnloaderAlarmtime;
import com.hujiang.project.zhgd.sbUnloaderRegistration.domain.ExportUnloaderRealtime;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping(value = "/api/unloaderPcApi",method = RequestMethod.POST)
public class PcUnloader extends BaseController {
    @Autowired
    private SystemClient systemClient;
    @PostMapping(value = "/getUnloaderList")
    public JSONObject getUnloaderList(@RequestParam("projectId")Integer projectId){

        return systemClient.getUnloaderPcList(projectId);
    }
    @PostMapping(value = "/getSbUnloaderRealtimeList")
    public JSONObject getSbUnloaderRealtimeList(@RequestParam(value = "projectId")Integer projectId,
                                                @RequestParam(value = "deviceId") String deviceId){

        return systemClient.getSbUnloaderRealtimePcList(projectId, deviceId);
    }
    @PostMapping(value = "/getRealtimeHistory")
    public JSONObject getRealtimeHistory(@RequestParam("projectId")Integer projectId,
                                         @RequestParam(value = "deviceId") String deviceId,
                                         @RequestParam(value = "time",required = false)String time,
                                         @RequestParam(value = "endTime", required = false) String endTime,
                                         @RequestParam(value = "alarmType")Integer alarmType, PageDomain pageDomain
    ){

        return systemClient.getRealtimeHistory(projectId,deviceId,time,endTime,alarmType,pageDomain.getPageSize(),pageDomain.getPageNum());
    }



    @PostMapping(value = "/getSbUnloaderHistory")
    public JSONObject getSbUnloaderHistory(@RequestParam(value = "projectId")Integer projectId,
                                           @RequestParam(value = "deviceId") String deviceId,
                                           @RequestParam(value = "time",required = false)String time,
                                           @RequestParam(value = "endTime",required = false)String endTime,
                                           PageDomain pageDomain){


        return systemClient.getSbUnloaderPcHistory(projectId,deviceId,time,endTime,pageDomain.getPageSize(),pageDomain.getPageNum());
    }
    @GetMapping("/exportUnloader")
    public void exportUnloader(@RequestParam(value = "ids",required = false)String ids,
                               @RequestParam(value = "judge")int judge,
                               @RequestParam(value = "startTime",required = false)String startTime,
                               @RequestParam(value = "endTime",required = false)String endTime,
                               @RequestParam(value = "deviceId",required = false)String deviceId,
                               HttpServletResponse response)throws Exception
    {


        String title = null;
        if(judge==5){
            ExcelUtil<ExportUnloaderRealtime> util = new ExcelUtil<ExportUnloaderRealtime>(ExportUnloaderRealtime.class);
            List<ExportUnloaderRealtime> exportUnloaderRealtimeList = systemClient.exportUnloaderRealtime(ids,startTime,endTime,deviceId);

            title = "卸料实时历史记录";
            //生成Excel
            AjaxResult a = util.exportExcel(exportUnloaderRealtimeList, title);

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
        }else {
            ExcelUtil<ExportUnloaderAlarmtime> util = new ExcelUtil<ExportUnloaderAlarmtime>(ExportUnloaderAlarmtime.class);
            List<ExportUnloaderAlarmtime> exportUnloaderAlarmtimeList = systemClient.exportUnloaderAlarmtime(ids,startTime,endTime,deviceId,judge);
            if(judge==1){
                title = "卸料载重报警历史记录";
            }else if (judge==2){
                title = "卸料倾角X报警历史记录";
            }else if (judge==3){
                title = "卸料倾角Y报警历史记录";
            }else if (judge==4){
                title = "卸料电池电量报警历史记录";
            }
            //生成Excel
            AjaxResult a = util.exportExcel(exportUnloaderAlarmtimeList, title);
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



    }
}
