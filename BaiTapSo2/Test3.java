import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test3 {
	public static void main(String[] args) {
		String[] tt = {"24T102;Le van teo;K48;CNTT;23" , "24T103;Le van Ty;K45;CNTT;20", "24T103;Le van Nam;K48;Toan;17 " , "24T103;Le van Trung;K48;Ly;25"};
		//Cau1: Xuat ra ds sinh vien
		for (String string : tt) {
			System.out.println(string);
		}
		//Cau2: Nhap vao masv , in ra diem dau vao cua cac sinh vien do
		Scanner oj = new Scanner(System.in);
		System.out.println("Nhap ma sv: ");
		String s = oj.nextLine();
		for (String string : tt) {
			String[] a = string.split("[;]");
			if(string.toLowerCase().trim().contains(s.toLowerCase().trim())) {
				System.out.println(a[4]);
			}
		}
		//Cau3:
		System.out.println("Nhap key:");
		String key = oj.nextLine();
		for (String string : tt) {
			if(string.toLowerCase().trim().contains(key.toLowerCase().trim())) {
				System.out.println(string);
			}
		}
		//Cau 4:
		System.out.println("Nhap khoa:");
		String khoa = oj.nextLine();
		for (String string : tt) {
			String[] a = string.split("[;]");
			if(a[3].toLowerCase().trim().equals(khoa.toLowerCase().trim())) {
				System.out.println(string);
			}
		}
		//Cau 5
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Double> map2 = new HashMap<String, Double>();
		Set<String> setA = new HashSet<String>();
		for (String string : tt) {
			String[] a = string.split("[;]");
			setA.add(a[3]);
		}
		for (String string : setA) {
			int cnt = 0;
			double tong = 0;
			for (String string2 : tt) {
				String[] a = string2.split("[;]");
				if(string.toLowerCase().trim().equals(a[3].toLowerCase().trim())) {
					int number = Integer.parseInt(a[4].trim());
					tong += number;
					cnt++;
				}
			}
			map.put(string, cnt);
			map2.put(string, tong);
		}
		Set set = map.keySet();
		System.out.println("So luong sinh vien moi khoa:");
		for(Object c : set) {
			System.out.println(c + " " + map.get(c));
		}
		Set set1 = map2.keySet();
		System.out.println("Trung binh cong diem dau vao:");
		for (Object object : set1) {
			System.out.println(object + ":" + map2.get(object));
		}
	}
}
