package truongQuocBao.bai06;

import java.time.format.DateTimeFormatter;

public class HangDienMay extends HangHoa{
	private int tGianBH;
	private long congSuat;
	
	public HangDienMay(String maHang, String tenHang, double donGia, int soLuongTon, int tGianBH, long congSuat) {
		super(maHang, tenHang, donGia, soLuongTon);
		this.tGianBH = tGianBH;
		this.congSuat = congSuat;
	}
	
	public HangDienMay(String maHang, String tenHang, double donGia, int soLuongTon) {
		super(maHang, tenHang, donGia, soLuongTon);
	}

	public int gettGianBH() {
		return tGianBH;
	}
	public void settGianBH(int tGianBH) {
		if(tGianBH >= 0)
			this.tGianBH = tGianBH;
		else
			this.tGianBH = 0;
	}
	public long getCongSuat() {
		return congSuat;
	}
	public void setCongSuat(long congSuat) {
		if(congSuat >= 0)
			this.congSuat = congSuat;
		else
			this.congSuat = 0;
	}
	@Override
	public String danhGia() {
		if(getSoLuongTon() < 3)
			return "Ban duoc";
		return "-";
	}
	@Override
	public double tinhVAT() {
		return getSoLuongTon()*getDonGia()*0.1;
	}
	
	@Override
	public String toString() {
		return String.format("%s%-15s%-15s%-15s%-15d%-15d", super.toString(),"","","",tGianBH,congSuat);
	}
	public static String getTieuDe() {
		return String.format("%-10s%-15s%-15s%-15s%-15s%-15s","Ma hang","Ten hang","Don gia","So luong","Thoi gian BH","Cong suat");
	}
}
