package com.hujiang.project.zhgd.deye;

import com.hujiang.common.utils.StringUtils;
import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.framework.web.page.TableDataInfo;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.deye.domain.SbCraneAddrecord;
import com.hujiang.project.zhgd.deye.domain.SbCraneBinding;
import com.hujiang.project.zhgd.hjAttendanceRecord.domain.HjAttendanceRecord;
import com.hujiang.project.zhgd.hjAttendanceRecord.service.IHjAttendanceRecordService;
import com.hujiang.project.zhgd.hjProjectWorkers.domain.HjProjectWorkers;
import com.hujiang.project.zhgd.hjProjectWorkers.domain.ProjectWorkerPC;
import com.hujiang.project.zhgd.hjProjectWorkers.service.IHjProjectWorkersService;
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
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/api/craneApi",method = RequestMethod.POST)
public class PcApi  extends BaseController {
    @Autowired
    private SystemClient client;

    @RequestMapping("/selectIndex")
    @ResponseBody
    public Map<String, Object> selectIndex(Integer pid ,String time,String hxzid){
        return client.selectIndex(pid, time, hxzid);
    }

    /**
     * 切换设备
     * @param scb
     * @return
     */
    @RequestMapping("/switchDevice")
    @ResponseBody
    public AjaxResult switchDevice(SbCraneBinding scb){
        return client.switchDevice(scb);
    }

    /**
     * 历史记录
     * @param time
     * @param hxzid
     * @param status 0表示不合格
     * @return
     */
    @RequestMapping("/historyRecord")
    @ResponseBody
    public AjaxResult historyRecord(@RequestParam(value = "time",required = false)String time,
                                    @RequestParam(value = "hxzid")String hxzid,
                                    @RequestParam(value = "pageNum")String pageNum,
                                    @RequestParam(value = "pageSize")String pageSize,
                                    @RequestParam(value = "status",required = false)String status){
        return client.historyRecord(time, hxzid, pageNum, pageSize, status);
    }

    @GetMapping("/historyRecordExcel")
    public  void historyRecordExcel(@RequestParam(value = "time")String time,
                                                      @RequestParam(value = "hxzid")String hxzid,
                                    HttpServletResponse response)throws Exception{
        List<SbCraneAddrecord> list = client.historyRecordExcel(time, hxzid);
        ExcelUtil<SbCraneAddrecord> util = new ExcelUtil<SbCraneAddrecord>(SbCraneAddrecord.class);
        //生成Excel
        AjaxResult a = util.exportExcel(list, "塔吊历史记录");

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
