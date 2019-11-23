package com.hujiang.project.zhgd.client;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.common.support.Convert;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.project.zhgd.hjAttendanceDevice.domain.HjAttendanceDevice;
import com.hujiang.project.zhgd.hjDeeppit.domain.SbProjectDeeppitStructures;
import com.hujiang.project.zhgd.hjZhgdDriver.domain.HjZhgdDriver;
import com.hujiang.project.zhgd.lzfw.domain.*;
import com.hujiang.project.zhgd.hjDeveceProjectworkers.domain.HjDeviceProjectworkers;
import com.hujiang.project.zhgd.SbProjectVideo.domain.SbProjectVideo;
import com.hujiang.project.zhgd.SbProjectVideoArea.domain.SbProjectVideoArea;
import com.hujiang.project.zhgd.deye.domain.SbCraneAddrecord;
import com.hujiang.project.zhgd.deye.domain.SbCraneBinding;
import com.hujiang.project.zhgd.deye.domain.SbElevatorAddrecord;
import com.hujiang.project.zhgd.dustEmissionThresholdValue.domain.DustEmissionThresholdValue;
import com.hujiang.project.zhgd.hjAttendanceRecord.domain.HjAttendanceRecord;
import com.hujiang.project.zhgd.hjAttendanceRecord.domain.Param;
import com.hujiang.project.zhgd.hjBlacklist.domain.HjBlacklist;
import com.hujiang.project.zhgd.hjCompanyLibrary.domain.HjCompanyLibrary;
import com.hujiang.project.zhgd.hjConstructionCompany.domain.HjConstructionCompany;
import com.hujiang.project.zhgd.hjDictionaries.domain.HjDictionaries;
import com.hujiang.project.zhgd.hjFolder.domain.HjFolder;
import com.hujiang.project.zhgd.hjLogging.domain.HjLogging;
import com.hujiang.project.zhgd.hjProject.domain.HjProject;
import com.hujiang.project.zhgd.hjProjectWorkers.domain.*;
import com.hujiang.project.zhgd.hjSafetyAbarbeitung.domain.HjSafetyAbarbeitung;
import com.hujiang.project.zhgd.hjSafetyAbarbeitung.domain.HjSafetyNoPass;
import com.hujiang.project.zhgd.hjSynchronizationInformation.domain.HjSynchronizationInformation;
import com.hujiang.project.zhgd.hjSystemPrivileges.domain.HjSystemPrivileges;
import com.hujiang.project.zhgd.hjSystemPrivileges.domain.SystemRoleParam;
import com.hujiang.project.zhgd.hjSystemRole.domain.HjSystemRole;
import com.hujiang.project.zhgd.hjSystemRole.domain.RoleParam;
import com.hujiang.project.zhgd.hjSystemUser.domain.HjSystemUser;
import com.hujiang.project.zhgd.hjSystemUser.domain.PasswordParam;
import com.hujiang.project.zhgd.hjSystemUser.domain.SystemUserParam;
import com.hujiang.project.zhgd.hjSystemUser.domain.UserParam;
import com.hujiang.project.zhgd.hjTeam.domain.HjTeam;
import com.hujiang.project.zhgd.hjZhgdVehicle.domain.*;
import com.hujiang.project.zhgd.kqbb.domain.BG;
import com.hujiang.project.zhgd.kqbb.domain.Kqbb;
import com.hujiang.project.zhgd.sbApiFaceAttendance.domain.SbApiFaceAttendance;
import com.hujiang.project.zhgd.sbCurrentTemperature.domain.SbCurrentTemperature;
import com.hujiang.project.zhgd.sbDustEmission.domain.SbDustEmission;
import com.hujiang.project.zhgd.sbElevatorAddrecord.api.domain.OptionsElevator;
import com.hujiang.project.zhgd.sbExcessiveDust.domain.SbExcessiveDust;
import com.hujiang.project.zhgd.sbExcessiveDust.domain.SbExcessiveDust;
import com.hujiang.project.zhgd.sbHire.api.domain.SbArea;
import com.hujiang.project.zhgd.sbManufacturer.domain.SbManufacturer;
import com.hujiang.project.zhgd.sbProjectDustEmission.domain.SbProjectDustEmission;
import com.hujiang.project.zhgd.sbProjectElectricityBox.domain.SbProjectElectricityBox;
import com.hujiang.project.zhgd.sbUnloaderRegistration.domain.ExportUnloaderAlarmtime;
import com.hujiang.project.zhgd.sbUnloaderRegistration.domain.ExportUnloaderRealtime;
import com.hujiang.project.zhgd.zhNode.domain.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.text.ParseException;
import java.util.List;
import java.util.Map;

@FeignClient(value = "user-api")
public interface SystemClient {
    @PostMapping("/provider/pcEquipmentWarning/warningCount")
    public JSONObject warningCount(@RequestParam(value = "projectId") Integer projectId);
    @PostMapping("/provider/pcEquipmentWarning/getWarningList")
    public JSONObject getWarningList(@RequestParam(value = "userName",required = false)String userName,
                                     @RequestParam(value = "userId",required = false)Integer userId,
                                     @RequestParam(value = "areaName",required = false)String areaName,
                                     @RequestParam(value = "areaId",required =  false)Integer areaId,
                                     @RequestParam(value = "projectId",required = false)Integer projectId,
                                     @RequestParam(value = "warningType",required = false)Integer warningType,
                                     @RequestParam(value = "startTime",required = false)String startTime,
                                     @RequestParam(value = "endTime",required = false)String endTime,
                                     @RequestParam(value = "pageSize",required = false)Integer pageSize,
                                     @RequestParam(value = "pageNum",required = false)Integer pageNum);
    @PostMapping(value ="/provider/cay")
    public JSONObject cay(@RequestParam("projectId") Integer projectId);

    @PostMapping(value ="/provider/caySbDelete")
    public JSONObject deletecay(@RequestParam("sn") String sn, @RequestParam("xmid") String xmid, @RequestParam("devType") String devType,
                                @RequestParam("devCcrq") String devCcrq, @RequestParam("subId") String subId);

    /** 1.高支模监测因素*/
    @PostMapping(value ="/provider/formWorkExternalApi/addFormWorkDisplay")
    public Map<String,Object> addFormWorkDisplay(@RequestBody String json);


    @PostMapping(value ="/provider/formWorkExternalApi/addFormWorkFactor")
    public Map<String,Object> addFormWorkFactor(@RequestBody String json);

    @PostMapping(value = "/provider/formWorkExternalApi/addFormWorkGroup")
    public Map<String,Object> addFormWorkGroup(@RequestBody String json);
    @PostMapping(value = "/provider/formWorkExternalApi/addFormWorkData")
    public Map<String,Object> addFormWorkData(@RequestBody String json);
    @PostMapping(value = "/provider/formWorkExternalApi/addFormWorkAlarmData")
    public Map<String,Object> addFormWorkAlarmData(@RequestBody String json);
    /** 深基坑数据记录 */
    @PostMapping(value = "/provider/deeppitExternalApi/addDeeppitData")
    public  Map<String,Object> addDeeppitData(@RequestBody String json);

    /**  深基坑报警记录*/
    @PostMapping(value = "/provider/deeppitExternalApi/addDeeppitAlarmData")
    public Map<String,Object> addDeeppitAlarmData(@RequestBody String json);
    /**深基坑结构物*/
    @PostMapping(value = "/provider/deeppitExternalApi/addStructures")
    public Map<String,Object> addStructures(@RequestBody String json);

    /**结构物因素 */
    @PostMapping(value = "/provider/deeppitExternalApi/addDisplay")
    public Map<String,Object> addDisplay(@RequestBody String json);

    /**深基坑测点分组*/
    @PostMapping(value = "/provider/deeppitExternalApi/addGroup")
    public Map<String,Object> addGroup(@RequestBody String json);

    /**深基坑传感器*/
    @PostMapping(value = "/provider/deeppitExternalApi/addFactor")
    public  Map<String,Object> addFactor(@RequestBody String json);

    /** 电箱对外接口*/
    @PostMapping("/provider/electricityBoxExternal/addElectricityBox")
    public Map<String,Object> addElectricityBox(@RequestBody String json);

    @PostMapping(value = "/provider/unloaderPcApi/getUnloaderList")
    public JSONObject getUnloaderPcList(@RequestParam("projectId") Integer projectId);

    @PostMapping(value = "/provider/unloaderPcApi/getSbUnloaderRealtimeList")
    public JSONObject getSbUnloaderRealtimePcList(@RequestParam(value = "projectId") Integer projectId,
                                                  @RequestParam(value = "deviceId") String deviceId);

    @PostMapping(value = "/provider/unloaderPcApi/getRealtimeHistory")
    public JSONObject getRealtimeHistory(@RequestParam("projectId") Integer projectId,
                                         @RequestParam(value = "deviceId") String deviceId,
                                         @RequestParam(value = "time", required = false) String time,
                                         @RequestParam(value = "alarmType") Integer alarmType,
                                         @RequestParam("pageSize") Integer pageSize,
                                         @RequestParam("pageNum") Integer pageNum);

    @PostMapping(value = "/provider/unloaderPcApi/getSbUnloaderHistory")
    public JSONObject getSbUnloaderPcHistory(@RequestParam(value = "projectId") Integer projectId,
                                             @RequestParam(value = "deviceId") String deviceId,
                                             @RequestParam(value = "time", required = false) String time,
                                             @RequestParam("pageSize") Integer pageSize,
                                             @RequestParam("pageNum") Integer pageNum);
    //卸料pc报警数据历史记录导出
    @PostMapping("/provider/unloaderPcApi/exportUnloaderAlarmtime")
    public List<ExportUnloaderAlarmtime> exportUnloaderAlarmtime(@RequestParam(value = "ids", required = false) String ids,
                                                                 @RequestParam(value = "deviceId", required = false) String deviceId,
                                                                 @RequestParam(value = "alarmType", required = false) Integer alarmType);
    //卸料pc实时数据历史记录导出
    @PostMapping("/provider/unloaderPcApi/exportUnloaderRealtime")
    public List<ExportUnloaderRealtime> exportUnloaderRealtime(@RequestParam(value = "ids", required = false) String ids,
                                                               @RequestParam(value = "deviceId", required = false) String deviceId);
    /** 卸料app报警记录*/
    @PostMapping(value = "/provider/unloaderAppApi/getSbUnloaderAlarmtimeList")
    public JSONObject getSbUnloaderAlarmtimeList(@RequestParam("projectId") Integer projectId,
                                                 @RequestParam(value = "deviceId") String deviceId,
                                                 @RequestParam(value = "time", required = false) String time,
                                                 @RequestParam("pageSize") Integer pageSize,
                                                 @RequestParam("pageNum") Integer pageNum);
    /**  卸料app历史记录*/
    @PostMapping(value = "/provider/unloaderAppApi/getSbUnloaderHistory")
    public JSONObject getSbUnloaderHistory(@RequestParam(value = "projectId") Integer projectId,
                                           @RequestParam(value = "deviceId") String deviceId,
                                           @RequestParam(value = "time", required = false) String time,
                                           @RequestParam("pageSize") Integer pageSize,
                                           @RequestParam("pageNum") Integer pageNum);

    /** 卸料app界面*/
    @PostMapping(value = "/provider/unloaderAppApi/getSbUnloaderRealtimeList")
    public JSONObject getSbUnloaderRealtimeList(@RequestParam(value = "projectId") Integer projectId,
                                                @RequestParam(value = "deviceId") String deviceId);
    /** 卸料app切换设备*/
    @PostMapping(value = "/provider/unloaderAppApi/getUnloader")
    public JSONObject getUnloader(@RequestParam("projectId") Integer projectId);

    /**  卸料注册信息 */
    @PostMapping(value = "/provider/zhgd/LoginDataUnloadingPlatform")
    public JSONObject LoginDataUnloadingPlatform(@RequestBody String json);

    /** 卸料基础参数 */
    @PostMapping(value = "/provider/zhgd/BaseDataUnloadingPlatform")
    public JSONObject BaseDataUnloadingPlatform(@RequestBody String json);

    /** 卸料实时数据 */
    @PostMapping(value = "/provider/zhgd/RealtimeDataUnloadingPlatform")
    public JSONObject RealtimeDataUnloadingPlatform(@RequestBody String json);

    /** 卸料报警时段数据 */
    @PostMapping(value = "/provider/zhgd/AlarmDataUnloadingPlatform")
    public JSONObject AlarmDataUnloadingPlatform(@RequestBody String json);
    /** 卸料报警时刻数据*/
    @PostMapping(value = "/provider/zhgd/AlarmStartUnloadingPlatform")
    public JSONObject AlarmStartUnloadingPlatform(@RequestBody String json);

