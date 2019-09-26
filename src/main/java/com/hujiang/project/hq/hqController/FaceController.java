package com.hujiang.project.hq.hqController;

import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjDeveceProjectworkers.domain.HjDeviceProjectworkers;
import com.hujiang.project.zhgd.hjProjectWorkers.domain.HjProjectWorkers;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import org.lebo.facegate.Client;
import org.lebo.facegate.FaceGateApi;
import org.lebo.facegate.PersonOperate;
import org.lebo.facegate.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.lebo.facegate.Client.handleMap;

@RestController
@RequestMapping(value = "/api/instructions",method = RequestMethod.POST)
public class FaceController {

    @Autowired
    private SystemClient client;

    /**
     * 对该设备下达下发人脸指令
     * @param deviceNo
     * @return
     */
    @RequestMapping("/lowerHair")
    public AjaxResult lowerHair(@RequestParam(value = "deviceNo") String deviceNo,@RequestParam(value = "pid") String pid)throws  Exception{

        //拿到操作设备的句柄
        HANDLE ghandle = handleMap.get(deviceNo);
        FaceGateApi instance=Client.instance;
        if(ghandle!=null){
            HjDeviceProjectworkers hd;
            //不在设备里的人员信息
            List<HjProjectWorkers> hpwList=client.getPWD(deviceNo,pid);


            for(HjProjectWorkers hpw: hpwList){
             int nRet=    PersonOperate.addPerson(instance,ghandle,hpw);

                //成功的话需要将该人员和设备保存进设备人员表
                if(nRet == Constant.RET_TYPE_E.RET_SUCCESS){
                    hd=new HjDeviceProjectworkers();
                    hd.setDeviceNo(deviceNo);
                    hd.setProjectWorkersId(hpw.getId());
                int i= client.setPWD(hd);
                if(i!=1){
                    PersonOperate.deletePerson(instance,ghandle,hpw.getId());//保存失败则删除设备里已存的人脸
                }
                    System.out.println("新增人员名单成功");
                }
                File file=new File(ResourceUtils.getURL("classpath:").getPath()+"static/upload/img/");
                delFile(file);
            }

        }else{
            return AjaxResult.error("操作失败，该设备不在线");
        }
        return AjaxResult.success("设备添加人脸成功");
    }
    static void delFile(File file) {

                        File[] files = file.listFiles();
                      for (File f : files) {
                            f.delete();
                         }


            }
    /**
     * 清除指定设备里的人脸
     * @param deviceNo
     * @return
     */
    @RequestMapping(value = "/clean")
    public AjaxResult clean(@RequestParam(value = "deviceNo") String deviceNo){
        HANDLE ghandle = handleMap.get(deviceNo);
        FaceGateApi instance=Client.instance;
        if(ghandle!=null){
            List<HjDeviceProjectworkers> hdpwList=client.clean(deviceNo);
            for(HjDeviceProjectworkers hdpw: hdpwList){
                int nRet=   PersonOperate.deletePerson(instance,ghandle,hdpw.getProjectWorkersId());
                if(nRet == Constant.RET_TYPE_E.RET_SUCCESS){
                    client.deleteId(hdpw.getId());
                }
            }
        }
        return AjaxResult.success("清除人脸成功");
    }

    /**
     * 下发指定人脸
     * @param deviceNo
     * @return
     * @throws Exception
     */
    @RequestMapping("/oneLowerHair")
    public void oneLowerHair(@RequestParam(value = "deviceNo") String deviceNo,@RequestBody HjProjectWorkers hpw)throws  Exception{
//拿到操作设备的句柄
        HANDLE ghandle = handleMap.get(deviceNo);
        FaceGateApi instance=Client.instance;
        if(ghandle!=null) {
            int nRet = PersonOperate.addPerson(instance, ghandle, hpw);

            //成功的话需要将该人员和设备保存进设备人员表
            if (nRet == Constant.RET_TYPE_E.RET_SUCCESS) {
                HjDeviceProjectworkers hd = new HjDeviceProjectworkers();
                hd.setDeviceNo(deviceNo);
                hd.setProjectWorkersId(hpw.getId());
                int i = client.setPWD(hd);
                if (i != 1) {
                    PersonOperate.deletePerson(instance, ghandle, hpw.getId());//保存失败则删除设备里已存的人脸
                }
                System.out.println("新增人员名单成功");
            }
        }
    }
    /**
     * 清除指定人脸
     * @param deviceNo
     * @return
     */
    @RequestMapping(value = "/oneClean")
    public int clean(@RequestParam(value = "deviceNo") String deviceNo,@RequestParam(value = "projectWorkersId") Integer projectWorkersId){
        HANDLE ghandle = handleMap.get(deviceNo);
        FaceGateApi instance=Client.instance;
        int nRet=-1;
        if(ghandle!=null){

            nRet  =   PersonOperate.deletePerson(instance,ghandle,projectWorkersId);


        }
        return nRet;
    }

}
