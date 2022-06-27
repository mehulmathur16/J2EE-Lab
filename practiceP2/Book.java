package practiceP2;

import java.util.*;

public class Book {
	String title, author, publisher;
	Double price;
	
	Book(String title, String author, String publisher, Double price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	public void display() {
		System.out.println("Title : " + title);
		System.out.println("Author : " + author);
		System.out.println("Publisher : " + publisher);
		System.out.println("Price : " + price);
	}
}

class SortByPrice implements Comparator<Book> {
	public int compare(Book a, Book b) {
		return (a.price.compareTo(b.price));
	}
}