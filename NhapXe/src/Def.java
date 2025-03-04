import java.util.Scanner;

public class Def {
	//Nhap n xe va hien thi
	public static void main(String[] args){
		System.out.print("Nhap so xe:");
		Scanner nhap = new Scanner(System.in);
		String tam = nhap.nextLine();//Nhap vao 1 chuoi
		int n = Integer.parseInt(tam);
		Xe var1 = new Xe();
	      int var2 = 0;
	      int var3 = 0;

	      for(int var4 = 1; var4 <= n; ++var4) {
	         int var5 = var1.getSoxe();
	         System.out.println("Xe so " + var4 + ": " + var5);
	         if (var2 < var1.TinhDiem(var5)) {
	            var2 = var1.TinhDiem(var5);
	            var3 = var5;
	         }
	      }

	      System.out.println("Xe co diem lon nhat la: " + var2 + " Cua xe : " + var3);
	   }
	}
