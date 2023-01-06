package truongQuocBao.bai07;

import java.text.DecimalFormat;

public class ProjectLeader extends Programmer{

	public ProjectLeader(int thePayrollNumber, String theName, double theBasicMonthlySalary, String theLanguage) {
		super(thePayrollNumber, theName, theBasicMonthlySalary, theLanguage);
	}
	public double phuCap() {
		if(getTheLanguage().equalsIgnoreCase("Java"))
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
		return String.format("%s", super.toString());
	}
	
}
