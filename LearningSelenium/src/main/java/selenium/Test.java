package selenium;
import java.util.Comparator;
import java.util.TreeSet;

public class Test{
	public static void main(String args[]){
		TreeSet t = new TreeSet();
		t.add(new Class1(5,"R"));		t.add(new Class1(2,"N"));		t.add(new Class1(1,"P"));
		t.add(new Class1(4,"Z"));		t.add(new Class1(3,"A"));
		System.out.println(t);
		
		TreeSet t1 = new TreeSet(new Class2());
		t1.add(new Class1(5,"R"));		t1.add(new Class1(2,"N"));		t1.add(new Class1(1,"P"));
		t1.add(new Class1(4,"Z"));		t1.add(new Class1(3,"A"));
		System.out.println(t1);
	}
		
}
class Class1 implements Comparable{
	int id;
	String name;
	public Class1(int i, String n){
		id=i;
		name=n;
	}
	public String toString(){
		return id+"--"+name;
	}
	public int compareTo(Object ob1) {
		Class1 t1=(Class1)ob1;
		int id1 = t1.id;
		if(id<id1)
			return -2;
		else if(id>id1)
			return 1;
		else
			return 0;
	}
}
class Class2 implements Comparator{
	public int compare(Object ob1, Object ob2) {
		Class1 t1=(Class1)ob1;
		Class1 t2=(Class1)ob2;
		return (t1.name).compareTo(t2.name);
	}

}