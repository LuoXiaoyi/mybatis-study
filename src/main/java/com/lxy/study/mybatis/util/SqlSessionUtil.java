/**
 * [Product]
 *     mybatis.study
 * [Copyright]
 *     Copyright © 2018 ZTESoft All Rights Reserved.
 * [FileName]
 *     SqlSessionUtil.java
 * [History]
 *     Version  Date      Author     Content
 *     -------- --------- ---------- ------------------------
 *     1.0.0    Apr 15, 2018   Luo Xiaoyi    最初版本
 */
package com.lxy.study.mybatis.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * <p>
 * Class: SqlSessionUtil
 * </p>
 * Description:
 * 
 * @author Luo.xiaoyi
 * 
 */
public class SqlSessionUtil {

	private static final SqlSessionFactory sqlSessionFactory;
	private static final String MYBATIS_CONFIG_FILE = "mybatis-config.xml";
	static {
		InputStream is = ClassLoaderUtil.getDefaultClassLoader()
				.getResourceAsStream(MYBATIS_CONFIG_FILE);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	public static SqlSession openSession() {
		return sqlSessionFactory.openSession();
	}
}
