package com.lingnan.usersys.common.util;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
/**
 * 验证邮箱和日期转换工具包测试类
 * @author 12241
 *
 */
public class TypeUtilsTest {

	@Test
	public void testCheckEmail() {
		boolean flag=TypeUtils.checkEmail("122@163.com");
		System.out.println("邮箱是否正确："+flag);
	}

	@Test
	public void testStrToDate() {
		String date="2017-10-13";
		System.out.println("字符串转换成日期：" +TypeUtils.strToDate(date));
	}

	@Test
	public void testDateToStr() {
		Date date=new Date();
		System.out.println("日期转换成字符串：" +TypeUtils.dateToStr(date));
	}

}
