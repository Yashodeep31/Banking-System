<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="com.blackspotdetection.data.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete spot from Admin</title>
</head>
<body>
<%
int id =Integer.parseInt(request.getParameter("id"));
try
{
	Connection conn = ConnectDB.connect();
	PreparedStatement stmt4 = conn.prepareStatement("delete from addspot where id=?");
	stmt4.setInt(1,id);
	int res=stmt4.executeUpdate();
	if(res<1)
	{	
		response.sendRedirect("DeleteSpotFromAdmin.jsp");
	}
	else{
		response.sendRedirect("AdminDashboard.html");
		
	}
	/*PreparedStatement stmt3 = conn.prepareStatement("update userdetails set id=?");
	stmt3.setInt(1,id);
	stmt4.executeUpdate()*/;
	
	
}
catch(Exception e){
	e.printStackTrace();

}
%>


</body>
</html>