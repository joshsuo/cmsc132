package graphs;

import java.util.*;


/**
 * Implements a graph. We use two maps: one map for adjacency properties 
 * (adjancencyMap) and one map (dataMap) to keep track of the data associated 
 * with a vertex. 
 * 
 * @author cmsc132
 * 
 * @param <E>
 */
public class Graph<E> {
	
	private class Node implements Comparable<Node> {

		private int cost;
		private String name;
		
		public Node(String name, int cost)
		{
			this.name = name;
			this.cost = cost;
		}
		
		public int compareTo(Node node) {
			
			if(this.cost > node.cost)
				return 1;
			else if(this.cost < node.cost)
				return -1;
			else
				return 0;
			
		}
		
		public String getName()
		{
			return this.name;
		}
		
		public int getCost()
		{
			return this.cost;
		}
		
		
	}
	
	
	
	/* You must use the following maps in your implementation */
	private HashMap<String, HashMap<String, Integer>> adjacencyMap;
	private HashMap<String, E> dataMap;
	
	
	public Graph()
	{
		this.adjacencyMap = new HashMap<String, HashMap<String, Integer>>();
		this.dataMap = new HashMap<String, E>();
	}
	
	public void addVertex(String vertexName, E data)
	{
		if(dataMap.containsKey(vertexName) || adjacencyMap.containsKey(vertexName))
		{
			throw new IllegalArgumentException("Vertex Already Used");
		}
		else
		{
			dataMap.put(vertexName, data);
			adjacencyMap.put(vertexName, new HashMap<String, Integer>());
		}
	}
	
	public void addDirectedEdge(String startVertexName,String endVertexName, int cost)
	{
		if(!adjacencyMap.containsKey(startVertexName))
		{
			throw new IllegalArgumentException("Vertex Not In Graph");
		}
		else
		{
			adjacencyMap.get(startVertexName).put(endVertexName, cost);
		}
	}
	
	public String toString()
	{
		String result = "";
		TreeSet<String> dataPts = new TreeSet<String>(dataMap.keySet());
		
		result += "Vertices: " + dataPts.toString() + "\n";
		result += "Edges:\n";
		
		for(String point : dataPts)
		{
			result += "Vertex(" + point + ")--->";
			if(adjacencyMap.containsKey(point))
			{
				result += adjacencyMap.get(point).toString() + "\n";
			}
			else
			{
				result += new HashMap<String, Integer>() + "\n";
			}
		}
		return result;
	}
	
	public Map<String, Integer> getAdjacentVertices(String vertexName)
	{
		return new TreeMap<String, Integer>(adjacencyMap.get(vertexName));
	}
	
	public int getCost(String startVertexName, String endVertexName)
	{
		if(!adjacencyMap.containsKey(startVertexName) ||
				!adjacencyMap.get(startVertexName).containsKey(endVertexName))
		{
			throw new IllegalArgumentException("Vertex Not In Graph");
		}
		else
		{
			return adjacencyMap.get(startVertexName).get(endVertexName);
		}
	}
	
	public Set<String> getVertices()
	{
		return dataMap.keySet();
	}
	
	public E getData(String vertex)
	{
		return dataMap.get(vertex);
	}
	
	public void doDepthFirstSearch(String startVertexName, CallBack<E> callback)
	{
		if(!adjacencyMap.containsKey(startVertexName))
			throw new IllegalArgumentException("Vertex Not In Graph");
		
		Stack<String> stack = new Stack<>();
		HashSet<String> visited = new HashSet<>();
		
		stack.push(startVertexName);
		
		while(!stack.isEmpty())
		{
			String temp = stack.pop();
			visited.add(temp);
			callback.processVertex(temp, dataMap.get(temp));
			
			for(String vertex : getAdjacentVertices(temp).keySet())
			{
				if(!visited.contains(vertex) && !stack.contains(vertex))
					stack.push(vertex);
			}	
		}	
	}

	public void doBreadthFirstSearch(String startVertexName, CallBack<E> callback)
	{
		if(!adjacencyMap.containsKey(startVertexName))
			throw new IllegalArgumentException("Vertex Not In Graph");
		
		Queue<String> queue = new ArrayDeque<>();
		HashSet<String> visited = new HashSet<>();
		
		queue.add(startVertexName);
		
		while(!queue.isEmpty())
		{
			String temp = queue.remove();
			visited.add(temp);
			callback.processVertex(temp, dataMap.get(temp));
			
			for(String vertex : getAdjacentVertices(temp).keySet())
			{
				if(!visited.contains(vertex) && !queue.contains(vertex))
					queue.add(vertex);
			}	
		}	
	}
	
	public int doDijkstras(String startVertexName, String endVertexName, ArrayList<String> shortestPath)
	{
		if(!adjacencyMap.containsKey(startVertexName))
			throw new IllegalArgumentException("Vertex Not In Graph");
		
		if(startVertexName.equals(endVertexName))
		{
			shortestPath.add(startVertexName);
			return 0;
		}
		
		Set<String> visited = new HashSet<>();
		HashMap<String, String> predecessors = new HashMap<>();
		HashMap<String, Integer> costs = new HashMap<>();
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		for(String vertex : getVertices())
		{
			costs.put(vertex, Integer.MAX_VALUE);
		}
		costs.put(startVertexName, 0);
		
		queue.add(new Node(startVertexName, 0));
		predecessors.put(startVertexName, "None");
		Node curr;
		
		while(!queue.isEmpty())
		{
			curr = queue.poll();
			visited.add(curr.getName());
			
			for(String vertex : getAdjacentVertices(curr.getName()).keySet())
			{
				if(!visited.contains(vertex))
				{
					int cost = getCost(curr.getName(), vertex) + costs.get(curr.getName());
					
					if(costs.get(vertex) > cost)
					{
						costs.put(vertex, cost);
						predecessors.put(vertex, curr.getName());
					}
				
					queue.add(new Node(vertex, cost));
				}
			}	
			
		}
		
		//ArrayList<String> path = new ArrayList<>();
		
		String current = predecessors.get(endVertexName);
		
		if(current != null)
		{
			while(!current.equals(startVertexName))
			{
				shortestPath.add(current);
				
				current = predecessors.get(current);
			}
			shortestPath.add(startVertexName);
			
			Collections.reverse(shortestPath);
			shortestPath.add(endVertexName);
			//shortestPath = path;
		}
		
		if(costs.get(endVertexName) > 10001) {
			shortestPath.add("None");
			return -1;
		}
		
		return costs.get(endVertexName);
		
		
	}
	

}