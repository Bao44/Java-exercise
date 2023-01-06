package truongQuocBao.bai06;

import java.util.Arrays;

public class DanhSachHangHoa {
	private HangHoa[] hangHoa;
	private int count;
	
	public DanhSachHangHoa(int n) {
		hangHoa = new HangHoa[n];
	}
	
	public boolean them(HangHoa hh) {
		for(int i=0;i<count;i++) {
			if(hangHoa[i].getMaHang().equals(hh.getMaHang()))
				return false;
		}
		if(count >= hangHoa.length)
			return false;
		hangHoa[count++] = hh;
		return true;
	}
	@Override
	public String toString() {
		String s = String.format("%-10s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n"
				,"Ma hang","Ten hang","Don gia","So luong","Nha cung cap","Ngay Sx","Ngay het han"
						, "Thoi gian BH","Cong suat","Nha SX","Ngay NK");
		for(int i=0;i<count;i++) {
			s+=hangHoa[i] + "\n";
		}
		return s;
	}
	
	public DanhSachHangHoa getThongTinHTP() {
		DanhSachHangHoa ds = new DanhSachHangHoa(count);
		for (HangHoa hangHoa2 : hangHoa) {
			if(hangHoa2 instanceof HangThucPham)
				ds.them(hangHoa2);
		}
		return ds;
	}
	public DanhSachHangHoa getThongTinHDM() {
		DanhSachHangHoa ds = new DanhSachHangHoa(count);
		for (HangHoa hangHoa2 : hangHoa) {
			if(hangHoa2 instanceof HangDienMay)
				ds.them(hangHoa2);
		}
		return ds;
	}
	public DanhSachHangHoa getThongTinHSS() {
		DanhSachHangHoa ds = new DanhSachHangHoa(count);
		for (HangHoa hangHoa2 : hangHoa) {
			if(hangHoa2 instanceof HangSanhSu)
				ds.them(hangHoa2);
		}
		return ds;
	}
	
	public HangHoa timKiem(String ma) {
		for(int i=0;i<count;i++) {
			if(hangHoa[i].getMaHang().equals(ma)) {
				return hangHoa[i];
			}
		}
		return null;
	}
	
	public int timKiemViTri(String ma) {
		for(int i=0;i<count;i++) {
			if(hangHoa[i].getMaHang().equals(ma)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean xoa(String ma) {
		int vt = timKiemViTri(ma);
		if(vt == -1)
			return false;
		for(int i=vt;i<count-1;i++) {
			hangHoa[i] = hangHoa[i+1];
		}
		count--;
		return true;
	}
	
	public void sapXepTheoSLTon() {
		HangHoa temp;
		for(int i=0;i<count-1;i++) {
			for(int j=i+1;j<count;j++) {
				if(hangHoa[i].getSoLuongTon() < hangHoa[j].getSoLuongTon()) {
					temp = hangHoa[i];
					hangHoa[i] = hangHoa[j];
					hangHoa[j] = temp;
				}
			}
		}
	}
	
	public void sapXepTheoTenHangHoa() {
		HangHoa temp;
		for(int i=0;i<count-1;i++) {
			for(int j=i+1;j<count;j++) {
				if(hangHoa[i].getTenHang().compareTo(hangHoa[j].getTenHang()) > 0) {
					temp = hangHoa[i];
					hangHoa[i] = hangHoa[j];
					hangHoa[j] = temp;
				}
			}
		}
	}
	
	public DanhSachHangHoa getThongTinHTPKhoBan() {
		DanhSachHangHoa ds = new DanhSachHangHoa(count);
		for (HangHoa hangHoa2 : hangHoa) {
			if(hangHoa2 instanceof HangThucPham) {
				if(hangHoa2.danhGia().equalsIgnoreCase("Kho ban"))
					ds.them(hangHoa2);
			}
		}
		return ds;
	}
}
