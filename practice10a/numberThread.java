package practice10a;

import java.util.Scanner;

public class numberThread extends Thread {
	public void run() {
		System.out.println("Enter a number : ");
		
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		
		String[] digit = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven",
				"eight", "nine" };
		
		String res = "";
		
		for(char c : n.toCharArray()) {
			res = res + (digit[c - '0'] + " ");
		}
		
		System.out.println("Number in String format : " + res);
	}
}
