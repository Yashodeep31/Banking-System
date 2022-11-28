

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewRegister1
 */
public class NewRegister1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRegister1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection con=DBconnector.connect();	 
		 try{
			 int uno=0;
			 String uname=request.getParameter("name");
			 int ubalance= Integer.parseInt(request.getParameter("balance"));
			 String ucity=request.getParameter("city");
			 String upass=request.getParameter("password");
			 String sql="insert into user values(?,?,?,?,?)";
			 PreparedStatement pstmt = con.prepareStatement(sql);			 
			 pstmt.setInt(1,uno); 
			 pstmt.setString(2,uname);
		     pstmt.setInt(3,ubalance);
			 pstmt.setString(4,ucity);
			 pstmt.setString(5, upass);
			 
			 int i =pstmt.executeUpdate();
				if(i>0)
				{
//				System.out.println("New account is Registered...!");
				response.sendRedirect("RegisterS.html");
				}else
					response.sendRedirect("HomePage.html");	
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
