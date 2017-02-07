package lab2;
import java.util.Scanner;
public class easy2 
{
	public static void main(String[ ] args)
	{ String []a;String temp;
	a = new String[5];
	Scanner reader=new Scanner(System.in);
	for(int x=0;x<5;x++)
	{
		System.out.println("enter string "+(x+1));
		a[x]=reader.nextLine();
	}
	for(int j=0;j<5;j++)
	{
		for(int i=0;i+j<5;i++)
		{
			int check=a[i+j].compareTo(a[j]);
			if(check<0)
			{temp=a[j];
			a[j]=a[i+j];
			a[i+j]=temp;
			}

		}

	}System.out.println(" sorted strings");
	for(int x=0;x<5;x++)
	{
		System.out.println(a[x]);
	}
	}
}














