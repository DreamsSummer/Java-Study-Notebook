package Faction;

import javax.swing.JOptionPane;

import Information.UserInformation;
import Interface.InterfaceUserAndFaction;

public class LoginandRegisterFaction {
	
	//������Ϣ��Ĺ���
	public JOptionPane option = new JOptionPane();
	
	//��¼���ܣ������û����������ѯ�û���Ϣ��
	public UserInformation SelectUserInformationWithNameAndPass(String userName , String passWord) throws Exception{
		
		//����InterfaceUserAndFaction����������洢��ѯ�������
		InterfaceUserAndFaction SelectFaction = new InterfaceUserAndFaction();
		
		UserInformation SelectResultUser = SelectFaction.SelectUserInformation(userName);
		
		if(SelectResultUser.getPassWord().equals(passWord)){
			return SelectResultUser;
		}
		else
			throw new Exception("�����������������");
	}
	
	
	//ע�Ṧ�ܣ����ݴ����UserInformation���͵Ĳ������û���Ϣ������±���
	public void RegisterUser(UserInformation User) throws Exception{
		/**�ж��������Ϣ�Ƿ�Ϊ��*/
		if(User.getUserName().equals("")){
			option.showMessageDialog(null,"�û�������Ϊ��");
			return;
		}
		if(User.getPassWord().equals("")){
			option.showMessageDialog(null, "���벻��Ϊ��");
			return;
		}
		if(User.getTelephone().equals("")){
			option.showMessageDialog(null, "�绰���벻��Ϊ��");
			return;
		}
		if(User.getAddress().equals("")){
			option.showMessageDialog(null, "����ĵ�ַ����Ϊ��");
			return;
		}
		if(User.getTrueName().equals("")){
			option.showMessageDialog(null, "��ʵ��������Ϊ��");
			return ;
		}
		
		InterfaceUserAndFaction ff = new InterfaceUserAndFaction();
		ff.RegisterUserInformation(User);
		
		System.out.println("ע��ɹ�����ӭ���û������½");
	}
	
}	
