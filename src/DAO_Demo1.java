//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO_Demo1 {
	public static void main(String[] args) {
		int temp1 = 0, temp2 = 0, temp3 = 0;
		try{
			DAO_Factory daoFactory = new DAO_Factory();

			daoFactory.activateConnection();
			Scanner scan = new Scanner(System.in);
			while(true){
				System.out.println("======================================================================" );
				System.out.println("Press-1: To retrieve Bills");
				System.out.println("Press-2: To retrieve Medical Records");

				temp1 = scan.nextInt();
				System.out.println("-------------------------------------------" );
				
				if(temp1 == 1){
					BillsDAO bdao = daoFactory.getBillsDAO();
					System.out.println("Press-1: To retrieve by ID" );
					System.out.println("Press-2: To retrieve by Name" );
					temp2 = scan.nextInt();
					if(temp2 == 1){
						System.out.println("Enter your ID");
						int pat_id = scan.nextInt();
						ArrayList<Bills> bp = bdao.getBillByPatientID(pat_id);
						if(bp.size() == 0)
						{
							System.out.println("No Bills to show");
						}
						else
						{
							for(int i = 0; i < bp.size(); i++)
							{
								System.out.println("*********Bill: " + (i+1) +"***********");
								bp.get(i).print();
								System.out.println("......................");
							}
						}
					}
					else if(temp2 == 2){
						System.out.println("Enter your Name");
						String pat_name = scan.next();
						ArrayList<Bills> bp = bdao.getBillByPatientName(pat_name);
						if(bp.size() == 0)
						{
							System.out.println("No Bills to show");
						}
						else
						{
							for(int i = 0; i < bp.size(); i++)
							{
								System.out.println("*********Bill: " + (i+1) +"***********");
								bp.get(i).print();
								System.out.println("......................");
							}
						}					}
					else{
						System.out.println("Invalid input");					
					}
				}
				else if(temp1 == 2){
					ReportsDAO rdao = daoFactory.getReportsDAO();
					System.out.println("Press-1: To retrieve by ID" );
					System.out.println("Press-2: To retrieve by Name" );
					temp2 = scan.nextInt();
					if(temp2 == 1){
						System.out.println("Enter your ID");
						int pat_id = scan.nextInt();
						ArrayList<Reports> rp = rdao.getReportByPatientID(pat_id);
						if(rp.size() == 0)
						{
							System.out.println("No Reports to show");
						}
						else
						{
							for(int i = 0; i < rp.size(); i++)
							{
								System.out.println("*********Report: " + (i+1) +"***********");
								rp.get(i).print();
								System.out.println("......................");
							}
						}
					}
					else if(temp2 == 2){
						System.out.println("Enter your Name");
						String pat_name = scan.next();
						ArrayList<Reports> rp = rdao.getReportByPatientName(pat_name);
						if(rp.size() == 0)
						{
							System.out.println("No Reports to show");
						}
						else
						{
							for(int i = 0; i < rp.size(); i++)
							{
								System.out.println("*********Report: " + (i+1) +"***********");
								rp.get(i).print();
								System.out.println("......................");
							}
						}
					}
					else{
						System.out.println("Invalid input");
					}
				}
				else{
					System.out.println("Invalid input");
				}
				System.out.println("======================================================================" );
				System.out.println("Enter 1 to Continue");
				System.out.println("Enter 0 to Exit");
				temp3 = scan.nextInt();
				if(temp3 == 1){
					continue;
				}
				else{
					break; 
				}
			}
			daoFactory.deactivateConnection();
		}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
		}
	}
}
