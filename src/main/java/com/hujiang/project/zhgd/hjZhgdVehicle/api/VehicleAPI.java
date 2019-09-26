package com.hujiang.project.zhgd.hjZhgdVehicle.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjZhgdVehicle.domain.HjZhgdPkcount;
import com.hujiang.project.zhgd.hjZhgdVehicle.domain.Vehicle;
import com.hujiang.project.zhgd.hjZhgdVehicle.domain.VehiclePc;
import com.hujiang.project.zhgd.lzfw.domain.HjReport;
import com.hujiang.project.zhgd.lzfw.domain.HjReportPc;
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

@RestController
@RequestMapping("/api/parkings")
public class VehicleAPI {

    @Autowired
    private SystemClient client;
    /**
     * 查询所有数据
     * @return
     * */
    @PostMapping( value = "/selectAll")
    public JSONObject selectAll(Vehicle vehicle, @RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum")Integer pageNum){
        return client.selectAll(vehicle,pageSize,pageNum);
    }

    /**
     *查询在场车辆
     * @return
     * */
    @PostMapping(value = "/parking/selectscene")
    public JSONObject selectscene( Vehicle vehicle, @RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum")Integer pageNum){
       return client.selectscene(vehicle,pageSize,pageNum);
    }

    /**
     * 查询剩余车位数
     *
     * @return*/
    @PostMapping(value = "/selectpkcount")
    @ResponseBody
    public JSONObject parkingspace(HjZhgdPkcount hjZhgdPkcount){
         return client.selectresidue(hjZhgdPkcount);
    }

    /**
     * 添加设备
     * @return
     * */
    @PostMapping(value = "/vehicleSnAdd")
    public JSONObject vehicleSnAdd(HjZhgdPkcount hjZhgdPkcount){
        return client.vehicleSnAdd(hjZhgdPkcount);
    }

    /**
     * 删除设备
     * @return
     * */
    @PostMapping(value = "/vehicleSnDel")
    public JSONObject vehicleSnDel(Integer id){
        return client.vehicleSnDel(id);
    }

    /**
     * 修改设备
     * @return
     * */
    @PostMapping(value = "/vehicleSnUpd")
    public JSONObject vehicleSnUpd(HjZhgdPkcount hjZhgdPkcount){
        return client.vehicleSnUpd(hjZhgdPkcount);
    }

    /**
     * 设置车位数
     * */
    @PostMapping(value = "/carUpd")
    public JSONObject carUpd(String deptId,Integer pkcount){
        return client.carUpd(deptId,pkcount);
    }

    /**导出车辆Excel*/
    @GetMapping("/export")
    public void export(Vehicle vehicle, HttpServletResponse response)throws Exception{
        System.out.println("导出Excel："+vehicle);
        List<VehiclePc> list = client.export(vehicle);
        ExcelUtil<VehiclePc> util = new ExcelUtil<VehiclePc>(VehiclePc.class);
        //生成Excel
        AjaxResult a = util.exportExcel(list, "车辆进出数据");
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
     * 智慧工地看板1.0
     *
     * @return*/
    @PostMapping(value = "/todaycount")
    public JSONObject parkingTodaycount( @RequestParam("projectId") Integer projectId){
        return client.parkingTodaycount(projectId);
    }

}
