package com.hujiang.project.zhgd.hjLogging.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjLogging.domain.HjLogging;
import com.hujiang.project.zhgd.hjProjectWorkers.domain.ProjectWorkerPC;
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
 * @create: 2019-06-27 10:59
 **/
@RestController
@RequestMapping(value = "/api/HjLogging")
public class HjLoggingApi {
    @Autowired
    private SystemClient client;

    /**
     * 根据项目id查询日志
     * @param projectId
     * @return
     */
    @PostMapping("getLog")
    public JSONObject getLog(@RequestParam(value = "projectId") Integer projectId,
                             @RequestParam(value = "pageNum")Integer pageNum,
                             @RequestParam(value = "pageSize")Integer pageSize,
                             @RequestParam(value = "startTime",required = false) String startTime,
                             @RequestParam(value = "endTime",required = false) String endTime,
                             @RequestParam(value = "userName",required = false) String userName){
        System.out.println(client.getLog(projectId, pageNum, pageSize, startTime, endTime, userName));
        return client.getLog(projectId, pageNum, pageSize, startTime, endTime, userName);
    }
    /**
     * 根据编号删除记录
     * @param ids
     * @return
     */
    @PostMapping( "/remove")
    public JSONObject removeLog(@RequestParam(value = "ids")String ids){
        return client.removeLog(ids);
    }
    /**
     * 导出Excel
     * @param projectId
     * @param startTime
     * @param endTime
     * @param userName
     * @return
     */
    @GetMapping("getLoggingExcel")
    public void getLoggingExcel(@RequestParam(value = "projectId") Integer projectId,
                                           @RequestParam(value = "startTime",required = false) String startTime,
                                           @RequestParam(value = "endTime",required = false) String endTime,
                                           @RequestParam(value = "userName",required = false) String userName, HttpServletResponse response)throws Exception{
        List<HjLogging> list = client.getLoggingExcel(projectId, startTime, endTime, userName);
        ExcelUtil<HjLogging> util = new ExcelUtil<HjLogging>(HjLogging.class);
        //生成Excel
        AjaxResult a = util.exportExcel(list, "异常记录");

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
