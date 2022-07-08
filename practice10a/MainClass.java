package practice10a;

public class MainClass {
	public static void main(String[] args) throws InterruptedException {
		stringThread st = new stringThread(); 
		numberThread nt = new numberThread();
		
		st.start();
		Thread.sleep(100);
		nt.start();
	}
}
