package hw4.main;
import hw4.*;
import hw4.game.Game;
import hw4.game.Movement;
import hw4.maze.Grid;
import hw4.player.Player;
import hw4.maze.CellComponents;

public class Main {
	public static void main(String[] args) {
		Game newGame = new Game(null);
		Grid newGrid = newGame.createRandomGrid(5);
		Player newPlayer = new Player(newGrid.getRows().get(4), newGrid.getRows().get(4).getCells().get(4));
		newGame.printGame(newPlayer);
		newGame.play(Movement.UP, newPlayer);
		newGame.printGame(newPlayer);
	}
}
