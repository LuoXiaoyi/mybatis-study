package com.lxy.study.mybatis.util;

/**
 * Project: mybatis.study
 *
 * @author Luo.xiaoyi
 * @date 2018/04/21
 */
public class PageInfo {

  private int pageSize;
  private int currentPageIndex;
  private int totalNumber;
  private int totalPage;

  public int getTotalNumber() {
    return totalNumber;
  }

  public void setTotalNumber(int totalNumber) {
    this.totalNumber = totalNumber;
  }

  public int getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getCurrentPageIndex() {
    return currentPageIndex;
  }

  public void setCurrentPageIndex(int currentPageIndex) {
    this.currentPageIndex = currentPageIndex;
  }
}
