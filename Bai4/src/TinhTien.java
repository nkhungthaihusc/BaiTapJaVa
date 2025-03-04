import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TinhTien {
	int LoaiXe;
	String BienSoXe;
	String SoVeXe;
	String ThoiGianVao;
	String ThoiGianRa;
	public String getTinhTrangXeVao() {
		return TinhTrangXeVao;
	}
	public void setTinhTrangXeVao(String tinhTrangXeVao) {
		TinhTrangXeVao = tinhTrangXeVao;
	}
	public String getTinhTrangXeRa() {
		return TinhTrangXeRa;
	}
	public void setTinhTrangXeRa(String tinhTrangXeRa) {
		TinhTrangXeRa = tinhTrangXeRa;
	}
	public int getTongtien() {
		return tongtien;
	}
	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}

	String TinhTrangXeVao;
	String TinhTrangXeRa;
	int tongtien;
	static DateTimeFormatter formater = DateTimeFormatter.ofPattern("H:mm dd/MM/yyyy");
	@Override
	public String toString() {
		return "TinhTien [LoaiXe=" + LoaiXe + ", BienSoXe=" + BienSoXe + ", SoVeXe=" + SoVeXe + ", ThoiGianVao="
				+ ThoiGianVao + ", ThoiGianRa=" + ThoiGianRa + "]";
	}
	public int getLoaiXe() {
		return LoaiXe;
	}
	public void setLoaiXe(int loaiXe) {
		LoaiXe = loaiXe;
	}
	public String getBienSoXe() {
		return BienSoXe;
	}
	public void setBienSoXe(String bienSoXe) {
		BienSoXe = bienSoXe;
	}
	public String getSoVeXe() {
		return SoVeXe;
	}
	public void setSoVeXe(String soVeXe) {
		SoVeXe = soVeXe;
	}
	public String getThoiGianVao() {
		return ThoiGianVao;
	}
	public void setThoiGianVao(String thoiGianVao) {
		ThoiGianVao = thoiGianVao;
	}
	public String getThoiGianRa() {
		return ThoiGianRa;
	}
	public void setThoiGianRa(String thoiGianRa) {
		ThoiGianRa = thoiGianRa;
	}
	
	public Object ThanhTien() {
		LocalDateTime vao = LocalDateTime.parse(ThoiGianVao , formater);
		LocalDateTime ra = LocalDateTime.parse(ThoiGianRa , formater);
		long giatong = 0;
		Duration duration = Duration.between(vao, ra);
		long tongsophut = duration.toMinutes();
		if(LoaiXe == 4) {
			long gia = 5000;
			if(TinhTrangXeVao.equalsIgnoreCase(TinhTrangXeRa)) return "Chua xac dinh - Dang xu ly boi thuong";
			else {
				long a =(long) Math.ceil(tongsophut / 30.0);
				giatong = a * gia;
			}
		}
		else if(LoaiXe == 2) {
			long gia = 3000;
			long a = (long) Math.ceil(tongsophut / (60 * 24.0));
			giatong = a * gia;
		}
		else {
			long gia = 1000;
			long a = (long) Math.ceil(tongsophut / (60 * 24.0));
			giatong = a * gia;
		}
		return giatong;
	}
}
