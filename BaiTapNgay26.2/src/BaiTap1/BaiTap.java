package BaiTap1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class BaiTap {
	public ArrayList getThongTin(String filename) throws Exception {
		ArrayList<Object> ds = new ArrayList<Object>();
		FileReader f1 = new FileReader(filename);
		BufferedReader r = new BufferedReader(f1);
		String cso="0[0-9]{9,10}";
		String cmsv = "^[0-9]{2}[A-Z][0-9]{7}$";
		String cns = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";
		String cmail = "^[a-zA-Z0-9_%+-]+@gmail.com$";
		while(true) {
			String st = r.readLine();	
			SinhVien sv = new SinhVien();
			if(st == null || st == "") break;
			String[] oj = st.split("[;]");
//			for (String string : oj) {
//				System.out.println(string);
//			}
			if(oj.length != 5) {
				System.out.println("Du lieu khong du");
			}
			else {
				if(Pattern.matches(cmsv, oj[0])) {
					sv.setMsv(oj[0]);
				}
				else {
					System.out.println("Du lieu dua vao chua ki tu loi o Ma Sinh Vien: " + oj[0]);
					continue;
				}
				if(Pattern.matches(cns, oj[2])) {
					
					sv.setNgaysinh(oj[2]);
				}
				else {
					System.out.println("Du lieu dua vao chua ki tu loi Ngay Sinh: " + oj[2]);
					continue;
				}
				if(Pattern.matches(cso, oj[3])) {
					sv.setSdt(oj[3]);
				}
				else {
					System.out.println("Du lieu dua vao chua ki tu loi So Dien Thoai: " + oj[3]);
					continue;
				}
				if(Pattern.matches(cmail, oj[4])) {
					sv.setEmail(oj[4]);
				}
				else {
					System.out.println("Du lieu dua vao chua ki tu loi Email: " + oj[4]);
					continue;
				}
				sv.setHoten(oj[1]);
				ds.add(sv);
			}
		}
		r.close();
		return ds;
	}
	public void HienThi(ArrayList ds) {
		for(Object t : ds) {
			if(t instanceof SinhVien) {
				SinhVien sv = (SinhVien)t;
				System.out.println(sv.toString());
			}
		}
	}
	public static void main(String[] args) {
		try {
			BaiTap bt = new BaiTap();
			bt.getThongTin("duleu.txt");
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}
}
