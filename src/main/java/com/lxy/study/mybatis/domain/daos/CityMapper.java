/**
 * [Product]
 *     mybatis.study
 * [Copyright]
 *     Copyright © 2018 ZTESoft All Rights Reserved.
 * [FileName]
 *     CityDao.java
 * [History]
 *     Version  Date      Author     Content
 *     -------- --------- ---------- ------------------------
 *     1.0.0    Apr 15, 2018   Luo Xiaoyi    最初版本
 */
package com.lxy.study.mybatis.domain.daos;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lxy.study.mybatis.domain.models.City;
import com.lxy.study.mybatis.util.MyParam;

/**
 * <p> Class: CityDao </p>
 * Description: 
 * 
 * @author Luo.xiaoyi
 * 
 */

public interface CityMapper {
  public City queryCityByName(String name);

	public int deleteCityById(int id);

	public int updateCity(City city);
	
	public City queryCity(Map<String,String> param);
	
	public int countCityByName(String likeName);
	
	public City queryCityById(int id);
	
	/**
	 * 多参数传递方式，同一个参数能够使用多个注解，在这里，只有@Param能够被Mybatis识别
	 * @param name
	 * @param countryCode
	 * @return
	 */
	public City queryCityByNameAndCountryCode(@Param("name") @MyParam("name2") String name,@Param("countryCode") String countryCode);

	/**
	 * 采用注解的方式实现sql语句的注入
	 * @param id
	 * @return
	 */
	@Select("select * from city where id = #{id}")
	public City queryCityById2(int id);
	
	/**
	 * 保存city信息
	 * @param c city信息
	 */
	public void saveCity(City c);
}
