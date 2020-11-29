import java.io.Serializable;
import java.util.Random;

public class Tiles implements Serializable {
	private int x;
	private int y;
	int shape;
	int color;
	int size;
	private static final String[] colorNames = {"yellow","green","orange","red","blue"};
	private static final String[] shapes = {"square","circle"};
	
	/**
	 * This function returns the x variable 
	 * @return the x coordinate 
	 */
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * This function returns the y variable 
	 * @return the y coordinate 
	 */
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * This function returns the shape variable
	 * @return the shape type 
	 */
	public int getShape() {
		return shape;
	}
	public void setShape(int shape) {
		this.shape = shape;
	}
	/**
	 * This function returns the color variable 
	 * @return the color type
	 */
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	/**
	 * This function returns the size variable 
	 * @return the size of the shapes 
	 */
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		 this.size =size ;
	}
	/**
	 * This function sets the size for each shape to be the same 
	 */
	public Tiles() { 
		size=160;
	}
	/** 
	 * This functions sets the array of variables needed to create each of the shapes  
	 * @param x ~ the x coordinate 
	 * @param y ~ the y coordinate 
	 * @param shape ~ which shape it will be 
	 * @param color ~ the color it will be 
	 */
	public Tiles(int x, int y, int shape, int color) {
		setX(x);
		setY(y);
		setShape(shape);
		setColor(color);
		size=170;
	}
	/**
	 * This function chooses the random numbers for the shape and color 
	 */
	public void setRandomly() {
		Random random = new Random();
        color = random.nextInt(5)+1;
        shape = random.nextInt(2)+1;
	}
	/**
	 * This function connects the color names to the color it codes to
	 * @return the color names 
	 */
	public String getColorName() {
		return colorNames[color];
	}
	/**
	 * This function connects the shape names to the shape it codes
	 * @return the shape names
	 */
	public String getShapeAsString() {
		return shapes[shape];
	}
	public String toStringWords() {
		return String.format("%s %s", getColorName(), getShapeAsString());
	}
	@Override
	public String toString() {
		return String.format("%d %d %d %d", x, y, shape, color);
	}
	
}
