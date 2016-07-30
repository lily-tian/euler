/* Author: lily.tian
 * Project Euler: Problem 15
 * Lattice Paths
 * 
 * Starting in the top left corner of a 2x2 grid, and only 
 * being able to move to the right and down, there are exactly 
 * 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20x20 grid?
 */

public class Problem15 {
	public static void main(String[] args) {

		// initializes length of edge of grid and path length
		double k = 20;
		double n = 2 * k;

		// calculates combination
		double c = 1;
		for (double i = n; i > n - k; i--)
			c = c * i / (i - k);

		// prints answer
		System.out.println(c);
	}
}