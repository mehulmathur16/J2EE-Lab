package practiceP4;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;

public class Main extends Frame implements ActionListener{
	
	public JLabel username, password, phoneNo, cid, itemName, quantity, price;
	public JTextField txtusername, txtpassword, txtphoneNo, txtcid, txtitemName, txtquantity, txtprice;
	public JButton login, addItem, checkout;
	public JTextArea area;
	public JScrollPane scrollArea;
	
	ArrayList<Staff> staffList = new ArrayList<Staff>();
	ArrayList<Item> itemsList = new ArrayList<Item>();
	
	boolean isFirstItem = true;
	double totalAmount = 0;

	public Main() {
		staffList.add(new Staff("a", "a"));
		username = new JLabel("Username");
		password = new JLabel("Password");
		phoneNo = new JLabel("Phone No");
		cid = new JLabel("Customer ID");
		itemName = new JLabel("Item Name");
		quantity = new JLabel("Quantity");
		price = new JLabel("Price");
		
		txtusername = new JTextField();
		txtpassword = new JTextField();
		txtphoneNo = new JTextField();
		txtcid = new JTextField();
		txtitemName = new JTextField();
		txtquantity = new JTextField();
		txtprice = new JTextField();
		
		login = new JButton("Login");
		addItem = new JButton("Add Item");
		checkout = new JButton("Checkout");
		
		area = new JTextArea();
		scrollArea = new JScrollPane(area);

		add(username);
		add(txtusername);
		add(password);
		add(txtpassword);
		add(phoneNo);
		add(txtphoneNo);
		add(cid);
		add(txtcid);
		add(itemName);
		add(txtitemName);
		add(quantity);
		add(txtquantity);
		add(price);
		add(txtprice);
		add(login);
		add(addItem);
		add(checkout);
		add(scrollArea);
		
		login.addActionListener(this);
		addItem.addActionListener(this);
		checkout.addActionListener(this);
		
		phoneNo.setVisible(false);
		txtphoneNo.setVisible(false);
		cid.setVisible(false);
		txtcid.setVisible(false);
		itemName.setVisible(false);
		txtitemName.setVisible(false);
		quantity.setVisible(false);
		txtquantity.setVisible(false);
		price.setVisible(false);
		txtprice.setVisible(false);
		scrollArea.setVisible(false);
		addItem.setVisible(false);
		checkout.setVisible(false);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			String un = txtusername.getText();
			String pass = txtpassword.getText();
			boolean newUser = false;
			
			for(Staff s : staffList) {
				if(s.username.equals(un) && s.password.equals(pass)) {
					JOptionPane.showMessageDialog(this, "Logged In Successfully");
					newUser = true;	
				}
			}
			
			if(newUser) {
				JOptionPane.showMessageDialog(this, "Add a new customer");
				
				phoneNo.setVisible(true);
				txtphoneNo.setVisible(true);
				cid.setVisible(true);
				txtcid.setVisible(true);
				itemName.setVisible(true);
				txtitemName.setVisible(true);
				quantity.setVisible(true);
				txtquantity.setVisible(true);
				price.setVisible(true);
				txtprice.setVisible(true);
				scrollArea.setVisible(true);
				addItem.setVisible(true);
				checkout.setVisible(true);
				
				username.setVisible(false);
				txtusername.setVisible(false);
				password.setVisible(false);
				txtpassword.setVisible(false);
				login.setVisible(false);
				
				area.setText("");
			}
			else {
				JOptionPane.showMessageDialog(this, "No User Found!");
			}
		}
		else if(e.getSource() == addItem){
			area.setText("Customer ID : " + txtcid.getText() + "\nPhone Number : " + txtphoneNo.getText() + "\n");
			
			String iName = txtitemName.getText();
			double price = Double.parseDouble(txtprice.getText());
			int quantity = Integer.parseInt(txtquantity.getText());
			
			totalAmount += (price * quantity);
			
			Item newItem = new Item(iName, price, quantity);
			itemsList.add(newItem);
			
			for(Item i : itemsList) {
				area.setText(area.getText() + i.display());
			}
			
			area.setText(area.getText() + "Total Amount : " + totalAmount);
			
			txtitemName.setText("");
			txtprice.setText("");
			txtquantity.setText("");
		}
		else {
			phoneNo.setVisible(false);
			txtphoneNo.setVisible(false);
			cid.setVisible(false);
			txtcid.setVisible(false);
			itemName.setVisible(false);
			txtitemName.setVisible(false);
			quantity.setVisible(false);
			txtquantity.setVisible(false);
			price.setVisible(false);
			txtprice.setVisible(false);
			addItem.setVisible(false);
			checkout.setVisible(false);
			
			username.setVisible(true);
			txtusername.setVisible(true);
			password.setVisible(true);
			txtpassword.setVisible(true);
			login.setVisible(true);
			
			txtusername.setText("");
			txtpassword.setText("");
			txtphoneNo.setText("");
			txtquantity.setText("");
			txtprice.setText("");
			txtcid.setText("");
			txtitemName.setText("");
			
			area.setText("Total Bill Amount : " + totalAmount);
			totalAmount = 0;
		}
	}
	
	public static void main(String args[]) {
		Main m = new Main();
		m.setLayout(new GridLayout(9,2));
		m.setSize(600, 400);
		m.setVisible(true);
	}
}
