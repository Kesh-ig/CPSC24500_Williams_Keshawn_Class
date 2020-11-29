import java.util.ArrayList;

public class TileChecker {
	/**
	 * This function is used for checking the colors of the tiles for matches 
	 * @param tiles THe array list of values 
	 * @return true if they match and false if they dont 
	 */
	public boolean checkieColor (ArrayList<Tiles> tiles) {
		boolean good=false;
		for(Tiles loca : tiles) {
			for(int i = 0; i < tiles.size(); i++){
				if (loca.getColor()== tiles.get(i).getColor()) {
					good=true;
				} else {
					return false;
				}
				
			}
		} 
		return good;
	}
	/**
	 * This function is used for checking the shapes of the tiles for matches 
	 * @param tiles
	 * @return
	 */
	public boolean checkieShape (ArrayList<Tiles> tiles) {
		boolean good=false;
		for(Tiles loca : tiles) {
			for(int i = 0; i < tiles.size(); i++){
				if (loca.getColor()== tiles.get(i).getShape()) {
					good=true;
				} else {
					return false;
				}
				
			}
		} 
		return good;
	}
}
