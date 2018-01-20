package selenium;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int temp, sum, lastDigit;
		System.out.println("Below are the Armstrong Numbers in between 100 and 1000: -");
		for(int i=100; i<=1000;i++){
			temp=i;											//Getting an actual no into temp variable 
			sum=0;											//Starting sum=0 for every new no
			while(temp>0){									//Loop till temp becomes 0
				lastDigit=temp%10;							//setting the variable to lastDigit
				sum=sum+(lastDigit*lastDigit*lastDigit);	//Getting sum of cubes of every digit in the no
				temp=temp/10;								//Removing the last digit from the temp variable
			}
			if(sum==i){										//verifying it is Armstrong Numbers or not						
				System.out.print(i+" ");
			}
		}
	}

}
