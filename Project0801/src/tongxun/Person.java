package tongxun;

import javax.swing.text.html.Option;

public class Person {
	private String name;
	private String number;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Person(String name , String number){
		super();
		this.name = name;
		this.number = number;
	}
}
