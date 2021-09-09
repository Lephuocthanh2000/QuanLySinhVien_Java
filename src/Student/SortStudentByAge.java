package Student;

import java.util.Comparator;

public class SortStudentByAge implements Comparator<Student>{
	@Override
	public int compare(Student st1, Student st2) {
		return (st1.getAge().compareTo(st2.getAge()));
	}
}
