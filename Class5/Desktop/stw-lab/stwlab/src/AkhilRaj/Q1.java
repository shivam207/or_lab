package AkhilRaj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Q1 {
public static void main(String args[])
{
	
	System.out.println(findUnique_file("test.txt"));
	
}

static char findUnique (String s){
	
	int count = 1, i = 0;
	char c = '?';
	

		for(i = 0; i < (s.length()); i++)
		{
			count = 0;
			c = s.charAt(i);
			for(int j = 0; j < s.length(); j++)
			if(c == s.charAt(j) && j != i)
				{
				
				count = 1;
				
				}
			if(count == 0)
				break;
		}
		
	
	
	if(count == 0)
		return c;
	else
		return '?';
	
}


static String findUnique_file ( String fileName)
{
	
	ArrayList<Character>ch = new ArrayList<Character>();
	String ans;
	try{
		File file = new File(fileName);
		
		String line;
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		while((line = br.readLine()) != null)
		{
		ch.add(findUnique(line));
		}
		
		br.close();
		}catch(Exception e)
	{
		
		return "File not found !";
		
	}
	
	ans = ch.toString();
	return ans;
}

}
