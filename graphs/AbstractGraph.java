package graphs;

import java.util.*;
import java.io.*;

public abstract class AbstractGraph implements Graph {

	//Data fields
	private int numV;
	private boolean directed;
	
	public AbstractGraph(int numV, boolean directed){
		this.numV 		= numV;
		this.directed	= directed;
	}


	public int getNumV() {
		return numV;
	}

	
	public boolean isDirected() {
		return directed;
	}

	public void loadEdgesFromFile(Scanner scan){
		Scanner lineScanner;
		int source;
		int dest;
		double weight;
		Edge e;
		
		while(scan.hasNextLine()){
			lineScanner = new Scanner(scan.nextLine());
			source = lineScanner.nextInt(); 
			dest = lineScanner.nextInt();	
			if(lineScanner.hasNextDouble())
				e = new Edge(source, dest, lineScanner.nextDouble());
			else
				e = new Edge(source, dest, 1.0);
			insert(e);
		}
	}

	/** Factory methos to create a graph and load the data from an input
	 * file. The first line of the input file should contain the edge data 
	 * as described under loadEdgesFromFile.
	 *  @param	scan		The scanner connected to the data file
	 *  @param	isDirected	true if this is a directed graph. false otherwise
	 *  @param	type		the string "Matrix" if an adjacency matrix is to be
	 *  					created and the string "List" if an adjacency list
	 *  					should be created.
	 * 
	 * @throws	IllegalArgumentException	if type is neither "Matrix" nor "List"
	 */
	public static Graph createGraph(Scanner scan, boolean isDirected, String type){
		int numV = scan.nextInt();
		AbstractGraph returnValue = null;
		if(type.equalsIgnoreCase("Matrix"))
			returnValue = new MatrixGraph(numV, isDirected);
		else if(type.equalsIgnoreCase("List"))
			returnValue = new ListGraph(numV, isDirected);
		else
			throw new IllegalArgumentException();
		returnValue.loadEdgesFromFile(scan);
		return returnValue;
	}
	
	
	
	public abstract void insert(Edge edge);
	public abstract boolean isEdge(int source, int dest);
	public abstract Edge getEdge(int source, int dest);
	public abstract Iterator<Edge> edgeIterator(int source);
	
	
}
