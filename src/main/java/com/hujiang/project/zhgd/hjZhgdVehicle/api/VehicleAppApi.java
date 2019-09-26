package com.hujiang.project.zhgd.hjZhgdVehicle.api;


import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjZhgdVehicle.domain.HjZhgdPkcount;
import com.hujiang.project.zhgd.hjZhgdVehicle.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 移动端
 * */
@RestController
@RequestMapping(value = "/api/vehicle/app",method = RequestMethod.POST)
public class VehicleAppApi extends BaseController {

    @Autowired
    private SystemClient client;
    /**
     * 查询所有数据
     * @return
     * */
    @PostMapping( value = "/selectAll")
    public JSONObject selectVehicleAll(Vehicle vehicle ,
                                       @RequestParam(value = "pageNum")String pageNum,
                                       @RequestParam(value = "pageSize")String pageSize){
        return client.selectVehicleAll(vehicle, pageNum, pageSize);
    }


    /**
     * 查询某车场总数
     * */
    @PostMapping(value = "/carcount")
    public JSONObject countcar(Vehicle vehicle){
        return client.countcar(vehicle);
    }


    /**
     *查询剩余车位
     * @return
     * */
    @PostMapping(value = "/selectpkcounts")
    public JSONObject parkingspace(HjZhgdPkcount hjZhgdPkcount){
        System.out.println(hjZhgdPkcount);
        System.out.println(client.parkingspace(hjZhgdPkcount).toJSONString());
        return client.parkingspace(hjZhgdPkcount);
    }

    /**
     * 查询某个车场剩余车位
     * */
    @PostMapping(value = "/carpkcount")
    public JSONObject carpkcount( HjZhgdPkcount hjZhgdPkcount){
        System.out.println(hjZhgdPkcount);
        System.out.println(client.carpkcount(hjZhgdPkcount).toJSONString());
        return client.carpkcount(hjZhgdPkcount);
    }
}
