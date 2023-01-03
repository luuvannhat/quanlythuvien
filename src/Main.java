import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static Scanner scanner = new Scanner(System.in);
	
	// đổi đường dẫn tại Main, SachDao, SachManager
	private static final String SACH_FILE_NAME = "G://JAVA_SPRING_WEB//";

	public static void main(String[] args) {

		// class SachDao để đọc và ghi file
		
		SachManager sachManager = new SachManager();
		String choose = null;
		boolean exit = false;

		// show menu
		showMenu();
		while (true) {
			choose = scanner.nextLine();
			switch (choose) {
			case "1":
				System.out.println("\n-----Sách trong thư viện được sắp xếp theo thể loại-----");
				sachManager.sortSachByTheLoai();
				sachManager.Show();
				System.out.println("========Sắp xếp kết thúc!!!!========\n");
				break;
			case "2":
				System.out.println("======Thêm sách mới=======");
				sachManager.add();
				sachManager.Show();
				System.out.println("========Thêm kết thúc=======\n");
				break;
			case "3":
				System.out.println("======Xóa 1 cuốn sách dựa theo mã sách=====");
				System.out.println("Nhập mã sách cần xóa:");
				String deleteMaSach = scanner.nextLine();
				sachManager.delete(deleteMaSach);
				sachManager.Show();
				System.out.println("===========Xóa kết thúc==========");
				break;
			case "4":
				System.out.println("Nhập mã sách để hiển thị thông tin:");
				String searchMaSach = scanner.nextLine();
				sachManager.searchMaSach(searchMaSach.trim());
				break;
				
				// chưa chạy được
			case "5":
				System.out.println("Nhập tên tác giả cần tìm:");
				String searchTenTG = scanner.nextLine();
				sachManager.searchTenTacGia(searchTenTG.trim());
				break;
				//chưa chạy được
			case "6":
				System.out.println("Nhập tên sách cần tìm:");
				String searchTenSach = scanner.nextLine();
				sachManager.searchTenSach(searchTenSach.trim());
				break;
			default:
				break;
			}
			showMenu();

		}

	}

	private static void showMenu() {
		System.out.println("----------menu---------");
		System.out.println("1.Hiển thị danh sách về các tựa sách có trong thư viện (sắp xếp theo thể loại)");
		System.out.println("2.Nhập thông tin cho các cuốn sách mới");
		System.out.println("3.Xóa 1 cuốn sách dựa trên mã sách");
		System.out.println("4.Tra cứu thông tin của cuốn sách dựa trên mã sách");
		System.out.println("5.Tìm kiếm sách dựa theo tên tác giả");
		System.out.println("6.Tìm kiếm sách dựa theo tên sách");
	}

}
