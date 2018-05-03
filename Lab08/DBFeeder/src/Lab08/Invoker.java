package Lab08;
import java.sql.SQLException;
public class Invoker {	
	public static void main(String[] args) throws SQLException{
		boolean check;
        DBManipulator test = new DBManipulator();  
    	System.out.println(">No. of Data Rows: 5000");
        for(int i=0; i<2; i++) {
        	if(i==1)
    	        check = true;
    		else
    	        check = false;
        	System.out.println("\n\n\t\t>>Auto Commit set to '"+ check+"'<<");
        	
        	//Statement
    		System.out.print(">>Statement Class:");
    		System.out.println("\t\t"+ test.statementClass(check) +" milliseconds");
    		
    		//Prepared
    		test.truncateTable();
    		System.out.print(">>Prepared Statement Class:");
            try {
        		System.out.println("\t"+ test.preparedStatementClass(check) +" milliseconds");
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		//Batch
    			//statement
    		test.truncateTable();
    		System.out.print(">>Batch Update (Statement): ");
            try {
        		System.out.println("\t"+ test.batchUpdateNPrepared(check) +" milliseconds");
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    			//Prepared
    		test.truncateTable();
    		System.out.print(">>Batch Update (Prepared): ");
            try {
        		System.out.println("\t"+ test.batchUpdatePrepared(check) +" milliseconds");
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    		//STORED
    		test.truncateTable();
    		System.out.print(">>Stored  Procedure: ");
            try {
        		System.out.println("\t\t"+ test.stored(check) +" milliseconds");
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }	
	}
}