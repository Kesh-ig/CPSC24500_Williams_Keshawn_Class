import java.util.Scanner;
import java.util.Random;
/**
 * 
 * @author Keshawn
 *
 */
public class GameZone {
	public static void greetingsPlayer() { /** welcoming for the player  */
		System.out.println("*********************************"); 
		System.out.println("*   Welcome to the Game Zone    *");
		System.out.println("*********************************");
		
	}
	
	public static String paper = "paper"; /** initializing the variables */
	public static String scissors = "scissors";
	public static String rock = "rock";
	public static String exit = "exit";
	
	public static String compMove() { /** the computer choosing randomly between rock, paper, and scissors */
		String comp;
		Random random = new Random();
        int input = random.nextInt(3)+1;
        if (input == 1)
            comp = paper;
        else if(input == 2)
            comp = scissors;
        else
            comp = rock;
        return comp;
	}
	
	public static void RPS() { /** The game of Rock Paper Scissors */
		System.out.println("Welcome to Rock, Paper, Scissors!");
		String yMove= compMove();
		String cMove= compMove(); 
		System.out.println ("You played " + yMove + " and your opponent played " + cMove);
		if (yMove.equals(cMove)) {
            System.out.println("Game is Tie !!");         
		} else if (yMove.equals(GameZone.rock) && cMove.equals(GameZone.paper)) {
			//System.out.println ("You played " + yMove + " and your opponent played " + cMove);
			System.out.println("You lost!");   
		} else if (yMove.equals(GameZone.rock) && cMove.equals(GameZone.scissors)) {
			//System.out.println ("You played " + yMove + " and your opponent played " + cMove);
			System.out.println ("You win!");
		} else if (yMove.equals(GameZone.paper) && cMove.equals(GameZone.scissors)) {
			//System.out.println ("You played " + yMove + " and your opponent played " + cMove);
			System.out.println("You lost!");   
		} else if (yMove.equals(GameZone.paper) && cMove.equals(GameZone.rock)) {
			//System.out.println ("You played " + yMove + " and your opponent played " + cMove);
			System.out.println ("You win!");
		} else if (yMove.equals(GameZone.scissors) && cMove.equals(GameZone.rock)) {
			//System.out.println ("You played " + yMove + " and your opponent played " + cMove);
			System.out.println("You lost!");
		} else {
			System.out.println ("You win!");
		}
	}
	
	public static int compTotal () { /** The random generation of the computer's drawing */
		int max = 20;
		int min = 13;
		int compTot = (int)(Math.random() * (max - min + 1) + min);
	    return compTot;
	}
	
	public static int playTotal() { /** The player making the drawing  */
		Scanner sc = new Scanner (System.in); 
		int newTotal=0; 
		int choice;
		int nmax = 11;
		int nmin =1;
		do {
			//intially draw card
			int newDraw = (int) (Math.random()*(nmax - nmin + 1) + nmin);
			newTotal = newTotal + newDraw ;
			//print out what total is for user
			System.out.println("Your total is "+ newTotal);
			//check to see if user has lost or won with 21 or greater than 21
			if (newTotal==21) {
					choice =2;
			} else if (newTotal > 21) {
					choice =2;
			} else {
				System.out.print("Would you like to draw card? ( 1- yes, 2 - no)");
				choice = sc.nextInt();	
				while (choice != 1 && choice !=2) {
					//ask if want to draw again
					System.out.print("Would you like to draw card? ( 1- yes, 2 - no)");
					choice = sc.nextInt();
				} 		
			}

		} while (choice == 1);
		
		return newTotal;
	} 
	
	public static void twenOne () { /** The conditions and game being played out for Twenty One */
		System.out.println("Welcome to the game Twenty-One!! ");
		int pPlay = playTotal();
		int cPlay = compTotal();
		System.out.println("The dealer has "+ cPlay);
		if (pPlay==cPlay) {
			System.out.println("Its a tie"); 
		} else if (pPlay==21) {
			System.out.println ("You win!!");
		} else if (pPlay> 21) {
			System.out.println ("You lose!!");
		} else if (pPlay< cPlay) {
			System.out.println ("You lose!!");
		} else {
			System.out.println ("You win!!");
		}
	}

	public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	greetingsPlayer(); 
	int decision;
	do { /** The program playing out with the option menu and such */
		System.out.println ("What game would you like to play? ");
		System.out.println ("1. Rock, Paper, Scissor");
		System.out.println ("2. Twenty-One");
		System.out.println ("3. Neither - Im done!");
		System.out.print("Please eneter the number of your choice: ");
		decision = sc.nextInt();
		if (decision==1) {
			RPS();
		} else if (decision==2) {
			twenOne();
		} else  {
			while (decision > 3 || decision <=0) {
			System.out.println ("Not a valid option");
			//ask again here
			}	
		} 
		
	} while (decision !=3);
	System.out.println("Thank You for Playing!");

	}

}
