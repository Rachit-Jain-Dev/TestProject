package selenium;
import java.util.Scanner;
public class AscOrderNumber {
	public static void main(String[] args) {
		System.out.println("Enter a Number");
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int Arr[] = new int[10];
		int temp=a, rem, i=0;
		while(temp>0){
			rem=temp%10;
			Arr[i]=rem;
			i++;
			temp=temp/10;
		}
		int Arr1[] = new int[i];
		
		for(i=0;i<Arr1.length;i++)	//Resizing the Array as Arr[] is containing other elements as 0
			Arr1[i]=Arr[i];
		
		System.out.println("Number after Sorting: -");
		bubbleSort(Arr1);			//Static method calling
		for(i=0;i<Arr1.length;i++)	
			System.out.print(Arr1[i]);
		
		System.out.println("\n\nNumber after removing duplicates: -");
		AscOrderNumber aon = new AscOrderNumber();
		int Arr2[] = aon.removeDuplicates(Arr1);	//Non-Static method calling
		for(i=0;i<Arr2.length;i++)	
			System.out.print(Arr2[i]);
	}
	
	public static void bubbleSort(int arr[]){
		int n=arr.length, temp;
		for(int i=0; i<n-1; i++){
			for(int j=0; j<n-i-1; j++){
				if(arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	//155332
	public int[] removeDuplicates(int arr[]){
		int i,j=0,n=arr.length,z=0;
		arr[j]=arr[0];
		for(i=0;i<n;i++){
			if(arr[j]!=arr[i]){
				j++;
				arr[j]=arr[i];
			}
		}
		//System.out.println(j);
		int arr2[] = new int[j+1];
		for(int m=0; m<j+1; m++){
			arr2[m]=arr[m];
		}
		return arr2;
	}
}
