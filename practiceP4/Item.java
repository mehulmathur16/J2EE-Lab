package practiceP4;

public class Item {
	String name;
	double price;
	int quantity;
	
	public Item(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String display() {
		String s = "Name : " + name + " Price : " + price + " Quantity : " + quantity + "\n";
		return s;
	}
}
