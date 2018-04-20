/**
 * [Product]
 *     mybatis.study
 * [Copyright]
 *     Copyright © 2018 ZTESoft All Rights Reserved.
 * [FileName]
 *     BuildSessionFactoryManually.java
 * [History]
 *     Version  Date      Author     Content
 *     -------- --------- ---------- ------------------------
 *     1.0.0    Apr 16, 2018   Luo Xiaoyi    最初版本
 */
package com.lxy.study.mybatis.util;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.lxy.study.mybatis.domain.daos.CityMapper;
import com.lxy.study.mybatis.domain.models.City;

import org.apache.ibatis.session.Configuration;
/**
 * <p> Class: BuildSessionFactoryManually </p>
 * Description: 
 * 
 * @author Luo.xiaoyi
 * 
 */
public class BuildSessionFactoryManually {
	
	public static SqlSessionFactory buildSessionFactory() {
		
		// 构建数据库连接池
		PooledDataSource pd = buildDataSource();
		// 构建数据库事务方式, JDBC
		TransactionFactory tf = new JdbcTransactionFactory();
		// 创建数据库的运行环境
		Environment e = new Environment("dev", tf, pd);
		// 构建Configuration对象
		Configuration config = new Configuration(e);
		// 注册一个mybatis的上下文的别名
		config.getTypeAliasRegistry().registerAlias("city", City.class);
		// 加入一个映射器，这个映射器的接口方法，只有通过注解注入才能正常被调用
		config.addMapper(CityMapper.class);
		// 使用SqlSessionFactoryBuilder构建SqlSessionFactory对象
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		
		return ssf;
	}

	/**
	 * @return
	 */
	private static PooledDataSource buildDataSource() {
		PooledDataSource pd = new PooledDataSource();
		pd.setDriver("com.mysql.jdbc.Driver");
		pd.setUrl("jdbc:mysql://127.0.0.1:3310/world?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false&useSSL=true");
		pd.setUsername("root");
		pd.setPassword("root");
		return pd;
	}

}
