package com.lingnan.usersys.usermgr.business.service;

import java.util.List;

import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * 业务层service类
 * @author 12241
 *
 */
public interface UserService {
	/**
	 * 用户登陆
	 * @param username 用户名
	 * @param password 密码
	 * @return  用户信息
	 */
	public UserVO login(String username,String password); 
	/**
	 * 添加用户
	 * @param user 用户信息
	 * @return flag
	 */
	public boolean addUser(UserVO user);
	/**
	 * 通过id查询用户信息
	 * @param id  用户id
	 * @return 用户信息
	 */
	public UserVO findUserById(int id);
	/**
	 * 根据用户名来查询用户信息
	 * @param username 用户名
	 * @return list结果集
	 */
	public List<UserVO> findUserByName(String username);
	/**
	 * 查询所有用户信息
	 * @return 结果集
	 */
	public List<UserVO> findUserAll();
	/**
	 * 更新修改用户信息
	 * @param user 用户信息
	 * @return flag
	 */
	public boolean updateUser(UserVO user);
	/**
	 * 删除用户
	 * @param id 用户名
	 * @return flag
	 */
	public boolean deleteUser(int id);
	/**
	 * 指定页面查询用户信息
	 * @param pageNo 第几页
	 * @param pageSize 获取几条数据
	 * @return list结果集
	 */
	public List<UserVO> findUsers(int pageNo,int pageSize);
}
