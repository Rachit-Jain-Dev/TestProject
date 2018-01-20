package day2;

class Class2 {	
	public static <T> void printArray(T[] genArray){
		for (T arry : genArray) {
			System.out.print(arry+" ");
		}
		System.out.println();
	}
	
	public static void main(String []args){
		Integer a[] ={1,2,3,4,5};
		Double b[] ={1.1,2.2,3.3,4.4,5.5};
		Character c[] = {'a','b','c','d','e'};
		printArray(a);
		printArray(b);
		printArray(c);
		
	}
}
