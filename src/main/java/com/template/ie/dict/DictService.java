package com.template.ie.dict;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.ie.model.Dict;
import com.template.ie.utils.HttpResponseUtil;

@Service("dictService")
public class DictService {

	@Autowired
	DictMapper dictMapper;
	
	/**
	 * 按id查询
	 */
	public String selectDict(Map<String, String> para) {
		String msg = "";
		try {
			String id = para.get("id");
			List<Dict> list = dictMapper.selectDict(id);
			msg = HttpResponseUtil.convertCommonJsonString(0, "成功", "data", list);
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", "data", e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 功能：查询分类字典（图片分类、角色分类）
	 */
	public String selectClassifDict(Map<String, String> para) {
		String msg = "";
		try {
			String group_code = para.get("group_code");
			List<Dict> list = dictMapper.selectClassifDict(group_code);
			msg = HttpResponseUtil.convertCommonJsonString(0, "成功", "data", list);
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", "data", e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 查询全部
	 */
	public String selectAllDict() {
		String msg = "";
		try {
			List<Dict> list = dictMapper.selectAllDict();
			msg = HttpResponseUtil.convertCommonJsonString(0, "成功", "data", list);
		} catch (Exception e) {
			e.printStackTrace();
			msg = HttpResponseUtil.convertCommonJsonString(1, "失败", "data", e.getMessage());
		}
		return msg;
	}
}