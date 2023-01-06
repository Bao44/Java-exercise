package truongQuocBao.bai06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListHangHoa {
	private ArrayList<HangHoa> list;

	public ListHangHoa(ArrayList<HangHoa> list) {
		this.list = list;
	}

	public ListHangHoa() {
		this.list = new ArrayList<HangHoa>();
	}

	public boolean add(HangHoa hh) {
		for (HangHoa hangHoa : list) {
			if(hangHoa.getMaHang().equalsIgnoreCase(hh.getMaHang()))
				return false;
		}
		list.add(hh);
		return true;
	}
	
	public String InDs() {
		String s = String.format("%-10s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n"
				,"Ma hang","Ten hang","Don gia","So luong","Nha cung cap","Ngay Sx","Ngay het han"
						, "Thoi gian BH","Cong suat","Nha SX","Ngay NK");
		for (HangHoa hangHoa : list) {
			s+=hangHoa + "\n";
		}
		return s;
	}
	
	public String layThongTinHTP() {
		String s="";
		for (HangHoa hangHoa : list) {
			if(hangHoa instanceof HangThucPham)
				s+=hangHoa.toString() +"\n";
		}
		return s;
	}
	public String layThongTinHDM() {
		String s="";
		for (HangHoa hangHoa : list) {
			if(hangHoa instanceof HangDienMay)
				s+=hangHoa.toString() +"\n";
		}
		return s;
	}
	public String layThongTinHSS() {
		String s="";
		for (HangHoa hangHoa : list) {
			if(hangHoa instanceof HangSanhSu)
				s+=hangHoa.toString() +"\n";
		}
		return s;
	}
	
	public HangHoa timKiemHH(String ma) {
		for (HangHoa hangHoa : list) {
			if(hangHoa.getMaHang().equals(ma))
				return hangHoa;
		}
		return null;
	}
	
	public void sapXepTheoTen() {
		Collections.sort(list, new Comparator<HangHoa>(){
			@Override
			public int compare(HangHoa hh1, HangHoa hh2) {
				return hh1.getTenHang().compareToIgnoreCase(hh2.getTenHang());
			}
		});
	}
	
	public void sapXepTheoSLTon() {
		Collections.sort(list, new Comparator<HangHoa>() {

			@Override
			public int compare(HangHoa hh1, HangHoa hh2) {
				Integer h1 = hh1.getSoLuongTon();
				Integer h2 = hh2.getSoLuongTon();
				return h2.compareTo(h1);
			}
		});
	}
	
	public boolean xoa(String ma) {
		HangHoa hh = timKiemHH(ma);
		if(hh!=null) {
			list.remove(hh);
			return true;
		}
		return false;
	}
	
	public HangHoa layThongTinHangKhoBan() {
		for (HangHoa hangHoa : list) {
			if(hangHoa instanceof HangThucPham)
				if(hangHoa.danhGia().equals("Kho ban"))
					return hangHoa;
		}
		return null;
	}
	
	public boolean sua(String ma, double donGia) {
		for (HangHoa hangHoa : list) {
			if(hangHoa.getMaHang().equals(ma)) {
				hangHoa.setDonGia(donGia);
				return true;
			}
		}
		return false;
	}
}
