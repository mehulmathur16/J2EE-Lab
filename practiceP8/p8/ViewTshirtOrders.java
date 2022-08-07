package p8;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ViewTshirtOrders
 */
public class ViewTshirtOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTshirtOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String display = "";
		
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaLab", "root", "password");
			
			String query = "select* from tshirts";
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			
			display += "<table border='2'><th>Order No</th><th>Accessories</th><th>Tagline</th><th>Pocket</th><th>Color</th>"; 
			
			while(rs.next()) {
				display += "<tr><td>" + rs.getString(1) +"</td>" + "<td>" + rs.getString(2) +"</td>" + "<td>" + rs.getString(3) +"</td>" + "<td>" + rs.getString(4) +"</td>" + "<td>" + rs.getString(5) +"</td></tr>";
			}
			
			out.print(display);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
