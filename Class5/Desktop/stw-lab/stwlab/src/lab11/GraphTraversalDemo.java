package lab11;
import java.util.*;

 import org.jgrapht.*;

 import org.jgrapht.generate.*;

 import org.jgrapht.graph.*;

 import org.jgrapht.traverse.*;

 public class GraphTraversalDemo

 {

 public static void main(String [] args)

 {

 UndirectedGraph<Integer, DefaultEdge>
 aGraph = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);



 aGraph.addVertex(1);

 aGraph.addVertex(2);

 aGraph.addVertex(3);

 aGraph.addVertex(4);
  aGraph.addEdge(1, 2);

  aGraph.addEdge(2, 3);

  aGraph.addEdge(3, 4);

  aGraph.addEdge(3, 1);

  Iterator<Integer> iter = new DepthFirstIterator<Integer, DefaultEdge>(aGraph);
		  

		  
  while (iter.hasNext()) {

	   int vertex = iter.next();

	   System.out.println( "Vertex " + vertex + " is connected to: " + aGraph.edgesOf(vertex));

	  

	 

	  
  }

  }

  }

