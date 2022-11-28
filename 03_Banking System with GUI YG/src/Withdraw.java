

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Withdraw
 */
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
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
			
			if(ant<balance){
				newbalance=balance-ant;
				PreparedStatement pstmt2 = con.prepareStatement("update user set balance =? where accountnum=?");
				pstmt2.setInt(1,newbalance);
				pstmt2.setInt(2,accountnum);
				int i=pstmt2.executeUpdate();
				if(i>0)
				{
					System.out.println("Amount is withdraw successfully...!");
					response.sendRedirect("WithdrawS.html");
				    	
				}}
				else{
					System.out.println("Plzz enter less amount than your balance to withdraw..!");
					response.sendRedirect("WithdrawF.html");
				}
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
