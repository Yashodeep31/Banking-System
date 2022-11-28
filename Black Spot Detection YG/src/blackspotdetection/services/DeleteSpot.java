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
 * Servlet implementation class DeleteSpot
 */
public class DeleteSpot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSpot() {
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
		
		int id =Integer.parseInt(request.getParameter("id"));
		try
		{
			Connection conn = ConnectDB.connect();
			PreparedStatement stmt4 = conn.prepareStatement("delete from addspot where id=?");
			stmt4.setInt(1,id);
			int res=stmt4.executeUpdate();
			if(res<1)
			{	
				response.sendRedirect("DeleteSpotAdmin.html");
			}
			else{
				response.sendRedirect("404.html");
				
			}
			PreparedStatement stmt3 = conn.prepareStatement("update addspot set id=?");
			stmt3.setInt(1,id);
			stmt4.executeUpdate();
			
			
		}
		catch(Exception e){
			e.printStackTrace();
	
		}
	}

}
