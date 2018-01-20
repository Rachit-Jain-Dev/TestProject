import java.util.Comparator;
public class MyComparator2 implements Comparator{
	public int compare(Object arg0, Object arg1) {
		//Student s1 = (Student)arg0;
		Integer I1 = (Integer)arg0; 
		Integer I2 = (Integer)arg1;
		if(I1<I2)	return +3;
		else if(I1>I2)	return -7;
		else	return 0;
	}
}
