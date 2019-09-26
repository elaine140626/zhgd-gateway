package com.hujiang.project.zhgd.deye;

import com.hujiang.common.utils.StringUtils;
import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.deye.domain.SbCraneAddrecord;
import com.hujiang.project.zhgd.deye.domain.SbElevatorAddrecord;
import com.hujiang.project.zhgd.deye.domain.SbElevatorBinding;
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
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/api/elevatorApi",method = RequestMethod.POST)
public class PcElevatorApi extends BaseController {
    @Autowired
    private SystemClient client;

    /**
     * 升降机界面接口
     * @param pid
     * @param hxzid
     * @return
     */
    @RequestMapping("/selectIndex")
    @ResponseBody
    public AjaxResult selectIndex(Integer pid , String hxzid) {
        return client.selectIndex(pid, hxzid);
    }

    /**
     * 升降机历史记录
     * @param time
     * @param hxzid
     * @param status 0表示不合格
     * @return
     */
    @RequestMapping("/provider/elevatorApi/historyRecord")
    public AjaxResult elevatorHistoryRecord(@RequestParam(value = "time")String time,
                                            @RequestParam(value = "hxzid")String hxzid,
                                            @RequestParam(value = "status")String status,
                                            @RequestParam(value = "pageNum")String pageNum,
                                            @RequestParam(value = "pageSize")String pageSize){
       return client.elevatorHistoryRecord(time, hxzid, status, pageNum, pageSize);
    }

    /**
     * 导出Excel
     * @param time
     * @param hxzid
     * @param response
     * @throws Exception
     */
    @GetMapping("/historyRecordExcel")
    public  void elevatorHistoryRecordExcel(@RequestParam(value = "time")String time,
                                                                 @RequestParam(value = "hxzid")String hxzid,
                                            HttpServletResponse response)throws Exception{
        List<SbElevatorAddrecord> list = client.elevatorHistoryRecordExcel(time, hxzid);
        ExcelUtil<SbElevatorAddrecord> util = new ExcelUtil<SbElevatorAddrecord>(SbElevatorAddrecord.class);
        //生成Excel
        AjaxResult a = util.exportExcel(list, "升降机历史记录");

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
     * 切换设备
     * @param pid
     * @return
     */
    @RequestMapping("/switchDevice")
    @ResponseBody
    public AjaxResult switchDevice(Integer pid){
        return client.elevatorSwitchDevice(pid);
    }

}
