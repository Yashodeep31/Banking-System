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
 * Servlet implementation class AddStation
 */
public class AddStation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStation() {
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
		String sname = request.getParameter("sname");
		String saddress = request.getParameter("saddress");
		String scontact=request.getParameter("scontact");
		String email=request.getParameter("email");
		String password = request.getParameter("password");
		
	
		
			
		
		try{
			Connection con = ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("insert into addstation values(?,?,?,?,?,?)");
			ps1.setInt(1,id);
			ps1.setString(2,sname);
			ps1.setString(3,saddress);
			ps1.setString(4,scontact);
			ps1.setString(5,email );
			ps1.setString(6,password);
			
			int res = ps1.executeUpdate();
			if(res>0)
			{
				
			    response.sendRedirect("Sucess.html");
			}
			else
			{
				response.sendRedirect("addStation.html");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
