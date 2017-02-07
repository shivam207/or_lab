package lab6;

import java.util.Scanner;

//import lab6.BST.Node;
public class Section1_2 {
	public static void main(String[] args) {
	 BST<Integer> bst = new BST<Integer>();
	 int[] a = { 1,5,2,7,4,67,12,2,5,7,6,4,25,36,49,24,15,36,49,102,156,43,789,15,35,3,2,9,12,23,24};
	 for(int n : a) bst.insert(n);
	 int h=bst.diameter();
	 System.out.println("longest path  from any node to any node "+h);
	
}
}

	
	