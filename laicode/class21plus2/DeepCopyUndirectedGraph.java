package laicode.class21plus2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import laicode.common.GraphNode;

public class DeepCopyUndirectedGraph {
	  // 0. keypoint
	  // undirected graph; cycles
	  
	  // 1. assumption
	  // graph is not null
	  
	  // 2. approach
	  // Method1: BFS
	  // iterative way
	  // Method2: DFS
	  // recursion
	  public List<GraphNode> copy(List<GraphNode> graph) {
	    if (graph == null)  {
	      return null;
	    }
	    
	    // maintain ori to copy relation
	    Map<GraphNode, GraphNode> map = new HashMap<>();
	    // assume the graph is not connected and select a seed to do dfs
	    for (GraphNode node: graph) {
	      if (!map.containsKey(node)) {
	    	  copyNode(node, map);    
	      }
	    }
	    
	    return new ArrayList<GraphNode>(map.values());
	  }
	  
	  private GraphNode copyNode(GraphNode node, Map<GraphNode, GraphNode> map) {
	    // base case
	    if (node == null) {
	      return node;
	    }
	    GraphNode copy = map.get(node);
	    if (copy == null) {
	      copy = new GraphNode(node.key);
	      map.put(node, copy);
	    }
	    
	    for (GraphNode nei : node.neighbors) {
	      copy.neighbors.add(copyNode(nei, map));  
	    }
	    
	    return copy;
	  }
}
