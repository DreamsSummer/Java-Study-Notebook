package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Faction.GoodsFaction;
import Faction.LoginandRegisterFaction;
import Information.Colthes;
import Information.Food;
import Information.UserInformation;
import Interface.InterfaceGoodsAndUser;

public class MainApp {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub			
		
		
		double SalePrice = 0.0f;
		//当前登录的用户
		UserInformation nowLoginUser = null;
		while(true){
			//运行程序主界面
			System.out.println("********************************************");
			System.out.println("*		欢迎来到购物车系统		   *");
			System.out.println("********************************************");
			System.out.println("		请选择您要选择的操作				 ");
			System.out.println("1-|登录| 2-|注册| 3-|查询商品| 4-|添加商品| 5-|购买商品| 6-|设置打折| 7-退出系统");
			Scanner inScanner = new Scanner(System.in);
			int check = inScanner.nextInt();
			

			
			//选择模块
			switch (check) {
			case 1:
				System.out.print("请输入用户名:");
				String userName = inScanner.next();
				System.out.print("请输入密码:");
				String passWord = inScanner.next();
				LoginandRegisterFaction faction = new LoginandRegisterFaction();
				try {
					nowLoginUser = faction.SelectUserInformationWithNameAndPass(userName, passWord);
					System.out.println("登录成功！欢迎您 "+nowLoginUser.getTrueName());
					if(nowLoginUser.getLevel().equals("1")){
						System.out.println("您是管理员，很牛逼啊");
					}
					else if(nowLoginUser.getLevel().equals("0")){
						System.out.println("您是普通用户！赶紧逛逛吧");
					}
					else{
						System.out.println("您是卖家，别乱晃，赶紧去卖东西！");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("欢迎来到注册界面，请分别输入以下信息!带*的为必填项(全带*)");
				System.out.print("用户名:");
				String RegisterName = inScanner.next();
				System.out.print("密码:");
				String RegisterPass = inScanner.next();
				System.out.print("联系方式:");
				String RegisterTel = inScanner.next();
				System.out.print("地址:");
				String RegisterAdd = inScanner.next();
				System.out.print("真实姓名:");
				String registerTrueName = inScanner.next();
				UserInformation RegisterUser = new UserInformation(RegisterName, RegisterPass, RegisterTel, RegisterAdd, registerTrueName,"0");
				LoginandRegisterFaction lorc = new LoginandRegisterFaction();
				try {
					lorc.RegisterUser(RegisterUser);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				InterfaceGoodsAndUser u1 = new InterfaceGoodsAndUser();
				System.out.println("请选择查询类型:");
				System.out.println("1-按分类查询    2-按名称查询");
				int c1 = inScanner.nextInt();
				if(c1 == 1){
					System.out.println("1.衣服	2.食品");
					int c2 = inScanner.nextInt();
					if(c2 == 1){
						System.out.println("你查询的衣服列表如下:");
						try {
							u1.SelAllColthesThings();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(c2 == 2){
						System.out.println("你查询的食品列表如下:");
						try {
							u1.SelAllFoodsThings();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(c1 == 2){
					System.out.println("请输入您想要查找的商品类别:1-食品 	 2-衣服");
					int c8 = inScanner.nextInt();
					System.out.println("请输入您想要查询的商品名字：");
					String SelThingName = inScanner.next();
					InterfaceGoodsAndUser in = new InterfaceGoodsAndUser();
					if(c8 == 1){
						try {
							Food f = in.SelFoodWithName(SelThingName);
							System.out.println("您查询的物品列表如下:");
							System.out.println("商品名称:"+f.getGoodsName()+" 商品价格:"+f.getPrice()+" 商品库存:"+f.getGoodsCounts()+" 生产日期:"+f.getCreateDate()+" 商品重量:"+f.getWeight()+" 保质期:"+f.getKeepDate());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else{
						try {
							Colthes colthes = in.selColthesWithName(SelThingName);
							System.out.println("您查询的物品列表如下：");
							System.out.println("商品名称:"+colthes.getGoodsName()+" 商品价格:"+colthes.getPrice()+" 商品库存:"+colthes.getGoodsCounts()+" 商品颜色:"+colthes.getColor()+" 商品型号:"+colthes.getSize()+" 商品类型:"+colthes.getStyle());
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					
				}
				break;
			case 4:
				System.out.println("请您输入您要添加商品的类别:");
				System.out.println("1-食品	2-服装");
				int c = inScanner.nextInt();
				if(c == 1){
					InterfaceGoodsAndUser l1 = new InterfaceGoodsAndUser();
					try {
//						ArrayList<Food> list = l1.readerFoods();
						
						System.out.print("请输入食品名称");
						String name = inScanner.next();
						System.out.print("请输入食品价格:");
						String price = inScanner.next();
						System.out.print("请输入食品库存:");
						String count = inScanner.next();
						System.out.print("请输入食品的生产日期:");
						String Data = inScanner.next();
						System.out.print("请输入食品重量:");
						String weight = inScanner.next();
						System.out.print("请输入食品保质期:");
						String keepTime = inScanner.next();
						
						Food f = new Food(name, price, count, Data, weight, keepTime);
						//l1.add(f);
						GoodsFaction addGoods = new GoodsFaction();
						addGoods.AddFoodInformation(f);
						System.out.println("添加成功");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else if(c == 2){
					
					System.out.print("请输入衣服名称");
					String name = inScanner.next();
					System.out.print("请输入衣服价格:");
					String price = inScanner.next();
					System.out.print("请输入衣服库存:");
					String count = inScanner.next();
					System.out.print("请输入衣服的颜色:");
					String Color = inScanner.next();
					System.out.print("请输入衣服的大小:");
					String Size = inScanner.next();
					System.out.print("请输入衣服的类型:");
					String Style = inScanner.next();
					
					InterfaceGoodsAndUser l2 = new InterfaceGoodsAndUser();
					GoodsFaction addColthesFaction = new GoodsFaction();
					try {
						Colthes colthes  = new Colthes(name, price, count, Color, Size, Style);
						addColthesFaction.AddClothesInformation(colthes);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					System.out.println("请输入正确的选项!");
				}
				break;
			case 5:
				System.out.println("请选择您想要购买的商品的类别:1-食品	2-服装");
				int c3 = inScanner.nextInt();
				System.out.println("现有食品如下：");
				if(c3 == 1){
					ArrayList<Food> list2 = new ArrayList<Food>();
					InterfaceGoodsAndUser selectFood = new InterfaceGoodsAndUser();
					ArrayList<Food> list = new ArrayList<Food>();
					try {
						list = selectFood.readerFoods();
						for(int i = 0 ; i < list.size(); i++ ){
							System.out.println(i+1  + ":" + "商品名称:" + list.get(i).getGoodsName() + "   商品单价:" + list.get(i).getPrice());
						}
						int sum = 0 ;
						while(true){
						System.out.println("请选择您要购买的商品：");
						int c4 = inScanner.nextInt();
						System.out.println("请输入您要购买的数量:");
						int c5 = inScanner.nextInt();
						list.get(c4-1).setBuyNumber(c5);
						System.out.println("*******Tip********");
						//double s = Integer.parseInt(list.get(c4-1).getPrice());
						//String ssString =String.valueOf(s);
						//System.out.println(ssString);
						//System.out.println("您购买的商品名称为：" + list.get(c4-1).getGoodsName() + '\t' + "您购买的商品单价为：" + list.get(c4-1).getPrice() + '\t' + "您要购买的商品的数量为:" + c5 + '\t' );
//						+ "您要购买的商品的总价格为:" + Integer.parseInt(list.get(c4-1).getPrice()) * c5 
						list2.add(list.get(c4-1));
						System.out.println("是否继续购买?(y/n)");
						String ccc = inScanner.next();
						char cc = ccc.charAt(0);
						
						if(cc == 'n'){
							double Sum = 0f;
							
							System.out.println("您本次购买了如下商品:");
							//System.out.println("您购买的商品名称为：" + list.get(c4-1).getGoodsName() + '\t' + "您购买的商品单价为：" + list.get(c4-1).getPrice() + '\t' + "您要购买的商品的数量为:" + c5 + '\t' );
							for(int i = 0 ; i < list2.size(); i++ ){
								System.out.println("您购买的商品名称为：" + list2.get(i).getGoodsName()+ '\t' + "您购买的商品单价为：" + list2.get(i).getPrice() + '\t' + "您要购买的商品的数量为:" + list2.get(i).getBuyNumber() );
								//System.out.println(Double.parseDouble(list2.get(i).getPrice()));
								Sum += Double.parseDouble(list2.get(i).getPrice()) * list2.get(i).getBuyNumber();
							}
								Sum = Sum - (int)(Sum / 100)*SalePrice;
								System.out.print("商品的总价格是:");
								System.out.println(Sum);
							break;
						}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					ArrayList<Colthes> list2 = new ArrayList<Colthes>();
					InterfaceGoodsAndUser selectFood = new InterfaceGoodsAndUser();
					ArrayList<Colthes> list = new ArrayList<Colthes>();
					try {
						list = selectFood.readerClothes();
						for(int i = 0 ; i < list.size(); i++ ){
							System.out.println(i+1  + ":" + "商品名称:" + list.get(i).getGoodsName() + "   商品单价:" + list.get(i).getPrice());
						}
						int sum = 0 ;
						while(true){
						System.out.println("请选择您要购买的商品：");
						int c4 = inScanner.nextInt();
						System.out.println("请输入您要购买的数量:");
						int c5 = inScanner.nextInt();
						list.get(c4-1).setBuyNumber(c5);
						System.out.println("*******Tip********");
						//double s = Integer.parseInt(list.get(c4-1).getPrice());
						//String ssString =String.valueOf(s);
						//System.out.println(ssString);
						//System.out.println("您购买的商品名称为：" + list.get(c4-1).getGoodsName() + '\t' + "您购买的商品单价为：" + list.get(c4-1).getPrice() + '\t' + "您要购买的商品的数量为:" + c5 + '\t' );
//						+ "您要购买的商品的总价格为:" + Integer.parseInt(list.get(c4-1).getPrice()) * c5 
						list2.add(list.get(c4-1));
						System.out.println("是否继续购买?(y/n)");
						String ccc = inScanner.next();
						char cc = ccc.charAt(0);
						
						if(cc == 'n'){
							double Sum = 0f;
							
							System.out.println("您本次购买了如下商品:");
							//System.out.println("您购买的商品名称为：" + list.get(c4-1).getGoodsName() + '\t' + "您购买的商品单价为：" + list.get(c4-1).getPrice() + '\t' + "您要购买的商品的数量为:" + c5 + '\t' );
							for(int i = 0 ; i < list2.size(); i++ ){
								System.out.println("您购买的商品名称为：" + list2.get(i).getGoodsName()+ '\t' + "您购买的商品单价为：" + list2.get(i).getPrice() + '\t' + "您要购买的商品的数量为:" + list2.get(i).getBuyNumber() );
								//System.out.println(Double.parseDouble(list2.get(i).getPrice()));
								Sum += Double.parseDouble(list2.get(i).getPrice()) * list2.get(i).getBuyNumber() * (double)(list2.get(i).getSale()/100);
							}
								Sum = Sum - (int)(Sum / 100)*SalePrice;
								System.out.print("商品的总价格是:");
								System.out.println(Sum);
							break;
						}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				
			case 6:
				if(nowLoginUser == null){
					System.out.println("请先登录");
				}
				else{
					InterfaceGoodsAndUser interfaceGoodsAndUser = new InterfaceGoodsAndUser();
					if(!nowLoginUser.getLevel().equals("1")){
						System.out.println("您不是管理员");
					}
					else{
						System.out.println("请选择您要打折的商品类型:1-食品   2-衣服");
						int check2 = inScanner.nextInt();
						System.out.println("请输入要打折的商品名称");
						String SelThingName = inScanner.next();
						
						if(check2 == 1){
							try {
								Food food= interfaceGoodsAndUser.SelFoodWithName(SelThingName);
								System.out.println("请输入您要打折的方式:1.按折扣打折。2.满减。3.先打折再满减。");
								int check3 = inScanner.nextInt();
								if(check3 == 1){
									System.out.println("请输入要打的折扣");
									int sale = inScanner.nextInt();
									food.setSale(sale);
									double ThingPrice = Double.parseDouble(food.getPrice());
									double TrueSale = sale / 100.0f;
									double TruePrice = ThingPrice * TrueSale;
									
									System.out.print("设置打折成功,目前该商品的价格为:");
									System.out.println(TruePrice);
								}
								if(check3 == 2){
									System.out.println("请设置满减类型:设置满100减价的数量");
									SalePrice  = inScanner.nextDouble();
								}
								else{
									System.out.println("该功能未上线");
								}
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else if(check2 == 2){
							try {
								Colthes colthes = interfaceGoodsAndUser.selColthesWithName(SelThingName);
								System.out.println("请输入您要打折的方式:1.按折扣打折。2.满减。3.先打折再满减。");
								int check3 = inScanner.nextInt();
								
								
								if(check3 == 1){
									System.out.println("请输入要打的折扣");
									int sale = inScanner.nextInt();
									colthes.setSale(sale);
									double ThingPrice = Double.parseDouble(colthes.getPrice());
									double TrueSale = sale / 100.0f;
									double TruePrice = ThingPrice * TrueSale;
									
									System.out.print("设置打折成功,目前该商品的价格为:");
									System.out.println(TruePrice);
								}
								if(check3 == 2){
									System.out.println("请设置满减类型:设置满100减价的数量");
									SalePrice  = inScanner.nextDouble();
								}

								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						else{
							System.out.println("该功能未上线");
						}
					}
				}
				break;
			case 7:
				System.out.println("退了好，退了就别回来！");
				return;
			}
		}
	}

}
