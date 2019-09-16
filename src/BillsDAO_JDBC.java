import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class BillsDAO_JDBC implements BillsDAO {
																																																																																																																																																																																																																																															Connection dbConnection;

	public BillsDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}

	@Override
	public ArrayList<Bills> getBillByPatientID(int patientID) {
		//Bills b = new Bills();
		ArrayList<Bills> bills = new ArrayList<Bills>();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "select p.name, b.bil_id, b.pat_id, b.amount, b.bill_date from patient p, bills b where p.pat_id = b.pat_id";
			ResultSet rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
					String patName = rs.getString("p.name");
					int billno  = rs.getInt("b.bil_id");
					int patID = rs.getInt("b.pat_id");
					int amount = rs.getInt("b.amount");
					String date = rs.getString("b.bill_date");
				if(patientID == patID){
					Bills b = new Bills();
					b.setBillNo(billno);
					b.setPatientID(patID);
					b.setPatientName(patName);
					b.setAmount(amount);
					b.setDate(date);
					bills.add(b);
				}
				// Add exception handling here if more than one row is returned
			}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return bills;
	}
	
	@Override
	public ArrayList<Bills> getBillByPatientName(String patientName) {
//		Bills b = new Bills();
		ArrayList<Bills> bills = new ArrayList<Bills>();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "select p.name, b.bil_id, b.pat_id, b.amount, b.bill_date from patient p, bills b where p.pat_id = b.pat_id";
			ResultSet rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				try{
				
					String patName = rs.getString("p.name");
					int billno  = rs.getInt("b.bil_id");
					int patID = rs.getInt("b.pat_id");
					int amount = rs.getInt("b.amount");
					String date = rs.getString("b.bill_date");
					if (patientName.equals(patName)) {
						Bills b = new Bills();
						b.setBillNo(billno);
						b.setPatientID(patID);
						b.setPatientName(patName);
						b.setAmount(amount);
						b.setDate(date);
						bills.add(b);
					}
				 }
				 catch(Exception e){
				 	e.printStackTrace();
				 }
				// Add exception handling here if more than one row is returned
			}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return bills;
	}
}
