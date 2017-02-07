package lab5;
import java.util.Scanner;
public class sum {
	public static void main(String[ ] args)
	{
    Scanner reader=new Scanner(System.in);
	int n,sum=0;
	do{
		 System.out.println("enter number");
		 n=reader.nextInt();
		 sum=sum+n;
	}while(n!=0);
	 System.out.println("sum="+sum);
} 
}
