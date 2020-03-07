package square;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.minesweeper.model.Square;
import uo.mp.minesweeper.utilities.StateOfSquare;

public class UnFlagTests {

	private Square[][] testSquares;

	@Before
	public void setUp() throws Exception {

		testSquares = new Square[9][9];

		for (int i = 0; i < testSquares.length; i++) {
			for (int j = 0; j < testSquares.length; j++) {
				testSquares[i][j] = new Square(0);
			}
		}

		testSquares[0][0].open();
		testSquares[2][2].flag();

	}

	/*
	 * GIVEN: square opened 
	 * WHEN: calling a unFlag method 
	 * THEN: square is OPEN
	 */
	@Test
	public void unFlagOpenTest() {

		testSquares[0][0].unflag();
		assertEquals(testSquares[0][0].getState(), StateOfSquare.OPEN);

	}

	/*
	 * GIVEN: square closed 
	 * WHEN: calling a unFlag method 
	 * THEN: square is OPEN
	 */
	@Test
	public void unFlagClosedTest() {

		testSquares[1][1].unflag();
		assertEquals(testSquares[1][1].getState(), StateOfSquare.CLOSED);

	}

	/*
	 * GIVEN: square flagged 
	 * WHEN: calling a unFlag method 
	 * THEN: square is closed
	 */
	@Test
	public void unFlagFlaggedTest() {

		testSquares[2][2].unflag();
		assertTrue(!testSquares[2][2].hasFlag());
		assertEquals(testSquares[2][2].getState(), StateOfSquare.CLOSED);

	}

}
