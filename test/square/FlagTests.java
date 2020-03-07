package square;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.minesweeper.model.Square;
import uo.mp.minesweeper.utilities.StateOfSquare;

public class FlagTests {

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
	 * WHEN: calling a flag method 
	 * THEN: square is OPEN
	 */
	@Test
	public void flagOpenTest() {

		testSquares[0][0].flag();
		assertEquals(testSquares[0][0].getState(), StateOfSquare.OPEN);

	}

	/*
	 * GIVEN: square closed 
	 * WHEN: calling a flag method 
	 * THEN: square is OPEN
	 */
	@Test
	public void flagClosedTest() {

		testSquares[1][1].flag();
		assertEquals(testSquares[1][1].getState(), StateOfSquare.FLAGGED);

	}

	/*
	 * GIVEN: square flagged 
	 * WHEN: calling a flag method 
	 * THEN: square is closed
	 */
	@Test
	public void flagFlaggedTest() {

		testSquares[2][2].flag();
		assertTrue(testSquares[2][2].hasFlag());
		assertEquals(testSquares[2][2].getState(), StateOfSquare.FLAGGED);

	}

}
