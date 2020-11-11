package com.codetalks.login.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.codetalks.login.model.StudentLogin;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class StudentLoginDao {
	
	public static int registerUser(StudentLogin student) throws ClassNotFoundException{
		
		
		String INSERT_USERS_SQL="insert into register "+" (firstname,email,password) values "+" (?,?,?);";
		int result=0;
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection=(Connection) DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/codetalks","root","root"); 
			PreparedStatement  preparedstatement=(PreparedStatement) connection.prepareStatement(INSERT_USERS_SQL);
			preparedstatement.setString(1,StudentLogin.getFullname());
			preparedstatement.setString(2,StudentLogin.getEmail());
			preparedstatement.setString(3,StudentLogin.getPassword());
			
			System.out.println(preparedstatement);
			result=preparedstatement.executeUpdate();
			
	}catch(SQLException e){e.printStackTrace();}
		
		return result;
	
}
}
