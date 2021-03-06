import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class TilesPanel extends JPanel implements MouseListener {
	private ArrayList<Tiles> tile;
	private TileRandomizer randy;
	private double cash=5;
	private TileChecker check;
	
	/**
	 * This function returns the variable that tracks cash
	 * @return the cash it tracks 
	 */
	public double getCash() {
		return cash;
	}
	public void setCash(double cash) {
		this.cash = cash;
	}
	/**
	 * This function returns an array of variables 
	 * @return the variables needed to create the tile 
	 */
	public ArrayList<Tiles> getTile() {
		return tile;
	}
	public void setTiles(ArrayList<Tiles> list) {
		tile = list; 
	}
	/**
	 * This function sets the location size and colors for the starting of the slot machine 
	 */
	public TilesPanel() {
		addMouseListener(this);
		Random random = new Random();
		tile = new ArrayList<Tiles>();
		Tiles shape1 = new Tiles(20,100,random.nextInt(2)+1,random.nextInt(5)+1);
		tile.add(shape1);
		Tiles shape2 = new Tiles(200,100,random.nextInt(2)+1,random.nextInt(5)+1);
		tile.add(shape2);
		Tiles shape3 = new Tiles(380,100,random.nextInt(2)+1,random.nextInt(5)+1);
		tile.add(shape3);
		Tiles shape4 = new Tiles(560,100,random.nextInt(2)+1,random.nextInt(5)+1);
		tile.add(shape4);
	}
  @Override
  public void paintComponent (Graphics g) {
	  super.paintComponent(g);
	  
	  for(Tiles shape : tile) {
		  if(shape.getShape()==1) {
			if(shape.getColor()==1) {
				g.setColor(Color.YELLOW);
			} else if (shape.getColor()==2) {
				g.setColor(Color.GREEN);
			} else if (shape.getColor()==3) {
				g.setColor(Color.ORANGE);
			} else if (shape.getColor()==4) {
				g.setColor(Color.RED);
			}else {
				g.setColor(Color.BLUE);
			} g.fillRect(shape.getX(), shape.getY(), shape.getSize(), shape.getSize());
		  } else {
			  if(shape.getColor()==1) {
					g.setColor(Color.YELLOW);
				} else if (shape.getColor()==2) {
					g.setColor(Color.GREEN);
				} else if (shape.getColor()==3) {
					g.setColor(Color.ORANGE);
				} else if (shape.getColor()==4) {
					g.setColor(Color.RED);
				}else {
					g.setColor(Color.BLUE);
				} g.fillOval(shape.getX(), shape.getY(), shape.getSize(), shape.getSize());
		  }
	  }
	  
  }
  /**
   * This function takes in the location of the mouse click and changes the shape and color of it 
   */
  public void mouseClicked (MouseEvent e) {
	  int xVal = e.getX();
	  int yVal = e.getY();
	  for (Tiles loca: tile) {
		  if (xVal>20 && xVal<190 && yVal>100 && yVal<270) {
			  loca.setRandomly();
		  } else if (xVal>200 && xVal<370 && yVal>100 && yVal<270) {
			  loca.setRandomly();
		  } else if (xVal>380 && xVal<550 && yVal>100 && yVal<270) {
			  loca.setRandomly();
		  } else if (xVal>560 && xVal<730 && yVal>100 && yVal<270) {
			  loca.setRandomly();
		  }
	  } repaint();
  }
  public void mouseExited(MouseEvent e) {
	  
  }
  public void mouseReleased(MouseEvent e) {
	  
  }
  public void mouseEntered(MouseEvent e) {
	  
  }
  public void mousePressed(MouseEvent e) {
	  
  }
  /**
   * This function connects the tile randomizer class to the setTiles for the buttons 
   */
  public void newTile() {
	  randy=new TileRandomizer();
	  setTiles(randy.randy(tile));
  }
  /**
   * This function is used to check the tiles   
   * @param m for the first value for the percentages to be multiplied with the cash  
   * @param n for the second smaller value for the percentages to be multiplied with the cash 
   */
  public void tileChecketh(int m, int n) {
	  check= new TileChecker();
	  if (check.checkieColor(tile)) {
		  if (check.checkieShape(tile)) {
			  cash*=m;
		  } else {
			  cash*=n;
		  }
	  }	else {
		  cash-=cash*(m/100.0);
	  }
  }
}
