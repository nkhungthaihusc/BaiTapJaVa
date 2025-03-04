import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class QuanLy {
	public ArrayList<Object> DocFile() throws Exception{
		ArrayList<Object> ds = new ArrayList<Object>();
		FileReader fr = new FileReader("input1.txt");
		FileReader fr1 = new FileReader("input2.txt");
		BufferedReader bf = new BufferedReader(fr);
		BufferedReader bf1 = new BufferedReader(fr1);
		while(true){
			TinhTien tt = new TinhTien();
			String st = bf.readLine();
			if(st == null || st == "") break;
			String[] s = st.split(";");
				DiVao dv = new DiVao();
				dv.setLoaiXe(Integer.parseInt(s[0]));
				tt.setLoaiXe(Integer.parseInt(s[0]));
				dv.setBienSoXe(s[1]);
				tt.setBienSoXe(s[1]);
				dv.setSoVeXe(s[2]);
				tt.setSoVeXe(s[2]);
				dv.setThoiGianVao(s[3]);
				tt.setThoiGianVao(s[3]);
				dv.setTinhTrangXe(s[4]);
				tt.setTinhTrangXeVao(s[4]);
				ds.add(dv);
			String a = bf1.readLine();
				String[] b = a.split(";");
					DiRa dr = new DiRa();
					dr.setLoaiXe(Integer.parseInt(b[0]));
					dr.setBienSoXe(b[1]);
					dr.setSoVeXe(b[2]);
					dr.setThoiGianRa(b[3]);
					tt.setThoiGianRa(b[3]);
					dr.setTinhTrangXe(b[4]);
					tt.setTinhTrangXeRa(b[4]);
					ds.add(dr);
					ds.add(tt);
			}
		return ds;
	}
	
	public void HienThi(ArrayList<Object> ds) {
		for(Object t : ds) {
			if(t instanceof DiVao) {
				DiVao dv = (DiVao)t;
				System.out.println(dv);
			}
			else if(t instanceof DiRa) {
				DiRa dr = (DiRa)t;
				System.out.println(dr);
			}
			else if(t instanceof TinhTien) {
				TinhTien tt = (TinhTien)t;
				System.out.println(tt);
			}
		}
	}
	
}
