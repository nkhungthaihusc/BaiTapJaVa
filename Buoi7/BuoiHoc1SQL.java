package Buoi7;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class BuoiHoc1SQL {
	public static Connection cn;

	public void KetNoi() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Ok da nap Driver");
		String url = "jdbc:sqlserver://LENOVO:1433;databaseName=qlnhanvien;user=sa;password=Hungthai@230305";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi" + cn);
	}

	public void KetNoi(String svName, String un, String pass) throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Ok da nap Driver");

		String url = "jdbc:sqlserver://" + svName + ":1433;databaseName=TEST;user=" + un + ";password=" + pass;
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi" + cn);

	}

	/**
	 * @throws Exception
	 */
	public void HienThi() throws Exception {
//b1: Ket noi vao CSDL
		BuoiHoc1SQL bh = new BuoiHoc1SQL();
		bh.KetNoi();
//b2:Thet lap cau lenh sql
		String sql = "select * from NhanVien";
//b3:tao cau lenh
		PreparedStatement cmd = BuoiHoc1SQL.cn.prepareStatement(sql);
//b4
//b5
		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			String manv = rs.getString(1);
			String hoten = rs.getString(2);
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			String t = rs.getString(3);
			java.util.Date d1 = f.parse(t);
			boolean gt = rs.getBoolean(4);
			String gtt = gt == true ? "Nam" : "Nu";
			double hsl = rs.getDouble(5);
			String gc = rs.getString(6);
			String mdv = rs.getString(7);
			System.out.println(manv + ";" + hoten + ";" + d1 + ";" + gtt + ";" + gt + ";" + hsl + ";" + gc + ";" + mdv);
		}
		rs.close();
	}

	public void TimHoTen(String ht) throws Exception {
//b1: Ket noi vao CSDL
		BuoiHoc1SQL bh = new BuoiHoc1SQL();
		bh.KetNoi();
//b2:Thet lap cau lenh sql
		String sql = "select * from NhanVien where hoten like ?";
//b3:tao cau lenh
		PreparedStatement cmd = BuoiHoc1SQL.cn.prepareStatement(sql);
		cmd.setString(1, "%" + ht + "%");
//b4
//b5
		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			String manv = rs.getString(1);
			String hoten = rs.getString(2);
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			String t = rs.getString(3);
			java.util.Date d1 = f.parse(t);
			boolean gt = rs.getBoolean(4);
			String gtt = gt == true ? "Nam" : "Nu";
			double hsl = rs.getDouble(5);
			String gc = rs.getString(6);
			String mdv = rs.getString(7);
			System.out.println(manv + ";" + hoten + ";" + d1 + ";" + gtt + ";" + gt + ";" + hsl + ";" + gc + ";" + mdv);
		}
		rs.close();
	}

	public int XoaDv(String mdv) throws Exception {
//b1: Ket noi vao CSDL
		BuoiHoc1SQL bh = new BuoiHoc1SQL();
		bh.KetNoi();
//b2:Thet lap cau lenh sql
		String sql = "delete from NhanVien where madv = ?";
//b3:tao cau lenh
		PreparedStatement cmd = BuoiHoc1SQL.cn.prepareStatement(sql);
		cmd.setString(1, mdv);
		int kq = cmd.executeUpdate();
		BuoiHoc1SQL.cn.close();
		return kq;
	}

	public void ThemDV(String madv, String tendvmoi) throws Exception {
//b1: Ket noi vao CSDL
		BuoiHoc1SQL bh = new BuoiHoc1SQL();
		bh.KetNoi();
//b2:Thet lap cau lenh sql
		String sql = "insert into DonVi(madv , tendv) values(? , ?)";
//b3:tao cau lenh
		PreparedStatement cmd = BuoiHoc1SQL.cn.prepareStatement(sql);
		cmd.setString(1, madv);
		cmd.setString(2, tendvmoi);
		cmd.executeUpdate();
	}
	
	public void SuaDV(String madv , String tendvmoi) throws Exception{
		BuoiHoc1SQL bh = new BuoiHoc1SQL();
		bh.KetNoi();
		String sql = "update DonVi set tendv = ? where madv = ? ";
		PreparedStatement cmd = BuoiHoc1SQL.cn.prepareStatement(sql);
		cmd.setString(1, tendvmoi);
		cmd.setString(2, madv);
		cmd.executeUpdate();
	}
	public static void main(String[] args) {
		try {
			BuoiHoc1SQL bh = new BuoiHoc1SQL();
			bh.HienThi();
			bh.TimHoTen("Lê");
			System.out.println(bh.XoaDv("DV02"));
			bh.SuaDV("001", "Khoa Anh");
		} catch (Exception e) {
// TODO: handle exception
			e.printStackTrace();
		}
	}
}
