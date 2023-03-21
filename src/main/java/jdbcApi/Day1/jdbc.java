package jdbcApi.Day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {

	
	
	public static void main(String []args) throws ClassNotFoundException, SQLException {
		
	
		
		// step 1 load the Driver jdbc driver classs 
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	    // step 2 Connection attribute
		
		String username= "root";
		String password="12dbpas";
		String url="jdbc:mysql://localhost:3306/craftdatabase";
		
		// Step 3  Create a connection 
		
		Connection connection  =	DriverManager.getConnection(url, username, password);
		
		
		// Step 4 Create a stmn  
		 // 1.statmenent   2. prestatmenent
		
		 // 1 
		 
		//Statement statement = connection.createStatement();
		
		// 2
		
		String sql="SELECT * FROM craftdatabase.user_info where id= ?";
		
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, 1);
		
		
		 ResultSet resultSet = preparedStatement.executeQuery();
		
		
	

			
			
			while(resultSet.next()) {
			
		int id=	resultSet.getInt("id");
		String email=	resultSet.getString("email");
		String passwords=	resultSet.getString("password");
		String usernames=	resultSet.getString("user_name");
		String roles=	resultSet.getString("roles");
			
			
		System.out.println(id);
		System.out.println(email);
		System.out.println(passwords);
		System.out.println(usernames);
		System.out.println(roles);
		System.out.println("--------------------------");
		
			}
		 
		 
		
		
	} 
}
