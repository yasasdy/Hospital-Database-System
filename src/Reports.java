import java.lang.*;

public class Reports
{
	int reportID;
	int patientID;
	int doctorID;
	int receptionID;
	String rep;
	String patientName;
	public Reports() {}
	public Reports(int repID, int patID, int docID, int recID)
	{
		reportID = repID;
		patientID = patID;
		doctorID = docID;
		receptionID = recID;
	}
	public void setReportID(int repID)
	{
		reportID = repID;
	}
	public int getReportID()
	{
		return reportID;
	}
	public void setPatientID(int patID)
	{
		patientID = patID;
	}
	public int getPatientID()
	{
		return patientID;
	}
	public void setDoctorID(int docID)
	{
		doctorID = docID;
	}
	public int getDoctorID()
	{
		return doctorID;
	}
	public void setRecID(int recID)
	{
		receptionID = recID;
	}
	public int getRecID()
	{
		return receptionID;
	}	
	public void setReport(String r)
	{
		rep = r;
	}
	public String getReport()
	{
		return rep;
	}
	public void setPatientName(String patName)
	{
		patientName = patName;
	}
	public String getPatientName()
	{
		return patientName;
	}
	public void print()
	{
		if (reportID == 0 && patientID == 0) {
			System.out.println("No record of Reports to display for the patient.");
		}
		else{
			System.out.println("ReportID = " + reportID);
			System.out.println("PatientID = " + patientID);
			System.out.println("PatientID = " + patientName);
			System.out.println("DoctorID = " + doctorID);
			System.out.println("Report = " + rep);
		}
	}
};
