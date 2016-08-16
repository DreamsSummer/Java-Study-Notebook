package Information;

public class UserInformation {
	
	/**�û���*/
	private String userName;
	//��ʵ����
	private String TrueName;
	/**����*/
	private String passWord;
	/**��ϵ��ʽ*/
	private String Telephone;
	/**��ַ*/
	private String Address;
	//�û����� 0-��ͨ�û�  1-����Ա�û�  2-����
	private String level;
	
	//�޲ι��캯��
	public UserInformation(){
		this.userName = "xxx";
		this.passWord = "xxx";
		this.Telephone = "xxx";
		this.Address = "xxx";
		this.TrueName = "xxx";
		this.level = "0";
	}
	
	//���ι��캯��
	public UserInformation(String usernamesString, String passwordString , String telString , String addString,String trueName,String level){
		this.userName = usernamesString;
		this.passWord = passwordString;
		this.Telephone = telString;
		this.Address = addString;
		this.TrueName = trueName;
		//ע����ɵ��û�ȫ����ͨ�û��������Ϊ���ұ��������Ա�������
		this.level = level;
	}
	
	//���������û�����ԱȨ�޹��ܣ����޹���Աʹ�ã�
	public boolean SuperManToUser(UserInformation admin , UserInformation user){
		if(admin.level == "1"){
			user.level = "1";
			return true;
		}
		return false;
	}
	
	
	/**setter and getter����*/
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
