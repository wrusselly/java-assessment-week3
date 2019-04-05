import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	
	Map map = new Map();
	Player player = new Player(0, 0, "");
	Treasure treasure = new Treasure(0, 0, 100);
	String difficulty;
	NPCs[] allyList;
	NPCs[] enemyList;
	private boolean dead = false;
	
	public void startGame() {
		System.out.println("Welcome to the infinite swamp.");
		String str;
		boolean exit = false;
		while(exit == false) {
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("What's your name");
				str = sc.nextLine();
				player.setName(str);
				exit = true;
			} catch (InputMismatchException e) {
				System.out.println("invalid input please type 'north', 'south', 'east' or 'west'");
			}
		}
		difficulty = map.setDifficulty();
		map.generateMap(difficulty);
		System.out.println("You find yourself in a vast and murky swamp, how did you get here? You look around and there is no sign of an end in any direction. "+
						   "\rYou do however find a compass in your pocket with a note saying there is treasure to be found. Can you find it?");
		player.generatePos(map.getxSize(), map.getySize());
		treasure.generatePos(map.getxSize(), map.getySize());
		allyList = createAllies(difficulty);
		enemyList = createEnemies(difficulty);
		while(this.checkPos(player.getxPos(), player.getyPos(), treasure.getxPos(), treasure.getyPos())) {
			player.generatePos(map.getxSize(), map.getySize());
		}
	}

		
	public NPCs[] createAllies(String difficulty) {
		NPCs[] allies = null;
		if (difficulty.equals("easy")) {
			allies = new NPCs[20];
			for (int i = 0; i < 20; i++){
				allies[i] = new NPCs(0, 0, "you look rough, here drink this", 2);
				allies[i].generatePos(map.getxSize(), map.getySize());
			}
		}
		else if (difficulty.equals("hard")) {
			allies = new NPCs[200];
			for (int i = 0; i < 200; i++){
				allies[i] = new NPCs(0, 0, "you look rough, here drink this", 2);
				allies[i].generatePos(map.getxSize(), map.getySize());
			}
		}
		else{
			allies = new NPCs[100];
			for (int i = 0; i < 100; i++){

				allies[i] = new NPCs(0, 0, "you look rough, here drink this", 2);
				allies[i].generatePos(map.getxSize(), map.getySize());
			}	
		}
		return allies;
	}
	
	public NPCs[] createEnemies(String difficulty) {
		NPCs[] enemies;
		if (difficulty.equals("easy")) {
			enemies = new NPCs[20];
			for (int i = 0; i < 20; i++){
				enemies[i] = new NPCs(0, 0, 3);
				enemies[i].generatePos(map.getxSize(), map.getySize());
			}
		}
		else if (difficulty.equals("hard")) {
			enemies = new NPCs[200];
			for (int i = 0; i < 200; i++){
				enemies[i] = new NPCs(0, 0, 3);
				enemies[i].generatePos(map.getxSize(), map.getySize());
			}
		}
		else{
			enemies = new NPCs[100];
			for (int i = 0; i < 100; i++){
				enemies[i] = new NPCs(0, 0, 3);
				enemies[i].generatePos(map.getxSize(), map.getySize());
			}	
		}
		return enemies;
	}
	
	public void move() {
		String str = "";
		boolean exit = false;
		while(exit == false) {
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("Which direction do you go? north, south, east or west");
				str = sc.nextLine();
				if (str.equals("north")||str.equals("south")||str.equals("east")||str.equals("west")) {
					exit = true;
				}
				else {
					System.out.println("invalid input please type 'north', 'south', 'east' or 'west'");
				}
			} catch (InputMismatchException e) {
				System.out.println("invalid input please type 'north', 'south', 'east' or 'west'");
			}
		}
		player.movement(str, map.getxSize(), map.getySize());
	}
	
	public double compass(int playerX, int playerY, int treasureX, int treasureY) {
		double distance = ((playerX-treasureX)*(playerX-treasureX)+(playerY-treasureY)*(playerY-treasureY));
		distance = Math.pow(distance, 0.5);
		
		return distance;
	}
	
	public boolean checkPos(int playerX, int playerY, int treasureX, int treasureY) {
		if (playerX == treasureX && playerY == treasureY) {
			return true;
		}
		return false;
	}
	
	public void checkAllies(int playerX, int playerY, NPCs[] allies) {
		for (NPCs a : allies) {
			if (playerX == a.getxPos() && playerY == a.getyPos()) {
				System.out.println("you bumped into something...\rit's an ally");
				System.out.println(a.getMessage());
				player.setHealth(player.getHealth()+a.getHealth());
				System.out.println("your health is: "+ player.getHealth());
				a.setMessage("Back again? I've got nothing left to drink");
				a.setHealth(0);
			} 
		}
	}
	
	public void checkEnemies(int playerX, int playerY, NPCs[] enemies) {
		for (NPCs e : enemies) {
			if (playerX == e.getxPos() && playerY == e.getyPos()) {
				System.out.println("you bumped into something...\rit's an enemy! Ouch it attacked you");
				player.setHealth(player.getHealth()-e.getDamage());
				System.out.println("your health is: "+ player.getHealth());
			} 
		}
	}
	
	public void takeTurn() {
		while(!checkPos(player.getxPos(), player.getyPos(), treasure.getxPos(), treasure.getyPos())) {
			move();
			checkAllies(player.getxPos(), player.getyPos(), allyList);
			checkEnemies(player.getxPos(), player.getyPos(), enemyList);
			if(player.getHealth() < 1) {
				setDead(true);
				return;
			}
			System.out.printf("the compass says you are %.2f meters away\r", compass(player.getxPos(), player.getyPos(), treasure.getxPos(), treasure.getyPos()));
		}
	}
	
	public void endGame() {
		if (checkPos(player.getxPos(), player.getyPos(), treasure.getxPos(), treasure.getyPos())) {
			System.out.println("Congratulations "+ player.getName() +"! You have found "+ treasure.getValue() + " coins");
		}
		else {
		}
	}
	
	public void endGame(boolean dead) {
		if (isDead()) {
			System.out.println("Oh no you died! better luck next time");
		}
		else {
		}
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}
}
