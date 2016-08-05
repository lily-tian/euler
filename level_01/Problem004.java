/* Author: lily.tian
 * Project Euler: Problem 004
 * Largest palindrome product
 *
 * A palindromic number reads the same both ways. The
 * largest palindrome made from the product of two 2-digit
 * numbers is 9009 = 91 x 99.
 *
 * Find the largest palindrome made from the product of
 * two 3-digit numbers.
 *
 * Dependencies: LilyCalcs
 */

public class Problem004 {
	public static void main(String[] args) throws Exception{

		// stores largest palindrome
		int palindrome = 0;

		// goes through all possible palindromes
		for (int i = 100; i <= 999; i++) {
			for (int j = 100; j <= 999; j++) {

				int product = i * j;

				// if product greater than current palindrome
				if (product > palindrome) {

					// if palindrome, update
					String s = Integer.toString(product);
					LilyCalcs calc = new LilyCalcs();
					if (calc.isPalindrome(s))
						palindrome = product;
				}
			}
		}

		// prints answer
		System.out.println(palindrome);
	}
}