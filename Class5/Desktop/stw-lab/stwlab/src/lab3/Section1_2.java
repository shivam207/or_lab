package lab3;
import java.util.Scanner;
import java.util.LinkedList;

class Section1_2 {
public static void main(String args[]) {
	int p,q;
	Scanner reader=new Scanner(System.in);
	
	LinkedList<String>l=new LinkedList<String>();
	LinkedList<String>m=new LinkedList<String>();
	System.out.println("enter size of list l");
	p=reader.nextInt( );
	System.out.println("enter nodes of list l");
	for(int i=0;i<p;i++)
		{ String val=reader.next();
		l.add(i,val );
		
		}
	System.out.println("Original l: "+l);
	System.out.println("enter size of list m");
	q=reader.nextInt( );
	System.out.println("enter nodes of list m");
	for(int i=0;i<q;i++)
	{ String val=reader.next();
		m.add(i,val );
		
	}
		System.out.println("Original m: "+m);
		for(int i=p;i<p+q;i++)
		{	String val=m.get(i-p);
			l.add(i,val);
		}
		
	System.out.println("concated list: "+l);
	 
}}
