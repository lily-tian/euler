/* Author: lily.tian
 * Project Euler: Problem 3
 * Largest Prime Factor
 * 
 * The prime factors of 13195 are 5, 7, 13, and 29.
 * 
 * What is the largest prime factor of 600851475143?
 * 
 * Required class: LilyCalcs
 */

public class Problem3 {
	public static void main(String[] args) throws Exception{

		// starts with number
		long num = 600851475143L;

		// stores largest prime thus far
		int prime = 1;

		// divides the number
		for (int i = 1; i <= num; i++) {

			// finds factors
			if (num % i == 0) {
				num /= i;

				// if prime, saves largest prime thus far
				LilyCalcs n = new LilyCalcs();
				if (n.isPrime(i))
					prime = i;
			}
		}

		// prints answer
		System.out.println(prime);
	}
}