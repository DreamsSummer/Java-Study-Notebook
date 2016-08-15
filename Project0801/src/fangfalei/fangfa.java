package fangfalei;

import javax.swing.JOptionPane;

import tongxun.*;
import chuangti.*;

public class fangfa {
	public JOptionPane option = new JOptionPane();
	
	/**添加姓名信息*/
	public void add(String name,String number) throws Exception{
		if(name.equals("")){
			option.showMessageDialog(null, "姓名不能为空");
			return;
		}
		else if(number.equals("")){
			option.showMessageDialog(null, "电话号码不能为空");
			return ;
		}
		else{
			/**将姓名以及电话号码信息添加到文本文档中*/
			//option.showMessageDialog(null, "这是方法类"+name+number);
			guanlilei gllGuanlilei = new guanlilei();
			Person person = new Person(name, number);
			gllGuanlilei.add(person);
		}
		option.showMessageDialog(null, "添加成功");
	}
	
	/**删除信息*/
	public void delete(String name,String number) throws Exception{
		int result = option.showConfirmDialog(null, "真的要删除吗?");
		
		if(result == 0){
			/**删除信息*/
			guanlilei gllGuanlilei = new guanlilei();
			Person person = new Person(name, number);
			gllGuanlilei.delPer(person);
		}
		option.showMessageDialog(null, "删除成功");
	}
	
	/**修改信息*/
	public void updatePer(String name,String number) throws Exception{
		int result = option.showConfirmDialog(null, "真的要修改信息吗?");
		if(result == 0){
			/**修改信息*/
			guanlilei gllGuanlilei = new guanlilei();
			Person person = new Person(name, number);
			gllGuanlilei.updatePer(person);
		}
		option.showMessageDialog(null, "修改成功");
	}
	
	
	/**查询信息*/
	public String Select(String name)throws Exception{
		guanlilei gllGuanlilei = new guanlilei();
		Person person = gllGuanlilei.selPer(name);
		return person.getNumber();
	}
	
}
