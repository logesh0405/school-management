package school_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_connection  {
	
	public static void main (String args []) throws ClassNotFoundException {
		/*String url ="jdbc:mysql://localhost:3306/school_management";
		String user ="root";
		String password ="root";
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection =DriverManager.getConnection(url, user, password);
		System.out.println("Connection is Successful to the database"+url);
		String query="Insert into students(student_Id,student_Name,studentAdress ,studentAge,schoolname ) values(101,ram,chennai,15,abc) ";
		Statement statement =connection.createStatement();
		statement.execute(query);
		}
		catch(ClassNotFoundException e) {
		e.printStackTrace();
		}
		catch(SQLException throwable) {
		throwable.printStackTrace();
		}
		}
		

	}*/
		  
		 try {
		   
		   Class.forName("com.mysql.cj.jdbc.Driver");
		         
		          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school_management", "root", "root");
		             if(con!=null)
		             {
		                 System.out.println("Connected Sucessfully!!");
		             }
		             else
		             {
		                 System.out.println("Problem in connection!!"); 
		             }
		         }
		         catch(SQLException e) 
		         {
		             System.out.println(e.getMessage());
		         }
 
}
}



