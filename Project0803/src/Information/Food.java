package Information;

public class Food extends Goods{
	/*
	//��Ʒ����
	private String GoodsName;
	//��Ʒ�۸�
	private double price;
	//��Ʒ�������
	private int GoodsCounts;
	*/
	
	//��������
	private String createDate;
	//����
	private String Weight;
	//������
	private String keepDate;
	
	/**setter ��   getter����*/
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
