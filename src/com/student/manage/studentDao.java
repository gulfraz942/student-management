package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class studentDao {
	
	public static boolean insertToDB(student st) {
		boolean f = false;
		try {
			//JDBC CODE
						
			Connection con = CP.createC();
			String q = "insert into students(sname,sphone,scity) values(?,?,?)";
			//Prepared statement
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2,st.getStudentPhone());
			pstmt.setString(3,st.getStudentCity());
			
			//execute
			pstmt.executeUpdate();
			f = true;
			
		}catch (Exception e){
			e.printStackTrace();
			
		}
		return f;
		
	}
	
	
	public static boolean deleteFromDB(student st1) {
	    boolean success = false;
	    try {
	        Connection con = CP.createC();
	        String query = "DELETE FROM students WHERE sid = ?";
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, st1.getStudentId()); // Use getStudentId() to retrieve the ID
	        pstmt.executeUpdate();
	        
	            success = true;
	        
	    } catch (Exception e) {
	        e.printStackTrace(); // Print the stack trace for debugging
	    }
	    return success;
	}

	
	
	public static boolean displayDetails(student st2) {
		boolean success = false;
	    try {
	        Connection con = CP.createC();
	        String query = "SELECT * FROM students WHERE sid = ?";
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, st2.getStudentId()); // Use getStudentId() to retrieve the ID
	        ResultSet resultSet = pstmt.executeQuery();

	        if (resultSet.next()) {
	            // Student details found
	            st2.setStudentName(resultSet.getString("sname"));
	            st2.setStudentPhone(resultSet.getString("sphone"));
	            st2.setStudentCity(resultSet.getString("scity"));

	            // Debugging: Print student details
	            System.out.println("Student details: " + st2.toString());

	            success = true;
	        } else {
	            // No student found with the given ID
	            System.out.println("No student found with ID: " + st2.getStudentId());
	        }

	        // Close resources
	        resultSet.close();
	        pstmt.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return success;
	}

}
