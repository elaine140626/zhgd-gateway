package com.hujiang.project.zhgd.lzfw.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.lzfw.domain.HjInformation;
import com.hujiang.project.zhgd.lzfw.domain.HjReport;
import com.hujiang.project.zhgd.lzfw.domain.HjReportPc;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping(value = "/api/baogao")
public class ReportApi extends BaseController {

    @Autowired
    private SystemClient client;

    @RequestMapping(value = "/select")
    @ResponseBody
    public JSONObject select(HjReport hjReport,PageDomain pageDomain){
        return client.select(hjReport,pageDomain.getPageNum(),pageDomain.getPageSize());
    }


    /**
     * 添加报告
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public JSONObject add(HjReport hjReport){
        return client.add(hjReport);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public JSONObject delete(@RequestParam(value = "id") Integer id){
        return client.deleteBaogao(id);
    }

    @GetMapping("/export")
    public void export( HjReport hjReport, HttpServletResponse response)throws Exception{
        System.out.println("导出Excel："+hjReport);
        List<HjReportPc> list = client.export(hjReport);
        ExcelUtil<HjReportPc> util = new ExcelUtil<HjReportPc>(HjReportPc.class);
        //生成Excel
        AjaxResult a = util.exportExcel(list, "工作汇报");
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