    //平台设置：人员定位设置
    @PostMapping(value = "/provider/OptionsLocationApi/getAreaList")
    public JSONObject getLocationAreaList(@RequestParam("projectId") Integer projectId);
    //修改人员定位工业区
    @PostMapping(value = "/provider/OptionsLocationApi/updateArea")
    public JSONObject updateLocationArea(@RequestParam("areaId") Integer areaId,
                                         @RequestParam("areaName") String areaName,
                                         @RequestParam("areaAddress") String areaAddress,
                                         @RequestParam("constructionId") Integer constructionId);
    //新增人员定位工业区
    @PostMapping(value = "/provider/OptionsLocationApi/addArea")
    public JSONObject addLocationArea(@RequestParam("areaName") String areaName,
                                      @RequestParam("areaAddress") String areaAddress,
                                      @RequestParam("constructionId") Integer constructionId,
                                      @RequestParam("areaXloc") Double areaXloc,
                                      @RequestParam("areaYloc") Double areaYloc,
                                      @RequestParam("radius") Double radius,
                                      @RequestParam("projectId") Integer projectId);

    @PostMapping(value = "/provider/OptionsLocationApi/deleteArea")
    public JSONObject deleteLocationArea(@RequestParam("areaId") Integer areaId);

    @PostMapping(value = "/provider/OptionsLocationApi/getAreaUserList")
    public JSONObject getLocationUserList(@RequestParam(value = "areaId", required = false) Integer areaId,
                                          @RequestParam(value = "filed", required = false) String filed,
                                          @RequestParam(value = "projectId") Integer projectId,
                                          @RequestParam("pageSize") Integer pageSize,
                                          @RequestParam("pageNum") Integer pageNum);

    @PostMapping("/provider/OptionsLocationApi/getAreaById")
    public JSONObject getAreaById(@RequestParam("areaId") Integer areaId);

    @PostMapping(value = "/provider/OptionsLocationApi/updateAreaUser")
    public JSONObject updateAreaUser(@RequestParam(value = "areaId") Integer areaId,
                                     @RequestParam(value = "userName") String userName,
                                     @RequestParam(value = "userPhone", required = false) String userPhone,
                                     @RequestParam(value = "imei") String imei,
                                     @RequestParam(value = "userId") Integer userId);

    @PostMapping(value = "/provider/OptionsLocationApi/deleteAreaUser")
    public JSONObject deleteLocationAreaUser(@RequestParam(value = "userId") Integer userId,
                                             @RequestParam(value = "areaId") Integer areaId);

    @PostMapping(value = "/provider/OptionsLocationApi/addAreaUser")
    public JSONObject addLocationAreaUser(@RequestParam(value = "areaId") Integer areaId,
                                          @RequestParam(value = "userName") String userName,
                                          @RequestParam(value = "userPhone", required = false) String userPhone,
                                          @RequestParam(value = "imei") String imei);

    @PostMapping(value = "/provider/OptionsConstructionApi/getConstructionList")
    public JSONObject getConstructionList(@RequestParam("projectId") Integer projectId,
                                          @RequestParam("pageSize") Integer pageSize,
                                          @RequestParam("pageNum") Integer pageNum);

    @PostMapping("/provider/systemuser/app/updateUserById")
    public JSONObject updateUserById(@RequestParam(value = "userName", required = false) String userName,
                                     @RequestParam(value = "userPhone", required = false) String userPhone,
                                     @RequestParam(value = "userId", required = false) Integer userId);
    //塔吊：设备列表
    @PostMapping("/provider/OptionsCraneApi/getCraneList")
    public JSONObject getCraneList(@RequestParam("projectId") Integer projectId);
    //塔吊：修改删除
    @PostMapping("/provider/OptionsCraneApi/updateCrane")
    public JSONObject updateCrane(@RequestParam("id") String id,
                                  @RequestParam("craneName") String craneName,
                                  @RequestParam("hxzId") String hxzId,
                                  @RequestParam("serialNum") String serialNum,//广东省统一安装告 知编号（产权备案 编号）
                                  @RequestParam("tcMaxScope") String tcMaxScope,//最大幅度（M）
                                  @RequestParam("tcMaxHeight") String tcMaxHeight,//最大高度（M)
                                  @RequestParam("tcLoadCapacity") String tcLoadCapacity,//最大载重（kg）
                                  @RequestParam("tcLoadMoment") String tcLoadMoment,//额定起重力矩（N·m）
                                  @RequestParam(value = "jdbh", required = false) String jdbh,
                                  @RequestParam(value = "xmid", required = false) String xmid,
                                  @RequestParam(value = "subId", required = false) String subId,
                                  @RequestParam("scznl") String scznl,
                                  @RequestParam("manufacturerId") String manufacturerId,
                                  @RequestParam("installCompany") String installCompany //设备安装单位

    );
    //塔吊：删除设备
    @PostMapping("/provider/OptionsCraneApi/deleteCrane")
    public JSONObject deleteCrane(@RequestParam("id") Integer id, @RequestParam(value = "devCcrq", required = false) String devCcrq);
    //塔吊：添加设备
    @PostMapping("/provider/OptionsCraneApi/insertCrane")
    public JSONObject insertCrane(@RequestParam("craneName") String craneName,
                                  @RequestParam("hxzId") String hxzId,
                                  @RequestParam("projectId") Integer projectId,
                                  @RequestParam("serialNum") String serialNum,//广东省统一安装告 知编号（产权备案 编号）
                                  @RequestParam("tcMaxScope") String tcMaxScope,//最大幅度（M）
                                  @RequestParam("tcMaxHeight") String tcMaxHeight,//最大高度（M)
                                  @RequestParam("tcLoadCapacity") String tcLoadCapacity,//最大载重（kg）
                                  @RequestParam("tcLoadMoment") String tcLoadMoment,//额定起重力矩（N·m）
                                  @RequestParam(value = "jdbh", required = false) String jdbh,
                                  @RequestParam(value = "xmid", required = false) String xmid,
                                  @RequestParam(value = "subId", required = false) String subId,
                                  @RequestParam("scznl") String scznl,
                                  @RequestParam("manufacturerId") String manufacturerId,
                                  @RequestParam("installCompany") String installCompany);
    //塔吊：报警设置列表
    @PostMapping("/provider/OptionsCraneApi/getCraneUserList")
    public JSONObject getCraneUserList(@RequestParam("projectId") Integer projectId,
                                       @RequestParam(value = "filed", required = false) String filed);

    //升降机：设备列表
    @PostMapping("/provider/OptionsElevatorApi/getElevatorList")
    public JSONObject getElevatorList(@RequestParam("projectId") Integer projectId);
    //升降机：修改设备
    @PostMapping("/provider/OptionsElevatorApi/updateElevator")
    public JSONObject updateElevator(@RequestBody OptionsElevator optionsElevator);
    //升降机：删除设备
    @PostMapping("/provider/OptionsElevatorApi/deleteElevator")
    public JSONObject deleteElevator(@RequestParam("id") Integer id, @RequestParam(value = "devCcrq", required = false) String devCcrq);
    //升降机：添加设备
    @PostMapping("/provider/OptionsElevatorApi/insertElevator")
    public JSONObject insertElevator(@RequestBody OptionsElevator optionsElevator);
    //升降机：报警设置列表
    @PostMapping("/provider/OptionsElevatorApi/getElevatorUserList")
    public JSONObject getElevatorUserList(@RequestParam("projectId") Integer projectId,
                                          @RequestParam(value = "filed", required = false) String filed);

    //推送开关
    @PostMapping("/provider/OptionsPushApi/optionsPush")
    public JSONObject optionsPush(@RequestParam(value = "onOff") Integer onOff,
                                  @RequestParam(value = "userId") Integer userId,
                                  @RequestParam(value = "privilegesId") Integer privilegesId);
    /**
     * 平台设置：安全/质量巡检工区设置
     * @param projectId
     * @return
     */
    @PostMapping(value = "/provider/optionsSafetyApi/getOptionsList")
    public JSONObject getOptionsList(@RequestParam(value = "projectId") Integer projectId);
    @PostMapping(value = "/provider/optionsSafetyApi/getUserList")
    public JSONObject getUserList(@RequestParam(value = "projectId") Integer projectId);
    //增加工业区
    @PostMapping("/provider/optionsSafetyApi/addArea")
    public JSONObject addSafetyArea(@RequestParam("areaName") String areaName,
                                    @RequestParam("address") String address,
                                    @RequestParam("constructionId") Integer constructionId);
    //修改工业区
    @PostMapping("/provider/optionsSafetyApi/updateArea")
    public JSONObject updateSafetyArea(@RequestParam("areaId") Integer areaId,
                                       @RequestParam("areaName") String areaName,
                                       @RequestParam("address") String address,
                                       @RequestParam("constructionId") Integer constructionId);

    //增加负责人
    @PostMapping("/provider/optionsSafetyApi/addAreaUser")
    public JSONObject addSafetyAreaUser(@RequestParam("userId") Integer userId,
                                        @RequestParam("areaId") Integer areaId);

    // 删除负责人
    @PostMapping("/provider/optionsSafetyApi/deleteAreaUser")
    public JSONObject deleteSafetyAreaUser(@RequestParam("userId") Integer userId,
                                           @RequestParam("areaId") Integer areaId);

    @PostMapping("/provider/optionsSafetyApi/deleteArea")
    public JSONObject deleteSafetyArea(@RequestParam("areaId") Integer areaId);


    /**
     * 添加驾驶员车牌
     * */
    @PostMapping(value = "/provider/driver/insertDriver")
    public JSONObject addDriver(@RequestParam("driver") String driver, @RequestParam("vehicle") String vehicle, @RequestParam("projectId") Integer projectId);

    /**
     * 查询司机列表
     * */
    @PostMapping(value = "/provider/driver/selectAll")
    public JSONObject all(@RequestBody HjZhgdDriver hjZhgdDriver, @RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum);

    /**
     * 查询设备厂商列表
     * */
    @PostMapping(value = "/provider/manufacturer/list")
    public JSONObject allFirm(@RequestBody SbManufacturer sbManufacturer);
    /**
     * 删除司机
     * */
    @PostMapping(value = "/provider/driver/delDriver")
    public JSONObject del(@RequestParam("id") Integer id);

    /**
     *编辑司机信息
     * */
    @PostMapping(value = "/provider/driver/updateDriver")
    public JSONObject uod(@RequestBody HjZhgdDriver hjZhgdDriver);

    /**
     * 车辆设备添加
     * */
    @PostMapping(value = "/provider/parkings/vehicleSnAdd")
    public JSONObject vehicleSnAdd(@RequestBody HjZhgdPkcount hjZhgdPkcount);

    /**
     * 车辆设备添加
     * */
    @PostMapping(value = "/provider/parkings/vehicleSnDel")
    public JSONObject vehicleSnDel(@RequestParam("id") Integer id);
    /**
     * 车辆设备修改
     * */
    @PostMapping(value = "/provider/parkings/vehicleSnUpd")
    public JSONObject vehicleSnUpd(@RequestBody HjZhgdPkcount hjZhgdPkcount);

    /**
     * 设置车位数
     * */
    @PostMapping(value = "/provider/parkings/carUpd")
    public JSONObject carUpd(@RequestParam("deptId") String deptId, @RequestParam("pkcount") Integer pkcount);

    /**
     * 版本号
     * @return
     */
    @PostMapping(value = "/provider/versionApi/getVersion")
    public JSONObject getVersion();

    //app巡检
    /**
     *推送设置别名
     */
    @PostMapping(value = "/provider/safetyAppApi/updateAlias")
    public JSONObject updateAlias(@RequestParam(value = "userId") int userId,
                                  @RequestParam(value = "userAlias") String alias);
    /**
     * 获取信息接口
     */
    @PostMapping("/provider/safetyAppApi/getSafetyList")
    public JSONObject getSafetyList(@RequestParam(value = "projectId") Integer projectId);
    /**
     * 安全监管--发起整改
     */
    @PostMapping(value = "/provider/safetyAppApi/sponsorSafety")
    public JSONObject sponsorSafety(@RequestBody HjSafetyAbarbeitung hjSafetyAbarbeitung);
    /**
     * 待整改/待复查/已完成--列表
     */
    @PostMapping("/provider/safetyAppApi/getAfterRectification")
    public JSONObject getAfterRectification(@RequestParam(value = "projectId") Integer projectId,
                                            @RequestParam(value = "status") Integer status,
                                            @RequestParam(value = "differentiate") Integer differentiate,
                                            @RequestParam(value = "userId") Integer userId,
                                            @RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum);
    /**
     * 进行整改
     */
    @PostMapping("/provider/safetyAppApi/alterSafety")
    public JSONObject alterSafety(@RequestBody HjSafetyNoPass hjSafetyNoPass);
    /**
     * 复查人通过/未通过
     */
    @PostMapping("/provider/safetyAppApi/alertReviewPass")
    public JSONObject alertReviewPass(@RequestBody HjSafetyNoPass hjSafetyNoPass);

    /**
     *  详情
     */
    @PostMapping("/provider/safetyAppApi/getAfterRectificationDetails")
    public JSONObject getAfterRectificationDetails(@RequestParam(value = "safetyId") Integer safetyId);


    /**
     *质量监管--合格/不合格
     */
    @PostMapping("/provider/safetyAppApi/sponsorQuality")
    public JSONObject sponsorQuality(@RequestBody HjSafetyAbarbeitung hjSafetyAbarbeitung);

    /**
     * tsp通知页面
     * */
    @PostMapping(value = "/provider/appDustApi/getExcessive")
    public JSONObject getExcessive(@RequestParam(value = "projectId") Integer projectId,
                                   @RequestParam(value = "userId") Integer userId,
                                   @RequestParam(value = "status") Integer status,
                                   @RequestParam("pageSize") Integer pageSize,
                                   @RequestParam("pageNum") Integer pageNum);

