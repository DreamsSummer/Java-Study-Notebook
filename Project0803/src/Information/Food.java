package Information;

public class Food extends Goods{
	/*
	//商品名称
	private String GoodsName;
	//商品价格
	private double price;
	//商品库存容量
	private int GoodsCounts;
	*/
	
	//生产日期
	private String createDate;
	//重量
	private String Weight;
	//保质期
	private String keepDate;
	
	/**setter 和   getter方法*/
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getWeight() {
		return Weight;
	}
	public void setWeight(String weight) {
		Weight = weight;
	}
	public String getKeepDate() {
		return keepDate;
	}
	public void setKeepDate(String keepDate) {
		this.keepDate = keepDate;
	}
	
	public Food(String nameString , String price , String goodcounts , String createdateString , String weight , String keepdate){
		super(nameString, price, goodcounts);
		this.createDate = createdateString;
		this.Weight = weight;
		this.keepDate = keepdate;
	}
}
