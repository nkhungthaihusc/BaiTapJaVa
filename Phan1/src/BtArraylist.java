import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BtArraylist {
	public ArrayList<String> DsHoten = new ArrayList<String>();
	public ArrayList<Double> DsDtb = new ArrayList<Double>();
	public void TaoDanhSach() throws Exception {
		FileReader fr = new FileReader("sv.txt");
		BufferedReader bf = new BufferedReader(fr);
		while(true) {
			String st = bf.readLine();
			if(st == "" || st == null) break;
			String[] ds = st.split("[;]");
			DsHoten.add(ds[1]);
			DsDtb.add(Double.parseDouble(ds[4]));
		}
		bf.close();
	}
	public void XuatDanhSach() {
		int ss = DsHoten.size();
		for(int i = 0 ; i < ss; i++) {
			System.out.println(DsHoten.get(i) + DsDtb.get(i));
		}
	}
	
	public ArrayList<String> Find(String name) throws Exception{
		ArrayList<String> ds = new ArrayList<String>();
		for(String string : DsHoten) {
			if(string.trim().toLowerCase().contains(name.trim().toLowerCase())) {
				ds.add(name);
			}
		}
		return ds;
	}
	
	public int ThongKeDau() {
		int cnt = 0;
		for(Double i : DsDtb) {
			if(i >= 5) cnt++;
		}
		return cnt;
	}
	public int ThongKeRot() {
		int cnt = 0;
		for(Double i : DsDtb) {
			if(i < 5) cnt++;
		}
		return cnt;
	}
	public double Tinh() {
		double cnt = 0;
		int x = DsDtb.size();
		for(double i : DsDtb) {
			cnt += i;
		}
		cnt /= x;
		return cnt;
	}
	
}
