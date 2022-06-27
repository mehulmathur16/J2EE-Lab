package practiceP1;

import java.util.*;

public class MainClass {
	
	static Scanner sc = new Scanner(System.in);
	static HashMap<Integer, String> contactList = new HashMap<Integer, String>();
	static ArrayList<Call> missedCallsList = new ArrayList<Call>();
	static int index = 0;
	
	static void insertMissedCall() {
		System.out.println("Enter Phone Number : ");
		int phoneNumber = sc.nextInt();
		System.out.println("Enter Time : ");
		String time = sc.next();
		
		String name = "Private Caller";
		
		if(contactList.containsKey(phoneNumber)) {
			name = contactList.get(phoneNumber);
		}
		
		Call newCall = new Call(name, phoneNumber, time);
		
		try {
			missedCallsList.set(index, newCall);
		}
		catch(Exception e) {
			missedCallsList.add(newCall);
		}
		
		finally {
			index = (index + 1) % 10;
		}
	}
	
	static void getCallersList() {
		System.out.println("Enter the number of people in contact list : ");
		int n = sc.nextInt();
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println("Enter the name of person " + (i + 1) + " : ");
			String name = sc.next();
			System.out.println("Enter the number of person " + (i + 1) + " : ");
			int phoneNumber = sc.nextInt();
			contactList.put(phoneNumber, name);
		}
	}
	
	public static void main(String args[]) {
		while(true) {
			System.out.println("**** Main Menu ****");
			System.out.println("1. Insert the Callers List");
			System.out.println("2. Exit");
			System.out.println("Enter your choice : ");
			
			int choice = sc.nextInt();
			
			if(choice >= 2)
				break;
			else {
				getCallersList();
				break;
			}
		}
		
		System.out.println("\nAll the callers are inserted successfully in the list!!\n");
		
		System.out.println("Enter missed Calls :");
		
		while(true) {
			System.out.println("**** Main Menu ****");
			System.out.println("1. Insert Missed Call");
			System.out.println("2. Exit");
			System.out.println("Enter your choice : ");
			
			int choice = sc.nextInt();
			
			if(choice >= 2)
				break;
			else {
				insertMissedCall();
			}
		}
		
		System.out.println("\nMissed Calls are inserted successfully in the list!!\n");
		
		int size = missedCallsList.size();
		
		for(int i = size - 1 ; i >= 0 ; i--) {
			Call curr = missedCallsList.get(i);
			
			System.out.println("\nMissed Call Number : " + curr.phoneNo);
			
			System.out.println("**** Menu ****");
			System.out.println("1. Delete Current Call");
			System.out.println("2. Next Missed Call");
			System.out.println("3. Display This Missed Call");
			System.out.println("Enter your choice : ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					missedCallsList.remove(i);
					System.out.println("Missed Call removed successfully!");
					break;
				
				case 2:
					break;
					
				case 3:
					curr.display();
					break;
			}
		}
		
		sc.close();
	}
}
