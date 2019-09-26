package com.hujiang.project.zhgd.hjDictionaries.controller;


import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjDictionaries.domain.HjDictionaries;
import com.hujiang.project.zhgd.hjDictionaries.service.IHjDictionariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 工种表
 * @author hujiang
 * @date 2019-05-19
 */
@RestController
@RequestMapping(value = "/api/dictionariesApi" , method = RequestMethod.POST)
public class DictionariesApi {


    @Autowired
    private IHjDictionariesService hjDictionariesService;
    @Autowired
    private SystemClient systemClient;


    @RequestMapping("/getHjDictionariesList")
    public JSONObject getHjDictionariesList(@RequestBody String json){
        return systemClient.getHjDictionariesList(json);
    }
    /**
     * 工种信息
     * @param
     * @return
     */
    @RequestMapping("/selectDictionaries")
    public Map<String, Object> selectDictionaries(HjDictionaries hjDictionaries)
    {
       return  hjDictionariesService.selectHjDictionariesList(hjDictionaries);
    }

    /**
     * 热门工种
     * @param
     * @return
     */
    @RequestMapping(value ="/selectWorkType",method = RequestMethod.POST)
    public  Map<String, Object> selectWorkType(HjDictionaries hjDictionaries){
        return systemClient.selectWorkType(hjDictionaries);
    }





}
