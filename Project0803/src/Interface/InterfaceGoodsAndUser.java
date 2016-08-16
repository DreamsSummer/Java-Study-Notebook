package Interface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import Information.Colthes;
import Information.Food;
import Information.Goods;

public class InterfaceGoodsAndUser {
	
	//ʳƷ��Ϣ���±�������
	private String pathForFood;
	//�·���Ϣ���±�������
	private String pathForColthes;
	
	//�޲ι��캯��
	public InterfaceGoodsAndUser(){
		this.pathForColthes = "Clothes.txt";
		this.pathForFood = "Food.txt";
	}

	/**pathForFood �� pathForColthes ��setter��getter����*/
	public String getPathForFood() {
		return pathForFood;
	}

	public void setPathForFood(String pathForFood) {
		this.pathForFood = pathForFood;
	}

	public String getPathForColthes() {
		return pathForColthes;
	}

	public void setPathForColthes(String pathForColthes) {
		this.pathForColthes = pathForColthes;
		
	}
	
	
	//��Food.txt�е���Ϣȫ��������
	public ArrayList<Food> readerFoods() throws Exception{
		ArrayList<Food> list = new ArrayList<Food>();
		
		try {
			FileReader fd = new FileReader(pathForFood);
			BufferedReader fw =  new BufferedReader(fd);
			
			String line = fw.readLine();
			
			while(line != null ){
				String a[] = line.split("[|]");
				Food food = new Food(a[0], a[1], a[2], a[3], a[4], a[5]);
				list.add(food);
				line = fw.readLine();
			}
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("�����ļ������ڻ����Ѿ���");
		}
		
		
//		for (Food food : list) {
//			System.out.println(food.getGoodsName() + " " + food.getPrice() + " " + food.getGoodsCounts() + " " + food.getCreateDate() + " " + food.getWeight() + " " + food.getKeepDate());
//		}
		return list;
	}
	
	
	//��������Food.txt��д����Ʒ��Ϣ
	public void writeFoodInformation(ArrayList<Food>list)throws Exception{
		try {
			FileWriter fw = new FileWriter(pathForFood);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(Food food:list){
				bw.write(food.getGoodsName() + "|" + food.getPrice() + "|" + food.getGoodsCounts() + "|" + food.getCreateDate() + "|" + food.getWeight() + "|" + food.getKeepDate());
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("IO����"+e.getMessage());
		}
	}
	
	/**��Food�������Ʒ��Ϣ*/
	public void add(Food food) throws Exception{
		ArrayList<Food>list = this.readerFoods();
		
		for(Food fo:list){
			if(food.getGoodsName().equals(fo.getGoodsName())){
				throw new Exception("Ҫ��ӵ�ʳƷ�Ѿ�����");
			}
		}
		list.add(food);
		this.writeFoodInformation(list);
	}
	
	
	
	//��Colthes.txt�е���Ϣȫ��������
	public ArrayList<Colthes> readerClothes() throws Exception{
		ArrayList<Colthes> list = new ArrayList<Colthes>();
		
		try {
			FileReader fd = new FileReader(pathForColthes);
			BufferedReader fw =  new BufferedReader(fd);
			
			String line = fw.readLine();
			
			while(line != null ){
				String a[] = line.split("[|]");
//				Food food = new Food(a[0], a[1], a[2], a[3], a[4], a[5]);
				Colthes colthes = new Colthes(a[0], a[1], a[2], a[3], a[4], a[5]);
				list.add(colthes);
				line = fw.readLine();
			}
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("�����ļ������ڻ����Ѿ���");
		}
		
		
//		for (Colthes colthes : list) {
//			System.out.println(colthes.getGoodsName() + " " + colthes.getPrice() + " " + colthes.getGoodsCounts() + " " + colthes.getColor() + " " + colthes.getSize() + " " + colthes.getStyle());
//		}
		return list;
	}
	
	
	//��������Colthes.txt��д����Ʒ��Ϣ
	public void writeColthesInformation(ArrayList<Colthes>list)throws Exception{
		try {
			FileWriter fw = new FileWriter(pathForColthes);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(Colthes colthes:list){
				bw.write(colthes.getGoodsName() + "|" + colthes.getPrice() + "|" + colthes.getGoodsCounts() + "|" + colthes.getColor() + "|" + colthes.getSize() + "|" + colthes.getStyle());
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("IO����"+e.getMessage());
		}
	}
	
	
	/**��Colthes�������Ʒ��Ϣ*/
	public void addColthes(Colthes colthes) throws Exception{
		ArrayList<Colthes>list = this.readerClothes();
		
		for(Colthes colthes2:list){
			if(colthes2.getGoodsName().equals(colthes.getGoodsName())){
				throw new Exception("Ҫ��ӵ��·��Ѿ�����");
			}
		}
		list.add(colthes);
		this.writeColthesInformation(list);
	}
	
	/**��ѯFood�����е���Ʒ*/
	public void SelAllFoodsThings() throws Exception{
		ArrayList<Food> list = this.readerFoods();
		
		for (Food food : list) {
			System.out.println(food.getGoodsName() + " " + food.getPrice() + " " + food.getGoodsCounts() + " " + food.getCreateDate() + " " + food.getWeight() + " " + food.getKeepDate());
		}
		
		System.out.println("��ѯ���");
		
	}
	
	
	/**��ѯColthes�е���Ʒ*/
	public void SelAllColthesThings() throws Exception{
		ArrayList<Colthes> list = this.readerClothes();
		
		for (Colthes colthes : list) {
			System.out.println(colthes.getGoodsName() + " " + colthes.getPrice() + " " + colthes.getGoodsCounts() + " " + colthes.getColor() + " " + colthes.getSize() + " " + colthes.getStyle());
			System.out.println(colthes.getSale());
		}
		System.out.println("��ѯ���");
	}
	
	/**�����ֲ�ѯFood�е���Ʒ*/
	public Food SelFoodWithName(String Name) throws Exception{
		ArrayList<Food> list = this.readerFoods();
		
		for(int i = 0 ; i < list.size(); i++ ){
			if(list.get(i).getGoodsName().equals(Name)){
				return list.get(i);
			}
		}
		throw new Exception("û�в�ѯ����Ʒ");
	}
	
	
	/**�����ֲ�ѯColthes�е���Ʒ*/
	public Colthes selColthesWithName(String Name) throws Exception{
		ArrayList<Colthes> list = this.readerClothes();
		
		for(int i = 0 ; i < list.size(); i++ ){
			if(list.get(i).getGoodsName().equals(Name)){
				return list.get(i);
			}
		}
		throw new Exception("û������ѯ����Ʒ");
	}
}
