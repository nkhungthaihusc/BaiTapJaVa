import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LopHoc {
	public ArrayList<Object> ds1 = new ArrayList<Object>();
	public void TaoLop(String tf) {
		try {
			FileReader fr = new FileReader(tf);
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String st = br.readLine();
//				System.out.println(st);
				if(st == null || st == "") break;
				System.out.println(st);
				String[] t = st.split("[|]");
//				System.out.println(t.length);
				if(t.length == 4) {
					SvCntt sv = new SvCntt();
					sv.setMaSv(t[0]);
					sv.setHoTen(t[1]);
					sv.setDm1(Double.parseDouble(t[2]));
					sv.setDm2(Double.parseDouble(t[3]));
					ds1.add(sv);
				}
				if(t.length == 5) {
					SvToan sv = new SvToan();
					sv.setMaSv(t[0]);
					sv.setHoTen(t[1]);
					sv.setDm1(Double.parseDouble(t[2]));
					sv.setDm2(Double.parseDouble(t[3]));
					sv.setDm3(Double.parseDouble(t[4]));
					ds1.add(sv);
				}
				if(t.length == 6) {
					SvLy sv = new SvLy();
					sv.setMaSv(t[0]);
					sv.setHoTen(t[1]);
					sv.setDm1(Double.parseDouble(t[2]));
					sv.setDm2(Double.parseDouble(t[3]));
					sv.setDm3(Double.parseDouble(t[4]));
					sv.setDm4(Double.parseDouble(t[5]));
					ds1.add(sv);
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}
	public void HienThi() {
		System.out.println("Danh sach sv Khoa CNTT");
		for (Object sv : ds1) {
			if(sv instanceof SvCntt) {
				SvCntt sv1 = (SvCntt)sv;
				sv1.HienThi();
			}
		}
		System.out.println("Danh sach sv Khoa Toan");
		for (Object sv : ds1) {
			if(sv instanceof SvToan) {
				SvToan sv1 = (SvToan)sv;
				sv1.HienThi();
			}
		}
		System.out.println("Danh sach sv Khoa Ly");
		for (Object sv : ds1) {
			if(sv instanceof SvLy) {
				SvLy sv1 = (SvLy)sv;
				sv1.HienThi();
			}
		}
	}
	public ArrayList<Object> TimKey(ArrayList<Object> ds , String key){
		ArrayList<Object> dst = new ArrayList<Object>();
		for(Object t : ds) {
			if(t instanceof SvCntt) {
				SvCntt sv = (SvCntt)t;
				if(sv.getHoTen().toLowerCase().trim().contains(key.trim().toLowerCase())) {
					dst.add(sv);
				}
			}
			if(t instanceof SvToan) {
				SvToan sv = (SvToan)t;
				if(sv.getHoTen().toLowerCase().trim().contains(key.trim().toLowerCase())) {
					dst.add(sv);
				}
			}
			if(t instanceof SvLy) {
				SvLy sv = (SvLy)t;
				if(sv.getHoTen().toLowerCase().trim().contains(key.trim().toLowerCase())) {
					dst.add(sv);
				}
			}
		}
		return dst;
	}
	public static void main(String[] args) {
		LopHoc lh = new LopHoc();
		lh.TaoLop("sv.txt");
		lh.HienThi();
	}
}
