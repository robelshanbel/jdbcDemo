package jdbcApi.Day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbcApi.Day2.Users;

public class jdbc {

	
	static String driver="com.mysql.cj.jdbc.Driver";
	static String username="root";
	static String password="12dbpas";
	static String url="jdbc:mysql://localhost:3306/craftdatabase";
	static Connection con=null;
	
	
	static void connection () throws ClassNotFoundException, SQLException {
		
		Class.forName(driver);
		
		con= DriverManager.getConnection(url, username, password);
		
	}
	
	
	static void insert(Users users  ) throws ClassNotFoundException, SQLException {
		
		connection();
		
		String sql="INSERT INTO `craftdatabase`.`user_info` (`id`, `email`, `password`, `roles`, `user_name`) VALUES (?, ? ,?, ?, ?)";
		
		 PreparedStatement preparedStatement= con.prepareStatement(sql);
		
		 preparedStatement.setInt(1, users.getId());
		 preparedStatement.setString(2, users.getEmail());
		 preparedStatement.setString(3, users.getPassword());
		 preparedStatement.setString(4, users.getRoles());
		 preparedStatement.setString(5, users.getUsername());
		 
		  int rows= preparedStatement.executeUpdate();
		 
		  
		  System.out.println(rows + " rows affected");
		  
		 
		 
		
	}
	
	static void display(String roles) throws ClassNotFoundException, SQLException {
		
		connection();
		
		String sql="SELECT * FROM craftdatabase.user_info where roles= ?";
		
	PreparedStatement preparedStatement=	con.prepareStatement(sql);
		
	preparedStatement.setString(1, roles);
	
	 ResultSet resultSet=  preparedStatement.executeQuery();
	
	while(resultSet.next()) {
		
		System.out.println( "id -> " + resultSet.getInt(1));
		System.out.println(" email -> " + resultSet.getString(2));
		System.out.println("username -> " + resultSet.getString(3));
		System.out.println("roles -> " + resultSet.getString(4));
		System.out.println("_________________________");
		
		
	}
	
		
		
		
	}
	
	static void update(String email, String username, int id) throws ClassNotFoundException, SQLException {
		
		connection();
		
		String sql="UPDATE `craftdatabase`.`user_info` SET `email` = ?, `user_name` = ? WHERE (`id` = ?)";
		
	 PreparedStatement preparedStatement=	con.prepareStatement(sql);
		
	 preparedStatement.setString(1, email);
	 preparedStatement.setString(2, username);
	 preparedStatement.setInt(3, id);
	 
		int rows=preparedStatement.executeUpdate();
		System.out.println(rows + " rows affcted");
		
	}
	
	static void delelte() {}
	
	
	
	
	public static void main(String []args) throws ClassNotFoundException, SQLException {
		
	
		
	
		  Users users1= new Users(3, "dawit", "123456", "admin", "dawit");
		  
		  //insert(users1);
		
		  //display("admin");
		 
		  update("dawit@gmail.com","dawituser" , 3);
	} 
}

