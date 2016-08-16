package Information;

public class Goods {
	
	//商品名称
	private String GoodsName;
	//商品价格
	private String price;
	//商品库存容量
	private String GoodsCounts;
	//商品折扣
	private int sale;
	
	private int BuyNumber;

	public int getBuyNumber() {
		return BuyNumber;
	}
	public void setBuyNumber(int buyNumber) {
		BuyNumber = buyNumber;
	}
	/**setter和getter方法*/
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
	
	
	/**带参数构造方法*/
	public Goods(String goodnameString , String price , String goodcounts ){
		this.GoodsName = goodnameString;
		this.price = price;
		this.GoodsCounts = goodcounts;
		this.sale = 100;
	}
	
	/**无参构造方法*/
	public Goods(){
		this.GoodsName = "";
		this.price = "0";
		this.GoodsCounts = "0" ;
		this.sale = 100;
	}
	
}
