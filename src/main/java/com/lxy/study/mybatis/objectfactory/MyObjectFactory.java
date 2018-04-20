/**
 * [Product]
 *     mybatis.study
 * [Copyright]
 *     Copyright © 2018 ZTESoft All Rights Reserved.
 * [FileName]
 *     MyObjectFactory.java
 * [History]
 *     Version  Date      Author     Content
 *     -------- --------- ---------- ------------------------
 *     1.0.0    Apr 20, 2018   Luo Xiaoyi    最初版本
 */
package com.lxy.study.mybatis.objectfactory;

import java.util.List;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

/**
 * <p> Class: MyObjectFactory </p>
 * Description: 
 * 自定义对象工厂，用于创建在运行时需要构建的对象（如：从数据库中查询数据，
 * 返回的数据需要映射到一个对象，则此时需要此factory用于构建对象）。
 * @author Luo.xiaoyi
 * 
 */
public class MyObjectFactory
		extends DefaultObjectFactory {
	private static final long serialVersionUID = -7849388429203680845L;
	
	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
	   System.out.println("MyObjectFactory create instance--> " + type.getCanonicalName());
	   return super.create(type, constructorArgTypes, constructorArgs);
	}
}
