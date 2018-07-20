package com.lingnan.usersys.usermgr.domain;

import java.util.Date;

/**
 * 用户信息类
 * @author 12241
 *
 */
public class UserVO {
    private int id;  			//编号
    private String userid; 		//用户编号
    private String username;	//用户名
    private String password;	//密码
    private String mail;		//邮箱
    private String power;		//权限
    private Date birth;			//出生年月
    private String status;		//标记
	/**
	 * 获取编号信息
	 * @return 返回编号的值
	 */
    public int getId() {
		return id;
	}
    /**
     * 设置编号的值
     * @param id 设置编号的值
     */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 获取用户编号
	 * @return 返回用户编号的值
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * 设置用户编号
	 * @param userid 用户id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 获取用户名
	 * @return 用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置用户名
	 * @param username 获取用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取密码
	 * @return 返回密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置密码
	 * @param password 设置密码的值
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取邮箱
	 * @return 返回邮箱的值
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * 设置邮箱 
	 * @param mail 设置邮箱
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * 获取权限
	 * @return power 返回权限
	 */
	public String getPower() {
		return power;
	}
	/**
	 * 设置权限
	 * @param power 设置权限
	 */
	public void setPower(String power) {
		this.power = power;
	}
	/**
	 *  获取出生日期
	 * @return 返回日期
	 */
	public Date getBirth() {
		return birth;
	}
	/**
	 * 设置出生日期
	 * @param birth 设置日期
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	/**
	 *  获取状态
	 * @return 返回状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置状态
	 * @param status 设置状态的值
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
