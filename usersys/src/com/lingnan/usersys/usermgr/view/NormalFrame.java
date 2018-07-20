package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 普通用户操作页面
 * @author 12241
 *
 */
public class NormalFrame extends IndexFrame {
	//用户对象
	UserVO user=null;
	/**
	 * 带参数的构造器，用于初始化user属性
	 * @param user 用户信息
	 */
	public NormalFrame(UserVO user){
		this.user=user;
	}
	/**
	 * 展示普通用户主界面
	 */
	public void show(){
		//声明缓冲处理流对象，用于接收控制台输入的数据
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				//循环操作
				while(true){	
					//用户登录和注册页面
					System.out.println("修改自己的信息-----------------1");
					System.out.println("查询自己的信息-----------------2");
					System.out.println("退出---------------------------3");
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
					 * 判断用户输入值，如果值为1，进行修改自己的密码，
					 * 如果值为2，进行修改日期，如果值为3，修改邮箱，如果为4，退出该界面
					 */
					switch(i){
					case 1:
						while(true){
							System.out.println("修改密码-----------------1");
							System.out.println("修改日期-----------------2");
							System.out.println("修改邮箱-----------------3");
							System.out.println("退出该界面---------------4");
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
							this.updateShow("修改密码", user);
							break;
						case 2:
							this.updateShow("修改日期", user);
							break;
						case 3:
							this.updateShow("修改邮箱", user);
							break;
						case 4:
							//退出当前界面
							this.show();
						default://输入值是1-4之外的数字
							System.out.println("您输入的操作不正确，请重新输入");
							}
						}						
					case 2:
						this.searchShow();
						break;//中断switch
					case 3:
						System.out.println("欢迎您的使用,再回！");
						//退出当前界面
						System.exit(0);
					default://输入值是1-3之外的数字
						System.out.println("您输入的操作不正确，请重新输入");
					}
				}
		}
	/**
	 * 添加用户页面
	 */
	public void addShow(String type){
   		super.addShow(type);
	   }
	/**
	 * 查询用户信息
	 */
	public void searchShow(){
		   System.out.println("你的信息如下：");
		   System.out.println("编号："+user.getId()+"  用户编号："+user.getUserid()+"  用户名："+user.getUsername()
				   +"  用户密码："+user.getPassword()+"  邮箱："+user.getMail()+"  权限："+user.getPower()+"  出生日期："+user.getBirth());
	   }
	/**
	 * 修改更新用户的信息
	 */
    public void updateShow(String type, UserVO user){
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		      int id=user.getId();
//		      UserController uc=new UserController();
//		      user=uc.dofind(id);
		      user.setUsername(user.getUsername());
		      user.setPassword(user.getPassword());
		      user.setMail(user.getMail());
			  user.setBirth(user.getBirth());
			  user.setPower(user.getPower());
			  user.setId(user.getId());
			//循环操作
				if("修改密码".equals(type)){
					System.out.println("请输入要修改的密码：");
					try {
						user.setPassword(br.readLine());
						//调用控制器中的doRegister方法，进行用户登录操作
						UserController uc=new UserController();
						boolean flag=uc.doUpdate(user);
						//如果返回值flag为真，注册成功，显示成功信息，否则注册失 败，显示失败信息
						if(flag){
							System.out.println("更新成功");
							System.out.println("---------------------");
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
						UserController uc=new UserController();
						boolean flag=uc.doUpdate(user);
						//如果返回值flag为真，注册成功，显示成功信息，否则注册失 败，显示失败信息
						if(flag){
							System.out.println("更新成功");
							System.out.println("--------------------------");
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
						UserController uc=new UserController();
						boolean flag=uc.doUpdate(user);
						//如果返回值flag为真，注册成功，显示成功信息，否则注册失 败，显示失败信息
						if(flag){
							System.out.println("更新成功");
							System.out.println("--------------------------");
						}
						else{
							System.out.println("更新失败,");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}					
				}
				
	   }
}
