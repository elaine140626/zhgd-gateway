package com.hujiang.project.zhgd.DeeppitExternal;



import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 深基坑对外接口
 */
@RestController
@RequestMapping(value = "/api/deeppitExternalApi",method = RequestMethod.POST)
public class DeeppitExternalApi {
    @Autowired
    private SystemClient systemClient;


    /**
     * 深基坑结构物
     * @param json
     * @return
     */
    @PostMapping(value = "/addStructures")
    public Map<String,Object> addStructures(@RequestBody String json){

        return systemClient.addStructures(json);
    }

    /**
     * 结构物因素
     * @param json
     * @return
     */
    @PostMapping(value = "/addDisplay")
    public Map<String,Object> addDisplay(@RequestBody String json){

        return systemClient.addDisplay(json);
    }

    /**
     * 深基坑测点
     * @param json
     * @return
     */
    @PostMapping(value = "/addGroup")
    public Map<String,Object> addGroup(@RequestBody String json){

        return systemClient.addGroup(json);
    }
    /**
     * 深基坑传感器
     * @param json
     * @return
     */
    @PostMapping(value = "/addFactor")
    public  Map<String,Object> addFactor(@RequestBody String json){

        return systemClient.addFactor(json);
    }

    /**
     *深基坑数据记录
     * @param json
     * @return
     */
    @PostMapping(value = "/addDeeppitData")
    public  Map<String,Object> addDeeppitData(@RequestBody String json){
        return systemClient.addDeeppitData(json);
    }

    /**
     * 深基坑报警记录
     * @param json
     * @return
     */
    @PostMapping(value = "/addDeeppitAlarmData")
    public Map<String,Object> addDeeppitAlarmData(@RequestBody String json){
        return systemClient.addDeeppitAlarmData(json);
    }
}
