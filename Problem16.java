/* Author: lily.tian
 * Project Euler: Problem 16
 * Power Digit Sum
 * 
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 */

public class Problem16 {
	public static void main(String[] args) {

		// initializes decimal holder
		int power = 1000;
		int[] decimal = new int[power];
		decimal[0] = 1;

		// repeats doubling each time per power
		for (int i = 0; i < power; i++) {
			// doubles then carries over
			for (int j = decimal.length - 1; j >= 0; j--) {
				if (decimal[j] > 0) {
					decimal[j] *= 2;
					if (decimal[j] >= 10) {
						decimal[j] -= 10;
						decimal[j + 1]++;
					}
				}
			}
		}

		// adds up digits
		int sum = 0;
		for (int i = 0; i < decimal.length; i++)
			sum += decimal[i];

		// prints answer
		System.out.println(sum);
	}
}