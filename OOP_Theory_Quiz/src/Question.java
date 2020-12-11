
public class Question {
	private String text;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String answer;

	/**
	 * This function gets the text variables 
	 * @return text variables
	 */
	public String getText() {
		return text;
	}

	
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * This function gets the first choice
	 * @return the first choice 
	 */
	public String getChoice1() {
		return choice1;
	}


	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	/**
	 * This function gets the second choice
	 * @return the second choice 
	 */
	public String getChoice2() {
		return choice2;
	}


	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	/**
	 * This function gets the third choice
	 * @return the third choice 
	 */
	public String getChoice3() {
		return choice3;
	}


	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}

	/**
	 * This function gets the fourth choice
	 * @return the fourth choice 
	 */
	public String getChoice4() {
		return choice4;
	}


	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}

	/**
	 * This function gets the correct answer
	 * @return the correct answer 
	 */
	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * The function that initializes all the variables for use 
	 */
	public Question() {
		text = "none";
		choice1 = "none";
		choice2 = "none";
		choice3 = "none";
		choice4 = "none";
		answer = "still nothing";
	}
	/**
	 * This function takes in the different variables and puts them into a string format
	 * @param text The questions
	 * @param choice1 the first choice
	 * @param choice2 the second choice
	 * @param choice3 the third choice
	 * @param choice4 the final choice
	 * @param answer the correct answer 
	 */
	public Question (String text, String choice1, String choice2, String choice3, String choice4, String answer) {
		setText(text);
		setChoice1(choice1);
		setChoice2(choice2);
		setChoice3(choice3);
		setChoice4(choice4);
		setAnswer(answer);
	}


	@Override
	public String toString() {
		return String.format("%s \n%s \n%s \n%s \n%s \n%s", text, choice1, choice2, choice3, choice4, answer);
	}
	
}

