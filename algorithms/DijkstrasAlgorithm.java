package algorithms;

import java.util.HashSet;

import graphs.Graph;

public class DijkstrasAlgorithm {

	/** Dijkstra's shortest path algorithm.
	 * 
	 * @param graph		the weighted graph to be searched
	 * @param start		the start vertex
	 * @param pred		output array to contain the predecessors
	 * @param dist		output array to contain the distance in the shortest path
	 */
	
	public static void dijkstrasAlgorithm(Graph graph, int start, int[] pred, double[] dist){
		int numV = graph.getNumV();
		HashSet<Integer> vMinusS = new HashSet<Integer>(numV);
		//Initialize V-S
		for(int i = 0; i <numV; i++){
			if(i != start)
				vMinusS.add(i);
		}
		
		//initialize predecessors and distance.
		for(int v : vMinusS){
			pred[v] = start;
			dist[v] = graph.getEdge(start, v).getWeight();
		}
		
		//Main loop
		while(vMinusS.size() != 0){
			//Find the value u in V-S with the smallest dist[u].
			double minDist = Double.POSITIVE_INFINITY;
			int u = -1;
			for(int v : vMinusS) {
				if(dist[v] < minDist){
					minDist  = dist[v];
					u = v;
				}
			}
			//Remove u from V-S
			vMinusS.remove(u);
			//Update the distances.
			for(int v : vMinusS){
				if(graph.isEdge(u, v)){
					double weight 	=  graph.getEdge(u,v).getWeight();
					if(dist[u] + weight < dist[v]){
						dist[v] 	= dist[u] + weight;
						pred[v] 	= u; 
					}
				}
			}
		}
	}
}
