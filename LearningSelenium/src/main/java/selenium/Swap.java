package selenium;


public class Swap {

	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();
		
		t1.staticVar=t1.instantVar+1;	//staticVar=11
		System.out.println(t2.staticVar);//11
		System.out.println(t3.staticVar);//11
		
		t1.instantVar=t1.staticVar+9;	//20
		System.out.println(t1.instantVar);//20
		System.out.println(t2.instantVar);//10
		System.out.println(t3.instantVar);//10
		
		System.out.println(t1.increament());//51
		System.out.println(t2.increament());//41
		System.out.println(t3.increament());//41
	}

}
