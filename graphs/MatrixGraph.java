package graphs;

import java.util.Iterator;

public class MatrixGraph extends AbstractGraph{
	
	public MatrixGraph(int numV, boolean isDirected){
		super(numV, isDirected);
	}

	@Override
	public void insert(Edge edge) {
		// TODO Auto-generated method stub
		
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
