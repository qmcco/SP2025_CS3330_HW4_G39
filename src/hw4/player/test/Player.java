package hw4.player.test;

import java.util.ArrayList;

import hw4.maze.test.Cell;
import hw4.maze.test.Row;

public class Player {
	private ArrayList<Row> currentRow;
	private Cell currentCell;
	
	public Player(ArrayList<Row> currentRow, Cell currentCell) {
		this.currentCell = currentCell;
		for(int i = 0; i < currentRow.size(); i++) {
			this.currentRow.add(currentRow.get(i));
		}
	}
	
	public ArrayList<Row> getCurrentRow(){
		return currentRow;
	}
	
	public void setCurrentRow(ArrayList<Row> newCurrentRow) {
		this.currentRow.clear();
		for(int i = 0; i < newCurrentRow.size(); i++) {
			this.currentRow.add(newCurrentRow.get(i));
		}
	}
	
	public Cell getCurrentCell() {
		return currentCell;
	}
	
	public void setCurrentCell(Cell newCurrentCell) {
		this.currentCell = newCurrentCell;
	}
}
