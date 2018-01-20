package selenium;

import java.util.Scanner;
public class LongestPositiveNo {
	public static void main(String[] args) {
		int i,j=1,m=0,k=0,z;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the length of the series");
		int n = s.nextInt();	
		int A[] = new int[n];
		System.out.println("Enter the series of "+n+" elements:");
		for(i=0;i<n;i++){
			A[i]=s.nextInt();
		}
		for(i=0;i<n-1;i++){
			if((A[i]+1==A[i+1])&&(A[i]>=0) && (A[i+1]>=0)){
				j++;
				if((i==n-2)&&(j>m)){	//this is code when longest series are present at last of the Array
					m=j;		
					j=1;		
					k=i-m+2;
				}
			}
			else if(j>m){
				m=j;		//Length
				j=1;		//Initilize once again
				k=i-m+1;		//saving the 1st element series position
			}
		}
		System.out.println("The Longest series is:");
		for(z=k;z<k+m;z++){
			System.out.print(A[z]+" ");
		}
	}
}
