package fangfalei;

import javax.swing.JOptionPane;

import tongxun.*;
import chuangti.*;

public class fangfa {
	public JOptionPane option = new JOptionPane();
	
	/**���������Ϣ*/
	public void add(String name,String number) throws Exception{
		if(name.equals("")){
			option.showMessageDialog(null, "��������Ϊ��");
			return;
		}
		else if(number.equals("")){
			option.showMessageDialog(null, "�绰���벻��Ϊ��");
			return ;
		}
		else{
			/**�������Լ��绰������Ϣ��ӵ��ı��ĵ���*/
			//option.showMessageDialog(null, "���Ƿ�����"+name+number);
			guanlilei gllGuanlilei = new guanlilei();
			Person person = new Person(name, number);
			gllGuanlilei.add(person);
		}
		option.showMessageDialog(null, "��ӳɹ�");
	}
	
	/**ɾ����Ϣ*/
	public void delete(String name,String number) throws Exception{
		int result = option.showConfirmDialog(null, "���Ҫɾ����?");
		
		if(result == 0){
			/**ɾ����Ϣ*/
			guanlilei gllGuanlilei = new guanlilei();
			Person person = new Person(name, number);
			gllGuanlilei.delPer(person);
		}
		option.showMessageDialog(null, "ɾ���ɹ�");
	}
	
	/**�޸���Ϣ*/
	public void updatePer(String name,String number) throws Exception{
		int result = option.showConfirmDialog(null, "���Ҫ�޸���Ϣ��?");
		if(result == 0){
			/**�޸���Ϣ*/
			guanlilei gllGuanlilei = new guanlilei();
			Person person = new Person(name, number);
			gllGuanlilei.updatePer(person);
		}
		option.showMessageDialog(null, "�޸ĳɹ�");
	}
	
	
	/**��ѯ��Ϣ*/
	public String Select(String name)throws Exception{
		guanlilei gllGuanlilei = new guanlilei();
		Person person = gllGuanlilei.selPer(name);
		return person.getNumber();
	}
	
}
