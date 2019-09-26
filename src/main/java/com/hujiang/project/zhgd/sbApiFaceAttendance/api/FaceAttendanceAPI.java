package com.hujiang.project.zhgd.sbApiFaceAttendance.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbApiFaceAttendance.domain.SbApiFaceAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-07-01 11:07
 **/
@RestController
@RequestMapping(value = "/api/FaceAttendanceAPI",method = RequestMethod.POST)
public class FaceAttendanceAPI {
    private Logger logger = Logger.getLogger(FaceAttendanceAPI.class.getName());
    @Autowired
    private SystemClient client;

    @PostMapping("getAttendance")
    public Map<String,Object> getAttendance( @RequestBody String json, HttpServletRequest request){
        logger.info("\r com.hujiang.project.zhgd.sbApiFaceAttendance.api.FaceAttendanceAPI.getAttendance" +
                "获取数据："+json);
        SbApiFaceAttendance attendance = JSONObject.parseObject(json, SbApiFaceAttendance.class);
        attendance.setIp(request.getRemoteAddr());
        return client.getAttendance(attendance);
    }

}
