/**
 * [Product]
 *     mybatis.study
 * [Copyright]
 *     Copyright © 2018 ZTESoft All Rights Reserved.
 * [FileName]
 *     ClassLoaderUtil.java
 * [History]
 *     Version  Date      Author     Content
 *     -------- --------- ---------- ------------------------
 *     1.0.0    Apr 15, 2018   Luo Xiaoyi    最初版本
 */
package com.lxy.study.mybatis.util;

/**
 * <p> Class: ClassLoaderUtil </p>
 * Description: 
 * 
 * @author Luo.xiaoyi
 * 
 */
public class ClassLoaderUtil {
	
	public static ClassLoader getDefaultClassLoader() {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		if(cl == null) {
			cl = ClassLoaderUtil.class.getClassLoader();
		}
		
		return cl;
	}

}
