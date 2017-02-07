package lab11;
import org.jgrapht.*;

 import org.jgrapht.graph.*;

 public class GraphDemo

 {

 public static void main(String [] args)

 {

 UndirectedGraph<Integer, DefaultEdge>

aGraph = new SimpleGraph<Integer,DefaultEdge>(DefaultEdge.class);


 
 aGraph.addVertex(1);

 aGraph.addVertex(2);

 aGraph.addVertex(3);

 aGraph.addEdge(1, 2);

 aGraph.addEdge(2, 3);

 System.out.println(aGraph.toString());

 }

 }
