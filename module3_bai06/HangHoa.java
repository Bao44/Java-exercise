package truongQuocBao.bai06;

public abstract class HangHoa {
	private String maHang,tenHang;
	private double donGia;
	private int soLuongTon;
	public HangHoa(String maHang, String tenHang, double donGia, int soLuongTon) {
		this.setMaHang(maHang);
		this.setTenHang(tenHang);
		this.setDonGia(donGia);
		this.setSoLuongTon(soLuongTon);
	}
	public HangHoa() {
		this("Null", "xxx", 0, 0);
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		if(!maHang.trim().equals(""))
			this.maHang = maHang;
		else
			this.maHang = "Null";
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		if(!tenHang.trim().equals(""))
			this.tenHang = tenHang;
		else
			this.tenHang = "xxx";
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		if(donGia >= 0)
			this.donGia = donGia;
		else
			this.donGia = 0;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		if(soLuongTon >= 0)
			this.soLuongTon = soLuongTon;
		else
			this.soLuongTon = 0;
	}
	
	public abstract String danhGia();
	public abstract double tinhVAT();
	
	@Override
	public String toString() {
		return String.format("%-10s%-15s%-15.2f%-15d", maHang,tenHang,donGia,soLuongTon);
	}
	public static String getTieuDe() {
		return String.format("%-10s%-15s%-15s%-15s","Ma hang","Ten hang","Don gia","So luong");
	}
	
}
