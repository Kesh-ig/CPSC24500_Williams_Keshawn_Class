import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TileWriter {
	
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
}
