package com.template.ie.homepage;

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
@RequestMapping("/homePage")
public class HomePageController {
	
	@Resource(name = "homePageService")
	private HomePageService homePageService;				//service服务接口
	
	private void setHeader(HttpServletResponse response) {	//设置响应
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader( "Cache-Control", "no-store" );
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setDateHeader("Expires", 0);
	}
	
	/**
	 * 获取展示用 左侧菜单
	 */
	@RequestMapping(value = "getLeftMenu", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getLeftMenu(HttpServletRequest request,HttpServletResponse response) {
		String msg = "";
		try {
			setHeader(response);
			msg = homePageService.getLeftMenu();
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", "data", e.getMessage());		
		}
		return msg;
    }
	
	/**
	 * 获取公司信息
	 */
	@RequestMapping(value = "getCompanyInfo", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getCompanyInfo(HttpServletRequest request,HttpServletResponse response) {
		String msg = "";
		try {
			setHeader(response);
			msg = homePageService.getCompanyInfo();
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", "data", e.getMessage());		
		}
		return msg;
    }
	
	/**
	 * 获取banner轮播图
	 */
	@RequestMapping(value = "getBannerImage", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getBannerImage(HttpServletRequest request,HttpServletResponse response) {
		String msg = "";
		try {
			setHeader(response);
			msg = homePageService.getBannerImage();
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", "data", e.getMessage());		
		}
		return msg;
    }
	
	/**
	 * 通过图片类型获取Image
	 
	@RequestMapping(value="getImage",method = {RequestMethod.GET,RequestMethod.POST})
	public String getImage(HttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		try {
			setHeader(response);
			String code = request.getParameter("code");
			String pageNumber = request.getParameter("page_number"); 	//当前页数
			String pageSize = request.getParameter("page_size"); 		//每页显示数量
			Integer page_number = Integer.valueOf(pageNumber);
			Integer page_size = Integer.valueOf(pageSize);
			Map<String, Object> para = new HashMap<String, Object>();
			para.put("page_number", page_number);
			para.put("page_size", page_size);
			para.put("code", code);
			msg = homePageService.getImage(para);
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", "data", e.getMessage());		
		}
		return msg;
	}
	*/
	
	/**
	 * 通过图片类型获取Image
	 */
	@RequestMapping(value="getImage",method = {RequestMethod.GET,RequestMethod.POST})
	public String getImage(HttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		try {
			setHeader(response);
			String code = request.getParameter("code");
			Map<String, Object> para = new HashMap<String, Object>();
			para.put("code", code);
			System.out.println(code);
			msg = homePageService.getImage(para);
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", "data", e.getMessage());		
		}
		System.out.println(msg);
		return msg;
	}
	
	/**
	 * 获取人员信息
	 */
	@RequestMapping(value = "getPersonInfo", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getPersonInfo(HttpServletRequest request,HttpServletResponse response) {
		String msg = "";
		try {
			setHeader(response);
			msg = homePageService.getPersonInfo();
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", "data", e.getMessage());		
		}
		return msg;
    }
	
	/**
	 * 获取合作公司信息
	 */
	@RequestMapping(value = "getCooperation", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getCooperation(HttpServletRequest request,HttpServletResponse response) {
		String msg = "";
		try {
			setHeader(response);
			msg = homePageService.getCooperation();
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", "data", e.getMessage());		
		}
		return msg;
    }
}