import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class ReportsDAO_JDBC implements ReportsDAO {
																																																																																																																																																																																																																																															Connection dbConnection;

	public ReportsDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}


	@Override
	public ArrayList<Reports> getReportByPatientID(int patientID) {
		//Bills b = new Bills();
		ArrayList<Reports> reports = new ArrayList<Reports>();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "select p.name, r.rep_id, r.pat_id, r.doc_id, r.report from patient p, reports r where p.pat_id = r.pat_id";
			ResultSet rs = stmt.executeQuery(sql);
			int c = 0;

			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column key
					String patName = rs.getString("p.name");
					int repID  = rs.getInt("r.rep_id");
					int patID = rs.getInt("r.pat_id");
					int docID = rs.getInt("r.doc_id");
					String rep = rs.getString("r.report");
				if(patientID == patID){
					Reports r = new Reports();
					r.setReportID(repID);
					r.setPatientID(patID);
					r.setPatientName(patName);
					r.setDoctorID(docID);
					r.setReport(rep);
					reports.add(r);
					c++;
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
		return reports;
	}
	
	@Override
	public ArrayList<Reports> getReportByPatientName(String patientName) {
//		Bills b = new Bills();
		ArrayList<Reports> reports = new ArrayList<Reports>();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "select p.name, r.rep_id, r.pat_id, r.doc_id, r.report from patient p, reports r where p.pat_id = r.pat_id";
			ResultSet rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				try{
					String patName = rs.getString("p.name");
					int repID  = rs.getInt("r.rep_id");
					int patID = rs.getInt("r.pat_id");
					int docID = rs.getInt("r.doc_id");
					String rep = rs.getString("r.report");
					if (patientName.equals(patName)) {
						Reports r = new Reports();
						r.setReportID(repID);
						r.setPatientID(patID);
						r.setPatientName(patName);
						r.setDoctorID(docID);
						r.setReport(rep);
						reports.add(r);
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
		return reports;
	}
//	@Override
//	public Reports getReportByPatientID(int patientID) {
//		Reports r = new Reports();
//		String sql;
//		Statement stmt = null;

//		try{
//			stmt = dbConnection.createStatement();
//			sql = "select rep_id, pat_id, doc_id, report from reports"; 
//			ResultSet rs = stmt.executeQuery(sql);

//			//STEP 5: Extract data from result set
//			while(rs.next()){
//				//Retrieve by column name
//				int repID  = rs.getInt("rep_id");
//				int patID = rs.getInt("pat_id");
//				int docID = rs.getInt("doc_id");
//				String rep = rs.getString("report");
//				if (patientID == patID) {
//					r.setReportID(repID);
//					r.setPatientID(patID);
//					r.setDoctorID(docID);
//					r.setReport(rep);
//					break;
//				}
//				// Add exception handling here if more than one row is returned
//			}
//		} catch (SQLException ex) {
//		    // handle any errors
//		    System.out.println("SQLException: " + ex.getMessage());
//		    System.out.println("SQLState: " + ex.getSQLState());
//		    System.out.println("VendorError: " + ex.getErrorCode());
//		}
//		// Add exception handling when there is no matching record
//		return r;
//	}
//	@Override
//	public Reports getReportByPatientName(String patientName) {
//		Reports r = new Reports();
//		String sql;
//		Statement stmt = null;

//		try{
//			stmt = dbConnection.createStatement();
//			sql = "select p.name, r.rep_id, r.pat_id, r.doc_id, r.report from patient p, reports r where p.pat_id = r.pat_id";
//			ResultSet rs = stmt.executeQuery(sql);

//			//STEP 5: Extract data from result set
//			while(rs.next()){
//				//Retrieve by column name
//				String patName = rs.getString("p.name");
//				int repID  = rs.getInt("r.rep_id");
//				int patID = rs.getInt("r.pat_id");
//				int docID = rs.getInt("r.doc_id");
//				String rep = rs.getString("r.report");
//				if (patientName.equals(patName)) {
//					r.setReportID(repID);
//					r.setPatientID(patID);
//					r.setDoctorID(docID);
//					r.setReport(rep);
//					break;
//				}
//				// Add exception handling here if more than one row is returned
//			}
//		} catch (SQLException ex) {
//		    // handle any errors
//		    System.out.println("SQLException: " + ex.getMessage());
//		    System.out.println("SQLState: " + ex.getSQLState());
//		    System.out.println("VendorError: " + ex.getErrorCode());
//		}
//		// Add exception handling when there is no matching record
//		return r;
//	}

	// @Override
	// public void addBill(Reports report) {
	// 	PreparedStatement preparedStatement = null;
	// 	String sql;
	// 	sql = "insert into reports(reports, patientID, doctorID) values (?, ?, ?)";
	//
	// 	try {
	// 		preparedStatement = dbConnection.prepareStatement(sql);
	//
	// 		preparedStatement.setInt(1, report.getBillno());
	// 		preparedStatement.setInt(2, report.getPatientID());
	// 		preparedStatement.setInt(3, report.getAmount());
	// 		preparedStatement.setString(4, report.getDate());
	//
	// 		// execute insert SQL stetement
	// 		preparedStatement.executeUpdate();
	//
	// 		System.out.println("Report: Report No " + report.getReportNo()
	// 			+ ", added to the database");
	// 	} catch (SQLException e) {
 	// 		System.out.println(e.getMessage());
 	// 	}
	//
	// 	try{
	// 		if (preparedStatement != null) {
	// 			preparedStatement.close();
	// 		}
	// 	} catch (SQLException e) {
 	// 		System.out.println(e.getMessage());
 	// 	}
	// }
}
