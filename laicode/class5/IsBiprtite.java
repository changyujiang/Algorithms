package laicode.class5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import laicode.common.GraphNode;

public class IsBiprtite {

	public boolean isBipartite(List<GraphNode> graph) {
		//map to store graphNode and its corresponding group 0 or 1
		Map<GraphNode, Integer> visited = new HashMap<>();
		for (GraphNode node : graph) {
			if (!bfs(node, visited)) {
				return false;
			}
		}
		return true;
	}

	private static boolean bfs(GraphNode node, Map<GraphNode, Integer> visited) {
		if (visited.containsKey(node)) {
			return true;
		}
		Queue<GraphNode> myQueue = new LinkedList<>();
		myQueue.offer(node);
		visited.put(node, 0);
		while (!myQueue.isEmpty()) {
			int size = myQueue.size();
			for (int i = 0; i < size; i++) {
				GraphNode cur = myQueue.poll();
				int curGroup = visited.get(cur);
				List<GraphNode> nei = cur.neighbors;
				int neiGroup = curGroup == 0 ? 1 : 0;
				for (GraphNode neiNode : nei) {
					if (!visited.containsKey(neiNode)) {
						myQueue.offer(neiNode);
						visited.put(neiNode, neiGroup);
					} else {
						if (visited.get(neiNode) != neiGroup) {
							return false;
						}
					}
				}
			}
		}
		return true;

	}

}
