package truongQuocBao.bai06;

public abstract class PhongHoc {
	private String maPhong,dayNha;
	private double dienTich;
	private int soBongDen;
	public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
		this.setMaPhong(maPhong);
		this.setDayNha(dayNha);
		this.setDienTich(dienTich);
		this.setSoBongDen(soBongDen);
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		if(!maPhong.trim().equals(""))
			this.maPhong = maPhong;
		else
			this.maPhong = "Null";
	}
	public String getDayNha() {
		return dayNha;
	}
	public void setDayNha(String dayNha) {
		if(!dayNha.trim().equals(""))
			this.dayNha = dayNha;
		else
			this.dayNha = "Null";
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		if(dienTich > 0)
			this.dienTich = dienTich;
		else
			this.dienTich = 1;
	}
	public int getSoBongDen() {
		return soBongDen;
	}
	public void setSoBongDen(int soBongDen) {
		if(soBongDen >=0)
			this.soBongDen = soBongDen;
		else
			this.soBongDen = 0;
	}
	
	public abstract boolean kiemTraDatChuan();
	public abstract boolean kiemTraDuAS();
	
	@Override
	public String toString() {
		return String.format("%-10s%15s%15f%15d", maPhong,dayNha,dienTich,soBongDen);
	}
}
