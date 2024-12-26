package Project_Nhom2;

public class wayToPostOffice {
	private String name;
	private double x;
	private double y;
	
	public wayToPostOffice(String name, double x, double y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	//tinh khang cach giua hai diem buu dien
	public double distanceTo(wayToPostOffice ortherPostOffice) {
		// TODO Auto-generated method stub
		double deltaX = ortherPostOffice.getX() - x;
		double deltaY = ortherPostOffice.getY() - y;
		return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	
	}

	@Override
	public String toString() {
		return "wayToPostOffice [name=" + name + ", x=" + x + ", y=" + y + "]";
	}

	
	
}
