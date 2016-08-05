/* Author: lily.tian
 * Project Euler: Problem 006
 * Sum square difference
 *
 * The sum of the squares of the first ten natural numbers
 * is,
 *
 * 1^2 + 2^2 + ... + 10^2 = 385
 *
 * The square of the sum of the first ten natural numbers
 * is,
 *
 * (1 + 2 + ... + 10)^2 55^2 = 3025
 *
 * Hence, the difference between the sum of the squares of
 * the first ten natural numbers and the square of the sum is
 * 3025 - 385 = 2640.
 *
 * Find the difference between the sum of the squares of the
 * first hundred natural numbers and the square of the sum.
 */

public class Problem006 {
	public static void main(String[] args) {

		// square of the sum
		int sum = 0;
		int sumsq = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
			sumsq += i * i;
		}
		int diff = sum * sum - sumsq;

		// prints answer
		System.out.println(diff);
	}
}