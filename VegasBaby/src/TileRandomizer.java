import java.util.ArrayList;


public class TileRandomizer {
	/**
	 * This is the function for the randomizer for the buttons
	 * @param tiles The array list of numbers used for the shapes 
	 * @return the new array list of values after the operation finishes
	 */
	public ArrayList<Tiles> randy(ArrayList<Tiles> tiles) {
		for (Tiles loca : tiles) {
			loca.setRandomly();
		} 
		return tiles;
	}
}
