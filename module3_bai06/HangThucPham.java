package truongQuocBao.bai06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa{
	private String nhaCC;
	private LocalDate ngSX,ngHH;
	public HangThucPham(String maHang, String tenHang, double donGia, int soLuongTon, String nhaCC, LocalDate ngSX,
			LocalDate ngHH) {
		super(maHang, tenHang, donGia, soLuongTon);
		this.setNhaCC(nhaCC);
		this.setNgSX(ngSX);
		this.setNgHH(ngHH);
	}

	public HangThucPham(String maHang, String tenHang, double donGia, int soLuongTon) {
		super(maHang, tenHang, donGia, soLuongTon);
	}

	public String getNhaCC() {
		return nhaCC;
	}
	public void setNhaCC(String nhaCC) {
		if(!nhaCC.trim().equals(""))
			this.nhaCC = nhaCC;
		else
			this.nhaCC = "Null";
	}
	public LocalDate getNgSX() {
		return ngSX;
	}
	public void setNgSX(LocalDate ngSX) {
		if(ngSX.isBefore(LocalDate.now()))
			this.ngSX = ngSX;
		else
			this.ngSX = LocalDate.now();
	}
	public LocalDate getNgHH() {
		return ngHH;
	}
	public void setNgHH(LocalDate ngHH) {
		if(ngHH.isAfter(getNgSX()))
			this.ngHH = ngHH;
		else
			this.ngHH = getNgSX();
	}

	@Override
	public String danhGia() {
		if(getSoLuongTon() > 0 && ngHH.isAfter(LocalDate.now()))
			return "Kho ban";
		return "-";
	}

	@Override
	public double tinhVAT() {
		return getSoLuongTon()*getDonGia()*0.05;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String sx = dtf.format(ngSX);
		String hh = dtf.format(ngHH);
		return String.format("%s%-15s%-15s%-15s", super.toString(),nhaCC,sx,hh);
	}
	public static String getTieuDe() {
		return String.format("%-10s%-15s%-15s%-15s%-15s%-15s%-15s","Ma hang","Ten hang","Don gia","So luong","Nha cung cap","Ngay Sx","Ngay het han");
	}
	
}
