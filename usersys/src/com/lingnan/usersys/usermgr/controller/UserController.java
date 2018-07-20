package com.lingnan.usersys.usermgr.controller;

import java.util.List;

import com.lingnan.usersys.usermgr.business.service.UserService;
import com.lingnan.usersys.usermgr.business.service.UserServiceImpl;
import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * service 控制层包
 * @author 12241
 *
 */
public class UserController {
	//声明用户service接口对象，用于业务处理
	UserService userMgrService =UserServiceImpl.getInstance();
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
	public UserVO dologin(String username,String password){
		UserVO user=null;
		try{
			//调用用户service接口中的login方法，进行用户登录操作
			user=userMgrService.login(username, password);
		}catch(Exception e){
			//显示异常信息
			System.out.println("用户登录的时候出错了"+e.getMessage());
		}			
		return  user;
	}
	/**
	 * 用户注册
	 * @param user 用户信息
	 * @return flag
	 */
	public boolean doRegister(UserVO user){
		boolean flag=false;
		try{
			//调用用户service的addUser方法，进行注册用户操作
			flag=userMgrService.addUser(user);
		}catch(Exception e){
			//显示异常信息
			System.out.println("注册用户的时候出错了"+e.getMessage());
		}
		return flag;		
	}
	/**
	 * 根据id查询信息
	 * @param id 用户id
	 * @return 用户信息
	 */
	public UserVO dofind(int id){
		UserVO user=null;
		try{
			//调用用户service接口中的findUserById方法，进行用户查询
			user=userMgrService.findUserById(id);
		}catch(Exception e){
			System.out.println("用户根据Id查询信息的时候出错了"+e.getMessage());
		}
		return user;		
	}
	/**
	 * 更新用户信息
	 * @param user 用户信息
	 * @return flag
	 */
	public boolean doUpdate(UserVO user){
		boolean flag=false;
		try{
			//调用用户service的updateUser方法，进行更新用户操作
			flag=userMgrService.updateUser(user);
		}catch(Exception e){
			//显示异常信息
			System.out.println("更新用户数据的时候出错了"+e.getMessage());
		}
		return flag;	
	}
	/**
	 * 根据用户名查询用户信息
	 * @param username 用户名
	 * @return list结果集
	 */
	public List<UserVO> dofindUserByName(String username){
		List<UserVO> list=null;
		try{
			//调用用户service接口中的findUserByName方法，进行用户查询
		list=userMgrService.findUserByName(username);
		}catch(Exception e){
			System.out.println("用户根据Name查询信息的时候出错了"+e.getMessage());
		}
		return list;		
	}
	/**
	 * 查询所有用户信息
	 * @return list结果集
	 */
	public List<UserVO> dofindUserAll(){
		List<UserVO> list=null;
		try{
			//调用用户service接口中的findUserAll方法，进行用户查询
		list=userMgrService.findUserAll();
		}catch(Exception e){
			System.out.println("查询所有用户信息的时候出错了"+e.getMessage());
		}
		return list;		
	}
	/**
	 * 删除用户
	 * @param id 用户id
	 * @return flag
	 */
	public boolean dodelete(int id){
		boolean flag=false;
		try{
			//调用用户service的deleteUser方法，进行删除用户操作
			flag=userMgrService.deleteUser(id);
		}catch(Exception e){
			//显示异常信息
			System.out.println("删除用户的时候出错了"+e.getMessage());
		}
		return flag;	
	}
	/**
	 * 指定页面获取用户信息
	 * @param pageNo 第几页
	 * @param pageSize 多少数据
	 * @return list结果集
	 */
	public List<UserVO> dofindUsers(int pageNo,int pageSize){
		List<UserVO> list=null;
		try{
			//调用用户service接口中的findUsers方法，进行用户查询
		list=userMgrService.findUsers(pageNo, pageSize);
		}catch(Exception e){
			System.out.println("指定页面查询用户信息的时候出错了"+e.getMessage());
		}
		return list;		
	}
	
}
