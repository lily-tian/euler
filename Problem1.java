/* Author: lily.tian
 * Project Euler: Problem 1
 * Multiples of 3 and 5
 * 
 * If we list all the natural numbers below ten that are multiples of 3 or 5, 
 * we get 3, 5, 6, and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all multiples of 3 or 5 below 1000.
 */

public class Problem1 {
	public static void main(String[] args) {

		// stores the sum thus far
		int sum = 0;

		// adds all multiples of 3
		for (int i = 3; i < 1000; i += 3) {
			sum += i;
		}

		// adds all multiples of 5 that are not already multiples of 3
		for (int i = 5; i < 1000; i += 5) {
			if (i % 3 != 0)
				sum += i;
		}

		// prints answer
		System.out.println(sum);
	}
}