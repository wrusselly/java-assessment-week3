
public class Player extends Tile {
	
	private String name;
	private int health;
	
	public Player(int xPos, int yPos, String name) {
		super(xPos, yPos);
		this.name = name;
		this.setHealth(10);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void generatePos(int mapX, int mapY) {
		this.setxPos((int) Math.ceil(Math.random()* mapX)); 
		this.setyPos((int) Math.ceil(Math.random()* mapY));
	}
	
	public void movement(String direction, int mapX, int mapY) {
		if(direction.equals("north")) {
			if(this.getyPos() == mapY) {
				this.setyPos(1);
			}
			else {
				this.setyPos(this.getyPos()+1);
			}
		}
		if(direction.equals("south")) {
			if(this.getyPos() == 1) {
				this.setyPos(mapY);
			}
			else {
				this.setyPos(this.getyPos()-1);
			}
		}
		if(direction.equals("east")) {
			if(this.getxPos() == mapX) {
				this.setxPos(1);
			}
			else {
				this.setxPos(this.getxPos()+1);
			}
		}
		if(direction.equals("west")) {
			if(this.getxPos() == 1) {
				this.setxPos(mapX);
			}
			else {
				this.setxPos(this.getxPos()-1);
			}
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	

}
