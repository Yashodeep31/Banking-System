

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServFile
 */
public class ServFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */ String accountnum,password;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=DBconnector.connect();
		try{		 		 
		 String uno=request.getParameter("accountnum");
		 
		 String upass=request.getParameter("password");
	     PreparedStatement pstmt=con.prepareStatement("select* from user where accountnum=? and password=?");
		 pstmt.setString(1, uno);
		 pstmt.setString(2, upass);
		 ResultSet rs=pstmt.executeQuery();
		    if(rs.next())
		    {
		    	int accNo=rs.getInt(1);
			    	Credential.setAccountnum(accNo);
		    	System.out.println("Login sucessfully..!");
		    	response.sendRedirect("AfterLogin.html");
		     }else
		       {
		    	System.out.println("Enter valid email and password ..!");
		    	response.sendRedirect("LoginFail.html");
		    	}
		
		}catch(Exception e)
		{
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
