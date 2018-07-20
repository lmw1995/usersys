package com.lingnan.usersys.usermgr.business.service;

import java.sql.Connection;
import java.util.List;

import com.lingnan.usersys.common.constant.EnumType;
import com.lingnan.usersys.common.dao.DaoFactory;
import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.business.dao.UserDao;
import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * 业务层service类的实例类
 * @author 12241
 *
 */
public class UserServiceImpl implements UserService{
	/**
	 * 用户service类实例
	 */
	private static UserService userService =new UserServiceImpl();
	/**
	 * 构造方法
	 */
	private UserServiceImpl(){
		
	}
	/**
	 * 取得用户service实例
	 * @return 实例对象
	 */
	public static UserService getInstance(){
		return userService;
		
	}
	/**
	 * 用户登录
	 */
	public UserVO login(String username,String password){
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		UserVO user=null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao()方法，取得指定类型的dao接口的实现类。并赋值给dao接口变量
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用dao中的login方法，进行登陆操作，结果赋值给登录结果变量
			user = userMgrDao.login(username, password);
		}
		catch(DaoException e){
			//将自定义异常抛出
			throw e;
		}
		catch(Exception e){
			//讲异常封装成自定义异常并抛出
			throw new ServiceException("用户登陆错误",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
        //返回用户登陆结果		
		return user;
	
	}
	/**
	 * 添加或注册用户
	 */
	@Override
	public boolean addUser(UserVO user) {
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn=null;
				boolean flag=false;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn=DBUtils.getConnection();
					//调用dao工厂类的getDao()方法，取得指定类型的dao接口的实现类。并赋值给dao接口变量
					UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
					//调用数据库工具类的beginTransaction方法，开启事务
					DBUtils.beginTransaction(conn);
					//调用dao 中的findMaxId方法,	取得最大id值，再加上1，设置给用户属性id
					user.setId(userMgrDao.findMaxId()+1);
					//设置用户权限为普通用户
					user.setPower("普通用户");
					//设置用户状态为1
					user.setStatus("1");
					//调用dao中的adduser方法，进行数据库插入操作，结果赋值给插入结果变量
					 flag =userMgrDao.addUser(user);
					 //调用数据库工具类的commit方法，提交事务
					 DBUtils.commit(conn);					 
				}//操作过程出现异常，调用数据库工具类的rollback方法，回滚事务
				catch(DaoException e){
					//将自定义异常抛出
					throw e;
				}
				catch(Exception e){
					DBUtils.rollback(conn);
					//将异常封装成自定义异常并抛出
					throw new ServiceException("添加用户或者注册失败",e);
				}finally{
					//关闭连接
					DBUtils.closeConnection(conn);
				}
				return flag;
	}
	/**
	 * 根据id查询用户信息
	 */
	@Override
	public UserVO findUserById(int id) {
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn=null;
				UserVO user=null;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn=DBUtils.getConnection();
					//调用dao工厂类的getDao()方法，取得指定类型的dao接口的实现类。并赋值给dao接口变量
					UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
					//调用数据库工具类的beginTransaction方法，开启事务
					DBUtils.beginTransaction(conn);
					//调用dao中的findUserById方法，进行查询操作
					user = userMgrDao.findUserById(id);
					 //调用数据库工具类的commit方法，提交事务
					 DBUtils.commit(conn);		
				}
				catch(DaoException e){
					//将自定义异常抛出
					throw e;
				}
				catch(Exception e){
					DBUtils.rollback(conn);
					//将异常封装成自定义异常并抛出
					throw new ServiceException("根据id查询用户信息失败",e);
				}finally{
					//关闭连接
					DBUtils.closeConnection(conn);
				}
		        //返回用户登陆结果		
				return user;		
	}
	/**
	 * 更新用户信息
	 */
	@Override
	public boolean updateUser(UserVO user) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		boolean flag=false;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao()方法，取得指定类型的dao接口的实现类。并赋值给dao接口变量
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用数据库工具类的beginTransaction方法，开启事务
			DBUtils.beginTransaction(conn);
			//调用dao中的updateUser方法，进行数据库更新操作，结果赋值给更新结果变量
			 flag =userMgrDao.updateUser(user);
			 //调用数据库工具类的commit方法，提交事务
			 DBUtils.commit(conn);					 
		}//操作过程出现异常，调用数据库工具类的rollback方法，回滚事务
		catch(DaoException e){
			//将自定义异常抛出
			throw e;
		}
		catch(Exception e){
			DBUtils.rollback(conn);
			//将异常封装成自定义异常并抛出
			throw new ServiceException("更新用户数据失败",e);
		}finally{
			//关闭连接
			DBUtils.closeConnection(conn);
		}
		return flag;
	}
	/**
	 * 根据用户名查询用户信息
	 */
	@Override
	public List<UserVO> findUserByName(String username) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		List<UserVO> list=null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao()方法，取得指定类型的dao接口的实现类。并赋值给dao接口变量
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用数据库工具类的beginTransaction方法，开启事务
			DBUtils.beginTransaction(conn);
			//调用dao中的findUserByName方法，进行查询操作
			list = userMgrDao.findUserByName(username);
			 //调用数据库工具类的commit方法，提交事务
			 DBUtils.commit(conn);	
		}//操作过程出现异常，调用数据库工具类的rollback方法，回滚事务
				catch(DaoException e){
					//将自定义异常抛出
					throw e;
				}
				catch(Exception e){
					DBUtils.rollback(conn);
					//将异常封装成自定义异常并抛出
					throw new ServiceException("根据用户名查询用户信息失败",e);
				}finally{
					//关闭连接
					DBUtils.closeConnection(conn);
				}
        //返回用户登陆结果		
		return list;		
		}
	/**
	 * 查询所有用户信息
	 */
	@Override
	public List<UserVO> findUserAll() {
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn=null;
				List<UserVO> list=null;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn=DBUtils.getConnection();
					//调用dao工厂类的getDao()方法，取得指定类型的dao接口的实现类。并赋值给dao接口变量
					UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
					//调用数据库工具类的beginTransaction方法，开启事务
					DBUtils.beginTransaction(conn);
					//调用dao中的findUserAll方法，进行查询所有用户信息操作，结果赋值给list
					list = userMgrDao.finUserAll();
					 //调用数据库工具类的commit方法，提交事务
					 DBUtils.commit(conn);	
				}//操作过程出现异常，调用数据库工具类的rollback方法，回滚事务
						catch(DaoException e){
							//将自定义异常抛出
							throw e;
						}
						catch(Exception e){
							DBUtils.rollback(conn);
							//将异常封装成自定义异常并抛出
							throw new ServiceException("查询所有用户信息失败",e);
						}finally{
							//关闭连接
							DBUtils.closeConnection(conn);
						}
		        //返回用户登陆结果		
				return list;		
			}
	/**
	 * 查询所有有效用户
	 */
	@Override
	public List<UserVO> finUserAllStatus() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		List<UserVO> list=null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao()方法，取得指定类型的dao接口的实现类。并赋值给dao接口变量
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用数据库工具类的beginTransaction方法，开启事务
			DBUtils.beginTransaction(conn);
			//调用dao中的findUserAll方法，进行查询所有用户信息操作，结果赋值给list
			list = userMgrDao.finUserAllStatus();
			 //调用数据库工具类的commit方法，提交事务
			 DBUtils.commit(conn);	
		}//操作过程出现异常，调用数据库工具类的rollback方法，回滚事务
				catch(DaoException e){
					//将自定义异常抛出
					throw e;
				}
				catch(Exception e){
					DBUtils.rollback(conn);
					//将异常封装成自定义异常并抛出
					throw new ServiceException("查询所有用户信息失败",e);
				}finally{
					//关闭连接
					DBUtils.closeConnection(conn);
				}
        //返回用户登陆结果		
		return list;		
	}
	/**
	 * 删除用户
	 */
	@Override
	public boolean deleteUser(int id) {
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn=null;
				boolean flag=false;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn=DBUtils.getConnection();
					//调用dao工厂类的getDao()方法，取得指定类型的dao接口的实现类。并赋值给dao接口变量
					UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
					//调用数据库工具类的beginTransaction方法，开启事务
					DBUtils.beginTransaction(conn);
					//调用dao中的deleteUser方法，进行删除用户
					 flag =userMgrDao.deleteUser(id);
					 //调用数据库工具类的commit方法，提交事务
					 DBUtils.commit(conn);					 
				}//操作过程出现异常，调用数据库工具类的rollback方法，回滚事务
				catch(DaoException e){
					//将自定义异常抛出
					throw e;
				}
				catch(Exception e){
					DBUtils.rollback(conn);
					//将异常封装成自定义异常并抛出
					throw new ServiceException("删除用户数据失败",e);
				}finally{
					//关闭连接
					DBUtils.closeConnection(conn);
				}
				return flag;
	}
	/**
	 * 指定页面获取用户信息
	 */
	@Override
	public List<UserVO> findUsers(int pageNo, int pageSize) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		List<UserVO> list=null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao()方法，取得指定类型的dao接口的实现类。并赋值给dao接口变量
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用数据库工具类的beginTransaction方法，开启事务
			DBUtils.beginTransaction(conn);
			//调用dao中的findUsers方法，
			list = userMgrDao.findUsers(pageNo, pageSize);
			 //调用数据库工具类的commit方法，提交事务
			 DBUtils.commit(conn);	
		}//操作过程出现异常，调用数据库工具类的rollback方法，回滚事务
				catch(DaoException e){
					//将自定义异常抛出
					throw e;
				}
				catch(Exception e){
					DBUtils.rollback(conn);
					//将异常封装成自定义异常并抛出
					throw new ServiceException("指定页面查询用户信息失败",e);
				}finally{
					//关闭连接
					DBUtils.closeConnection(conn);
				}
        //返回用户登陆结果		
		return list;		
	}
	
	
}
