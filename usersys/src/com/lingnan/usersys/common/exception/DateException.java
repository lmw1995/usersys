package com.lingnan.usersys.common.exception;
/**
 * 日期转换时发生的异常
 * @author 12241
 *
 */
public class DateException extends ServiceException{
/**
 * 默认的构造方法
 */
	public DateException() {
		super();
		// TODO Auto-generated constructor stub
	}
/**
 * 构造方法
 * @param arg0 异常的详细信息
 * @param arg1 产生异常的原因
 */
	public DateException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
/**
 * 构造方法
 * @param arg0 异常的详细信息
 */
	public DateException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
/**
 * 构造方法
 * @param arg0 产生异常的原因
 */
	public DateException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
