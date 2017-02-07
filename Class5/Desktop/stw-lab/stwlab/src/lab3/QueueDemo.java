package lab3;

import java.util.*;
 class QueueDemo {
 public static void main(String args[]) {
 Queue<Integer> q = new LinkedList<Integer>();
 int i=3;
 System.out.println("Queue: " + q);
 q.add(42);
 System.out.println("Queue: " + q);
 q.add(66);
 System.out.println("Queue: " + q);
 q.add(99);
 System.out.println("Queue: " + q);
 while(i>0){
 i--;
 q.remove();
System.out.println("Queue: " + q); }
 }}
