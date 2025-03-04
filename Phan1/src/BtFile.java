import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.regex.Pattern;


public class BtFile {
	public void TaoDanhSach(int n) {
			try {
				FileWriter fw = new FileWriter("sv.txt");
				PrintWriter pw = new PrintWriter(fw);
				Random r = new Random();
				
				BtMang m = new BtMang();
				for(int i = 1 ; i <= n ; i++) {
					double dtb = r.nextDouble()*10;
					String[] gt = {"Nam" , "Nu"};
						String t = gt[r.nextInt(gt.length)];
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
					pw.println("Sv" + i + ";" + m.TaoHoTen() + ";" + m.TaoNgay("01/01/1960", "01/01/2000") + ";" + t + ";" + dtb + ";" + c + ";" + d);
				}
				pw.close();
				System.out.println("Da tao xong");
			}catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Loi o ham TaoDanhSach:" + e.getMessage());
		}
	}
	
	
	public void XuatDanhSach() throws Exception{
		FileReader fr = new FileReader("sv.txt");
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String st = br.readLine();
			if(st == "" || st == null)break;
			String[] ds = st.split("[;]");
			System.out.println(ds[0] + "\n" + ds[1] + "\n" + ds[2] + "\n" + ds[3] + "\n" + ds[4] + "\n" + ds[5] + "\n" + ds[6] + "\n\n");
		}
		br.close();
	}
	public void FindLinear(String name) throws Exception {
		FileReader fr = new FileReader("sv.txt");
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String st = br.readLine();
			if(st == "" || st == null) break;
			String[] ds = st.split("[;]");
			if(ds[1].trim().toLowerCase().contains(name.toLowerCase().trim())) {
				System.out.println(ds[0] + "\n" + ds[1] + "\n" + ds[2] + "\n" + ds[3] + "\n" + ds[4] + "\n" + ds[5] + "\n" + ds[6] + "\n\n");
			}
		}
		br.close();
	}
	
	public void Counter() throws Exception {
		FileReader fr = new FileReader("sv.txt");
		BufferedReader br = new BufferedReader(fr);
		int cnt1 = 0;
		int cnt2 = 0;
		while(true) {
			String st = br.readLine();
			if(st == "" || st == null) break;
			String[] ds = st.split("[;]");
			if(ds[5] == "dau") {
				cnt1++;
			}
			else {
				cnt2++;
			}
		}
		br.close();
		System.out.println("So luong sinh vien dau la: " + cnt1 + "\n" + "So luong sinh vien rot la: " + cnt2);
	}
	public double Avg() throws Exception {
		FileReader fr = new FileReader("sv.txt");
		BufferedReader br = new BufferedReader(fr);
		double tdtb = 0;
		int cnt = 0;
		while(true) {
			String st = br.readLine();
			if(st == "" || st == null) break;
			String[] ds = st.split("[;]");
			cnt = ds.length;
			tdtb += Double.parseDouble(ds[4]);
		}
		br.close();
		tdtb /= cnt;
		return tdtb;
	}
	public void check() throws Exception{
		FileReader fr = new FileReader("sv.txt");
		BufferedReader br = new BufferedReader(fr);
		String cns = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";
		String d = "^[0-10]$";
		while(true) {
			String st = br.readLine();
			if(st == "" || st == null) break;
			String[] ds = st.split("[;]");
			if(!Pattern.matches(cns, ds[2])) {
				System.out.println("Ngay sinh bi loi: " + ds[2]);
			}
			if(!Pattern.matches(d, ds[4])) {
				System.out.println("Diem trung binh bi loi: " + ds[4]);
			}
		}
	}
}
