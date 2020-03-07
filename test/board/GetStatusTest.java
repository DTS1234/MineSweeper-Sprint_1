package board;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.minesweeper.model.Board;
import uo.mp.minesweeper.model.Square;
import uo.mp.minesweeper.utilities.Constants;

public class GetStatusTest {
	
	private Board testBoardHidden;
	private Board testBoardRevealed;
	private Board testBoardPartially;
	private Square[][] testSquaresPartially;
	
	@Before
	public void setUp() throws Exception {

		testSquaresPartially = new Square[9][9];

		for (int i = 0; i < testSquaresPartially.length; i++) {
			for (int j = 0; j < testSquaresPartially.length; j++) {
				testSquaresPartially[i][j] = new Square(0);
			}
		}

		testSquaresPartially[2][2].putMine();
		testSquaresPartially[2][3].putMine();
		testSquaresPartially[8][8].putMine();
		testSquaresPartially[5][8].putMine();
		
		
		testBoardHidden = new Board(9, 9, 12);
		testBoardPartially = new Board(0, testSquaresPartially);
		testBoardRevealed = new Board(0, testSquaresPartially);
		
		testSquaresPartially[1][1].open();
		testSquaresPartially[5][5].open();
		testSquaresPartially[3][2].open();
		testSquaresPartially[3][3].flag();
		testSquaresPartially[2][2].flag();
		testSquaresPartially[7][8].open();
				
	}
	
	/*
	 * GIVEN: board hidden squares
	 * WHEN: calling a getStatus
	 * THEN: returns char array with '#' values
	 */
	@Test
	public void hiddenBoardTest() {
		
		char[][] testChar = testBoardHidden.getStatus();
		int counter = 0;
		
		for(int i = 0; i<testChar.length; i++) {
			for(int j = 0; j<testChar.length; j++) {
				
				if(testChar[i][j] != Constants.unrevealedChar) {
					counter++;
				}				
			}
		}
		
		assertTrue(counter == 0);
		
	}
	
	/*
	 * GIVEN: board revealed squares
	 * WHEN: calling a getStatus
	 * THEN: returns char array with adjusted values
	 */
	@Test
	public void revealedBoardTest() {
		
		testBoardRevealed.unveil();
		char[][] testChar = testBoardRevealed.getStatus();
		
		assertTrue(testChar[2][2] == Constants.revealedMineChar 
				&& testChar[8][8] == Constants.revealedMineChar 
					&& testChar[5][8] == Constants.revealedMineChar);		
		assertTrue(testChar[3][3] == Constants.twochar && testChar[7][7] == Constants.onechar);
		assertTrue(testChar[2][2] == Constants.revealedMineChar);
		assertTrue(testChar[5][5] == Constants.blankChar);		
		
	}
	
	/*
	 * GIVEN: board partially solved
	 * WHEN: calling a getStatus
	 * THEN: returns char array with adjusted values
	 */
	@Test
	public void partiallySolvedBoardTest() {
		
		char[][] testChar = testBoardPartially.getStatus();
		
		assertTrue(testChar[3][2] == Constants.twochar);
		assertTrue(testChar[1][1] == Constants.onechar);
		assertTrue(testChar[1][2] == Constants.unrevealedChar);
		assertTrue(testChar[3][3] == Constants.armedChar);
		assertTrue(testChar[2][2] == Constants.armedChar);
		assertTrue(testChar[5][5] == Constants.blankChar);
		assertTrue(testChar[7][8] == Constants.onechar);
		
	}

}
