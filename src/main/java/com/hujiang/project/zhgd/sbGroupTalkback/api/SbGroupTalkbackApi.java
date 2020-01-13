package com.hujiang.project.zhgd.sbGroupTalkback.api;

import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbGroupTalkback.domain.SbGroupTalkback;
import com.hujiang.project.zhgd.util.AliyunOSSClientUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * 获取集团对讲列表
 */
@RestController
@RequestMapping(value = "/api/sbGroupTalkback")
public class SbGroupTalkbackApi extends BaseController {
        @Autowired
        private SystemClient client;


        @PostMapping("/getAccountList")
        public List<SbGroupTalkback> getAccountList(SbGroupTalkback sbGroupTalkback){

            return client.getAccountList(sbGroupTalkback);
        }
        @GetMapping("/ftpDownload")
        public void ftpDownload(String ftpPath,String user,String startTime,String name,String endTime, HttpServletResponse response) throws  Exception{

                String s = client.ftpDownload(ftpPath,user,startTime,name,endTime);
                if(!"-1".equals(s)){
                        URL url = new URL(s);
                        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                        //设置超时间为3秒
                        conn.setConnectTimeout(3*1000);
                        //防止屏蔽程序抓取而返回403错误
                        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

                        //得到输入流
                        //下载
                        try (InputStream inputStream = conn.getInputStream();
                             OutputStream outputStream = response.getOutputStream();) {
                                response.setContentType("application/zip");

                                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(name+startTime+"_"+endTime+".zip", "UTF-8"));
                                IOUtils.copy(inputStream, outputStream);

                                //删除文件
                                AliyunOSSClientUtil.deleteFile(AliyunOSSClientUtil.getOSSClient(),"hujiang", name+startTime+"_"+endTime+".zip");
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }
        }


}

