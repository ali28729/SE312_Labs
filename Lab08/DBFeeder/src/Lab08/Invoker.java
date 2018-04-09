package Lab08;
import java.sql.SQLException;
public class Invoker {	
	public static void main(String[] args) throws SQLException{
		long startTime;
		long endTime;
		long duration;
		boolean check;
        DBManipulator insertRecord = new DBManipulator();  
    	System.out.println(">No. of Data Rows: 5000");
        for(int i=0; i<2; i++) {
        	if(i==1)
    	        check = true;
    		else
    	        check = false;
        	System.out.println("\n\n\t\t>>Commit set to '"+check+"'<<");
    		System.out.print(">>Statement Class:");
            startTime = System.currentTimeMillis();
            insertRecord.statementClass(check);
            endTime = System.currentTimeMillis();
            duration = (endTime - startTime);
    		System.out.println("\t\t"+ duration +" milliseconds");
    		insertRecord.truncateStudentTable();
    		System.out.print(">>Prepared Statement Class:");
            startTime = System.currentTimeMillis();
            try {
    			insertRecord.preparedStatementClass(check);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            endTime = System.currentTimeMillis();
            duration = (endTime - startTime);
    		System.out.println("\t"+ duration +" milliseconds");
    		insertRecord.truncateStudentTable();
    		System.out.print(">>Batch Update: ");
    		startTime = System.currentTimeMillis();
            try {
    			insertRecord.batchUpdate(check);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
    		System.out.println("\t\t"+ duration +" milliseconds");
        }	
	}
}