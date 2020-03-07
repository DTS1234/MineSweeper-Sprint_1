package square;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.minesweeper.model.Square;
import uo.mp.minesweeper.utilities.StateOfSquare;

public class StepOnTests {

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
	 * WHEN: calling a stepOn method
	 * THEN: square is OPEN 
	 */
	@Test
	public void stepOnOpenTest() {
		
		testSquares[0][0].stepOn();
		assertTrue(testSquares[0][0].isOpen());
		assertEquals(testSquares[0][0].getState(), StateOfSquare.OPEN);
		
	}
	
	/*
	 * GIVEN: square closed 
	 * WHEN: calling a stepOn method
	 * THEN: square is OPEN 
	 */
	@Test
	public void stepOnClosedTest() {
		
		testSquares[1][1].stepOn();
		assertTrue(testSquares[1][1].isOpen());
		assertEquals(testSquares[1][1].getState(), StateOfSquare.OPEN);
		
	}
	
	/*
	 * GIVEN: square flagged 
	 * WHEN: calling a stepOn method
	 * THEN: square is Flagged 
	 */
	@Test
	public void stepOnFlaggedTest() {
		
		testSquares[2][2].stepOn();
		assertTrue(testSquares[2][2].hasFlag());
		assertEquals(testSquares[2][2].getState(), StateOfSquare.FLAGGED);
		
	}
	
}
