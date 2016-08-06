/* Author: lily.tian
 * Project Euler: Problem 026
 * Reciprocal cycles
 *
 * A unit fraction contains 1 in the numerator. The decimal representation 
 * of the unit fractions with denominators 2 to 10 are given:
 * 
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 * 
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. 
 * It can be seen that 1/7 has a 6-digit recurring cycle.
 * 
 * Find the value of d < 1000 for which 1/d contains the longest 
 * recurring cycle in its decimal fraction part.
 */

public class Problem026 {
	public static void main(String[] args) {

		// initializes max denominator and longest cycle
		int maxd = 1000;
		int lcycle = 0;

		// finds denominator with longest cycle
		int longd = 0;
		for (int d = 2; d < maxd; d++) {

			// stores all possible remainders
			int[] r = new int[d];

			// goes through each new numerator
			int n = 1;
			int c = 0;
			while (r[0] == 0) {

				// finds new remainder
				while (n < d)
					n *= 10;
				n = n % d;

				// increases count for all remainders
				if (r[n] == 0) {
					for (int j = 0; j < r.length; j++) {
						if (r[j] > 0)
							r[j]++;
					}
					r[n] = 1;
				} else {
					c = r[n];
					break;
				}
			}

			// check if longest cycle
			if (c > lcycle) {
				lcycle = c;
				longd = d;
			}
		}

		// prints answer
		System.out.println(longd);
	}
}