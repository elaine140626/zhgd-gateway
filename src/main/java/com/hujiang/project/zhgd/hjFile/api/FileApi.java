package com.hujiang.project.zhgd.hjFile.api;

import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.Constants;
import com.hujiang.project.zhgd.RestTemplateUtil;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjFile.domain.HjFile;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-06-28 16:25
 **/
@RestController
@RequestMapping(value = "/api/FileApi")
public class FileApi extends BaseController {

    @Autowired
    private RestTemplateUtil restTemplateUtil;
    @Autowired
    private SystemClient client;

    /**
     * 文件列表
     * @param folderId
     * @return
     */
    @PostMapping(value = "getFileList")
    public Map<String,Object> getFileList(@RequestParam(value = "folderId") Integer folderId,@RequestParam(value = "pageNum") Integer pageNum,
                                          @RequestParam(value = "pageSize") Integer pageSize,@RequestParam(value = "fileName",required = false) String fileName){
        return client.getFileList(folderId, pageNum, pageSize, fileName);
    }
    /**
     * 上传文件
     * @param folderId
     * @param projectId
     * @param uploadAccount
     * @param folderName
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("uploadFile")
    public Map<String,Object> uploadFile(Integer folderId,
                                         Integer projectId,
                                         String uploadAccount,
                                         String folderName,
                                         MultipartFile file)throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("folderId",folderId);
        map.put("projectId",projectId);
        map.put("uploadAccount",uploadAccount);
        map.put("folderName",folderName);
        return ( Map<String,Object>)restTemplateUtil.PostFile(map, Constants.SERVICE_NAME+"provider/FileApi/uploadFile",file);
    }
    /**
     * 删除文件
     * @param ids
     * @return
     */
    @PostMapping("deleteFile")
    public  Map<String,Object> deleteFile(@RequestParam(value = "ids") String ids){
        return client.deleteFile(ids);
    }



    @GetMapping("download")
    public void d(String imgURL,HttpServletResponse response)throws Exception{
        String fileName = imgURL.substring(imgURL.lastIndexOf("/")+1,imgURL.length());
        // 创建URL
        URL url = new URL(imgURL);
        byte[] by = new byte[1024];
        // 创建链接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        try (
                InputStream inputStream = conn.getInputStream();
             OutputStream outputStream = response.getOutputStream();) {

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);

            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
