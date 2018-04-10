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
			standQuery = con.createStatement();
		}
		catch(Exception ex)
		{
			System.out.println("Error: "+ex);
		}
	}
	
	public void stored(boolean check) throws SQLException {
		Random randName = new Random();
		
		if(check==true)
	        con.setAutoCommit(true);
		else
			con.setAutoCommit(false);
       
		try {
			String SQL = "{call user_proc (?, ?,?,?)}";
	        callQuery = con.prepareCall (SQL);
	        for(int i = 1; i <= 5000;i++){
	           	callQuery.setString(1, generateName());
	        	callQuery.setInt(2, randName.nextInt(99999) + 100000);
	        	callQuery.setInt(3, 6);
	        	callQuery.setString(4, "Islamabad");
	        	callQuery.executeUpdate();
	        }
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	public void statementClass(boolean check) throws SQLException {
		String name = "";
		int regNo;
		int semester = 6;
		String address = "Islamabad";
		Random randName = new Random();
		
		if(check==true)
	        con.setAutoCommit(true);
		else
			con.setAutoCommit(false);

		try {
			for(int i=0; i<5000; i++){
				name = generateName();
				regNo = randName.nextInt(99999) + 100000;
				String query = "INSERT INTO students (name, regNo, semester, address) VALUES ('"+name+"', '"+regNo+"', '"+semester+"', '"+address+"');";
				ins = standQuery.executeUpdate(query);
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	public void preparedStatementClass(boolean check) throws SQLException {
		String name = "";
		int regNo;
		int semester = 6;
		String address = "Islamabad";
		Random randName = new Random();
		PreparedStatement stmt=con.prepareStatement("INSERT INTO students (name, regNo, semester, address) VALUES(?,?,?,?)");  
		int count;
		if(check==true)
	        con.setAutoCommit(true);
		else
			con.setAutoCommit(false);

		try {
			for(int i=0; i<5000; i++){
				name = generateName();	
				regNo = randName.nextInt(99999) + 100000;	
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
	}
	
	public void batchUpdatePrepared(boolean check) throws SQLException {
		
		String name = "";
		int regNo;
		int semester = 6;
		String address = "Islamabad";
		Random randName = new Random();
		  	
		PreparedStatement stmt=con.prepareStatement("INSERT INTO students (name, regNo, semester, address) VALUES(?,?,?,?)"); 
		
		if(check==true)
	        con.setAutoCommit(true);
		else
			con.setAutoCommit(false);
		
        int[] count;

		try {
			for(int i=1; i<=5000; i++){
				if(i%1000==0)
					count = stmt.executeBatch();  
				
				name = generateName();
				regNo = randName.nextInt(99999) + 100000;
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
	}
	
public void batchUpdateNPrepared(boolean check) throws SQLException {
		
		String name = "";
		int regNo;
		int semester = 6;
		String address = "Islamabad";
		Random randName = new Random();
		  	
		PreparedStatement stmt=con.prepareStatement("INSERT INTO students (name, regNo, semester, address) VALUES(?,?,?,?)"); 
		
		if(check==true)
	        con.setAutoCommit(true);
		else
			con.setAutoCommit(false);
		
        int[] count;

		try {
			for(int i=0; i<5000; i++){
				name = generateName();
				regNo = randName.nextInt(99999) + 100000;
				String query = "INSERT INTO students (name, regNo, semester, address) VALUES ('"+name+"', '"+regNo+"', '"+semester+"', '"+address+"');";
				ins = standQuery.executeUpdate(query);
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	public String generateName() {
		int leftLimit = 97;
	    int rightLimit = 122;
	    int targetStringLength = 5;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
//	    System.out.println(generatedString);
	    return generatedString;
	}
	public void truncateStudentTable() throws SQLException {
		
		standQuery.executeUpdate("TRUNCATE students");
		//System.out.println("-Student Table Truncated");  
	}
}
