

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deposit
 */
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=DBconnector.connect();
		int balance=0,newbalance,accountnum=0;
		try
		{   
			
			accountnum = Credential.getAccountnum();
			int ant=Integer.parseInt(request.getParameter("amount"));
		    System.out.println(ant);
			if(ant>0){
			PreparedStatement pstmt = con.prepareStatement("select balance from user where accountnum=?");			
			pstmt.setInt(1,accountnum);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				balance=rs.getInt(1);		
			}
			
			
			newbalance=balance+ant;
			PreparedStatement pstmt1 = con.prepareStatement("update user set balance=? where accountnum=?");
			pstmt1.setInt(1,newbalance);
			pstmt1.setInt(2,accountnum);
			int i=pstmt1.executeUpdate();
			
			if(i>0)
			{
				
				System.out.println("Amount is deposited successfully...!");
			    response.sendRedirect("DepositS.html");	
			}	
			}
			else{
				System.out.println("Please enter positive number for  this process..!");
				response.sendRedirect("DepositF.html");
			}
		}catch(Exception e)
		{
		   e.printStackTrace();	
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
