package com.template.ie.dict;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.template.ie.utils.HttpResponseUtil;

@RestController
@RequestMapping("/dict")
public class DictController {
	
	@Resource(name="dictService")
	private DictService dictService;
	
	private void setHeader(HttpServletResponse response) {	//设置响应
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setDateHeader("Expires", 0);
	}

	/**
	 * 按id查询
	 */
	@RequestMapping(value = "selectDict", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String selectDict(HttpServletRequest request,HttpServletResponse response) {
		String msg = "";
		try {
			setHeader(response);
			String id = request.getParameter("id");
			Map<String, String> para = new HashMap<String, String>();
			para.put("id", id);
			msg = dictService.selectDict(para);
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString("1", "失败", "0001", null, null);		
		}
		return msg;
    }
	
	/**
	 * 功能：查询分类字典（图片分类、角色分类）
	 */
	@RequestMapping(value = "selectClassifDict", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String selectClassifDict(HttpServletRequest request,HttpServletResponse response) {
		String msg = "";
		try {
			setHeader(response);
			String group_code = request.getParameter("group_code");
			Map<String, String> para = new HashMap<String, String>();
			para.put("group_code", group_code);
			msg = dictService.selectClassifDict(para);
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString("1", "失败", "0001", null, null);		
		}
		return msg;
    }
	
	/**
	 * 查询全部
	 */
	@RequestMapping(value = "selectAllDict", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String selectAllDict(HttpServletRequest request,HttpServletResponse response) {
		String msg = "";
		try {
			setHeader(response);
			msg = dictService.selectAllDict();
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString("1", "失败", "0001", null, null);		
		}
		return msg;
    }
}