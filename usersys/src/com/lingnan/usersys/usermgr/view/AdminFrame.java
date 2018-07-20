package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 管理员操作页面
 * @author 12241
 *
 */
public class AdminFrame extends NormalFrame{
	/**
	 * 带参数的构造器，用于初始化user属性
	 * @param user 用户信息
	 */
	public AdminFrame(UserVO user) {
		super(user);
	}
	/**
	 * 登录成功主窗体
	 */
	public void loginSuccShow(){
		System.out.println("欢迎登录主窗体");
		System.out.println(user.getUsername()+"你好："+"你的权限是"+user.getPower());
		System.out.println("---------------");
		//管理员
		if(user.getPower().equals("管理员")){
			this.show();
		}
		else{
			//普通用户
			new NormalFrame(user).show();
		}
	}
	/**
	 * 管理员功能主界面
	 */
   public void show(){
	 //声明缓冲处理流对象，用于接收控制台输入的数据
	 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 		//循环操作
	 		while(true){	
	 			//用户登录和注册页面
	 			System.out.println("添加用户-------------------1");
	 			System.out.println("删除用户-------------------2");
	 			System.out.println("修改用户-------------------3");
	 			System.out.println("查询用户-------------------4");
	 			System.out.println("程序退出-------------------5");
	 			int i=-1;
	 			while(true){
	 				try{
	 					//读取用户输入操作选项的数字，同时转换为int型
	 					i=Integer.parseInt(br.readLine());
	 					//中断该循环，进入下一步操作：i值判断
	 					break;
	 				}catch(Exception e){
	 					//出现异常时，提示错误信息，再重新输入
	 					System.out.println("输入错误，只能输入1~5的数字。");
	 					System.out.println("请你重新输入");
	 				}
	 			}
	 			/**
	 			 * 判断用户输入值，如果值为1，进行添加用户操作，
	 			 * 如果值为2，进行删除用户操作，
	 			 * 如果值为3，进行修改用户信息操作
	 			 * 如果值为4，进行查询用户操作
	 			 * 如果值为5，退出系统
	 			 */
	 			switch(i){
	 			case 1:
	 				this.addShow("添加");
	 				break;
	 			case 2:
	 				this.deleteUserShow();
	 				break;//中断switch
	 			case 3:
	 				this.updateShow();
	 			case 4:
	 				this.searchShow();
	 			case 5:
	 				System.out.println("欢迎您的使用");
	 				//退出当前界面
	 				System.exit(0);
	 			default://输入值是1-5之外的数字
	 				System.out.println("您输入的操作不正确，请重新输入");
	 			}
	 		}			
   }
   /**
    * 添加用户界面
    */
   	public void addShow(String type){
   		super.addShow(type);
   }
   	/**
   	 * 查询用户页面
   	 */
   	public void searchShow(){
   	//声明缓冲处理流对象，用于接收控制台输入的数据
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		//循环操作
   		while(true){	
	 			//用户登录和注册页面
	 			System.out.println("查询全部用户----------------------------1");
	 			System.out.println("根据id查询用户--------------------------2");
	 			System.out.println("根据姓名查询用户------------------------3");
	 			System.out.println("指定页面查询用户------------------------4");
	 			System.out.println("退出该界面------------------------------5");
	 			System.out.println("请输入要做的操作:");
	 			int i=-1;
	 			while(true){
	 				try{
	 					//读取用户输入操作选项的数字，同时转换为int型
	 					i=Integer.parseInt(br.readLine());
	 					//中断该循环，进入下一步操作：i值判断
	 					break;
	 				}catch(Exception e){
	 					//出现异常时，提示错误信息，再重新输入
	 					System.out.println("输入错误，只能输入1~5的数字。");
	 					System.out.println("请你重新输入");
	 				}
	 			}
	 			switch(i){
	 			case 1:
	 				this.findUserAllShow();
	 				break;
	 			case 2:
	 				this.findUserByIdShow();
	 				break;
	 			case 3:
	 				this.findUserByNameShow();
	 				break;
	 			case 4:
	 				this.findUsersByPageShow();
	 				break;
	 			case 5:
	 				System.out.println("欢迎您的使用");
	 				//退出当前界面
	 				this.show();
	 			default://输入值是1-4之外的数字
	 				System.out.println("您输入的操作不正确，请重新输入");
	 			}	 		 			
			}
   	}
   	/**
   	 * 更新用户页面
   	 */
   	public void updateShow(){
   		//声明缓冲处理流对象，用于接收控制台输入的数据
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   		while(true){
			System.out.println("修改密码-----------------1");
			System.out.println("修改日期-----------------2");
			System.out.println("修改邮箱-----------------3");
			System.out.println("修改权限-----------------4");
			System.out.println("修改用户名---------------5");
			System.out.println("退出该界面---------------6");
			int i=-1;
			while(true){
				try{
					//读取用户输入操作选项的数字，同时转换为int型
					i=Integer.parseInt(br.readLine());
					//中断该循环，进入下一步操作：i值判断
					break;
				}catch(Exception e){
					//出现异常时，提示错误信息，再重新输入
					System.out.println("输入错误，只能输入1~4的数字。");
					System.out.println("请你重新输入");
				}
			}
		switch(i){
		case 1:
			this.updateUserShow("修改密码", user);
			break;
		case 2:
			this.updateUserShow("修改日期", user);
			break;
		case 3:
			this.updateUserShow("修改邮箱", user);
			break;
		case 4:
			this.updateUserShow("修改权限", user);
			break;
		case 5:
			this.updateUserShow("修改用户名", user);
			break;
		case 6:
			//退出当前界面
			this.show();
		default://输入值是1-4之外的数字
			System.out.println("您输入的操作不正确，请重新输入");
			}
		}						
   	}
   	/**
   	 * 根据用户Id查询用户信息页面
   	 */
   public void findUserByIdShow(){   
	   //声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入要查询用户信息的id:");
		try {
			int id=Integer.parseInt(br.readLine());
			//调用控制器中的doRegister方法，进行用户登录操作
			UserController uc=new UserController();
			UserVO user=uc.dofind(id);
			if(user!=null){
				System.out.println("查询成功");
				System.out.println("==============================================================================================================");
				 System.out.println("编号：\t"+user.getId()+"  用户编号：\t"+user.getUserid()+"  用户名：\t"+user.getUsername()
						   +"  用户密码：\t"+user.getPassword()+"  邮箱：\t"+user.getMail()+"  权限：\t"+user.getPower()+"  出生日期：\t"+user.getBirth());
			}
			else{
				System.out.println("查询失败,");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   /**
    * 根据用户名查询用户信息页面
    */
   public void findUserByNameShow(){
	   //声明缓冲处理流对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入要查询用户信息的username:");
		try {
			String username=br.readLine();
			List<UserVO> list= new ArrayList<UserVO>();
			//调用控制器中的doRegister方法，进行用户登录操作
			UserController uc=new UserController();
			list=uc.dofindUserByName(username);
			if(list!=null){
				System.out.println("查询成功");
				System.out.println("==============================================================================================================");
				for(UserVO user :list){		  
				 System.out.println("编号："+user.getId()+"  用户编号："+user.getUserid()+"  用户名："+user.getUsername()	
						 +"  用户密码："+user.getPassword()+"  邮箱："+user.getMail()+	 "  权限："+user.getPower()+	"   出生日期："+user.getBirth());
					}
			}
			else{
				System.out.println("查询失败,");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   /**
    * 查询所有用户信息页面
    */
   public void findUserAllShow(){
	 //声明缓冲处理流对象，用于接收控制台输入的数据
	 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 		try {
	 			List<UserVO> list= new ArrayList<UserVO>();
	 			//调用控制器中的doRegister方法，进行用户登录操作
	 			UserController uc=new UserController();
	 			list=uc.dofindUserAll();
	 			if(list!=null){
	 				System.out.println("查询成功");
	 				System.out.println("==============================================================================================================");
	 				for(UserVO user :list){		  
	 				 System.out.println("编号："+user.getId()+"  用户编号:"+user.getUserid()+"  用户名："+user.getUsername()
	 						   +"  用户密码："+user.getPassword()+"   邮箱: "+user.getMail()+"  权限: "+user.getPower()+"  出生日期: "+user.getBirth());
	 				 System.out.println("==============================================================================================================");
	 					}
	 			}
	 			else{
	 				System.out.println("查询失败,");
	 			}
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
   }
   /**
    * 指定页面查询用户信息页面
    */
   public void findUsersByPageShow(){
	 //声明缓冲处理流对象，用于接收控制台输入的数据
	 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 		System.out.println("请输入要指定的页数:");
	 		try {
	 			int pageNo=Integer.parseInt(br.readLine());
	 			System.out.println("请输入所要查询几条信息：");
	 			int pageSize=Integer.parseInt(br.readLine());
	 			List<UserVO> list= new ArrayList<UserVO>();
	 			//调用控制器中的doRegister方法，进行用户登录操作
	 			UserController uc=new UserController();
	 			list=uc.dofindUsers(pageNo, pageSize);
	 			if(list!=null){
	 				System.out.println("查询成功");
	 				System.out.println("==============================================================================================================");
	 				for(UserVO user :list){		  
	 				 System.out.println("编号："+user.getId()+"  用户编号："+user.getUserid()+"  用户名："+user.getUsername()	
	 						 +"  用户密码："+user.getPassword()+"  邮箱："+user.getMail()+	 "  权限："+user.getPower()+	"   出生日期："+user.getBirth());
	 				System.out.println("==============================================================================================================");
	 					}
	 			}
	 			else{
	 				System.out.println("查询失败,");
	 			}
	 		} catch (IOException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
   }
   /**
    * 修改用户信息页面
    * @param type 类型
    * @param user 用户信息
    */
   public void updateUserShow(String type, UserVO user){
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   UserController uc=new UserController();
	   System.out.println("请输入要修改用户的id");	
			int id;
			try {
				id = Integer.parseInt(br.readLine());			
			      user=uc.dofind(id);
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}				      
	      user.setUsername(user.getUsername());
	      user.setPassword(user.getPassword());
	      user.setMail(user.getMail());
		  user.setBirth(user.getBirth());
		  user.setPower(user.getPower());
		  user.setUserid(user.getUserid());
		  if("修改用户名".equals(type)){
				System.out.println("请输入要修改的用户名：");
				try {
					user.setUsername(br.readLine());
					//调用控制器中的doRegister方法，进行用户登录操作
					boolean flag=uc.doUpdate(user);
					//如果返回值flag为真，修改成功，显示成功信息，否则修改失 败，显示失败信息
					if(flag){
						System.out.println("更新成功");
						System.out.println("==========================");
					}
					else{
						System.out.println("更新失败,");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}					
			}	
		  if("修改密码".equals(type)){
				System.out.println("请输入要修改的密码：");
				try {
					user.setPassword(br.readLine());
					//调用控制器中的doRegister方法，进行用户登录操作
					boolean flag=uc.doUpdate(user);
					//如果返回值flag为真，修改成功，显示成功信息，否则修改失 败，显示失败信息
					if(flag){
						System.out.println("更新成功");
						System.out.println("============================");
					}
					else{
						System.out.println("更新失败,");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}					
			}				
			if("修改日期".equals(type)){
				System.out.println("请修改你的日期（YYYY-MM-DD)：");
				try {						
					user.setBirth(TypeUtils.strToDate(br.readLine()));
					//调用控制器中的doRegister方法，进行用户登录操作
					boolean flag=uc.doUpdate(user);
					//如果返回值flag为真，修改成功，显示成功信息，否则修改失 败，显示失败信息
					if(flag){
						System.out.println("更新成功");
						System.out.println("=============================");
					}
					else{
						System.out.println("更新失败,");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}					
			}
			if("修改邮箱".equals(type)){
				try {		
					//进行邮箱格式验证
					while(true){
						System.out.println("请输入你要修改的邮箱：");
						String mail=br.readLine();	
						if(TypeUtils.checkEmail(mail)){
							user.setMail(mail);
							break;
						}
					}				
					//调用控制器中的doRegister方法，进行用户登录操作
					boolean flag=uc.doUpdate(user);
					//如果返回值flag为真，修改成功，显示成功信息，否则修改失 败，显示失败信息
					if(flag){
						System.out.println("更新成功");
						System.out.println("==========================");
					}
					else{
						System.out.println("更新失败,");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}					
			}
			if("修改权限".equals(type)){
				System.out.println("请输入要修改的权限：");
				try {
					user.setPower(br.readLine());
					//调用控制器中的doRegister方法，进行用户登录操作
					boolean flag=uc.doUpdate(user);
					//如果返回值flag为真，修改成功，显示成功信息，否则修改失 败，显示失败信息
					if(flag){
						System.out.println("更新成功");
						System.out.println("=======================");
					}
					else{
						System.out.println("更新失败,");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}					
			}			
			
   }
   /**
    * 删除用户
    */
   public void deleteUserShow(){
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   System.out.println("请输入你想要删除用户的id：");
	   try {
		int id=Integer.parseInt(br.readLine());
		//调用控制器中的doRegister方法，进行用户登录操作
		UserController uc=new UserController();
		boolean flag=uc.dodelete(id);
		//如果返回值flag为真，注册成功，显示成功信息，否则注册失 败，显示失败信息
		if(flag){
			System.out.println("删除成功");
			System.out.println("================================");
		}
		else{
			System.out.println("删除失败,");
		}
	} catch (IOException e) {
		e.printStackTrace();
	}					
   }
}