    /**
     * tsp页面修改状态
     * @return
     */
    @PostMapping(value = "/provider/appDustApi/updateExcessive")
    public JSONObject updateExcessive(@RequestParam(value = "id", required = false) Integer id,
                                      @RequestParam(value = "status", required = false) Integer status);

    /**
     * tsp/巡检通知未读总数
     * @param projectId
     * @param userId
     * @return
     */
    @PostMapping(value = "/provider/appDustApi/getCount")
    public JSONObject getCount(@RequestParam(value = "projectId") Integer projectId,
                               @RequestParam(value = "userId") Integer userId);

    /**
     * 巡检通知页面
     * @param projectId
     * @param userId
     * @param pageSize
     * @param pageNum
     * @return
     */
    @PostMapping(value = "/provider/appCommissionApi/getCommission")
    public JSONObject getCommission(@RequestParam(value = "projectId") Integer projectId,
                                    @RequestParam(value = "userId") Integer userId,
                                    @RequestParam(value = "status") Integer status,
                                    @RequestParam("pageSize") Integer pageSize,
                                    @RequestParam("pageNum") Integer pageNum);

    /**
     * 巡检通知页面修改状态
     * @param id
     * @param status
     * @return
     */
    @PostMapping(value = "/provider/appCommissionApi/updateCommission")
    public JSONObject updateCommission(@RequestParam(value = "id") Integer id,
                                       @RequestParam(value = "status") Integer status);
    //pc
    @PostMapping(value = "/provider/safetyPcApi/statisticsCount")
    public JSONObject statisticsCount(@RequestParam(value = "differentiate") Integer differentiate,
                                      @RequestParam(value = "projectId") Integer projectId,
                                      @RequestParam(value = "startTime", required = false) String startTime,
                                      @RequestParam(value = "endTime", required = false) String endTime);

    /**
     * 检查记录查询信息
     * @param projectId
     * @return
     */
    @PostMapping(value = "/provider/safetyPcApi/getInformationList")
    public JSONObject getInformationList(@RequestParam(value = "projectId") Integer projectId);

