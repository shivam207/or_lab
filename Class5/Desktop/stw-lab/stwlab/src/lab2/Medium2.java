package lab2;
import java.util.Scanner;
public class Medium2 
{
	public static void main(String[ ] args)
	{ float []a;int flag=0;
	Scanner input = new Scanner(System.in);
	System.out.println("enter size of array");
	int n;
	n= input.nextInt( );
	a = new float[n];
	for(int i=0;i<n;i++)
	{ System.out.println("enter element"+(i+1));
		a[i]=input.nextFloat( );
	}
	for(int j=0;j<n;j++)
	{  
		for(int i=0;i+j+1<n;i++)
		
		{
	if(a[i+j+1]==a[j])
	{
		System.out.println("array does not contain distinct elements");
		flag=1;
		break;
	}
		}
		if(flag==1)
		{break;}

		
	}	if(flag==0)
		System.out.println("array does  contain distinct elements");
		
	
	}
	
}
	
	
		
	
	
	
	
