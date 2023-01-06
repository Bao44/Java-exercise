package truongQuocBao.bai06;

public class PhongLyThuyet extends PhongHoc{
	private boolean coMayChieu;
	
	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
	}

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.setCoMayChieu(coMayChieu);
	}

	public boolean isCoMayChieu() {
		return coMayChieu;
	}
	public void setCoMayChieu(boolean coMayChieu) {
		this.coMayChieu = coMayChieu;
	}

	@Override
	public boolean kiemTraDatChuan() {
		if(coMayChieu && kiemTraDuAS())
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
		return String.format("%s%15s%15s", super.toString(),coMayChieu,kiemTraDatChuan());
	}
}
