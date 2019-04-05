
public class Treasure extends Tile {
	
	private int value;
	
	public Treasure(int xPos, int yPos, int value) {
		super(xPos, yPos);
		this.setValue(value);
	}
	
	public void generatePos(int mapX, int mapY) {
		this.setxPos((int) Math.ceil(Math.random()* mapX)); 
		this.setyPos((int) Math.ceil(Math.random()* mapY));
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
