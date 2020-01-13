package com.hujiang.project.zhgd.sbGroupTitle.api;

import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbGroupTitle.domain.SbGroupTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/groupTitleApi")
public class GroupTitleApi {
    @Autowired
    private SystemClient client;
    @PostMapping(value = "/getTitle")
    public AjaxResult getTitle(SbGroupTitle groupTitle){

        return client.getTitle(groupTitle);
    }
}
