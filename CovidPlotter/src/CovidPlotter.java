import java.util.LinkedHashMap;
import java.util.Scanner;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;
import java.awt.Container;
import java.io.File;
import java.awt.BorderLayout;
/**
 * 
 * @author Keshawn
 *
 */


public class CovidPlotter {
	public static void welcome () {
		System.out.println("**************************************************");
		System.out.println("*      INTERATIONAL COVID-19 MORTALITY RATES     *");
		System.out.println("**************************************************");
	}
	public static LinkedHashMap<String, double[]> coData(Scanner fsc) {
		LinkedHashMap<String, double[]> output= new LinkedHashMap<String, double[]>();
		fsc.hasNextLine();
		String location;
		String row; 									/** This function scans the data */
		String[] colomn;
		double[] death; 
		while (fsc.hasNextLine()) {
			row = fsc.nextLine();
			colomn = row.split("\t");
			location = colomn[0];
			death = new double [colomn.length-1];
			for (int t = 1; t < colomn.length; t++) {
				death[t-1] = Double.parseDouble(colomn[t]);
			}
			output.put(location, death);
		}
		return output;
	}
	
	public static double[] days(int amount) {
		double[] output = new double[amount];     /** This function is used for the cumulative graph */
		for(int t=0; t < amount; t++ ) {
			output[t] = t;
		}
		return output;
	}
	public static double[] dailyDays(double[] amount) {
		double[] output = new double [amount.length];
		double differ=0;
		for (int p=0; p<amount.length-1; p++) {           /** This function is used for the daily death graph */
			if(amount[p]>amount[p+1]) {
			differ = amount[p]- amount[p+1];
			} else {
				differ = amount[p+1] - amount[p];
			}
			if (differ == 0) {
				output[p] = amount[p]; 
			} else {
				output[p] = differ; 
			}
			
			}
			int hold = amount.length-1;
			differ = amount[hold] - amount[hold-1];
			if (differ<0) {
				differ = Math.abs(differ);
		}
		output[hold]= differ;
		return output;
	}
	public static void plot(Plot2DPanel graph) {
		JFrame frm = new JFrame(); 
		frm.setBounds(100,100,500,500);                         /** This function is for the set up of the cumulative deaths graph  */
		frm.setTitle("Cumulative Deaths");
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container cont = frm.getContentPane();
		cont.setLayout(new BorderLayout());
		graph.addLegend("SOUTH");
		graph.setAxisLabels("Day","Deaths");
		cont.add(graph,BorderLayout.CENTER);
		frm.setVisible(true);
	}
	public static void plot2(Plot2DPanel graph) {
		JFrame frm = new JFrame(); 
		frm.setBounds(100,100,500,500);
		frm.setTitle("Daily Deaths");
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    /** This function is for the set up of the daily deaths graph */
		Container cont = frm.getContentPane();
		cont.setLayout(new BorderLayout());
		graph.addLegend("SOUTH");
		graph.setAxisLabels("Day","Deaths");
		cont.add(graph,BorderLayout.CENTER);
		frm.setVisible(true);
	}
	
	
	public static void main(String[] args) {
	LinkedHashMap<String, double[]> countries;
	String input, input2;
	String[] country;
	Scanner sc = new Scanner (System.in);
	welcome();
	System.out.println("Enter the name of the file: ");
	String file = sc.nextLine();
	double [] countryDeaths;
	try {
		Scanner fsc = new Scanner (new File(file));      /** checking to see if the file was able to be read */
		countries = coData(fsc); 
	} catch (Exception ex) {
		countries = null;
	}
	if (countries == null) {
		System.out.println("The file counldn't be read try again.");
	} else {
		do {
			System.out.print("Enter the countries to plot, separated by commas (or quit to end): ");
			input = sc.nextLine(); 
			if (!input.equalsIgnoreCase("exit")) {      /** Running of the program */
				Plot2DPanel graph = new Plot2DPanel();
				country = input.split(",");
				for (String place : country) {
					place = place.trim();
					if (!countries.containsKey(place)) {
						System.out.printf("%s is not within the data collection. \n", place);
					} else {
						System.out.print("[D]aily or [C]umulative? ");
						input2 = sc.nextLine();
						if (input2.equalsIgnoreCase("C")) {
							countryDeaths = countries.get(place);
							graph.addLinePlot(place, days(countryDeaths.length), countryDeaths);
							plot(graph);
						} else if (input2.equalsIgnoreCase("D")) {
							countryDeaths = countries.get(place);
							graph.addLinePlot(place, days(countryDeaths.length), dailyDays(countryDeaths));
							plot2(graph);
						} else {
							System.out.println("Not one of the options please try again"); 
						}
						
					}
				}
			}
		} while (!input.equalsIgnoreCase("quit"));    /** Exiting of the program */
		System.out.println("Thank You!"); 
	}
		

	}

}
