package fr.insa_rennes.sdd.dijkstra;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import fr.insa_rennes.sdd.graph.Graph;
import fr.insa_rennes.sdd.graph.VertexAndWeight;
import fr.insa_rennes.sdd.priority_queue.PriorityQueue;

public class Dijkstra<T> {
	private final PriorityQueue<DijkstraNode<T>> pq;	
	private final Map<T, Double> cost = new HashMap<>();
	private final Map<T, T> prev = new HashMap<>();

	public Dijkstra(Graph<T> graph, T source) {
		this(graph, source, FactoryPQ.newInstance("OrderedArrayPQ"));
	}	

	public Dijkstra(Graph<T> graph, T source, PriorityQueue<DijkstraNode<T>> pq) {
		this.pq = pq; 
		solve(graph, source);
	}

	private void solve(Graph<T> graph, T source) {
		this.pq.add(new DijkstraNode<>(0.0,source));
		while (!pq.isEmpty()){
			DijkstraNode<T> current_elem = pq.poll();
			if(cost.containsKey(current_elem.vertex)){
				continue;
			}
			cost.put(current_elem.vertex,current_elem.cost);
			prev.put(current_elem.vertex, current_elem.prev);

			for (VertexAndWeight<T> voisin: graph.neighbors(current_elem.vertex)) {
				double dist = current_elem.cost + voisin.weight;
				this.pq.add(new DijkstraNode<>(dist,voisin.vertex));
			}
		}
	}

	public Deque<T> getPathTo(T v) {
		throw new UnsupportedOperationException();
	}

	public double getCost(T v) {
		return cost.getOrDefault(v, Double.POSITIVE_INFINITY);
	}
	
	public boolean hasPathTo(T v) {
		return getCost(v) != Double.POSITIVE_INFINITY;
	}

}
