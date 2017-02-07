package AkhilRaj;


import java.util.*;

/** 
*   <h2>The  Generic Binary Search Tree Class.</h2>
*   A binary search tree is a rooted binary tree, 
*   whose internal nodes each store a key (or simply a value) and each have two distinguished sub-trees, commonly denoted left child and right child.  
*   The tree additionally satisfies the binary search tree property, which states that the key in each node must be greater than all keys stored in the left sub-tree,  
*   and smaller than all keys in right sub-tree  
*
*/



public class BST implements Iterable<Integer>
{
	
   protected Node root;
/**
* Creates an empty BST
*
*    
*   
*/
   public BST()
   {
      root = null;
   }


/*****************************************************
*
*            INSERT
*
******************************************************/
/**
* This method is  insert the data into the BST
*
* @param  data
*  
*/
   public void insert(Integer data)
   {

      root = insert(root, data);
   }
   protected Node insert(Node p, Integer toInsert)
   {
      if (p == null)
         return new Node(toInsert);

      if (toInsert == p.data)
      	return p;

      if (toInsert < p.data)
         p.left = insert(p.left, toInsert);
      else
         p.right = insert(p.right, toInsert);

      return p;
   }

/*****************************************************
*
*            SEARCH
*
******************************************************/

/**
* This method is for searching the data in the BST
*
* @param  data
* @return true or false
*/

   public boolean search(Integer data)
   {
      return search(root, data);
   }
   protected boolean search(Node p, Integer data)
   {
      if (p == null)
         return false;
      else
      if (data == p.data)
      	return true;
      else
      if (data < p.data)
         return search(p.left, data);
      else
         return search(p.right, data);
   }

/*****************************************************
*
*            DELETE
*
******************************************************/
/**
* This method is to delete the data from the BST
*
* @param  data
*  
*/
   public void delete(Integer data)
   {
      root = delete(root, data);
   }
   protected Node delete(Node p, Integer data)
   {
      if (p == null)  throw new RuntimeException("cannot delete.");
      else
      if (data < p.data)
      p.left = delete (p.left, data);
      else
      if (data > p.data)
      p.right = delete (p.right, data);
      else
      {
         if (p.left == null) return p.right;
         else
         if (p.right == null) return p.left;
         else
         {
         // get data from the rightmost node in the left subtree
            p.data = retrieveData(p.left);
         // delete the rightmost node in the left subtree
            p.left =  delete(p.left, p.data) ;
         }
      }
      return p;
   }
   protected Integer retrieveData(Node p)
   {
      while (p.right != null) p = p.right;

      return p.data;
   }

/**
*@deprecated 
*            toString
*
*/

   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      for(Integer data : this) sb.append(data.toString());

      return sb.toString();
   }

/*************************************************
*
*            TRAVERSAL
*
**************************************************/
/**
* This method is to print the preorder traversal of the BST
*
*   
*  
*/
   public void preOrderTraversal()
   {
      preOrderHelper(root);
   }
   protected void preOrderHelper(Node r)
   {
      if (r != null)
      {
         System.out.print(r+" ");
         preOrderHelper(r.left);
         preOrderHelper(r.right);
      }
   }
/**
* This method is to print the inorder traversal of the BST
*
*   
*  
*/
   public void inOrderTraversal()
   {
      inOrderHelper(root);
   }
   protected void inOrderHelper(Node r)
   {
      if (r != null)
      {
         inOrderHelper(r.left);
         System.out.print(r+" ");
         inOrderHelper(r.right);
      }
   }
/**
* This method is to print the postorder traversal of the BST
*
*   
*  
*/
   public void postOrderTraversal()
   {
      postOrderHelper(root);
   }
   protected void postOrderHelper(Node r)
   {
      if (r != null)
      {
         postOrderHelper(r.left);
         postOrderHelper(r.right);
         System.out.print(r+" ");
      }
   }

