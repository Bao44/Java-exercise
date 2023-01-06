package truongQuocBao.bai07;

import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int luaChon = 0;
		SoftwareHouse s = new SoftwareHouse("A");
		do {
			menu();
			luaChon = sc.nextInt();
			if(luaChon == 1) {
				s.addEmployee(new Programmer(1, "An", 100, "java"));
				s.addEmployee(new Programmer(2, "Vy", 100, "python"));
				s.addEmployee(new ProjectLeader(3, "Hoa", 100, "JAVA"));
				s.addEmployee(new ProjectLeader(4, "Duy", 100, "C++"));
				s.addEmployee(new Administrator(5, "Bao", 1000, "Apple"));
				s.addEmployee(new Administrator(2, "Minh", 1000, "IT"));
				System.out.println("Thêm thành công");
			}
			else if(luaChon == 2)
				System.out.println(s.displayAllStaff());
			else if(luaChon == 3) {
				System.out.println("Tổng tiền phải trả cho nhân viên là: " + s.getMonthlySalaryBill());
			}
			else if(luaChon == 4) {
				s.sortAllStaffByName();
				System.out.println("Sắp xếp thành công.\nDanh sách sau khi sắp xếp: ");
				System.out.println(s);
			}
			else if(luaChon == 5) {
				System.out.println(s.displayListProgrammers());
			}
			else if(luaChon == 6) {
				System.out.println("Nhập phòng ban: ");
				String deptNew = sc.next();
				System.out.println("Nhập mã số cần cập nhật: ");
				int aPayrollNo = sc.nextInt();
				if(s.updateDepartmentForAdmin(aPayrollNo, deptNew))
					System.out.println("Cập nhật thành công");
				else
					System.out.println("Cập nhật không thành công");
				
			}
			else if(luaChon == 7) {
				System.out.println("Nhập mã số cần xóa: ");
				int number = sc.nextInt();
				if(s.deleteEmployee(number)) {
					System.out.println("Xóa thành công");
				}
				else
					System.out.println("Xóa không thành công");
			}
			else
				break;
		}while(luaChon != 0);
		
	}
	
	public static void menu() {
		System.out.println("1. Thêm 1 nhân viên.\n"
						+ "2. Lấy thông tin toàn bộ nhân viên.\n"
						+ "3. Tính tổng tiền phải trả cho các nhân viên.\n"
						+ "4. Sắp xếp danh sách nhân viên theo tên.\n"
						+ "5. Thông tin các lập trình viên.\n"
						+ "6. Cập nhật phòng ban.\n"
						+ "7. Xóa nhân viên theo mã số.\n"
						+ "8. Chọn 0 để thoát.");
	}
}	
