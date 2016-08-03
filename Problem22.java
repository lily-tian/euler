/* Author: lily.tian
 * Project Euler: Problem 22
 * Amicable Numbers
 * 
 * Using names.txt (right click and 'Save Link/Target As...'), 
 * a 46K text file containing over five-thousand first names, 
 * begin by sorting it into alphabetical order. Then working 
 * out the alphabetical value for each name, multiply this value 
 * by its alphabetical position in the list to obtain a name score.
 * 
 * For example, when the list is sorted into alphabetical order, 
 * COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th 
 * name in the list. So, COLIN would obtain a score of 938 x 53 
 * = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 * Required class: StdIn, Quick3string
 * */

public class Problem22 {
	public static void main(String[] args) {

		// stores all names in array
		String allnames = StdIn.readString();
		allnames = allnames.replaceAll("\"", "");
		String[] names = allnames.split(",");

		// uses 3-way quicksort
		Quick3string.sort(names);

		// sums up values of each name
		int sum = 0;
		for (int i = 0; i < names.length; i++) {
			String s = names[i];
			int val = 0;
			for (int j = 0; j < s.length(); j++)
				val = val + Character.getNumericValue(s.charAt(j)) - 9;
			sum += val * (i + 1);
		}

		// prints answer
		System.out.println(sum);
	}
}