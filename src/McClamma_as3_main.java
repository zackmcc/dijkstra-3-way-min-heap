/* Zackary McClamma
 * CPS 530
 * Assignment 3
 * 27 July 2020 */

import java.util.*;
import java.io.*;

/* This is the main method for this project, it includes code used to 
 * test the functionality of the PriorityQueue, in its current state
 * this will throw a EmptyPQException at the end, this is by design
 * to test the EmptyPQException */
public class McClamma_as3_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		McClamma_as3_WeightedGraph G;
		McClamma_as3_DirectedEdge e;
		
		
		//read data from file
		try {
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
			//BufferedReader in = new BufferedReader(new FileReader("input.txt"));
			StringTokenizer str;
			String oneLine;
			int v,w;
			double weight;
			
			oneLine = in.readLine();
			str = new StringTokenizer(oneLine);
			int V = Integer.parseInt(str.nextToken());
			int E = Integer.parseInt(str.nextToken());
			
			//System.out.println("V= " + V);
			//System.out.println("E= " + E);
			
			double [] xVals = new double[V];
			double [] yVals = new double[V];
			
			G = new McClamma_as3_WeightedGraph(V);
			
			for(int i =0; i < V; i++)
			{
				oneLine = in.readLine();
				if (oneLine.length() > 0)
				{
					str = new StringTokenizer(oneLine);
					v = Integer.parseInt(str.nextToken());
					xVals[v] = Double.parseDouble(str.nextToken());
					yVals[v] = Double.parseDouble(str.nextToken());
				}
			}
			
			for (int i = 0; i < E; i++)
			{
				oneLine = in.readLine();
				if(oneLine.length() > 0)
				{
					str = new StringTokenizer(oneLine);
					v = Integer.parseInt(str.nextToken());
					w = Integer.parseInt(str.nextToken());
					
					//System.out.println("edge: " + v + "--" + w);
					
					weight = McClamma_as3_Distance.Euclidean(xVals[v], yVals[v], xVals[w], yVals[w]);
					
					e = new McClamma_as3_DirectedEdge(v, w, weight);
					G.addEdge(e);
					e = new McClamma_as3_DirectedEdge(w, v, weight);
					G.addEdge(e);
				}
			}

			test(G, 0, 5);
			test(G, 0, 6);
			test(G, 0, 7);
			test(G, 0, 10);
			test(G,0,20);
			test(G,100, 20);
			test(G,100, 5000);

		} catch (IOException ioe ) {
			System.err.println("Error opening/readin input file.");
			System.exit(1);
		}
		
		
	}
	
	public static void test(McClamma_as3_WeightedGraph G, int s, int t)
	{
		McClamma_as3_DijkstraShortestPath sp;
		McClamma_as3_DijkstraShortestPathMinHeap heapSP;

		long start;
		long end;
		int[] results;
		
		
		System.out.println("\n");
		
		System.out.println("========= Running Dijkstra (Priority Queue) ========");
		System.out.println("Calculating Shortest path from source node " + s + " to destination node " + t + ".");
		start = System.nanoTime();
		sp = new McClamma_as3_DijkstraShortestPath(G, s, t);
		end = System.nanoTime();
		results = sp.path(s ,t);
		System.out.println(Arrays.toString(results));
		System.out.println("PriorityQueue Dijkstra execution time (ms): " + (end - start)/1000000);
		System.out.println("\n");
		
		System.out.println("========= Running Dijkstra (Min Heap) ========");
		System.out.println("Calculating Shortest path from source node " + s + " to destination node " + t + ".");
		start = System.nanoTime();
		heapSP = new McClamma_as3_DijkstraShortestPathMinHeap(G, s, t);
		end = System.nanoTime();
		results = heapSP.path(s,t);
		System.out.println(Arrays.toString(results));
		System.out.println("MinHeap Dijkstra execution time (ms): " + (end - start)/1000000);
		System.out.println("\n");

		
	}

}

