/* Zackary McClamma
 * CPS 530
 * Assignment 3
 * 27 July 2020 */

/* This is the DirectedEdge class given during lecture*/
public class McClamma_as3_DirectedEdge {
	private final int v, w;
	private final double weight;
	
	public McClamma_as3_DirectedEdge(int v, int w, double weight)
	{
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int from()
	{
		return v;
	}
	
	public int to()
	{
		return w;
	}
	
	public double weight()
	{
		return weight;
	}
	
	public String toString()
	{
		return Integer.toString(v) + "-->" + Integer.toString(w) + " weight: " + Double.toString(weight);
	}
}
