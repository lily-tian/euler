/* Author: lily.tian
 * Project Euler: Problem 027
 * Quadratic primes
 *
 *Euler discovered the remarkable quadratic formula:
 *
 *n^2 + n + 41
 *
 *It turns out that the formula will produce 40 primes for
 *the consecutive integer values 0 <= n <= 39. However, when n = 40,
 *40^2 + 40 + 41 = 40(40+1) + 41 is divisible by 41, and certainly
 *when n = 41, 41^2 + 41 + 41n = 41 is clearly divisible by 41.
 *
 *The incredible formula n^2 - 79n + 1601 was discovered,
 *which produces 80 primes for the consecutive values 0 <= n <=79.
 *The product of the coefficients, -79 and 1601, is 126479.
 *
 *Considering quadratics of the form:
 *
 **n^2 + an + b, where |a| < 1000 and |b| <= 1000
 *
 *where |n| is the modulus/absolute value of n.
 *
 *Find the product of the coefficients, a and b, for the
 *quadratic expression that produces the maximum number of
 *primes for consecutive values of n, starting with n = 0.
 */

public class Problem027 {
	public static void main(String[] args) throws Exception {

		// initializes max value
		int max = 1000;

		// stores all possible a and b coefficients
		/* note that when n = 0, b cannot be negative */
		int[] a = new int[2 * max - 1];
		int[] b = new int[max];
		for (int i = 0; i < a.length; i++)
			a[i] = i - max + 1;
		for (int i = 0; i < b.length; i++)
			b[i] = i + 1;

		// tries brute force method
		int longn = 0;
		int longa = 0;
		int longb = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				int n = 0;
				while (calc.isPrimeN(n * (n + a[i]) + b[j]))
					n++;
				if (n > longn) {
					longn = n - 1;
					longa = a[i];
					longb = b[j];
				}
			}
		}

		// prints answer
		System.out.println(longa*longb);
		
		/* The following are implementations to quicken algorithm*/
		
		// stores qualified a and b
		boolean[] qa = new boolean[a.length];
		boolean[] qb = new boolean[b.length];
		
		/* note that when n = 0, b must be prime! */
		LilyCalcs calc = new LilyCalcs();
		for (int i = 0; i < b.length; i++) {
			if (calc.isPrime(b[i]))
				qb[i] = true;
		}
		
		/* note that n * (n + a) must be even */
		/* note that when n = 1, a must be odd */
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0)
				qa[i] = true;
		}
		/* The above are implementations to quicken algorithm*/
	}
}