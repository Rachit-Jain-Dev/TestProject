package selenium;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		float a,b;
		String oper;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 1st no");
		a = s.nextFloat();
		System.out.println("Enter 2nd no");
		b = s.nextFloat();
		
		System.out.println("Select aithmetic operation from the following: -\n1. Add\n2. Sub\n3. Mul\n4. Div");
		oper = s.next();
		
		switch(oper){
			case "Add": System.out.println("The Addition of 2 numbers: "+(a+b));
				break;
			case "Sub": System.out.println("The Subtract of 2 numbers: "+(a-b));
				break;
			case "Mul": System.out.println("The Multiply of 2 numbers: "+(a*b));
				break;
			case "Div": System.out.println("The Division of 2 numbers: "+(a/b));
				break;
		}
	}

}
