package Information;

public class Colthes extends Goods{

	/*
	//商品名称
	private String GoodsName;
	//商品价格
	private double price;
	//商品库存容量
	private int GoodsCounts;
	*/
	
	
	//颜色
	private String Color;
	//大小
	private String Size;
	//类型
	private String style;
	
	
	/*setter 和   getter方法**/
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
	
	
	//带参构造函数
	public Colthes(String goodsnameString , String price , String gc, String color , String size , String styleString ){
		super(goodsnameString, price, gc);
		this.Color = color;
		this.Size = size;
		this.style = styleString;
	}
	
}
