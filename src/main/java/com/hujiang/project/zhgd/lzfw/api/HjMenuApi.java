package com.hujiang.project.zhgd.lzfw.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.lzfw.domain.HjMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/api/menu")
public class HjMenuApi {

    @Autowired
    private SystemClient client;

    /**
     * 查询菜单
     * */
    @PostMapping(value = "/seleall")
    public JSONObject seleall( HjMenu menu){
        return client.seleall(menu);
    }
}
