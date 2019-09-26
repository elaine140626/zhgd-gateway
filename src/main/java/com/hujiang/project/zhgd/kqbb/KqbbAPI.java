package com.hujiang.project.zhgd.kqbb;

import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.kqbb.domain.BG;
import com.hujiang.project.zhgd.kqbb.domain.Kqbb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: Consumer01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-07-05 14:57
 **/
@RestController
@RequestMapping(value = "api/kqbb")
public class KqbbAPI {

    @Autowired
    private SystemClient client;


    @GetMapping("getbb")
    public  void  getbb(HttpServletResponse response,Integer projectId){
        String fileName = "考勤报表";
        String[] columnNames =new String[33];
        columnNames[0]="ID";
        columnNames[1]="姓名";
        long millis = System.currentTimeMillis();//系统毫秒数
        List<BG> bgs = client.getKqbbListBb(projectId);
        for(int i = 0; i<30;i++) {
            millis=millis - (1000 * 60 * 60 * 24);
            Date d = new Date(millis);
            SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
            String rq=sp.format(d);//获取日期
            int i1 = 32 - (i + 1);
            columnNames[i1]=rq;
//            if(i1==31){
//                List<Kqbb> kqbbList = client.getKqbbList(projectId,rq);
//                System.out.println(kqbbList.size());
//                for(int a = 0 ;a<kqbbList.size();a++){
//                    BG bg = bgs.get(a);
//                    if(kqbbList.get(a).getEmpId()==Integer.parseInt(bgs.get(i).getId())){
//                        bg.setTime_30(kqbbList.get(i).getATime());
//                        bg.setCount(kqbbList.get(i).getManHour().toString());
//                        bgs.add(bg);
//                    }
//
//                }
//            }else{
                List<Kqbb> kqbbList = client.getKqbbList(projectId,rq);
            for(int s = 0; s < bgs.size();s++){
                BG bg =  bgs.get(s);
                for(Kqbb k:kqbbList) {
                    if(k.getEmpId()==Integer.parseInt(bgs.get(s).getId())){
                        k.setManHour( k.getManHour().equals("null") ?BigDecimal.valueOf(Float.parseFloat("0.00")):k.getManHour());
                        switch (i1) {
                            case 31:
                                bg.setTime_30(k.getManHour().toString());
                                break;
                            case 30:
                                bg.setTime_29(k.getManHour().toString());
                                break;
                            case 29:
                                bg.setTime_28(k.getManHour().toString());
                                break;
                            case 28:
                                bg.setTime_27(k.getManHour().toString());
                                break;
                            case 27:
                                bg.setTime_26(k.getManHour().toString());
                                break;
                            case 26:
                                bg.setTime_25(k.getManHour().toString());
                                break;
                            case 25:
                                bg.setTime_24(k.getManHour().toString());
                                break;
                            case 24:
                                bg.setTime_23(k.getManHour().toString());
                                break;
                            case 23:
                                bg.setTime_22(k.getManHour().toString());
                                break;
                            case 22:
                                bg.setTime_21(k.getManHour().toString());
                                break;
                            case 21:
                                bg.setTime_20(k.getManHour().toString());
                                break;
                            case 20:
                                bg.setTime_19(k.getManHour().toString());
                                break;
                            case 19:
                                bg.setTime_18(k.getManHour().toString());
                                break;
                            case 18:
                                bg.setTime_17(k.getManHour().toString());
                                break;
                            case 17:
                                bg.setTime_16(k.getManHour().toString());
                                break;
                            case 16:
                                bg.setTime_15(k.getManHour().toString());
                                break;
                            case 15:
                                bg.setTime_14(k.getManHour().toString());
                                break;
                            case 14:
                                bg.setTime_13(k.getManHour().toString());
                                break;
                            case 13:
                                bg.setTime_12(k.getManHour().toString());
                                break;
                            case 12:
                                bg.setTime_11(k.getManHour().toString());
                                break;
                            case 11:
                                bg.setTime_10(k.getManHour().toString());
                                break;
                            case 10:
                                bg.setTime_9(k.getManHour().toString());
                                break;
                            case 9:
                                bg.setTime_8(k.getManHour().toString());
                                break;
                            case 8:
                                bg.setTime_7(k.getManHour().toString());
                                break;
                            case 7:
                                bg.setTime_6(k.getManHour().toString());
                                break;
                            case 6:
                                bg.setTime_5(k.getManHour().toString());
                                break;
                            case 5:
                                bg.setTime_4(k.getManHour().toString());
                                break;
                            case 4:
                                bg.setTime_3(k.getManHour().toString());
                                break;
                            case 3:
                                bg.setTime_2(k.getManHour().toString());
                                break;
                            case 2:
                                bg.setTime_1(k.getManHour().toString());
                                break;

                        }

                        bg.setCount(bg.getCount()==null?k.getManHour().toString():k.getManHour().doubleValue()+Float.parseFloat(bg.getCount())+"");
                        bgs.set(s,bg);
                    }
                }
            }


        }
        columnNames[32]="出勤总工时";

        // 列名
        // map中的key
        String keys[] = {  "id", "name", "time_1", "time_2", "time_3" , "time_4" , "time_5" , "time_6" , "time_7" , "time_8" , "time_9"
                , "time_10" , "time_11" , "time_12" , "time_13" , "time_14" , "time_15" , "time_16" , "time_17" , "time_18" , "time_19" , "time_20"
                , "time_21" , "time_22" , "time_23" , "time_24", "time_25" , "time_26" , "time_27" , "time_28" , "time_29" , "time_30", "count"   };
        try {
            ExcelUtil.start_download(response, fileName, bgs,columnNames, keys);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
