package practiceP3;

public class Student {
	String name, usn, address, category;
	int age;
	double g1, g2, g3, cgpa;
	
	public Student(String name, String usn, String address, String category, int age, double g1, double g2
			, double g3) {
		this.name = name;
		this.usn = usn;
		this.address = address;
		this.category = category;
		this.age = age;
		this.g1 = g1;
		this.g2 = g2;
		this.g3 = g3;
	}
	
	public double calCulateGPA() {
		cgpa = ((g1 + g2 + g3) / 3);
		return cgpa;
	}
	
	public String display() {
		return "Name : " + name + "USN : " + usn + "Address : " + address + "Category : " + category
				 + "Age : " + age + "CGPA : " + cgpa;
	}
}
