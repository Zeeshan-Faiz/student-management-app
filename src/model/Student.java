package model;

public class Student {

	private int rollNumber;
	private String name;
	private String collegeName;
	private String city;
	private double percentage;
	
	public Student(){
		
	}
	
	//Constructor for MySQl DB, where roll_number will be auto incremented
	public Student(String name, String collegeName, String city, double percentage) {
		super();
		this.name = name;
		this.collegeName = collegeName;
		this.city = city;
		this.percentage = percentage;
	}

	//constructor for our java code.
	public Student(int rollNumber, String name, String collegeName, String city, double percentage) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.collegeName = collegeName;
		this.city = city;
		this.percentage = percentage;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", collegeName=" + collegeName + ", city="
				+ city + ", percentage=" + percentage + "]";
	}
	
	
}
