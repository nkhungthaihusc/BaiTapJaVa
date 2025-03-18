import java.util.ArrayList;

public class test {
	public static void main(String[] args) {
		LopHoc lh = new LopHoc();
		ArrayList<Object> ds = lh.ds1;
		for(Object t : ds) {
			System.out.println("dhshds");
			if(t instanceof SvCntt) {
				System.out.println("sds");
				SvCntt sv = new SvCntt();
				sv.getThongTin();
			}
		}
	}
}
