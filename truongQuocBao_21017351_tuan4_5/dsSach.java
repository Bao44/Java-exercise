package truongQuocBao_21017351_tuan4_5;

import java.io.Serializable;
import java.util.ArrayList;

public class dsSach implements Serializable{
	private ArrayList<Sach> dsSach;

	public dsSach(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}

	public dsSach() {
		this.dsSach = new ArrayList<Sach>();
	}

	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}

	public void setDsSach(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}
	
	public boolean add(Sach Sach) {
		for (Sach sach : dsSach) {
			if(Sach.getMaSach().equalsIgnoreCase(sach.getMaSach()))
				return false;
		}
		dsSach.add(Sach);
		return true;
	}
	
	public boolean xoaViTri(int i) {
		if(i >= 0 && i < dsSach.size()) {
			dsSach.remove(i);
			return true;
		}else
			return false;
	}
	
	public int timKiemSach(String masach) {
		for(int i=0;i<dsSach.size();i++) {
			if(dsSach.get(i).getMaSach().equalsIgnoreCase(masach))
				return i;
		}
		return -1;
	}
}
