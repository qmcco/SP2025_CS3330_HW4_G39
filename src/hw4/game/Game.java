package hw4.game;

import java.util.ArrayList;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Player;
import hw4.game.test.*;

import java.util.Random;
/**
 * Game class represents overall game state
 */
public class Game {
	private Grid grid;
	/**
	 * constructor
	 * @param grid grid containing the board's rows of cells
	 */
	public Game(Grid grid) {
		this.grid = grid;
	}
	/**
	 * constructor, given a size create random grid
	 * @param size of random grid
	 */
	public Game(int size) {
		createRandomGrid(size);
	}
	
	/**
	 * get grid
	 * @return grid
	 */
	public Grid getGrid() {
		return grid;
	}
	
	/**
	 * set grid
	 * @param newGrid new value of grid
	 */
	public void setGrid(Grid newGrid) {
		this.grid = newGrid;
	}
	/**
	 * create a grid with random wall placements and random exit placement (with conditions that there must be walls at edges and exit must be on left hand side)
	 * @param size of the random grid to generate
	 * @return the generated random grid
	 */
	public Grid createRandomGrid(int size) {
		if(size < 3 || size > 7) {
			return null;
		}
		else {
			ArrayList<Row> rowList = new ArrayList<Row>();
			Random random = new Random();
			int exitPos = random.nextInt(size);
			for(int i = 0; i < size; i++) {
				ArrayList<Cell> newRow = new ArrayList<Cell>();
				for(int j = 0; j < size; j++) {
					System.out.println("I: "+ i + " J: " + j);
					int exitCheck = 0;
					if(i == exitPos && j == 0) {
						exitCheck = 1;
					}
					CellComponents up = null;
					CellComponents down = null;
					CellComponents left = null;
					CellComponents right = null;
					boolean newWall = false;
					if(i == 0) {
						up = CellComponents.WALL;
					}
					else if(i == size-1) {
						up = rowList.get(i-1).getCells().get(j).getDown();
						down = CellComponents.WALL;
					}
					else {
						up = rowList.get(i-1).getCells().get(j).getDown();
					}
					if(j == 0) {
						left = CellComponents.WALL;
						if(exitCheck == 1) {
							left = CellComponents.EXIT;
						}
					}
					else if(j == size-1) {
						
						left = rowList.get(i).getCells().get(j-1).getRight();
						right = CellComponents.WALL;
					}
					else {
						
						left = rowList.get(i).getCells().get(j-1).getRight();
					}
					if(down == null && right == null) {
						int randWall = random.nextInt(3);
						if(randWall == 0) {
							down = CellComponents.WALL;
							right = CellComponents.APERTURE;
						}
						else if(randWall == 1) {
							right = CellComponents.APERTURE;
							down = CellComponents.APERTURE;
						}
						else {
							down = CellComponents.APERTURE;
							right = CellComponents.APERTURE;
						}
					}
					else if(down == null && right == CellComponents.WALL) {
						down = CellComponents.APERTURE;
					}
					else if(down == CellComponents.WALL && right == null) {
						right = CellComponents.APERTURE;
					}
					System.out.println("LEFT: " + left + " RIGHT: " + right + " UP: " + up + " DOWN: " + down );
					Cell newCell = new Cell(left, right, up, down);
					if(j != 0) {
						rowList.get(i).getCells().add(newCell);
					}
					else {
						newRow.add(newCell);
						Row row = new Row(newRow);
						rowList.add(row);
					}
				}
				//Row row = new Row(newRow);
				//rowList.add(row);
			}
			this.grid = new Grid(rowList);
			return this.grid;
		}
	}
	/**
	 * make a move on the game board
	 * @param move to be made (up, down, left, right)
	 * @param player current player representing the position of the actor to be moved
	 * @return true if the move is successful, false otherwise
	 */
	public boolean play(Movement move, Player player){
		if(player == null) {
			return false;
		}
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
				else {
					System.out.println("Wall Hit!");
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
				else {
					System.out.println("Wall Hit!");
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
				else {
					System.out.println("Wall Hit!");
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
				else {
					System.out.println("Wall Hit!");
				}
				break;
			case null:
				return false;
			default:
				break;
		}
		return false;
	}
	/**
	 * print the current game board
	 * @param player used to print the position of the actor
	 */
	public void printGame(Player player) {
		System.out.println();
		for(int i = 0; i < this.grid.getRows().size(); i++) {
			for(int j = 0; j < this.grid.getRows().get(i).getCells().size(); j++) {
				if(this.grid.getRows().get(i).getCells().get(j).equals(player.getCurrentCell())) {
					System.out.print(" A ");
				}
				else if(this.grid.getRows().get(i).getCells().get(j).getLeft() == CellComponents.EXIT) {
					System.out.print(" E ");
				}
				else {
					System.out.print(" S ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	/**
	 * String representation of the current Game state including the inner grid, rows, and cells
	 */
	@Override
	public String toString() {
		String retString = "Game [grid=" + this.grid.toString() + "]";
		System.out.println(retString);
		return retString;
	}
}
