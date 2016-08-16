package Faction;

import javax.swing.JOptionPane;

import Information.UserInformation;
import Interface.InterfaceUserAndFaction;

public class LoginandRegisterFaction {
	
	//弹出消息框的工具
	public JOptionPane option = new JOptionPane();
	
	//登录功能（根据用户名和密码查询用户信息）
	public UserInformation SelectUserInformationWithNameAndPass(String userName , String passWord) throws Exception{
		
		//创建InterfaceUserAndFaction类对象，用来存储查询后的数据
		InterfaceUserAndFaction SelectFaction = new InterfaceUserAndFaction();
		
		UserInformation SelectResultUser = SelectFaction.SelectUserInformation(userName);
		
		if(SelectResultUser.getPassWord().equals(passWord)){
			return SelectResultUser;
		}
		else
			throw new Exception("密码错误，请重新输入");
	}
	
	
	//注册功能（根据传入的UserInformation类型的参数将用户信息存入记事本）
	public void RegisterUser(UserInformation User) throws Exception{
		/**判断输入的信息是否为空*/
		if(User.getUserName().equals("")){
			option.showMessageDialog(null,"用户名不能为空");
			return;
		}
		if(User.getPassWord().equals("")){
			option.showMessageDialog(null, "密码不能为空");
			return;
		}
		if(User.getTelephone().equals("")){
			option.showMessageDialog(null, "电话号码不能为空");
			return;
		}
		if(User.getAddress().equals("")){
			option.showMessageDialog(null, "输入的地址不能为空");
			return;
		}
		if(User.getTrueName().equals("")){
			option.showMessageDialog(null, "真实姓名不能为空");
			return ;
		}
		
		InterfaceUserAndFaction ff = new InterfaceUserAndFaction();
		ff.RegisterUserInformation(User);
		
		System.out.println("注册成功！欢迎新用户！请登陆");
	}
	
}	
