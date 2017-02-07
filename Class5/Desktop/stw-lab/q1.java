import java.util.Scanner;
 class q1
{
 public static void main(String[ ] args) 
{
 Scanner input = new Scanner(System.in);
 System.out.print("Enter First Number: ");
 int n = input.nextInt( );
 System.out.print("Enter Second Number(<n): ");
 int m = input.nextInt();
if(n%m==0)
System.out.println("true");
else
System.out.println("false");
}
}
