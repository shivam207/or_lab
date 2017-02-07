package practice;
import java.util.*;

 import org.jgrapht.*;

 import org.jgrapht.generate.*;

 import org.jgrapht.graph.*;

 import org.jgrapht.traverse.*;

 public class TopologicalDemo
{

 public static void main(String [] args)

 {

	 DirectedGraph<Integer, DefaultEdge> Dgraph =
			 new DefaultDirectedGraph<Integer,DefaultEdge> (DefaultEdge.class);
	

 Dgraph.addVertex(1);

 Dgraph.addVertex(2);

 Dgraph.addVertex(3);

 Dgraph.addVertex(4);

 Dgraph.addVertex(5);
  
Dgraph.addEdge(1, 2);
 Dgraph.addEdge(3, 2);
 Dgraph.addEdge(2, 4);
 Dgraph.addEdge(2, 5);
 Iterator<Integer> iter = new
TopologicalOrderIterator<Integer,
DefaultEdge>(Dgraph);
 System.out.println("Topological Order");
 while (iter.hasNext()) {
 int vertex = iter.next();
 System.out.print(vertex+" ");
 }
 System.out.println();
 }
 }
