package eecs2030.lab1;

import java.util.Collections;
import java.util.List;

/**
 * A random assortment of methods reviewing topics that should have been covered
 * in your previous programming courses.
 *
 */
public class Lab {

	public final static int ANGLEOFCIRCLE = 360;

	private Lab() {
		// empty to prevent object creation
	}

	/**
	 * Returns the value 1.
	 * 
	 * @return the value 1
	 */
	public static int one() {
		return 1;
	}

	/**
	 * Returns the maximum number of complete revolutions equivalent to a number
	 * of degrees not greater than the given number of degrees (there are 360
	 * degrees in one revolution). For example:
	 * 
	 * <pre>
	 * numRevolutions(0)    returns 0
	 * numRevolutions(1)    returns 0
	 * numRevolutions(360)  returns 1
	 * numRevolutions(719)  returns 1
	 * numRevolutions(720)  returns 2
	 * numRevolutions(800)  returns 2
	 * </pre>
	 * 
	 * @param degrees
	 *            a number of degrees not less than zero
	 * @return the maximum number of complete revolutions not greater than the
	 *         given number of degrees
	 */
	public static long numRevolutions(long degrees) {
		long numRevolutions = 0;
		if (degrees > 0) {
			numRevolutions = degrees / ANGLEOFCIRCLE;

		} else if (degrees == 0) {
			numRevolutions = 0;
		}

		return numRevolutions;
	}

	/**
	 * Returns the number of degrees on a circle that is equivalent to the given
	 * number of degrees. The returned value is always between 0 and 359
	 * degrees, inclusive. For example:
	 * 
	 * <pre>
	 * fixAngle(0)    returns 0
	 * fixAngle(1)    returns 1
	 * fixAngle(359)  returns 359
	 * fixAngle(360)  returns 0
	 * fixAngle(700)  returns 340
	 * fixAngle(720)  returns 0
	 * fixAngle(725)  returns 5
	 * </pre>
	 * 
	 * @param degrees
	 *            a number of degrees not less than zero
	 * @return the number of degrees on a circle that is equivalent to the given
	 *         number of degrees
	 */
	public static int fixAngle(long degrees) {
		long degreeOnCircle = 0;
		if (numRevolutions(degrees) == 0) {
			degreeOnCircle = degrees;
		} else if (numRevolutions(degrees) > 0) {
			long temp = numRevolutions(degrees) * ANGLEOFCIRCLE;
			degreeOnCircle = degrees - temp;
		}
		return (int) degreeOnCircle;
	}

	/**
	 * Returns the mathematical average of 3 values.
	 * 
	 * @param a
	 *            a value
	 * @param b
	 *            a value
	 * @param c
	 *            a value
	 * @return the average of a, b, and c
	 */
	public static double avg(int a, int b, int c) {
		double avg = ((double) a + (double) b + (double) c) / 3;
		return avg;

	}

	/**
	 * Returns true if {@code x} is even and false otherwise.
	 * 
	 * @param x
	 *            a value
	 * @return true if x is even and false otherwise
	 */
	public static boolean isEven(int x) {
		boolean isEven = false;
		if (x % 2 == 0) {
			isEven = true;
		}
		return isEven;
	}

	/**
	 * Returns true if {@code units} is not a valid unit for a temperature and
	 * false otherwise. A valid unit is either the string {@code "C"} (for
	 * degrees Celcius) or the string {@code "F"} (for degrees Fahrenheit).
	 * 
	 * @param units
	 *            a string
	 * @return true if units is not a valid unit for a temperature and false
	 *         otherwise
	 */
	public static boolean badUnits(String units) {

		boolean badUnits = false;
		if (units.equals("C") || units.equals("F")) {
			badUnits = false;
		} else {
			badUnits = true;
		}
		return badUnits;
	}

	/**
	 * Returns true if {@code x} is between the values {@code lo} and
	 * {@code hi}. Returns {@code false} if {@code x} is equal to {@code lo} or
	 * {@code hi}.
	 * 
	 * @param x
	 *            a value
	 * @param lo
	 *            a value
	 * @param hi
	 *            a value
	 * @return true if {@code x} is between the values {@code lo} and {@code hi}
	 */

	public static boolean isInRange(double x, double lo, double hi) {
		boolean isInRange = false;
		if (x > lo && x < hi) {
			isInRange = true;
		}
		return isInRange;
	}

	/**
	 * Increments the given counter if the value of the counter is even.
	 * 
	 * <p>
	 * Decrements the given counter if the value of the counter is odd.
	 * 
	 * <p>
	 * Increments the given counter two times if the value of the counter is
	 * zero.
	 * 
	 * @param c
	 *            a counter
	 */

	public static void twiddle(HiddenCounter c) {
		if (c.isZero()) {
			c.incr();
			c.incr();
		} else if (c.isEven()) {
			c.incr();
		} else if (c.isOdd()) {
			c.decr();
		}

	}

	/**
	 * Swaps the first and last elements of a list. For example if {@code t} is
	 * the list {@code ["a", "b", "c"]} then swapping the first and last
	 * elements causes {@code t} to become the list {@code ["c", "b", "a"]}.
	 * 
	 * @param t
	 *            a list of strings
	 */
	public static void swapFirstAndLast(List<String> t) {
		if (t.size() > 1) {
			Collections.swap(t, 0, t.size() - 1);
		}
	}

	/**
	 * Returns the number of short words in the given list of strings. A short
	 * word is a string whose length is less than or equal to 2. This method
	 * does not modify the list {@code t}.
	 * 
	 * @param t
	 *            a list of strings
	 * @return the number of short words in the given list of strings
	 */
	public static int numShortWords(List<String> t) {
		int count = 0;
		for (int i = 0; i < t.size(); i++) {
			if (t.get(i).length() <= 2) {
				count++;
			}
		}
		return count;
	}

}
