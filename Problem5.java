/* Author: lily.tian
 * Project Euler: Problem 5
 * Smallest Multiple
 * 
 * 2520 is the smallest number that can be divided by each
 * of the numbers from 1 to 10 without any remainder.
 * 
 * What is the smallest possible number that is evenly
 * divisible by all the numbers from 1 to 20?
 */

public class Problem5 {
	public static void main(String[] args) {

		// smallest possible number
		int num = 0;

		// goes through possible numbers
		for (int i = 1; num == 0; i++) {

			// checks if divisible from 1 to 20
			boolean divisible = true;
			for (int j = 1; j <= 20 & divisible; j++) {
				if (i % j != 0)
					divisible = false;
			}

			if (divisible)
				num = i;
		}

		// prints answer
		System.out.println(num);
	}
}