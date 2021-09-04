/* Zackary McClamma
 * CPS 530
 * Assignment 3
 * 27 July 2020 */

/* This is the Pair class(taken from the lecture notes)*/
public class McClamma_as3_Pair implements Comparable<McClamma_as3_Pair> {
	Double key;
	int value;
	
	public McClamma_as3_Pair(Double key, int value)
	{
		this.key = key; 
		this.value = value;
	}
	
	@Override
	public int compareTo(McClamma_as3_Pair that)
	{
		return this.key.compareTo(that.key);
	}

}
