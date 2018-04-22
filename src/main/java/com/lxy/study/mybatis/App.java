package com.lxy.study.mybatis;

import com.lxy.study.mybatis.domain.daos.CountryMapper;
import com.lxy.study.mybatis.domain.models.City2;
import com.lxy.study.mybatis.domain.models.Country;
import com.lxy.study.mybatis.util.PageInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.lxy.study.mybatis.domain.daos.CityMapper;
import com.lxy.study.mybatis.domain.models.City;
import com.lxy.study.mybatis.domain.models.Role;
import com.lxy.study.mybatis.util.BuildSessionFactoryManually;
import com.lxy.study.mybatis.util.SqlSessionUtil;

/**
 * Hello world!
 */
public class App {

  private static Logger log = LogManager.getLogger(App.class);

  public static void main(String[] args) {
    log.debug("Hello MyBatis!");
    String databaseId = SqlSessionUtil.getSqlSessionFactory().getConfiguration().getDatabaseId();
    System.out.println("databaseId --> " + databaseId);
    //test1();
    //test2();
    //test3();
    //testUpdate();
    //testDelete();
    //testSelect();
    //testSelectList();
    //testAssociation();
    // testCollection();
    testPage();
  }

  private static void testPage(){
    SqlSession ss = SqlSessionUtil.openSession();
    CountryMapper cm = ss.getMapper(CountryMapper.class);
    Map<String,Object> params = new HashMap<>();
    PageInfo pi = new PageInfo();
    pi.setPageSize(3);
    pi.setCurrentPageIndex(3);
    params.put("pageInfo",pi);
    params.put("population",2441000);
    List<Country> countries = cm.queryAllCountriesByPage(params);
    ss.close();
  }

  private static void testCollection() {
    SqlSession ss = SqlSessionUtil.openSession();
    CountryMapper cm = ss.getMapper(CountryMapper.class);
    Country c = cm.queryCountryByCode("ABW");
    // System.out.println("Country: " + c);
    ss.close();
  }

  private static void testAssociation() {
    SqlSession ss = SqlSessionUtil.openSession();
    CityMapper cm = ss.getMapper(CityMapper.class);
    City2 cts = cm.queryCityWithCountryInfo(1);
    System.out.println("cts: " + cts);
    ss.close();
  }

  private static void testSelectList() {
    SqlSession ss = SqlSessionUtil.openSession();
    CountryMapper cm = ss.getMapper(CountryMapper.class);
    List<Country> cts = cm.queryAllCountries();
    System.out.println("cts: " + cts);
    ss.commit();
  }

  private static void testSelect() {
    SqlSession ss = SqlSessionUtil.openSession();
    CityMapper cm = ss.getMapper(CityMapper.class);
    City c = cm.queryCityByName("Kabul");
    System.out.println("city： " + c);
    ss.commit();
  }

  private static void testDelete() {
    SqlSession ss = SqlSessionUtil.openSession();
    CityMapper cm = ss.getMapper(CityMapper.class);
    int rel = cm.deleteCityById(14007);
    System.out.println("rel: " + rel);
    ss.commit();
  }

  private static void testUpdate() {
    SqlSession ss = SqlSessionUtil.openSession();
    CityMapper cm = ss.getMapper(CityMapper.class);
    City c = new City();
    c.setId(14007);
    c.setName("myCity");
    c.setDistrict("myDistrict");
    int rel = cm.updateCity(c);
    System.out.println("rel: " + rel);
    ss.commit();
  }

  private static void test3() {
    SqlSession ss = SqlSessionUtil.openSession();
    // CityMapper 实际上是 MapperProxy的一个代理对象实例，其中拥有了SqlSession的实例，
    // 所以SqlSession对应的这个Mapper的所有查询都是在同一个事务内部
    CityMapper cm = ss.getMapper(CityMapper.class);
    //		Map<String, String> param = new HashMap<String, String>();
    //		param.put("name", "dah");
    //		param.put("countryCode", "AFG");
    //log.info(cm.queryCity(param));
    //log.info(cm.queryCityById(14003));
    City c = buildCity();
    cm.saveCity(c);
    System.out.println(c);
    //log.info(cm.countCityByName("dah"));
    // System.out.println(cm.queryCityById2(14003));
    //log.info(cm.queryCityByNameAndCountryCode("Qandahar", "AFG"));
    //cm.saveCity(buildCity());
    ss.commit();
    ss.close();
  }

  private static void test2() {
    SqlSessionFactory ssf = BuildSessionFactoryManually.buildSessionFactory();
    SqlSession ss = ssf.openSession();
    CityMapper cm = ss.getMapper(CityMapper.class);
    System.out.println(cm.queryCityById2(14003));
  }

  private static void test1() {
    SqlSession ss = SqlSessionUtil.openSession();
    // CityMapper 实际上是 MapperProxy的一个代理对象实例，其中拥有了SqlSession的实例，
    // 所以SqlSession对应的这个Mapper的所有查询都是在同一个事务内部
    CityMapper cm = ss.getMapper(CityMapper.class);
    //log.info(cm.queryCityById(1));
    log.info(cm.queryCityByNameAndCountryCode("Qandahar", "AFG"));
    log.info(cm.queryCityById2(3));
  }

  private static City buildCity() {
    City c = new City();
    c.setCountryCode("DMA");
    c.setDistrict("St George4");
    c.setName("Roseau4");
    c.setRole(Role.BIG);
    c.setPopulation(10000000);
    return c;
  }
}
