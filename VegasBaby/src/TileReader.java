import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TileReader {
	/**
	 * This function reads in a file from .txt
	 * @param fname ~ the file name 
	 * @return the file read from the .txt file
	 */
	public ArrayList<Tiles> readFromText(String fname) {
		File k = new File(fname);
		return readFromText(k);
	}
	public ArrayList<Tiles> readFromText(File k) {
		try {
			ArrayList<Tiles> tilesRead = new ArrayList<Tiles>();
			Scanner fsc = new Scanner(k);
			String line;
			String[] parts;
			int x, y, shape, color;
			Tiles tile;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split(" ");
				x = Integer.parseInt(parts[0]);
				y = Integer.parseInt(parts[1]);
				shape = Integer.parseInt(parts[2]);
				color = Integer.parseInt(parts[3]);
				tile = new Tiles(x,y,shape, color);
				tilesRead.add(tile);
			}
			fsc.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;  // null means I wasn't able to build 
						  // the required array list of dots
		}
	}
	/**
	 * This function reads in a file from .bin
	 * @param fname ~ the file name
	 * @return the file read from the .bin file 
	 */
	public ArrayList<Tiles> readFromBinary(String fname) {
		File f = new File(fname);
		return readFromBinary(f);
	}
	public ArrayList<Tiles> readFromBinary(File k) {
		try {
			ArrayList<Tiles> tilesRead;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(k));
			tilesRead = (ArrayList<Tiles>)ois.readObject();
			ois.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}
	/**
	 * This function reads in a file from .xml
	 * @param fname~ the file name 
	 * @return the file read from the .xml file 
	 */
	public ArrayList<Tiles> readFromXML(String fname) {
		File k = new File(fname);
		return readFromXML(k);
	}
	public ArrayList<Tiles> readFromXML(File k) {
		try {
			ArrayList<Tiles> tilesRead;
			XMLDecoder dec = new XMLDecoder(
					new BufferedInputStream(new FileInputStream(k)));
			tilesRead = (ArrayList<Tiles>)dec.readObject();
			dec.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}
	public ArrayList<Tiles> read(String fname) {
		File k = new File(fname);
		return read(k);
	}
	/**
	 * This function activates the other function based off what the file ends in 
	 * @param k ~ the file
	 * @return which function needed to read the file 
	 */
	public ArrayList<Tiles> read(File k) {
		try {
			String fname = k.getName().toUpperCase();
			if (fname.endsWith(".TXT")) {
				return readFromText(k);
			} else if (fname.endsWith(".BIN")) {
				return readFromBinary(k);
			} else if (fname.endsWith(".XML")) {
				return readFromXML(k);
			} else {
				return null;  // unrecognized extension
			}
		} catch (Exception ex) {
			return null;
		}
}
}
