package com.template.ie.homepage;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.template.ie.model.Company;
import com.template.ie.model.Image;
import com.template.ie.model.LeftMenu;
import com.template.ie.model.PersonInfo;

@Mapper
public interface HomePageMapper {

	/**
	 * 获取展示用 获取左侧菜单
	 */
	@Select("select * from LEFT_MENU where STATE = #{state} and ID != #{code1} and ID != #{code2} order by sort asc")
	@Results({
        @Result(property = "id", column = "ID"),
        @Result(property = "name", column = "NAME"),
        @Result(property = "sort", column = "SORT"),
        @Result(property = "state", column = "STATE")
	})
	List<LeftMenu> getLeftMenu(@Param("code1") String code1, @Param("code2") String code2, @Param("state") String state);
	
	/**
	 * 获取公司信息
	 */
	@Select("select * from COMPANY_INFO")
	@Results({
        @Result(property = "id", column = "ID"),
        @Result(property = "name", column = "NAME"),
        @Result(property = "address", column = "ADDRESS"),
        @Result(property = "legal_person", column = "LEGAL_PERSON"),
        @Result(property = "title", column = "TITLE"),
        @Result(property = "wechat_qrcode", column = "WECHAT_QRCODE"),
        @Result(property = "phone", column = "PHONE"),
        @Result(property = "email", column = "EMAIL"),
        @Result(property = "weibo", column = "WEIBO"),
        @Result(property = "sort", column = "SORT")
	})
	List<Company> getCompanyInfo();
	
	/**
	 * 获取banner轮播图
	 */
	@Select("select * from IMAGE where STATE = #{state} and CODE = #{code} order by sort asc")
	@Results({
        @Result(property = "id", column = "ID"),
        @Result(property = "name", column = "NAME"),
        @Result(property = "title", column = "TITLE"),
        @Result(property = "image", column = "IMAGE"),
        @Result(property = "introduce", column = "INTRODUCE"),
        @Result(property = "code", column = "CODE"),
        @Result(property = "state", column = "STATE"),
        @Result(property = "time", column = "TIME"),
        @Result(property = "sort", column = "SORT")
	})
	List<Image> getBannerImage(@Param("code") String code, @Param("state") String state);
	
	/**
	 * 通过图片类型获取Image
	 
//	@Select("select * from IMAGE where code = #{code} and state = #{state} order by sort asc")
	@Select("select * from ( select c.*, rownum rn from "
			+ "(select a.ID,a.NAME,a.TITLE,a.IMAGE,a.INTRODUCE,a.STATE,a.TIME,a.SORT,"
			+ "b.NAME as code from IMAGE a join LEFT_MENU b on a.CODE = b.ID "
			+ "where a.code = #{code} and a.state = #{state} order by a.sort asc,a.time desc) c where rownum <= #{pageEnd}) "
			+ "where rn > #{pageStart}")
	@Results({
        @Result(property = "id", column = "ID"),
        @Result(property = "name", column = "NAME"),
        @Result(property = "title", column = "TITLE"),
        @Result(property = "image", column = "IMAGE"),
        @Result(property = "introduce", column = "INTRODUCE"),
        @Result(property = "code", column = "CODE"),
        @Result(property = "state", column = "STATE"),
        @Result(property = "time", column = "TIME"),
        @Result(property = "sort", column = "SORT")
	})
	List<Image> getImage(@Param("code") String code, @Param("state") String state, 
			@Param("pageEnd") int pageEnd,@Param("pageStart") int pageStart);
	
	@Select("select count(*) from ("
			+ "select a.ID,a.NAME,a.TITLE,a.IMAGE,a.INTRODUCE,a.STATE,a.TIME,a.SORT,"
			+ "b.NAME as code from IMAGE a join LEFT_MENU b on a.CODE = b.ID "
			+ "where a.code = #{code} and a.state = #{state} order by a.sort asc,a.time desc)")
	int selectCount(@Param("code") String code, @Param("state") String state);
	*/
	
	/**
	 * 通过图片类型获取Image
	 */
	@Select("select * from IMAGE where code = #{code} and state = #{state} order by sort asc")
	@Results({
        @Result(property = "id", column = "ID"),
        @Result(property = "name", column = "NAME"),
        @Result(property = "title", column = "TITLE"),
        @Result(property = "image", column = "IMAGE"),
        @Result(property = "introduce", column = "INTRODUCE"),
        @Result(property = "code", column = "CODE"),
        @Result(property = "state", column = "STATE"),
        @Result(property = "time", column = "TIME"),
        @Result(property = "sort", column = "SORT")
	})
	List<Image> getImage(@Param("code") String code, @Param("state") String state);
	
	/**
	 * 分组获取人员信息，只获取前2个
	 */
//	@Select("select * from (SELECT id,name,role_code,image,produce,state,sort,ROW_NUMBER() OVER(PARTITION BY role_code ORDER BY sort asc) e from PERSON_INFO) t where state = #{state} and e < 3")
	@Select("select * from (select * from PERSON_INFO where state = #{state} order by sort asc) where rownum<3")
	@Results({
        @Result(property = "id", column = "ID"),
        @Result(property = "name", column = "NAME"),
        @Result(property = "role_code", column = "ROLE_CODE"),
        @Result(property = "title", column = "TITLE"),
        @Result(property = "image", column = "IMAGE"),
        @Result(property = "produce", column = "PRODUCE"),
        @Result(property = "state", column = "STATE"),
        @Result(property = "sort", column = "SORT")
	})
	List<PersonInfo> getPersonInfo(@Param("state") String state);
	
	/**
	 * 获取底部合作品牌区，只获取前8个
	 */
	@Select("select * from (select * from IMAGE where state = #{state} order by sort asc) "
			+ "where CODE = #{code} and rownum<9")
	@Results({
        @Result(property = "id", column = "ID"),
        @Result(property = "name", column = "NAME"),
        @Result(property = "title", column = "TITLE"),
        @Result(property = "image", column = "IMAGE"),
        @Result(property = "introduce", column = "INTRODUCE"),
        @Result(property = "code", column = "CODE"),
        @Result(property = "state", column = "STATE"),
        @Result(property = "time", column = "TIME"),
        @Result(property = "sort", column = "SORT")
	})
	List<Image> getCooperation(@Param("code") String code, @Param("state") String state);
}