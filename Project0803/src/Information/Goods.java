package Information;

public class Goods {
	
	//��Ʒ����
	private String GoodsName;
	//��Ʒ�۸�
	private String price;
	//��Ʒ�������
	private String GoodsCounts;
	//��Ʒ�ۿ�
	private int sale;
	
	private int BuyNumber;

	public int getBuyNumber() {
		return BuyNumber;
	}
	public void setBuyNumber(int buyNumber) {
		BuyNumber = buyNumber;
	}
	/**setter��getter����*/
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getGoodsCounts() {
		return GoodsCounts;
	}
	public void setGoodsCounts(String goodsCounts) {
		GoodsCounts = goodsCounts;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	
	
	/**���������췽��*/
	public Goods(String goodnameString , String price , String goodcounts ){
		this.GoodsName = goodnameString;
		this.price = price;
		this.GoodsCounts = goodcounts;
		this.sale = 100;
	}
	
	/**�޲ι��췽��*/
	public Goods(){
		this.GoodsName = "";
		this.price = "0";
		this.GoodsCounts = "0" ;
		this.sale = 100;
	}
	
}
