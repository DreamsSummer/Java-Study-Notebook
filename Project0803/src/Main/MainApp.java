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
		//��ǰ��¼���û�
		UserInformation nowLoginUser = null;
		while(true){
			//���г���������
			System.out.println("********************************************");
			System.out.println("*		��ӭ�������ﳵϵͳ		   *");
			System.out.println("********************************************");
			System.out.println("		��ѡ����Ҫѡ��Ĳ���				 ");
			System.out.println("1-|��¼| 2-|ע��| 3-|��ѯ��Ʒ| 4-|�����Ʒ| 5-|������Ʒ| 6-|���ô���| 7-�˳�ϵͳ");
			Scanner inScanner = new Scanner(System.in);
			int check = inScanner.nextInt();
			

			
			//ѡ��ģ��
			switch (check) {
			case 1:
				System.out.print("�������û���:");
				String userName = inScanner.next();
				System.out.print("����������:");
				String passWord = inScanner.next();
				LoginandRegisterFaction faction = new LoginandRegisterFaction();
				try {
					nowLoginUser = faction.SelectUserInformationWithNameAndPass(userName, passWord);
					System.out.println("��¼�ɹ�����ӭ�� "+nowLoginUser.getTrueName());
					if(nowLoginUser.getLevel().equals("1")){
						System.out.println("���ǹ���Ա����ţ�ư�");
					}
					else if(nowLoginUser.getLevel().equals("0")){
						System.out.println("������ͨ�û����Ͻ�����");
					}
					else{
						System.out.println("�������ң����һΣ��Ͻ�ȥ��������");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("��ӭ����ע����棬��ֱ�����������Ϣ!��*��Ϊ������(ȫ��*)");
				System.out.print("�û���:");
				String RegisterName = inScanner.next();
				System.out.print("����:");
				String RegisterPass = inScanner.next();
				System.out.print("��ϵ��ʽ:");
				String RegisterTel = inScanner.next();
				System.out.print("��ַ:");
				String RegisterAdd = inScanner.next();
				System.out.print("��ʵ����:");
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
				System.out.println("��ѡ���ѯ����:");
				System.out.println("1-�������ѯ    2-�����Ʋ�ѯ");
				int c1 = inScanner.nextInt();
				if(c1 == 1){
					System.out.println("1.�·�	2.ʳƷ");
					int c2 = inScanner.nextInt();
					if(c2 == 1){
						System.out.println("���ѯ���·��б�����:");
						try {
							u1.SelAllColthesThings();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(c2 == 2){
						System.out.println("���ѯ��ʳƷ�б�����:");
						try {
							u1.SelAllFoodsThings();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(c1 == 2){
					System.out.println("����������Ҫ���ҵ���Ʒ���:1-ʳƷ 	 2-�·�");
					int c8 = inScanner.nextInt();
					System.out.println("����������Ҫ��ѯ����Ʒ���֣�");
					String SelThingName = inScanner.next();
					InterfaceGoodsAndUser in = new InterfaceGoodsAndUser();
					if(c8 == 1){
						try {
							Food f = in.SelFoodWithName(SelThingName);
							System.out.println("����ѯ����Ʒ�б�����:");
							System.out.println("��Ʒ����:"+f.getGoodsName()+" ��Ʒ�۸�:"+f.getPrice()+" ��Ʒ���:"+f.getGoodsCounts()+" ��������:"+f.getCreateDate()+" ��Ʒ����:"+f.getWeight()+" ������:"+f.getKeepDate());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else{
						try {
							Colthes colthes = in.selColthesWithName(SelThingName);
							System.out.println("����ѯ����Ʒ�б����£�");
							System.out.println("��Ʒ����:"+colthes.getGoodsName()+" ��Ʒ�۸�:"+colthes.getPrice()+" ��Ʒ���:"+colthes.getGoodsCounts()+" ��Ʒ��ɫ:"+colthes.getColor()+" ��Ʒ�ͺ�:"+colthes.getSize()+" ��Ʒ����:"+colthes.getStyle());
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					
				}
				break;
			case 4:
				System.out.println("����������Ҫ�����Ʒ�����:");
				System.out.println("1-ʳƷ	2-��װ");
				int c = inScanner.nextInt();
				if(c == 1){
					InterfaceGoodsAndUser l1 = new InterfaceGoodsAndUser();
					try {
//						ArrayList<Food> list = l1.readerFoods();
						
						System.out.print("������ʳƷ����");
						String name = inScanner.next();
						System.out.print("������ʳƷ�۸�:");
						String price = inScanner.next();
						System.out.print("������ʳƷ���:");
						String count = inScanner.next();
						System.out.print("������ʳƷ����������:");
						String Data = inScanner.next();
						System.out.print("������ʳƷ����:");
						String weight = inScanner.next();
						System.out.print("������ʳƷ������:");
						String keepTime = inScanner.next();
						
						Food f = new Food(name, price, count, Data, weight, keepTime);
						//l1.add(f);
						GoodsFaction addGoods = new GoodsFaction();
						addGoods.AddFoodInformation(f);
						System.out.println("��ӳɹ�");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else if(c == 2){
					
					System.out.print("�������·�����");
					String name = inScanner.next();
					System.out.print("�������·��۸�:");
					String price = inScanner.next();
					System.out.print("�������·����:");
					String count = inScanner.next();
					System.out.print("�������·�����ɫ:");
					String Color = inScanner.next();
					System.out.print("�������·��Ĵ�С:");
					String Size = inScanner.next();
					System.out.print("�������·�������:");
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
					System.out.println("��������ȷ��ѡ��!");
				}
				break;
			case 5:
				System.out.println("��ѡ������Ҫ�������Ʒ�����:1-ʳƷ	2-��װ");
				int c3 = inScanner.nextInt();
				System.out.println("����ʳƷ���£�");
				if(c3 == 1){
					ArrayList<Food> list2 = new ArrayList<Food>();
					InterfaceGoodsAndUser selectFood = new InterfaceGoodsAndUser();
					ArrayList<Food> list = new ArrayList<Food>();
					try {
						list = selectFood.readerFoods();
						for(int i = 0 ; i < list.size(); i++ ){
							System.out.println(i+1  + ":" + "��Ʒ����:" + list.get(i).getGoodsName() + "   ��Ʒ����:" + list.get(i).getPrice());
						}
						int sum = 0 ;
						while(true){
						System.out.println("��ѡ����Ҫ�������Ʒ��");
						int c4 = inScanner.nextInt();
						System.out.println("��������Ҫ���������:");
						int c5 = inScanner.nextInt();
						list.get(c4-1).setBuyNumber(c5);
						System.out.println("*******Tip********");
						//double s = Integer.parseInt(list.get(c4-1).getPrice());
						//String ssString =String.valueOf(s);
						//System.out.println(ssString);
						//System.out.println("���������Ʒ����Ϊ��" + list.get(c4-1).getGoodsName() + '\t' + "���������Ʒ����Ϊ��" + list.get(c4-1).getPrice() + '\t' + "��Ҫ�������Ʒ������Ϊ:" + c5 + '\t' );
//						+ "��Ҫ�������Ʒ���ܼ۸�Ϊ:" + Integer.parseInt(list.get(c4-1).getPrice()) * c5 
						list2.add(list.get(c4-1));
						System.out.println("�Ƿ��������?(y/n)");
						String ccc = inScanner.next();
						char cc = ccc.charAt(0);
						
						if(cc == 'n'){
							double Sum = 0f;
							
							System.out.println("�����ι�����������Ʒ:");
							//System.out.println("���������Ʒ����Ϊ��" + list.get(c4-1).getGoodsName() + '\t' + "���������Ʒ����Ϊ��" + list.get(c4-1).getPrice() + '\t' + "��Ҫ�������Ʒ������Ϊ:" + c5 + '\t' );
							for(int i = 0 ; i < list2.size(); i++ ){
								System.out.println("���������Ʒ����Ϊ��" + list2.get(i).getGoodsName()+ '\t' + "���������Ʒ����Ϊ��" + list2.get(i).getPrice() + '\t' + "��Ҫ�������Ʒ������Ϊ:" + list2.get(i).getBuyNumber() );
								//System.out.println(Double.parseDouble(list2.get(i).getPrice()));
								Sum += Double.parseDouble(list2.get(i).getPrice()) * list2.get(i).getBuyNumber();
							}
								Sum = Sum - (int)(Sum / 100)*SalePrice;
								System.out.print("��Ʒ���ܼ۸���:");
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
							System.out.println(i+1  + ":" + "��Ʒ����:" + list.get(i).getGoodsName() + "   ��Ʒ����:" + list.get(i).getPrice());
						}
						int sum = 0 ;
						while(true){
						System.out.println("��ѡ����Ҫ�������Ʒ��");
						int c4 = inScanner.nextInt();
						System.out.println("��������Ҫ���������:");
						int c5 = inScanner.nextInt();
						list.get(c4-1).setBuyNumber(c5);
						System.out.println("*******Tip********");
						//double s = Integer.parseInt(list.get(c4-1).getPrice());
						//String ssString =String.valueOf(s);
						//System.out.println(ssString);
						//System.out.println("���������Ʒ����Ϊ��" + list.get(c4-1).getGoodsName() + '\t' + "���������Ʒ����Ϊ��" + list.get(c4-1).getPrice() + '\t' + "��Ҫ�������Ʒ������Ϊ:" + c5 + '\t' );
//						+ "��Ҫ�������Ʒ���ܼ۸�Ϊ:" + Integer.parseInt(list.get(c4-1).getPrice()) * c5 
						list2.add(list.get(c4-1));
						System.out.println("�Ƿ��������?(y/n)");
						String ccc = inScanner.next();
						char cc = ccc.charAt(0);
						
						if(cc == 'n'){
							double Sum = 0f;
							
							System.out.println("�����ι�����������Ʒ:");
							//System.out.println("���������Ʒ����Ϊ��" + list.get(c4-1).getGoodsName() + '\t' + "���������Ʒ����Ϊ��" + list.get(c4-1).getPrice() + '\t' + "��Ҫ�������Ʒ������Ϊ:" + c5 + '\t' );
							for(int i = 0 ; i < list2.size(); i++ ){
								System.out.println("���������Ʒ����Ϊ��" + list2.get(i).getGoodsName()+ '\t' + "���������Ʒ����Ϊ��" + list2.get(i).getPrice() + '\t' + "��Ҫ�������Ʒ������Ϊ:" + list2.get(i).getBuyNumber() );
								//System.out.println(Double.parseDouble(list2.get(i).getPrice()));
								Sum += Double.parseDouble(list2.get(i).getPrice()) * list2.get(i).getBuyNumber() * (double)(list2.get(i).getSale()/100);
							}
								Sum = Sum - (int)(Sum / 100)*SalePrice;
								System.out.print("��Ʒ���ܼ۸���:");
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
					System.out.println("���ȵ�¼");
				}
				else{
					InterfaceGoodsAndUser interfaceGoodsAndUser = new InterfaceGoodsAndUser();
					if(!nowLoginUser.getLevel().equals("1")){
						System.out.println("�����ǹ���Ա");
					}
					else{
						System.out.println("��ѡ����Ҫ���۵���Ʒ����:1-ʳƷ   2-�·�");
						int check2 = inScanner.nextInt();
						System.out.println("������Ҫ���۵���Ʒ����");
						String SelThingName = inScanner.next();
						
						if(check2 == 1){
							try {
								Food food= interfaceGoodsAndUser.SelFoodWithName(SelThingName);
								System.out.println("��������Ҫ���۵ķ�ʽ:1.���ۿ۴��ۡ�2.������3.�ȴ�����������");
								int check3 = inScanner.nextInt();
								if(check3 == 1){
									System.out.println("������Ҫ����ۿ�");
									int sale = inScanner.nextInt();
									food.setSale(sale);
									double ThingPrice = Double.parseDouble(food.getPrice());
									double TrueSale = sale / 100.0f;
									double TruePrice = ThingPrice * TrueSale;
									
									System.out.print("���ô��۳ɹ�,Ŀǰ����Ʒ�ļ۸�Ϊ:");
									System.out.println(TruePrice);
								}
								if(check3 == 2){
									System.out.println("��������������:������100���۵�����");
									SalePrice  = inScanner.nextDouble();
								}
								else{
									System.out.println("�ù���δ����");
								}
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else if(check2 == 2){
							try {
								Colthes colthes = interfaceGoodsAndUser.selColthesWithName(SelThingName);
								System.out.println("��������Ҫ���۵ķ�ʽ:1.���ۿ۴��ۡ�2.������3.�ȴ�����������");
								int check3 = inScanner.nextInt();
								
								
								if(check3 == 1){
									System.out.println("������Ҫ����ۿ�");
									int sale = inScanner.nextInt();
									colthes.setSale(sale);
									double ThingPrice = Double.parseDouble(colthes.getPrice());
									double TrueSale = sale / 100.0f;
									double TruePrice = ThingPrice * TrueSale;
									
									System.out.print("���ô��۳ɹ�,Ŀǰ����Ʒ�ļ۸�Ϊ:");
									System.out.println(TruePrice);
								}
								if(check3 == 2){
									System.out.println("��������������:������100���۵�����");
									SalePrice  = inScanner.nextDouble();
								}

								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						else{
							System.out.println("�ù���δ����");
						}
					}
				}
				break;
			case 7:
				System.out.println("���˺ã����˾ͱ������");
				return;
			}
		}
	}

}
