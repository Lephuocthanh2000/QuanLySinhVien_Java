package Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	private static final String StudentFile = "C:\\Users\\ASUS\\Desktop\\Java_Servlet\\StudentManager\\ListStudent.txt";

	/**
	 * save list student to file
	 * 
	 * @param studentList: list student to save
	 */
	public void write(List<Student> studentList) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(new File(StudentFile));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(studentList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeStream(fos);
			closeStream(oos);
		}
	}

	public List<Student> read() {
		List<Student> studentList = new ArrayList<>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(new File(StudentFile));
			ois = new ObjectInputStream(fis);
			studentList = (List<Student>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeStream(fis);
			closeStream(ois);
		}
		return studentList;
	}

	private static void closeStream(InputStream is) {
		// TODO Auto-generated method stub
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void closeStream(OutputStream os) {
		// TODO Auto-generated method stub
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
