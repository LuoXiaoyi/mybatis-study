/**
 * [Product]
 *     mybatis.study
 * [Copyright]
 *     Copyright © 2018 ZTESoft All Rights Reserved.
 * [FileName]
 *     Role.java
 * [History]
 *     Version  Date      Author     Content
 *     -------- --------- ---------- ------------------------
 *     1.0.0    Apr 19, 2018   Luo Xiaoyi    最初版本
 */
package com.lxy.study.mybatis.domain.models;

import org.apache.ibatis.type.Alias;

/**
 * <p>
 * Class: Role
 * </p>
 * Description:
 * 
 * @author Luo.xiaoyi
 * 
 */
@Alias("role")
public enum Role {
	BIG(2), MEDIUM(1), SMALL(0);

	private int id;

	private Role(int i) {
		id = i;
	}
	
	public String toString() {
		return this.name().toLowerCase() + " city";
	}
	
	public static Role toRole(String roleStr) {
		switch (roleStr) {
		case "small city":
			return Role.SMALL;
		case "medium city":
			return Role.MEDIUM;
		case "big city":
			return Role.BIG;
		default:
			throw new IllegalArgumentException("unsupported role name for： " + roleStr);
		}
	}

	public static Role toRole(int id) {
		switch (id) {
		case 0:
			return Role.SMALL;
		case 1:
			return Role.MEDIUM;
		case 2:
			return Role.BIG;
		default:
			throw new IllegalArgumentException("unsupported id for： " + id);
		}
	}
	
	public int getId() {
		return id;
	}
}
