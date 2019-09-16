import java.lang.*;

public class Bills{
	int billNo;
	int patientID;
	int amount;
	String date;
	String patientName;
	public Bills() {}
	public Bills(int bill, int patID, int amo, String dat){
		billNo = bill;
		patientID = patID;
		amount = amo;
		date = dat;
	}
	public void setBillNo(int bill){
		billNo = bill;
	}
	public int getBillNo(){
		return billNo;
	}
	public void setPatientID(int patID){
		patientID = patID;
	}
	public int getPatientID(){
		return patientID;
	}
	public void setAmount(int amo){
		amount = amo;
	}
	public int getAmount(){
		return amount;
	}
	public void setDate(String dat){
		date = dat;
	}
	public String getDate(){
		return date;
	}
	public void setPatientName(String patName){
		patientName = patName;
	}
	public String getPatientName(){
		return patientName;
	}
  	public void print(){
		if (billNo == 0 && patientID == 0) {
			System.out.println("No record of bills to display for the patient.");
		}
		else{
			System.out.println("Bill ID = " + billNo);
			System.out.println("Patient ID = " + patientID);
			System.out.println("Patient Name = " + patientName);
			System.out.println("Amount = " + amount);
			System.out.println("Date = " + date);
		 }
	}
};
