package com.hujiang.project.zhgd.zhNode.api;

import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.lzfw.domain.HjReportPc;
import com.hujiang.project.zhgd.zhNode.domain.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @program: Provider01
 * @description:
 * @author: yant
 **/
@RestController
@RequestMapping(value = "/api/Node", method = RequestMethod.POST)
public class NodeApi {
    @Autowired
    private SystemClient client;


    /**
     * 导出节点计划所有列表
     */

    @GetMapping("/exportZhProgressPlan")
    public void exportZhProgressPlan(Integer progressId, HttpServletResponse response) throws Exception {
        System.out.println("导出Excel：");
        List<ZhNodePc> list = client.exportZhProgressPlan(progressId);
        ExcelUtil<ZhNodePc> util = new ExcelUtil<ZhNodePc>(ZhNodePc.class);
        //生成Excel
        AjaxResult a = util.exportExcel(list, "节点计划");
        //设置下载文件名
        String fileName = URLEncoder.encode((String) a.get("msg"), "UTF-8");
        File file = new File(Util.getPath(), (String) a.get("msg"));
        try (InputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = response.getOutputStream();) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (file.exists()) {
            file.delete();
        }
    }


    /**
     * 查询进度节点列表
     */
    @PostMapping("selectZhNodeList")
    @ResponseBody
    public AjaxResult selectZhNodeList(ZhNode node) {

        return client.selectZhNodeList(node);
    }

    /**
     * 查询进度节点列表
     */
    @PostMapping("selectCruxZhNode")
    @ResponseBody
    public AjaxResult selectCruxZhNode(ZhNode node) {

        return client.selectCruxZhNode(node);
    }

    /**
     * 查询即将开始节点列表
     */
    @PostMapping("selectWarningZhNode")
    @ResponseBody
    public AjaxResult selectWarningZhNode(ZhNode node) {
        return client.selectWarningZhNode(node);
    }


    /**
     * 查询即将开始节点列表
     */
    @PostMapping("selectBeginZhNode")
    @ResponseBody
    public AjaxResult selectBeginZhNode(ZhNode node) {
        return client.selectBeginZhNode(node);
    }

    /**
     * 查询即将结束节点列表
     */
    @PostMapping("selectEndZhNode")
    @ResponseBody
    public AjaxResult selectEndZhNode(ZhNode node) {
        return client.selectEndZhNode(node);
    }


    /**
     * 查询计划节点关联列表
     */
    @PostMapping("selectZhProgressNodeList")
    @ResponseBody
    public AjaxResult selectZhProgressNodeList(ZhProgressNode zhProgressNode) {
        return client.selectZhProgressNodeList(zhProgressNode);
    }

    /**
     * 查询进度计划列表
     */
    @PostMapping("selectZhProgressPlanList")
    @ResponseBody
    public AjaxResult selectZhProgressPlanList(ZhProgressPlan zhProgressPlan) {
        return client.selectZhProgressPlanList(zhProgressPlan);
    }

    /**
     * 首页查询进度计划列表
     */
    @PostMapping("selectZhProgressPlan")
    @ResponseBody
    public AjaxResult selectZhProgressPlan(ZhProgressPlan zhProgressPlan) {
        return client.selectZhProgressPlan(zhProgressPlan);
    }

    /**
     * 查询前置节点列表
     */
    @PostMapping("selectZhPreposeList")
    @ResponseBody
    public AjaxResult selectZhPreposeList(ZhPrepose zhPrepose) {
        return client.selectZhPreposeList(zhPrepose);
    }


    /**
     * 新增保存节点计划
     */
    @PostMapping("addNode")
    @ResponseBody
    public AjaxResult addNode(ZhNode zhNode) {
        return client.addNode(zhNode);
    }

    /**
     * 新增保存进度计划
     */
    @PostMapping("addProgressPlan")
    @ResponseBody
    public AjaxResult addProgressPlan(ZhProgressPlan zhProgressPlan) {
        return client.addProgressPlan(zhProgressPlan);
    }


    /**
     * 删除节点
     */
    @PostMapping("removeNode")
    @ResponseBody
    public AjaxResult removeNode(int id) {
        return client.removeNode(id);
    }

    /**
     * 根据id删除进度计划
     */
    @PostMapping("remoProgressPlan")
    public AjaxResult removeProgressPlan(int id) {
        return client.removeProgressPlan(id);
    }

    /**
     * 修改保存节点计划详情
     */
    @PostMapping("editNode")
    @ResponseBody
    public AjaxResult editNode(ZhNode zhNode) {
//        if ((zhNode.getParentIds() == null || zhNode.getParentIds() == "" || zhNode.getParentIds().equals("null") ) || (zhNode.getPrincipals() == null || zhNode.getPrincipals() == "" || zhNode.getPrincipals().equals("null"))){
//            zhNode.setParentId(null);
//            zhNode.setPrincipal(null);
//        }else {
//            zhNode.setPrincipal(Integer.valueOf(zhNode.getPrincipals()));
//            zhNode.setParentId(Integer.valueOf(zhNode.getParentIds()));
//        }
        return client.editNode(zhNode);
    }

    /**
     * 修改保存进度计划
     */
    @PostMapping("editProgressPlan")
    @ResponseBody
    public AjaxResult editProgressPlan(ZhProgressPlan zhProgressPlan) {
        return client.editProgressPlan(zhProgressPlan);
    }


    /**
     * 添加前置节点
     */
    @PostMapping("addPrepose")
    @ResponseBody
    public AjaxResult addPrepose(ZhPrepose zhPrepose) {
        return client.addPrepose(zhPrepose);
    }

    /**
     * 根据id删除前置节点
     */
    @PostMapping("removePreposeById")
    @ResponseBody
    public AjaxResult removePreposeById(int id) {
        return client.removePreposeById(id);
    }

    /**
     * 进度导入关联节点
     */
    @PostMapping("addProgressNode")
    @ResponseBody
    public AjaxResult addProgressNode(ZhProgressNode zhProgressNode) {
        return client.addProgressNode(zhProgressNode);
    }

    /**
     * 删除进度中的关联节点
     */
    @PostMapping("removeProgressNode")
    @ResponseBody
    public AjaxResult removeaddProgressNode(int id) {
        return client.removeaddProgressNode(id);
    }

    /**
     * 更新计划中节点进度
     */
    @PostMapping("editNodeWithProgress")
    @ResponseBody
    public AjaxResult editNodeWithProgress(ZhProgressNode zhProgressNode) {
        return client.editNodeWithProgress(zhProgressNode);
    }

    /**
     * 查询计划关联节点列表
     */
    @PostMapping("selectZhNodeProgressList")
    @ResponseBody
    public AjaxResult selectZhNodeProgressList(ZhProgressNode zhProgressNode) {
        return client.selectZhNodeProgressList(zhProgressNode);
    }

    /**
     * 查询计划关联节点列表
     */
    @PostMapping("selectAddZhNodeList")
    public AjaxResult selectAddZhNodeList(@RequestParam(value = "projectId") Integer projectId) {
        return client.selectAddZhNodeList(projectId);
    }

}
