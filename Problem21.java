/* Author: lily.tian
 * Project Euler: Problem 21
 * Amicable Numbers
 * 
 * Let d(n) be defined as the sum of proper divisors of n 
 * (numbers less than n which divide evenly into n).
 * 
 * If d(a) = b and d(b) = a, where a != b, then a and b are 
 * an amicable pair and each of a and b are called amicable 
 * numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 
 * 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so
 * d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 */

public class Problem21 {
	public static void main(String[] args) {

		// initialize max
		int max = 10000;

		// initializes array of all numbers and amiacable
		boolean[] checked = new boolean[max];
		boolean[] am = new boolean[max];

		// checks through all unchecked numbers
		for (int i = 1; i < max; i++) {
			if (!checked[i]) {
				checked[i] = true;

				// sums all factors of i
				int isum = 1;
				int factor = 1;
				for (int j = 2; j < i / factor; j++) {
					if (i % j == 0) {
						isum = isum + j + (i / j);
						factor = j;
					}
				}

				// checks number does not pair with itself
				if (i != isum) {

					// makes sure pair is checked
					if (isum < max)
						checked[isum] = true;

					// sums all factors of pair
					int psum = 1;
					factor = 1;
					for (int j = 2; j < isum / factor; j++) {
						if (isum % j == 0) {
							psum = psum + j + (isum / j);
							factor = j;
						}
					}

					// if pairs match, then flip am
					if (i == psum) {
						am[i] = true;
						if (isum < max)
							am[isum] = true;
					}
				}
			}
		}

		// finds sum
		int sum = 0;
		for (int i = 0; i < max; i++)
			if (am[i])
				sum += i;

		// prints answer
		System.out.println(sum);
	}
}