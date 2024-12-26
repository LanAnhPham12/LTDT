package Project_Nhom2;

import java.util.ArrayList;
import java.util.List;

public class ListPostOffice {
	private List<wayToPostOffice> postOffice;
	public String addPostOffice(String name, double x, double y) {
		wayToPostOffice postOffice = new wayToPostOffice(name, x, y);
		
		return name;
	}

	public ListPostOffice() {
	   postOffice = new ArrayList<>();
	   postOffice.add(new wayToPostOffice("Quan 9", 300.0, 212.1));
	   postOffice.add(new wayToPostOffice("Quan 8", 450.0, 475.9));
	   postOffice.add(new wayToPostOffice("Quan 7", 125.9, 546.2));
	   postOffice.add(new wayToPostOffice("Quan 6", 120.7, 251.5));
	   postOffice.add(new wayToPostOffice("Quan 5", 450.2, 452.1));
  }

	public List<wayToPostOffice> getPostOffices() {
		return postOffice;
	}

}
