/* Author: lily.tian
 * Project Euler: Problem 028
 * Number spiral diagonals
 *
 * Starting with the number 1 and moving to the right in a 
 * clockwise direction a 5 by 5 spiral is formed as follows:
 *
 *21 22 23 24 25
 *20  7  8  9 10
 *19  6  1  2 11
 *18  5  4  3 12
 *17 16 15 14 13
 *
 *It can be verified that the sum of the numbers on the diagonals 
 *is 101.
 *
 *What is the sum of the numbers on the diagonals in a 1001 by 
 *1001 spiral formed in the same way?
 */

public class Problem028 {
	public static void main(String[] args) {

		// creates the grid
		int edge = 1001;
		int[][] grid = new int[edge][edge];

		// initializes center point
		int center = edge / 2;
		int x = center;
		int y = center;
		grid[center][center] = 1;

		// fills in grid
		int hops = 1;
		while (grid[0][0] == 0) {
			// right
			for (int j = 0; j < hops; j++) {
				grid[x][y + 1] = grid[x][y] + 1;
				y++;
			}
			// down
			for (int j = 0; j < hops; j++) {
				grid[x + 1][y] = grid[x][y] + 1;
				x++;
			}
			hops++;
			// left
			for (int j = 0; j < hops; j++) {
				grid[x][y - 1] = grid[x][y] + 1;
				y--;
			}
			// up
			for (int j = 0; j < hops; j++) {
				grid[x - 1][y] = grid[x][y] + 1;
				x--;
			}
			hops++;
		}
		for (int i = 1; i < edge; i++)
			grid[0][i] = grid[0][i - 1] + 1;

		// finds diagonal
		int dia = 0;
		for (int i = 0; i < edge; i++) {
			dia += grid[i][i];
			dia += grid[edge - i - 1][i];
		}

		// prints answer
		System.out.println(dia - 1);
	}
}