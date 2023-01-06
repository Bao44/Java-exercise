package truongQuocBao.bai07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class SoftwareHouse {
	private String theName;
	private ArrayList<Employee_07> list;
	
	public SoftwareHouse(String aName) {
		this.theName = aName;
		this.list = new ArrayList<Employee_07>();
	}
	public SoftwareHouse() {
		this.list = new ArrayList<Employee_07>();
	}
	
	public boolean addEmployee(Employee_07 emp) {
		for (Employee_07 employee_07 : list) {
			if(employee_07.getThePayrollNumber() == emp.getThePayrollNumber())
				return false;
		}
		list.add(emp);
		return true;
	}
	
	public String displayAllStaff() {
		String s = String.format("%-10s%-20s%-20s%-15s%-20s%-20s\n",
				"Mã số","Tên nhân viên","Lương cơ bản","Ngôn ngữ","Lương hàng tháng","Phòng ban");
		for (Employee_07 employee_07 : list) {
			s+= employee_07 + "\n";
		}
		return s;
	}
	
	public double getMonthlySalaryBill() {
		double sum = 0;
		for (Employee_07 employee_07 : list) {
			sum+= employee_07.getMonthlySalary();
		}
		return sum;
	}

	public void sortAllStaffByName() {
		Collections.sort(list, new Comparator<Employee_07>() {
			@Override
			public int compare(Employee_07 o1, Employee_07 o2) {
				return o1.getTheName().compareToIgnoreCase(o2.getTheName());
			}
		});
	}
	
	public String displayListProgrammers() {
		String s = String.format("%-10s%-20s%-20s%-15s%-20s\n",
				"Mã số","Tên nhân viên","Lương cơ bản","Ngôn ngữ","Lương hàng tháng");
		for (Employee_07 employee_07 : list) {
			if(employee_07 instanceof Programmer)
				s+=employee_07.toString() + "\n";
		}
		return s;
	}
	
	@Override
	public String toString() {
		String s = String.format("%-10s%-20s%-20s%-15s%-20s%-20s\n",
				"Mã số","Tên nhân viên","Lương cơ bản","Ngôn ngữ","Lương hàng tháng","Phòng ban");
		for (Employee_07 employee_07 : list) {
			s+= employee_07 + "\n";
		}
		return s;
	}
	
	public boolean updateDepartmentForAdmin(int aPayrollNo, String deptNew) {
		for (Employee_07 employee_07 : list) {
			if(employee_07 instanceof Administrator) {
				if(employee_07.getThePayrollNumber() == aPayrollNo) {
					((Administrator) employee_07).setTheDepartment(deptNew);
					return true;
				}
			}
		}
		return false;
	}
	
	public Employee_07 timKiem(int id) {
		for (Employee_07 employee_07 : list) {
			if(employee_07.getThePayrollNumber() == id)
				return employee_07;
		}
		return null;
	}
	
	public boolean deleteEmployee(int id) {
		Employee_07 emp = timKiem(id);
		if(emp != null) {
			list.remove(emp);
			return true;
		}
		return false;
	}
}
