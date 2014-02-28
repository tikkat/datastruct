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

	public void insert(Edge edge) {
		edges[edge.getSource()].add(edge);
		if(!isDirected())
			edges[edge.getDest()].add(new Edge(edge.getSource(), edge.getDest(), edge.getWeight()));		
	}

	@Override
	public boolean isEdge(int source, int dest) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Edge getEdge(int source, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Edge> edgeIterator(int source) {
		// TODO Auto-generated method stub
		return null;
	}
}
