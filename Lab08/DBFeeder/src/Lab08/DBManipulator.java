package Lab08;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class DBManipulator{
	private Connection con;
	private Statement standQuery;
    private CallableStatement callQuery = null;

	private int ins;
	public DBManipulator() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","");
		}
		catch(Exception ex){
			System.out.println("Error: "+ex);
		}
	}
	
	public long stored(boolean check) throws SQLException {
		if(check==true)
	        con.setAutoCommit(true);
		else
			con.setAutoCommit(false);
		
        long startTime = System.currentTimeMillis();
        Random randReg = new Random();	
		try {
			String SQL = "{call user_proc (?, ?,?,?)}";
	        callQuery = con.prepareCall (SQL);
	        for(int i = 1; i <= 5000;i++){
	           	callQuery.setString(1, "blob");
	        	callQuery.setInt(2, randReg.nextInt(99999) + 100000);
	        	callQuery.setInt(3, 6);
	        	callQuery.setString(4, "Islamabad");
	        	callQuery.executeUpdate();
	        }
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		if(check == false)
			con.commit();
        long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
	public long statementClass(boolean check) throws SQLException {
		if(check==true)
	        con.setAutoCommit(true);
		else
			con.setAutoCommit(false);
		standQuery = con.createStatement();
        long startTime = System.currentTimeMillis();
		String name = "";
		int regNo;
		int semester = 6;
		String address = "Islamabad";
		Random randReg = new Random();
		try {
			for(int i=0; i<5000; i++){
				name = "blob";
				regNo = randReg.nextInt(99999) + 100000;
				String query = "INSERT INTO students (name, regNo, semester, address) VALUES ('"+name+"', '"+regNo+"', '"+semester+"', '"+address+"');";
				ins = standQuery.executeUpdate(query);
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		if(check == false)
			con.commit();
        long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	public long preparedStatementClass(boolean check) throws SQLException {
		if(check==true)
	        con.setAutoCommit(true);
		else
			con.setAutoCommit(false);
		standQuery = con.createStatement();
        long startTime = System.currentTimeMillis();
		int regNo;
		int semester = 6;
		String address = "Islamabad";
		Random randReg = new Random();
		PreparedStatement stmt=con.prepareStatement("INSERT INTO students (name, regNo, semester, address) VALUES(?,?,?,?)");  
		int count;
		try {
			for(int i=0; i<5000; i++){
				String name = "blob";	
				regNo = randReg.nextInt(99999) + 100000;	
				stmt.setString(1,name);
				stmt.setInt(2,regNo);
				stmt.setInt(3,semester);
				stmt.setString(4,address);		
				count=stmt.executeUpdate();  
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		if(check == false)
			con.commit();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
	}
	
	public long batchUpdatePrepared(boolean check) throws SQLException {
		if(check==true)
	        con.setAutoCommit(true);
		else
			con.setAutoCommit(false);
		standQuery = con.createStatement();
        long startTime = System.currentTimeMillis();
		String name = "blob";
		int regNo;
		int semester = 6;
		String address = "Islamabad";
		Random randReg = new Random();
		  	
		PreparedStatement stmt=con.prepareStatement("INSERT INTO students (name, regNo, semester, address) VALUES(?,?,?,?)"); 
        int[] count;
		try {
			for(int i=1; i<=5000; i++){
				if(i%1000==0)
					count = stmt.executeBatch();  
				regNo = randReg.nextInt(99999) + 100000;
				stmt.setString(1,name);
				stmt.setInt(2,regNo);
				stmt.setInt(3,semester);
				stmt.setString(4,address);
		        stmt.addBatch();
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		if(check == false)
			con.commit();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
	}
	
	public long batchUpdateNPrepared(boolean check) throws SQLException {
		if(check==true)
	        con.setAutoCommit(true);
		else
			con.setAutoCommit(false);
		standQuery = con.createStatement();
        long startTime = System.currentTimeMillis();
		String name = "blob";
		int regNo;
		int semester = 6;
		String address = "Islamabad";
		Random randReg = new Random();
		  	
		PreparedStatement stmt=con.prepareStatement("INSERT INTO students (name, regNo, semester, address) VALUES(?,?,?,?)"); 
	    int[] count;
		try {
			for(int i=0; i<5000; i++){
				regNo = randReg.nextInt(99999) + 100000;
				String query = "INSERT INTO students (name, regNo, semester, address) VALUES ('"+name+"', '"+regNo+"', '"+semester+"', '"+address+"');";
				ins = standQuery.executeUpdate(query);
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		if(check == false)
			con.commit();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
	}
	
	public void truncateTable() throws SQLException {	
		standQuery.executeUpdate("TRUNCATE students");
	}
}
