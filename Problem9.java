/* Author: lily.tian
 * Project Euler: Problem 9
 * Special Pythagorean Triplet
 * 
 * A Pythagorean triple is a set of three natural numbers
 * a < b < c, for which, 
 * 
 * a^2 + b^2 = c^2
 * 
 * For example 3^2 + 4^2 = 9 + 16 = 25 = 5^2 
 * 
 * There exists exactly one Pythagorean triplet for which
 * a + b + c = 1000.
 * 
 * Find product abc. 
 */

public class Problem9 {
	public static void main(String[] args) {

		// initializes product
		int abc = 0;

		// goes through all a's and b's that fit criteria
		for (int i = 1; i < 998; i++) {
			for (int j = i + 1; j < 999; j++) {
				int c = 1000 - i - j;
				if (i * i + j * j == c * c) {
					abc = i * j * c;
				}
			}
		}

		// prints answer
		System.out.println(abc);
	}
}