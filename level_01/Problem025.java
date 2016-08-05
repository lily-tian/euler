/* Author: lily.tian
 * Project Euler: Problem 025
 * 1000-digit Fibonacci number
 *
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * Fn = F(n-1) + F(n-2), where F1 = 1 and F2 = 1.
 *
 * Hence the first 12 terms will be:
 *
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 *
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence to
 * contain 1000 digits?
 */

public class Problem025 {
	public static void main(String[] args) {

		// initializes 1000-digit numbers
		int digits = 1000;
		int[] first = new int[digits];
		int[] second = new int[digits];
		first[0] = 1;
		second[0] = 1;

		// finds index
		int index = 2;
		int[] next = new int[digits];
		while (next[digits - 1] == 0) {
			// finds next fibonacci
			for (int i = 0; i < digits; i++)
				next[i] = first[i] + second[i];

			// carries over digits
			for (int i = 0; i < digits; i++) {
				while (next[i] > 9) {
					next[i] -= 10;
					next[i + 1]++;
				}
			}

			// replaces previous numbers in sequence
			for (int i = 0; i < digits; i++) {
				first[i] = second[i];
				second[i] = next[i];
			}
			index++;
		}

		// prints answer
		System.out.println(index);
	}
}