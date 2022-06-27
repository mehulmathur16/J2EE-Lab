package practiceP2;

import java.util.*;

public class MainClass {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Book> booksList = new ArrayList<Book>();
	
	static void getBooksDetails() {
		System.out.println("Enter the number of books that you want to enter in Book Database: ");
		int n = sc.nextInt();
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println("Enter the title of Book " + (i + 1) + " : ");
			String title = sc.next();
			
			System.out.println("Enter the author of Book " + (i + 1) + " : ");
			String author = sc.next();
			
			System.out.println("Enter the publisher of Book " + (i + 1) + " : ");
			String publisher = sc.next();
			
			System.out.println("Enter the price of Book " + (i + 1) + " : ");
			Double price = sc.nextDouble();
			
			Book newBook = new Book(title, author, publisher, price);
			
			booksList.add(newBook);
		}
	}
	
	public static void main(String args[]) {
		getBooksDetails();
		
		System.out.println("*** Original Book Collection ***");
		
		for(int i = 0 ; i < booksList.size() ; i++) {
			Book curr = booksList.get(i);
			System.out.println("Details for Book " + (i + 1) + " : ");
			curr.display();
			System.out.println();
		}
		
		ArrayList<Book> copiedList = new ArrayList<Book>(booksList);
		Collections.sort(copiedList, new SortByPrice());
		
		System.out.println("*** Sorted Book Collection ***");
		
		for(int i = 0 ; i < copiedList.size() ; i++) {
			Book curr = copiedList.get(i);
			System.out.println("Details for Book " + (i + 1) + " : ");
			curr.display();
			System.out.println();
		}
		
		System.out.println("Enter the name of the author : ");
		String authorName = sc.next();
		
		System.out.println("Books with this author name are given below : ");
		
		boolean flag = false;
		
		for(Book b : booksList) {
			if(b.author.equalsIgnoreCase(authorName)) {
				b.display();
				System.out.println();
				flag = true;
			}
		}
		
		if(!flag) {
			System.out.println("No Books Found with this author name!!");
		}
		
		System.out.println("Enter the threshold Price : ");
		Double price = sc.nextDouble();
		
		System.out.println("Books with prices above than threshold price are given below : ");
		
		flag = false;
		
		ArrayList<Book> pr = new ArrayList<Book>();
		
		for(Book b : booksList) {
			if(b.price > price) {
				pr.add(b);
				flag = true;
			}
		}
		
		if(!flag) {
			System.out.println("No Books Found with prices above than threshold price!!");
		}
		else {
			for(Book b : pr) {
				b.display();
				System.out.println();
			}
		}
		
		System.out.println("Enter the Hint for book title : ");
		String bookTitleHint = sc.next();
		
		flag = false;
		
		for(Book b : booksList) {
			if(b.title.contains(bookTitleHint)) {
				b.display();
				System.out.println();
				flag = true;
			}
		}
		
		if(!flag) {
			System.out.println("No Books Found with the given Hint!!");
		}
		
		System.out.println("Enter the name of the publisher : ");
		String publisher = sc.next();
		
		flag = false;
		
		for(Book b : booksList) {
			if(b.publisher.equalsIgnoreCase(publisher)) {
				b.display();
				System.out.println();
				flag = true;
			}
		}
		
		if(!flag) {
			System.out.println("No Books Found with the given Publisher Name!!");
		}
		
		System.out.println("Enter the Title of Book whose publisher you want to change : ");
		String title = sc.next();
		
		flag = false;
		
		for(Book b : booksList) {
			if(b.title.equalsIgnoreCase(title)) {
				System.out.println("The old publisher name is : " + b.publisher);
				System.out.println("Enter the new publisher name : ");
				b.publisher = sc.next();
				System.out.println("\nPublisher name changed successfully!!! \n");
				
				b.display();
				System.out.println();
				flag = true;
				break;
			}
		}
		
		if(!flag) {
			System.out.println("No Books Found with the given Title!!");
		}
		
		sc.close();
	}
}
