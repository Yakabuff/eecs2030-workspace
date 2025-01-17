package eecs2030.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents domino tiles. A domino is a rectangular tile with a
 * line dividing its playing face into two sides. Each side of the playing face
 * is marked with pips (dots) similar to a standard 6-sided die. The number of
 * pips on each side of the playing face ranges from Domino.MIN_VALUE to
 * Domino.MAX_VALUE (inclusive).
 * 
 * <p>
 * In simpler terms, each domino tile has two integer values that range from
 * Domino.MIN_VALUE to Domino.MAX_VALUE (inclusive).
 *
 */
public class Domino implements Comparable<Domino> {

	// YOU NEED TO ADD SOME public static final FIELDS HERE
	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 6;

	// YOU NEED TO ADD SOME FIELDS FOR THE STATE OF A DOMINO HERE
	int leftSide;
	int rightSide;

	/**
	 * Initializes this domino so that both of its values are equal to
	 * <code>Domino.MIN_VALUE</code>.
	 */
	public Domino() {
		this.leftSide = MIN_VALUE;
		this.rightSide = MIN_VALUE;
	}

	/**
	 * Initializes this domino to have the specified values.
	 * 
	 * @param value1
	 *            a value
	 * @param value2
	 *            another value @pre. Domino.isValueOK(value1) &&
	 *            Domino.isValueOK(value2)
	 * @throws IllegalArgumentException
	 *             if value1 or value2 is not a legal domino value
	 */
	public Domino(int value1, int value2) {
		if (isValueOK(value1) && isValueOK(value2)) {
			this.leftSide = value1;
			this.rightSide = value2;
		} else if (!isValueOK(value1) && isValueOK(value2)) {
			throw new IllegalArgumentException("value1 is illegal: " + value1);
		} else if (isValueOK(value1) && !isValueOK(value2)) {
			throw new IllegalArgumentException("value2 is illegal: " + value2);
		} else {
			throw new IllegalArgumentException("both values illegal:" + value1 + " " + value2);
		}

	}

	/**
	 * Initializes this domino so that its values are the same as the specified
	 * other domino.
	 * 
	 * @param other
	 *            a domino
	 */
	public Domino(Domino other) {
		this.leftSide = other.leftSide;
		this.rightSide = other.rightSide;
	}

	/**
	 * Returns true if the specified value is a legal domino value, and false
	 * otherwise.
	 * 
	 * @param value
	 *            a value to check
	 * @return true if the specified value is a legal domino value, and false
	 *         otherwise
	 */
	public static boolean isValueOK(int value) {

		boolean valueOK = true;
		if (value > MAX_VALUE || value < MIN_VALUE) {
			valueOK = false;
		}
		return valueOK;
	}

	/**
	 * Returns a list of size 28 containing all of the tiles of the double-six
	 * set (see test document for details).
	 * 
	 * @return a list of size 28 containing all of the tiles of the double-six
	 *         set
	 */
	public static List<Domino> allDominoes() {
		ArrayList<Domino> list = new ArrayList<Domino>();
		for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
			for (int j = MIN_VALUE + i; j <= MAX_VALUE; j++) {

				System.out.println(" v1 " + i + " v2 " + j);
				Domino domino = new Domino(i, j);

				list.add(domino);

			}

		}

