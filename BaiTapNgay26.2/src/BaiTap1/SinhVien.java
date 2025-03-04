package BaiTap1;

import java.util.Date;

public class SinhVien {
	private String msv;
	private String hoten;
	private String ngaysinh;
	private String sdt;
	private String email;
	public String getMsv() {
		return msv;
	}
	public void setMsv(String msv) {
		this.msv = msv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "SinhVien [msv=" + msv + ", hoten=" + hoten + ", ngaysinh=" + ngaysinh + ", sdt=" + sdt + ", email="
				+ email + "]";
	}
	
}
