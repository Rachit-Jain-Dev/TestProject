package selenium;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		System.out.println("Enter a Year");
		Scanner s = new Scanner(System.in);
		int temp=0;
		int year = s.nextInt();
		if(year%4==0){
			if(year%100==0){
				if(year%400==0){
					temp=1;
				}
			}
			else
				temp =1;
		}
		if(temp==1)
			System.out.println("It is a Leap Year");
		else
			System.out.println("It is not a Leap Year");
	}

}
