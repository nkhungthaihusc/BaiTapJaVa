package BaiTap1;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		try {
			BaiTap bt = new BaiTap();
			ArrayList ds = bt.getThongTin("dulieu.txt");
			bt.HienThi(ds);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}
}
