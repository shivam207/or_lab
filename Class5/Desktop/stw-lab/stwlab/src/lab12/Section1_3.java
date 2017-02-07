package lab12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Section1_3 {
	public static void main(String[] args){
		Scanner reader=new Scanner(System.in);
		File f1=new File("f4");
		char ch;
		String s;int sum=0;

		try{
			if(!f1.exists()){
				System.out.println("file does not exist");
				return;
			}
			 FileReader fr1=new FileReader(f1);
			BufferedReader br1=new BufferedReader(fr1);
			while((s=br1.readLine())!=null)
			{
              for(int i=0;i<s.length();i++)
				{
					
					ch=s.charAt(i);
				   if(ch!=',')
				   {
					int j=ch;
					sum+=j;

				}
			} System.out.println("sum="+sum);
			}
          br1.close();

		}
		catch(IOException e){
			System.out.println("error");
		}
	}
}
