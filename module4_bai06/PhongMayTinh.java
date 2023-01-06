package truongQuocBao.bai06;

public class PhongMayTinh extends PhongHoc{
	private int soMayTinh;
	
	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
	}
	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.setSoMayTinh(soMayTinh);
	}

	public int getSoMayTinh() {
		return soMayTinh;
	}


	public void setSoMayTinh(int soMayTinh) {
		if(soMayTinh > 0)
			this.soMayTinh = soMayTinh;
		else
			this.soMayTinh = 0;
	}

	@Override
	public boolean kiemTraDatChuan() {
		if((getSoMayTinh() >= getDienTich()/(1.5)) && kiemTraDuAS())
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
		return String.format("%s%15d%15s", super.toString(),soMayTinh,kiemTraDatChuan());
	}
}
