import java.util.Scanner;
 public class q7
 {
 public static void main(String[ ] args) 
{ int n,i;
Scanner input = new Scanner(System.in);
System.out.println("enter an integer");
 n=input.nextInt( );
for(i=2;i<n;i++)
{
if(n%i==0)
{
 System.out.println("number is not prime");
break;
}
}
if(i==n)
System.out.println("number is prime");
}
}

