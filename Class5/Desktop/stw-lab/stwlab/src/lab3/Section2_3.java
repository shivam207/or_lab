package lab3;
import java.util.*;
public class Section2_3 {
	public static void main(String args[]) {
		int p,q,i;
	Scanner reader=new Scanner(System.in);
	 Stack<Integer> l = new Stack<Integer>();
	 Stack<Integer> m = new Stack<Integer>();
	 System.out.println("enter size of  m");
	 q=reader.nextInt( );
	 for(i=0;i<q;i++)
	 {  System.out.println("enter element "+(i+1)+ " of m");
	 int c=reader.nextInt( );
	 m.push(c);
	 }
	 System.out.println("enter size of  l");
	 p=reader.nextInt( );
	 for( i=0;i<p;i++)
	 {  System.out.println("enter element "+(i+1)+ " of l");
	 int c=reader.nextInt( );
	 l.push(c);
	 }
	 for( i=q;i<p+q;i++)
	 { int c=l.get(i-q);
	 m.push(c);
	  }
	 
	 
	
	  System.out.print(" " + m);
	 
	 
	 
	 
	 
	 
	 

}}
