package truongQuocBao.bai06;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListPhongHoc list = new ListPhongHoc();
		
		int luaChon = 0;
		do {
			menu();
			System.out.println("Nhập lựa chọn của bạn: "); luaChon = sc.nextInt();
			if(luaChon==1) {
				if(them(list)) {
					System.out.println("Them thanh cong!");
				}
				else
					System.out.println("Them khong thanh cong");
			}
			else if(luaChon==2) {
				System.out.println("Nhập mã phòng cần tìm: "); String mp = sc.next();
				PhongHoc ph = list.timKiemPH(mp);
				if(ph != null) {
					System.out.println("Tìm thấy\n");
					System.out.println(list.timKiemPH(mp));
				}
				else
					System.out.println("Không tìm thấy mã phòng.\n");
			}
			else if(luaChon==3) {
				System.out.println(list);
			}
			else if(luaChon==4) {
				System.out.println("Danh sách phòng học đạt chuẩn: ");
				System.out.println(list.pHDatChuan());
			}
			else if(luaChon==5) {
				System.out.println("Sắp xếp tăng dần theo dãy nhà: \n");
				list.sapXepTheoDayNha();
				System.out.println("Sắp xếp thành công");
			}
			else if(luaChon==6) {
				System.out.println("Sắp xếp giảm dần theo diện tích: \n");
				list.sapXepTheoDienTich();
				System.out.println("Sắp xếp thành công");
			}
			else if(luaChon==7) {
				System.out.println("Sắp xếp tăng dần theo số bóng đèn: \n");
				list.sapXepTheoSoBD();
				System.out.println("Sắp xếp thành công");
			}
			else if(luaChon==8) {
				System.out.print("Nhập mã phòng cần cập nhật: ");
				String ma = sc.next();
				System.out.println("Nhập số máy tính cần cập nhật: ");
				int soMT = sc.nextInt();
				if(list.capNhatSoMT(ma, soMT)) {
					System.out.println("Cập nhật thành công");
				}
				else
					System.out.println("Cập nhật không thành công");
			}
			else if(luaChon==9) {
				System.out.println("Nhap ma muon xoa: ");
				String r = sc.next();
				if(list.timKiemPH(r)!=null) {
					System.out.println("Ban chac chan muon xoa khong, nhap y de xoa n de out.");
					String t = sc.next();
					if(t.equalsIgnoreCase("y") ) {
						list.xoa(r);
						System.out.println("Ban chap nhan xoa. Xoa thanh cong");
						System.out.println("Danh sach sau khi xoa:");
						System.out.println(list);
					}	
					else
						System.out.println("Ban khong chap nhan xoa.");
				}
				else
					System.out.println("Khong tim thay ma de xoa.");
			}
			else if(luaChon == 10) {
				System.out.println("Tổng số phòng học: ");
				System.out.println(list.tongSoPH());
			}
			else if(luaChon == 11) {
				System.out.println("Danh sách các phòng máy có 60 máy: ");
				System.out.println(list.danhSachPHMT());
			}
			else
				break;
		} while (luaChon!=0);
	}
	
	public static void menu() {
		System.out.println("******************************************\n"
				+"1. Thêm một phòng học vào danh sách\n"
				+"2. Tìm kiếm một phòng học nào đó khi biết mã phòng\n"
				+"3. Lấy thông tin toàn bộ danh sách các phòng học\n"
				+"4. Lấy danh sách các phòng học đạt chuẩn\n"
				+"5. Sắp xếp danh sách tăng dần theo dãy nhà\n"
				+"6. Sắp xếp danh sách giảm dần theo diện tích\n"
				+"7. Sắp xếp danh sách tăng dần theo số bóng đèn.\n"
				+"8. Cập nhật số máy tính cho một phòng máy tính nào đó khi biết mã phòng\n"
				+"9. Xóa một phòng học nào đó khi biết mã phòng\n"
				+"10. Tính tổng số phòng học\n"
				+"11. Lấy danh sách các phòng máy có 60 máy"
				+"12. Nhập 0 để thoát.\n"
				+"*******************************************\n");
	}
	
	public static boolean them(ListPhongHoc list) {
		list.add(new PhongLyThuyet("A", "A", 100, 15, true));
		list.add(new PhongMayTinh("C", "C", 150, 10, 60));
		list.add(new PhongMayTinh("CC", "CC", 150, 10, 60));
		list.add(new PhongThiNghiem("B", "B", 130, 5, "IT", 80, true));
		list.add(new PhongThiNghiem("A", "D", 130, 5, "IT", 80, true));
		list.add(new PhongMayTinh("C", "e", 150, 10, 50));
		list.add(new PhongMayTinh("B", "f", 150, 10, 60));
		return true;
	}
}
