package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListGraph  extends AbstractGraph{

	//Data fields
	private List<Edge>[] edges;
	
	public ListGraph(int numV, boolean isDirected){
		super(numV, isDirected);
		edges = new List[numV];
		for(int i = 0; i < numV; i++){
			edges[i] = new LinkedList<Edge>();
		}
	}

	/**inserts an edge to the list at the source position.
	 * If the graph isn't directed it will be added to the destination position as well.
	 *
	 */
	public void insert(Edge edge) {
		edges[edge.getSource()].add(edge);
		if(!isDirected())
			// Make a new edge so it doesn't refer to the same object as we just inserted to the list.
			edges[edge.getDest()].add(new Edge(edge.getSource(), edge.getDest(), edge.getWeight()));		
	}

	/**Checks if and Edge exists in the list.
	 * 
	 */
	public boolean isEdge(int source, int dest) {
				return edges[source].contains(new Edge(source, dest));
	}

	/**Get the edge between two vertices. If an
	 * edge does not exist, an Edge with a weight
	 * of Double.POSITIVE_INFINITY is returned.
	 * @param	source	the source
	 * @param	dest	the destination
	 * @return	the edge between these two verices.
	 * 
	 */
	public Edge getEdge(int source, int dest) {
		Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
		for(Edge edge : edges[source]){
			if(edge.equals(target))
				return edge;	//both the source and destination was the same.
		}
		return target;
			
	}

	/**Returns an iterator for one of the ArrayLists in the List.
	 * 
	 */
	
	public Iterator<Edge> edgeIterator(int source) {
		return edges[source].iterator();
	}
}
