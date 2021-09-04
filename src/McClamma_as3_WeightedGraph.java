/* Zackary McClamma
 * CPS 530
 * Assignment 3
 * 27 July 2020 */

import java.util.*;

/* This is the Weighted graph Class (taken from the lecture notes)*/
public class McClamma_as3_WeightedGraph {
	private final int V;
	private final ArrayList<McClamma_as3_DirectedEdge>[] adj;
	
	public McClamma_as3_WeightedGraph(int V)
	{
		this.V = V;
		adj = (ArrayList<McClamma_as3_DirectedEdge>[]) new ArrayList[V];
		
		for(int v = 0; v < V; v++)
		{
			adj[v] = new ArrayList<McClamma_as3_DirectedEdge>();
		}
	}
	
	public void addEdge(McClamma_as3_DirectedEdge e)
	{
		int v = e.from();
		adj[v].add(e);
	}
	
	public Iterable<McClamma_as3_DirectedEdge> adj(int v)
	{
		return adj[v];
	}
	
	public int V( ) {return V;}
	
	public void printAllEdges()
	{
		for(int v = 0; v < V; v++)
		{
			for(McClamma_as3_DirectedEdge e : adj[v])
			{
				System.out.println(e.toString());
			}
		}
	}
}
