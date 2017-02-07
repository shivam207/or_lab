package lab3;

import java.util.*;
 class StackDemo {
 public static void main(String args[]) {
 Stack<Integer> st = new Stack<Integer>();
 int i=3;
System.out.println("stack: " + st);
 st.push(42);
 System.out.println("stack: " + st);
 st.push(66);
 System.out.println("stack: " + st);
 st.push(99);
 System.out.println("stack: " + st);
 while(i>0){
 i--;
st.pop();
 System.out.println("stack: " + st); }
}}

