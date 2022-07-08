package practice10a;

import java.util.Scanner;

public class stringThread extends Thread{
	public void run() {
		System.out.println("Enter a String : ");
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		String vowels = "aeiou";
		
		int count = 0;
	
		for(char c : s.toCharArray()) {
			for(char ch : vowels.toCharArray()) {
				if(c == ch) {
					count++;
				}
			}
		}
		
		System.out.println("Number of vowels : " + count);
	}
}
