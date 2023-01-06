package truongQuocBao.bai06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListPhongHoc {
	private ArrayList<PhongHoc> list;

	public ListPhongHoc(ArrayList<PhongHoc> list) {
		this.list = list;
	}

	public ListPhongHoc() {
		this.list = new ArrayList<PhongHoc>();
	}
	
	public boolean add(PhongHoc ph) {
		for (PhongHoc phongHoc : list) {
			if(phongHoc.getMaPhong().equalsIgnoreCase(ph.getMaPhong()))
				return false;
		}
		list.add(ph);
		return true;
	}

	public PhongHoc timKiemPH(String ma) {
		for (PhongHoc phongHoc : list) {
			if(phongHoc.getMaPhong().equals(ma))
				return phongHoc;
		}
		return null;
	}
	
	
	public String pHDatChuan() {
		String s = "";
		for (PhongHoc phongHoc : list) {
			if(phongHoc.kiemTraDatChuan())
				s+= phongHoc +"\n";
		}
		return s;
	}

	public void sapXepTheoDayNha() {
		Collections.sort(list, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				return o1.getDayNha().compareToIgnoreCase(o2.getDayNha());
			}
		});
	}
	
	public void sapXepTheoDienTich() {
		Collections.sort(list, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				Double dt1 = o1.getDienTich();
				Double dt2 = o2.getDienTich();
				return dt2.compareTo(dt1);
			}
		});
	}
	
	public void sapXepTheoSoBD() {
		Collections.sort(list,new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				Integer bd1 = o1.getSoBongDen();
				Integer bd2 = o2.getSoBongDen();
				return bd1.compareTo(bd2);
			}
		});
	}
	
	public boolean capNhatSoMT(String ma,int soMT) {
		for (PhongHoc phongHoc : list) {
			if(phongHoc instanceof PhongMayTinh)
				if(phongHoc.getMaPhong().equals(ma)) {
					((PhongMayTinh) phongHoc).setSoMayTinh(soMT);
					return true;
				}
		}
		return false;
	}
	
	public boolean xoa(String ma) {
		PhongHoc ph = timKiemPH(ma);
		if(ph != null) {
			list.remove(ph);
			return true;
		}
		return false;
	}
	
	public int tongSoPH() {
		return list.size();
	}
	
	public String danhSachPHMT() {
		ListPhongHoc mt = new ListPhongHoc();
		
		for (PhongHoc phongHoc : list) {
			if(phongHoc instanceof PhongMayTinh)
				if(((PhongMayTinh) phongHoc).getSoMayTinh() == 60)
					mt.add(phongHoc);
		}
		return mt.toString();
	}

	@Override
	public String toString() {
		String s = String.format("%-10s%15s%15s%15s%15s%15s%15s%15s%15s\n","Mã phòng","Dãy nhà","Diện tích","Số bóng đèn",
				"Máy chiếu","Số máy tính","Thông tin CN","Sức chứa","Bồn rửa");
		for (PhongHoc phongHoc : list) {
		s+=phongHoc + "\n";
		}
		return s;
	}
	
	
}
