import java.util.Scanner;
 public class q5
 {
 public static void main(String[ ] args) 
{ int a,b,,r=1;
Scanner input = new Scanner(System.in);
System.out.println("enter a");
 a=input.nextInt( );
System.out.println("enter b(<a)");
b=input.nextInt( );
while(r!=0)
{
 r=a%b;
a=b;
b=r;
}
System.out.println("gcd="+a);

String s=reader.nextLine();



