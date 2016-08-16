package Interface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import Information.UserInformation;

public class InterfaceUserAndFaction {
	
	//�洢�û���Ϣ�ļ��±�������
	private String path ;
	
	
	//�޲ι��캯������ʼ�����±�������
	public InterfaceUserAndFaction(){
		this.path = "UserInformation.txt";
	}
	
	
	/**path ��setter��getter����*/
	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
	
	//����:���û�����Ϣ�Ӽ��±��ж�ȡ����
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
			throw new Exception("�����ļ������ڻ����Ѿ���");
		}
		
		//System.out.println(list.get(0).getLevel());
		return list;
	}

	//���������û�����Ϣд����±�
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
			throw new Exception("IO����"+e.getMessage());
		}
	}
	
	
	//��������ѯ�û���Ϣ
	public UserInformation SelectUserInformation(String username)throws Exception{
		
		//����һ��list�����ҵ���readerUserInformations���������е��û���Ϣ��ȡ�������洢��list��
		ArrayList<UserInformation> list = this.readerUserInformations();
		
		System.out.println(list.get(0).getLevel());
		
		//System.out.println(list.get(0).getLevel());
		//ѭ������list���ҳ����кͲ����û���ƥ������ݣ����������ظ�Faction
		for(int i = 0 ; i < list.size() ; i++ ){
			if(username.equals(list.get(i).getUserName()))
				return list.get(i);
		}
		
		
		//������
		throw new Exception("���ҵ���Ա������");
	}

	//�������û���Ϣע��
	public void RegisterUserInformation(UserInformation user) throws Exception{
		ArrayList<UserInformation> list = this.readerUserInformations();
		
		for(UserInformation u:list){
			if(u.getUserName().equals(user.getUserName()))
				throw new Exception("�û����Ѿ�����");
		}
		
		list.add(user);
		this.writeUserInformation(list);
	}
	
}
