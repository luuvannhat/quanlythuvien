import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SachManager {
	private static final String SACH_FILE_NAME = "G://JAVA_SPRING_WEB//";
	public static Scanner sc = new Scanner(System.in);
	public List<Sach> sachList;
	private SachDao sachDao;

	public SachManager() {
		SachDao sachDao = new SachDao();
		sachList = sachDao.read();

	}

	public List<Sach> getSachList() {
		return sachList;
	}

	public void setSachList(List<Sach> sachList) {
		this.sachList = sachList;
	}

	public void Show() {
		for (Sach sach : sachList) {
			System.out.format("%-1s; %10s; %10s; %10s; %5s ", sach.getMaSach(), sach.getTenSach(), sach.getTheLoai(),
					sach.getTenTacGia(), sach.getNamSX());
			System.out.println("\n");

		}
	}

	public void sortSachByTheLoai() {
		Collections.sort(sachList, new SortSachByTheLoai());
	}

	public void add() {
		int maSach = (sachList.size() > 0) ? (sachList.size() + 100) : 1;

		System.out.println("Mã sách tiếp theo = " + maSach);
		System.out.println("Nhập tên sách:");
		String tenSach = sc.nextLine();
		System.out.println("Nhập thể loại sách:");
		String theLoai = sc.nextLine();
		System.out.println("Nhập tên tác giả:");
		String tenTG = sc.nextLine();
		System.out.println("Nhập năm sản xuất:");
		String namSX = sc.nextLine();

		String id = Integer.toString(maSach);
		Sach sach = new Sach(id, tenSach, theLoai, tenTG, namSX);
		sachList.add(sach);

//		sachDao.Write(sachList);

		File outputTXT = new File(SACH_FILE_NAME + "book_data.txt");
		FileWriter fWriter = null;
		BufferedWriter buffW = null;
		try {

			//
			fWriter = new FileWriter(outputTXT);
			buffW = new BufferedWriter(fWriter);

			for (Sach sach1 : sachList) {
				buffW.write(sach1.getMaSach() + "; " + sach1.getTenSach() + "; " + sach1.getTheLoai() + "; "
						+ sach1.getTenTacGia() + "; " + sach1.getNamSX());
				buffW.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				if (buffW != null)
					buffW.close();

			} catch (Exception e2) {

			}
		}
	}

	public void delete(String maSach) {

		Sach sach = null;
		int size = sachList.size();

		for (int i = 0; i < size; i++) {
			if (sachList.get(i).getMaSach().equalsIgnoreCase(maSach)) {
				sach = sachList.get(i);
				break;

			}
		}
		if (sach != null) {
			sachList.remove(sach);

			//
			File outputTXT = new File(SACH_FILE_NAME + "book_data.txt");
			FileWriter fWriter = null;
			BufferedWriter buffW = null;
			try {

				//
				fWriter = new FileWriter(outputTXT);
				buffW = new BufferedWriter(fWriter);

				for (Sach sach1 : sachList) {
					buffW.write(sach1.getMaSach() + "; " + sach1.getTenSach() + "; " + sach1.getTheLoai() + "; "
							+ sach1.getTenTacGia() + "; " + sach1.getNamSX());
					buffW.newLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {

					if (buffW != null)
						buffW.close();

				} catch (Exception e2) {

				}
			}

		} else {
			System.out.println(maSach + " không tìm thấy!!!!");
		}
	}

	public void searchMaSach(String maSach) {
		System.out.println("\nThông tin ma sach " + maSach + " là :");
		for (int i = 0; i < sachList.size(); i++) {
			if (sachList.get(i).getMaSach().trim().equalsIgnoreCase(maSach)) {
				
				System.out.println(
						"\nMã sách: " + sachList.get(i).getMaSach() + "; Tên sách: " + sachList.get(i).getTenSach()
								+ "; Thể loại: " + sachList.get(i).getTheLoai() + "; Tên tác giả: "
								+ sachList.get(i).getTenTacGia() + "; Năm sản xuất: " + sachList.get(i).getNamSX());
				break;
			}
		}
		

	}

	public void searchTenTacGia(String tenTG) {
		System.out.println("\nThông tin sách có tên tác giả " + tenTG + " là:");
		for (int i = 0; i < sachList.size(); i++) {
			if (sachList.get(i).getMaSach().trim().equalsIgnoreCase(tenTG)) {
				
				System.out.println(
						"\nMã sách: " + sachList.get(i).getMaSach() + "; Tên sách: " + sachList.get(i).getTenSach()
								+ "; Thể loại: " + sachList.get(i).getTheLoai() + "; Tên tác giả: "
								+ sachList.get(i).getTenTacGia() + "; Năm sản xuất: " + sachList.get(i).getNamSX());
				break;
			}
		}
	}
	
	public void searchTenSach(String tenSach) {
		System.out.println("\nThông tin tên sach " + tenSach + " là :");
		for (int i = 0; i < sachList.size(); i++) {
			if (sachList.get(i).getMaSach().trim().equalsIgnoreCase(tenSach)) {
				
				System.out.println(
						"\nMã sách: " + sachList.get(i).getMaSach() + "; Tên sách: " + sachList.get(i).getTenSach()
								+ "; Thể loại: " + sachList.get(i).getTheLoai() + "; Tên tác giả: "
								+ sachList.get(i).getTenTacGia() + "; Năm sản xuất: " + sachList.get(i).getNamSX());
				break;
			}
		}
	}
}
