package com.hujiang.project.zhgd.hjAttendanceRecord.controller;


import com.alibaba.fastjson.JSONObject;
import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.Constants;
import com.hujiang.project.zhgd.RestTemplateUtil;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjAttendanceRecord.domain.Param;
import com.hujiang.project.zhgd.hjAttendanceRecord.service.IHjAttendanceRecordService;
import com.hujiang.project.zhgd.hjProjectWorkers.domain.ProjectWorkerPC;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * pc两制考勤记录
 *
 * @author hujiang
 * @date 2019-05-19
 */
@Controller
@RequestMapping(value = "/api/attendanceRecordPcApi",method = RequestMethod.POST)
public class AttendanceRecordPcApi extends BaseController {
    private Logger logger = Logger.getLogger(AttendanceRecordPcApi.class.getName());

    @Autowired
    private RestTemplateUtil restTemplateUtil;
    @Autowired
    private SystemClient systemClient;



    /**
     * pc考勤列表
     * @param
     * @return
     */
    @RequestMapping("/selectAttendanceRecordList")
    @ResponseBody
    public Map<String,Object> selectAttendanceRecordListTwo(Param param, Integer pageNum, Integer pageSize)throws Exception
    {
        return systemClient.selectAttendanceRecordListTwo(param,pageNum,pageSize);
    }


    /**
     * 导出考勤数据源
     * @param param
     * @return
     */
    @GetMapping("/export")
    public void export( Param param , HttpServletResponse response)throws Exception{
        System.out.println("导出Excel："+param);
        List<Param> list = systemClient.export(param);
        ExcelUtil<Param> util = new ExcelUtil<Param>(Param.class);
        //生成Excel
        AjaxResult a = util.exportExcel(list, "考勤记录");

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
