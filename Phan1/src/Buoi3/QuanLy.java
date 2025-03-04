package Buoi3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class QuanLy {
	public ArrayList<Object> getThongTin(String tenfile) throws Exception{
		ArrayList<Object> ds = new ArrayList<Object>();
		FileReader f1= new FileReader(tenfile);
		BufferedReader r= new BufferedReader(f1);
		while(true){
		String st= r.readLine();
		if(st==null|| st=="")  break;
		String[] tach = st.split(";");
			if(tach.length == 3) {
				SinhVien sv = new SinhVien();
				sv.setMasv(tach[0]);
				sv.setHoten(tach[1]);
				sv.setDtb(Double.parseDouble(tach[2]));
				ds.add(sv);
			}
			else if(tach.length == 4) {
				NhanVien nv = new NhanVien();
				nv.setManv(tach[0]);
				nv.setHoten(tach[1]);
				nv.setTendv(tach[2]);
				nv.setHsl(Double.parseDouble(tach[3]));
				ds.add(nv);
			}
		}
		r.close();
		return ds;
	}
	public static void main(String[] args) {
		try {
			QuanLy ql = new QuanLy();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//Nhap vao 1 key(ho ten) in ra thong tin cua sinh vien hoac nhan vien
		public ArrayList<Object> HienThi2(ArrayList<?> sv , String key) {
			ArrayList<Object> ds = new ArrayList<Object>();
			for(Object ql1 : sv) {
				if(ql1 instanceof SinhVien) {
					SinhVien sv1 = (SinhVien)ql1;
					if(sv.toString().toLowerCase().contains(key.toLowerCase())) {
						ds.add(sv1);
					}
				}
				else {
					NhanVien nv = (NhanVien)ql1;
					if(nv.toString().toLowerCase().contains(key.toLowerCase())) {
						ds.add(nv);
					}
				}
			}
			return ds;
		}
		public void HienThiNV(ArrayList<Object> ds) throws Exception{
			for(Object t : ds) {
				if(t instanceof NhanVien) {
					NhanVien nv = (NhanVien)t;
					System.out.println(nv.toString());
				}
			}
		}
		public void HienThiSV(ArrayList<Object> ds) throws Exception{
			for(Object t : ds) {
				if(t instanceof SinhVien) {
					SinhVien sv = (SinhVien)t;
					System.out.println(sv.toString());
				}
			}
		}
		
		//xoa sv co dtb duoi 5
			public static void Xoa(ArrayList<?> sv) {
				for(Object ql1 : sv) {
					if(ql1 instanceof SinhVien) {
						SinhVien sv1 = (SinhVien)ql1;
							if(sv1.getDtb() < 5.0) sv.remove(ql1);
						}
					}
			}
			//Nhap vao 1 key -> in ra thong tin cua sinh vien
			public SinhVien HienThi (ArrayList<?> sv , String msv) {
				for(Object ql1 : sv) {
					if(ql1 instanceof SinhVien) {
						SinhVien sv1 = (SinhVien)ql1;
						if(sv.toString().toLowerCase().contains(msv.toLowerCase())) {
							return sv1;
						}
					}
				}
				return null;
			}
			//Nhap Vao mot masv va dtb moi , sua lai dtb cho sv nay
			public static void Sua(ArrayList<?> ds , String msv , double dtb) {
				
				for(Object ql1 : ds) {
					if(ql1 instanceof SinhVien) {
						SinhVien sv = (SinhVien)ql1;
						if(sv.toString().contains(msv)) {
							sv.setDtb(dtb);
						}
					}
				}
			}
			//Tim Sv
			public SinhVien TimSV(ArrayList<?> ds , String masv) throws Exception{
				for(Object t : ds) {
					if(t instanceof SinhVien) {
						SinhVien sv = (SinhVien)t;
						if(sv.getMasv().trim().equalsIgnoreCase(masv.trim())) {
							return sv;
						}
					}
				}
				return null;
			}
			public void luuFile(ArrayList ds) throws Exception{
				//Mo 2 file sv.txt va nv nv.txt de luu
				//Duyet ds: Sinh Vien -> sv.txt
				//Duyet ds: Nhan Vien -> nv.txt
				FileWriter sv= new FileWriter("sv.txt");
				PrintWriter pwsv= new PrintWriter(sv);
				FileWriter nv= new FileWriter("nv.txt");
				PrintWriter pwnv= new PrintWriter(nv);
				for(Object t : ds) {
					if(t instanceof SinhVien) {
						SinhVien sv1 = (SinhVien)t;
					    pwsv.println(sv1.toString());
					}
					else {
						NhanVien nv1 = (NhanVien)t;
					    pwnv.println(nv1.toString());
					}
				}
				pwsv.close();
			    pwnv.close();
			    System.out.println("Alo");
			}
}
