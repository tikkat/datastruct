package graphs;

public class Edge {

	private int 	dest;		//destination vertex
	private int 	source;		//source vertex
	private double 	weight;
	
	public Edge(int source, int dest){
		this.source = source;
		this.dest 	= dest; 
	}
	
	public Edge(int source, int dest, double w){
		this.source = source;
		this.dest 	= dest; 
		this.weight = w;
	}
	
	/** Compares to edges for equality. If the input isn't
	 * an Edge you'll get false.
	 * 
	 */
	public boolean equals(Object o){
		if(o.getClass() == this.getClass()){
			Edge e = (Edge) o;
			return e.dest == this.dest && e.source == this.source;
		} else {
			return false;
		}
	}
	
	public int getDest(){
		return dest;
	}
	
	public int getSource(){
		return source;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public int hashCode(){
		return (dest*2377 + source*1979)%3259;
	}
	
	public String toString(){
		return "Edge with source vertex: " + source + 
				", destination vertex: " + dest +
				" and weight: " + weight;
	}
}

