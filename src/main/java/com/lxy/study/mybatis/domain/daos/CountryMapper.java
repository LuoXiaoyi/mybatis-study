/**
 * [Product] mybatis.study [Copyright] Copyright © 2018 ZTESoft All Rights Reserved. [FileName]
 * CityDao.java [History] Version  Date      Author     Content -------- --------- ----------
 * ------------------------ 1.0.0    Apr 15, 2018   Luo Xiaoyi    最初版本
 */
package com.lxy.study.mybatis.domain.daos;

import com.lxy.study.mybatis.domain.models.City;
import com.lxy.study.mybatis.domain.models.Country;
import com.lxy.study.mybatis.util.MyParam;
import com.lxy.study.mybatis.util.PageInfo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p> Class: CountryMapper </p>
 * Description: 
 *
 * @author Luo.xiaoyi
 *
 */

public interface CountryMapper {
  List<Country> queryCountryByCodes(@Param("codeList") List<String> codeList,
      @Param("like") String like);

  int updateCountryByParas(Map<String,Object> params);

  List<Country> queryAllCountries();

  Country queryCountryByCode(String code);

  List<Country> queryCountryByParas(Map<String,Object> params);

  List<Country> queryAllCountriesByPage(Map<String,Object> params);
}
