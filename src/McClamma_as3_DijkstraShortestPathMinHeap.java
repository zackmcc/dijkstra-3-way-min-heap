/* Zackary McClamma
 * CPS 530
 * Assignment 3
 * 27 July 2020 */

import java.util.Arrays;
import java.util.Stack;

/* This calss implements the Dijkstra shortest path algorithm using
 * a 3 way heap (from assignment 1), it is more efficient for short
 * paths but when the paths start to get unruly it is not as efficient
 * as using the priority queue, I believe that this is due to the 
 * resize function */

public class McClamma_as3_DijkstraShortestPathMinHeap {
	
	private boolean[] marked;
	private int[] parent;
	private double[] key;
	private McClamma_as3_MinHeap<Double, Integer> heap;
	int u, v;
	
	McClamma_as3_DijkstraShortestPathMinHeap(McClamma_as3_WeightedGraph G, int s, int t)
	{
		marked = new boolean[G.V()];
		parent = new int[G.V()];
		key = new double[G.V()];
		heap = new McClamma_as3_MinHeap<Double, Integer>();
		Arrays.fill(key, Double.POSITIVE_INFINITY);
		key[s] = 0.0; parent[s] = s;
		heap.insert(key[s], s);
		
		while(!heap.isEmpty())
		{
			u = heap.deleteMin();
			if (u == t)
				break;
			
			if (!marked[u])
			{
				marked[u] = true;
				for (McClamma_as3_DirectedEdge e : G.adj(u))
				{
					v = e.to();
					if (!marked[v] && key[u] + e.weight() < key[v])
					{
						key[v] = key[u] + e.weight();
						parent[v] = u;
						heap.insert(key[v],v);
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
