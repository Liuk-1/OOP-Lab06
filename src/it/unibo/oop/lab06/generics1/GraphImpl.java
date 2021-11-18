package it.unibo.oop.lab06.generics1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {

	private Map<N, Set<N>> nodes = new HashMap<>();
	
	@Override
	public void addNode(N node) {
		if(node != null) {
			this.nodes.putIfAbsent(node, null);
		}
	}

	@Override
	public void addEdge(N source, N target) {
		if((source != null) && (target != null)) {
			this.nodes.get(source).add(target);
			this.nodes.get(target).add(source);
		}
		
	}

	@Override
	public Set<N> nodeSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<N> linkedNodes(N node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<N> getPath(N source, N target) {
		// TODO Auto-generated method stub
		return null;
	}

}
