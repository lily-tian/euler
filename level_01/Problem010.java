/* Author: lily.tian
 * Project Euler: Problem 010
 * Summation of primes
 *
 * The summation of primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all primes below two million.
 *
 * Dependencies: LilyCalcs
 */

public class Problem010 {
	public static void main(String[] args) throws Exception {

		// initializes summation of primes and max prime n
		long sum = 0;
		int n = 2000000;

		// sets up array of all numbers to look through
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = i + 1;

		// opens calculator
		LilyCalcs calc = new LilyCalcs();

		// goes through all existing numbers
		for (int i = 1; i < n; i++) {
			if (nums[i] != 0) {

				// adds to sum
				sum += calc.toLong(nums[i]);

				// clears all numbers that are multiples
				for (int j = 2; j <= n / nums[i]; j++) {
					int multiple = nums[i] * j;
					nums[multiple - 1] = 0;
				}
			}
		}

		// prints answer
		System.out.println(sum);
	}
}