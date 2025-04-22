package hw4.game.test;

import java.util.ArrayList;

import hw4.maze.test.Cell;
import hw4.maze.test.CellComponents;
import hw4.maze.test.Grid;
import hw4.maze.test.Row;
import hw4.player.test.Player;

import java.util.Random;

public class Game {
	private Grid grid;
	
	public Game(Grid grid) {
		this.grid = grid;
	}
	
	public Game(int size) {
		createRandomGrid(size);
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
			//int actorRowPos = -1;
			//int actorCellPos = -1;
			//while((actorRowPos == -1 && actorCellPos == -1) || (actorRowPos == exitPos && actorCellPos == 0)) {
			//	actorRowPos = random.nextInt(size);
			//	actorCellPos = random.nextInt(size);
			//}
			ArrayList<Row> rowList = null;
			for(int i = 0; i < size; i++) {
				ArrayList<Cell> cellList = null;
				for(int j = 0; j < size; j++) {
					int exitCheck = 0;
					boolean wallUp = false;
					boolean wallDown = false;
					boolean wallLeft = false;
					boolean wallRight = false;
					int wallCount = 0;
					if(i == exitPos && j == 0) {
						exitCheck = 1;
					}
					CellComponents up = CellComponents.APERTURE;
					CellComponents down = CellComponents.APERTURE;
					CellComponents left = CellComponents.APERTURE;
					CellComponents right = CellComponents.APERTURE;
					Cell above = rowList.get(i-1).getCells().get(j);
					Cell below = rowList.get(i+1).getCells().get(j);
					Cell toLeft = rowList.get(i).getCells().get(j-1);
					Cell toRight = rowList.get(i).getCells().get(j+1);
					
					if(i == 0 || (above.getDown() == CellComponents.WALL)) {
						up = CellComponents.WALL;
						wallUp = true;
						wallCount++;
					}
					else if(i == size-1 || (below.getUp() == CellComponents.WALL)) {
						down = CellComponents.WALL;
						wallDown = true;
						wallCount++;
					}
					if(j == 0 || (toLeft.getRight() == CellComponents.WALL)) {
						left = CellComponents.WALL;
						wallLeft = true;
						wallCount++;
					}
					else if(j == size-1 || (toRight.getLeft() == CellComponents.WALL)) {
						right = CellComponents.WALL;
						wallRight = true;
						wallCount++;
					}
					if(exitCheck == 1) {
						left = CellComponents.EXIT;
					}
					if(wallCount < 3 && exitCheck != 1) {
						int randomNum = 3 - wallCount;
						int runCond = random.nextInt(randomNum);
						while(runCond != 0 && wallCount < 3) {
							int wallPos = random.nextInt(3);
							switch(wallPos) {
								case 0:
									if(wallUp == false && (above.getWallCount() < 3)) {
										up = CellComponents.WALL;
										wallUp = true;
										runCond--;
										wallCount++;
									}
									break;
								case 1:
									if(wallRight == false && (toRight.getWallCount() < 3)) {
										right = CellComponents.WALL;
										wallRight = true;
										runCond--;
										wallCount++;
									}
									break;
								case 2:
									if(wallDown == false && (below.getWallCount() < 3)) {
										down = CellComponents.WALL;
										wallDown = true;
										runCond--;
										wallCount++;
									}
									break;
								case 3:
									if(wallLeft == false && (toLeft.getWallCount() < 3)) {
										left = CellComponents.WALL;
										wallLeft = true;
										runCond--;
										wallCount++;
									}
									break;
								default:
									break;
							}
						}
					}
					Cell newCell = new Cell(left, right, up, down);
					cellList.add(newCell);
				}
				Row newRow = new Row(cellList);
				rowList.add(newRow);
			}
			this.grid.setRows(rowList);
			return this.grid;
		}
	}
	
	public boolean play(Movement move, Player player){
		switch(move){
			case UP:
				if(player.getCurrentCell().getUp() == CellComponents.APERTURE) {
					int i = 0;
					while(i < grid.getRows().size()) {
						if(player.getCurrentRow().equals(grid.getRows().get(i))) {
							int cellIndex = -1;
							for(int j = 0; j < grid.getRows().get(i).getCells().size(); j++) {
								if(player.getCurrentCell().equals(grid.getRows().get(i).getCells().get(j))) {
									cellIndex = j;
								}
							}
							if(cellIndex != -1) {
								player.setCurrentRow(grid.getRows().get(i-1));
								player.setCurrentCell(grid.getRows().get(i-1).getCells().get(cellIndex));
								return true;
							}
							
							
						}
						i++;
					}
				}
				break;
			case DOWN:
				if(player.getCurrentCell().getDown() == CellComponents.APERTURE) {
					int i = 0;
					while(i < grid.getRows().size()) {
						if(player.getCurrentRow().equals(grid.getRows().get(i))) {
							int cellIndex = -1;
							for(int j = 0; j < grid.getRows().get(i).getCells().size(); j++) {
								if(player.getCurrentCell().equals(grid.getRows().get(i).getCells().get(j))) {
									cellIndex = j;
								}
							}
							if(cellIndex != -1) {
								player.setCurrentRow(grid.getRows().get(i+1));
								player.setCurrentCell(grid.getRows().get(i+1).getCells().get(cellIndex));
								return true;
							}
							
							
						}
						i++;
					}
				}
				break;
			case RIGHT:
				if(player.getCurrentCell().getRight() == CellComponents.APERTURE) {
					int i = 0;
					while(i < grid.getRows().size()) {
						if(player.getCurrentRow().equals(grid.getRows().get(i))) {
							int cellIndex = -1;
							for(int j = 0; j < grid.getRows().get(i).getCells().size(); j++) {
								if(player.getCurrentCell().equals(grid.getRows().get(i).getCells().get(j))) {
									cellIndex = j;
								}
							}
							if(cellIndex != -1) {
								player.setCurrentCell(grid.getRows().get(i).getCells().get(cellIndex+1));
								return true;
							}
							
							
						}
						i++;
					}
				}
				break;
			case LEFT:
				if(player.getCurrentCell().getLeft() == CellComponents.APERTURE) {
					int i = 0;
					while(i < grid.getRows().size()) {
						if(player.getCurrentRow().equals(grid.getRows().get(i))) {
							int cellIndex = -1;
							for(int j = 0; j < grid.getRows().get(i).getCells().size(); j++) {
								if(player.getCurrentCell().equals(grid.getRows().get(i).getCells().get(j))) {
									cellIndex = j;
								}
							}
							if(cellIndex != -1) {
								player.setCurrentCell(grid.getRows().get(i).getCells().get(cellIndex-1));
								return true;
							}
							
							
						}
						i++;
					}
				}
				else if(player.getCurrentCell().getLeft() == CellComponents.EXIT) {
					return true;
				}
				break;
			default:
				break;
		}
		return false;
	}
}
