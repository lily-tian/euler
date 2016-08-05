/* Author: lily.tian
 * Project Euler: Problem 024
 * Lexicographic permutations
 *
 *A permutation is an ordered arrangement of objects. For
 *example, 3124 is one possible permutation of the digits
 *1, 2, 3 and 4. If all of the permutations are listed
 *numerically or alphabetically, we call it lexicographic
 *order. The lexicographic permutations of 0, 1 and 2 are:
 *
 *012   021   102   120   201   210
 *
 *What is the millionth lexicographic permutation of the
 *digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

public class Problem024 {
	public static void main(String[] args) {

		/*
		 * Note there are 9! of first digit = x, followed by 8! of second digit
		 * = y, etc
		 */

		// initializes digits and lexi permutation
		int digits = 10;
		int countdown = 1000000;

		// stores the frequency count of every digit
		int[] frequency = new int[digits];
		for (int i = 0; i < digits; i++) {
			// finds the factorial, aka times a digit appears
			int factorial = 1;
			for (int j = digits - i - 1; j > 0; j--)
				factorial *= j;
			frequency[i] = factorial;
		}

		// finds the permutation
		int[] num = new int[digits];
		boolean[] taken = new boolean[digits];
		// repeats for each decimal place
		for (int i = 0; i < digits - 1; i++) {

			// finds which digit belongs in decimal place
			int n = (countdown - 1) / frequency[i] + 1;
			if (countdown % frequency[i] == 0)
				countdown = frequency[i];
			else
				countdown = countdown % frequency[i];

			// finds which digits have not been taken
			int index = 0;
			for (int j = 0; n > 0; j++) {
				if (!taken[j]) {
					index = j;
					n--;
				}
			}
			num[i] = index;
			taken[index] = true;
		}

		// finds last digit
		num[digits - 1] = -1;
		for (int i = 0; num[digits - 1] < 0; i++)
			if (!taken[i])
				num[digits - 1] = i;

		// prints answer
		for (int i = 0; i < digits; i++)
			System.out.print(num[i]);
		System.out.println("");
	}
}