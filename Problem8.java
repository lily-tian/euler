/* Author: lily.tian
 * Project Euler: Problem 8
 * Largest Product in a Series
 * 
 * The four adjacent digits in the 1000-digit number that 
 * have the greatest product are 9 x 9 x 8 x 9 = 5832. 
 * 
 * 73167176531330624919225119674426574742355349194934
 * 96983520312774506326239578318016984801869478851843
 * 85861560789112949495459501737958331952853208805511
 * 12540698747158523863050715693290963295227443043557
 * 66896648950445244523161731856403098711121722383113
 * 62229893423380308135336276614282806444486645238749
 * 30358907296290491560440772390713810515859307960866
 * 70172427121883998797908792274921901699720888093776
 * 65727333001053367881220235421809751254540594752243
 * 52584907711670556013604839586446706324415722155397
 * 53697817977846174064955149290862569321978468622482
 * 83972241375657056057490261407972968652414535100474
 * 82166370484403199890008895243450658541227588666881
 * 16427171479924442928230863465674813919123162824586
 * 17866458359124566529476545682848912883142607690042
 * 24219022671055626321111109370544217506941658960408
 * 07198403850962455444362981230987879927244284909188
 * 84580156166097919133875499200524063689912560717606
 * 05886116467109405077541002256983155200055935729725
 * 71636269561882670428252483600823257530420752963450
 * 
 * Find the thirteen adjacent digits in the 1000-digit number 
 * that have the greatest product. What is the value of this 
 * product?
 * 
 * Required class: LilyCalcs
 */

public class Problem8 {
	public static void main(String[] args) {

		// inputs 1000-digit number as string
		String s = "73167176531330624919225119674426574742355"
				+ "34919493496983520312774506326239578318016984801"
				+ "86947885184385861560789112949495459501737958331"
				+ "95285320880551112540698747158523863050715693290"
				+ "96329522744304355766896648950445244523161731856"
				+ "40309871112172238311362229893423380308135336276"
				+ "61428280644448664523874930358907296290491560440"
				+ "77239071381051585930796086670172427121883998797"
				+ "90879227492190169972088809377665727333001053367"
				+ "88122023542180975125454059475224352584907711670"
				+ "55601360483958644670632441572215539753697817977"
				+ "84617406495514929086256932197846862248283972241"
				+ "37565705605749026140797296865241453510047482166"
				+ "37048440319989000889524345065854122758866688116"
				+ "42717147992444292823086346567481391912316282458"
				+ "61786645835912456652947654568284891288314260769"
				+ "00422421902267105562632111110937054421750694165"
				+ "89604080719840385096245544436298123098787992724"
				+ "42849091888458015616609791913387549920052406368"
				+ "99125607176060588611646710940507754100225698315"
				+ "52000559357297257163626956188267042825248360082"
				+ "3257530420752963450";

		// opens calculator
		LilyCalcs calcs = new LilyCalcs();

		// sets initial product
		long product = 1;

		// finds greater products
		int n = s.length();
		for (int i = 0; i <= n - 13; i++) {
			long newproduct = 1;
			for (int j = 0; j < 13; j++) {
				long digit = calcs.toLong(calcs.toInt(s.charAt(i + j)));
				newproduct *= digit;
			}
			if (newproduct > product)
				product = newproduct;
		}
		// prints answer
		System.out.println(product);
	}
}