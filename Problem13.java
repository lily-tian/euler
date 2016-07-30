/* Author: lily.tian
 * Project Euler: Problem 13
 * Large Sum
 * 
 * Work out the first ten digits of the sum of the following 
 * one-hundred 50-digit numbers.
 * 
 * Required class: StdIn, LilyCalcs
 */

public class Problem13 {
	public static void main(String[] args) throws Exception {

		// reads input
		String[] input = StdIn.readAllStrings();

		// opens calculator
		LilyCalcs calc = new LilyCalcs();

		// stores sum in array of decimal places
		int[] digits = new int[input[0].length()];
		for (int i = 0; i < input[i].length(); i++) {
			digits[i] = 0;
			for (int j = 0; j < input.length; j++) {
				digits[i] += calc.toInt(input[j].charAt(i));
			}
		}

		// carries tens over
		for (int i = digits.length - 1; i > 0; i--) {
			while (digits[i] >= 10) {
				digits[i] = digits[i] - 10;
				digits[i - 1] = digits[i - 1] + 1;
			}
		}

		// finds first ten digits
		int firstdigits = 10;
		String sum = "";
		for (int i = 0; sum.length() < firstdigits; i++) {
			sum = sum + digits[i];
		}

		// prints answer
		System.out.println(sum);
	}
}