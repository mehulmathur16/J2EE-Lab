package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.*;

/**
 * Servlet implementation class ReserveTicket
 */
public class ReserveTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String customerName = request.getParameter("name");
		String customerPhone = request.getParameter("phoneNo");
		String date = request.getParameter("date");
		int flightNo = Integer.parseInt(request.getParameter("flightNo"));
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaLab", "root", "password");
			
			//Firstly we have to validate if the flight number is valid!
			String query = "select* from Flight where flight_no = " + flightNo;
			
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			
			PrintWriter out = response.getWriter();
			
			if(!rs.next()) {
				out.print("Flight Number not found!");
			}
			else {
				//If the Flight number is valid, then we can make reservation
				//and insert this new record in seatReservation table by generating 
				//a random seat number b/w 1-500
				
				int seatNumber = (int) ((Math.random() * 500) + 1);
				
				String insertionQuery = "insert into seatReservation values(?, ?, ?, ?, ?)";
				
				PreparedStatement stat = (PreparedStatement) conn.prepareStatement(insertionQuery);
				
				stat.setInt(1, flightNo);
				stat.setString(2, date);
				stat.setInt(3, seatNumber);
				stat.setString(4, customerName);
				stat.setString(5, customerPhone);
				
				stat.executeUpdate();
				
				String display = "Reservation Successful!\n\n" + "Name : " + customerName + "\nPhone Number : " + customerPhone + "\nDate : " + date + 
						"\nFlight No : " + flightNo + "\nSeat Number : " + seatNumber;
				
				out.print(display);
			}
		} catch (ClassNotFoundException | SQLException e) {
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
