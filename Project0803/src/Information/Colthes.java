package Information;

public class Colthes extends Goods{

	/*
	//��Ʒ����
	private String GoodsName;
	//��Ʒ�۸�
	private double price;
	//��Ʒ�������
	private int GoodsCounts;
	*/
	
	
	//��ɫ
	private String Color;
	//��С
	private String Size;
	//����
	private String style;
	
	
	/*setter ��   getter����**/
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	
	//���ι��캯��
	public Colthes(String goodsnameString , String price , String gc, String color , String size , String styleString ){
		super(goodsnameString, price, gc);
		this.Color = color;
		this.Size = size;
		this.style = styleString;
	}
	
}
