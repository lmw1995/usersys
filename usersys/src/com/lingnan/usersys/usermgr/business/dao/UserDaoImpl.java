package com.lingnan.usersys.usermgr.business.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * DAO方法 实现类UserDaoImpl
 * 实现接口UserDao中所有的方法
 * @author 12241
 *
 */
	public class UserDaoImpl implements UserDao{
		/**
		 * 数据库连接
		 */
		private Connection conn;
		/**
		 * 构造方法
		 * @param conn 数据库连接
		 */
		public UserDaoImpl(Connection conn){
			//给属性赋初始化值
			this.conn=conn;
		}
	/**
	 * 用户登录方法
	 */
		public UserVO login(String username,String password){
			//声明预编译的声明对象变量，用于进行数据库操作的载体
			PreparedStatement pstat=null;
			//声明结果集对象变量，用于保存数据库查询结果
			ResultSet rs=null;
			//声明用户对象变量，用于保存从结果集中提取出来的数据
			UserVO UserVO=null;
			try {
				//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
				pstat=conn.prepareStatement("select * from T_user where username=? and password=? and status=1");
				//调用预编译对象的setXXX方法，给？号赋值
				pstat.setString(1, username);
				pstat.setString(2, password);
				//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
				rs=pstat.executeQuery();
				if(rs.next()){
					//创建一个新用户对象，赋值给用户对象变量
					 UserVO = new UserVO();
					 UserVO.setId(rs.getInt("id"));
					 UserVO.setUserid(rs.getString("userid"));
					 UserVO.setUsername(rs.getString("username"));
					 UserVO.setPassword(rs.getString("password"));
					 UserVO.setMail(rs.getString("mail"));
					 UserVO.setPower(rs.getString("power"));
					 UserVO.setBirth(rs.getDate("birth"));
					 UserVO.setStatus(rs.getString("status"));				
				}
			} catch (SQLException e) {
				throw new DaoException("登陆时查询数据出错",e);			
			}
			finally{
				DBUtils.closeStatement(rs, pstat);
			}				
			return UserVO;
		}
		/**
		 * 添加用户方法
		 * @return  flag
		 */
		@Override
		public boolean addUser(UserVO user) {
			boolean flag=false;
			//声明预编译的声明对象变量，用于进行数据库操作的载体
			PreparedStatement pstat=null;
			//声明变量，用于保存数据库更新结果
			try {
				//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
				pstat=conn.prepareStatement("insert into  T_user(id,userid,username,password,mail,birth,power,status) values(?,?,?,?,?,?,?,?)");	
				//调用预编译对象的setXXX方法，给？号赋值
				pstat.setInt(1, user.getId());
				pstat.setString(2, user.getUserid());
				pstat.setString(3, user.getUsername());
				pstat.setString(4, user.getPassword());
				pstat.setString(5, user.getMail());
				
				//将java.util.Date类型转换成java.sql.Date类型
				pstat.setDate(6, new java.sql.Date(user.getBirth().getTime()));		
				pstat.setString(7, user.getPower());
				pstat.setString(8,user.getStatus());
				pstat.executeUpdate(); 
				flag=true;							
		}catch(SQLException e){
			throw new DaoException("添加用户数据出错",e);
		}
			finally{
				DBUtils.closeStatement(null, pstat);
			}
			return flag;
       }	
		/**
		 * 查询用户中最大id
		 * 返回最大id值
		 */
		@Override
		public int findMaxId() {
			int max=-1;
			ResultSet rs=null;
			PreparedStatement pstat=null;
			try {
				pstat=conn.prepareStatement("select max(id) from T_user");
				rs=pstat.executeQuery();
				if(rs.next()){
					max=rs.getInt("max(id)");
				}
				else{
					max=0;
				}
			} catch (SQLException e) {
				System.out.println("在查询最大id时候出错了"+e.getMessage());
			}
			return max;
		}
		/**
		 * 根据用户id查询用户信息
		 */
		@Override
		public UserVO findUserById(int id) {
			//声明预编译的声明对象变量，用于进行数据库操作的载体
			PreparedStatement pstat=null;
			//声明结果集对象变量，用于保存数据库查询结果
			ResultSet rs=null;
			//声明用户对象变量，用于保存从结果集中提取出来的数据
			UserVO UserVO=null;
			try {
				//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
				pstat=conn.prepareStatement("select * from T_user where id=? and status=1");
				//调用预编译对象的setXXX方法，给？号赋值
				pstat.setInt(1, id);
				//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
				rs=pstat.executeQuery();
				if(rs.next()){
					//创建一个新用户对象，赋值给用户对象变量
					 UserVO = new UserVO();
					 UserVO.setId(rs.getInt("id"));
					 UserVO.setUserid(rs.getString("userid"));
					 UserVO.setUsername(rs.getString("username"));
					 UserVO.setPassword(rs.getString("password"));
					 UserVO.setMail(rs.getString("mail"));
					 UserVO.setPower(rs.getString("power"));
					 UserVO.setBirth(rs.getDate("birth"));
					 UserVO.setStatus(rs.getString("status"));				
				}
			} catch (SQLException e) {
				throw new DaoException("登陆时查询数据出错",e);			
			}
			finally{
				DBUtils.closeStatement(rs, pstat);
			}				
			return UserVO;
		}
		/**
		 * 更新修改用户信息
		 */
		@Override
		public boolean updateUser(UserVO user) {
			boolean flag=false;
			//声明预编译的声明对象变量，用于进行数据库操作的载体
			PreparedStatement pstat=null;
			//声明变量，用于保存数据库更新结果
			try {
				//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
				pstat=conn.prepareStatement("update  T_user set username=?,password=?,mail=?,birth=?,power=? where id=?");	
				//调用预编译对象的setXXX方法，给？号赋值
				pstat.setString(1, user.getUsername());
				pstat.setString(2, user.getPassword());
				pstat.setString(3, user.getMail());			
				//将java.util.Date类型转换成java.sql.Date类型
				pstat.setDate(4, new java.sql.Date(user.getBirth().getTime()));		
				pstat.setString(5, user.getPower());
				pstat.setInt(6, user.getId());
				pstat.executeUpdate(); 
				flag=true;							
		}catch(SQLException e){
			throw new DaoException("修改用户数据出错",e);
		}
			finally{
				DBUtils.closeStatement(null, pstat);
			}
			return flag;
		}
		/**
		 * 根据用户名来查询用户信息
		 */
		@Override
		public List<UserVO> findUserByName(String username) {
			//声明预编译的声明对象变量，用于进行数据库操作的载体
			PreparedStatement pstat=null;
			//声明结果集对象变量，用于保存数据库查询结果
			ResultSet rs=null;		
			UserVO  UserVO=null;
			List<UserVO> list= new ArrayList<UserVO>();
			try {
				//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
				pstat=conn.prepareStatement("select * from T_user where username=? and status=1");
				//调用预编译对象的setXXX方法，给？号赋值
				pstat.setString(1, username);
				//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
				rs=pstat.executeQuery();
				if(rs.next()){
					//创建一个新用户对象，赋值给用户对象变量
					  UserVO=new UserVO();
					 UserVO.setId(rs.getInt("id"));
					 UserVO.setUserid(rs.getString("userid"));
					 UserVO.setUsername(rs.getString("username"));
					 UserVO.setPassword(rs.getString("password"));
					 UserVO.setMail(rs.getString("mail"));
					 UserVO.setPower(rs.getString("power"));
					 UserVO.setBirth(rs.getDate("birth"));
					 UserVO.setStatus(rs.getString("status"));
					 list.add(UserVO);
//					 	System.out.print(rs.getInt("id")+" ");
//						System.out.print(rs.getString("userid")+" ");
//						System.out.print(rs.getString("username")+" ");
//						System.out.print(rs.getString("password")+" ");
//						System.out.print(rs.getString("mail")+" ");
//						System.out.print(rs.getString("power")+" ");
//						System.out.print(rs.getDate("birth")+" ");
//						System.out.println(rs.getString("status")+" ");
				}
			} catch (SQLException e) {
				throw new DaoException("根据用户名查询数据出错",e);			
			}
			finally{
				DBUtils.closeStatement(rs, pstat);
			}				
			return list;
		}
		/**
		 * 查询所有的用户信息
		 */
		@Override
		public List<UserVO> finUserAll() {
			//声明预编译的声明对象变量，用于进行数据库操作的载体
			PreparedStatement pstat=null;
			//声明结果集对象变量，用于保存数据库查询结果
			ResultSet rs=null;		
			UserVO  UserVO=null;
			List<UserVO> list= new ArrayList<UserVO>();
			try {
				//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
				pstat=conn.prepareStatement("select * from T_user where  status=1");
				//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
				rs=pstat.executeQuery();
				while(rs.next()){
					//创建一个新用户对象，赋值给用户对象变量
					  UserVO=new UserVO();
					 UserVO.setId(rs.getInt("id"));
					 UserVO.setUserid(rs.getString("userid"));
					 UserVO.setUsername(rs.getString("username"));
					 UserVO.setPassword(rs.getString("password"));
					 UserVO.setMail(rs.getString("mail"));
					 UserVO.setPower(rs.getString("power"));
					 UserVO.setBirth(rs.getDate("birth"));
					 UserVO.setStatus(rs.getString("status"));
					 list.add(UserVO);

				}
			} catch (SQLException e) {
				throw new DaoException("查询所有用户数据出错",e);			
			}
			finally{
				DBUtils.closeStatement(rs, pstat);
			}				
			return list;
		}
		/**
		 * 删除用户
		 */
		@Override
		public boolean deleteUser(int id) {
			boolean flag=false;
			//声明预编译的声明对象变量，用于进行数据库操作的载体
			PreparedStatement pstat=null;
			//声明变量，用于保存数据库更新结果
			try {
				//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
				pstat=conn.prepareStatement("delete from  T_user  where id=?");	
				//调用预编译对象的setXXX方法，给？号赋值
				pstat.setInt(1, id);	
				pstat.executeUpdate(); 
				flag=true;							
		}catch(SQLException e){
			throw new DaoException("删除用户数据出错",e);
		}
			finally{
				DBUtils.closeStatement(null, pstat);
			}
			return flag;
		}
		/**
		 * 指定页面获取用户信息
		 */
		@Override
		public List<UserVO> findUsers(int pageNo, int pageSize) {
			//声明预编译的声明对象变量，用于进行数据库操作的载体
			PreparedStatement pstat=null;
			//声明结果集对象变量，用于保存数据库查询结果
			ResultSet rs=null;		
			UserVO  UserVO=null;
			List<UserVO> list= new ArrayList<UserVO>();
			try {
				//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
				pstat = conn.prepareStatement("select * from (select t2.*,rownum rn from (select t1.* from t_user t1 order by id) t2) " +
						"where rn>? and rn<=?");
				pstat.setInt(1, (pageNo-1)*pageSize);
				pstat.setInt(2, pageSize*pageNo);
				//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
				rs=pstat.executeQuery();
				while(rs.next()){
					//创建一个新用户对象，赋值给用户对象变量
					  UserVO=new UserVO();
					 UserVO.setId(rs.getInt("id"));
					 UserVO.setUserid(rs.getString("userid"));
					 UserVO.setUsername(rs.getString("username"));
					 UserVO.setPassword(rs.getString("password"));
					 UserVO.setMail(rs.getString("mail"));
					 UserVO.setPower(rs.getString("power"));
					 UserVO.setBirth(rs.getDate("birth"));
					 UserVO.setStatus(rs.getString("status"));
					 list.add(UserVO);
				}
			} catch (SQLException e) {
				throw new DaoException("指定页面查询用户数据出错",e);			
			}
			finally{
				DBUtils.closeStatement(rs, pstat);
			}				
			return list;
		}
}
	
