package lab5;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class hashmap{

public static void main(String args[]) {
	
        int pos=0;
		 Scanner reader=new Scanner(System.in);
		 HashMap<String, Double> hm = new HashMap<String,Double>();
		 System.out.println("enter number of mountains");
		int n=reader.nextInt();
		String []a=new String[n];
		for(int i=0;i<n;i++)
		{	System.out.println("enter name   of mountain"+(i+1));
			 String val=reader.next();
			 a[i]=val;
			 System.out.println("enter height of mountain"+(i+1));
			 Double h=reader.nextDouble();
			 hm.put(a[i],new Double (h));
		}
		
for(int i=0;i<n;i++)
{
	double max=hm.get(a[i]);
	for(int j=i;j<n;j++)
	{
	if(hm.get(a[j])>max)
	{
		
		 pos=j;
	}
	
	}
	double temp=hm.get(a[pos]);
	 hm.put(a[pos],max);
	 hm.put(a[i],temp);
	 System.out.println("mountain " +a[pos]+" height "+temp);
	
}
}
}


	

	
	 
	 

	 
		
	
	
		

FileReader fr2=new FileReader(s2);
FileReader fr3=new FileReader(s3);
BufferedReader br1=new BufferedReader(fr1);
BufferedReader br2=new BufferedReader(fr2);

		
	
	
		
	



