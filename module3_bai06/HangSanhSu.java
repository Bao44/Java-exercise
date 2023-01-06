package truongQuocBao.bai06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class HangSanhSu extends HangHoa{
	private String nhaSX;
	private LocalDate ngNK;
	public HangSanhSu(String maHang, String tenHang, double donGia, int soLuongTon, String nhaSX, LocalDate ngNK) {
		super(maHang, tenHang, donGia, soLuongTon);
		this.nhaSX = nhaSX;
		this.ngNK = ngNK;
	}
	public HangSanhSu(String maHang, String tenHang, double donGia, int soLuongTon) {
		super(maHang, tenHang, donGia, soLuongTon);
	}
	public String getNhaSX() {
		return nhaSX;
	}
	public void setNhaSX(String nhaSX) {
		if(!nhaSX.trim().equals(""))
			this.nhaSX = nhaSX;
		else
			this.nhaSX = "Null";
	}
	public LocalDate getNgNK() {
		return ngNK;
	}
	public void setNgNK(LocalDate ngNK) {
		if(ngNK.isBefore(LocalDate.now()))
			this.ngNK = ngNK;
		else
			this.ngNK = LocalDate.now();
	}
	
	public long tinhSoNgayLuuKho() {
		LocalDate day = LocalDate.now();
		long soNgay = ngNK.until(day, ChronoUnit.DAYS);
		return soNgay;
	}
	
	@Override
	public String danhGia() {
		if(getSoLuongTon() > 50 && tinhSoNgayLuuKho() > 10)
			return "Ban cham";
		return "-";
	}
	@Override
	public double tinhVAT() {
		return getSoLuongTon()*getDonGia()*0.1;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String nk = dtf.format(ngNK);
		return String.format("%s%-15s%-15s%-15s%-15s%-15s%-15s%-15s", super.toString(),"","","","","",nhaSX,nk);
	}
	public static String getTieuDe() {
		return String.format("%-10s%-15s%-15s%-15s%-15s%-15s","Ma hang","Ten hang","Don gia","So luong","Nha SX","Ngay NK");
	}
}
