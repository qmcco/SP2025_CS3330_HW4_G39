package hw4.main;
import java.util.Scanner;

import hw4.*;
import hw4.game.Game;
import hw4.game.Movement;
import hw4.maze.Grid;
import hw4.player.Player;
import hw4.maze.CellComponents;

/**
 * Main class allows for user testing of Tears, Despair & Debugging Game
 */
public class Main {
	/**
	 * Welcome user and prompt for size of game
	 * Given size used to generate random game board
	 * Prompt user to select move until the exit is reached
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		Game newGame = new Game(3);
		
		//newGame.accessTest();
		System.out.println("Welcome to Tears, Despair & Debugging!");
		System.out.println();
		int size = 0;
		while(size > 7 || size < 3) {
			System.out.println("Enter the desired size of the game board (3 to 7): ");
			try {
				size = Integer.parseInt(scanner.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println();
				System.out.println("Not an Integer");
				System.out.println();
				continue;
			}
			if(size > 7 || size < 3) {
				System.out.println();
				System.out.println("Invalid Size");
				System.out.println();
			}
		}
		
		Grid newGrid = newGame.createRandomGrid(size);
		Player newPlayer = new Player(newGrid.getRows().get(size-1), newGrid.getRows().get(size-1).getCells().get(size-1));
		
		int gameRun = 0;
		while(gameRun == 0) {
			int choice = 0;
			newGame.printGame(newPlayer);
			while(choice > 4 || choice < 1) {
				System.out.println("Select a Move to Make (enter the associated number): ");
				System.out.println("* 1. UP: ");
				System.out.println("* 2. DOWN: ");
				System.out.println("* 3. LEFT: ");
				System.out.println("* 4. RIGHT: ");
				System.out.println("Enter:  ");
				try {
					choice = Integer.parseInt(scanner.nextLine());
				}
				catch(NumberFormatException e) {
					System.out.println();
					System.out.println("Not an Integer");
					System.out.println();
					continue;
				}
				if(choice > 4 || choice < 1) {
					System.out.println();
					System.out.println("Invalid Move");
					System.out.println();
				}
			}
			switch(choice) {
				case 1:
					newGame.play(Movement.UP, newPlayer);
					break;
				case 2:
					newGame.play(Movement.DOWN, newPlayer);
					break;
				case 3:
					if(newPlayer.getCurrentCell().getLeft() == CellComponents.EXIT) {
						System.out.println("You Win!");
						gameRun = 1;
					}
					newGame.play(Movement.LEFT, newPlayer);
					break;
				case 4:
					newGame.play(Movement.RIGHT, newPlayer);
					break;
				default:
					break;
			}
			
		}
	}
}
