import java.util.Comparator;
public class MyComparator1 implements Comparator{
	public int compare(Object arg0, Object arg1) {
		Student s1 = (Student)arg0;
		String I1 = s1.Name;
		Student s2 = (Student)arg1;
		String I2 = s2.Name;
		return I1.compareTo(I2);
	}
}
