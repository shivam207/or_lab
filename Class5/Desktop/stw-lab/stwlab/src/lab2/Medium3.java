package lab2;

import java.util.Scanner;

public class Medium3 {
	public static void main(String[ ] args)
	{ int []a;int s=0;
		Scanner input = new Scanner(System.in);
	  System.out.println("enter size of array");
	  int n;
	  n= input.nextInt( );
	  a = new int[n];
	  for(int i=0;i<n;i++)
		{ System.out.println("enter element"+(i+1));
			a[i]=input.nextInt( );
		}
	  for(int i=0;i<n;i++)
	  { if(a[i]==0)
	  { s++;}
	  }
	  if(s>n/2)
	System.out.println("array is sparse");
	  else {System.out.println("array is not sparse");}
		  
	}

}
