package com.lingnan.usersys.usermgr.business.dao;

import java.sql.Connection;
import java.util.List;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * 用户dao方法接口
 * @author 12241
 *
 */
public interface UserDao extends BaseDao {
	/**
	 * 用户登陆
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
	public UserVO login(String username,String password);
	/**
	 * 添加用户
	 * @param user 用户信息
	 * @return flag
	 */
	public boolean addUser(UserVO user);
	/**
	 * 查询用户中最大id值
	 * @return 返回最大id值
	 */
	public int findMaxId();
	/**
	 * 根据id查询用户信息
	 * @param id 用户id
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
	 * 查询所有的用户信息
	 * @return list结果集
	 */
	public List<UserVO> finUserAll();
	/**
	 * 修改更新用户信息
	 * @param user 用户信息
	 * @return flag
	 */
	public boolean updateUser(UserVO user);
	/**
	 * 删除用户
	 * @param id 用户id
	 * @return flag
	 */ 
	public boolean deleteUser(int id);
	/**
	 * 获取分页的用户信息
	 * @param pageNo   第几页      
	 * @param pageSize 每页多少条数据  
	 * @return list结果集
	 */
	public List<UserVO> findUsers(int pageNo,int pageSize);
}
 