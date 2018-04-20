/**
 * [Product]
 *     mybatis.study
 * [Copyright]
 *     Copyright © 2018 ZTESoft All Rights Reserved.
 * [FileName]
 *     MyTypeHandler.java
 * [History]
 *     Version  Date      Author     Content
 *     -------- --------- ---------- ------------------------
 *     1.0.0    Apr 19, 2018   Luo Xiaoyi    最初版本
 */
package com.lxy.study.mybatis.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.lxy.study.mybatis.domain.models.Role;

/**
 * <p> Class: MyTypeHandler </p>
 * Description: 
 * 用于从数据库中获取某个特殊的对象，或者将某个对象格式化成特定的数据类型保持进数据库
 * 如：这里将一个Role对象作为字符串保存到数据库，而取出来的时候则反序列化成Role对象
 * @author Luo.xiaoyi
 * 
 */
public class MyTypeHandler
		extends BaseTypeHandler<Role> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Role parameter, JdbcType jdbcType)
			throws SQLException {
		if(parameter != null) {
			ps.setInt(i, parameter.getId());
			System.out.println("setNonNullParameter....");
		}
	}

	@Override
	public Role getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		System.out.println("getNullableResult....");
		int id = rs.getInt(columnName);
		return Role.toRole(id);
	}

	@Override
	public Role getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		System.out.println("getNullableResult 2....");
		int id = rs.getInt(columnIndex);
		return Role.toRole(id);
	}
	
	@Override
	public Role getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		System.out.println("getNullableResult 3....");
		int id = cs.getInt(columnIndex);
		return Role.toRole(id);
	}
}
