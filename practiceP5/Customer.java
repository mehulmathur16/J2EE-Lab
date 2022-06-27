package practiceP5;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.mysql.jdbc.*;

public class Customer extends JFrame implements ActionListener{
	public JLabel custno, custName, state, creditLimit, repNo;
	public JTextField txtcustno, txtcustName, txtstate, txtcreditLimit, txtrepNo;
	public JButton addCustomer;
	public JTextArea area;
	
	public Customer() {
		custno = new JLabel("Customer No : ");
		custName = new JLabel("Customer Name : ");
		state = new JLabel("State : ");
		creditLimit = new JLabel("Credit Limit : ");
		repNo = new JLabel("Rep No : ");
		
		txtcustno = new JTextField();
		txtcustName = new JTextField();
		txtstate = new JTextField();
		txtcreditLimit = new JTextField();
		txtrepNo = new JTextField();
		
		addCustomer = new JButton("Add Customer");
		
		area = new JTextArea();
		
		add(custno);
		add(txtcustno);
		add(custName);
		add(txtcustName);
		add(state);
		add(txtstate);
		add(creditLimit);
		add(txtcreditLimit);
		add(repNo);
		add(txtrepNo);
		
		add(addCustomer);
		add(area);
		
		setLayout(new GridLayout(6, 2));
		setSize(600, 400);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addCustomer.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addCustomer) {
			int custno = Integer.parseInt(txtcustno.getText());
			String custName = txtcustName.getText();
			String State = txtstate.getText();
			int creditLimit = Integer.parseInt(txtcreditLimit.getText());
			int repNo = Integer.parseInt(txtrepNo.getText());
			
			Connection conn = connection.c;
			
			String query = "insert into customer values(?, ?, ?, ?, ?)";
			
			try {
				PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				
				st.setInt(1, custno);
				st.setString(2, custName);
				st.setString(3, State);
				st.setInt(4, creditLimit);
				st.setInt(5, repNo);
				
				st.executeUpdate();
				
				JOptionPane.showMessageDialog(this, "Customer Added Successfully!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			if(creditLimit > 15000) {
				String subQuery = "select* from representative where RepNo = " + repNo;
				
				try {
					PreparedStatement subst = (PreparedStatement) conn.prepareStatement(subQuery);
					
					ResultSet rs = subst.executeQuery();
					
					while(rs.next()) {
						String display = "Representative Information\n\n" + "Rep No : " + 
					rs.getString("RepNo") + "\nRep Name : " + rs.getString("RepName") + 
					"\nState : " + rs.getString("State") + "\nComission : " + rs.getString("Comission") + 
					"\nRate : " + rs.getString("Rate");
						
						area.setText(display);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		}
	}
}

