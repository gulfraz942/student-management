import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.student;
import com.student.manage.studentDao;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
         System.out.println("Welcome to student management");
         
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         while(true) {
        	 System.out.println("Press 1 to Add student");
        	 System.out.println("Press 2 to Delete student");
        	 System.out.println("Press 3 to Display student");
        	 System.out.println("Press 4 to Exit from student");
        	 
        	 int c = Integer.parseInt(br.readLine());
        	 
        	 
        	 if(c==1) {
        		 //add student
        		 System.out.println("Enter Student Name :");
        		 String name = br.readLine();
        		 
        		 System.out.println("Enter Studen phone :");
        		 String phone = br.readLine();
        		 
        		 System.out.println("Enter Student city :");
        		 String city = br.readLine();
        		 
        		 //student object
        		 student st = new student(name,phone,city);
        		 boolean ans = studentDao.insertToDB(st);
        		 
        		 if(ans) {
        			 System.out.println("Student is added succesfully...");
        		 }else {
        			 System.out.println("something went wrong try again...");
        		 }
        		 
        	 }else if(c==2) {
        		 //delete student
        		 System.out.println("Enter Student ID to delete from table");
        		 int sid = Integer.parseInt(br.readLine());
        		 student st1 = new student(sid);
                 boolean ans = studentDao.deleteFromDB(st1);
        		 
        		     if(ans) {
        			      System.out.println("Student is deleted succesfully...");
        		     }else {
        			      System.out.println("something went wrong try again...");
        		     }
        	 }else if(c==3) {
        		 //display student
        		 System.out.println("Enter Student ID to display details from table");
        		 int sid = Integer.parseInt(br.readLine());
        		 student st2 = new student(sid);
        		 boolean ans = studentDao.displayDetails(st2);

        		    if(ans) {
   			            System.out.println("Student is displayed succesfully...");
   		            }else {
   			            System.out.println("something went wrong try again...");
   		            }     
        		 
        	 }else if(c==4){
        		 //break
        		 break;
        	 }else {
        		 
        	 }
         }
         System.out.println("Thankyou for using the App");
         System.out.println("see you soon");
	}

}
