package lab11;


import java.util.Iterator;
import java.util.Scanner;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.DepthFirstIterator;


public class Section1_3 { public static void main(String [] args)

{
	Scanner input = new Scanner(System.in);
UndirectedGraph<Integer, DefaultEdge>
aGraph = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
System.out.println("Enter number of vertices");
int n=input.nextInt();
for(int i=1;i<=n;i++)
{
	 aGraph.addVertex(i);
}


	String ch;

	do{
		int i ,j;
		System.out.println("enter edges");
		i=input.nextInt();
		j=input.nextInt();
		if(i!=j) aGraph.addEdge(i,j);
		System.out.println("do you want to enter more edges (y/n for yes or no respectively)");
		ch=input.next();
		 }while(ch.equals("y"));

		System.out.println(aGraph.toString());
int degmax=aGraph.degreeOf(1);
int v=1;
for(int i=2;i<=n;i++)
{
	if(degreeOf(i)>degmax)
	{
		degmax=degreeOf(i);
		v=i;  
    }
}

System.out.println("node"+v+"has highest degree ehich is equal to "+degmax);
	

		  

		 

		  
	 }

	 

	 static int degreeOf(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	 




}
