package lab6;
import java.util.Scanner;
public class Section1_4 {
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		 BST<String> bst = new BST<String>();
		System.out.println("enter number of strings");
		int n=reader.nextInt();
		System.out.println("enter strings");
		for(int i=0;i<n;i++){
				String s=reader.next();
				bst.insert(s);
		}
		bst.inOrderTraversal();
		}
}
