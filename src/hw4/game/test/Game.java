package hw4.game.test;

import java.util.ArrayList;

import hw4.maze.test.Cell;
import hw4.maze.test.CellComponents;
import hw4.maze.test.Grid;
import hw4.maze.test.Row;

import java.util.Random;

public class Game {
	private Grid grid;
	
	public Game(Grid grid) {
		this.grid = grid;
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public void setGrid(Grid newGrid) {
		this.grid = newGrid;
	}
	
	public Grid createRandomGrid(int size) {
		grid.setRows(null);
		if(size < 3 || size > 7) {
			return null;
		}
		else {
			Random random = new Random();
			int exitPos = random.nextInt(size);
			int actorRowPos = -1;
			int actorCellPos = -1;
			while((actorRowPos == -1 && actorCellPos == -1) || (actorRowPos == exitPos && actorCellPos == 0)) {
				actorRowPos = random.nextInt(size);
				actorCellPos = random.nextInt(size);
			}
			ArrayList<Row> rowList = null;
			for(int i = 0; i < size; i++) {
				ArrayList<Cell> cellList = null;
				for(int j = 0; j < size; j++) {
					int exitCheck = 0;
					if(i == exitPos && j == 0) {
						exitCheck = 1;
					}
					CellComponents up = CellComponents.APERTURE;
					CellComponents down = CellComponents.APERTURE;
					CellComponents left = CellComponents.APERTURE;
					CellComponents right = CellComponents.APERTURE;
					if(i == 0) {
						up = CellComponents.WALL;
					}
					else if(i == size-1) {
						down = CellComponents.WALL;
					}
					if(j == 0) {
						left = CellComponents.WALL;
					}
					else if(j == size-1) {
						right = CellComponents.WALL;
					}
					if(exitCheck == 1) {
						left = CellComponents.EXIT;
					}
					Cell newCell = new Cell(up, down, left, right);
					cellList.add(newCell);
				}
				Row newRow = new Row(cellList);
				rowList.add(newRow);
			}
			this.grid.setRows(rowList);
			return this.grid;
		}
	}
}
