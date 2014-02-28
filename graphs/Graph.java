package graphs;

/** Interface so specify a Graph ADT. A graph is a set
 * of vertices and a set of edges. Verices are represented 
 * by integers from 0 to n-2. Edges are ordered pairs of
 * vertices. Each implementation of the Graph interface
 * should provide a constructor that specifies the number
 * of vertices and whether or not the graph is directed.
 * 
 * @author Tobias Tikka
 *
 */
public interface Graph {
	
	/** Return the number of vertices
	 * 
	 * @return  nbr of vertices.
	 */
	
	int getNumV();
	boolean isDirected();
	void insert(Edge edge);	
	boolean isEdge(int source, int dest);
	
	/** Get the edge between two verices.
	 * 
	 * @param source	the source vertex
	 * @param dest		the destination vertex
	 * @return			the edge between these two verices or an
	 * 					Edge with a weight of Double.POSITIVE_INFINITY 
	 * 					if there is no edge
	 */
	
	Edge getEdge(int source, int dest);
	
	/** Return an iterator to the edges connected 
	 * 	to a given vertex.
	 * 
	 * 	@param	source	The source vertex
	 * 	@return	an Iterator<Edge> to the verices
	 * 			connected to source
	 */
	
	Interator<Edge> edgeIterator(int source);
}
