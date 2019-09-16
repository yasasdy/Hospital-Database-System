import java.lang.*;
import java.util.List;
import java.util.ArrayList;

public interface ReportsDAO{
	public ArrayList<Reports> getReportByPatientID(int patientID);
	public ArrayList<Reports> getReportByPatientName(String patientName);
}
