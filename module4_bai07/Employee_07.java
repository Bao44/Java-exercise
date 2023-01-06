package truongQuocBao.bai07;

import java.text.DecimalFormat;

public abstract class Employee_07 {
	private int thePayrollNumber ;
	private String theName;
	private double theBasicMonthlySalary;
	public Employee_07(int thePayrollNumber, String theName, double theBasicMonthlySalary) {
		this.setThePayrollNumber(thePayrollNumber);
		this.setTheName(theName);
		this.setTheBasicMonthlySalary(theBasicMonthlySalary);
	}
	public Employee_07() {
		this(0, "Null", 1);
	}
	public int getThePayrollNumber() {
		return thePayrollNumber;
	}
	public void setThePayrollNumber(int thePayrollNumber) {
		if(thePayrollNumber > 0)
			this.thePayrollNumber = thePayrollNumber;
		else
			thePayrollNumber = 0;
	}
	public String getTheName() {
		return theName;
	}
	public void setTheName(String theName) {
		if(!theName.equals(""))
			this.theName = theName;
		else
			this.theName = "Null";
	}
	public double getTheBasicMonthlySalary() {
		return theBasicMonthlySalary;
	}
	public void setTheBasicMonthlySalary(double theBasicMonthlySalary) {
		if(theBasicMonthlySalary > 0)
			this.theBasicMonthlySalary = theBasicMonthlySalary;
		else
			this.theBasicMonthlySalary = 1;
	}
	
	public abstract double getMonthlySalary();
	
	@Override
	public String toString() {
		DecimalFormat dcm = new DecimalFormat("#.000$");
		String monney = dcm.format(theBasicMonthlySalary);
		return String.format("%-10d%-20s%-20s",thePayrollNumber,theName,monney);
	}
}
