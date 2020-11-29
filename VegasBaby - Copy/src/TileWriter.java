import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TileWriter {
	/**
	 * This function returns the file written in a text form
	 * @param fname ~ the file
	 * @param tiles ~ a variable used 
	 * @return the file in .txt form
	 */
	public boolean writeToText(String fname, ArrayList<Tiles> tiles) {
		File k = new File(fname);
		return writeToText(k,tiles);  // delegation - lean on another function to do your task
	}
	public boolean writeToText(File k, ArrayList<Tiles>tiles) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(k)));
			for (Tiles tile : tiles) {
				pw.println(tile);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	/**
	 * This function returns the file in a binary form
	 * @param fname ~ the file name 
	 * @param tiles ~ a variable used 
	 * @return the file in .bin form
	 */
	public boolean writeToBinary(String fname, ArrayList<Tiles> tiles) {
		File k = new File(fname);
		return writeToBinary(k,tiles);
	}
	
	public boolean writeToBinary(File k, ArrayList<Tiles> tiles) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(k));
			oos.writeObject(tiles);
			oos.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	} 
	/**
	 * This function takes in input and returns turns the file into the needed file type 
	 * @param k ~ the file
	 * @param tiles ~ the array of numbers
	 * @return the correct file type based off the input given 
	 */
	public boolean write(File k, ArrayList<Tiles> tiles) {
		try {
			String fname = k.getName().toUpperCase();
			if (fname.endsWith(".TXT")) {
				return writeToText(k,tiles);
			} else if (fname.endsWith(".BIN")) {
				return writeToBinary(k,tiles);
			} else if (fname.endsWith(".XML")) {
				return writeToXML(k,tiles);
			} else {
				return false;  // unrecognized file format
			}
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean write(String fname, ArrayList<Tiles> tiles) {
		File k = new File(fname);
		return write(k,tiles);
	}
	/**
	 * This function returns the file in a xml form
	 * @param fname ~ the file 
	 * @param tiles ~ a variable used 
	 * @return the file in .xml form
	 */
	public boolean writeToXML(String fname, ArrayList<Tiles> tiles) {
		File k = new File(fname);
		return writeToXML(k,tiles);
	}
	public boolean writeToXML(File k, ArrayList<Tiles> tiles) {
		try {
			XMLEncoder enc = new XMLEncoder(new 
					BufferedOutputStream(new FileOutputStream(k)));
			enc.writeObject(tiles);
			enc.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
