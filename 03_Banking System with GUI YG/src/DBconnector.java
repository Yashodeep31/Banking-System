

	import java.sql.Connection;
	import java.sql.DriverManager;
	public class DBconnector {
		
			static Connection connect()
			{
				Connection con=null;
				try
				{
					System.out.println("Driver is loading..!");
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver is loaded..!");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hbank","root","");
					System.out.println("Connection established sucessfully");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return(con);
			}

	}






