package program6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ITreturns
 */
public class ITreturns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ITreturns() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String salary = request.getParameter("salary");
		String tax = request.getParameter("tax");
		
		PrintWriter out = response.getWriter();
		out.println(name + " " + gender + " " + salary + " " + tax);
		
		File file = new File("C:\\Users\\Mehul Mathur\\OneDrive\\Desktop\\Servelet\\a.txt");
		FileOutputStream fout = new FileOutputStream(file);
		
		fout.write((name + " " + gender + " " + salary + " " + tax).getBytes());
		
		fout.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
