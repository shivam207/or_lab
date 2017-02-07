package lab10;
import java.util.*;
public class Section1_2 
{
	static float squareroot(int x)  {
		float a;
		if(x<0){
			System.out.println("enter positive number");
			return -1;
		}
	   a=(float) Math.sqrt(x);
			
		return a;
       }
		


	public static void main (String args [ ] ) throws Exception {
		Scanner input = new Scanner(System.in);
		String i;
		 float r;
		int b;
		 do{
			 System.out.println("enter number whose squareroot is to be calculated");
			 
		   try{
			   i=input.nextLine();
				 b=Integer.parseInt(i);
			 r=squareroot(b);
		   }  
	
		   catch(Exception e){
			   r=-1;
		        System.out.println (" number not found");}
		  
		}while(r==-1);
		 System.out.println("squareRoot="+r);
}
}
