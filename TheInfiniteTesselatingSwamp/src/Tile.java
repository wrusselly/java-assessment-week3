
public abstract class Tile {
	
	private int xPos;
	private int yPos;
	
	public Tile (int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	abstract public void generatePos(int mapX, int mapY);

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

}
