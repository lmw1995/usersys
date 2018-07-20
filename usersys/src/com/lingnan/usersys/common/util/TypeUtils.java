package com.lingnan.usersys.common.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.exception.EmailException;
/**
 * 验证邮箱和日期转换工具包
 * @author 12241
 *
 */
public class TypeUtils {
	/**
	 * 验证邮箱格式
	 * @param email 邮箱
	 * @return flag
	 */
	 public static boolean checkEmail(String email){
	        boolean flag = false;
	        try{
	                String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	                Pattern regex = Pattern.compile(check);
	                Matcher matcher = regex.matcher(email);
	                flag = matcher.matches();
	            }catch(Exception e){
	            	throw new EmailException("验证邮箱格式失败",e);

	            }
	        return flag;
		}
		/**
		 * 字符串转换为日期
		 * @param str 指定的字符串
		 * @return  转换后的日期
		 */
		public static Date strToDate(String str){
			Date date=null;
			//设置要格式化的日期格式
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    		try {
			date=sdf.parse(str);
			} catch (ParseException e) {
			//将异常封装成自定义异常
			throw new DateException("字符串转换日期失败",e);
			}
    	//返回转换后的值
    	return date;
		}
		/**
		 * 日期转换为字符串
		 * @param date 指定的日期
		 * @return 转换后的字符串
     	*/
		public static String dateToStr(Date date ){
			String str=null;
			//设置要格式化的日期格式
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			str=format.format(date);
			//返回转换后的值
			return str;   	
		}
}
