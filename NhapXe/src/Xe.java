import java.util.Random;

public class Xe {
    public int getSoxe(){
        Random r = new Random();
		int sx = r.nextInt(100000);
        return sx;
    }
    public int TinhDiem(int sx){
        sx = getSoxe();
        int diem = 0;
		int donvi = sx % 10;
		diem += donvi;
		sx /= 10;
		// System.out.println("Don vi: " + donvi);
		int chuc = sx % 10;
		diem += chuc;
		sx /= 10;
		// System.out.println("Chuc: " + chuc);
		int tram = sx % 10;
		diem += tram;
		sx /= 10;
		// System.out.println("Tram: " + tram);
		int ngan = sx % 10;
		diem += ngan;
		sx /= 10;
		// System.out.println("Ngan: " + ngan);
		int cngan = sx % 10;
		diem += cngan;
		sx /= 10;
		// System.out.println("Chuc ngan: " + cngan);
        return diem % 10;
    }
    public String Hienthiso(int sx){
        return String.valueOf(sx % 10) + String.valueOf(sx / 10 % 10)
                    + String.valueOf(sx /100 % 10) + String.valueOf(sx / 1000 % 10) + 
                    String.valueOf(sx /10000);
    }
}
