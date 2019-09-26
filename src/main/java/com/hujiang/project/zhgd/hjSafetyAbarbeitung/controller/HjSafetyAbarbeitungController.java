package com.hujiang.project.zhgd.hjSafetyAbarbeitung.controller;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjSafetyAbarbeitung.domain.HjSafetyAbarbeitung;
import com.hujiang.project.zhgd.hjSafetyAbarbeitung.domain.HjSafetyNoPass;
import com.hujiang.project.zhgd.util.AliyunOSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import java.io.IOException;

/**
 * app巡检
 * 
 * @author hujiang
 * @date 2019-07-10
 */
@RestController
@RequestMapping(value = "/api/safetyAppApi",method = RequestMethod.POST)
public class HjSafetyAbarbeitungController extends BaseController
{


	@Autowired
	private SystemClient client;

	@PostMapping(value = "/updateAlias")
	public JSONObject updateAlias(@RequestParam(value = "userId")int userId,
								  @RequestParam(value = "userAlias")String alias){
		return client.updateAlias(userId,alias);
	}

	/**
	 * 获取信息接口
	 */
	@PostMapping("/getSafetyList")
	@ResponseBody
	public JSONObject getSafetyList(Integer projectId){
		return client.getSafetyList(projectId);
	}
	/**
	 * 安全监管--发起整改
	 */
	@RequestMapping("/sponsorSafety")
	public JSONObject sponsorSafety(HjSafetyAbarbeitung hjSafetyAbarbeitung,MultipartFile[] file)throws IOException {
		if (file.length > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < file.length; i++) {
				String photoName = file[i].getOriginalFilename();
				String url = AliyunOSSClientUtil.uploadFileImg(file[i], "zhgd_img", photoName);
				String path = url.substring(0, url.lastIndexOf("?"));   //截取"?" 后面字符- - 文件路径
				sb.append(path);
				sb.append(",");
			}
			String safetyPhotos = sb.toString().substring(0, sb.toString().length() - 1);
			hjSafetyAbarbeitung.setSafetyPhotos(safetyPhotos);
		}
		return client.sponsorSafety(hjSafetyAbarbeitung);
	}
	/**
	 * 待整改/待复查/已完成--列表
	 */
	@RequestMapping("/getAfterRectification")
	public JSONObject getAfterRectification(@RequestParam(value = "projectId") Integer projectId,
											@RequestParam(value = "status") Integer status,
											@RequestParam(value = "differentiate")Integer differentiate,
											@RequestParam(value = "userId")Integer userId,
											PageDomain pageDomain){
		return client.getAfterRectification(projectId,status,differentiate,userId,pageDomain.getPageSize(),pageDomain.getPageNum());
	}
	/**
	 *进行整改
	 */
	@RequestMapping("/alterSafety")
	public JSONObject alterSafety(HjSafetyNoPass hjSafetyNoPass,MultipartFile[] file)throws IOException{
		if (file.length > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < file.length; i++) {
				String photoName = file[i].getOriginalFilename();
				String url = AliyunOSSClientUtil.uploadFileImg(file[i], "zhgd_img", photoName);
				String path = url.substring(0, url.lastIndexOf("?"));   //截取"?" 后面字符- - 文件路径
				sb.append(path);
				sb.append(",");
			}
			String rectifyPhotos = sb.toString().substring(0, sb.toString().length() - 1);
			hjSafetyNoPass.setRectifyPhotos(rectifyPhotos);
		}else{
			hjSafetyNoPass.setRectifyPhotos(null);
		}
		return client.alterSafety(hjSafetyNoPass);
	}
	/**
	 * 复查人通过/未通过
	 */
	@RequestMapping("/alertReviewPass")
	public JSONObject alertReviewPass(HjSafetyNoPass hjSafetyNoPass,MultipartFile[] file)throws IOException{
		if (file.length > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < file.length; i++) {
				String photoName = file[i].getOriginalFilename();
				String url = AliyunOSSClientUtil.uploadFileImg(file[i], "zhgd_img", photoName);
				String path = url.substring(0, url.lastIndexOf("?"));   //截取"?" 后面字符- - 文件路径
				sb.append(path);
				sb.append(",");
			}
			String reviewPath = sb.toString().substring(0, sb.toString().length() - 1);
			hjSafetyNoPass.setReviewPath(reviewPath);
		}
		return client.alertReviewPass(hjSafetyNoPass);
	}
	/**
	 * 详情
	 */
	@RequestMapping("/getAfterRectificationDetails")
	public JSONObject getAfterRectificationDetails(@RequestParam(value = "safetyId")Integer safetyId){
		return client.getAfterRectificationDetails(safetyId);
	}

	/**
	 * 质量监管--合格/不合格
	 */
	@RequestMapping("/sponsorQuality")
	public JSONObject sponsorQuality(HjSafetyAbarbeitung hjSafetyAbarbeitung,MultipartFile[] file) throws  IOException{
		if (file.length > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < file.length; i++) {
				String photoName = file[i].getOriginalFilename();
				String url = AliyunOSSClientUtil.uploadFileImg(file[i], "zhgd_img", photoName);
				String path = url.substring(0, url.lastIndexOf("?"));   //截取"?" 后面字符- - 文件路径
				sb.append(path);
				sb.append(",");
			}
			String safetyPhotos = sb.toString().substring(0, sb.toString().length() - 1);
			hjSafetyAbarbeitung.setSafetyPhotos(safetyPhotos);
		}
		return client.sponsorQuality(hjSafetyAbarbeitung);
	}

}
