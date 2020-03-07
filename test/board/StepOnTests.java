package board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.minesweeper.model.Board;
import uo.mp.minesweeper.model.Square;

public class StepOnTests {

	private Board testBoard;
	private Square[][] testSquares;

	@Before
	public void setUp() throws Exception {

		testSquares = new Square[9][9];
		
		for (int i = 0; i < testSquares.length; i++) {
			for (int j = 0; j < testSquares.length; j++) {
				testSquares[i][j] = new Square(0);
			}
		}
		
		testSquares[1][1].putMine();
		testSquares[3][3].putMine();
		
		testBoard = new Board(0, testSquares);
		testBoard.stepOn(0, 0);

		testBoard.flag(1, 1);
		testBoard.flag(2, 2);

	}

	/*
	 * GIVEN: board square already opened 
	 * WHEN: calling a stepOn method 
	 * THEN: square is revealed
	 */
	@Test
	public void alreadyOpenedtest() {

		testBoard.stepOn(0, 0);
		assertTrue(testBoard.getSquaresForTest()[0][0].isOpen());
		assertEquals('1', testBoard.getStatus()[0][0]);
	}

	/*
	 * GIVEN: board square flagged and mined 
	 * WHEN: calling a stepOn method 
	 * THEN: square remains flagged and unreveailed
	 */
	@Test
	public void flaggedArmedtest() {

		testBoard.stepOn(1, 1);
		assertTrue(testBoard.getSquaresForTest()[1][1].hasFlag() 
				&& !testBoard.getSquaresForTest()[1][1].isOpen());
		assertEquals('¶', testBoard.getStatus()[1][1]);


	}

	/*
	 * GIVEN: board square flagged
	 * WHEN: calling a stepOn method
	 * THEN: square remains flagged and unreveailed
	 */
	@Test
	public void flaggedNonArmedtest() {
		
		testBoard.stepOn(2, 2);
		assertTrue(testBoard.getSquaresForTest()[2][2].hasFlag() 
				&& !testBoard.getSquaresForTest()[2][2].isOpen());
		assertEquals('¶', testBoard.getStatus()[2][2]);

	}
	
	/*
	 * GIVEN: board square armed revealed
	 * WHEN: calling a stepOn method
	 * THEN: square becomes open and explosion occurs
	 */
	@Test
	public void unRevealedArmedtest() {
		
		testBoard.stepOn(3, 3);
		assertTrue(testBoard.getSquaresForTest()[3][3].isOpen());
		assertTrue(testBoard.isExploded(3, 3));
		assertEquals('@', testBoard.getStatus()[3][3]);
		
	}
	
	/*
	 * GIVEN: board square clue revealed
	 * WHEN: calling a stepOn method
	 * THEN: square becomes open
	 */
	@Test
	public void unRevealedClueTest() {
		
		testBoard.stepOn(4, 4);
		assertTrue(testBoard.getSquaresForTest()[4][4].isOpen());	
		assertEquals('1', testBoard.getStatus()[4][4]);
		
	}
	
	/*
	 * GIVEN: board square clue revealed
	 * WHEN: calling a stepOn method
	 * THEN: square becomes open
	 */
	@Test
	public void unRevealedEmptyTest() {
		
		testBoard.stepOn(5, 5);
		assertTrue(testBoard.getSquaresForTest()[5][5].isOpen());
		assertEquals(' ', testBoard.getStatus()[5][5]);

	}
	
	
}
