/* Author: lily.tian
 * Project Euler: Problem 23
 * Non-abundant Sums
 *
 *A perfect number is a number for which the sum of its proper 
 *divisors is exactly equal to the number. For example, the sum 
 *of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, 
 *which means that 28 is a perfect number.
 *
 *A number n is called deficient if the sum of its proper divisors 
 *is less than n and it is called abundant if this sum exceeds n.
 *
 *As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, 
 *the smallest number that can be written as the sum of two abundant 
 *numbers is 24. By mathematical analysis, it can be shown that all 
 *integers greater than 28123 can be written as the sum of two 
 *abundant numbers. However, this upper limit cannot be reduced 
 *any further by analysis even though it is known that the greatest 
 *number that cannot be expressed as the sum of two abundant 
 *numbers is less than this limit.
 *
 *Find the sum of all the positive integers which cannot be written 
 *as the sum of two abundant numbers.
 */

public class Problem23 {
	public static void main(String[] args) {

		// initializes limit
		int limit = 28123;

		// finds out which numbers are abundant
		boolean[] abundant = new boolean[limit];
		for (int i = 1; i < limit; i++) {

			// finds the sum of all unique factors
			int factorsum = 1;
			int factor = 1;
			for (int j = 2; j < i / factor; j++) {
				if (i % j == 0) {
					factor = j;
					// prevents double-counting for squares
					if (j == i / j)
						factorsum += j;
					else
						factorsum = factorsum + j + (i / j);
				}
			}

			if (factorsum > i)
				abundant[i] = true;
		}

		// checks which numbers can be summed by abundant numbers
		boolean[] absum = new boolean[limit];
		for (int i = 0; i < limit; i++) {
			if (abundant[i]) {
				for (int j = i; j < limit; j++) {
					if (abundant[j] & (i + j) < limit) {
						absum[i + j] = true;
					}
				}
			}
		}

		// finds sum of all non-abundant sums
		int sum = 0;
		for (int i = 0; i < limit; i++) {
			if (!absum[i]) {
				sum += i;
			}
		}

		// prints answer
		System.out.println(sum);
	}
}