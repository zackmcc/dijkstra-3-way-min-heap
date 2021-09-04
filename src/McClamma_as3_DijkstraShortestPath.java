/* Zackary McClamma
 * CPS 530
 * Assignment 3
 * 27 July 2020 */

import java.util.*;

/* This is the DIjkstra shortest path algorithm (taken from the lecture notes)*/
public class McClamma_as3_DijkstraShortestPath {
	private boolean[] marked;
	private int[] parent;
	private double[] key;
	private PriorityQueue<McClamma_as3_Pair> Q;

	
	public McClamma_as3_DijkstraShortestPath(McClamma_as3_WeightedGraph G, int s, int t)
	{
		marked = new boolean[G.V()];
		parent = new int[G.V()];
		key = new double[G.V()];
		Q = new PriorityQueue<McClamma_as3_Pair>();
		for (int v = 0; v < G.V(); v++) {key[v] = Double.POSITIVE_INFINITY;}
		
		key[s] = 0.0; parent[s] = s;
		Q.add(new McClamma_as3_Pair(key[s], s));
		
		while(!Q.isEmpty())
		{
			int u = Q.poll().value;
			if (u == t)
				break;
			
			if (!marked[u])
			{
				marked[u] = true;
				for (McClamma_as3_DirectedEdge e : G.adj(u))
				{
					int v = e.to();
					if (!marked[v] && key[u] + e.weight() < key[v])
					{
						key[v] = key[u] + e.weight();
						parent[v] = u;
						Q.add(new McClamma_as3_Pair(key[v],v));
					}
				}
			}
		}
	}
	
	
	public int[] path(int s, int destination)
	{
		Stack<Integer> stPath = new Stack<Integer>();
		int current = destination;
		while(current != s)
		{
			stPath.push(current);
			current = parent[current];
		}
		stPath.push(s);
		
		int [] a = new int[stPath.size()];
		int i = 0;
		while(!stPath.isEmpty())
		{
			a[i++] = stPath.pop();
			//System.out.println(a[i-1]);
		}
		return a;
	}
}
