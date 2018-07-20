package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;

import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * 主页面
 * 用户登录和注册页面
 * @author 12241
 *
 */
public class IndexFrame implements BaseFrame{
/**
 * 主页面展示
 */
	@Override
	public void show() {
		//声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//循环操作
		while(true){	
			//用户登录和注册页面
			System.out.println("--------欢迎使用用户管理系统------------");
			System.out.println("请登录--------------------------------1");
			System.out.println("请注册--------------------------------2");
			System.out.println("退出----------------------------------3");
			int i=-1;
			while(true){
				try{
					//读取用户输入操作选项的数字，同时转换为int型
					i=Integer.parseInt(br.readLine());
					//中断该循环，进入下一步操作：i值判断
					break;
				}catch(Exception e){
					//出现异常时，提示错误信息，再重新输入
					System.out.println("输入错误，只能输入1~3的数字。");
					System.out.println("请你重新输入");
				}
			}
			/**
			 * 判断用户输入值，如果值为1，进行用户登录操作，
			 * 如果值为2，进行用户注册操作，如果值为3，退出系统
			 */
			switch(i){
			case 1:
				this.loginShow();
				break;
			case 2:
				this.addShow("注册");
				break;//中断switch
			case 3:
				System.out.println("欢迎您的使用");
				//退出当前界面
				System.exit(0);
			default://输入值是1-3之外的数字
				System.out.println("您输入的操作不正确，请重新输入");
			}
		}			
	}
	/**
	 * 登录页面
	 */
		public void loginShow() {
			//声明缓冲处理流对象，用于接收控制台输入的数据
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("-------用户登录界面-------");
			System.out.println("请输入你的用户名：");
			try{
				//以行为单元，读取输入的各个值，赋值给用户对象的各个属性
				String username = br.readLine();
				System.out.println("请输入你的密码：");
				String password= br.readLine();
				//调用控制器中的dologin方法，进行用户登录操作
				UserController uc=new UserController();
				UserVO user=uc.dologin(username, password);
				//如果返回值user不为空，登录成功，显示用户信息操作界面，否则登录失败，显示失败
				if(user!=null){
					System.out.println("登录成功");
					System.out.println("--------------------------");
					//调用主界面
					AdminFrame m=new AdminFrame(user);
					m.loginSuccShow();
					//退出当前界面
					System.exit(0);
				}
				else{
					System.out.println("登录失败,");
				}
			}catch(Exception e){
				System.out.println("登录失败"+e.getMessage());
			}
		}
/**
 * 注册页面
 */
		@Override
		public void addShow(String type) {	
			//声明缓冲处理流对象，用于接收控制台输入的数据
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			if("注册".equals(type)){
				System.out.println("-------用户注册界面-------");
				System.out.println("--------------------------");
			}
			else{
				System.out.println("---------添加用户界面------");
				System.out.println("---------------------------");
			}
			System.out.println("请输入你的用户编号：");
			try{
				UserVO user=new UserVO();
				//以行为单元，读取输入的各个值，赋值给用户对象的各个属性				
				user.setUserid(br.readLine());
				System.out.println("请输入你的用户名：");
				user.setUsername(br.readLine());			
				System.out.println("请输入你的用户密码：");
				user.setPassword(br.readLine());	
				//进行邮箱格式验证
				while(true){
					System.out.println("请输入你的邮箱：");
					String mail=br.readLine();	
					if(TypeUtils.checkEmail(mail)){
						user.setMail(mail);
						break;
					}
				}									
				System.out.println("请输入你的出生日期（YYYY-MM-DD)：");
				user.setBirth(TypeUtils.strToDate(br.readLine()));
				//调用控制器中的doRegister方法，进行用户登录操作
				UserController uc=new UserController();
				boolean flag=uc.doRegister(user);
				//如果返回值flag为真，注册成功，显示成功信息，否则注册失 败，显示失败信息
				if(flag){
					if("注册".equals(type)){
						System.out.println("注册成功");
						System.out.println("--------------------------");
					//退出当前界面
//					System.exit(0);
						}
					else{
						System.out.println("添加用户成功");
						System.out.println("--------------------------");
						}
				}
				else{
					if("注册".equals(type)){
					System.out.println("注册失败,");
					}
					else{
						System.out.println("添加用户失败");
					}
				}
			}catch(Exception e){
				System.out.println("注册失败"+e.getMessage());
			}
		}

		@Override
		public void searchShow() {
			
		}

		@Override
		public void updateShow(String type, UserVO user) {
		
		}
   
}
