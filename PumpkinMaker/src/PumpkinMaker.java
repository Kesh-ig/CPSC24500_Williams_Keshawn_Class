import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

class PumpSettings extends JPanel {
	private int hori;
	private int vert;
	private int wide;
	private int tall; 
	private String shapeE;
	private String shapeN;
	private String shapeM;
	private boolean shapeD;
	
	public boolean getShapeD() {
		return shapeD;
	}
	public boolean setShapeD() {
		return this.shapeD=true;
	}
	public String getShapeE() {
		return shapeE;
	}
	public void setShapeE(String shapeE) {
		if ((!shapeE.equalsIgnoreCase("C")) || (!shapeE.equalsIgnoreCase("S")) || (!shapeE.equalsIgnoreCase("T"))) {
			this.shapeE=null; //Come back to
		} else {
			this.shapeE=shapeE;
		}
	}
	public String getShapeN() {
		return shapeN;
	}
	public void setShapeN(String shapeN) {
		if ((!shapeN.equalsIgnoreCase("C")) || (!shapeN.equalsIgnoreCase("S")) || (!shapeN.equalsIgnoreCase("T"))) {
			this.shapeN=null; //Come back to
		} else {
			this.shapeN=shapeN;
		}
	}
	public String getShapeM() {
		return shapeM;
	}
	public void setShapeM(String shapeM) {
		if ((!shapeM.equalsIgnoreCase("O")) || (!shapeE.equalsIgnoreCase("R"))) {
			this.shapeM=null; //Come back to
		} else {
			this.shapeM=shapeM;
		}
	}
	public int getHori() {
		return hori;
	}
	public void setHori(int hori) {
		if (hori < 200) {
			hori=200; 
		} else if (hori> 600) {
			hori= 600;
		} else {
			this.hori=hori;
		}
	}
	public int getVert() {
		return vert;
	}
	public void setVert(int vert) {
		if (vert < 100) {
			vert = 100;
		} else if (vert > 370) {
			vert = 370; 
		} else {
			this.vert = vert;
		}
	}
	public int getWide() {
		return wide;
	}
	public void setWide(int wide) {
		if (wide < 100) {
			wide = 100;
		} else if (wide > 650) {
			wide = 550;
		} else {
			this.wide = wide;
		}
	}
	public int getTall() {
		return tall;
	}
	public void setTall(int tall) {
		if (tall < 100) {
			tall = 100;
		} else if (tall > 300) {
			tall = 300;
		} else {
			this.tall = tall;
		}
	}
	public void DrawingPanel() {
		setShapeD();
		setShapeE("C");
		setShapeN("S");
		setShapeM("O");
	}
  @Override
  public void paintComponent (Graphics p) {
	  super.paintComponent(p);
	  
	  if (shapeD = true) {
		p.setColor(Color.ORANGE);
		p.fillOval(200,100,100,100);
		p.setColor(Color.WHITE);
		p.fillRect(225,150,50,50);
	  }
	  
	  
	  int x1[] = {hori+10, hori+8, hori+12};
	  int y1[] = {vert-5, vert-8, vert-8};
	  int x2[] = {hori+20, hori+18, hori+22};
	  int y2[] = {vert-5, vert-8, vert-8};
	  int x3[] = {hori+15, hori+13, hori+17};
	  int y3[] = {vert-15, vert-20, vert-20}; 
	  
	  if (shapeE.equalsIgnoreCase("C")) {
		  p.setColor(Color.WHITE);
		  p.fillOval(hori+10,vert-5,10,10);
		  p.fillOval(hori+20,vert-25,10,10);
	  } else if (shapeE.equalsIgnoreCase("S")) {
		  p.setColor(Color.WHITE);
		  p.fillRect(hori+10, vert+10, 10, 10);
		  p.fillRect(hori+20,vert-25,10,10);
	  } else if (shapeE.equalsIgnoreCase("T")) {
		  p.setColor(Color.WHITE);
		  p.fillPolygon(x1,y1,3);
		  p.fillPolygon(x2,y2,3);
	  } 
	  if (shapeN.equalsIgnoreCase("C")) {
		  p.setColor(Color.WHITE);
		  p.fillOval(hori+15,vert-15,10,10);
	  } else if (shapeN.equalsIgnoreCase("S")) {
		  p.setColor(Color.WHITE);
		  p.fillRect(hori+15,vert-15,10,10); 
	  } else if (shapeN.equalsIgnoreCase("T")) {
		  p.setColor(Color.WHITE);
		  p.fillPolygon(x3,y3,3);
	  }
	  if (shapeM.equalsIgnoreCase("O")) {
		  p.setColor(Color.WHITE);
		  p.fillOval(hori+10, vert-25, wide-25, 10);
	  } else if (shapeM.equalsIgnoreCase("R")) {
		  p.setColor(Color.WHITE);
		  p.fillRect(hori+10, vert-25, wide-25, 10);
	  } 
  }
}

class PumpFrame extends JFrame {
	
	public void centerFrame(int width, int height) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenDims = tk.getScreenSize();
		int screenWidth = (int)screenDims.getWidth();
		int screenHeight = (int)screenDims.getHeight();
		int left = (screenWidth - width)/2;
		int top = (screenHeight- height)/2;
		setBounds(left,top,width,height);
	}
	
	public void frameLook() {
		centerFrame(800,480);
		setTitle("Pumpkin Maker"); 
		Container cont = getContentPane();
		cont.setLayout(new BorderLayout());
		PumpSettings centerPan = new PumpSettings();
		cont.add(centerPan, BorderLayout.CENTER);
		JPanel southPan = new JPanel();
		southPan.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("Left: ");
		southPan.add(label1);
		JLabel label2 = new JLabel("Top: ");
		southPan.add(label2);
		JLabel label3 = new JLabel("Width: ");
		southPan.add(label3);
		JLabel label4 = new JLabel("Height: ");
		southPan.add(label4);
		JLabel label5 = new JLabel("Eye (C S T): ");
		southPan.add(label5);
		JLabel label6 = new JLabel("Nose (C S T): ");
		southPan.add(label6);
		JLabel label7 = new JLabel("Mouth (O R): ");
		southPan.add(label7);
		JButton button1 = new JButton ("Draw");
		cont.add(southPan, BorderLayout.SOUTH);
	}
	
	public PumpFrame() {
		frameLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class PumpkinMaker {
	public static void main(String[] args) {
	PumpFrame pf1 = new PumpFrame ();
	pf1.setVisible(true);

	}

}
