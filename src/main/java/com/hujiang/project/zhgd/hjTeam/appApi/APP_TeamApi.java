package com.hujiang.project.zhgd.hjTeam.appApi;


import com.hujiang.project.zhgd.Constants;
import com.hujiang.project.zhgd.RestTemplateUtil;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjTeam.domain.HjTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: Provider01
 * @description: 班组接口
 * @author: Mr.LiuYong
 * @create: 2019-05-15 18:30
 **/
@RestController
@RequestMapping(value = "/api/teamApi/app", method = RequestMethod.POST)
public class APP_TeamApi {

    @Autowired
    private RestTemplateUtil restTemplateUtil;
    @Autowired
    private SystemClient systemClient;


    /**
     * 查参建单位下的班组
     * @param hjTeam 参建单位id
     * @return
     */
    @RequestMapping(value = "selectTeam")
    public Map<String, Object> selectTeam(HjTeam hjTeam)throws Exception {
//       restTemplateUtil.Post(hjTeam, Constants.SERVICE_NAME+"provider/teamApi/app/selectTeam");
        return systemClient.selectTeam(hjTeam);
    }






}
