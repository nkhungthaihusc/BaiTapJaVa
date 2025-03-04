package Buoi3;

import java.util.ArrayList;

public class NhanVien {
	private String manv;
	private String hoten;
	private String tendv;
	private double hsl;
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getTendv() {
		return tendv;
	}
	public void setTendv(String tendv) {
		this.tendv = tendv;
	}
	public double getHsl() {
		return hsl;
	}
	public void setHsl(double hsl) {
		this.hsl = hsl;
	}
	@Override
	public String toString() {
		return manv + ";" + hoten + ";" + tendv + ";" + hsl;
	}

	
}
