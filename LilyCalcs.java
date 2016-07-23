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

	// converts character to number
	public static int toInt(char c) {
		int n = Character.getNumericValue(c);
		return n;
	}

	// converts string to number
	public static int toInt(String s) {
		int n = Integer.parseInt(s);
		return n;
	}

	// converts int to long
	public static long toLong(int n) {
		long l = Long.valueOf(n);
		return l;
	}

	public static void main(String[] args) throws Exception {

		LilyCalcs calc = new LilyCalcs();
		boolean x = calc.isPrime(2);
		boolean y = calc.isPalindrome("heh");

		// prints answer
		System.out.println(x + " " + y);

	}
}