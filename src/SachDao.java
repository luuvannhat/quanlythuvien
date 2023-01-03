import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SachDao {
	private static final String SACH_FILE_NAME = "G://JAVA_SPRING_WEB//";

	public void Write(List<Sach> sachList) {


		//

		File outputTXT = new File(SACH_FILE_NAME + "book_data.txt");
		FileWriter fWriter = null;
		BufferedWriter buffW = null;
		try {

			//
			fWriter = new FileWriter(outputTXT);
			buffW = new BufferedWriter(fWriter);

			for (Sach sach : sachList) {
				buffW.write(sach.getMaSach()+"; "+sach.getTenSach()+"; "+sach.getTheLoai()+"; "+sach.getTenTacGia()+"; "+sach.getNamSX());
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

	public List<Sach> read() {
		List<Sach> sachList = new ArrayList<>();
		File inputTxt = new File(SACH_FILE_NAME + "book_data.txt");
		FileReader fReader = null;
		BufferedReader bufferR = null;
		try {
			fReader = new FileReader(inputTxt);
			bufferR = new BufferedReader(fReader);

			// doc theo tung dong
			String line;
			while ((line = bufferR.readLine()) != null) {
				String[] parts = line.split(";");
//				int namSX = Integer.parseInt(parts[4]);
				Sach sach = new Sach(parts[0], parts[1], parts[2], parts[3], parts[4]);
				sachList.add(sach);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferR != null)
					bufferR.close();

			} catch (Exception e2) {

			}
		}
		return sachList;
	}

}
