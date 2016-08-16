package Information;

public class UserInformation {
	
	/**用户名*/
	private String userName;
	//真实姓名
	private String TrueName;
	/**密码*/
	private String passWord;
	/**联系方式*/
	private String Telephone;
	/**地址*/
	private String Address;
	//用户级别 0-普通用户  1-管理员用户  2-卖家
	private String level;
	
	//无参构造函数
	public UserInformation(){
		this.userName = "xxx";
		this.passWord = "xxx";
		this.Telephone = "xxx";
		this.Address = "xxx";
		this.TrueName = "xxx";
		this.level = "0";
	}
	
	//带参构造函数
	public UserInformation(String usernamesString, String passwordString , String telString , String addString,String trueName,String level){
		this.userName = usernamesString;
		this.passWord = passwordString;
		this.Telephone = telString;
		this.Address = addString;
		this.TrueName = trueName;
		//注册完成的用户全是普通用户，若想成为卖家必须向管理员提出申请
		this.level = level;
	}
	
	//授予其他用户管理员权限功能（仅限管理员使用）
	public boolean SuperManToUser(UserInformation admin , UserInformation user){
		if(admin.level == "1"){
			user.level = "1";
			return true;
		}
		return false;
	}
	
	
	/**setter and getter函数*/
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getTrueName() {
		return TrueName;
	}

	public void setTrueName(String trueName) {
		TrueName = trueName;
	}
	
}
