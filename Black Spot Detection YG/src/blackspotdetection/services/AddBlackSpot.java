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
 * Servlet implementation class AddBlackSpot
 */
public class AddBlackSpot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBlackSpot() {
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
		String latitude=request.getParameter("latitude");
		String longitude=request.getParameter("longitude");
		String location = request.getParameter("location");
		String address = request.getParameter("address");
		String reason=request.getParameter("reason");
		int level=Integer.parseInt(request.getParameter("level"));
		String city = request.getParameter("city");
		String type = request.getParameter("type");
		
	
		
			
		
		try{
			Connection con = ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("insert into addspot values(?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1,id);
			ps1.setString(2,latitude );
			ps1.setString(3,longitude);
			ps1.setString(4,location);
			ps1.setString(5,address);
			ps1.setString(6,reason );
			ps1.setInt(7,level);
			ps1.setString(8,city);
			ps1.setString(9,type);
			
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


