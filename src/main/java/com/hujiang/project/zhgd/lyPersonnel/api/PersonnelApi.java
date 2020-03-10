package com.hujiang.project.zhgd.lyPersonnel.api;

import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.lyPersonnel.domain.LyCompanyPersonnel;
import com.hujiang.project.zhgd.lyPersonnel.domain.LyPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/lyPersonnel",method = RequestMethod.POST)
public class PersonnelApi {
    @Autowired
    private SystemClient client;
    @PostMapping("/insertPersonnel")
    public AjaxResult insertPersonnel(LyPersonnel lyPersonnel){
        return client.insertPersonnel(lyPersonnel);

    }
    /**
     * 信息查询人员资料
     */
    @PostMapping("/selectPersonnelCompany")
    public AjaxResult selectPersonnelCompany( LyPersonnel lyPersonnel){

        return client.selectPersonnelCompany(lyPersonnel);
    }
    /**
     * 人员进出动态
     */
    @PostMapping("/getPersonnelDT")
    public AjaxResult getPersonnelDT(Integer pid,String time){
        return client.getPersonnelDT(pid,time);
    }
    /**
     * 人员进出记录
     */
    @PostMapping("/getPersonnelRecord")
    public AjaxResult getPersonnelRecord(Integer pid,String time){
        return client.getPersonnelRecord(pid,time);
    }
    /**
     * 查询人员信息
     */
    @PostMapping("/selectPersonnelById")
    public AjaxResult selectPersonnelById(Integer personnelId){
        return client.selectPersonnelById(personnelId);
    }
}
