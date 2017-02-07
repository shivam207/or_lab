package mathmisc;
import java.util.Scanner;
public class perfect {
	public static void main(String[ ] args){
		Scanner reader=new Scanner(System.in);
		int n,sum=0;
		 System.out.println("enter number");
		n=reader.nextInt();
		for(int i=1;i<n;i++)
		{if(n%i==0)
			sum=sum+i;
		}
		if(sum==n)
	    System.out.println("number is perfect");
		else
			 System.out.println("number is not perfect");	
			
	}

}
