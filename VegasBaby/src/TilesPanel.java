import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class TilesPanel extends JPanel {
	private ArrayList<Tiles> tile;

	
	public ArrayList<Tiles> getTile() {
		return tile;
	}
	public void setTiles(ArrayList<Tiles> list) {
		tile = list; 
	}
	public TilesPanel() {
		tile = new ArrayList<Tiles>();
		Tiles shape1 = new Tiles(20,100,1,3);
		tile.add(shape1);
		Tiles shape2 = new Tiles(200,100,0,5);
		tile.add(shape2);
		Tiles shape3 = new Tiles(380,100,0,4);
		tile.add(shape3);
		Tiles shape4 = new Tiles(560,100,0,4);
		tile.add(shape4);
	}
  @Override
  public void paintComponent (Graphics g) {
	  super.paintComponent(g);
	  
	  for(Tiles shape : tile) {
		  if(shape.getShape()==0) {
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
}
