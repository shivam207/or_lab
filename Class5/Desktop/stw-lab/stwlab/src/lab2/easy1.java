package lab2;

import java.util.Scanner;

public class easy1 {
	public static void main(String[ ] args)
	{
		Scanner input = new Scanner(System.in);
		 int [ ]a ;
		int x,max=0;
		 a = new int[10];
		 for(x=0;x<10;x++)
		 {
		 System.out.println("enterinteger"+(x+1));
		 a[x]= input.nextInt( );
		 if(a[x]>max)
		 {
			 max=a[x];
		 }
		 
		 }
		 System.out.println("maximum="+max);
		 
	}
		}
