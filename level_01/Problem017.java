/* Author: lily.tian
 * Project Euler: Problem 017
 * Number letter counts
 *
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains
 * 20 letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 */

public class Problem017 {
	public static void main(String[] args) {

		// stores letter count
		int[] letter = new int[1001];

		// counts letter for each number
		letter[0] = 0;
		letter[1] = 3; // one
		letter[2] = 3; // two
		letter[3] = 5; // three
		letter[4] = 4; // four
		letter[5] = 4; // five
		letter[6] = 3; // six
		letter[7] = 5; // seven
		letter[8] = 5; // eight
		letter[9] = 4; // nine
		letter[10] = 3; // ten

		letter[11] = 6; // eleven
		letter[12] = 6; // twelve
		letter[13] = 8; // thirteen
		letter[14] = 8; // fourteen
		letter[15] = 7; // fifteen
		letter[16] = 7; // sixteen
		letter[17] = 9; // seventeen
		letter[18] = 8; // eighteen
		letter[19] = 8; // nineteen

		letter[20] = 6; // twenty
		letter[30] = 6; // thirty
		letter[40] = 5; // forty
		letter[50] = 5; // fifty
		letter[60] = 5; // sixty
		letter[70] = 7; // seventy
		letter[80] = 6; // eighty
		letter[90] = 6; // ninety

		letter[1000] = 3 + 8; // one thousand

		// completes 21-99
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				letter[i * 10 + j] = letter[i * 10] + letter[j];
			}
		}

		// completes the 100s
		for (int i = 1; i < 10; i++) {
			letter[i * 100] = letter[i] + 7;
		}

		// completes 101-999
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 100; j++) {
				letter[i * 100 + j] = letter[i * 100] + 3 + letter[j];
			}
		}

		// calculates sum
		int sum = 0;
		for (int i = 1; i < letter.length; i++) {
			sum += letter[i];
		}

		// prints answer
		System.out.println(sum);
	}
}