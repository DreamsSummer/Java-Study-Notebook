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
	//�������ڵ�ȫ����Ա��Ϣд�����±��ļ���
	
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
			throw new Exception("IO����"+e.getMessage());
		}
	}
	
	
	//�����±��е�������Ա��Ϣ������
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
			throw new Exception("�����ļ������ڻ����Ѿ���");
		}
//		catch(IOException e){
//			e.printStackTrace();
//			throw new Exception("IO����"+e.getMessage());
//		}
		
		return list;
	}
	
	
	public void add(Person person)throws Exception{
		ArrayList<Person>list = this.readerPer();
		
		//System.out.println("23123123");
		//throw new Exception("12Ҫ��ӵ���Ա�Ѵ���");
		for(Person per:list){
			if(person.getName().equals(per.getName())){
				throw new Exception("Ҫ��ӵ���Ա�Ѵ���");
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
		
		throw new Exception("���ҵ���Ա������");
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
