import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Test1 {
	public static void main(String[] args) throws Exception {
		QuanLy ql = new QuanLy();
		ArrayList ds;
		FileWriter fw = new FileWriter("output.txt");
		PrintWriter pw = new PrintWriter(fw);
		ds = ql.DocFile();
			for(Object t : ds) {
				if(t instanceof TinhTien) {
					TinhTien x = (TinhTien)t;
					pw.println(x.toString() + ";" + x.ThanhTien().toString());
				}
			}
			pw.close();
		} 
	}
