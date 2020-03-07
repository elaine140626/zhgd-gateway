package com.hujiang.project.zhgd.lyPersonnel.api;

import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.lyPersonnel.domain.LyPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/lyPersonnel",method = RequestMethod.POST)
public class PersonnelApi {
    @Autowired
    private SystemClient client;
    @PostMapping("/insertPersonnel")
    public AjaxResult insertPersonnel(LyPersonnel lyPersonnel){
        return client.insertPersonnel(lyPersonnel);

    }
}
