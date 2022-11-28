package blackspotdetection.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackspotdetection.data.ConnectDB;

/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		int id=0;
		String name = request.getParameter("name");
		String email=request.getParameter("email");
		String mobileno=request.getParameter("mobileno");
		String password = request.getParameter("password");
		String city=request.getParameter("city");
		
			
		
		try{
			Connection con = ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			ps1.setInt(1,id);
			ps1.setString(2, name);
			ps1.setString(3,email );
			ps1.setString(4, mobileno);
			ps1.setString(5, password);
			ps1.setString(6,city);
	
			int res = ps1.executeUpdate();
			if(res>0)
			{
				
			    response.sendRedirect("LoginDashBoard.html");
			}
			else
			{
				response.sendRedirect("RegisterUserView.html");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}

}
