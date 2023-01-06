package truongQuocBao.bai06;

public class PhongThiNghiem extends PhongHoc{
	private String thongTinCN;
	private int sucChua;
	private boolean bonRua;
	
	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
	}
	
	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, String thongTinCN, int sucChua,
			boolean bonRua) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.setThongTinCN(thongTinCN);
		this.setSucChua(sucChua);
		this.setBonRua(bonRua);
	}
	
	public String getThongTinCN() {
		return thongTinCN;
	}
	public void setThongTinCN(String thongTinCN) {
		if(!thongTinCN.trim().equals(""))
			this.thongTinCN = thongTinCN;
		else
			this.thongTinCN = "Null";
	}
	public int getSucChua() {
		return sucChua;
	}
	public void setSucChua(int sucChua) {
		if(sucChua > 0)
			this.sucChua = sucChua;
		else
			this.sucChua = 1;
	}
	public boolean isBonRua() {
		return bonRua;
	}
	public void setBonRua(boolean bonRua) {
		this.bonRua = bonRua;
	}

	
	
	@Override
	public boolean kiemTraDatChuan() {
		if(bonRua && kiemTraDuAS())
			return true;
		return false;
	}
	@Override
	public boolean kiemTraDuAS() {
		if(getSoBongDen() >= getDienTich()/10)
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("%s%15s%15d%15s%15s", super.toString(),thongTinCN,sucChua,bonRua,kiemTraDatChuan());
	}
}
