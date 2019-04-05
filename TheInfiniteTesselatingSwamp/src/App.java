
public class App {
	public static void main(String[] args) {
		
		Game game = new Game();
		
		game.startGame();
		game.takeTurn();
		game.endGame(game.isDead());
		game.endGame();
		
	}

}
