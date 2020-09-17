

/**
 * This program is used to determine and print how many packages of laminate boards you will need to buy and what that will cost
 * @author Keshawn
 *
 */
public class Flooring {
	public static double areaRec (double a,double b) { //used to find the area of a rectangle 
		double area = a * b;
		return area;
	}
	public static double areaTri (double c, double d) { // used to find the area of a triangle
		double area = .5 * c * d; 
		return area;
	}
	public static double division (double e, double f) { // used to divide to parts 
		double divi = e / f;
		return divi; 
	}
	public static double addition (double j, double k, double l) { // used to add to parts 
		double add = j + k + l;
		return add; 
	}
	public static void main(String[] args) {
	double x, y, z, g, h, i;
	x = 20;
	y= 13;
	double areaBott = areaRec (x, y); // area for the rectangle at the bottom 
	z = 12; //25-13
	g = 10;
	double areaTop = areaRec (z,g); // area for the rectangle at the top to the left of the triangle 
	h = 10; //20-10
	i = 12; //25-13 
	double areaRight = areaTri (h, i); //area of the triangle 
	double totalArea = addition (areaBott, areaTop, areaRight); //the total area of the room
	double m, n;
	m= 2.5; // 30/12
	n= .5; // 6/12
	double packArea = areaRec(m, n); // total are of the board 
	double dividend = division (totalArea,packArea); // total number of boards it would take 
	dividend = Math.ceil(dividend); // that total above rounded to the next whole number 
	double totalFloor = dividend * 1.2; // the accounting for the extra wasted material
	double needPack = totalFloor/6; // the total number of packages needed 
	needPack = Math.ceil(needPack); // the rounding of that number to a whole number 
	double totalCost = 24.99 * needPack; // the total cost of the project 
	System.out.printf("The number of packages needed is %.2f and the cost will be %.2f.", needPack, totalCost);
	

	}

}
