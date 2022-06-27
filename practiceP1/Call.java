package practiceP1;

public class Call {
	String name;
	int phoneNo;
	String time;
	
	Call(String name, int phoneNo, String time) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.time = time;
	}
	
	public void display() {
		System.out.println("Name : " + name);
		System.out.println("Number : " + phoneNo);
		System.out.println("Time : " + time);
	}
}
