/**
 * [Product]
 *     mybatis.study
 * [Copyright]
 *     Copyright © 2018 ZTESoft All Rights Reserved.
 * [FileName]
 *     MyParam.java
 * [History]
 *     Version  Date      Author     Content
 *     -------- --------- ---------- ------------------------
 *     1.0.0    Apr 19, 2018   Luo Xiaoyi    最初版本
 */
package com.lxy.study.mybatis.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p> Class: MyParam </p>
 * Description: 
 * 
 * @author Luo.xiaoyi
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface MyParam {
	String value() default "";
}
