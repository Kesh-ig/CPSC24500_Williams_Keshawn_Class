
public class Tiles {
	private int x;
	private int y;
	int shape;
	int color;
	int size;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getShape() {
		return shape;
	}
	public void setShape(int shape) {
		this.shape = shape;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		 this.size =size ;
	}
	public Tiles() { 
		size=160;
	}
	public Tiles(int x, int y, int shape, int color) {
		setX(x);
		setY(y);
		setShape(shape);
		setColor(color);
		size=170;
	}
	@Override
	public String toString() {
		return String.format("%d %d %d %d", x, y, shape, color);
	}
}
