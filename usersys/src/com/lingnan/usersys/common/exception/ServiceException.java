package com.lingnan.usersys.common.exception;
/**
 * 业务层异常装成自定义异常
 * @author 12241
 *
 */
public class ServiceException extends RuntimeException{
/**
 * 默认的构造方法
 */
	public ServiceException() {
		super();
	}
	/**
	 * 构造方法
	 * @param arg0 异常的详细信息
	 * @param arg1 产生异常的原因
	 */
	public ServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	/**
	 * 构造方法
	 * @param arg0 异常的详细信息
	 */
	public ServiceException(String arg0) {
		super(arg0);
	}
	/**
	   * 构造方法
	   * @param arg0 产生异常的原因
	   */
	public ServiceException(Throwable arg0) {
		super(arg0);
	}

}
