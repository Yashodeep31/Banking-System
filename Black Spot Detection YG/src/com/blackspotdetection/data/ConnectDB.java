package com.blackspotdetection.data;

	import java.sql.Connection;
	import java.sql.DriverManager;

	public class ConnectDB 
	{
	  public static Connection con=null;
	  public static Connection connect()
	  {
		  try{
			  
			if(con == null){
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Black_Spot_Database","root","");
				System.out.println("Connection Estabalish: "+con);
			}
			  
		  }
		  catch(Exception e){
			  System.out.println(e);
		  }
		  return con;
	  }
	 

	}



