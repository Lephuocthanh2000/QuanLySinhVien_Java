package Student;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
	public static Scanner scanner = new Scanner(System.in);
	private List<Student> studentList;
	private StudentDao studentDao;

	// Khởi tạo
	public StudentManager() {
		studentDao = new StudentDao();
		studentList = studentDao.read();
	}

	// thêm
	public void add() {
		int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
		System.out.println("student id = " + id);
		scanner.nextLine();
		String name = inputName();
		String age = inputAge();
		String address = inputAddress();
		double gpa = inputGpa();
		Student student = new Student(id, name, age, address, gpa);
		studentList.add(student);
		studentDao.write(studentList);
	}

	private double inputGpa() {
		// TODO Auto-generated method stub
		double gpa = 0;
		System.out.println("What is your gpa?");
		gpa = scanner.nextDouble();
		return gpa;
	}

	private String inputAge() {
		String age = "";
		System.out.println("What is your age?");
		age = scanner.nextLine();
		return age;
	}

	private String inputName() {
		// TODO Auto-generated method stub
		String name = "";
		System.out.println("What is your name?");
		name = scanner.nextLine();
		return name;
	}

	private String inputAddress() {
		// TODO Auto-generated method stub
		String address = "";
		System.out.println("Where is your address?");
		address = scanner.nextLine();
		return address;
	}

	/**
	 * edit student by id
	 * 
	 * @param id
	 */
	public void edit(int id) {
		boolean isExisted = false;
		int size = studentList.size();
		for (int i = 0; i < size; i++) {
			if (studentList.get(i).getId() == id) {
				isExisted = true;
				studentList.get(i).setName(inputName());
				studentList.get(i).setAge(inputAge());
				studentList.get(i).setAddress(inputAddress());
				studentList.get(i).setGpa(inputGpa());
				break;
			}
		}
		if (!isExisted) {
			System.out.printf("id = %d not existed.\n", id);
		} else {
			studentDao.write(studentList);
		}

	}

	/**
	 * delete student by id
	 * 
	 * @param id: student id
	 */
	public void delete(int id) {
		Student student = null;
		int size = studentList.size();
		for (int i = 0; i < size; i++) {
			if (studentList.get(i).getId() == id) {
				student = studentList.get(i);
				break;
			}
		}
		if (student != null) {
			studentList.remove(student);
			studentDao.write(studentList);
		} else {
			System.out.printf("id = %d not existed.\n", id);
		}
	}

	/**
	 * show list student to screen
	 */
	public void show() {
		for (Student student : studentList) {
			System.out.format("%d | ", student.getId());
			System.out.format("%20s | ", student.getName());
			System.out.format("%5s | ", student.getAge());
			System.out.format("%20s | ", student.getAddress());
			System.out.format("%10.1f%n", student.getGpa());
		}
	}

	/**
	 * sort student by name
	 */
	public void sortStudentByName() {
		Collections.sort(studentList, new SortStudentByName());
	}

	/**
	 * sort student by id
	 */
	public void sortStudentByGPA() {
		Collections.sort(studentList, new SortStudentByGPA());
	}
	/**
	 * sort student by age
	 */
	public void sortStudentByAge() {
		Collections.sort(studentList, new SortStudentByAge());
	}

	/**
	 * input student id
	 * 
	 * @return student id
	 */
	public int inputId() {
		System.out.print("Input student id: ");
		while (true) {
			try {
				int id = Integer.parseInt((scanner.nextLine()));
				return id;
			} catch (NumberFormatException ex) {
				System.out.print("invalid! Input student id again: ");
			}
		}
	}

}
