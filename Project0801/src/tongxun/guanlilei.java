package tongxun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;




import javax.swing.text.html.Option;

import fangfalei.fangfa;
import chuangti.*;

public class guanlilei {
	//将集合内的全部人员信息写到记事本文件里
	
	public void writerPer(ArrayList<Person>list)throws Exception{
		try {
			FileWriter fw = new FileWriter("Arrt.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(Person person:list){
				bw.write(person.getName()+"|"+person.getNumber());
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("IO错误"+e.getMessage());
		}
	}
	
	
	//将记事本中的所有人员信息读出来
	public ArrayList<Person> readerPer()throws Exception{
		ArrayList<Person> list = new ArrayList<Person>();
		
		try {
			FileReader fr = new FileReader("Arrt.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			while(line != null){
				String arr[] = line.split("[|]");
				Person person = new Person(arr[0], arr[1]);
				list.add(person);
				line = br.readLine();
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("数据文件不存在或者已经损坏");
		}
//		catch(IOException e){
//			e.printStackTrace();
//			throw new Exception("IO错误"+e.getMessage());
//		}
		
		return list;
	}
	
	
	public void add(Person person)throws Exception{
		ArrayList<Person>list = this.readerPer();
		
		//System.out.println("23123123");
		//throw new Exception("12要添加的人员已存在");
		for(Person per:list){
			if(person.getName().equals(per.getName())){
				throw new Exception("要添加的人员已存在");
			}
		}
		
		list.add(person);
		this.writerPer(list);
	}
	
	
	public void delPer(Person person) throws Exception{
		ArrayList<Person>list = this.readerPer();
		
		for(int i = 0 ; i < list.size(); i++ ){
			if(person.getName().equals(list.get(i).getName())){
				list.remove(i);
				//this.writerPer(list);
				this.writerPer(list);
				return;
			}
		}
	}
	
	
	public Person selPer(String name) throws Exception{
		ArrayList<Person>list = this.readerPer();
		
		for(int i = 0 ; i < list.size(); i++ ){
			if(name.equals(list.get(i).getName()))
				return list.get(i);
		}
		
		throw new Exception("查找的人员不存在");
	}
	
	
	public void updatePer(Person person)throws Exception{
		ArrayList<Person> list = this.readerPer();
		
		for(int i = 0 ; i < list.size(); i++ ){
			if(person.getName().equals(list.get(i).getName())){
				list.get(i).setNumber(person.getNumber());
			}
		}
		
		this.writerPer(list);
	}
	
}