    /**
     * 检查记录
     * @param status
     * @param initiatorTime
     * @param initiatorName
     * @param rectifyName
     * @param reviewName
     * @param constructionId
     * @param areaId
     * @param problemGradeId
     * @param differentiate
     * @return
     */
    @PostMapping(value = "/provider/safetyPcApi/getInspectionRecordList")
    public JSONObject getInspectionRecordList(@RequestParam(value = "projectId") Integer projectId,
                                              @RequestParam(value = "hiddenId") Integer hiddenId,
                                              @RequestParam(value = "status") Integer status,
                                              @RequestParam(value = "initiatorTime") String initiatorTime,
                                              @RequestParam(value = "initiatorName") String initiatorName,
                                              @RequestParam(value = "rectifyName") String rectifyName,
                                              @RequestParam(value = "reviewName") String reviewName,
                                              @RequestParam(value = "constructionId") Integer constructionId,
                                              @RequestParam(value = "areaId") Integer areaId,
                                              @RequestParam(value = "problemGradeId") Integer problemGradeId,
                                              @RequestParam(value = "differentiate") Integer differentiate,
                                              @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    /**
     * 检查记录详情
     * @param safetyId
     * @return
     */
    @PostMapping(value = "/provider/safetyPcApi/getInspectionRecordDetails")
    public JSONObject getInspectionRecordDetails(@RequestParam(value = "safetyId") Integer safetyId);

    /**
     * 查询分包单位
     * @param projectId
     * @return
     */
    @PostMapping(value = "/provider/safetyPcApi/getConstructionList")
    public JSONObject getConstructionList(@RequestParam(value = "projectId") Integer projectId);
    /**
     * 查询检查区域
     * @param constructionId
     * @return
     */
    @PostMapping(value = "/provider/safetyPcApi/getAreaList")
    public JSONObject getAreaList(@RequestParam(value = "constructionId") Integer constructionId);


    /**
     * 整改单管理
     * @return
     */
    @PostMapping(value = "/provider/safetyPcApi/getManagementList")
    public JSONObject getManagementList(@RequestParam(value = "projectId") Integer projectId,
                                        @RequestParam(value = "status", required = false) Integer status,
                                        @RequestParam(value = "initiatorTime", required = false) String initiatorTime,
                                        @RequestParam(value = "initiatorName", required = false) String initiatorName,
                                        @RequestParam(value = "rectifyName", required = false) String rectifyName,
                                        @RequestParam(value = "reviewName", required = false) String reviewName,
                                        @RequestParam(value = "constructionId", required = false) Integer constructionId,
                                        @RequestParam(value = "differentiate") Integer differentiate,
                                        @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);
    /**
     * 整改单详情
     * @param safetyId
     * @return
     */
    @PostMapping(value = "/provider/safetyPcApi/getManagementDetails")
    public JSONObject getManagementDetails(@RequestParam(value = "safetyId") Integer safetyId);

    @PostMapping(value = "/provider/safetyPcApi/getHiddenList")
    public JSONObject getHiddenList();

    @PostMapping(value = "/provider/safetyPcApi/updateSafety")
    public JSONObject updateSafety(@RequestParam(value = "safetyId") Integer safetyId,
                                   @RequestParam(value = "initiatorId", required = false) Integer initiatorId,
                                   @RequestParam(value = "rectifyId", required = false) Integer rectifyId,
                                   @RequestParam(value = "reviewId", required = false) Integer reviewId,
                                   @RequestParam(value = "make", required = false) String[] makes,
                                   @RequestParam(value = "areaId", required = false) Integer areaId,
                                   @RequestParam(value = "safetyDeadline", required = false) String safetyDeadline,
                                   @RequestParam(value = "hiddenId", required = false) Integer hiddenId,
                                   @RequestParam(value = "safetyRequire", required = false) String safetyRequire,
                                   @RequestParam(value = "initiatorTime", required = false) String initiatorTime,
                                   @RequestParam(value = "rectifyTime", required = false) String rectifyTime,
                                   @RequestParam(value = "reviewTime", required = false) String reviewTime);

    @PostMapping(value = "/provider/safetyPcApi/deleteSafety")
    public JSONObject deleteSafety(@RequestParam("safetyId") Integer safetyId);
    //对外接口start

    /**
     * 增加考情记录
     * @param json
     * @return
     */
    @PostMapping(value = "/provider/projectWorkersApi/addAttendanceRecord")
    Map<String,Object> addAttendanceRecord(@RequestBody String json);
    /**
     * 增加人员工区设备绑定
     * @param json
     * @return
     */
    @PostMapping(value = "/provider/hireApi/addHire")
    JSONObject addHire(@RequestBody String json);

    /**
     * 添加人员定位--对外
     * @param json
     * @return
     */
    @PostMapping(value = "/provider/equipmentRecordApi/addEquipmentRecord")
    Map<String,Object> addEquipmentRecord(@RequestBody String json);

    /**
     * 实名制录入--对外
     * @param json
     * @return
     */
    @RequestMapping(value = "/provider/projectWorkersApi/insertProjectWorkersTwo",method = RequestMethod.POST)
    Map<String, Object> insertProjectWorkersTwo(@RequestBody String json);


    /**
     * 新建参见单位信息--对外
     * 返回参见单位ID
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/provider/constructionCompanyApi/insertConstructionCompanyTwo",method = RequestMethod.POST)
    public AjaxResult insertConstructionCompanyTwo(@RequestBody String json);

    /**
     * 新建班组信息--对外
     * 返回班组ID
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/provider/pcCompanyLibrary/insertHjTeamTwo",method = RequestMethod.POST)
    public AjaxResult insertHjTeamTwo(@RequestBody String json);

    /**
     * 山东扬尘--对外
     * @param json
     * @return
     */
    @RequestMapping(value = "/provider/dustEmission/addDustEmission")
    public Map<String,Object>  addDustEmission(@RequestBody String json);

    /**
     * 同步人员 进出或退场--对外
     * @return
     */
    @PostMapping(value = "/provider/pc/projectWorkersApi/outOrInTwo")
    Map<String,Object> outOrInTwo(@RequestBody String json);

    /**
     * 查询字段列表
     * @return
     */
    @PostMapping(value = "/provider/dictionariesApi/getHjDictionariesList")
    JSONObject getHjDictionariesList(@RequestBody String json);

    //对外接口stop



    /**
     * 根据项目id获取城市天气
     * @param pid
     * @return
     */
    @RequestMapping("/provider/lz/get/getWeather")
    public JSONObject getWeather(@RequestParam(value = "pid") Integer pid);

    /**
     * 根据项目id获取扬尘设备列表
     * @param pid
     * @return
     */
    @RequestMapping("/provider/dustEmission/get/getDustEmissionList")
    public JSONObject getDustEmissionList(@RequestParam(value = "pid") String pid);
    /**
     * 根据编号获取设备记录
     * @param sid
     * @return
     */
    @RequestMapping("/provider/dustEmission/get/DustEmissionDatas")
    public JSONObject getDustEmissionData(@RequestParam(value = "sid") String sid);
    /**
     *绿色施工界面中心数据
     * @param pid
     * @return
     * @throws Exception
     */
    @RequestMapping("/provider/dustEmission/get/HomeDustEmissionCentre")
    public JSONObject getHomeDustEmission(@RequestParam(value = "pid") String pid);
    /**
     * 根据项目id获取项目电箱列表
     *
     * @param pid
     * @return
     */
    @RequestMapping("/provider/electricityBox/get/list")
    public Object getProjectElectricityBox(@RequestParam(value = "pid") String pid);
    /**
     * 根据设备id获取电箱数据
     *
     * @param electricityBoxId
     * @param time
     * @return
     */
    @RequestMapping("/provider/electricityBox/get/message")
    public Object getElectricityBoxRecord(@RequestParam(value = "electricityBoxId") String electricityBoxId,
                                          @RequestParam(value = "time", required = false) String time);
    /**
     * 根据项目id获取电箱状态数据
     *
     * @param pid
     * @return
     */
    @RequestMapping("/provider/electricityBox/get/getElectricBoxState")
    public JSONObject getElectricBoxState(@RequestParam(value = "pid") String pid);



    @PostMapping(value = "/provider/baogao/select")
    public JSONObject select(@RequestBody HjReport hjReport, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @PostMapping(value = "/provider/baogao/add")
    public JSONObject add(@RequestBody HjReport hjReport);
    @PostMapping(value = "/provider/baogao/delete")
    public JSONObject deleteBaogao(@RequestParam(value = "id") Integer id);

    @PostMapping(value = "/provider/workersInformationAp/insteradd")
    public JSONObject insteradd(@RequestBody HjWorkersInformation hjWorkersInformation);
    /**
     * 查看详情
     * */
    @PostMapping(value = "/provider/workersInformationAp/sele")
    public JSONObject sele(@RequestParam(value = "userid") Integer userid);
    /**
     * 查询所有
     * */
    @PostMapping(value = "/provider/workersInformationAp/selectall")
    public JSONObject selectall(@RequestBody HjWorkersInformation hjWorkersInformation, @RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum);
    /**
     * 继续上传（修改）
     * */
    @PostMapping(value = "/provider/workersInformationAp/update")
    public JSONObject uodate(@RequestBody HjWorkersInformation hjWorkersInformation);

    @PostMapping("/provider/workersInformationAp/delete")
    public JSONObject delete(@RequestParam(value = "id") Integer id);
    /** 统计*/
    @PostMapping("/provider/workersInformationAp/lzfwtj")
    public JSONObject selectzhiliaoqiquan(@RequestParam(value = "projectId") Integer projectId);
    /**
     * 查看详情
     * */
    @PostMapping("/provider/lzfw/particulars")
    public JSONObject particulars(@RequestBody HjInformation hjInformation, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);
    /**
     * 删除
     * */
    @PostMapping("/provider/lzfw/deleteHjInformationById")
    public JSONObject deleteHjInformationById(@RequestParam(value = "id") Integer id);
    /**
     * 上传
     * */
    @PostMapping("/provider/lzfw/instadd")
    public JSONObject instadd(@RequestBody HjInformation hjInformation);
    /**
     * 编辑
     * */
    @PostMapping("/provider/lzfw/upda")
    public JSONObject upda(@RequestBody HjInformation hjInformation);
    /**
     * 下载
     * */
    @RequestMapping(value = "/provider/lzfw/testDownload",method = RequestMethod.GET)
    public void dowcCfg(@RequestParam("fileName") String fileName);
    /**
     * 查询菜单
     * */
    @PostMapping("/provider/menu/seleall")
    public JSONObject seleall(@RequestBody HjMenu menu);
    /**
     * 实名制进出看板
     */
    @PostMapping("/provider/inOutKanBan/selectIndex")
    public AjaxResult inOutKanBanSelectIndex(@RequestParam(value = "pid") Integer pid);
    /**
     * 搜索查询
     *
     * @param filed 按名字、设备、电话查询当天的定位信息
     * @return
     */
    @PostMapping("/provider/hireApi/getHireSearch")
    public JSONObject getPeopleAreaSearch(@RequestParam(value = "filed", required = false) String filed,
                                          @RequestParam(value = "projectId") int projectId);
    /**
     * 历史轨迹 按照时间排序
     * @return
     */
    @PostMapping("/provider/hireApi/getHireHistory")
    public JSONObject getHireHistory(@RequestParam(value = "filed", required = false) String filed,
                                     @RequestParam(value = "projectId") int projectId,
                                     @RequestParam(value = "startTime", required = false) String startTime);
    /**
     * 实时监控
     * @return
     * @throws ParseException
     */
    @PostMapping("/provider/hireApi/getHirePeople")
    public JSONObject getHirePeople(@RequestParam(value = "projectId") int projectId);



    /**
     * 实时监控
     * @return
     * @throws ParseException
     */
    @PostMapping("/provider/hireAppApi/getHirePeople")
    public JSONObject getAppHirePeople(@RequestParam(value = "projectId") int projectId);
    /**
     * 搜索查询
     * @return
     */
    @PostMapping("/provider/hireAppApi/getHireByNameSearch")
    public JSONObject getAppHireByNameSearch(@RequestParam(value = "userName", required = false) String userName,
                                             @RequestParam(value = "projectId") int projectId);
    /**
     * 历史记录
     * @return
     */
    @PostMapping("/provider/hireAppApi/getHireByNameHistory")
    public JSONObject getAppHireByNameHistory(@RequestParam(value = "userName", required = false) String userName,
                                              @RequestParam(value = "projectId") int projectId);
    /**
     *  根据人员姓名查询多个判断是否状态：在线/离线
     */
    @PostMapping("/provider/hireAppApi/getHirePeopleList")
    public JSONObject getAppHirePeopleList(@RequestParam(value = "userName", required = false) String userName,
                                           @RequestParam(value = "projectId") int projectId);
    /**
     * app查询所有数据
     * @return
     * */
    @PostMapping( value = "/provider/vehicle/app/selectAll")
    public JSONObject selectVehicleAll(@RequestBody Vehicle vehicle,
                                       @RequestParam(value = "pageNum") String pageNum,
                                       @RequestParam(value = "pageSize") String pageSize);
    /**
     * app查询某车场总数
     * */
    @PostMapping(value = "/provider/vehicle/app/carcount")
    public JSONObject countcar(@RequestBody Vehicle vehicle);
    /**
     *app查询剩余车位
     * @return
     * */
    @PostMapping(value = "/provider/vehicle/app/selectpkcounts")
    public JSONObject parkingspace(@RequestBody HjZhgdPkcount hjZhgdPkcount);
    /**
     * 查询某个车场剩余车位
     * */
    @PostMapping(value = "/provider/vehicle/app/carpkcount")
    public JSONObject carpkcount(@RequestBody HjZhgdPkcount hjZhgdPkcount);


    /**
     * 车牌查询所有数据
     * @return
     * */
    @PostMapping( value = "/provider/parkings/selectAll")
    public JSONObject selectAll(@RequestBody Vehicle vehicle, @RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum);
    /**
     *查询在场车辆
     * @return
     * */
    @PostMapping(value = "/provider/parkings/parking/selectscene")
    public JSONObject selectscene(@RequestBody Vehicle vehicle, @RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum);
    /**
     * 查询剩余车位数
     *
     * @return*/
    @PostMapping(value = "/provider/parkings/selectpkcount")
    public JSONObject selectresidue(@RequestBody HjZhgdPkcount hjZhgdPkcount);
    /**
     * 智慧工地看板1.0
     *
     * @return*/
    @PostMapping(value = "/provider/parkings/todaycount")
    public JSONObject parkingTodaycount(@RequestParam("projectId") Integer projectId);
    /**
     * 扬尘阈值查询
     * @param thresholdValue
     * @return
     */
    @PostMapping("/provider/DustEmissionThresholdValueAPI/getThresholdValue")
    public AjaxResult getThresholdValue(@RequestBody DustEmissionThresholdValue thresholdValue);
    /**
     * 扬尘阈值修改
     * @param thresholdValue
     * @return
     */
    @PostMapping("/provider/DustEmissionThresholdValueAPI/updateThresholdValue")
    public AjaxResult updateThresholdValue(@RequestBody DustEmissionThresholdValue thresholdValue);

    @RequestMapping(value = "/provider/systemuser/pc/test",method = RequestMethod.POST)
    AjaxResult test();
    /**
     * PC登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/provider/systemuser/pc/login",method = RequestMethod.POST)
    AjaxResult pcLogin(HjSystemUser user);
    /**
     * APP登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/provider/systemuser/app/login",method = RequestMethod.POST)
    AjaxResult appLogin(HjSystemUser user);
    /**
     * pc菜单权限
     * @param uid
     * @param appOrPc
     * @return
     */
    @RequestMapping(value = "provider/systemPrivileges/pc/getSystemPrivileges",method = RequestMethod.POST)
    AjaxResult getSystemPrivileges_pc(@RequestParam("uid") Integer uid, @RequestParam("appOrPc") Integer appOrPc, @RequestParam("parentId") Integer parentId);
    /**
     * app账户菜单权限
     * @param uid
     * @param appOrPc
     * @return
     */
    @RequestMapping(value = "provider/systemPrivileges/app/getSystemPrivileges",method = RequestMethod.POST)
    AjaxResult getSystemPrivileges_app(@RequestParam("uid") Integer uid, @RequestParam("appOrPc") Integer appOrPc, @RequestParam("parentId") Integer parentId);

    /**
     * 劳务工人考勤情况
     * @param hjAttendanceRecord 考勤记录表
     * @return
     */
    @RequestMapping(value = "/provider/attendanceRecordApi/selectWorkerAttendance",method = RequestMethod.POST)
    Map<String, Object> selectWorkerAttendance(HjAttendanceRecord hjAttendanceRecord);

    /**
     * 管理人员考勤情况
     * @param hjAttendanceRecord 考勤记录表
     * @return
     */
    @RequestMapping(value = "/provider/attendanceRecordApi/selectAdministration",method = RequestMethod.POST)
    Map<String, Object> selectAdministration(HjAttendanceRecord hjAttendanceRecord);
     /**
     * 人脸考勤
     * @param
     * @return
     */
    @RequestMapping(value = "/provider/attendanceRecordApi/insertAdministration",method = RequestMethod.POST)
    Map<String, Object> insertAdministration(HjAttendanceRecord hjAttendanceRecord);

    /**
     * 1.0项目出勤统计
     * @param
     * @return
     */
    @RequestMapping(value = "/provider/attendanceRecordApi/getNearlyEightDays",method = RequestMethod.POST)
    JSONObject attendanceRecordApiGetNearlyEightDays(@RequestParam("projectId") Integer projectId);
    /**
     * 1.0人员动态+班组动态
     * @param
     * @return
     */
    @RequestMapping(value = "/provider/attendanceRecordApi/getTeamCount",method = RequestMethod.POST)
    JSONObject attendanceRecordApiGetTeamCount(@RequestParam("projectId") Integer projectId);

    /**
     * 现场工种
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/provider/attendanceRecordApi/getWorkType",method = RequestMethod.POST)
     JSONObject attendanceRecordApiGetWorkType(@RequestParam("projectId") Integer projectId);
    /**
     * 分包单位考勤情况
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/provider/attendanceRecordApi/getBuildcompanyData",method = RequestMethod.POST)
    JSONObject attendanceRecordApiGetBuildcompanyData(@RequestParam("projectId") Integer projectId);
    /**
     * 今日劳动曲线1.0
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/provider/attendanceRecordApi/getXS",method = RequestMethod.POST)
    JSONObject attendanceRecordApiGetXS(@RequestParam("projectId") Integer projectId);
    /**
     * 人员信息列 表
     * @param empNameParam
     * @return
     */
    @RequestMapping(value = "/provider/projectWorkersApi/selectProjectWorkers",method = RequestMethod.POST)
    Map<String, Object> selectProjectWorkers(EmpNameParam empNameParam);

    /**
     * 人员信息 详情
     * @param projectWorkersParam
     * @return
     */
    @RequestMapping(value = "/provider/projectWorkersApi/selectProjectWorkersDetails",method = RequestMethod.POST)
    Map<String, Object> selectProjectWorkersDetails(ProjectWorkersParam projectWorkersParam);
    /**
     * 人员信息 所属单位
     * @param projectWorkers
     * @return
     */
    @RequestMapping("/provider/projectWorkersApi/selectConstructionProject")
    Map<String, Object> selectConstructionProject(ProjectWorkers projectWorkers);
    /**
     * 实名制录入
     * @param hjProjectWorkers
     * @return
     */
    @RequestMapping(value = "/provider/projectWorkersApi/insertProjectWorkers",method = RequestMethod.POST)
    Map<String, Object> insertProjectWorkers(HjProjectWorkers hjProjectWorkers);
    /**
     * 人员信息 修改
     * @param hjProjectWorkers
     * @return
     */
    @RequestMapping(value = "/provider/projectWorkersApi/updateProjectWorkers",method = RequestMethod.POST)
    Map<String, Object> updateProjectWorkers(HjProjectWorkers hjProjectWorkers);

    /**
     * 数据字典
     * @param hjDictionaries
     * @return
     */
    @RequestMapping(value = "/provider/dictionariesApi/selectDictionaries",method = RequestMethod.POST)
    Map<String, Object> selectDictionaries(HjDictionaries hjDictionaries);
      /**
     * 数据字典
     * @param
     * @return
     */
    @RequestMapping(value = "/provider/dictionariesApi/selectDictionariesWorkType",method = RequestMethod.POST)
    Map<String, Object> selectDictionariesWorkType(@RequestParam("pid") Integer pid);
    /**
     * 功能描述 :根据id获取下级市区
     * @author Mr.LiuYong
     * @date  2019/5/14 17:46
     * @param id
     * @return java.lang.Object
     */
    @RequestMapping(value = "/provider/area/getArea",method = RequestMethod.POST)
    AjaxResult getArea(@RequestParam("id") Long id);

    /**
     * 保存公司库信息
     * @param
     * @return
     */
    @RequestMapping(value = "/provider/pcCompanyLibrary/insertHjCompanyLibrary",method = RequestMethod.POST)
    int insertHjCompanyLibrary(HjCompanyLibrary hjCompanyLibrary, @RequestParam("parentaId") Integer parentaId);

    /**
     * 根据id查询公司库信息
     * @param
     * @return
     */
    @RequestMapping(value = "/provider/pcCompanyLibrary/selectHjCompanyLibrary",method = RequestMethod.POST)
    HjCompanyLibrary selectHjCompanyLibraryIds(@RequestParam("id") Integer id);
    /**
     * 修改保存公司库信息
     * @param
     * @return
     */
    @RequestMapping(value = "/provider/pcCompanyLibrary/updateHjCompanyLibrary",method = RequestMethod.POST)
    int updateHjCompanyLibrary(HjCompanyLibrary hjCompanyLibrary);
    /**
     * 根据单位类型查询公司库信息列表
     * @param
     * @return
     */
    @RequestMapping(value = "/provider/pcCompanyLibrary/selectHjCompanyLibraryList",method = RequestMethod.POST)
    List<HjCompanyLibrary> selectHjCompanyLibraryList(HjCompanyLibrary hjCompanyLibrary);




    /**
     * 添加项目
     * @param hjProject
     * @param cid
     * @param file
     * @return
     */
    @RequestMapping(value = "/provider/project/addProject",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    AjaxResult addSave(@RequestBody HjProject hjProject, @RequestParam("cid") Integer cid, @RequestParam(value = "file") MultipartFile file);


    /**
     * 人员信息 是否签订
     * @param signParam
     * @return
     */
    @RequestMapping(value = "/provider/projectWorkersApi/selectSignParam",method = RequestMethod.POST)
    Map<String, Object> selectSignParam(SignParam signParam);

    /**
     * 获取银行卡信息
     * @return 身份信息
     */
    @RequestMapping(value = "/provider/projectWorkersApi/getAliOcrBankCard",method = RequestMethod.POST)
    Map<String, Object> getAliOcrBankcard(AliOcrBankCard aliOcrBankCard);

    /**
     * 查询指定公司下公司和项目信息
     * @param
     * @return
     */
    @RequestMapping(value = "/provider/pcCompanyLibrary/selectHjCompanyProjectList",method = RequestMethod.POST)
    Map<String,Object> selectHjCompanyProjectList(@RequestParam("companyId") Integer companyId);


    /**
     * 修改密码
     * @param passwordParam 密码
     * @return id 用户id
     */
    @RequestMapping(value = "/provider/systemuser/app/updateUserPassword",method = RequestMethod.POST)
     Map<String, Object> updateUserPassword(PasswordParam passwordParam);
    /**
     * 切换项目
     * @param userId 人员id
     * @return
     */
    @RequestMapping(value = "/provider/systemuser/app/queryProject",method = RequestMethod.POST)
    Map<String, Object> queryProject(@RequestParam("userId") Integer userId);

    /**
     * 班组分页
     * @param hjTeam
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/provider/pcCompanyLibrary/selectHjTeamList",method = RequestMethod.POST)
    AjaxResult selectHjTeamList(@RequestBody HjTeam hjTeam, @RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum);

    /**
     * 查参建单位下的班组
     * @param hjTeam 参建单位id
     * @return
     */
    @RequestMapping(value ="/provider/teamApi/app/selectTeam",method = RequestMethod.POST)
    Map<String, Object> selectTeam(@RequestBody HjTeam hjTeam);

    /**
     * 查詢项目下参建单位
     * @param projectId 项目id
     * @return
     */
    @RequestMapping(value ="/provider/constructionCompanyApi/selectConstructionCompany",method = RequestMethod.POST)
    Map<String, Object> selectConstructionCompany(@RequestParam("projectId") Integer projectId);
    /**
     * 导出参建单位 数据源
     * @param param
     * @param suid
     * @param projectId
     * @return
     */
    @PostMapping("/provider/constructionCompanyApi/export")
    List<HjConstructionCompany> export(@RequestParam("param") String param, @RequestParam("suid") String suid, @RequestParam("projectId") Integer projectId);
    /**
     * 热门工种
     * @param
     * @return
     */
    @RequestMapping(value ="/provider/dictionariesApi/selectWorkType",method = RequestMethod.POST)
    Map<String, Object> selectWorkType(@RequestBody HjDictionaries hjDictionaries);
    /**
     * 查询对接平台列表
     * @param
     * @return
     * */
    @RequestMapping(value = "/provider/dictionariesApi/cxdjpt",method = RequestMethod.POST)
    JSONObject caydjpt(@RequestBody HjDictionaries hjDictionaries);


    /**
     * 新增保存项目两制同步
     */
    @PostMapping("/provider/synchronizationInformationApi/add")
    Map<String, Object> addSave(@RequestBody HjSynchronizationInformation hjSynchronizationInformation);

    /**
     * 修改保存项目两制同步
     */
    @PostMapping("/provider/synchronizationInformationApi/edit")
    AjaxResult editSave(@RequestBody HjSynchronizationInformation hjSynchronizationInformation);

    /**
     * 删除项目两制同步
     */
    @PostMapping( "/provider/synchronizationInformationApi/remove")
    AjaxResult remove(@RequestParam("ids") String ids);

    /**
     * 创建角色
     * @param hjSystemRole
     * @return
     */
    @RequestMapping(value = "/provider/systemRoleApi/addSystemRole",method = RequestMethod.POST)
   Map<String, Object> insertSystemRole(@RequestBody HjSystemRole hjSystemRole, @RequestParam(value = "ids") String ids);

    /**
     * 修改前显示
     * @param hjSystemRole
     * @return
     */
    @RequestMapping(value = "/provider/systemRoleApi/selectSystemRoleId",method = RequestMethod.POST)
    public Map<String, Object> selectSystemRoleId(@RequestBody HjSystemRole hjSystemRole);
    /**
     * 修改角色
     * @param hjSystemRole
     * @return
     */
    @RequestMapping(value = "/provider/systemRoleApi/updateRole",method = RequestMethod.POST)
    Map<String, Object> updateSystemRole(@RequestBody HjSystemRole hjSystemRole, @RequestParam(value = "ids") String ids);

    /**
     * 删除角色
     * @param ids 角色id(1,2,3)
     * @return
     */
    @RequestMapping(value = "/provider/systemRoleApi/deleteSystemRole",method = RequestMethod.POST)
     Map<String, Object> deleteSystemRole(@RequestParam("ids") String ids);


    /**
     * 角色列表
     * @param systemRoleParam
     * @return
     */
    @RequestMapping(value = "/provider/systemRoleApi/selectSystemRole",method = RequestMethod.POST)
    Map<String, Object> selectSystemRole(@RequestBody RoleParam systemRoleParam);

    /**
     * 项目 或者 集团 公司 有那些角色
     * @param hjSystemRole
     * @return
     */
    @RequestMapping(value = "/provider/systemRoleApi/querySystemRole",method = RequestMethod.POST)
    Map<String, Object> querySystemRole(@RequestBody HjSystemRole hjSystemRole);


    /**
     * 查看账号是否存在
     * @param user
     * @return
     */
    @RequestMapping(value = "/provider/systemuser/pc/selectSystemUser",method = RequestMethod.POST)
    Map<String, Object> selectSystemUser(@RequestBody HjSystemUser user);

    /**
     * 修改前显示
     * @param hjSystemUser
     * @return
     */
    @RequestMapping(value = "/provider/systemuser/pc/selectUserId",method = RequestMethod.POST)
    public Map<String, Object> selectUserId(@RequestBody HjSystemUser hjSystemUser);
    /**
     * 创建账号
     * @param systemUserParam
     * @return
     */
    @RequestMapping(value = "/provider/systemuser/pc/insertSystemUser",method = RequestMethod.POST)
    Map<String, Object> insertSystemUser(@RequestBody SystemUserParam systemUserParam);

    /**
     * 修改账号
     * @param hjSystemUser
     * @return
     */
    @RequestMapping(value = "/provider/systemuser/pc/updateUser",method = RequestMethod.POST)
    Map<String, Object> updateSystemUser(@RequestBody HjSystemUser hjSystemUser, @RequestParam("ids") String ids);

    /**
     * 删除账号
     * @param ids 角色id(1,2,3)
     * @return
     */
    @RequestMapping(value = "/provider/systemuser/pc/deleteSystemUser",method = RequestMethod.POST)
    Map<String, Object> deleteSystemUser(@RequestParam("ids") String ids);

    /**
     * 列表账号
     * @param userParam
     * @return
     */
    @RequestMapping(value = "/provider/systemuser/pc/querySystemUser",method = RequestMethod.POST)
    Map<String, Object> querySystemUser(@RequestBody UserParam userParam);

    /**
     * pc考勤列表
     * @param
     * @return
     */
    @RequestMapping(value = "/provider/attendanceRecordPcApi/selectAttendanceRecordList",method = RequestMethod.POST)
    Map<String,Object> selectAttendanceRecordListTwo(@RequestBody Param param, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);
    /**
     * 同步人员 进出或退场
     * @param tag
     * @param ids
     * @return
     */
    @PostMapping(value = "/provider/pc/projectWorkersApi/outOrIn")
   Map<String,Object> outOrIn(@RequestParam("tag") Integer tag, @RequestParam("ids") String ids);

    /**
     * 查询权限列表
     * @param systemRoleParam
     * @return
     */
    @RequestMapping(value = "/provider/systemPrivileges/pc/selectSystemPrivileges")
    public Map<String, Object> selectSystemPrivileges(@RequestBody SystemRoleParam systemRoleParam);

    /**
     * 查询权限列表
     * @return
     */
    @PostMapping(value = "/provider/systemPrivileges/pc/getPrivilegesList")
    public JSONObject getPrivilegesList(@RequestParam("userId") Integer userId);
    /**
     * 查询全部
     * @param hjSystemPrivileges
     * @return
     */
    @RequestMapping(value = "/provider/systemPrivileges/pc/querySystemPrivileges")
    public Map<String, Object> querySystemPrivileges(@RequestBody HjSystemPrivileges hjSystemPrivileges);
    /**
     * 导出工人
     * @param hjProjectWorkers
     * @return
     */
    @PostMapping(value = "/provider/pc/projectWorkersApi/export" )
    List<ProjectWorkerPC> export(@RequestBody HjProjectWorkers hjProjectWorkers);
    /**
     * 导出两制服务工人信息
     * @param hjWorkersInformation
     * @return
     */
    @PostMapping(value = "/provider/workersInformationAp/export" )
    List<HjWorkersInformationPc> export(@RequestBody HjWorkersInformation hjWorkersInformation);
    /**
     * 获取合同统计
     * @param projectId
     * @return
     */
    @PostMapping("/provider/pc/projectWorkersApi/getDataCount")
     JSONObject projectWorkersApiGetDataCount(@RequestParam(value = "projectId") Integer projectId);
    /**
     * 获取合同统计
     * @param projectId
     * @return
     */
    @PostMapping("/provider/pc/projectWorkersApi/getKQCount")
     JSONObject projectWorkersApiGetKQCount(@RequestParam(value = "projectId") Integer projectId);
    /**
     * 导出班组数据源
     * @param hjTeam
     * @return
     */
    @PostMapping("/provider/pcCompanyLibrary/export")
    List<HjTeam> export(@RequestBody HjTeam hjTeam);

    /**
     * 导出考勤数据源
     * @param param
     * @return
     */
    @PostMapping("/provider/attendanceRecordPcApi/export")
    List<Param> export(@RequestBody Param param);

    /**
     * 导出车辆进出数据
     * @param vehicle
     * @return
     */
    @PostMapping("/provider/parkings/selectAlls")
    List<VehiclePc> export(@RequestBody Vehicle vehicle);

    /**
     * 导出两制服务工作汇报
     * @param
     * @return
     * */
    @PostMapping("/provider/baogao/export")
    List<HjReportPc> export(@RequestBody HjReport hjReport);

    /**
     * 根据id查询项目信息
     * 考勤统计
     * @param
     * @return
     */
    @PostMapping("/provider/pcLzIndex/selectIndex")
    AjaxResult selectIndex(@RequestParam("pid") Integer pid);


    /**
     * pdf导出查询
     * @param ids
     * @return
     */
    @PostMapping("/provider/pc/projectWorkersApi/selectPdfWorkers")
   List<PdfWorkers> selectPdfWorkers(@RequestParam("ids") String ids);

    /**
     * 功能描述 :接收上传的考勤记录
     * @author Mr.LiuYong
     * @date  2019/5/14 9:02
     * @return com.hujiang.framework.web.domain.AjaxResult
     */
    @PostMapping(value = "/api/moredian/record")
    AjaxResult record(@RequestParam("json") String json);

    /**
     * 根据项目id查询项目扬尘设备列表
     * @param projectId
     * @return
     */
    @PostMapping("/provider/ProjectDustEmission/getProjectDustEmission")
    JSONObject getProjectDustEmission(@RequestParam(value = "projectId") Long projectId);
    /**
     * 查询项目对应的扬尘设备SN列表
     */
    @PostMapping("/provider/ProjectDustEmission/projectDustEmissionList")
    public AjaxResult projectDustEmissionList(@RequestBody SbProjectDustEmission sbProjectDustEmission,
                                              @RequestParam(value = "pageSize") Integer pageSize,
                                              @RequestParam(value = "pageNum") Integer pageNum);
    /**
     * 新增保存项目对应的扬尘设备SN
     */
    @PostMapping("/provider/ProjectDustEmission/projectDustEmissionAddSave")
    public AjaxResult projectDustEmissionAddSave(@RequestBody SbProjectDustEmission sbProjectDustEmission);
    /**
     * 根据id查询
     */
    @PostMapping("/provider/ProjectDustEmission/projectDustEmissionById")
    public AjaxResult projectDustEmissionById(@RequestParam(value = "id") Long id);
    /**
     * 修改保存项目对应的扬尘设备SN
     */
    @PostMapping("/provider/ProjectDustEmission/projectDustEmissionEditSave")
    public AjaxResult projectDustEmissionEditSave(@RequestBody SbProjectDustEmission sbProjectDustEmission);
    /**
     * 删除项目对应的扬尘设备SN
     */
    @PostMapping( "/provider/ProjectDustEmission/remove")
    public AjaxResult projectDustEmissionRemove(@RequestParam(value = "id") Integer id, @RequestParam(value = "devCcrq", required = false) String devCcrq);
    /**
     * APP根据项目id查询项目扬尘设备列表
     * @param projectId
     * @return
     */
    @PostMapping("/provider/appProjectDustEmission/getAppProjectDustEmission")
    JSONObject getAppProjectDustEmission(@RequestParam(value = "projectId", required = false) Long projectId);

    /**
     * 查询扬尘记录
     * @param sn sn编号
     * @param tag 0 不合格   1合格
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param pageNum 当前页
     * @param pageSize 每页大小
     * @return
     */
    @PostMapping("/provider/DustEmission/getDustEmission")
    JSONObject getDustEmission(@RequestParam(value = "sn") String sn,
                               @RequestParam(value = "tag", required = false) Integer tag,
                               @RequestParam(value = "startTime", required = false) String startTime,
                               @RequestParam(value = "endTime", required = false) String endTime,
                               @RequestParam(value = "pageNum") Integer pageNum,
                               @RequestParam(value = "pageSize") Integer pageSize);
    /**
     * 获取绿色施工TSP数据
     * @param sn
     * @return
     */
    @PostMapping("/provider/DustEmission/getPM25AndPN10")
    JSONObject getPM25AndPN10(@RequestParam(value = "sn") String sn, @RequestParam(value = "projectId") Integer projectId);
    /**
     * Excel数据源
     * @param sn
     * @param startTime
     * @param endTime
     * @return
     */
    @PostMapping("/provider/DustEmission/getExcel")
    List<SbDustEmission> getExcel(@RequestParam(value = "sn") String sn,
                                  @RequestParam(value = "startTime", required = false) String startTime,
                                  @RequestParam(value = "endTime", required = false) String endTime);

    /**
     *  看板1.0TSP数据
     * @param projectId
     * @return
     */
    @PostMapping("/provider/DustEmission/Tsp")
    public JSONObject tsp(@RequestParam(value = "projectId") long projectId);

    @PostMapping("/provider/DustEmission/getTSP")
    public JSONObject getDustUserList(@RequestParam("projectId") Integer projectId,
                                      @RequestParam(value = "filed", required = false) String filed);
    /**
     * 根据项目id获取项目视频区
     * @param projectId
     * @return
     */
    @PostMapping("/provider/ProjectVideoAreaApi/getProjectVideoArea")
    JSONObject getProjectVideoArea(@RequestParam(value = "projectId") Integer projectId);
    /**
     * 查询项目视频区列表
     */
    @PostMapping("/provider/ProjectVideoAreaApi/list")
    public AjaxResult projectVideoAreaList(@RequestBody SbProjectVideoArea sbProjectVideoArea,
                                           @RequestParam(value = "pageNum") Integer pageNum,
                                           @RequestParam(value = "pageSize") Integer pageSize);
    /**
     * 新增保存项目视频区
     */
    @PostMapping("/provider/ProjectVideoAreaApi/add")
    public AjaxResult projectVideoAreaAddSave(@RequestBody SbProjectVideoArea sbProjectVideoArea);
    /**
     * 修改前查询
     */
    @PostMapping("/provider/ProjectVideoAreaApi/edit")
    public AjaxResult projectVideoAreaEdit(@RequestParam(value = "id") Integer id);
    /**
     * 修改保存项目视频区
     */
    @PostMapping("/provider/ProjectVideoAreaApi/editSave")
    public AjaxResult projectVideoAreaEditSave(@RequestBody SbProjectVideoArea sbProjectVideoArea);
    /**
     * 删除项目视频区
     */
    @PostMapping( "/provider/ProjectVideoAreaApi/remove")
    public AjaxResult projectVideoAreaRemove(@RequestParam(value = "ids") String ids);
    /**
     * APP根据项目id获取项目视频区
     * @param projectId
     * @return
     */
    @PostMapping("/provider/appProjectVideoAreaApi/getAppProjectVideoArea")
    JSONObject getAppProjectVideoArea(@RequestParam(value = "projectId") Integer projectId);

    /**
     * 根据项目视频区id获取视频信息
     * @param areaId
     * @return
     */
    @PostMapping("/provider/ProjectVideo/getProjectVideo")
    public JSONObject getProjectVideo(@RequestParam(value = "areaId") Integer areaId);
    /**
     * 删除项目视频
     */
    @PostMapping( "/provider/ProjectVideo/deleteSbProjectVideoByIds")
    public AjaxResult deleteSbProjectVideoByIds(@RequestParam(value = "ids") String ids);
    /**
     * 查询工区视频列表
     */
    @PostMapping("/provider/ProjectVideo/projectVideoList")
    public AjaxResult projectVideoList(@RequestBody SbProjectVideo sbProjectVideo,
                                       @RequestParam(value = "pageNum") Integer pageNum,
                                       @RequestParam(value = "pageSize") Integer pageSize);
    /**
     * 查询项目所有视频列表
     */
    @PostMapping("/provider/ProjectVideo/selectSbProjectVideoByProjectId")
    public AjaxResult selectSbProjectVideoByProjectId(@RequestParam(value = "projectId") Integer projectId,
                                                      @RequestParam(value = "pageNum") Integer pageNum,
                                                      @RequestParam(value = "pageSize") Integer pageSize);
    /**
     * 新增保存项目视频
     */
    @PostMapping("/provider/ProjectVideo/projectVideoAddSave")
    public AjaxResult  projectVideoAddSave(@RequestBody SbProjectVideo sbProjectVideo);
    /**
     * 根据id查询视频信息
     */
    @PostMapping("/provider/ProjectVideo/selectProjectVideoById")
    public AjaxResult selectProjectVideoById(@RequestParam(value = "id") Integer id);
    /**
     * 修改保存项目视频
     */
    @PostMapping("/provider/ProjectVideo/projectVideoEditSave")
    public AjaxResult projectVideoEditSave(@RequestBody SbProjectVideo sbProjectVideo);

    @PostMapping("/provider/ProjectVideo/ysCloudControldirection")
    public void ysCloudControldirection(@RequestParam(value = "pid") Integer pid,@RequestParam(value = "deviceSerial") String deviceSerial,@RequestParam(value = "direction") Integer direction);
    /**
     * 电箱数据分页
     * @param electricityBoxId
     * @param startTime
     * @param endTime
     * @return
     */
    @PostMapping("/provider/currentTemperatureApi/list")
    public JSONObject currentTemperatureList(@RequestParam(value = "electricityBoxId") String electricityBoxId,
                                             @RequestParam(value = "startTime", required = false) String startTime,
                                             @RequestParam(value = "endTime", required = false) String endTime,
                                             @RequestParam(value = "pageNum") Integer pageNum,
                                             @RequestParam(value = "pageSize") Integer pageSize);
    /**
     * 根据项目id获取电箱设备编号
     * @param projectId
     * @return
     */
    @PostMapping("/provider/ProjectElectricityBox/getProjectElectricityBox")
    public JSONObject getProjectElectricityBox(@RequestParam(value = "projectId") Integer projectId);
    /**
     * 查询项目电箱列表
     */
    @PostMapping("/provider/ProjectElectricityBox/list")
    public AjaxResult list(@RequestBody SbProjectElectricityBox sbProjectElectricityBox,
                           @RequestParam(value = "pageNum") Integer pageNum,
                           @RequestParam(value = "pageSize") Integer pageSize);
    /**
     * 添加电箱
     * @param sbProjectElectricityBox
     * @return
     */
    @PostMapping("/provider/ProjectElectricityBox/addSave")
    public AjaxResult addSave(@RequestBody SbProjectElectricityBox sbProjectElectricityBox);
    /**
     * 添加电箱
     * @return
     */
    @PostMapping("/provider/ProjectElectricityBox/addElectricityBox")
    public AjaxResult addElectricityBox(@RequestParam(value = "projectId") Integer projectId,
                                        @RequestParam(value = "electricityBoxId") String electricityBoxId,
                                        @RequestParam(value = "electricityBoxName") String electricityBoxName);

    /**
     * 修改前查询
     */
    @PostMapping("/provider/ProjectElectricityBox/edit")
    public AjaxResult edit(@RequestParam("id") Integer id);
    /**
     * 修改保存项目电箱
     */
    @PostMapping("/provider/ProjectElectricityBox/editSave")
    public AjaxResult editSave(@RequestBody SbProjectElectricityBox sbProjectElectricityBox);
    /**
     * 删除项目电箱
     */
    @PostMapping( "/provider/ProjectElectricityBox/remove")
    public AjaxResult projectElectricityBoxRemove(@RequestParam("id") Integer id, @RequestParam(value = "devCcrq", required = false) String devCcrq);
    /**
     * APP根据项目id获取电箱设备编号
     * @param projectId
     * @return
     */
    @PostMapping("/provider/appProjectElectricityBox/getAppProjectElectricityBox")
    public JSONObject getAppProjectElectricityBox(@RequestParam(value = "projectId") Integer projectId);
     @PostMapping("/provider/appProjectElectricityBox/getBoxList")
    public AjaxResult getBoxList(@RequestParam(value = "pid") Integer pid);
    /**
     * 电箱导出Excel数据源
     * @param electricityBoxId
     * @param startTime
     * @param endTime
     * @return
     */
    @PostMapping(value = "/provider/currentTemperatureApi/getExcel")
    public List<SbCurrentTemperature> getSbCurrentTemperatureExcel(@RequestParam(value = "electricityBoxId") String electricityBoxId,
                                                                   @RequestParam(value = "startTime", required = false) String startTime,
                                                                   @RequestParam(value = "endTime", required = false) String endTime);

    /**
     * 智能电箱界面数据
     * @param electricityBoxId
     * @param projectId
     * @return
     */
    @PostMapping(value = "/provider/currentTemperatureApi/getEquipmentInformation")
    public JSONObject getEquipmentInformation(@RequestParam(value = "electricityBoxId") String electricityBoxId,
                                              @RequestParam(value = "projectId") Integer projectId);
    /**
     * 智能电箱界面数据
     * @param projectId
     * @return
     */
    @PostMapping(value = "/provider/currentTemperatureApi/kanban")
    public JSONObject currentTemperatureApiKanban(@RequestParam(value = "projectId") Integer projectId);

    /**
     * 查询黑名单列表
     */
    @PostMapping("/provider/hjBlacklist/getBlacklist")
    public JSONObject getBlacklist(@RequestBody HjBlacklist hjBlacklist, @RequestParam(value = "pageNum") Integer pageNum, @RequestParam(value = "pageSize") Integer pageSize);
    /**
     * 新增保存黑名单
     */
    @PostMapping("/provider/hjBlacklist/addBlacklist")
    public JSONObject addBlacklist(@RequestBody HjBlacklist hjBlacklist);

    /**
     * 根据项目id查询日志
     * @param projectId
     * @return
     */
    @PostMapping("/provider/HjLogging/getLog")
    public JSONObject getLog(@RequestParam(value = "projectId") Integer projectId,
                             @RequestParam(value = "pageNum") Integer pageNum,
                             @RequestParam(value = "pageSize") Integer pageSize,
                             @RequestParam(value = "startTime", required = false) String startTime,
                             @RequestParam(value = "endTime", required = false) String endTime,
                             @RequestParam(value = "userName", required = false) String userName);
    /**
     * 根据编号删除记录
     * @param ids
     * @return
     */
    @PostMapping( "/provider/HjLogging/remove")
    public JSONObject removeLog(@RequestParam(value = "ids") String ids);

    /**
     * 查询扬尘记录
     * @param sn sn编号
     * @param dateTime 时间
     * @return
     */
    @PostMapping("/provider/appDustEmission/getDustEmission")
    public JSONObject getDustEmission(@RequestParam(value = "sn") String sn,
                                      @RequestParam(value = "pageNum") Integer pageNum,
                                      @RequestParam(value = "pageSize") Integer pageSize,
                                      @RequestParam(value = "dateTime", required = false) String dateTime);
    /**
     * 获取TSP界面数据
     * @param sn
     * @return
     */
    @PostMapping("/provider/appDustEmission/getPM25AndPN10")
    public JSONObject getAppPM25AndPN10(@RequestParam(value = "sn") String sn, @RequestParam(value = "projectId") Integer projectId);

    /**
     * 智能电箱界面数据
     * @param electricityBoxId 设备编号
     * @return
     */
    @PostMapping(value = "/provider/appCurrentTemperature/getEquipmentInformation")
    public JSONObject getEquipmentInformation(@RequestParam(value = "electricityBoxId") String electricityBoxId);
    /**
     * 电箱数据分页
     * @return
     */
    @PostMapping("/provider/appCurrentTemperature/list")
    public JSONObject list(@RequestParam(value = "sn") String sn,
                           @RequestParam(value = "dateTime", required = false) String dateTime,
                           @RequestParam(value = "pageNum") Integer pageNum,
                           @RequestParam(value = "pageSize") Integer pageSize);
    /**
     * 导出Excel数据源
     * @param projectId
     * @param startTime
     * @param endTime
     * @param userName
     * @return
     */
    @PostMapping("/provider/HjLogging/getLoggingExcel")
    public List<HjLogging> getLoggingExcel(@RequestParam(value = "projectId") Integer projectId,
                                           @RequestParam(value = "startTime", required = false) String startTime,
                                           @RequestParam(value = "endTime", required = false) String endTime,
                                           @RequestParam(value = "userName", required = false) String userName);

    /**
     *创建文件夹
     * @param folder
     * @return
     */
    @PostMapping("/provider/folder/createFolder")
    public Map<String,Object> createFolder(@RequestBody HjFolder folder);

    /**
     * 获取文件夹列表
     * @param folder
     * @return
     */
    @PostMapping("/provider/folder/folderList")
    public Map<String,Object> folderList(@RequestBody HjFolder folder);

    /**
     * 删除文件夹
     * @param ids
     * @return
     */
    @PostMapping("/provider/folder/removeFolder")
    public Map<String,Object> removeFolder(@RequestParam(value = "ids") String ids);

    /**
     * 文件列表
     * @param folderId
     * @return
     */
    @PostMapping(value = "/provider/FileApi/getFileList")
    public Map<String,Object> getFileList(@RequestParam(value = "folderId") Integer folderId, @RequestParam(value = "pageNum") Integer pageNum,
                                          @RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "fileName", required = false) String fileName);

    /**
     * 删除文件
     * @param ids
     * @return
     */
    @PostMapping("/provider/FileApi/deleteFile")
    public  Map<String,Object> deleteFile(@RequestParam(value = "ids") String ids);

    /**
     * 出场
     * @return
     */
    @PostMapping("/provider/parking/uploadcarout")
    public Map<String,Object> uploadcarout(@RequestBody UploadCarout uploadCarout);

    /**
     * 入场
     * @return
     */
    @PostMapping("/provider/parking/uploadcarin")
    public Map<String,Object> uploadcarin(@RequestBody UploadCarin uploadCarin);

    /**
     * 文件
     * @return
     */
    @PostMapping("/provider/parking/uploadfile")
    public Map<String,Object> file(@RequestBody UploadFile uploadFile);
    /**
     * 车位
     * @return
     * */
    @PostMapping("/provider/parking/parkingspace")
    public Map<String,Object> parkingspaces(@RequestBody Parkingspace parkingspace);
    /**
     * 第三方考勤机设备上传考勤记录
     * @param object
     * @return
     */
    @PostMapping("/provider/FaceAttendanceAPI/getAttendance")
    public Map<String,Object> getAttendance(@RequestBody SbApiFaceAttendance object);

    /**
     * 升降机注册帧
     */
    @RequestMapping(value="/provider/zhgd/LoginDataCrane",method = RequestMethod.POST)
    public JSONObject  loginDataCrane(@RequestBody String json);

    /**
     * 上报基础信息
     */
    @RequestMapping(value="/provider/zhgd/BaseDataCrane",method = RequestMethod.POST)
    public JSONObject  baseDataCrane(@RequestBody String json);

    /**
     * 接收德业塔吊设备实时信息
     */
    @RequestMapping(value="/provider/zhgd/RealtimeDataCrane",method = RequestMethod.POST)
    public JSONObject  setCraneData(@RequestBody String json);

    /**
     * 2.4上报深圳版塔机报警数据
     */
    @RequestMapping(value="/provider/zhgd/ShenZhenAlarmDataCrane",method = RequestMethod.POST)
    public JSONObject  shenZhenAlarmDataCrane(@RequestBody String json);
    /**
     * 2.5上报GPS定位数据
     */
    @RequestMapping(value="/provider/zhgd/GpsData",method = RequestMethod.POST)
    public JSONObject  gpsData(@RequestBody String json);

    /**
     * 2.6上报设备运行时长
     */
    @RequestMapping(value="/provider/zhgd/RuntimeData",method = RequestMethod.POST)
    public JSONObject  runtimeData(@RequestBody String json);

    /**
     * 2.7上报塔机工作循环数据
     */
    @RequestMapping(value="/provider/zhgd/WorkDataCrane",method = RequestMethod.POST)
    public JSONObject  workDataCrane(@RequestBody String json);
    /**
     * 2.8上报塔机报警数据
     */
    @RequestMapping(value="/provider/zhgd/AlarmDataCrane",method = RequestMethod.POST)
    public JSONObject  alarmDataCrane(@RequestBody String json);
    /**
     * 2.9上报司机打卡记录信息
     */

    @RequestMapping(value="/provider/zhgd/OperatorRecord",method = RequestMethod.POST)
    public JSONObject  operatorRecord(@RequestBody String json);

    /**
     *22.6上报升降机工作循环数据
     */
    @RequestMapping(value="/provider/zhgd/WorkDataElevator",method = RequestMethod.POST)
    public JSONObject  workDataElevator(@RequestBody String json);
    /**
     * 接收升降机实时信息
     */
    @RequestMapping(value="/provider/zhgd/RealtimeDataElevator",method = RequestMethod.POST)
    public JSONObject  realtimeDataElevator(@RequestBody String json);
    /**
     *上报升降机基础参数
     */
    @RequestMapping(value="/provider/zhgd/BaseDataElevator",method = RequestMethod.POST)
    public JSONObject  baseDataElevator(@RequestBody String json);
    /**
     * 升降机注册帧
     */
    @RequestMapping(value="/provider/zhgd/LoginDataElevator",method = RequestMethod.POST)
    public JSONObject  loginDataElevator(@RequestBody String json);

    @RequestMapping(value = "/provider/craneApi/selectIndex",method = RequestMethod.POST)
    public Map<String, Object> selectIndex(@RequestParam(value = "pid") Integer pid, @RequestParam(value = "time") String time, @RequestParam(value = "hxzid") String hxzid);
    /**
     * 切换设备
     * @param scb
     * @return
     */
    @PostMapping("/provider/craneApi/switchDevice")
    public AjaxResult switchDevice(@RequestBody SbCraneBinding scb);
    /**
     * 历史记录
     * @param time
     * @param hxzid
     * @param status 0表示不合格
     * @return
     */
    @PostMapping("/provider/craneApi/historyRecord")
    public AjaxResult historyRecord(@RequestParam(value = "time", required = false) String time,
                                    @RequestParam(value = "hxzid") String hxzid,
                                    @RequestParam(value = "pageNum") String pageNum,
                                    @RequestParam(value = "pageSize") String pageSize,
                                    @RequestParam(value = "status", required = false) String status);

    /**
     * 塔吊导出历史记录
     * @param time
     * @param hxzid
     * @return
     */
    @PostMapping("/provider/craneApi/historyRecordExcel")
    public  List<SbCraneAddrecord> historyRecordExcel(@RequestParam(value = "time") String time,
                                                      @RequestParam(value = "hxzid") String hxzid);

    /**
     * 升降机界面接口
     * @param pid
     * @param hxzid
     * @return
     */
    @PostMapping("/provider/elevatorApi/selectIndex")
    public AjaxResult selectIndex(@RequestParam(value = "pid") Integer pid, @RequestParam(value = "hxzid") String hxzid);


    /**
     * 升降机历史记录
     * @param time
     * @param hxzid
     * @param status 0表示不合格
     * @return
     */
    @PostMapping("/provider/elevatorApi/historyRecord")
    public AjaxResult elevatorHistoryRecord(@RequestParam(value = "time") String time,
                                            @RequestParam(value = "hxzid") String hxzid,
                                            @RequestParam(value = "status") String status,
                                            @RequestParam(value = "pageNum") String pageNum,
                                            @RequestParam(value = "pageSize") String pageSize);

    /**
     * 升降机数据导出
     * @param time
     * @param hxzid
     * @return
     */
    @PostMapping("/provider/elevatorApi/historyRecordExcel")
    public  List<SbElevatorAddrecord> elevatorHistoryRecordExcel(@RequestParam(value = "time") String time,
                                                                 @RequestParam(value = "hxzid") String hxzid);
    /**
     * 切换设备
     * @param pid
     * @return
     */
    @PostMapping("/provider/elevatorApi/switchDevice")
    public AjaxResult elevatorSwitchDevice(@RequestParam(value = "pid") Integer pid);

    /**
     * 考勤报表数据
     * @param projectId
     * @return
     */
    @PostMapping("/provider/kqbb/getKqbbList")
    public List<Kqbb> getKqbbList(@RequestParam(value = "projectId") Integer projectId, @RequestParam(value = "time") String time);

    @PostMapping("/provider/kqbb/getKqbbListBb")
    public List<BG> getKqbbListBb(@RequestParam(value = "projectId") Integer projectId);

    /**
     * app升降机
     * @param deviceId
     * @return
     */
    @PostMapping(value = "/provider/appElevatorAddRecord/getElevatorAddRecord")
    public JSONObject getElevatorAddRecord(@RequestParam(value = "deviceId") String deviceId, @RequestParam(value = "projectId") Integer projectId);

    /**
     * 升降机切换设备
     * @return
     */
    @PostMapping(value = "/provider/appElevatorAddRecord/getElevatorHxzId")
    public JSONObject getElevatorHxzId(@RequestParam(value = "projectId") int projectId);
    /**
     * 升降机看板接口
     * @return
     */
    @PostMapping(value = "/provider/appElevatorAddRecord/crane")
    public JSONObject appElevatorAddRecordCrane(@RequestParam(value = "pid") Integer projectId);
    /**
     * app塔吊界面
     * @return
     */
    @PostMapping(value = "/provider/appCraneAddRecord/getCraneAddRecord")
    public JSONObject getCraneAddRecord(@RequestParam(value = "deviceId") String deviceId,
                                        @RequestParam(value = "projectId") Integer projectId);

    /**
     * app塔吊历史记录
     * @return
     */
    @PostMapping(value = "/provider/appCraneAddRecord/getCraneAddRecordHistory")
    public JSONObject getCraneAddRecordHistory(@RequestParam(value = "deviceId") String deviceId,
                                               @RequestParam(value = "pageNum") Integer pageNum,
                                               @RequestParam(value = "pageSize") Integer pageSize,
                                               @RequestParam(value = "dateTime", required = false) String dateTime);

    /**
     * 塔吊切换设备
     * @return
     */
    @PostMapping(value = "/provider/appCraneAddRecord/getCraneHxzId")
    public JSONObject getCraneHxzId(@RequestParam(value = "projectId") int projectId);
    /**
     * 智慧工地1.0看板 塔吊
     * */
    @PostMapping(value = "/provider/appCraneAddRecord/kanban")
    public JSONObject appCraneAddRecordKanban(@RequestParam(value = "pid") Integer projectId);
    /**
     * 集团看板

     * @return
     */
    @PostMapping(value = "/provider/project/selectListProjectArea")
       Map<String, Object> selectListProjectArea(@RequestParam(value = "companyId") Integer companyId, @RequestParam(value = "region") String region);
    /**
     * 查询子公司列表
     * @param
     * @return
     */
    @PostMapping("/provider/pcCompanyLibrary/selectHjCompanyList")
      List<HjCompanyLibrary> selectHjCompanyList(@RequestParam(value = "companyId") Integer companyId);




    /**
     * 智慧工地1.0看板，工程概括
     * */
    @PostMapping(value = "/provider/project/getXmzk")
    public JSONObject kanban(@RequestParam("id") Integer id);

    /**
     * 智慧工地1.0看板，安全文明施工天数
     * */
    @PostMapping(value = "/provider/project/day")
    public JSONObject day(@RequestParam("id") Integer id);
    /**
     * 智慧工地1.0，工人上工情况
     * */
    @PostMapping(value = "/provider/attendanceRecordApi/TheWorkersWork")
    public JSONObject TheWorkersWork(@RequestParam("projectId") Integer projectId);

    /**
     * 智慧工地1.0，人员定位-电子围栏
     * */
    @PostMapping(value = "/provider/hireApi/edit")
    public JSONObject updateRadius(@RequestBody SbArea sbArea);
    @PostMapping(value = "/provider/Subscribe/Verify")
    public void hqRecord(@RequestBody String json);
    /**
     * 集团看板统计信息
     */
    @PostMapping(value = "/provider/project/selectProjectArea")
    public Map<String,Object> selectProjectArea(@RequestParam(value = "companyId") Integer companyId, @RequestParam(value = "region") String region);

    /**
     * 集团看板统计信息
     */
    @PostMapping(value = "/provider/project/selectProjectAreaS")
    public Map<String,Object> selectProjectAreaS(@RequestParam(value = "companyId") Integer companyId);

    /**
     * 集团端地图搜索项目
     * */
    @PostMapping(value = "/provider/project/selectProjects")
    public JSONObject selectProjects(@RequestBody HjProject hjProject);

    @PostMapping(value = "/provider/project/selectProjectRegion")
    public JSONObject selectProjectRegion(@RequestBody HjProject hjProject);
    @PostMapping(value = "/provider/project/selectHjProject")
    public JSONObject selectHjProject(@RequestBody HjProject hjProject);

    /**
     * 查询关键节点列表
     */
    @PostMapping(value = "/provider/Node/selectCruxZhNode")
    public AjaxResult selectCruxZhNode(@RequestBody ZhNode node);

    /**
     * 查询即将开始节点列表
     */
    @PostMapping(value = "/provider/Node/selectWarningZhNode")
    public AjaxResult selectWarningZhNode(@RequestBody ZhNode node);

    /**
     * 查询即将开始节点列表
     */
    @PostMapping(value = "/provider/Node/selectBeginZhNode")
    public AjaxResult selectBeginZhNode(@RequestBody ZhNode node);


    /**
     * 查询即将结束节点列表
     */
    @PostMapping(value = "/provider/Node/selectEndZhNode")
    public AjaxResult selectEndZhNode(@RequestBody ZhNode node);



    /**
     * 首页查询进度计划列表
     */
    @PostMapping(value = "/provider/Node/selectZhProgressPlan")
    public AjaxResult selectZhProgressPlan(@RequestBody ZhProgressPlan zhProgressPlan);

    /**
     * 删除进度中的关联节点
     */
    @PostMapping(value = "/provider/Node/editNodeWithProgress")
    public AjaxResult editNodeWithProgress(@RequestBody ZhProgressNode zhProgressNode);



    /**
     * 查询计划中关联节点列表
     */
    @PostMapping(value = "/provider/Node/selectZhNodeProgressList")
    public AjaxResult selectZhNodeProgressList(@RequestBody ZhProgressNode zhProgressNode);

    /**
     * 集团看板公司列表
     */
    @PostMapping(value = "/provider/project/selectAreaProjectList")
    public AjaxResult selectAreaProjectList(@RequestParam(value = "companyId") Integer companyId, @RequestParam(value = "region") String region);


    /**
     * 获取未录进设备的人员信息
     * @param deviceNo
     * @param pid
     * @return
     */
    @PostMapping(value = "/provider/instructions/getPWD")
    public List<HjProjectWorkers> getPWD(@RequestParam(value = "deviceNo") String deviceNo, @RequestParam(value = "pid") String pid);
    /**
     * 保存录进设备的人脸
     */
    @PostMapping(value = "/provider/instructions/setPWD")
    public int setPWD(@RequestBody HjDeviceProjectworkers hjDeviceProjectworkers);
    /**
     * 清除录进设备的人脸
     */
    @PostMapping(value = "/provider/instructions/clean")
    public List<HjDeviceProjectworkers> clean(@RequestParam(value = "deviceNo") String deviceNo);
 /**
     * 删除记录
     */
    @PostMapping(value = "/provider/instructions/deleteId")
    public void deleteId(@RequestParam(value = "id") Integer id);

    @PostMapping(value = "/provider/instructionsXm/xm")
    public JSONObject xm(@RequestParam(value = "deviceNo") String deviceNo);

    @PostMapping(value = "/provider/instructionsXm/feedBack")
    public void feedBack(@RequestBody String json);


    /**
     * 导出节点计划所有列表
     */
    @PostMapping(value = "/provider/Node/exportZhProgressPlan")
    public List<ZhNodePc> exportZhProgressPlan(@RequestParam(value = "progressId") int progressId);
    /**
     * 查询进度节点列表
     */
    @PostMapping(value = "/provider/Node/selectZhNodeList")
    public AjaxResult selectZhNodeList(@RequestBody ZhNode node);
    /**
     * 查询计划节点关联列表
     */
    @PostMapping(value = "/provider/Node/selectZhProgressNodeList")
    public AjaxResult selectZhProgressNodeList(@RequestBody ZhProgressNode zhProgressNode);
    /**
     * 查询进度计划列表
     */
    @PostMapping(value = "/provider/Node/selectZhProgressPlanList")
    public AjaxResult selectZhProgressPlanList(@RequestBody ZhProgressPlan zhProgressPlan);
    /**
     * 查询前置节点列表
     */
    @PostMapping(value = "/provider/Node/selectZhPreposeList")
    public AjaxResult selectZhPreposeList(@RequestBody ZhPrepose zhPrepose);
    /**
     * 新增保存节点计划
     */
    @PostMapping(value = "/provider/Node/addNode")
    public AjaxResult addNode(@RequestBody ZhNode zhNode);
    /**
     * 新增保存进度计划
     */
    @PostMapping(value = "/provider/Node/addProgressPlan")
    public AjaxResult addProgressPlan(@RequestBody ZhProgressPlan zhProgressPlan);
    /**
     * 根据id删除进度计划
     */
    @PostMapping(value = "/provider/Node/remoProgressPlan")
    public AjaxResult removeProgressPlan(@RequestParam(value = "id") int id);
    /**
     * 修改保存节点详情
     */
    @PostMapping(value = "/provider/Node/editNode")
    public AjaxResult editNode(@RequestBody ZhNode zhNode);
    /**
     * 删除节点
     */
    @PostMapping(value = "/provider/Node/removeNode")
    public AjaxResult removeNode(@RequestParam(value = "id") int id);
    /**
     * 修改保存进度计划
     */
    @PostMapping(value = "/provider/Node/editProgressPlan")
    public AjaxResult editProgressPlan(@RequestBody ZhProgressPlan zhProgressPlan);
    /**
     * 添加前置节点
     */
    @PostMapping(value = "/provider/Node/addPrepose")
    public AjaxResult addPrepose(@RequestBody ZhPrepose zhPrepose);
    /**
     * 根据id删除前置节点
     */
    @PostMapping(value = "/provider/Node/removePreposeById")
    public AjaxResult removePreposeById(@RequestParam(value = "id") int id);
    /**
     * 进度导入关联节点
     */
    @PostMapping(value = "/provider/Node/addProgressNode")
    public AjaxResult addProgressNode(@RequestBody ZhProgressNode zhProgressNode);
    /**
     * 删除进度中的关联节点
     */
    @PostMapping(value = "/provider/Node/removeProgressNode")
    public AjaxResult removeaddProgressNode(@RequestParam(value = "id") int id);

    /**
     * 对艾达信人脸机下发指令
     * @param json
     * @return
     */
    @PostMapping(value = "/provider/hs/person")
    public String addPerson(@RequestBody String json);

    /**
     * 接收艾达信人脸机的考勤记录
     * @param json
     * @return
     */
    @PostMapping(value = "/provider/hsRecord/setRecord")
    public String setRecord(@RequestBody String json);

    /**
     * 新增人脸机
     * @param hjAttendanceDevice
     * @return
     */
    @PostMapping(value = "/provider/attendanceDeviceApi/insertAttendanceDevice")
    public AjaxResult insertAttendanceDevice(@RequestBody HjAttendanceDevice hjAttendanceDevice);

    /**
     * 修改人脸机
     * @param hjAttendanceDevice
     * @return
     */
    @PostMapping(value = "/provider/attendanceDeviceApi/updateAttendanceDevice")
    public AjaxResult updateAttendanceDevice(@RequestBody HjAttendanceDevice hjAttendanceDevice);
    /**
     * 人脸机列表
     * @param
     * @return
     */
    @PostMapping(value = "/provider/attendanceDeviceApi/selectAttendanceDevice")
    public AjaxResult selectAttendanceDevice(@RequestBody HjAttendanceDevice hjAttendanceDevice,@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);


    /**
     * 查询结构物列表（高支模）
     * @param projectId
     * @return
     */
    @PostMapping(value = "/provider/HjGhformworktApi/selectStructure")
    public  AjaxResult selectStructure(@RequestParam("projectId") Integer projectId);

    /**
     * 查询所有的因素列表（高支模）
     * @return
     */
    @PostMapping(value = "/provider/HjGhformworktApi/selectDisplay" )
    public AjaxResult selectDisplay(@RequestParam(value = "structureId") Integer structureId);

    /**
     * 查询所有的监测点（高支模）
     * @return
     */
    @PostMapping(value = "/provider/HjGhformworktApi/getFactorList" )
    public AjaxResult getFactorList(@RequestParam(value = "structureId") Integer structureId, @RequestParam(value = "displayId") Integer displayId);

    /**
     * 查询测点历史数据（高支模）
     * @param factorId
     * @return
     */
    @PostMapping(value = "/provider/HjGhformworktApi/getFactorData" )
    public AjaxResult getFactorData(@RequestParam(value = "factorId") Integer factorId, @RequestParam(value = "date") String date,
                                    @RequestParam(value = "pageSize") Integer pageSize,
                                    @RequestParam(value = "pageNum") Integer pageNum);

    /**
     * 查询报警数据（高支模）
     * @param structureId
     * @return
     */
    @PostMapping(value = "/provider/HjGhformworktApi/selectUserAlarms" )
    public AjaxResult selectUserAlarms(@RequestParam(value = "structureId") Integer structureId, @RequestParam(value = "date") String date,
                                       @RequestParam(value = "pageSize") Integer pageSize,
                                       @RequestParam(value = "pageNum") Integer pageNum);

    /**
     * 按时间段查询历史数据（高支模）
     * @param factorId
     * @param startTime
     * @param endTime
     * @return
     */
    @PostMapping(value = "/provider/HjGhformworktApi/getFactorDataT" )
    public AjaxResult getFactorDataT(@RequestParam(value = "factorId") Integer factorId, @RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime") String endTime,
                                     @RequestParam(value = "pageSize") Integer pageSize,
                                     @RequestParam(value = "pageNum") Integer pageNum);

    /**
     * 查询历史数据最大、最小、平均值（高支模）
     * @param displayId
     * @return
     */
    @PostMapping(value = "/provider/HjGhformworktApi/getParmeterAvg" )
    public AjaxResult getParmeterAvg(@RequestParam(value = "displayId") Integer displayId, @RequestParam(value = "factorId") Integer factorId);

    /**
     * 当日数据表特殊点（高支模）
     * @param factorId
     * @return
     */
    @PostMapping(value = "/provider/HjGhformworktApi/selectSpecial" )
    public List selectSpecial(@RequestParam(value = "factorId") Integer factorId, @RequestParam(value = "param") String param, @RequestParam(value = "date") String date);

    /**
     * 历史数据图表（高支模）
     * @param factorId
     * @param startTime
     * @param endTime
     * @return
     */
    @PostMapping(value = "/provider/HjGhformworktApi/selectSpecialS" )
    public JSONArray selectSpecialS(@RequestParam(value = "displayId") Integer displayId, @RequestParam(value = "factorId") Integer factorId, @RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime") String endTime);

    /**
     * 报警数据统计等级比例（高支模）
     * @param structureId
     * @return
     */
    @PostMapping(value = "/provider/HjGhformworktApi/statisticsAlertor" )
    public AjaxResult statisticsAlertor(@RequestParam(value = "structureId") Integer structureId);

    /**
     * 查询报警数据（高支模）
     * @param factorName
     * @return
     */
    @PostMapping(value = "/provider/HjGhformworktApi/selectUserAlarmsByFactor" )
    public AjaxResult selectUserAlarmsByFactor(@RequestParam(value = "factorName") String factorName, @RequestParam(value = "date") String date);

    /**
     * 关联项目(工讯)
     * @param sPD
     * @return
     */
    @PostMapping(value = "/provider/hjDeeppit/insertDeeppit")
    public AjaxResult insertDeeppit(@RequestBody SbProjectDeeppitStructures sPD);

    /**
     * 查询结构物列表（基坑）
     * @param projectId
     * @return
     */
    @PostMapping(value = "/provider/hjDeeppit/selectStructure")
    public AjaxResult selectStructureDeeppit(@RequestParam("projectId") Integer projectId);

    /**
     * 查询所有的因素列表（基坑）
     * @return
     */
    @PostMapping(value = "/provider/hjDeeppit/selectDisplay" )
    public AjaxResult selectDisplayDeeppit(@RequestParam(value = "structureId") Integer structureId);

    /**
     * 查询所有的监测点（基坑）
     * @return
     */
    @PostMapping(value = "/provider/hjDeeppit/getFactorList" )
    public AjaxResult getFactorListDeeppit(@RequestParam(value = "structureId") Integer structureId, @RequestParam(value = "displayId") Integer displayId);

    /**
     * 查询测点历史数据（基坑）
     * @param factorId
     * @return
     */
    @PostMapping(value = "/provider/hjDeeppit/getFactorData" )
    public JSONObject getFactorDataDeeppit(@RequestParam(value = "factorId") Integer factorId, @RequestParam(value = "date") String date, @RequestParam(value = "pageSize") Integer pageSize,
                                           @RequestParam(value = "pageNum") Integer pageNum);

    /**
     * 查询历史数据最大、最小、平均值
     * @param displayId
     * @return
     */
    @PostMapping(value = "/provider/hjDeeppit/getParmeterAvg" )
    public AjaxResult getFactorDataInfoDeeppit(@RequestParam(value = "displayId") Integer displayId, @RequestParam(value = "factorId") Integer factorId);

    /**
     * 查询报警数据（基坑）
     * @param structureId
     * @return
     */
    @PostMapping(value = "/provider/hjDeeppit/selectUserAlarms" )
    public AjaxResult selectUserAlarmsDeeppit(@RequestParam(value = "structureId") Integer structureId, @RequestParam(value = "date") String date, @RequestParam(value = "pageSize") Integer pageSize,
                                              @RequestParam(value = "pageNum") Integer pageNum);

    /**
     * 报警数据统计等级比例（基坑）
     * @param structureId
     * @return
     */
    @PostMapping(value = "/provider/hjDeeppit/statisticsAlertor" )
    public AjaxResult statisticsAlertorDeeppit(@RequestParam(value = "structureId") Integer structureId);

    /**
     * 按时间段查询历史数据（基坑）
     * @param factorId
     * @param startTime
     * @param endTime
     * @return
     */
    @PostMapping(value = "/provider/hjDeeppit/getFactorDataT" )
    public AjaxResult getFactorDataTDeeppit(@RequestParam(value = "factorId") Integer factorId, @RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime") String endTime, @RequestParam(value = "pageSize") Integer pageSize,
                                            @RequestParam(value = "pageNum") Integer pageNum);

    /**
     * 当日数据表特殊点（基坑）
     * @param factorId
     * @return
     */
    @PostMapping(value = "/provider/hjDeeppit/selectSpecial" )
    public List selectSpecialDeeppit(@RequestParam(value = "factorId") Integer factorId, @RequestParam(value = "param") String param, @RequestParam(value = "date") String date);

    /**
     * 历史数据图表（基坑）
     * @param factorId
     * @param startTime
     * @param endTime
     * @return
     */
    @PostMapping(value = "/provider/hjDeeppit/selectSpecialS" )
    public JSONArray getFactorDataTDeeppit(@RequestParam(value = "displayId") Integer displayId, @RequestParam(value = "factorId") Integer factorId, @RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime") String endTime);

    /**
     * 查询报警数据（基坑）
     * @param factorName
     * @return
     */
    @PostMapping(value = "/provider/hjDeeppit/selectUserAlarmsByFactor" )
    public AjaxResult selectUserAlarmsByFactorDeeppit(@RequestParam(value = "factorName") String factorName, @RequestParam(value = "date") String date);

    /**
     * 海康人脸机记录
     * @param json
     * @return
     */
    @PostMapping(value = "/provider/ys/setRecord")
    public String setRecordYs(@RequestBody String json);
    /**
     * 实名制进出看板
     */
    @PostMapping("/provider/inOutKanBan/selectTV")
    public AjaxResult selectTV(@RequestParam(value = "pid") Integer pid);

    /**
     * 实名制进出看板
     */
    @PostMapping("/provider/project/selectProjectMsg")
    public AjaxResult selectProjectMsg(@RequestParam(value = "projectId") Integer projectId);

}
