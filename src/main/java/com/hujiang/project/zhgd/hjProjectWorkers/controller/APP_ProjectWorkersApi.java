package com.hujiang.project.zhgd.hjProjectWorkers.controller;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.common.exception.BusinessException;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.Constants;
import com.hujiang.project.zhgd.RestTemplateUtil;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjProjectWorkers.domain.*;
import com.hujiang.project.zhgd.hjProjectWorkers.service.IHjProjectWorkersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 人员信息
 *
 * @author hujiang
 * @date 2019-05-20
 */
@RestController
@RequestMapping(value = "/api/projectWorkersApi", method = RequestMethod.POST)
public class APP_ProjectWorkersApi {


    @Autowired
    private IHjProjectWorkersService hjProjectWorkersService;
    @Autowired
    private RestTemplateUtil restTemplateUtil;
    @Autowired
    private SystemClient systemClient;

    /**
     * 人员信息列表--对外
     *
     * @param empNameParam
     * @return
     */
    @RequestMapping("/selectProjectWorkers")
    @ResponseBody
    public Map<String, Object> selectProjectWorkers(EmpNameParam empNameParam) {
        System.out.println(empNameParam);
        return hjProjectWorkersService.selectProjectWorkers(empNameParam);
    }

    /**
     * 实名制录入
     *
     * @return
     */
    @RequestMapping("/insertProjectWorkersTwo")
    @ResponseBody
    public Map<String, Object> insertProjectWorkersTwo(@RequestBody String json) {
        return systemClient.insertProjectWorkersTwo(json);
    }

    /**
     * 增加考情记录
     *
     * @param json
     * @return
     */
    @PostMapping(value = "/addAttendanceRecord")
    public Map<String, Object> addAttendanceRecord(@RequestBody String json) {
        return systemClient.addAttendanceRecord(json);
    }

    /**
     * 人员信息 详情
     *
     * @param projectWorkersParam
     * @return
     */
    @RequestMapping("/selectProjectWorkersDetails")
    @ResponseBody
    public Map<String, Object> selectProjectWorkersDetails(ProjectWorkersParam projectWorkersParam) {
        return hjProjectWorkersService.selectProjectWorkersDetails(projectWorkersParam);
    }


    /**
     * 人员信息 所属单位
     *
     * @param projectWorkers
     * @return
     */
    @RequestMapping("/selectConstructionProject")
    @ResponseBody
    public Map<String, Object> selectConstructionProject(ProjectWorkers projectWorkers) {
        System.out.println("-------------------------------------------------------------" + projectWorkers);
        return hjProjectWorkersService.selectConstructionProject(projectWorkers);
    }


    /**
     * 实名制录入
     *
     * @param hjProjectWorkers
     * @return
     */
    @RequestMapping("/insertProjectWorkers")
    @ResponseBody
    public Map<String, Object> insertProjectWorkers(HjProjectWorkers hjProjectWorkers) {
        System.out.println("-------------------------------------------------------------" + hjProjectWorkers);
        return hjProjectWorkersService.insertProjectWorkers(hjProjectWorkers);
    }

    /**
     * 人证对比
     */
    @RequestMapping(value = "/queryWitnessComparison")
    @ApiOperation("人证对比")
    @ResponseBody
    public Map<String, Object> queryWitnessComparison(MultipartFile file, String url) throws Exception {
        System.out.println(url);
        Map<String, Object> map = new HashMap<>();
        map.put("url", url);
//        return systemClient.queryWitnessComparison(file,url);
        return (Map<String, Object>) restTemplateUtil.PostFile(map, Constants.SERVICE_NAME + "provider/projectWorkersApi/queryWitnessComparison", file);
    }


    /**
     * 人员信息 修改
     *
     * @return
     */
    @RequestMapping("/updateProjectWorkers")
    @ResponseBody
    public Map<String, Object> updateProjectWorkers(HjProjectWorkers hj, MultipartFile file) throws Exception {
        System.out.println(hj);
//        System.out.println(file.getOriginalFilename());
        //        return hjProjectWorkersService.updateProjectWorkers(hj);
        hj.setUpdateDate(new SimpleDateFormat().format(new Date()));
//        return  systemClient.updateProjectWorkersP(hj,file);
        return (Map<String, Object>) restTemplateUtil.PostFile(hj, Constants.SERVICE_NAME + "provider/projectWorkersApi/updateProjectWorkers", file);
    }

    /**
     * 人员银行卡信息 修改
     *
     * @return
     */
    @RequestMapping("/updateProjectWorkersBank")
    @ResponseBody
    public Map<String, Object> updateProjectWorkersBank(int id,String bankName,String cardNum, MultipartFile file) throws Exception {
        Map<String,Object> map  = new HashMap<>();
        map.put("id",id);
        map.put("bankName",bankName);
        map.put("cardNum",cardNum);
//        return systemClient.updateProjectWorkersBank(id,bankName,cardNum,file);
        return(Map<String,Object>) restTemplateUtil.PostFile(map,Constants.SERVICE_NAME+"provider/projectWorkersApi/updateProjectWorkersBank",file);
//
    }
    /**
     * 人员信息 是否签订
     *
     * @param signParam
     * @return
     */
    @RequestMapping("/selectSignParam")
    @ResponseBody
    public Map<String, Object> selectSignParam(SignParam signParam) {
        return hjProjectWorkersService.selectSignParam(signParam);
    }

    /**
     * 证件识别(身份证正反面,银行卡)
     *
     * @param configStr 正反面(face,back,card)
     * @return
     */
    @RequestMapping(value = "/getAliOcrIdCard")
    @ResponseBody
    public Map<String, Object> getAliOcrIdCard(MultipartFile file, String configStr) throws Exception {
        System.out.println(configStr);
        Map<String, Object> map = new HashMap<>();
        map.put("configStr", configStr);
        System.out.println(file.getOriginalFilename());
//        return systemClient.getAliOcrIdCard(file,configStr);
        return (Map<String, Object>) restTemplateUtil.PostFile(map, Constants.SERVICE_NAME + "provider/projectWorkersApi/getAliOcrIdCard", file);
    }

    /**
     * 百度云人脸对比
     * 修改头像比对
     */
    @RequestMapping(value = "/faceVerify")
    @ApiOperation("百度云人脸对比")
    @ResponseBody
    public Map<String, Object> faceVerify(String imageUrl1, String imageUrl2) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("imageUrl1", imageUrl1);
        map.put("imageUrl2", imageUrl2);
//        return systemClient.faceVerify(imageUrl1,imageUrl2);
        return (Map<String, Object>) restTemplateUtil.Post(map, Constants.SERVICE_NAME + "provider/projectWorkersApi/faceVerify");
    }


}
