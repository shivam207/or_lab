package lab7;

import java.util.Scanner;
public class BSTex<T extends Comparable<T>>extends BST<T>{
	
	
	void FindParent(Node<T> node,T x){
		if(node!=null)
		{if((node.left!=null)&&(node.left.data==x))
			System.out.println(node.data);
		if((node.right!=null)&&(node.right.data==x))
			System.out.println(node.data);
		 FindParent(node.left,x);
		FindParent(node.right,x);
		}
		}
	 int max(Node N){
		int a,b,m;
		if(N!=null)
		{
		a=max(N.left);
		b=max(N.right);
		if(a>b)
			m=a;
		else
			m=b;
		if(m>(int)N.data)
			return m;
		else
			return (int)N.data;
		
			}
		else return 0;
	}
	 int min(Node N){
			int a,b,m=(int)N.data;
			if(N!=null)
			{
			a=min(N.left);
			b=min(N.right);
			if(a<b)
				m=a;
			else
				m=b;
			if(m<(int)N.data)
				return m;
			else
				return (int)N.data;
			
				}
			else	return 0;
		}
	public static void main(String[] args){
		Scanner reader=new Scanner(System.in);
		BSTex<Integer> b=new BSTex<Integer>();
		int[] a = {1,5,2,7,4,67,12};
		for(int n : a) b.insert(n);
		System.out.println(b );
		System.out.println("enter number");
Integer n=reader.nextInt();
b.FindParent(b.root, n);
int m=b.max(b.root);
System.out.println("maximum="+m);

System.out.println("minimum="+b.min(b.root));


	}
}