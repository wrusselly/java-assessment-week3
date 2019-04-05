import java.util.InputMismatchException;
import java.util.Scanner;

public class Map {
	
	private int xSize;
	private int ySize;
	
	public Map() {
		this.xSize = 10;
		this.ySize = 10;
	}

	public int getxSize() {
		return xSize;
	}

	public void setxSize(int xSize) {
		this.xSize = xSize;
	}

	public int getySize() {
		return ySize;
	}

	public void setySize(int ySize) {
		this.ySize = ySize;
	}
	
	public String setDifficulty() {
		String str = "";
		boolean exit = false;
		while(exit == false) {
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("Select difficulty: easy, medium, hard");
				str = sc.nextLine();
				if (str.equals("easy")||str.equals("medium")||str.equals("hard")) {
					exit = true;
				}
				else {
					System.out.println("invalid input please type 'easy', 'medium' or 'hard'");
				}
			} catch (InputMismatchException e) {
				System.out.println("invalid input please type 'easy', 'medium' or 'hard'");
			}
		}
		return str;
	}
	
	public void generateMap(String difficulty) {
		if (difficulty.equals("easy")) {
			this.setxSize(10);
			this.setySize(10);
		}
		else if (difficulty.equals("hard")) {
			this.setxSize(30);
			this.setySize(30);
		}
		else{
			this.setxSize(20);
			this.setySize(20);
		}
	}

}
