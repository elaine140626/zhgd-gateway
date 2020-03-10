package com.hujiang.project.zhgd.hjBlacklist.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.project.zhgd.Constants;
import com.hujiang.project.zhgd.RestTemplateUtil;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjBlacklist.domain.HjBlacklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 黑名单 信息操作处理
 * 
 * @author hujiang
 * @date 2019-06-25
 */
@RestController
@RequestMapping("/api/hjBlacklist")
public class HjBlacklistApi extends BaseController
{

	@Autowired
	private SystemClient client;
	@Autowired
	private RestTemplateUtil restTemplateUtil;


	/**
	 * 查询黑名单列表
	 */
	@PostMapping("/getBlacklist")
	public JSONObject getBlacklist(HjBlacklist hjBlacklist,Integer pageNum,Integer pageSize)
	{
		return client.getBlacklist(hjBlacklist,pageNum,pageSize);
	}


	/**
	 * 新增保存黑名单
	 */
	@PostMapping("/addBlacklist")
	public JSONObject addBlacklist(HjBlacklist hjBlacklist)
	{
		return client.addBlacklist(hjBlacklist);
	}

	/**
	 * 上传通报文件
	 * @param file
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@PostMapping("uploadBlacklist")
	public Map uploadBlacklist(MultipartFile file, String ids)throws Exception{
		Map<String,String> map = new HashMap<>();
		map.put("ids",ids);
//		return client.uploadBlacklist(file,ids);
		return (Map)restTemplateUtil.PostFile(map, Constants.SERVICE_NAME + "provider/hjBlacklist/uploadBlacklist", file);
	}
}
