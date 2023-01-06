package truongQuocBao.bai07;

import java.text.DecimalFormat;

public class Programmer extends Employee_07 {
	private String theLanguage;
	
	public Programmer(int thePayrollNumber, String theName, double theBasicMonthlySalary, String theLanguage) {
		super(thePayrollNumber, theName, theBasicMonthlySalary);
		this.setTheLanguage(theLanguage);
	}

	public String getTheLanguage() {
		return theLanguage;
	}

	public void setTheLanguage(String theLanguage) {
		if(!theLanguage.equals(""))
			this.theLanguage = theLanguage;
		else
			this.theLanguage = "Null";
	}

	public double phuCap() {
		if(theLanguage.equalsIgnoreCase("Java"))
			return getTheBasicMonthlySalary()*0.2;
		return 0;
	}
	@Override
	public double getMonthlySalary() {
		return getTheBasicMonthlySalary()+phuCap();
	}

	@Override
	public String toString() {
		DecimalFormat dcm = new DecimalFormat("#.000$");
		String monney = dcm.format(getMonthlySalary());
		return String.format("%s%-15s%-15s", super.toString(),theLanguage,monney);
	}
	
}
