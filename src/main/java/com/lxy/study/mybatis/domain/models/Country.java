package com.lxy.study.mybatis.domain.models;

import com.sun.org.apache.bcel.internal.classfile.Code;
import java.io.Serializable;
import java.util.List;
import sun.rmi.server.InactiveGroupException;

/**
 * Project: mybatis.study
 *
 * @author Luo.xiaoyi
 * @date 2018/04/21
 */
public class Country implements Serializable {

  public Country(String code,String name){
    this.code = code;
    this.name = name;
  }

  private String code;
  private String name;
  private Continent continent;
  private String region;
  private Double surfaceArea;
  private Integer indepYear;
  private Integer population;
  private Double lifeExpectancy;
  private Double gnp;
  private Double gnpOld;
  private String localName;
  private String governmentForm;
  private String headOfState;
  private Integer capital;
  private String code2;
  private List<City> cities;

  public List<City> getCities() {
    return cities;
  }

  public void setCities(List<City> cities) {
    this.cities = cities;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Continent getContinent() {
    return continent;
  }

  public void setContinent(Continent continent) {
    this.continent = continent;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public Double getSurfaceArea() {
    return surfaceArea;
  }

  public void setSurfaceArea(Double surfaceArea) {
    this.surfaceArea = surfaceArea;
  }

  public Integer getIndepYear() {
    return indepYear;
  }

  public void setIndepYear(Integer indepYear) {
    this.indepYear = indepYear;
  }

  public Integer getPopulation() {
    return population;
  }

  public void setPopulation(Integer population) {
    this.population = population;
  }

  public Double getLifeExpectancy() {
    return lifeExpectancy;
  }

  public void setLifeExpectancy(Double lifeExpectancy) {
    this.lifeExpectancy = lifeExpectancy;
  }

  public Double getGnp() {
    return gnp;
  }

  public void setGnp(Double gnp) {
    this.gnp = gnp;
  }

  public Double getGnpOld() {
    return gnpOld;
  }

  public void setGnpOld(Double gnpOld) {
    this.gnpOld = gnpOld;
  }

  public String getLocalName() {
    return localName;
  }

  public void setLocalName(String localName) {
    this.localName = localName;
  }

  public String getGovernmentForm() {
    return governmentForm;
  }

  public void setGovernmentForm(String governmentForm) {
    this.governmentForm = governmentForm;
  }

  public String getHeadOfState() {
    return headOfState;
  }

  public void setHeadOfState(String headOfState) {
    this.headOfState = headOfState;
  }

  public Integer getCapital() {
    return capital;
  }

  public void setCapital(Integer capital) {
    this.capital = capital;
  }

  public String getCode2() {
    return code2;
  }

  public void setCode2(String code2) {
    this.code2 = code2;
  }

  @Override
  public String toString() {
    return "Country{" +
        "code='" + code + '\'' +
        ", name='" + name + '\'' +
        ", continent=" + continent +
        ", region='" + region + '\'' +
        ", surfaceArea=" + surfaceArea +
        ", indepYear=" + indepYear +
        ", population=" + population +
        ", lifeExpectancy=" + lifeExpectancy +
        ", gnp=" + gnp +
        ", gnpOld=" + gnpOld +
        ", localName='" + localName + '\'' +
        ", governmentForm='" + governmentForm + '\'' +
        ", headOfState='" + headOfState + '\'' +
        ", capital=" + capital +
        ", code2='" + code2 + '\'' +
        '}';
  }
}
