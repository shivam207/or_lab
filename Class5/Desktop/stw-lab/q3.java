import java.util.Scanner;
 public class q3
 {
 public static void main(String[ ] args) 
{ int n,fact=1;
Scanner input = new Scanner(System.in);
System.out.println("enter an integer");
 n= input.nextInt( );
for(int i=n;i>0;i--)
{
fact=fact*i;
}
System.out.println("factorial of number is ="+fact);
}
}
