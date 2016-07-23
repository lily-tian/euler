/* Author: lily.tian
 * Project Euler: Problem 7
 * 10001st Prime
 * 
 * By listing the first six prime numbers: 2, 3, 5, 7, 11,
 * and 13, we can see that the 6th prime is 13.
 * 
 * What is the 10001st prime number?
 * 
 * Required class: LilyCalcs
 */

public class Problem7 {
	public static void main(String[] args) throws Exception {

		// prime number and counter
		int prime = 0;
		int count = 0;

		// calculator
		LilyCalcs calc = new LilyCalcs();

		// goes through primes
		for (int i = 2; count < 10001; i++) {
			if (calc.isPrime(i)) {
				prime = i;
				count++;
			}
		}

		// prints answer
		System.out.println(prime);
	}
}