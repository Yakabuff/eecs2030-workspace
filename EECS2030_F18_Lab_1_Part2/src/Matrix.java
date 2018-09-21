import java.util.Arrays;

/**
 * <p>
 * A Matrix has two dimensions: rows and columns. Each cell in the matrix stores
 * an integer value, and it can be uniquely identified via a row number and a
 * column number. Row numbers start with 0 and column numbers start with 0.
 * <p>
 * For simplicity, you can assume that all row and column numbers passed by
 * users are valid.
 */
public class Matrix {

	/*
	 * You must use this attribute 'imp' to implement the various methods of the
	 * Matrix class. Do not change any parts of this attribute declaration.
	 */
	int[][] imp;

	/**
	 * <p>
	 * Initialize a 1-by-1 matrix with default values.
	 * <p>
	 * See TestMatrix class for how this method can be used.
	 */
	public Matrix() {
		imp = new int[1][1];
	}

	/**
	 * <p>
	 * Initialize a 'nor'-by-'noc' matrix, where each cell
	 * <p>
	 * See TestMatrix class for how this method can be used. stores the default
	 * integer value 0.
	 * 
	 * @param nor
	 *            Number of rows
	 * @param noc
	 *            Number of columns
	 */
	public Matrix(int nor, int noc) {
		/* Your Task */
		imp = new int[nor][noc];

	}

	/**
	 * <p>
	 * Initialize a 'nor'-by-'noc' matrix, where each cell
	 * <p>
	 * See TestMatrix class for how this method can be used. stores the default
	 * integer value 'v'.
	 * 
	 * @param nor
	 *            Number of rows
	 * @param noc
	 *            Number of columns
	 * @param v
	 *            Default value for each cell
	 */
	public Matrix(int nor, int noc, int v) {
		/* Your Task */
		imp = new int[nor][noc];

		for (int i = 0; i < imp.length; i++) {
			for (int j = 0; j < imp[i].length; j++) {
				imp[i][j] = v;
			}
		}

	}

	/**
	 * <p>
	 * Get the number of rows in this matrix.
	 * <p>
	 * See TestMatrix class for how this method can be used.
	 * 
	 * @return Number of rows
	 */
	public int getNumberOfRows() {
		/* Your Task */
		return imp.length;
	}

	/**
	 * <p>
	 * Get the number of columns in this matrix.
	 * <p>
	 * See TestMatrix class for how this method can be used.
	 * 
	 * @return Number of columns
	 */
	public int getNumberOfColumns() {
		/* Your Task */
		return imp[0].length;
	}

	/**
	 * <p>
	 * Get the value stored at cell ('r', 'c').
	 * <p>
	 * You can assume that 'r' and 'c' are valid - no error checking is needed.
	 * <p>
	 * See TestMatrix class for how this method can be used.
	 * 
	 * @param r
	 *            Row number
	 * @param c
	 *            Column number
	 * @return Value stored at cell ('r', 'c')
	 */
	public int get(int r, int c) {
		/* Your Task */
		return imp[r][c];
	}

	/**
	 * <p>
	 * Store value 'v' in cell ('r', 'c').
	 * <p>
	 * You can assume that 'r' and 'c' are valid - no error checking is needed.
	 * <p>
	 * See TestMatrix class for how this method can be used.
	 * 
	 * @param r
	 *            Row number
	 * @param c
	 *            Column number
	 * @param v
	 *            Value to be stored
	 */
	public void set(int r, int c, int v) {
		/* Your Task */

		imp[r][c] = v;
	}

	/**
	 * <p>
	 * Replace values of row 'r' by a the new row 'nr'.
	 * <p>
	 * You can assume the length of 'nr' equals the number of columns of this
	 * matrix - no error checking is needed for this.
	 * <p>
	 * See TestMatrix class for how this method can be used.
	 * 
	 * @param r
	 *            Row number
	 * @param nr
	 *            A new row (as an array of integers)
	 */
	public void setRow(int r, int[] nr) {
		/* Your Task */

		for (int i = 0; i < imp.length; i++) {
			if (i == r) {
				for (int j = 0; j < imp[i].length; j++) {
					imp[i][j] = nr[j];
				}
			}
		}
	}

