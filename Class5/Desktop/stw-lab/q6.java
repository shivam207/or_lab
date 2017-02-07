import java.util.Scanner;
 public class q6
 {
 public static void main(String[ ] args) 
{
int a,b,ch;
float r;
Scanner input = new Scanner(System.in);
System.out.println("enter first number");
a=input.nextInt( );
System.out.println("enter second number");
b=input.nextInt( );
System.out.println("Operation Menu:");
System.out.println("1.addition");
System.out.println("2.subtraction");
System.out.println("3.multiplication");
System.out.println("4.division");
System.out.println("enter choice");
 ch=input.nextInt( );
switch(ch)
{
case 1: r=a+b;
       System.out.println("sum of the numbers is:"+r);
       break;
case 2: r=a-b;
       System.out.println("difference of the numbers is:"+r);
       break;
case 3: r=a*b;
       System.out.println("product of the numbers is:"+r);
       break;
case 4:r=a/b;
       System.out.println("ratio of the numbers is:"+r);
       break;
default: System.out.println("\n Wrong choice entered");
}
}
}

