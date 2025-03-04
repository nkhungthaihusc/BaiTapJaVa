package Buoi3;



public class SinhVien {
	private String masv;
	@Override
	public String toString() {
		return masv + ";" + hoten + ";" + dtb;
	}
	private String hoten;
	private double dtb;
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public double getDtb() {
		return dtb;
	}
	public void setDtb(double dtb) {
		this.dtb = dtb;
	}
	
}
