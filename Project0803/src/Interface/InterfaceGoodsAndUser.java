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
	
	//食品信息记事本的名称
	private String pathForFood;
	//衣服信息记事本的名称
	private String pathForColthes;
	
	//无参构造函数
	public InterfaceGoodsAndUser(){
		this.pathForColthes = "Clothes.txt";
		this.pathForFood = "Food.txt";
	}

	/**pathForFood 和 pathForColthes 的setter和getter方法*/
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
	
	
	//将Food.txt中的信息全部读出来
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
			throw new Exception("数据文件不存在或者已经损坏");
		}
		
		
//		for (Food food : list) {
//			System.out.println(food.getGoodsName() + " " + food.getPrice() + " " + food.getGoodsCounts() + " " + food.getCreateDate() + " " + food.getWeight() + " " + food.getKeepDate());
//		}
		return list;
	}
	
	
	//方法：向Food.txt中写入商品信息
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
			throw new Exception("IO错误"+e.getMessage());
		}
	}
	
	/**向Food中添加商品信息*/
	public void add(Food food) throws Exception{
		ArrayList<Food>list = this.readerFoods();
		
		for(Food fo:list){
			if(food.getGoodsName().equals(fo.getGoodsName())){
				throw new Exception("要添加的食品已经存在");
			}
		}
		list.add(food);
		this.writeFoodInformation(list);
	}
	
	
	
	//将Colthes.txt中的信息全部读出来
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
			throw new Exception("数据文件不存在或者已经损坏");
		}
		
		
//		for (Colthes colthes : list) {
//			System.out.println(colthes.getGoodsName() + " " + colthes.getPrice() + " " + colthes.getGoodsCounts() + " " + colthes.getColor() + " " + colthes.getSize() + " " + colthes.getStyle());
//		}
		return list;
	}
	
	
	//方法：向Colthes.txt中写入商品信息
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
			throw new Exception("IO错误"+e.getMessage());
		}
	}
	
	
	/**向Colthes中添加商品信息*/
	public void addColthes(Colthes colthes) throws Exception{
		ArrayList<Colthes>list = this.readerClothes();
		
		for(Colthes colthes2:list){
			if(colthes2.getGoodsName().equals(colthes.getGoodsName())){
				throw new Exception("要添加的衣服已经存在");
			}
		}
		list.add(colthes);
		this.writeColthesInformation(list);
	}
	
	/**查询Food中所有的商品*/
	public void SelAllFoodsThings() throws Exception{
		ArrayList<Food> list = this.readerFoods();
		
		for (Food food : list) {
			System.out.println(food.getGoodsName() + " " + food.getPrice() + " " + food.getGoodsCounts() + " " + food.getCreateDate() + " " + food.getWeight() + " " + food.getKeepDate());
		}
		
		System.out.println("查询完成");
		
	}
	
	
	/**查询Colthes中的商品*/
	public void SelAllColthesThings() throws Exception{
		ArrayList<Colthes> list = this.readerClothes();
		
		for (Colthes colthes : list) {
			System.out.println(colthes.getGoodsName() + " " + colthes.getPrice() + " " + colthes.getGoodsCounts() + " " + colthes.getColor() + " " + colthes.getSize() + " " + colthes.getStyle());
			System.out.println(colthes.getSale());
		}
		System.out.println("查询完成");
	}
	
	/**按名字查询Food中的商品*/
	public Food SelFoodWithName(String Name) throws Exception{
		ArrayList<Food> list = this.readerFoods();
		
		for(int i = 0 ; i < list.size(); i++ ){
			if(list.get(i).getGoodsName().equals(Name)){
				return list.get(i);
			}
		}
		throw new Exception("没有查询的商品");
	}
	
	
	/**按名字查询Colthes中的商品*/
	public Colthes selColthesWithName(String Name) throws Exception{
		ArrayList<Colthes> list = this.readerClothes();
		
		for(int i = 0 ; i < list.size(); i++ ){
			if(list.get(i).getGoodsName().equals(Name)){
				return list.get(i);
			}
		}
		throw new Exception("没有您查询的商品");
	}
}
