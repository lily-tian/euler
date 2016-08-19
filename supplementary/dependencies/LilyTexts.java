/* Author: lily.tian
 * LilyTexts
 * 
 * Compilation of simple calculations.
 * 
 * Note: Remember to throw Exceptions!
 */

public class LilyTexts {

	// parses list of text and places words into a queue
	public static Queue<String> parseText(String s) {
		Queue<String> q = new Queue<String>();
		int i = 0;
		while (i < s.length()) {
			String w = "";
			if (s.charAt(i) == '\"') {
				while (i < s.length() && s.charAt(i + 1) != '\"') {
					w += s.charAt(i + 1);
					i++;
				}
				i++;
			}
			i++;
			q.enqueue(w);
		}
		return q;
	}

	// returns number value of a character
	public static int alphaNum(char c) {
		int decimal = (int) c;
		if (decimal < 91)
			decimal -= 64;
		else
			decimal -= 96;
		return decimal;
	}

	public static void main(String[] args) {

		LilyTexts text = new LilyTexts();
		System.out.println(text.alphaNum('S'));
	}
}