		return list;
	}

	/**
	 * Returns the value of one of the two sides of the domino (the value of the
	 * other side of the domino is returned by <code>getValue2</code>).
	 * 
	 * @return the value of one of the two sides of the domino
	 */
	public int getValue1() {

		return this.leftSide;
	}

	/**
	 * Returns the value of one of the two sides of the domino (the value of the
	 * other side of the domino is returned by <code>getValue1</code>).
	 * 
	 * @return the value of one of the two sides of the domino
	 */
	public int getValue2() {

		return this.rightSide;
	}

	/**
	 * Returns the smaller of the two values of this domino. If both values of
	 * this domino are equal to the same value then that value is returned.
	 * 
	 * @return the smaller of the two values of this domino
	 */
	public int getSmallerValue() {
		int smaller = 0;
		if (this.rightSide > this.leftSide) {
			smaller = this.leftSide;
		} else if (this.rightSide < this.leftSide) {
			smaller = this.rightSide;
		} else if (this.rightSide == this.leftSide) {
			smaller = this.rightSide;
		}

		return smaller;
	}

	/**
	 * Returns the larger of the two values of this domino. If both values of
	 * this domino are equal to the same value then that value is returned.
	 * 
	 * @return the larger of the two values of this domino
	 */
	public int getLargerValue() {
		int larger = 0;

		if (rightSide > leftSide) {
			larger = rightSide;
		} else if (leftSide > rightSide) {
			larger = leftSide;
		} else if (leftSide == rightSide) {
			larger = leftSide;
		}

		return larger;
	}

	/**
	 * Returns true if this domino matches the specified domino, and false
	 * otherwise.
	 *
	 * <p>
	 * Two dominoes match if they have at least one value in common. Note that
	 * the side on which a value appears is not considered for the purposes of
	 * matches; for instance, <code>m</code> will be true in the example below:
	 * 
	 * <pre>
	 * Domino a = new Domino(1, 4);
	 * Domino b = new Domino(4, 2); // a and b have the value 4 in common
	 * boolean m = a.matches(b);
	 * </pre>
	 * 
	 * @param other
	 *            a domino
	 * @return true if this domino matches the specified domino, and false
	 *         otherwise
	 */
	public boolean matches(Domino other) {
		boolean matches = false;

		if (other.rightSide == this.rightSide || other.rightSide == this.leftSide) {
			matches = true;
		} else if (other.leftSide == this.leftSide || other.leftSide == this.rightSide) {
			matches = true;
		}

		return matches;
	}

	/**
	 * Compares two dominoes by their values. The smaller values on the two
	 * dominoes are compared first; if the smaller values of both dominoes are
	 * equal then the larger values of the two dominoes are compared.
	 * 
	 * <p>
	 * If the two dominoes are equal then {@code 0} is returned.
	 * 
	 * <p>
	 * This domino is less than the other domino if the smaller value of this
	 * domino is less than the smaller value of the other domino, or if the
	 * larger value of this domino is less than the larger value of the other
	 * domino and the smaller values of both dominoes are equal.
	 * 
	 * <p>
	 * This domino is greater than the other domino if the smaller value of this
	 * domino is greater than the smaller value of the other domino, or if the
	 * larger value of this domino is greater than the larger value of the other
	 * domino and the smaller values of both dominoes are equal.
	 * 
	 * @param other
	 *            the other domino to compare to this domino
	 * @return the value 0 if this domino is equal to other; a value less than 0
	 *         if this domino is less than the other domino; and a value greater
	 *         than 0 if this domino is greater than the other domino
	 */
	@Override
	public int compareTo(Domino other) {

		if (this.getSmallerValue() == other.getSmallerValue()) {
			if (this.getLargerValue() > other.getLargerValue()) {
				return 1;
			}
		} else if (this.getSmallerValue() > other.getSmallerValue()) {
			return 1;
		} else if (this.getSmallerValue() < other.getSmallerValue()) {
			return -1;
		}else if(this.getSmallerValue() == other.getSmallerValue()){
			if (this.getLargerValue() < other.getLargerValue()) {
				return -1;
			}
		}

		return 0;
	}

	/**
	 * Compares this domino to the specified object. The result is true if and
	 * only if the argument is a Domino object having the same values as this
	 * domino object. Note that the side on which a value appears is not
	 * considered for the purposes of equals; for instance, <code>eq</code> will
	 * be true in the example below:
	 * 
	 * <pre>
	 * Domino a = new Domino(1, 4);
	 * Domino b = new Domino(4, 1);
	 * boolean eq = a.equals(b);
	 * </pre>
	 * 
	 * @param obj
	 *            an object to compare
	 * @return true if this domino is equal to the specified object, and false
	 *         otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		boolean equals = true;
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Domino other = (Domino) obj;

		if (other.getSmallerValue() != this.getSmallerValue()) {
			return false;
		}

		if (other.getLargerValue() != this.getLargerValue()) {
			return false;
		}

		return true;

	}

	/**
	 * Returns a hash code for this domino. The hash code value is equal to the
	 * smaller value of this domino plus eleven times the larger value of this
	 * domino.
	 * 
	 * @return the smaller value of this domino plus eleven times the larger
	 *         value of this domino
	 */
	@Override
	public int hashCode() {

		return this.getSmallerValue() + 11 * this.getLargerValue();
	}

	/**
	 * Returns a string representation of this domino. The returned string is
	 * the smaller value of this domino followed by a space, a colon, a space,
	 * and finally the larger value of this domino all inside a pair of square
	 * brackets; for example, if {@code d = new Domino(5, 3)} then
	 * {@code d.toString()} returns the string {@code "[3 : 5]"}.
	 * 
	 * @return a string representation of this domino
	 */
	@Override
	public String toString() {

		String string = "";
		int smaller = getSmallerValue();
		int larger = getLargerValue();
		string = "[" + smaller + " : " + larger + "]";

		return string;
	}

}