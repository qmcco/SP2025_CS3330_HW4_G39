package hw4.player;

import java.util.ArrayList;

import hw4.maze.Cell;
import hw4.maze.Row;
import hw4.player.test.*;
/**
 * represents the current player actor's position on the Game grid
 */
public class Player {
	private Row currentRow;
	private Cell currentCell;
	/**
	 * constructor sets current row and cell that the player is positioned in
	 * @param currentRow
	 * @param currentCell
	 */
	public Player(Row currentRow, Cell currentCell) {
		this.currentCell = currentCell;
		this.currentRow = currentRow;
	}
	
	
	public Row getCurrentRow(){
		return currentRow;
	}
	
	public void setCurrentRow(Row newCurrentRow) {
		this.currentRow = newCurrentRow;
	}
	
	
	
	public void setCurrentCell(Cell newCurrentCell) {
		this.currentCell = newCurrentCell;
	}

	public Cell getCurrentCell() {
		return currentCell;
	}
	
	@Override
	public String toString() {
		return "Player [currentCell=" + this.currentCell + ", currentRow=" + this.currentRow + "]";
	}
}


