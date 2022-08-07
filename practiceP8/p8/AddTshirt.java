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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class AddTshirt
 */
public class AddTshirt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTshirt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accessories[] = request.getParameterValues("access");
		String tagLine = request.getParameter("tagline");
		String typeOfPocket = request.getParameter("pocket");
		String color = request.getParameter("color");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaLab", "root", "password");
			
			String selectedAccess = "";
			
			for(String s : accessories) {
				selectedAccess += (s + " ");
			}
			
			String query = "select count(*) from tshirts";
			PreparedStatement st = conn.prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			rs.next();
			int size = rs.getInt(1);
			
			int orderNo = 100 + size;
			
			String addTshirtQuery = "insert into tshirts values(?, ?, ?, ?, ?)";
			PreparedStatement stat = conn.prepareStatement(addTshirtQuery);
			
			stat.setInt(1, orderNo);
			stat.setString(2, selectedAccess);
			stat.setString(3, tagLine);
			stat.setString(4, typeOfPocket);
			stat.setString(5, color);
			
			stat.executeUpdate();
			
			PrintWriter out = response.getWriter();
			
			out.print("T-Shirt inserted successfully!");
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
