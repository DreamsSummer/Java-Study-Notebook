package Faction;

import Information.Colthes;
import Information.Food;
import Interface.InterfaceGoodsAndUser;

public class GoodsFaction {
	
	//���������ʳƷ��Ϣ
	public void AddFoodInformation(Food food) throws Exception{
		InterfaceGoodsAndUser AddFoodInformation = new InterfaceGoodsAndUser();
		AddFoodInformation.add(food);
	}
	
	
	//����������·���Ϣ
	public void AddClothesInformation(Colthes colthes) throws Exception{
		InterfaceGoodsAndUser AddColthesInformation = new InterfaceGoodsAndUser();
		AddColthesInformation.addColthes(colthes);
	}
	
	
}