	/**
	 * <p>
	 * Replace values of column 'c' by a the new column 'nc'.
	 * <p>
	 * You can assume the length of 'nc' equals the number of rows of this
	 * matrix - no error checking is needed for this.
	 * <p>
	 * See TestMatrix class for how this method can be used.
	 * 
	 * @param c
	 *            Column number
	 * @param nc
	 *            A new column (as an array of integers)
	 */
	public void setColumn(int c, int[] nc) {
		/* Your Task */
		for (int i = 0; i < imp.length; i++) {

			imp[i][c] = nc[i];

		}
	}

	/**
	 * <p>
	 * Return a copy of contents stored in row 'r'.
	 * <p>
	 * You can assume that 'r' is valid - no error checking is needed.
	 * <p>
	 * See TestMatrix class for how this method can be used.
	 * 
	 * @param r
	 *            Row number
	 * @return A new array whose contents correspond to those of row 'r'.
	 */
	public int[] getRow(int r) {
		/* Your Task */
		int[] newRow = new int[imp[0].length];

		for (int i = 0; i < imp[r].length; i++) {
			newRow[i] = imp[r][i];
		}
		return newRow;

	}

	/**
	 * <p>
	 * Return a copy of contents stored in column 'c'.
	 * <p>
	 * You can assume that 'c' is valid - no error checking is needed.
	 * <p>
	 * See TestMatrix class for how this method can be used.
	 * 
	 * @param c
	 *            Column number
	 * @return A new array whose contents correspond to those of column 'c'.
	 */
	public int[] getColumn(int c) {
		/* Your Task */
		int[] newColumn = new int[imp.length];

		for (int i = 0; i < imp.length; i++) {
			newColumn[i] = imp[i][c];
		}

		return newColumn;
	}

	/**
	 * <p>
	 * Rotate the matrix by 90 degrees.
	 * <p>
	 * The old 1st row becomes the new last column, the old 2nd row becomes the
	 * new 2nd last column, and so on.
	 * <p>
	 * Hint: attribute 'imp' should be reassigned to a new matrix.
	 * <p>
	 * See TestMatrix class for how this method can be used.
	 */
	public void rotateClockwise() {
		/* Your Task */
		System.out.println(Arrays.deepToString(this.imp));
		int[][] newMatrix = new int[this.imp[0].length][this.imp.length];

		Matrix newImp = new Matrix(this.imp[0].length, this.imp.length);

		for (int i = 0; i < this.imp.length; i++) {

			newImp.setColumn(newImp.imp[0].length - 1 - i, this.getRow(i));
			System.out.println(Arrays.deepToString(newImp.imp));
		}

		this.imp = newImp.imp;

		// System.out.println(Arrays.deepToString(this.imp));

	}

	/**
	 * <p>
	 * Shift this matrix to the left by one column.
	 * <p>
	 * The old 2nd column becomes the new 1st column, the old 3rd column becomes
	 * the new 2nd column, ..., the old 1st column becomes the new last column.
	 * <p>
	 * See TestMatrix class for how this method can be used.
	 */
	public void shiftLeft() {
		/* Your Task */
		int maxColIndex = imp[0].length - 1;
		int[] firstCol = getColumn(0); // save first col
		int[] lastCol = getColumn(maxColIndex);

		// round 1 set first col to second col
		// roud 2 set 2nd col to third
		// round 3 set 3rd col to 4th
		// last round set last col to original first

		for (int i = 0; i < maxColIndex; i++) {
			// loop through each col
			setColumn(i, getColumn(i + 1));

		}

		setColumn(maxColIndex, firstCol);

	}

	/**
	 * <p>
	 * Shift this matrix up by one row.
	 * <p>
	 * The old 2nd row becomes the new 1st row, the old 3rd row becomes the new
	 * 2nd row, ..., the old 1st row becomes the new last row.
	 * <p>
	 * See TestMatrix class for how this method can be used.
	 */
	public void shiftUp() {
		/* Your Task */

		int maxRowIndex = imp.length - 1;
		int[] firstRow = getRow(0); // save first col
		int[] lastRow = getColumn(maxRowIndex);

		for (int i = 0; i < maxRowIndex; i++) {
			// loop through each col
			setRow(i, getRow(i + 1));

		}

		setRow(maxRowIndex, firstRow);

	}
}
