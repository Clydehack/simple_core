package com.template.ie.homepage;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.ie.model.Company;
import com.template.ie.model.Image;
import com.template.ie.model.LeftMenu;
import com.template.ie.model.PersonInfo;
import com.template.ie.utils.Configation;
import com.template.ie.utils.HttpResponseUtil;

@Service("homePageService")
public class HomePageService {

	@Autowired
	
	@Resource
	HomePageMapper homePageMapper;
	
	/**
	 * 获取展示用 获取左侧菜单
	 */
	public String getLeftMenu() {
		String msg = "";
		try {
			String code1 = Configation.cooperation_code;		//不开启此项
			String code2 = Configation.banner_code;				//不开启此项
			String state = "0";									//只获取开启的数据
			List<LeftMenu> list = homePageMapper.getLeftMenu(code1, code2, state);
			msg = HttpResponseUtil.convertCommonJsonString(0, "成功", "data", list);
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", null, null);
		}
		return msg;
	}
	
	/**
	 * 获取公司信息
	 */
	public String getCompanyInfo() {
		String msg = "";
		try {
			List<Company> list = homePageMapper.getCompanyInfo();
			msg = HttpResponseUtil.convertCommonJsonString(0, "成功", "data", list);
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", null, null);
		}
		return msg;
	}
	
	/**
	 * 获取banner轮播图
	 */
	public String getBannerImage() {
		String msg = "";
		try {
			String code = Configation.banner_code;		//只获广告轮播图
			String state = "0";							//只获取开启的数据
			List<Image> list = homePageMapper.getBannerImage(code,state);
			msg = HttpResponseUtil.convertCommonJsonString(0, "成功", "data", list);
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", null, null);
		}
		return msg;
	}
	
	/**
	 * 通过图片类型获取Image
	 
	public String getImage(Map<String, Object> para) {
		String msg = "";
		try {
			String code = (String) para.get("code");
			int page_number = (int) para.get("page_number");	//当前页数
			int page_size = (int) para.get("page_size");		//每页显示数量
			
			int pageStart = page_size*(page_number-1); 			//大于该条记录 不包含条该记录 
	    	int pageEnd = page_size*page_number; 				//不大于该记录 包含该条记录
			String state = "0";									//只获取开启的数据
			List<Image> list = homePageMapper.getImage(code, state, pageEnd, pageStart);
			int count = homePageMapper.selectCount(code, state);
			msg = HttpResponseUtil.convertCommonJsonString(0, "成功", "data", list, "count", count);
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", null, null);
		}
		return msg;
	}
	*/
	
	/**
	 * 通过图片类型获取Image
	 */
	public String getImage(Map<String, Object> para) {
		String msg = "";
		try {
			String code = (String) para.get("code");
			String state = "0";									//只获取开启的数据
			List<Image> list = homePageMapper.getImage(code, state);
			msg = HttpResponseUtil.convertCommonJsonString(0, "成功", "data", list);
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", null, null);
		}
		return msg;
	}

	/**
	 * 获取人员信息
	 */
	public String getPersonInfo() {
		String msg = "";
		try {
			String state = "0";					//只获取开启的数据
			List<PersonInfo> list = homePageMapper.getPersonInfo(state);
			msg = HttpResponseUtil.convertCommonJsonString(0, "成功", "data", list);
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", null, null);
		}
		return msg;
	}
	
	/**
	 * 获取合作公司信息
	 */
	public String getCooperation() {
		String msg = "";
		try {
			String code = Configation.cooperation_code;		//只获取合作公司图片
			String state = "0";								//只获取开启的数据
			List<Image> list = homePageMapper.getCooperation(code,state);
			msg = HttpResponseUtil.convertCommonJsonString(0, "成功", "data", list);
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", null, null);
		}
		return msg;
	}
}