package lab10;
import java.util.Scanner;
public class Section1_1 {
	public static void main (String args [ ] ) {
		Scanner input = new Scanner(System.in);
	String a;
	System.out.println("enter number");
	a=input.nextLine();
	try{
		int b=Integer.parseInt(a);
		System.out.println("number found  "+b);
		}
	catch(Exception e){
		System.out.println("something else found");
	}
}
}
