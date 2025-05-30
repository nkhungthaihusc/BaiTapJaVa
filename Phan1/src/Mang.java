import java.util.Random;
import java.util.Scanner;

public class Mang {
	public static void main(String[] args) {
		BtMang m = new BtMang();
		System.out.println(m.TaoHoTen());
		String ngay1 = "01/02/1900";
		String ngay2 = "12/12/2024";
		System.out.println(m.TaoNgay(ngay1, ngay2));
		//Hien thi thong tin cua 100 sinh vien
		for(int i = 1 ; i <= 100 ; i++) {
			System.out.println("Ho ten nguoi thu " + i + ": " + m.TaoHoTen() + " Ngay sinh: " + m.TaoNgay(ngay1, ngay2));
		}
		//Bai tap ve nha
		Random r = new Random();
		String[] gt = {"Nam" , "Nu"};
		for(int i = 1 ; i <= 10 ; i++) {
			String t = gt[r.nextInt(gt.length)];
			double dtb = r.nextDouble()* 10;
			String c , d;
			if (dtb >= 5.0) c= "dau";
			else c = "rot";
			if(dtb >= 8) d = "gioi";
			else if (dtb >= 6.5 && dtb <= 7.9) {
				d = "kha";
			}
			else if (dtb >= 5.0 && dtb <= 6.4) {
				d = "trung binh";
			}
			else if (dtb >= 3.1 && dtb <= 4.9) {
				d = "yeu";
			}
			else d = "kem";
			System.out.println(m.TaoHoTen() + ";" + m.TaoNgay(ngay1, ngay2) + ";" + t + ";" + dtb + ";" + c + ";" + d);
		}
		//Hien thi thong tin cua n Sinh vien
		Scanner oj = new Scanner(System.in);
		System.out.print("Nhap n: ");
		String x = oj.nextLine();
		int n = Integer.parseInt(x);
		m.HienThi(n);
	}	
}
