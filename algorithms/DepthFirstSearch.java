package algorithms;

import java.util.Iterator;
import graphs.Edge;
import graphs.Graph;


/**Class to implement the depth-first search algortihm. */
public class DepthFirstSearch {
	
	//Data fields
	private Graph 		graph;			//the graph being searched
	private int[] 		parent;
	private boolean[] 	visited;		
	private int[] 		discoveryOrder;
	private int[] 		finishOrder;
	private int 		discoverIndex = 0;
	private int 		finishIndex = 0;
	
	
	/** Construct the depth-first seach of a Graph
	 * starting at vertex 0 and visiting the start verices
	 * in ascending order.
	 * @param	graph	the graph
	 */
	public DepthFirstSearch(Graph graph){
		this.graph 		= graph;
		int n 			= graph.getNumV();
		parent 			= new int[n];
		visited 		= new boolean[n];
		discoveryOrder 	= new int[n];
		finishOrder 	= new int[n];
		
		for(int i  = 0; i < n; i++){
			parent[i] = -1;
		}
		
		for(int i  = 0; i < n; i++){
			if(!visited[i])
				depthFirstSearch(i);
		}		
	}
	
	public DepthFirstSearch(Graph graph, int[] order){
		this.graph 		= graph;
		int n 			= graph.getNumV();
		parent 			= new int[n];
		visited 		= new boolean[n];
		discoveryOrder 	= new int[n];
		finishOrder 	= new int[n];
		
		for(int i  = 0; i < n; i++){
			parent[i] = -1;
		}
		
		for(int i  = 0; i < n; i++){
			depthFirstSearch(i);
		}	
	}
	/** Recursively depth-first search the graph
	 * starting at vertex current.
	 * 
	 * @param 	current		the start vertex
	 */
	
	public void depthFirstSearch(int current){
		
		/*Mark the current vertex visited*/
		visited[current] 				= true;
		discoveryOrder[discoverIndex++] = current;
		
		/*Examine each vertex adjacent to the current vertex*/
		Iterator<Edge> itr = graph.edgeIterator(current);
		while(itr.hasNext()){
			int neighbor = itr.next().getDest();
			/* Process a neighbor that hasn't been visited */
			if(!visited[neighbor]) {
				/*Insert (current, neighbor) into the depth-first search tree*/
				parent[neighbor] = current;
				/*Recursively apply the algorithm starting at neighbor*/
				depthFirstSearch(neighbor);
			}
		}
		/* Mark current finished */
		finishOrder[finishIndex++] = current;
		
		
	}
}
