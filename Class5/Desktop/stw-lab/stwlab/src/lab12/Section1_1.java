package lab12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Section1_1 {
	public static void main(String[] args){
		Scanner reader=new Scanner(System.in);
		String s1,s2,s3,s;
		System.out.println("enter name of the files");
		s1=reader.next();
		s2=reader.next();
		s3=reader.next();
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
		try{
			File f1=new File(s1);
			if(!f1.exists()){
				System.out.println("file does not exist");
				return;
			}
			File f2=new File(s2);
			if(!f2.exists()){
				System.out.println("file does not exist");
				return;
			}
			File f3=new File(s3);
			if(!f3.exists()){
				System.out.println("file does not exist");
				return;
			}
			FileReader fr1=new FileReader(s1);
			FileReader fr2=new FileReader(s2);
			PrintWriter pw=new PrintWriter(s3);
			BufferedReader br1=new BufferedReader(fr1);
			BufferedReader br2=new BufferedReader(fr2);

			while((s=br1.readLine())!=null){
				pw.println(s);

			}
			while((s=br2.readLine())!=null){
				pw.println(s);

			}
			pw.flush();
			pw.close();

			System.out.println("file 3 after concatenation");
			fr1=new FileReader(s3);
			br1=new BufferedReader(fr1);
			while((s=br1.readLine())!=null){
				System.out.println(s);

			}


		}
		catch(IOException e){
			System.out.println("error,file does not exist");
		}


	}

}
