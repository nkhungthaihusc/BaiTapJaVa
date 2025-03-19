package MyFrame2;

public class SinhVien {
	public String ht, tenlop, masv;
	public float dtb;

	public SinhVien(String masv, String ht, String tenlop, float dtb) {
		this.masv = masv;
		this.ht = ht;
		this.tenlop = tenlop;
		this.dtb = dtb;
	}

	public void DoiTen(String ht) {
		this.ht = ht;
	}

	public void DoiDtb(float string) {
		this.dtb = string;
	}

	public void DoiLop(String TenLop) {
		this.tenlop = TenLop;
	}
}
