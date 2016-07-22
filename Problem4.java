/* Author: lily.tian
 * Project Euler: Problem 4
 * Largest Palindrome Product
 * 
 * A palindromic number reads the same both ways. The 
 * largest palindrome made from the product of two 2-digit
 * numbers is 9009 = 91 x 99.
 * 
 * Find the largest palindrome made from the product of 
 * two 3-digit numbers.
 */

public class Problem4 {
	public static void main(String[] args) {

		// stores largest palindrome
		int palindrome = 0;

		// goes through all possible palindromes
		for (int i = 100; i <= 999; i++) {
			for (int j = 100; j <= 999; j++) {

				int product = i * j;

				// if product greater than current palindrome
				if (product > palindrome) {
					String s = Integer.toString(product);

					// checks if palindrome
					boolean isPalindrome = true;
					int max = s.length();
					for (int index = 0; index < max / 2; index++) {
						if (s.charAt(index) != s.charAt(max - index - 1))
							isPalindrome = false;
					}

					// if palindrome, update
					if (isPalindrome)
						palindrome = product;
				}
			}
		}

		// prints answer
		System.out.println(palindrome);
	}
}