/**
* @deprecated 
*            CLONE
*
*/

   public BST clone()
   {
      BST twin = null;

     twin = new BST();

      twin.root = cloneHelper(root);
      return twin;
   }
   protected Node cloneHelper(Node p)
   {
      if(p == null)
         return null;
      else
         return new Node(p.data, cloneHelper(p.left), cloneHelper(p.right));
   }

/*************************************************
*
*           MISC
*
**************************************************/
/**
* This method is to find the height of the BST
*
*   
* @return height of tree
*/
   public int height()
   {
      return height(root);
   }
   protected int height(Node p)
   {
      if(p == null) return 0;
      else
      return 1 + Math.max( height(p.left), height(p.right));
   }
/**
* @deprecated 
*
*/
   public int countLeaves()
   {
      return countLeaves(root);
   }
   protected int countLeaves(Node p)
   {
      if(p == null) return 0;
      else
      if(p.left == null && p.right == null) return 1;
      else
      return countLeaves(p.left) + countLeaves(p.right);
   }


/**
* @deprecated 
*
*/
 public void restore(Integer[] pre, Integer[] in)
   {
      root = restore(pre, 0, pre.length-1, in, 0, in.length-1);
   }
   protected Node restore(Integer[] pre, int preL, int preR, Integer[] in, int inL, int inR)
   {
      if(preL <= preR)
      {
         int count = 0;
         //find the root in the inorder array
         while(pre[preL] != in[inL + count]) count++;

         Node tmp = new Node(pre[preL]);
         tmp.left = restore(pre, preL+1, preL + count, in, inL, inL +count-1);
         tmp.right = restore(pre, preL+count+1, preR, in, inL+count+1, inR);
         return tmp;
      }
      else
         return null;
   }

/**
* This method is to find the width(The maximum number of elements on one level of the tree) of the BST
*
*   
* @return width of tree
*/ 
   public int width()
   {
      int max = 0;
      for(int k = 0; k <= height(); k++)
      {
         int tmp = width(root, k);
         if(tmp > max) max = tmp;
      }
      return max;
   }
   //rerturns the number of node on a given level
   protected int width(Node p, int depth)
   {
      if(p==null) return 0;
      else
      if(depth == 0) return 1;
      else
      return width(p.left, depth-1) + width(p.right, depth-1);
   }
/**
* This method is to find the diameter(The number of nodes on the longest path between two leaves in the tree) of the BST
*
*   
* @return diameter of tree
*/
   //The diameter of a tree is the number of nodes
   //on the longest path between two leaves in the tree.
   public int diameter()
   {
      return diameter(root);
   }
   protected int diameter(Node p)
   {
      if(p==null) return 0;

      //the path goes through the root
      int len1 = height(p.left) + height(p.right) +1;

      //the path does not pass the root
      int len2 = Math.max(diameter(p.left), diameter(p.right));

      return Math.max(len1, len2);
   }


/*****************************************************
*
*            TREE ITERATOR
*
******************************************************/
/**
* @deprecated 
*
*/

   public Iterator<Integer> iterator()
   {
      return new MyIterator();
   }
   //pre-order
   protected class MyIterator implements Iterator<Integer>
   {
      Stack<Node> stk = new Stack<Node>();

      public MyIterator()
      {
         if(root != null) stk.push(root);
      }
      public boolean hasNext()
      {
         return !stk.isEmpty();
      }

      public Integer next()
      {
         Node cur = stk.peek();
         if(cur.left != null)
         {
            stk.push(cur.left);
         }
         else
         {
            Node tmp = stk.pop();
            while( tmp.right == null )
            {
               if(stk.isEmpty()) return cur.data;
               tmp = stk.pop();
            }
            stk.push(tmp.right);
         }

         return cur.data;
      }//end of next()

      public void remove()
      {

      }
   }//end of MyIterator

/*****************************************************
*
*            the Node class
*
******************************************************/

   protected class Node
   {
      protected Integer data;
      protected Node left, right;

      public Node(Integer data, Node l, Node r)
      {
         left = l; right = r;
         this.data = data;
      }

      public Node(Integer data)
      {
         this(data, null, null);
      }

      public String toString()
      {
         return data.toString();
      }
   } //end of Node
}//end of BST
