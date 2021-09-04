/* Zackary McClamma
 * CPS 530
 * Assignment 3
 * 27 July 2020 */

/* This is the Distance class given during lecture, it calculates the euclidean distance between points*/
public class McClamma_as3_Distance {
	public static double Euclidean(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt(Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2));
		
	}
}
