/**
 * 
 */
package org.tucana.astronomy.solarsystem.computations;

import java.util.Calendar;
import java.util.Date;

/**
 * @author kamann
 * 
 */
public class AstroDate {

	/**
	 * d = 367*y - 7 * ( y + (m+9)/12 ) / 4 + 275*m/9 + D - 730530
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param ut
	 * @return
	 */
	public static double computeDayNumber(Date computationDate) {
		assert (computationDate != null);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(computationDate);

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		double dayNumber;

		dayNumber = 367 * year - 7 * (year + (month + 9) / 12) / 4 + 275
				* month / 9 + day - 730530;
		dayNumber += convertTimeIntoDecimalTime(computationDate) / 24.0d;

		return dayNumber;
	}

	public static double convertTimeIntoDecimalTime(Date computationDate) {
		assert (computationDate != null);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(computationDate);

		return (calendar.get(Calendar.HOUR_OF_DAY) + calendar
				.get(Calendar.MINUTE) / 60d);
	}
}
