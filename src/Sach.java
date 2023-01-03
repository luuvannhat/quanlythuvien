import java.io.Serializable;
import java.util.Comparator;

public class Sach implements Serializable{
	private String maSach, tenSach, theLoai, tenTacGia;
	private String namSX;
	
	public Sach(String maSach, String tenSach, String theLoai, String tenTacGia, String namSX) {
		
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.theLoai = theLoai;
		this.tenTacGia = tenTacGia;
		this.namSX = namSX;
	}
	public Sach() {
	
		
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	public String getNamSX() {
		return namSX;
	}
	public void setNamSX(String namSX) {
		this.namSX = namSX;
	}
	public String getTheLoai() {
		return theLoai;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%-5s %-15s %-10s %-15s %5s", maSach, tenSach, theLoai,tenTacGia,namSX);
	}


	
	
	
	

}
