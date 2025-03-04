import java.io.Closeable;
import java.util.Scanner;

public class Recursion {
	static double Sum(int n) {
		if(n == 1) return 1;
		return Sum(n - 1) + (double)1/n;
	}
	static void InSDN(long n) {
		if(n >= 10) { System.out.print(n % 10);
		InSDN(n / 10);
		}
		else System.out.println(n);
	}
	static double LT(double a, int n) {
		if (n == 0) return 1;
		double X = LT(a , n / 2);
		if(n % 2 == 0) {
			return X * X;
		}
		else {
			return a * X * X;
		}
	}
	public static void main(String[] args){
		Scanner oj = new Scanner(System.in);
		String n = oj.nextLine();
		int a = Integer.parseInt(n);
		double x = Sum(a);
		int b = oj.nextInt();
		System.out.println(x);
		InSDN(b);
		oj.close();
	}
}