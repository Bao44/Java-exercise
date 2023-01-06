package truongQuocBao.bai06;

import java.time.LocalDate;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DanhSachHangHoa hh = new DanhSachHangHoa(100);
		ListHangHoa lhh = new ListHangHoa();
		int luaChon = 0;
		do {
			menu();
			System.out.println("Nhập lựa chọn của bạn: "); luaChon = sc.nextInt();
			if(luaChon==1) {
				if(them(lhh)) {
					System.out.println("Them thanh cong!");
				}
				else
					System.out.println("Them khong thanh cong");
			}
			else if(luaChon==2) {
				System.out.println(lhh.InDs());
				
			}
			else if(luaChon==3) {
				layThongTinTungLoai(lhh);
			}
			else if(luaChon==4) {
				System.out.println("Nhập mã hàng muốn tìm: ");
				String k = sc.next();
				if((timKiemHangHoa(k, lhh)))
					System.out.println(lhh.timKiemHH(k));
				else
					System.out.println("Không tìm thấy mã hàng.");
			}
			else if(luaChon==5) {
				lhh.sapXepTheoTen();
				System.out.println("Hang hoa sau khi sap xep theo ten: \n");
				lhh.InDs();
			}
			else if(luaChon==6) {
				lhh.sapXepTheoSLTon();
				System.out.println("Hang hoa sau khi sap xep theo ten: \n");
				lhh.InDs();
			}
			else if(luaChon==7) {
				layThongTinHTP_KB(lhh);
			}
			else if(luaChon==8) {
				System.out.print("Nhập mã hàng muốn xóa: ");
				String ma = sc.next();
				if(lhh.xoa(ma)) {
					System.out.println("Xóa thành công");
				}
				else
					System.out.println("Xóa không thành công");
			}
			else if(luaChon==9) {
				System.out.println("Nhập mã hàng muốn sửa đơn giá: ");
				String k = sc.next();
				if(lhh.timKiemHH(k)!=null) {
					System.out.println("Nhập đơn giá muốn sửa: ");
					double donGia = sc.nextDouble();
					if(lhh.sua(k, donGia))
						System.out.println("Sửa thành công!");
					else
						System.out.println("Sửa không thành công");
				}
				else
					System.out.println("Không tìm thấy mã cần sửa.");
			}
			else
				break;
		} while (luaChon!=0);
		
	}
	
	public static void menu() {
		System.out.println("******************************************\n"
							+"1. Thêm 1 hàng hóa\n"
							+"2. Lấy thông tin toàn bộ danh sách\n"
							+"3. Lấy thông tin từng loại\n"
							+"4. Tìm kiếm hàng hóa khi biết mã hàng\n"
							+"5. Sắp xếp hàng hóa theo tên hàng tăng dần\n"
							+"6. Sắp xếp hàng hóa theo số lượng tồn giảm dần\n"
							+"7. Lấy thông tin các hàng thực phẩm khó bán\n"
							+"8. Xóa hàng hóa khi biết mã hàng\n"
							+"9. Sửa thông tin đơn giá của hàng hóa khi biết mã hàng\n"
							+"10. Nhập 0 để thoát.\n"
							+"*******************************************\n");
	}

	public static boolean them(ListHangHoa hh) {
		hh.add(new HangThucPham("a", "a", 100, 201, "abc",LocalDate.of(2000, 1, 10), LocalDate.of(2023, 1, 1)));
		hh.add(new HangThucPham("b", "b", 100, 2, "abc",LocalDate.of(2020, 1, 10), LocalDate.of(2000, 1, 1)));
		hh.add(new HangDienMay("e", "e", 10, 2, 15, 150));
		hh.add(new HangDienMay("d", "d", 10, 2, 10, 150));
		hh.add(new HangSanhSu("e", "e", 60, 100, "ABC", LocalDate.of(2022, 10, 19)));
		hh.add(new HangSanhSu("a", "a", 60, 1030, "ABC", LocalDate.of(2000, 10, 19)));
		return true;
	}

	public static void layThongTinTungLoai(ListHangHoa hh) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		do {
			System.out.println("1. Lấy thông tin hàng thực phẩm\n"
							   +"2. Lấy thông tin hàng điện máy\n"
							   +"3. Lấy thông tin hàng sành sứ\n"
							   +"4. Nhập 0 để thoát.\n");
			System.out.println("Nhập lựa chọn của bạn: ");
			n = sc.nextInt();
			if(n==1) {
				System.out.println(hh.layThongTinHTP());
			}
			else if(n==2) {
				System.out.println(hh.layThongTinHDM());
			}
			else if(n==3) {
				System.out.println(hh.layThongTinHSS());
			}
			else
				break;
		} while (n!=0);
	}
	
	public static boolean timKiemHangHoa(String ma,ListHangHoa hh) {
		if(hh.timKiemHH(ma) == null) 
			return false;
		return true;
	}
	
	public static void layThongTinHTP_KB(ListHangHoa hh) {
		if(hh.layThongTinHangKhoBan()!=null)
			System.out.println(hh.layThongTinHangKhoBan());
		else
			System.out.println("Khong co");
	}
	
}
