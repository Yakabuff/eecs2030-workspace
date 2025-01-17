package eecs2030.lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A word puzzle where the puzzle word is formed by randomly shuffling the
 * letters of the solution word.
 * 
 * <p>
 * Many scrambled word puzzles have multiple solutions but this class assumes
 * that there is only one solution for the puzzle.
 * 
 *
 */
public class ScrambledWordPuzzle extends AbstractWordPuzzle {

	/**
	 * The solution to the puzzle
	 */
	private String solution;

	/**
	 * Creates a scrambled word puzzle given the solution word.
	 * 
	 * @param solutionWord
	 *            the puzzle word
	 */
	public ScrambledWordPuzzle(String solutionWord) {
		// COMPLETE THIS
		// Hint: You need to scramble the letters of the solution word
		// to generate the puzzle word and then set the puzzle word.
		// The easiest way to scramble the letters is to put them
		// into a list, use Collections.shuffle, and then convert the
		// the shuffled list of letters back into a string.

		super("");
		this.solution = solutionWord;

		List<String> shuffle = new ArrayList<String>();
		for (String i : solutionWord.split("")) {
			shuffle.add(i);
		}
		Collections.shuffle(shuffle);
		String puzzleWord = String.join("", shuffle);
		super.setPuzzleWord(puzzleWord); // make puzzleword
	}

	/**
	 * Get the solution for this reverse word puzzle.
	 * 
	 * @return the solution for this reverse word puzzle
	 */
	@Override
	public String getSolution() {
		// COMPLETE THIS
		return solution;
	}

}
