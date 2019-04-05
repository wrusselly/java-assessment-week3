
public class NPCs extends Tile{

	private String message;
	private int damage;
	private int health;
	
	
	
	public NPCs(int xPos, int yPos, int damage) {
		super(xPos, yPos);
		this.damage = damage;
	}
	
	public NPCs(int xPos, int yPos, String message, int health) {
		super(xPos, yPos);
		this.message = message;
		this.health = health;
	}
	
	public void generatePos(int mapX, int mapY) {
		this.setxPos((int) Math.ceil(Math.random()* mapX)); 
		this.setyPos((int) Math.ceil(Math.random()* mapY));
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
}
