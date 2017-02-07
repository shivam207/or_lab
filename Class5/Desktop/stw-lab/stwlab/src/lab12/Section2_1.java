package lab12;
import java.util.List;
import org.jgrapht.alg.*;
import org.jgrapht.*;
import org.jgrapht.graph.*;
public class Section2_1 
{   public static void main(String[] args)
    {

	SimpleDirectedWeightedGraph<Integer,DefaultWeightedEdge> Dgraph=new
			SimpleDirectedWeightedGraph<Integer,DefaultWeightedEdge>(DefaultWeightedEdge.class);
	Dgraph.addVertex(1);
	Dgraph.addVertex(2);
	Dgraph.addVertex(3);
	Dgraph.addVertex(4);
	Dgraph.addVertex(5);
	Dgraph.addVertex(6);
	Dgraph.addEdge(1, 2);
	Dgraph.addEdge(2,4);
	Dgraph.addEdge(2,5);
	Dgraph.addEdge(3, 4);
	Dgraph.addEdge(4, 5);
	Dgraph.addEdge(6, 2);
	Dgraph.setEdgeWeight(Dgraph.getEdge(1,2),20);
	Dgraph.setEdgeWeight(Dgraph.getEdge(2,4),15);
	Dgraph.setEdgeWeight(Dgraph.getEdge(2,5),28);
	Dgraph.setEdgeWeight(Dgraph.getEdge(3,4),67);
	Dgraph.setEdgeWeight(Dgraph.getEdge(4,5),17);
	Dgraph.setEdgeWeight(Dgraph.getEdge(6,2),15);
	System.out.println(Dgraph.toString());
	List path=DijkstraShortestPath.findPathBetween(Dgraph,1,5);
	List path1=KruskalMinimumSpanningTree.
	System.out.println("shortest path between 1 and 5");
	System.out.println(path);
}
}
