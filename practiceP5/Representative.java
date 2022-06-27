package practiceP5;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import com.mysql.jdbc.*;

public class Representative extends JFrame implements ActionListener{
	public JLabel repno, repName, state, comission, rate;
	public JTextField txtrepno, txtrepName, txtstate, txtcomission, txtrate;
	public JButton addRepresentative;
	
	public Representative() {
		repno = new JLabel("Rep No : ");
		repName = new JLabel("Rep Name : ");
		state = new JLabel("State : ");
		comission = new JLabel("Comission : ");
		rate = new JLabel("Rate : ");
		
		txtrepno = new JTextField();
		txtrepName = new JTextField();
		txtstate = new JTextField();
		txtcomission = new JTextField();
		txtrate = new JTextField();
		
		addRepresentative = new JButton("Add Representative");
		
		add(repno);
		add(txtrepno);
		add(repName);
		add(txtrepName);
		add(state);
		add(txtstate);
		add(comission);
		add(txtcomission);
		add(rate);
		add(txtrate);
		
		add(addRepresentative);
		
		setLayout(new GridLayout(6, 2));
		setSize(600, 400);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addRepresentative.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addRepresentative) {
			int RepNo = Integer.parseInt(txtrepno.getText());
			String RepName = txtrepName.getText();
			String State = txtstate.getText();
			int Comission = Integer.parseInt(txtcomission.getText());
			int Rate = Integer.parseInt(txtrate.getText());
			
			Connection conn = connection.c;
			
			String query = "insert into representative values(?, ?, ?, ?, ?)";
			
			try {
				PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
				
				st.setInt(1, RepNo);
				st.setString(2, RepName);
				st.setString(3, State);
				st.setInt(4, Comission);
				st.setInt(5, Rate);
				
				st.executeUpdate();
				
				JOptionPane.showMessageDialog(this, "Representative Added Successfully!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
}
