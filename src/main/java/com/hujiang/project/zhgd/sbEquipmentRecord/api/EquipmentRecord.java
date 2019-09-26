package com.hujiang.project.zhgd.sbEquipmentRecord.api;

import com.hujiang.project.zhgd.sbEquipmentRecord.domain.SbEquipmentRecord;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/equipmentRecordApi")
public class EquipmentRecord {
    @Autowired
    private SystemClient systemClient;
    @PostMapping("/addEquipmentRecord")
    public Map<String,Object> addEquipmentRecord(@RequestBody String json){
        return systemClient.addEquipmentRecord(json);
    }

}
