package com.template.ie.dict;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.template.ie.model.Dict;

@Mapper
public interface DictMapper {

	/**
	 * 按id查询
	 */
	@Select("select * from DICT where ID = #{id}")
	@Results({
        @Result(property = "id", column = "ID"),
        @Result(property = "group_code", column = "GROUP_CODE"),
        @Result(property = "group_name", column = "GROUP_NAME"),
        @Result(property = "name", column = "NAME"),
        @Result(property = "code", column = "CODE"),
        @Result(property = "key", column = "KEY"),
        @Result(property = "state", column = "STATE"),
        @Result(property = "sort", column = "SORT")
	})
	List<Dict> selectDict(@Param("id") String id);
	
	/**
	 * 按分类查询字典（图片分类、角色分类）
	 */
	@Select("select * from DICT where group_code = #{group_code} order by sort asc")
	@Results({
        @Result(property = "id", column = "ID"),
        @Result(property = "group_code", column = "GROUP_CODE"),
        @Result(property = "group_name", column = "GROUP_NAME"),
        @Result(property = "name", column = "NAME"),
        @Result(property = "code", column = "CODE"),
        @Result(property = "key", column = "KEY"),
        @Result(property = "state", column = "STATE"),
        @Result(property = "sort", column = "SORT")
	})
	List<Dict> selectClassifDict(@Param("group_code") String group_code);
	
	/**
	 * 查询全部
	 */
	@Select("select * from DICT order by sort asc")
	@Results({
        @Result(property = "id", column = "ID"),
        @Result(property = "group_code", column = "GROUP_CODE"),
        @Result(property = "group_name", column = "GROUP_NAME"),
        @Result(property = "name", column = "NAME"),
        @Result(property = "code", column = "CODE"),
        @Result(property = "key", column = "KEY"),
        @Result(property = "state", column = "STATE"),
        @Result(property = "sort", column = "SORT")
	})
	List<Dict> selectAllDict();
}