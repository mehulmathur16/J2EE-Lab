package practiceP3;

import java.util.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main extends Frame implements ActionListener{
	public JLabel name, usn, age, address, g1, g2, g3, category;
	public JTextField txtname, txtusn, txtage, txtaddress, txtg1, txtg2, txtg3;
	public JButton submit, display;
	public JTextArea area;
	
	public JComboBox<String> categoryBox;
	
	public String cats[] = {"GM", "SC", "ST"};
	public ArrayList<Student> studentList = new ArrayList<Student>();
	
	public Main() {
		name = new JLabel("Name");
		usn = new JLabel("USN");
		age = new JLabel("Age");
		address = new JLabel("Address");
		g1 = new JLabel("SGPA - 1");
		g2 = new JLabel("SGPA - 2");
		g3 = new JLabel("SGPA - 3");
		category = new JLabel("Category");
		
		txtname = new JTextField();
		txtusn = new JTextField();
		txtaddress = new JTextField();
		txtage = new JTextField();
		txtg1 = new JTextField();
		txtg2 = new JTextField();
		txtg3 = new JTextField();
		
		categoryBox = new JComboBox<String>(cats);
		
		submit = new JButton("Submit");
		display = new JButton("Display");
		area = new JTextArea();
		
		add(name);
		add(txtname);
		add(usn);
		add(txtusn);
		add(age);
		add(txtage);
		add(address);
		add(txtaddress);
		add(category);
		add(categoryBox);
		add(g1);
		add(txtg1);
		add(g2);
		add(txtg2);
		add(g3);
		add(txtg3);
		add(submit);
		add(display);
		add(area);
		
		display.addActionListener((ActionListener) this);
		submit.addActionListener((ActionListener) this);
	}
	
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() == submit) {
			try {
				int age = Integer.parseInt(txtage.getText()) ;
				
				if(age < 0 || age > 100) {
					txtage.setText(JOptionPane.showInputDialog("Reenter Age : "));
				}
			}
			catch(Exception e) {
				txtage.setText(JOptionPane.showInputDialog("Reenter Age : "));
			}
			
			Student newStudent = new Student(txtname.getText(), txtusn.getText(), 
					txtaddress.getText(), (String) categoryBox.getItemAt(categoryBox.getSelectedIndex()),
					Integer.parseInt(txtage.getText()), Double.parseDouble(txtg1.getText()), Double.parseDouble(txtg2.getText()), 
					Double.parseDouble(txtg3.getText()) );
			
			newStudent.calCulateGPA();
			studentList.add(newStudent);
		}
		
		if(ev.getSource() == display) {
			for(Student s : studentList) {
				area.setText(s.display());
			}
		}
	}
	
	public static void main(String args[]) {
		Main m = new Main();
		m.setLayout(new GridLayout(10, 2));
		m.setSize(600, 400);
		m.setVisible(true);
	}
}
