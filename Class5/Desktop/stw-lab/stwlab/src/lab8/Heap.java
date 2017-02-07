package lab8;
import java.util.ArrayList;
/**
 * CSE 373, Winter 2011, Jessica Miller
 * The BinaryHeap is an -generic- implementation of the PriorityQueue interface.  
 * This is a binary min-heap implementation of the priority queue ADT.
 */
import java.util.Arrays;

public class Heap{
    ArrayList<Integer> array;
    
    /**
     * Constructs a new BinaryHeap.
     */
	public BinaryHeap () {
        array = new ArrayList<Integer>();
    }
    
    
    /**
     * Adds a value to the min-heap.
     */
    public void add(Integer value) {
        // your code here
        
        bubbleUp();
    }
    
    
    /**
     * Returns true if the heap has no elements; false otherwise.
     */
    public boolean isEmpty() {
        return /*code here*/;
    }

    
    /**
     * Returns (but does not remove) the minimum element in the heap.
     */
    public Integer peek() {
        // your code here
    }

    
    /**
     * Removes and returns the minimum element in the heap.
     */
    public Integer remove() {
    	Integer result = /**/;
    	
        /// code

    	bubbleDown();
    	
    	return result;
    }
    
    
    /**
     * Performs the "bubble down" operation to place the element that is at the 
     * root of the heap in its correct place so that the heap maintains the 
     * min-heap order property.
     */
    protected void bubbleDown() {
        //your code here
    }
    
    
    /**
     * Performs the "bubble up" operation to place a newly inserted element 
     * (i.e. the element that is at the size index) in its correct place so 
     * that the heap maintains the min-heap order property.
     */
    protected void bubbleUp() {
        //your code here
    }
    
    
    protected boolean hasParent(Integer i) {
        return /*code*/;
    }
    
    
    protected int leftIndex(Integer i) {
        return /*code*/;
    }
    
    
    protected int rightIndex(Integer i) {
        return /*code*/;
    }
    
    
    protected boolean hasLeftChild(Integer i) {
        return /*code*/;
    }
    
    
    protected boolean hasRightChild(Integer i) {
        return /*code*/;
    }
    
    
    protected Integer parent(Integer i) {
        return /*code*/;
    }
    
    
    protected Integer parentIndex(Integer i) {
        return /*code*/;
    }
    
    
    protected void swap(int index1, int index2) {
        //your code here                
    }
}