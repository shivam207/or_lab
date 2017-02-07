package lab5;
import java.util.*;
public class arraylistdemo {
 
 public static void main(String args[]) {
 ArrayList<String> al = new ArrayList<String>();
 System.out.println("Initial size of al: " + al.size
());
 al.add("C"); al.add("F"); al.add(1,"A2");
 System.out.println("Size of al after additions: " +
al.size());
 System.out.println("Contents of al: " + al);
al.remove("F");
 System.out.println("Size of al after deletions: " +
al.size());
 System.out.println("Contents of al: " + al);}
 }



