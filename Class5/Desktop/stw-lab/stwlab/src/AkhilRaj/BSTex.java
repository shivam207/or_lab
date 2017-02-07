package AkhilRaj;

import java.util.ArrayList;
import java.util.Scanner;

import AkhilRaj.BST.Node;

public class BSTex extends BST{

	ArrayList<Integer> traversal = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		BSTex bst = new BSTex();
		int p1, p2;
		
		/*          50
		 * 		25	     75
		 * 	 15  35    65   85
		 * 	10			     95
		 * 5 				  105
		 * 						  125
		 * 
		 *  ABOVE IS MY BST
		 * 		
		 */
		Scanner inp = new Scanner(System.in);
		bst.insert(50);
		bst.insert(25);
		bst.insert(75);
		bst.insert(15);
		bst.insert(35);
		bst.insert(65);
		bst.insert(85);
		bst.insert(95);
		bst.insert(105);
		bst.insert(125);
		bst.insert(10);
		bst.insert(5);
		System.out.println("Give number to be taken as root ...");
		p1= inp.nextInt();
		System.out.println("No of nodes : " + bst.noOfNodes(p1, bst.root));
		
		System.out.println("Give value of k ...");
		p2= inp.nextInt();
		
		System.out.println("Kth largest number : " + bst.kthLargest(p2));

	}
	
	
	static int noOfNodes(int n, Node root)
	{
		int a = -1;
		
		if(root == null)
			return -1;
		
		if(root.data == n)
		{
			return size(root);
			
		}
		
		a = noOfNodes(n, root.left);
		if(a != -1)
			return a;
		a = noOfNodes(n, root.right);
		return a;
		
	}
	
	static int size(Node root)
	{
		int num = 0;
		
		if(root == null)
			return 0;
		
		num += size(root.left);
		num += size(root.right);

		
		return num + 1;
		
	}
	
	Integer kthLargest ( int k)
	{
		inOrderTraversal(root, k);
		return traversal.get(traversal.size() - 1);
		
		
	}
	
	protected void inOrderTraversal(Node r, int k)
	   {
		if(traversal.size() == k)
			return;
	      if (r != null)
	      {
	         inOrderTraversal(r.left, k);
	         if(traversal.size() == k)
	        	 return;

	         traversal.add(r.data);
	         if(traversal.size() == k)
	        	 return;
	         inOrderTraversal(r.right, k);
	      }
	   }
	

}
