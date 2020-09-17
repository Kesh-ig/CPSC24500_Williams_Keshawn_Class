import java.util.Random;
import java.lang.Math.*;

/**
 * This Program generates a random radius and computes the area and circumference. 
 * @author Keshawn
 *
 */

public class CircleCalc {
	
	public static double computeCir (double  a) { //Computes the Circumference given the radius
		double circumference = 2 * a * Math.PI; 
		return circumference;
	}
	public static double computeArea (double b) { //Computes the Area given the radius
		double area = Math.PI * b * b;
		return area;
	}
	public static void main(String[] args) {
		Random rnd = new Random();  
		double radius;
		radius= rnd.nextInt(25); //random variable introduced
		double circ = computeCir (radius);
		double area = computeArea (radius);
		System.out.println("The radius is " + radius + ".");
		System.out.println("The circumference is " + circ + ".");
		System.out.println("The area is " + area + ".");
		
	}

}
