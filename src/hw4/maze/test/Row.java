package hw4.maze.test;

import java.util.ArrayList;

public class Row {
	private ArrayList<Cell> cells;
	
	public Row(ArrayList<Cell> cells) {
		for(int i = 0; i < cells.size(); i++) {
			this.cells.add(cells.get(i));
		}
	}
	
	public ArrayList<Cell> getCells(){
		return cells;
	}
	
	public void setCells(ArrayList<Cell> newCells) {
		this.cells.clear();
		for(int i = 0; i < newCells.size(); i++) {
			this.cells.add(newCells.get(i));
		}
	}
}
