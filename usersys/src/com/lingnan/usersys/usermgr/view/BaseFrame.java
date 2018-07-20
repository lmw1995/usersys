package com.lingnan.usersys.usermgr.view;

import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * BaseFrame接口
 * @author 12241
 *
 */
public interface BaseFrame {
	/**
	 * 页面显示
	 */
	public void show();
	/**
	 * 添加用户显示
	 * @param type 类型
	 */
	public void addShow(String type);
	/**
	 * 查询页面显示
	 */
	public void searchShow();
	/**
	 * 修改页面显示
	 * @param type 类型
	 * @param user 用户信息
	 */
	public void updateShow(String type,UserVO user);
}
