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
@RequestMapping(value = "/api/DustEmission",method = RequestMethod.POST)
public class DustEmissionApi extends BaseController {
    private Logger logger = Logger.getLogger(DustEmissionApi.class.getName());
    @Autowired
    private SystemClient client;

    /**
     * 查询扬尘记录
     * @param sn sn编号
     * @param tag 0 不合格   1合格
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    @PostMapping("getDustEmission")
    public JSONObject getDustEmission(@RequestParam(value = "sn")String sn,
                                      @RequestParam(value = "tag",required = false)Integer tag,
                                      @RequestParam(value = "startTime",required = false)String startTime,
                                      @RequestParam(value = "endTime",required = false)String endTime,
                                      @RequestParam(value = "pageNum")Integer pageNum,
                                      @RequestParam(value = "pageSize")Integer pageSize){
        return client.getDustEmission(sn, tag, startTime, endTime,pageNum,pageSize);
    }
    /**
     * 获取绿色施工TSP数据
     * @param sn
     * @return
     */
    @PostMapping("getPM25AndPN10")
    public JSONObject getPM25AndPN10(String sn,Integer projectId){
        return client.getPM25AndPN10(sn,projectId);
    }

    /**
     * 导出扬尘记录
     * @param sn
     * @param startTime
     * @param endTime
     * @param response
     * @throws Exception
     */
    @GetMapping("getExcel")
    public void getExcel(@RequestParam(value = "sn")String sn,
                         @RequestParam(value = "startTime",required = false)String startTime,
                         @RequestParam(value = "endTime",required = false)String endTime, HttpServletResponse response)throws Exception{
        List<SbDustEmission> excel = client.getExcel(sn, startTime, endTime);
        ExcelUtil<SbDustEmission> util = new ExcelUtil<SbDustEmission>(SbDustEmission.class);
        //生成Excel
        AjaxResult a = util.exportExcel(excel, "扬尘监测记录");

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
    @RequestMapping("/Tsp")
    @ResponseBody
    public JSONObject tsp(@RequestParam(value = "projectId") long projectId)
    {
        return client.tsp(projectId);
    }

    @PostMapping("/getTSP")
    @ResponseBody
    public JSONObject getDustUserList(@RequestParam("projectId")Integer projectId,
                                       @RequestParam(value = "filed",required = false)String filed){
        return  client.getDustUserList(projectId, filed);
    }
}
