import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
/**
 * 
 * @author Keshawn
 *
 */

public class baseballStanding {
	public static void welcome () {
		System.out.println("*************************************");
		System.out.println("*   BASEBALL STANDING ANALYZER      *");
		System.out.println("*************************************");
		System.out.println();
		System.out.println("This program contains a file that contains");
		System.out.println("current baseball standings and add to");
		System.out.println("more detailed statistic. It also prints");
		System.out.println("overall standings in American and");
		System.out.println("national leagues.");
	}
	public static int Menu(Scanner sc) {
		System.out.println("Choose a league ");
		System.out.println("1. AL East");
		System.out.println("2. AL Central");
		System.out.println("3. AL West");
		System.out.println("4. NL Eest");
		System.out.println("5. NL Central");
		System.out.println("6. NL West");
		System.out.println("7. Overall");
		System.out.println("8. Exit");
		System.out.print("Enter choice: ");
		int decision = sc.nextInt();
		return decision;
	}
	public static void printInfo(ArrayList<String> league) {
		String [] colomns;
		double pctg;
		System.out.println("yyyyyyyyyy");
		for (String wins : league) {
			System.out.println("ggggggggggggg");
			colomns = wins.split("\t");
			System.out.println(colomns);
			pctg = winPercentage(wins);
			System.out.println(pctg);
			System.out.printf("%-10s%6.2f\n",colomns[0],pctg);
		}
	}
	public static double winPercentage (String row) {
		String[] colomns= row.split("\t"); 
		double perc = (Integer.parseInt(colomns[1])) / (Integer.parseInt(colomns[1])+Integer.parseInt(colomns[2]));
		return perc;
	}
	public static void insertPctg(ArrayList<String>every,String row) {
		double pctg = winPercentage(row);
		double otherPctg;
		int spot=-1;
		for (int b =0; b<every.size(); b++) {
			otherPctg = winPercentage(every.get(b));
			if(pctg>otherPctg) {
				spot = b;
				break;
			}
		}
		if (spot<0) {
			every.add(row);
		} else {
			every.add(spot,row);
		}
	}
	public static void losesBehind (String row) {
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fold;
		ArrayList<String> alEast = new ArrayList<String>();
		ArrayList<String> alCentral = new ArrayList<String>();
		ArrayList<String> alWest = new ArrayList<String>();
		ArrayList<String> nlEast = new ArrayList<String>();
		ArrayList<String> nlCentral = new ArrayList<String>();
		ArrayList<String> nlWest = new ArrayList<String>();
		ArrayList<String> allLeague = new ArrayList<String>();
		ArrayList<String> aim = null;
		
		String row;
		String[] colomn;
		String leag;
		boolean vars = false;
		int decide;
		try {
			System.out.print("Enter name of file: ");
			fold = sc.nextLine();
			Scanner gh = new Scanner(new File(fold));
			while (gh.hasNextLine()) {
				row = gh.nextLine();
				System.out.println(row);
				colomn = row.split("\t");
				System.out.println(colomn);
				if (colomn[0].equalsIgnoreCase("League")) {
					leag = colomn[1].toUpperCase();
					if (leag.equalsIgnoreCase("AL East")) {
						aim = alEast;
					} else if (leag.equalsIgnoreCase("AL Central")) {
						aim = alCentral;
					} else if (leag.equalsIgnoreCase("AL West")) {
						aim = alWest;
					} else if (leag.equalsIgnoreCase("NL East")) {
						aim = nlEast;
					} else if (leag.equalsIgnoreCase("NL Central")) {
						aim = nlCentral;
				    } else if (leag.equalsIgnoreCase("NL West")) {
						aim = nlWest;
				    } else {
					aim.add(row); 
					insertPctg(allLeague,row);
				    }
				}
			vars=true;
			gh.close();
			}
		} catch (Exception ex) {
			System.out.println("Couldn't read the file.");
			ex.printStackTrace();
			vars = false;
			
		} 
		System.out.println(alEast);
		System.out.println(alCentral);
		System.out.println(alWest);
		System.out.println(nlEast);
		System.out.println(nlCentral);
		System.out.println(nlWest);
		if (vars) {
			welcome();
			do {
				decide = Menu(sc);
				if (decide == 1) {
					printInfo(alEast);
				} else if (decide == 2) {
					printInfo(alCentral);
				} else if (decide == 3) {
					printInfo(alWest);
				} else if (decide == 4) {
					printInfo(nlEast);
				} else if (decide == 5) {
					printInfo(nlCentral);
				} else if (decide == 6) {
					printInfo(nlWest);
				} else if (decide == 7) {
					for (String team : allLeague) {
						System.out.println(team);
					}
				}
			} while (decide != 8);

		}

	}

}
