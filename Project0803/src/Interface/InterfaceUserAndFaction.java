package Interface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import Information.UserInformation;

public class InterfaceUserAndFaction {
	
	//存储用户信息的记事本的名字
	private String path ;
	
	
	//无参构造函数，初始化记事本的名字
	public InterfaceUserAndFaction(){
		this.path = "UserInformation.txt";
	}
	
	
	/**path 的setter和getter方法*/
	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
	
	//方法:将用户的信息从记事本中读取出来
	public ArrayList<UserInformation> readerUserInformations() throws Exception{
		
		ArrayList<UserInformation> list = new ArrayList<UserInformation>();
		
		try {
			FileReader fileReader = new FileReader(this.path);
			BufferedReader fd = new BufferedReader(fileReader);
			
			String line = fd.readLine();
			
			while(line != null){
				String arr[] = line.split("[|]");
				UserInformation user = new UserInformation(arr[0], arr[2], arr[3], arr[4], arr[1],arr[5]);
				list.add(user);
				line = fd.readLine();
			}
			fd.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("数据文件不存在或者已经损坏");
		}
		
		//System.out.println(list.get(0).getLevel());
		return list;
	}

	//方法：将用户的信息写入记事本
	public void writeUserInformation(ArrayList<UserInformation>list) throws Exception{
		try {
			FileWriter fw = new FileWriter(this.path);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(UserInformation user:list){
				bw.write(user.getUserName() + "|" + user.getTrueName() + "|" + user.getPassWord() + "|" + user.getTelephone() + "|" + user.getAddress() + "|" + user.getLevel());
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("IO错误"+e.getMessage());
		}
	}
	
	
	//方法：查询用户信息
	public UserInformation SelectUserInformation(String username)throws Exception{
		
		//创建一个list，并且调用readerUserInformations函数将所有的用户信息读取出来，存储到list内
		ArrayList<UserInformation> list = this.readerUserInformations();
		
		System.out.println(list.get(0).getLevel());
		
		//System.out.println(list.get(0).getLevel());
		//循环遍历list，找出其中和参数用户名匹配的数据，并将它返回给Faction
		for(int i = 0 ; i < list.size() ; i++ ){
			if(username.equals(list.get(i).getUserName()))
				return list.get(i);
		}
		
		
		//出错返回
		throw new Exception("查找的人员不存在");
	}

	//方法：用户信息注册
	public void RegisterUserInformation(UserInformation user) throws Exception{
		ArrayList<UserInformation> list = this.readerUserInformations();
		
		for(UserInformation u:list){
			if(u.getUserName().equals(user.getUserName()))
				throw new Exception("用户名已经存在");
		}
		
		list.add(user);
		this.writeUserInformation(list);
	}
	
}
