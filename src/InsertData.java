

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertData
 */
@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doGet(request, response);
	    PrintWriter out = response.getWriter();
	    String name = request.getParameter("name");
	    String surname = request.getParameter("surname");
	    String email = request.getParameter("email");
	    String college = request.getParameter("college");
	    String sclass = request.getParameter("sclass");
	    String subject = request.getParameter("subject");
	    
	    try 
	    {

	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/balludb","root","root");
	            Statement stmt = con.createStatement();
	            stmt.executeUpdate("insert into student (name,surname,email)values('"+name+"','"+surname+"','"+email+"') ");
	            stmt.executeUpdate("insert into education (college,sclass,subject)values('"+college+"','"+sclass+"','"+subject+"') ");
	            
	            out.println("Data is inserted successfully in both tables");
	    	
	    }
	    catch(ClassNotFoundException e)
	    {
	    	e.printStackTrace();
	    }
	    
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	}

}
