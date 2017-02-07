package lab12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Section1_2 {
	public static void main(String[] args){
		Scanner reader=new Scanner(System.in);
		File f1=new File("f1");
		char ch;
		String s;
		int count=0;
		try{
			if(!f1.exists()){
				System.out.println("file does not exist");
				return;
			}
//			else System.out.println(f1.getAbsolutePath());
			 FileReader fr1=new FileReader(f1);
			BufferedReader br1=new BufferedReader(fr1);
			System.out.println("enter character to be searched");
			char ch2=reader.next().charAt(0);
			
			while((s=br1.readLine())!=null)
			{
//				System.out.println(s);
				
				for(int i=0;i<s.length();i++)
				{
					
					ch=s.charAt(i);
				
					
					if(ch==ch2){
						count++;}

				}
			} 
			System.out.println("number of e's="+count)	;

			br1.close();

		}
		catch(IOException e){
			System.out.println("error");
		}
	}
}

