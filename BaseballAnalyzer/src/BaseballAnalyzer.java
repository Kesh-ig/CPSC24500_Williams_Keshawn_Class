import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
/**
 * 
 * @author Keshawn
 *
 */
public class BaseballAnalyzer {
	public static void Welcome() { /** The welcoming function */
	
		System.out.println("******************************************");
		System.out.println("*       BASEBALL STANDING ANALYZER       *");
		System.out.println("******************************************");
		System.out.println();
		System.out.println("This program reads a file that contains");
		System.out.println("current baseball standings and adds to");
		System.out.println("more detailed statistics. It also prints");
		System.out.println("overall standings in the American and");
		System.out.println("national leagues.");
	}
	public static int Menu (Scanner sc) { /** The menu for the choices */
		System.out.println("Which league would you like to view? ");
		System.out.println("1: AL East");
		System.out.println("2: AL Central");
		System.out.println("3: AL West");
		System.out.println("4: NL East");
		System.out.println("5: NL Central");
		System.out.println("6: NL West");
		System.out.println("7: All Leagues");
		System.out.println("8: Exit");
		int decision = sc.nextInt();
		return decision;
	}
	public static double getPctg (String row) { /** The creation of the winning percentages */ 
		String[] piece = row.split("\t");
		double pctg = (Integer.parseInt(piece[1])/ (Integer.parseInt(piece[1])+Integer.parseInt(piece[2])));
		return pctg; 
	}
	public static void showStats(ArrayList<String> stats) { /** Displaying the statistics from the text file */
		String[] piece;
		double pctg;
		for (String stat: stats ) {
			piece = stat.split("\t");
			pctg = getPctg(stat);
			System.out.printf( "%-15s%-8s%-8s%6.2f \n ", piece[0], piece[1], piece[2], pctg );
		}	
	}
	public static void byPctg(ArrayList<String> league, String row) { /** Updating the list to have the variables within the data */
		double pctg1 = getPctg(row); 
		double pctg2;
		int pos = -1;
		for (int i = 0; i < league.size(); i++) {
			pctg2 = getPctg(league.get(i));
			if (pctg1 > pctg2) {
				pos = 1;
				break;
			}
			if (pos<0) {
				league.add(row);
			} else {
				league.add(pos,row);
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the file: ");
		String file = sc.nextLine(); 
		ArrayList<String> alEast = new ArrayList<String>();
		ArrayList<String> alCentral = new ArrayList<String>();
		ArrayList<String> alWest = new ArrayList<String>();
		ArrayList<String> nlEast = new ArrayList<String>();
		ArrayList<String> nlCentral = new ArrayList<String>();
		ArrayList<String> nlWest = new ArrayList<String>();
		ArrayList<String> aim = null;
		ArrayList<String> everything = new ArrayList<String>(); 
		String row; 
		String par=null;
		String[] parts;
		boolean moveOn;
		int decision;
		try {
			Scanner fsc = new Scanner(new File(file));
			while (fsc.hasNextLine()) {
				row = fsc.nextLine();
				parts = row.split("\t");
				if (parts[0].trim().equalsIgnoreCase("LEAGUE".trim())) {
				par = parts[1].toUpperCase();
			}	
				if (par.equalsIgnoreCase("AL EAST")) {
					aim = alEast;
				} else if (par.equalsIgnoreCase("AL CENTRAL")) {
					aim = alCentral;
				} else if (par.equalsIgnoreCase("AL WEST")) {
					aim = alWest;
				} else if (par.equalsIgnoreCase("NL EAST")) {
					aim = nlEast;
				} else if (par.equalsIgnoreCase("NL CENTRAL")) {
					aim = nlCentral;
				} else if (par.equalsIgnoreCase("NL WEST")) {
					aim = nlWest; 
				} else {
					aim.add(row);
					byPctg(everything,row);
				}
		}Welcome();
		moveOn = true;
		

	} catch (Exception ex) {
		ex.printStackTrace();
		System.out.println("File couldnt be read");
		moveOn=false;
	}
	if (moveOn) {
		do {
			decision = Menu(sc);
			if (decision == 1) {
				showStats(alEast);
			} else if (decision == 2) {
				showStats(alCentral);
			} else if (decision == 3) {
				showStats(alWest);
			} else if (decision == 4) {
				showStats(nlEast);
			} else if (decision == 5) {
				showStats(nlCentral);
			} else if (decision == 6) {
				showStats(nlWest);
			} else if (decision== 7) {
				showStats(everything);
			}
		} while (decision !=8);
	}

}
}
