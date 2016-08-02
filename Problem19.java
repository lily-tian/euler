/* Author: lily.tian
 * Project Euler: Problem 19
 * Counting Sundays
 * 
 * You are given the following information, but you may prefer to 
 * do some research for yourself.
 * 
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on 
 * a century unless it is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth 
 * century (1 Jan 1901 to 31 Dec 2000)?
 */

public class Problem19 {
	public static void main(String[] args) {

		// stores days in each month of year
		int[] year = new int[12];
		year[0] = 31;
		year[1] = 28;
		year[2] = 31;
		year[3] = 30;
		year[4] = 31;
		year[5] = 30;
		year[6] = 31;
		year[7] = 31;
		year[8] = 30;
		year[9] = 31;
		year[10] = 30;
		year[11] = 31;

		// initalizes days passed and number of first sundays
		int days = 0;
		int sundays = 0;

		// runs from 1900 to 200
		for (int y = 1900; y < 2001; y++) {

			// corrects for leap year
			if ((y % 4 == 0 & y % 100 != 0) | y % 400 == 0)
				year[1] = 29;
			else
				year[1] = 28;

			// runs from Jan to Dec
			for (int m = 0; m < 12; m++) {
				if (y > 1900) {
					if ((days + 1) % 7 == 0)
						sundays++;
				}
				days += year[m];
			}
		}

		// prints answer
		System.out.println(sundays);
	}
}