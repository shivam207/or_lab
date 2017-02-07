package lab5;

import java.util.*;
class HashMapDemo {
 public static void main(String args[]) {
 // Create a hash map.
 HashMap<String, Double> hm = new HashMap<String,
Double>();
 // Put elements to the map
 hm.put("John", new Double(3434.34)); 
 hm.put("Tom", new Double(123.22));
 hm.put("Jane", new Double(1378.00));
 System.out.println("John’s balance: " + hm.get("John"));
 hm.put("John", hm.get("John") + 1000);
 System.out.println("John’s new balance: " + hm.get(
"John"));
 }}
