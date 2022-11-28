

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=DBconnector.connect();
		int balance=0,amount=0,newbalance1,newbalance2,ant;
		try
		{
			int accountnum = Credential.getAccountnum();
			
			PreparedStatement pstmt=con.prepareStatement("select balance from user where accountnum=?");
			pstmt.setInt(1, accountnum);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				{
					balance=rs.getInt(1);
					System.out.println("Enter the withdraw ammount :");
					amount=Integer.parseInt(request.getParameter("amount"));
							
				}
		if(amount>0)
		{
			ant=Integer.parseInt(request.getParameter("accno"));
			String sql="select balance from user where accountnum=?";
			PreparedStatement pstmt3 = con.prepareStatement(sql);
			pstmt3.setInt(1,ant);
			ResultSet rs1=pstmt3.executeQuery();
			if(rs1.next())
			{
				balance=rs1.getInt(1);	
			}
			else
			{
				System.out.println("Enter valid account number..!");
				response.sendRedirect("TransferFailS.html");
				return;
			}
			if(amount<balance){
				newbalance1=balance-amount;
				PreparedStatement pstmt2 = con.prepareStatement("update user set balance =? where accountnum=?");
				pstmt2.setInt(1,newbalance1);
				pstmt2.setInt(2,accountnum);
				int i=pstmt2.executeUpdate();
				if(i>0)
				{
					System.out.println("Amount is withdraw successfully...!");
					response.sendRedirect("TransferS.html");
				    	
				}}
				else{
					System.out.println("Plzz enter less amount than your balance to withdraw..!");
					response.sendRedirect("TransferFailS.html");
				}
			}else
			{
				System.out.println("Enter valid account number..!");
				response.sendRedirect("TransferFailS.html");
				return;
			}
			newbalance2=balance+amount;
			PreparedStatement pstmt4 = con.prepareStatement("update user set balance =? where accountnum=?");
			pstmt4.setInt(1,newbalance2);
			pstmt4.setInt(2,ant);
			int i=pstmt4.executeUpdate();
			if(i>0)
			{
				System.out.println("Amount is deposited successfully...!");
				response.sendRedirect("TransferS.html");
			    	
			}	
		}else
		{
			System.out.println("Amount is negative.");
			response.sendRedirect("TransferFailS.html");
			
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
