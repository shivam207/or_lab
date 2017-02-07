package lab3;


import java.util.*;
 class LinkedListDemo {
 public static void main(String args[]) {
LinkedList<String>ll=new LinkedList<String>();
 ll.add("F");
 ll.addFirst("A");
 ll.add(1, "A2");
 System.out.println("Original ll: "+ll);ll.remove("F");
 System.out.println("ll after deletion: "+ ll);
 String val = ll.get(1);
 ll.set(1, val + " Changed");
 System.out.println("ll after change: " + ll);
 }
 }