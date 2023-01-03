import java.util.Comparator;

public class SortSachByTheLoai implements Comparator<Sach> {



	@Override
	public int compare(Sach o1, Sach o2) {
		// TODO Auto-generated method stub
		return o1.getTheLoai().compareTo(o2.getTheLoai());
	}
}
