/* Author: lily.tian
 * Project Euler: Problem 20
 * Factorial Digit Sum
 * 
 * n! means n x (n - 1) x ... x 3 x 2 x 1
 * 
 * For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 
 * 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 */

public class Problem20 {
	public static void main(String[] args) {

		// initialize n factorial
		int n = 100;

		// initializes array to store digits
		int digits = 1000;
		int[] product = new int[digits];
		product[0] = 1;

		// multiplies by next factorial
		for (int i = 1; i < n + 1; i++) {

			// finds each digit of factorial
			int hundreds = (i % 1000) / 100;
			int tens = (i % 100) / 10;
			int ones = (i % 10) / 1;

			// initializes new array
			int[] hundred = new int[digits];
			int[] ten = new int[digits];
			int[] one = new int[digits];

			// multiplies each decimal place
			for (int j = 0; j < digits - 2; j++) {
				one[j] = product[j] * ones;
				ten[j + 1] = product[j] * tens;
				hundred[j + 2] = product[j] * hundreds;
			}

			// carries over
			for (int j = 0; j < digits - 2; j++) {
				while (one[j] > 9) {
					one[j] -= 10;
					one[j + 1]++;
				}
				while (ten[j + 1] > 9) {
					ten[j + 1] -= 10;
					ten[j + 2]++;
				}
				while (hundred[j + 2] > 9) {
					hundred[j + 2] -= 10;
					hundred[j + 3]++;
				}
			}

			// sets product as sum of each
			for (int j = 0; j < digits; j++)
				product[j] = hundred[j] + ten[j] + one[j];
		}

		// sums digits
		int sum = 0;
		for (int i = 0; i < digits; i++)
			sum += product[i];

		// prints answer
		System.out.println(sum);
	}
}