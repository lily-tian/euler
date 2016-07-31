/* Author: lily.tian
 * Project Euler: Problem 18
 * Maximum Path Sum I
 * 
 * By starting at the top of the triangle below and moving to 
 * adjacent numbers on the row below, the maximum total from 
 * top to bottom is 23.
 * 
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * 
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom of the triangle 
 * below.
 * 
 * NOTE: As there are only 16384 routes, it is possible to solve 
 * this problem by trying every route. However, Problem 67, is 
 * the same challenge with a triangle containing one-hundred rows; 
 * it cannot be solved by brute force, and requires a clever method! 
 * ;o)
 * 
 * Required class: StdIn
 */

public class Problem18 {
	public static void main(String[] args) {

		// reads input file
		int[] input = StdIn.readAllInts();

		// finds the base length of triangle
		int nums = input.length;
		int base = 0;
		for (int i = 1; nums > 0; i++) {
			nums -= i;
			base++;
		}

		// creates triangle
		int count = 0;
		int[][] triangle = new int[base][base];
		for (int i = 0; i < base; i++) {
			for (int j = 0; j < i + 1; j++) {
				triangle[i][j] = input[count];
				count++;
			}
		}

		// sums up from bottom to top
		for (int i = base - 1; i > 0; i--) {
			for (int j = 0; j < base - 1; j++) {
				if (triangle[i][j] > triangle[i][j + 1])
					triangle[i - 1][j] += triangle[i][j];
				else
					triangle[i - 1][j] += triangle[i][j + 1];
			}
		}

		// prints answer
		System.out.println(triangle[0][0]);
	}
}