package com.lingnan.usersys.usermgr.business.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * DAO方法 实现类UserDaoImpl
 * 实现接口UserDao中所有的方法
 * 的测试类
 * @author 12241
 *
 */
public class UserDaoImplTest {

	@Test
	public void testLogin() {
		Connection conn=null;
		conn=DBUtils.getConnection();
		 UserDaoImpl US=new UserDaoImpl(conn);
//		 US.login("aaa", "aaa");
		 UserVO user=new UserVO();
//		 user=US.findUserById(1);
//		 System.out.println("---"+user.getId());
//		 System.out.println("----"+user.getUsername());
//		 user.setUserid(user.getUserid());
//		 user.setUsername(user.getUsername());
//		 user.setMail(user.getMail());
//		 user.setBirth(user.getBirth());
//		 user.setPassword("123");
//		 US.updateUser(user);
		 
		 List<UserVO> list= new ArrayList<UserVO>();
		 US.findUsers(1, 5);
//		 boolean flag=US.deleteUser(5);
//		 System.out.println("--------"+flag);
	}

}
