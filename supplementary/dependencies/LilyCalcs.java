/* Author: lily.tian
 * Lily Calcs
 * 
 * Compilation of simple calculations.
 * 
 * Note: Remember to throw Exceptions!
 */

public class LilyCalcs {

	// checks if number is prime
	public static boolean isPrime(int x) throws Exception {
		if (x == 1)
			return false;
		if (x > 1) {
			boolean isprime = true;
			for (int i = 2; i < x; i++) {
				if (x % i == 0) {
					isprime = false;
					break;
				}
			}
			return isprime;
		} else
			throw new Exception("Number must be positive.");
	}

	// checks if number is prime (with negative numbers)
	public static boolean isPrimeN(int x) {
		if (x > 1) {
			boolean isprime = true;
			for (int i = 2; i < x; i++) {
				if (x % i == 0) {
					isprime = false;
					break;
				}
			}
			return isprime;
		} else
			return false;
	}

	// returns boolean array of all prime numbers less than n
	public static boolean[] allPrime(int n) {

		// sets up array of all numbers to look through
		boolean[] isPrime = new boolean[n];
		for (int i = 2; i < n; i++)
			isPrime[i] = true;

		// clears all multiples
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				for (int j = 2; j * i < n; j++) {
					int multiple = i * j;
					isPrime[multiple] = false;
				}
			}
		}

		return isPrime;
	}

	// checks if string is palindrome
	public static boolean isPalindrome(String s) throws Exception {
		int n = s.length();
		if (n > 0) {
			boolean ispalindrome = true;
			for (int i = 0; i < n / 2; i++) {
				if (s.charAt(i) != s.charAt(n - i - 1)) {
					ispalindrome = false;
					break;
				}
			}
			return ispalindrome;
		} else
			throw new Exception("String must be at least one character long.");
	}

	// gets all factors of a number
	public static Queue<Integer> getFactors(int n) {
		Queue<Integer> q = new Queue<Integer>();
		for (int i = 2; i <= n; i++)
			if (n % i == 0)
				q.enqueue(i);
		return q;
	}

	// returns lowest factor
	public static int LF(int n) {
		int lf = 0;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				lf = i;
				break;
			}
		}
		return lf;
	}

	// breaks number into factors
	public static Queue<Integer> factorization(int n) {
		Queue<Integer> q = new Queue<Integer>();
		while (n > 1) {
			q.enqueue(LF(n));
			n = n / LF(n);
		}
		return q;
	}

	// simplfies fraction
	public static int[] simplifyF(int n, int d) {
		Queue<Integer> nfact = factorization(n);
		Queue<Integer> dfact = factorization(d);
		if (!nfact.isEmpty() && !dfact.isEmpty()) {
			int nf = nfact.dequeue();
			int df = dfact.dequeue();
			while (true) {
				if (nf == df) {
					n /= nf;
					d /= df;
					if (!nfact.isEmpty() && !dfact.isEmpty()) {
						nf = nfact.dequeue();
						df = dfact.dequeue();
					} else
						break;
				} else if (nf > df) {
					if (!dfact.isEmpty())
						df = dfact.dequeue();
					else
						break;
				} else {
					if (!nfact.isEmpty())
						nf = nfact.dequeue();
					else
						break;
				}
			}
		}
		int[] nd = { n, d };
		return nd;
	}

	// checks if every digit in number is unique (excludes zero)
	public boolean unique(int n) {
		String s = "" + n;
		boolean[] digit = new boolean[s.length() + 1];
		for (int i = 0; i < s.length(); i++) {
			int index = Character.getNumericValue(s.charAt(i));
			digit[index] = true;
		}
		boolean all = true;
		for (int i = 1; i < digit.length; i++)
			all &= digit[i];
		return all;
	}

	// converts character to integer
	public static int toInt(char c) {
		int n = Character.getNumericValue(c);
		return n;
	}

	// converts string to integer
	public static int toInt(String s) {
		int n = Integer.parseInt(s);
		return n;
	}

	// converts integer to long
	public static long toLong(int n) {
		long l = Long.valueOf(n);
		return l;
	}

	// converts double to integer
	public static int toInt(double d) {
		return (int) d;
	}

	public static void main(String[] args) throws Exception {

		LilyCalcs calc = new LilyCalcs();
		boolean x = calc.isPrime(2);
		boolean y = calc.isPalindrome("heh");

		// prints answer
		System.out.println(x + " " + y);

	}
}