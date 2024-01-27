package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	
	static Connection con;
	public static Connection createC(){
		try {
			//LOAD THE DRIVER
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage", "root", "root");
		}catch(Exception e){
			
		e.printStackTrace();
		}
		return con;
    }
}
