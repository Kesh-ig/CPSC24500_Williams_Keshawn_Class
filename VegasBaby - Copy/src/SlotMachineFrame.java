import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SlotMachineFrame extends JFrame {
	private TilesPanel panCenter;
	private JButton mxButton = new JButton ("Max");
	private JButton mdButton = new JButton ("Mid");
	private JButton mnButton = new JButton ("Min");
	private JTextField monText = new JTextField(9);
	/**
	 * Sets up the menu at the top of the program with file and help being shown 
	 */
	public void vegasMenu() {
		JMenuBar menu = new JMenuBar();	
		JMenu fileMenu = new JMenu ("File");
		JMenuItem saveMenu = new JMenuItem("Save Tiles");
		saveMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				JFileChooser fc = new JFileChooser();
				TileWriter tw = new TileWriter();
				if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					if (tw.writeToText(fc.getSelectedFile(),panCenter.getTile())) {
						JOptionPane.showMessageDialog(null,"Tiles were written.");
					} else if (tw.writeToBinary(fc.getSelectedFile(),panCenter.getTile())) {
						JOptionPane.showMessageDialog(null,"Tiles were written.");
					} else if (tw.writeToXML(fc.getSelectedFile(),panCenter.getTile())) {
						JOptionPane.showMessageDialog(null,"Tiles were written.");
					} else {
						JOptionPane.showMessageDialog(null,"Tiles could not be written.");
					}
			}
		}
		});
		fileMenu.add(saveMenu);
		JMenuItem loadMenu = new JMenuItem("Load Tiles"); 
		loadMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				JFileChooser fc = new JFileChooser();
				TileReader tr;
				ArrayList<Tiles> tilesRead;
				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					tr = new TileReader();
					tilesRead = tr.read(fc.getSelectedFile());
					if (tilesRead == null) {
						JOptionPane.showMessageDialog(null,"Could not read.");
					} else {
						panCenter.setTiles(tilesRead);
						repaint();
					}
				}
			}
		});
		fileMenu.add(loadMenu);
		JMenuItem print = new JMenuItem("Print"); 
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Tiles loca : panCenter.getTile()) {
					System.out.println(loca.toStringWords());
				}
			}
		});
		fileMenu.add(print);
		JMenuItem restart = new JMenuItem("Restart");
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panCenter.newTile();
				mxButton.setEnabled(true);
				mdButton.setEnabled(true);
				mnButton.setEnabled(true);
				panCenter.setCash(5);
			}
		});
		fileMenu.add(restart);
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(exit);
		menu.add(fileMenu);
		JMenu helpMenu = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Keshawn, github.com/Kesh-ig/CPSC24500_Williams_Keshawn_Class");
			}
		});
		helpMenu.add(about);
		menu.add(helpMenu);
		setJMenuBar(menu);
		}
		/** 
		 * This function centers the frame of the program 
		 * @param wide ~ how wide the screen is 
		 * @param tall ~ how tall the screen is 
		 */
		public void frameCenter(int wide, int tall) {
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension screenDim = tk.getScreenSize();
			int screenWide = (int)screenDim.getWidth();
			int screenTall = (int)screenDim.getHeight();
			int x = (screenWide - wide)/2;
			int y = (screenTall- tall)/2;
			setBounds(x,y,wide,tall);
		}
		/**
		 * This function sets up how the center and bottom of the frame of the program will look
		 */
		public void slotMachineLook() {
			frameCenter(800, 480);
			setTitle ("Vegas Baby Vegas Slot Machine ");
			Container co = getContentPane();
			panCenter = new TilesPanel();
			co.add(panCenter,BorderLayout.CENTER);
			JPanel panSouth = new JPanel ();
			panSouth.setLayout(new FlowLayout());
			mxButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panCenter.newTile();
					panCenter.tileChecketh(100,25);
					monText.setText(String.format("%.2f", panCenter.getCash()));
					if (panCenter.getCash()==0) {
						mxButton.setEnabled(false);
						mdButton.setEnabled(false);
						mnButton.setEnabled(false);
					} else {
						
					}

					repaint();
				}
			});
			panSouth.add(mxButton);
			mdButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panCenter.newTile();
					panCenter.tileChecketh(50,10);
					monText.setText(String.format("%.2f", panCenter.getCash()));
					if (panCenter.getCash()==0) {
						mxButton.setEnabled(false);
						mdButton.setEnabled(false);
						mnButton.setEnabled(false);
					} else {
						
					}
					repaint();
				}
			});
			panSouth.add(mdButton);
			mnButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panCenter.newTile();
					panCenter.tileChecketh(10,5);
					monText.setText(String.format("%.2f", panCenter.getCash()));
					if (panCenter.getCash()==0) {
						mxButton.setEnabled(false);
						mdButton.setEnabled(false);
						mnButton.setEnabled(false);
					} else {
						
					}
					repaint();
				}
			});
			panSouth.add(mnButton);
			JLabel monLabel = new JLabel ("$ ");
			panSouth.add(monLabel);
			monText.setText(String.format("%.2f", panCenter.getCash()));
			panSouth.add(monText);
			co.add(panSouth, BorderLayout.SOUTH);
			vegasMenu();
		}
		/**
		 * This function closes the program when the user exits the program
		 */
		public SlotMachineFrame () {
			slotMachineLook();
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
}
