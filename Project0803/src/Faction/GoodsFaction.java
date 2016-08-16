package Faction;

import Information.Colthes;
import Information.Food;
import Interface.InterfaceGoodsAndUser;

public class GoodsFaction {
	
	//方法：添加食品信息
	public void AddFoodInformation(Food food) throws Exception{
		InterfaceGoodsAndUser AddFoodInformation = new InterfaceGoodsAndUser();
		AddFoodInformation.add(food);
	}
	
	
	//方法：添加衣服信息
	public void AddClothesInformation(Colthes colthes) throws Exception{
		InterfaceGoodsAndUser AddColthesInformation = new InterfaceGoodsAndUser();
		AddColthesInformation.addColthes(colthes);
	}
	
	
}
