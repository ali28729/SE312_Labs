import java.sql.*;
import java.util.*;

public class JDBC {
   // Driver and DB paths
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/university";

   // DB credentials
   static final String USER = "root";
   static final String PASS = "";
   static Connection conn = null;
   static Statement stmt = null;
   
   public static void UI(){
	   System.out.println(">> Connection secured!");
	   System.out.println("\n\t\t>>Welocme to the student DB!<<\n");
	   System.out.println("• Choose any of the mentioned options:");
	   System.out.println("- Enter 1 to display all records.");
	   System.out.println("- Enter 2 to delete a record.");
	   System.out.println("- Enter 3 to search for a student by name.");
	   System.out.println("____________________________________________");
	   System.out.print("Enter Your Choice:");    
   }
   
   public static void dispall(){
		try{
		// Registration and connection
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt = conn.createStatement();
		ResultSet rs;
		rs = stmt.executeQuery("SELECT ID,Name,RegNo,Class,Section,Contact,Address FROM student");
		System.out.println("ID\t"+"Name\t\t"+"Reg#\t"+"Class\t"+"Contact\t\t"+"Address\t");
		while ( rs.next() ) {
		    String id = rs.getString("ID");
			String name = rs.getString("Name");
			String reg = rs.getString("RegNo");
			String classy = rs.getString("Class");
			String contact = rs.getString("Contact");
			String addr = rs.getString("Address");
			System.out.println(id+"\t"+name+"\t"+reg+"\t"+classy+"\t"+contact+"\t"+addr);
		}}
		catch(SQLException se){
       //Handle errors for JDBC
		}
		catch(Exception e){
       //Handle errors for Class.forName
		}
		finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }
	      catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }
	      catch(SQLException se){
	      }//end finally try
		}//end try
   }
   
   public static void del(){
   try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      Statement stmt = conn.createStatement();
            ResultSet rs;
            System.out.println("Enter ID of student you want to delete:");
            Scanner input =new Scanner(System.in);
            String id = input.nextLine();{
                stmt.executeUpdate("DELETE FROM student WHERE ID="+Integer.parseInt(id));
                System.out.println("User with ID "+id+" deleted!");
            }        
   }catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try   
   }
   
   public static void disp()
   {
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      Statement stmt = conn.createStatement();
            ResultSet rs;
            System.out.println("Enter the name of the Student:");
            Scanner input =new Scanner(System.in);
            String us = input.nextLine();
            rs = stmt.executeQuery("SELECT * FROM student WHERE Name LIKE "+"'%"+us+"%'");
        	System.out.println("ID\t"+"Name\t\t"+"Reg#\t"+"Class\t"+"Contact\t\t"+"Address\t");
            while ( rs.next() ) {
                String id = rs.getString("ID");
                String name = rs.getString("Name");
                String reg = rs.getString("RegNo");
                String classy = rs.getString("Class");
                String contact = rs.getString("Contact");
                String addr = rs.getString("Address");
        		System.out.println(id+"\t"+name+"\t"+reg+"\t"+classy+"\t"+contact+"\t"+addr);
            }     
   }catch(SQLException se){
       //Handle errors for JDBC

   }catch(Exception e){
       //Handle errors for Class.forName

   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
   }
   
   public static void main(String[] args) { 
	   UI();
	   Scanner input =new Scanner(System.in);
	   String selection = input.nextLine();
	   switch(Integer.parseInt(selection)){
	       case 1:
	       dispall();
	       break;
	       case 2:
	       del();
	       break;
	       case 3:
	       disp();
	       break;
	       default:
	       System.out.println("Invalid Selection!");   
	   } 
	}
}
