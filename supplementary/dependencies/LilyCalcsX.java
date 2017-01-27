/* Author: lily.tian
 * LilyCalcsX
 * 
 * Compilation of simple calculations.
 * 
 * Note: Remember to throw Exceptions!
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;

public class LilyCalcsX {

	private ArrayList<String[]> q;
	private ArrayList<int[]> intAL;
	private HashSet<String> h;

	public LilyCalcsX() {
	}

	private void getC(String s, int nc, int rc, int n, int r) {
		if (nc < n && rc != r) {
			nc++;
			getC(s, nc, rc, n, r);
			rc++;
			getC(s + " " + nc, nc, rc, n, r);
		} else if (rc == r) {
			if (!h.contains(s)) {
				q.add(s.substring(1).split(" "));
				h.add(s.substring(1));
			}
		}
	}

	public ArrayList<String[]> getCombos(int n, int r) {
		this.q = new ArrayList<String[]>();
		this.h = new HashSet<String>();
		getC("", 0, 0, n, r);
		return q;
	}

	private void getP(String s, LinkedList<Integer> num, int n, int r) {
		if (num.size() > n - r) {
			for (int i = 0; i < num.size(); i++) {
				LinkedList<Integer> newnum = (LinkedList) num.clone();
				getP(s + " " + newnum.remove(i), newnum, n, r);
			}
		} else {
			q.add(s.substring(1).split(" "));
		}
	}

	public ArrayList<String[]> getPerm(int n, int r) {
		this.q = new ArrayList<String[]>();
		LinkedList<Integer> num = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			num.add(i);
		}
		getP("", num, n, r);
		return q;
	}

	private void getPD(ArrayList<Integer> s, int start, int n, int r) {
		if (s.size() < r) {
			for (int i = start; i < n; i++) {
				ArrayList<Integer> next = (ArrayList<Integer>) s.clone();
				next.add(i);
				getPD(next, start, n, r);
			}
		} else {
			int[] a = new int[s.size()];
			for (int i = 0; i < a.length; i++)
				a[i] = s.get(i);
			intAL.add(a);
		}
	}

	public ArrayList<int[]> getPermD(int n, int r) {
		this.intAL = new ArrayList<int[]>();
		getPD(new ArrayList<Integer>(), 0, n, r);
		return intAL;
	}

	// creates a decimal array of number with specific decimal places
	public static int[] getDecimal(int n, int size) throws Exception {
		int[] decimal = new int[size];
		String s = "" + n;
		if (s.length() <= size) {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(s.length() - 1 - i);
				decimal[i] = Character.getNumericValue(c);
			}
		} else
			throw new Exception("Array size too small.");
		return decimal;
	}

	// creates a decimal array of string with specific decimal places
	public static int[] getDecimal(String s, int size) throws Exception {
		int[] decimal = new int[size];
		if (s.length() <= size) {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(s.length() - 1 - i);
				decimal[i] = Character.getNumericValue(c);
			}
		} else
			throw new Exception("Array size too small.");
		return decimal;
	}

	// creates a decimal array of number
	public static int[] getDecimal(int n) {
		String s = "" + n;
		int[] decimal = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(s.length() - 1 - i);
			decimal[i] = Character.getNumericValue(c);
		}
		return decimal;
	}

	// reverses array
	public static int[] reverseArray(int[] a) {
		int[] newa = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			newa[i] = a[a.length - 1 - i];
		}
		return newa;
	}

	// reverses string
	public static String reverseString(String s) {
		String newstring = "";
		for (int i = 0; i < s.length(); i++) {
			newstring += s.charAt(s.length() - 1 - i);
		}
		return newstring;
	}

	// creates array of number
	public static int[] toArray(int n) {
		String s = "" + n;
		int[] decimal = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			decimal[i] = Character.getNumericValue(s.charAt(i));
		}
		return decimal;
	}

	// performs addition on two decimal arrays
	public static int[] dAdd(int[] decimal, int[] add) {

		for (int i = 0; i < add.length; i++)
			decimal[i] += add[i];
		for (int i = 0; i < decimal.length - 1; i++) {
			decimal[i + 1] += (decimal[i] / 10);
			decimal[i] %= 10;
		}

		decimal[decimal.length - 1] %= 10;
		return decimal;
	}

	// performs decimal addition on two numbers
	public static int[] dAdd(int n1, int n2) {
		return dAdd(getDecimal(n1), getDecimal(n2));
	}

	// performs decimal addition on two numbers with specific size
	public static int[] dAdd(int n1, int n2, int size) throws Exception {
		return dAdd(getDecimal(n1, size), getDecimal(n2, size));
	}

	// performs multiplication on two decimal arrays
	public static int[] dMulti(int[] decimal, int[] multi) {

		int[] sum = new int[decimal.length];
		for (int i = 0; i < multi.length; i++) {
			int[] temp = new int[decimal.length];
			for (int j = 0; j + i < decimal.length; j++) {
				temp[j + i] = decimal[j] * multi[i];
			}
			for (int j = 0; j < decimal.length - 1; j++) {
				temp[j + 1] += (temp[j] / 10);
				temp[j] %= 10;
			}
			temp[decimal.length - 1] %= 10;
			sum = dAdd(sum, temp);
		}
		return sum;
	}

	// performs decimal multiplication on two numbers
	public static int[] dMulti(int n1, int n2) {
		return dMulti(getDecimal(n1), getDecimal(n2));
	}

	// performs decimal multiplication on two numbers with specific size
	public static int[] dMulti(int n1, int n2, int size) throws Exception {
		return dMulti(getDecimal(n1, size), getDecimal(n2, size));
	}

	public static String dString(int[] decimal) {
		String s = "";
		for (int i = decimal.length - 1; i >= 0; i--)
			s += decimal[i];
		return s;
	}

	public static String cutZero(int[] a) {
		String s = dString(a);
		return cutZero(s);
	}

	public static String cutZero(String s) {
		int zeroEnd = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '0') {
				zeroEnd = i;
				break;
			}
		}
		return s.substring(zeroEnd);
	}

	public static int dInt(int[] decimal) {
		return Integer.parseInt(dString(decimal));
	}

	// checks if number is prime
	public static boolean isPrime(int x) throws Exception {
		if (x == 1)
			return false;
		if (x > 1) {
			boolean isprime = true;
			for (int i = 2; i <= x / i; i++) {
				if (x % i == 0) {
					isprime = false;
					break;
				}
			}
			return isprime;
		} else
			throw new Exception("Number must be positive.");
	}

	// checks if number is prime
	public static boolean isPrime(long x) throws Exception {
		if (x == 1L)
			return false;
		if (x > 1L) {
			boolean isprime = true;
			for (long i = 2L; i <= x / i; i++) {
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
			for (int i = 2; i <= x / i; i++) {
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

	// returns array of all prime numbers less than n
	public static int[] allPrimeN(int n) {
		boolean[] p = allPrime(n);
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			if (p[i])
				a.add(i);
		int[] primes = new int[a.size()];
		for (int i = 0; i < primes.length; i++)
			primes[i] = a.get(i);
		return primes;
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

	// returns combination of a number (smaller numbers)
	public static int c(int n, int k) {
		return (factorial(n) / factorial(k) / factorial(n - k));
	}

	// returns combination of a number using factorization (big numbers)
	public static long nCrf(int n, int r, int b) {
		int[] nfactors = new int[n + 1];
		int[] rfactors = new int[r + 1];
		for (int i = n; i > n - r; i--) {
			LinkedList<Integer> q = factorization(i);
			while (!q.isEmpty())
				nfactors[q.remove()]++;
		}
		for (int i = r; i > 1; i--) {
			LinkedList<Integer> q = factorization(i);
			while (!q.isEmpty())
				rfactors[q.remove()]++;
		}
		for (int i = 0; i < rfactors.length; i++)
			while (rfactors[i] > 0) {
				nfactors[i]--;
				rfactors[i]--;
			}
		long cnr = 1;
		for (int i = 0; i < nfactors.length; i++) {
			while (nfactors[i] > 0) {
				if (cnr * i < b) {
					cnr *= i;
					nfactors[i]--;
				} else
					return -1;
			}
		}
		return cnr;
	}

	// returns factorial of a number
	public static int factorial(int n) {
		if (n > 1)
			return n * factorial(n - 1);
		else
			return 1;
	}

	// returns factorial of a number
	public static long factorial(long n) {
		if (n > 1L)
			return n * factorial(n - 1);
		else
			return 1L;
	}

	// returns factorial of a number up to k
	public static long truncfact(long n, long k) {
		long f = 0;
		while (n > k) {
			f *= n;
			n--;
		}
		return f;
	}

	// gets all factors of a number
	public static LinkedList<Integer> getFactors(int n) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		for (int i = 2; i <= n; i++)
			if (n % i == 0)
				q.add(i);
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

	// relatively prime
	public static boolean rprime(int n, int m) {
		boolean rprime = true;
		LinkedList<Integer> qn = getFactors(n);
		LinkedList<Integer> qm = getFactors(m);
		int nfact = qn.remove();
		int mfact = qm.remove();
		while (true) {
			if (nfact == mfact) {
				rprime = false;
				break;
			} else if (nfact > mfact && !qm.isEmpty())
				mfact = qm.remove();
			else if ((nfact < mfact && !qn.isEmpty()))
				nfact = qn.remove();
			else
				break;
		}
		return rprime;
	}

	// breaks number into factors
	public static LinkedList<Integer> factorization(int n) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		while (n > 1) {
			q.add(LF(n));
			n = n / LF(n);
		}
		return q;
	}

	// simplfies fraction
	public static int[] simplifyF(int n, int d) {
		LinkedList<Integer> nfact = factorization(n);
		LinkedList<Integer> dfact = factorization(d);
		if (!nfact.isEmpty() && !dfact.isEmpty()) {
			int nf = nfact.remove();
			int df = dfact.remove();
			while (true) {
				if (nf == df) {
					n /= nf;
					d /= df;
					if (!nfact.isEmpty() && !dfact.isEmpty()) {
						nf = nfact.remove();
						df = dfact.remove();
					} else
						break;
				} else if (nf > df) {
					if (!dfact.isEmpty())
						df = dfact.remove();
					else
						break;
				} else {
					if (!nfact.isEmpty())
						nf = nfact.remove();
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

	// checks if numbers are permutations of one another
	public static boolean isPerm(int ii, int jj) {

		// finds frequency of every digit
		String si = "" + ii;
		String sj = "" + jj;
		if (si.length() != sj.length())
			return false;
		int[] ai = new int[10];
		int[] aj = new int[10];
		for (int i = 0; i < si.length(); i++) {
			ai[Character.getNumericValue(si.charAt(i))]++;
			aj[Character.getNumericValue(sj.charAt(i))]++;
		}
		return Arrays.equals(ai, aj);
	}

	public static <E> void printDA(E[][] a) {
		for (E[] row : a) {
			for (E item : row)
				System.out.print(item + " ");
			System.out.println();
		}
	}

	public static <E> void printA(E[] a) {
		for (E item : a)
			System.out.print(item + " ");
		System.out.println();
	}

	public static void printPA(int[] a) {
		for (int item : a)
			System.out.print(item + " ");
		System.out.println();
	}

	public static void main(String[] args) throws Exception {

	}
}