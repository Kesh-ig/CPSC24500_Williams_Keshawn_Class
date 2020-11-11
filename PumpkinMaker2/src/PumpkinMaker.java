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
import javax.swing.JTextField;
import javax.swing.JOptionPane;
/**
 * 
 * @author Keshawn
 *
 */

class PumpkinSettings extends JPanel {
	private int hori;
	private int vert;
	private int wide;
	private int tall; 
	private int shapeE;
	private int shapeN;
	private int shapeM;
	private int shapeD;
	
	/** gets the value of horizon */
	public int getHori() {
		return hori;
	}
	/** sets the value of horizon */
	public void setHori(int hori) {
		if (hori < 200) {
			hori=200; 
		} else if (hori> 600) {
			hori= 600;
		} else {
			this.hori=hori;
		} repaint();
	}
	/** gets the value of vertical */
	public int getVert() {
		return vert;
	}
	/** sets the value of vertical */
	public void setVert(int vert) {
		if (vert < 100) {
			vert = 100;
		} else if (vert > 370) {
			vert = 370; 
		} else {
			this.vert = vert;
		} repaint();
	}
	/** gets the value of width */
	public int getWide() {
		return wide;
	}
	/** sets the value of vertical */
	public void setWide(int wide) {
		if (wide < 100) {
			wide = 100;
		} else if (wide > 650) {
			wide = 550;
		} else {
			this.wide = wide;
		} repaint();
	}
	/** gets the value of height */
	public int getTall() {
		return tall;
	}
	/** sets the value of vertical */
	public void setTall(int tall) {
		if (tall < 100) {
			tall = 100;
		} else if (tall > 300) {
			tall = 300;
		} else {
			this.tall = tall;
		} repaint();
	}
	/** gets the code for the eyes  */
	public int getShapeE() {
		return shapeE;
	}
	/** sets the code for the eyes  */
	public void setShapeE(int num) {
		if (num ==1 ) {
			this.shapeE=1;
		} else if (num ==2) {
			this.shapeE=2;
		} else if (shapeE==3) {
			this.shapeE = 3;
		} else {
			shapeE = num;
		} repaint();
	}
	/** gets the code for the nose  */
	public int getShapeN() {
		return shapeN;
	}
	/** sets the code for the nose  */
	public void setShapeN(int num2) {
		if (num2 ==1 ) {
			this.shapeN=1;
		} else if (num2 ==2) {
			this.shapeN=2;
		} else if (shapeN==3) {
			this.shapeN = 3;
		} else {
			shapeN = num2;
		} repaint();
	}
	/** gets the code for the mouth  */
	public int getShapeM() {
		return shapeM;
	}
	/** sets the code for the mouth  */
	public void setShapeM(int num3) {
		if (num3 ==1 ) {
			this.shapeM=1;
		} else if (num3 ==2) {
			this.shapeM=2;
		}  else {
			shapeM = num3;
		} repaint();
	}
	/** sets the original pumpkin  */
	public PumpkinSettings() {
	hori=200;
	vert=100;
	wide=100;
	tall=100;
	shapeE=1;
	shapeN=2;
	shapeM=1;
	
	}
	/** paints out the pumpkin under the different conditions  */
  @Override
  public void paintComponent(Graphics g) {
	  super.paintComponent(g);
	  
	  g.setColor(Color.WHITE);
	  g.fillRect(hori+38,vert-18,wide-75,tall-82);
	  g.setColor(Color.ORANGE);
	  g.fillOval(hori, vert, wide, tall);
	  
	  int x1[] = {hori+(wide/4)+(wide/16), hori+(wide/4), hori+(wide/4)+(wide/8)};
	  int y1[] = {vert+(tall/4), vert+(tall/4)+(tall/6), vert+(tall/4)+(tall/6)};
	  int x2[] = {hori+(wide/2)+(wide/4)+(wide/16), hori+(wide/2)+(wide/4), hori+(wide/2)+(wide/4)+(wide/8)};
	  int y2[] = {vert+(tall/4), vert+(tall/4)+(tall/6), vert+(tall/4)+(tall/6)};
	  int x3[] = {hori+(wide/2), hori+(wide/2)-(wide/8), hori+(wide/2)+(wide/8)};
	  int y3[] = {vert+(tall/2), vert+(tall/2)+(tall/8), vert+(tall/8)};
	  
	  if (shapeE==1) {
		  g.setColor(Color.WHITE);
		  g.fillOval(hori+(wide/4),vert+(tall/4),wide/6,tall/6);
		  g.fillOval(hori+(wide/2)+(wide/4),vert+(tall/4),wide/6,tall/6);
	  } else if (shapeE==2) {
		  g.setColor(Color.WHITE);
		  g.fillRect(hori+(wide/4),vert+(tall/4),wide/6,tall/6);
		  g.fillRect(hori+(wide/2)+(wide/4),vert+(tall/4),wide/6,tall/6);
	  } else if (shapeE==3) {
		  g.setColor(Color.WHITE);
		  g.fillPolygon(x1,y1,3);
		  g.fillPolygon(x2,y2,3);
	  } else {
		  
	  }
	  if (shapeN==1) {
		  g.setColor(Color.WHITE);
		  g.fillOval(hori+(wide/2),vert+(tall/2),wide/6,tall/6);
	  } else if (shapeN==2) {
		  g.setColor(Color.WHITE);
		  g.fillRect(hori+(wide/2),vert+(tall/2),wide/6,tall/6); 
	  } else if (shapeN==3) {
		  g.setColor(Color.WHITE);
		  g.fillPolygon(x3,y3,3);
	  } else {
		  
	  }
	  if (shapeM==1) {
		  g.setColor(Color.WHITE);
		  g.fillOval(hori+(wide/4), vert+(tall/2)+(tall/4), wide/3, tall/6);
	  } else if (shapeM==2) {
		  g.setColor(Color.WHITE);
		  g.fillRect(hori+(wide/4), vert+(tall/2)+(tall/4), wide/3, tall/6);
	  } else {
		  
	  }
  }
	
}
/** handles the input of the button  */
class ButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"was handled by a different class");
	}
}
class PumpFrame extends JFrame {
	/** centers the frame */
	public void centerFrame(int wide, int tall) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenDim = tk.getScreenSize();
		int screenWide = (int)screenDim.getWidth();
		int screenTall = (int)screenDim.getHeight();
		int x = (screenWide - wide)/2;
		int y = (screenTall- tall)/2;
		setBounds(x,y,wide,tall);
	}
	/** sets how the frame will look  */
	public void frameLook() {
		centerFrame(800,480);
		setTitle("Pumpkin Maker~Keshawn"); 
		Container cont = getContentPane();
		cont.setLayout(new BorderLayout());
		PumpkinSettings centerPan = new PumpkinSettings();
		cont.add(centerPan, BorderLayout.CENTER);
		JPanel southPan = new JPanel();
		southPan.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("Left: ");
		southPan.add(label1);
		JTextField txtLabel1 = new JTextField(2);
		southPan.add(txtLabel1);
		JLabel label2 = new JLabel("Top: ");
		southPan.add(label2);
		JTextField txtLabel2 = new JTextField(2);
		southPan.add(txtLabel2);
		JLabel label3 = new JLabel("Width: ");
		southPan.add(label3);
		JTextField txtLabel3 = new JTextField(2);
		southPan.add(txtLabel3);
		JLabel label4 = new JLabel("Height: ");
		southPan.add(label4);
		JTextField txtLabel4 = new JTextField(2);
		southPan.add(txtLabel4);
		JLabel label5 = new JLabel("Eye (1C 2S 3T): ");
		southPan.add(label5);
		JTextField txtLabel5 = new JTextField(2);
		southPan.add(txtLabel5);
		JLabel label6 = new JLabel("Nose (1C 2S 3T): ");
		southPan.add(label6);
		JTextField txtLabel6 = new JTextField(2);
		southPan.add(txtLabel6);
		JLabel label7 = new JLabel("Mouth (1O 2R): ");
		southPan.add(label7);
		JTextField txtLabel7 = new JTextField(2);
		southPan.add(txtLabel7);
		JButton button1 = new JButton ("Draw");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					centerPan.setHori(Integer.parseInt((txtLabel1.getText())));
					centerPan.setVert(Integer.parseInt((txtLabel2.getText())));
					centerPan.setWide(Integer.parseInt((txtLabel3.getText())));
					centerPan.setTall(Integer.parseInt((txtLabel4.getText())));
					centerPan.setShapeE(Integer.parseInt((txtLabel5.getText())));
					centerPan.setShapeN(Integer.parseInt((txtLabel6.getText())));
					centerPan.setShapeM(Integer.parseInt((txtLabel7.getText())));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"The input you entered isnt valid");
				}
				repaint();
			}
		});
		southPan.add(button1);
		cont.add(southPan, BorderLayout.SOUTH);
	}
	/** makes sure the program exits when you close it */
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
