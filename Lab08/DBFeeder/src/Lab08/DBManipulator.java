package Lab08;
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
	private Statement cquery;
	private int ins;
	public DBManipulator() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","");
			cquery = con.createStatement();
		}
		catch(Exception ex)
		{
			System.out.println("Error: "+ex);
		}
	}
	
	public void statementClass(boolean flage) throws SQLException {
		String name = "";
		int regNo;
		int semester = 6;
		String address = "Islamabad";
		Random rand = new Random();
		
		if(flage==true)
	        con.setAutoCommit(true);
		else
			con.setAutoCommit(false);

		try {
			for(int i=0; i<5000; i++){
				name = generateName();
				regNo = rand.nextInt(99999) + 100000;
				String query = "INSERT INTO students (name, regNo, semester, address) VALUES ('"+name+"', '"+regNo+"', '"+semester+"', '"+address+"');";
				ins = cquery.executeUpdate(query);
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	public void preparedStatementClass(boolean flage) throws SQLException {
		String name = "";
		int regNo;
		int semester = 6;
		String address = "Islamabad";
		Random rand = new Random();
		PreparedStatement stmt=con.prepareStatement("INSERT INTO students (name, regNo, semester, address) VALUES(?,?,?,?)");  
		int count;
		if(flage==true)
	        con.setAutoCommit(true);
		else
			con.setAutoCommit(false);

		try {
			for(int i=0; i<5000; i++){
				name = generateName();	
				regNo = rand.nextInt(99999) + 100000;	
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
public void batchUpdate(boolean flage) throws SQLException {
		
		String name = "";
		int regNo;
		int semester = 6;
		String address = "Islamabad";
		Random rand = new Random();
		  	
		PreparedStatement stmt=con.prepareStatement("INSERT INTO students (name, regNo, semester, address) VALUES(?,?,?,?)"); 
		
		if(flage==true)
		{
	        con.setAutoCommit(true);

		}
		else
		{
			con.setAutoCommit(false);
		}
		
        int[] count;

		try {
			for(int i=1; i<=5000; i++)
			{
				if(i%1000==0)
				{
					count=stmt.executeBatch();  
				}
				
				name = generateName();
				regNo = rand.nextInt(99999) + 100000;
				
				stmt.setString(1,name);
				stmt.setInt(2,regNo);
				stmt.setInt(3,semester);
				stmt.setString(4,address);
		        stmt.addBatch(); // Add to Batch


//				System.out.println(count + " Inserted into Database Successfully");
			}


		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	public String generateName() {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
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
		
		cquery.executeUpdate("TRUNCATE students");
		System.out.println("-Student Table Truncated");
		  
	}
	
}
