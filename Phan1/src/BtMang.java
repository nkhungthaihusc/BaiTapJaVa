import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BtMang {
	public String TaoNgay(String ngay1 , String ngay2) {
		try {
			//Dinh dang ngay theo ngay thang nam
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			Date n1 = f.parse(ngay1); //Doi chuoi ra ngay
			Date n2 = f.parse(ngay2);
			Random r = new Random();
			 while(true) {
				 Long t = r.nextLong();
				 if(t >= n1.getTime() && t <= n2.getTime()) {
					 Date n = new Date(t);//doi so ra ngay
					 return f.format(n);//Tra ve chuoi ngay thang nam
		
				 }
			 }
		}catch (Exception tt) {
			// TODO: handle exception
			System.out.println("Loi: " + tt.getMessage());
			return null;
		}
	}
public String TaoHoTen() {
	String[] ho = {"Tran" , "Le" , "Nguyen"};
	String[] chulot = {"Thanh" , "Hoang" , "Trung" , "Van" , "My"};
	String[] ten = {"Hung" , "Nga" , "Tien" , "Tam" , "Ton" , "Giang" , "Sy"};
	Random r = new Random();
	//ho.length tra ve do dai cua mang ho -> 3
	String h = ho[r.nextInt(ho.length)];
	String cl = chulot[r.nextInt(chulot.length)];
	String t = ten[r.nextInt(ten.length)];
	return h + " " + cl + " " + t;
	}

public void HienThi(int n) {
	Random r = new Random();
	for(int i = 1 ; i <= n ; i++) {
		double dtb = r.nextDouble()*10;
		System.out.println(TaoHoTen() + ";" + TaoNgay("01/01/1960",	"01/01/2000") + ";" + dtb);
	}
}
}