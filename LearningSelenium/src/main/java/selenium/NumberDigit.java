package selenium;
import java.util.Scanner;

public class NumberDigit {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a Number");
		int Num = s.nextInt();
		System.out.println("Enter a Digit available in the number");
		int Digit = s.nextInt();
		int ActualNo=LargestValue(Num,Digit);
		System.out.println("The Largest No is: "+ActualNo);
	}
	public static int LargestValue(int No, int Dig){
		int Arr[] = new int[10];
		int TempNo = No;
		int i=0,j;
		while(No>0){
			int rem =No%10;
			Arr[i]=rem;
			i++;
			No=No/10;
		}
		int A[] = new int[i];
		for(j=0;j<i;j++){
			A[j]=Arr[j];
		}
		
		for(j=0;j<i;j++){
			if(A[j]==Dig){
				TempNo--;
				TempNo=LargestValue(TempNo,Dig);
				break;
			}
		}
		return TempNo;
	}
}
