import java.util.Scanner;
 public class q4
 {
 public static void main(String[ ] args) 
{ int a,b,c,temp;
Scanner input = new Scanner(System.in);
System.out.println("enter a");
 a=input.nextInt( );
System.out.println("enter b");
b=input.nextInt( );
System.out.println("enter c");
c=input.nextInt( );
temp=a+b;
if(temp==c)
System.out.println("a+b=c");
else
System.out.println("a+b!=c");
temp=b-c;
if(temp==a)
System.out.println("a=b-c");
else
System.out.println("a!=b-c");
temp=a*b;
if(temp==c)
System.out.println("a*b=c");
else
System.out.println("a*b!=c");
}
}








