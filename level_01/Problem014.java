/* Author: lily.tian
 * Project Euler: Problem 014
 * Longest Collatz sequence
 *
 * The following iterative sequence is defined for the set of positive integers:
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains
 * 10 terms. Although it has not been proved yet (Collatz Problem), it is thought
 * that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */

public class Problem014 {
	public static void main(String[] args) {

		// initializes the max limit
		int max = 1000000;

		// stores sequences of all positive numbers under the max
		long[] chain = new long[max - 1];

		// finds path of each number
		for (int i = 0; i < chain.length; i++) {
			// skip if number is on path of another number
			if (chain[i] >= 0) {

				// initializes the new number and its length
				long n = i + 1;
				long hops = 0;

				// finds length of sequence, knocking out all numbers in path
				while (n != 1) {
					if (n % 2 == 0) {
						n = n / 2;
						if (n < max)
							chain[(int) n - 1] = -1;
					} else {
						n = n * 3 + 1;
						if (n < max)
							chain[(int) n - 1] = -1;
					}
					hops++;
				}
				chain[i] = hops;
			}
		}

		// goes through all numbers for greatest length
		int starter = 1;
		long longest = 0;
		for (int i = 0; i < chain.length; i++) {
			if (chain[i] > longest) {
				longest = chain[i];
				starter = i + 1;
			}
		}

		// prints answer
		System.out.println(starter);
	}
}