package selenium;
import java.util.Scanner;
public class Factorial {
	public static void main(String[] args) {
		System.out.println("Please enter a number: ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int fact=1;
		for(int i=n;i>0;i--){
			fact=fact*i;
		}
		System.out.println("The Factorial of the entered no is: "+fact);
	}
}
