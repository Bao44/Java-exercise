package truongQuocBao.bai07;

import java.text.DecimalFormat;

public class Administrator extends Employee_07 {
	private String theDepartment;

	public Administrator(int thePayrollNumber, String theName, double theBasicMonthlySalary, String theDepartment) {
		super(thePayrollNumber, theName, theBasicMonthlySalary);
		this.setTheDepartment(theDepartment);
	}

	public String getTheDepartment() {
		return theDepartment;
	}

	public void setTheDepartment(String theDepartment) {
		if(!theDepartment.equals(""))
			this.theDepartment = theDepartment;
		else
			this.theDepartment = "Null";
	}

	@Override
	public double getMonthlySalary() {
		return getTheBasicMonthlySalary()+(getTheBasicMonthlySalary()*0.4);
	}
	@Override
	public String toString() {
		DecimalFormat dcm = new DecimalFormat("#.000$");
		String monney = dcm.format(getMonthlySalary());
		return String.format("%s%-15s%-20s%-15s", super.toString(),"-",monney,theDepartment);
	}
	
}
