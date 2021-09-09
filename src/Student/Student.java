package Student;

import java.io.Serializable;

public class Student implements Serializable {
	// Khai báo thuộc tính
	private int id;
	private String name;
	private String age;
	private String address;
	private double gpa;

	// Khơi tạo hàm
	public Student() {

	}

	public Student(int id, String name, String age, String address, double gpa) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.gpa = gpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

}
