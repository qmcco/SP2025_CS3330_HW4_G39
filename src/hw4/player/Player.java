package hw4.player;

import java.util.ArrayList;

import hw4.maze.Cell;
import hw4.maze.Row;

public class Player {
	private Row currentRow;
	private Cell currentCell;
	
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
}
