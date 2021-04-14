import java.util.Scanner;

public class homeworkTwo 
{
	public static void main(String[] args)
	{
		//additionQuiz();
		//randomMonth();
		//lottery();
		//costOfShipping();
		pickACard();
	}
	/**
	 * Problem 3-24
	 */
	private static void pickACard() 
	{
		//randomly picking between 13 different types of cards
		int rank = (int) (Math.random()*13);
		
		//randomly picking a suit
		int suit = (int) (Math.random()*4);
		
		//switch statement to go through and pick a card rank
		switch(rank)
		{
		case 0: System.out.print("The card you picked is the King of ");
		break;
		case 1: System.out.print("The card you picked is the Queen of ");
		break;
		case 2: System.out.print("The card you picked is the Jack of ");
		break;
		case 3: System.out.print("The card you picked is the Ace of ");
		break;
		case 4: System.out.print("The card you picked is the 2 of ");
		break;
		case 5: System.out.print("The card you picked is the 3 of ");
		break;
		case 6: System.out.print("The card you picked is the 4 of ");
		break;
		case 7: System.out.print("The card you picked is the 5 of ");
		break;
		case 8: System.out.print("The card you picked is the 6 of ");
		break;
		case 9: System.out.print("The card you picked is the 7 of ");
		break;
		case 10: System.out.print("The card you picked is the 8 of ");
		break;
		case 11: System.out.print("The card you picked is the 9 of ");
		break;
		case 12: System.out.print("The card you picked is the 10 of ");
		break;
		}
		//switch to go through and pick a suit
		switch(suit)
		{
		case 0: System.out.print("Clubs");
		break;
		case 1: System.out.print("Spades");
		break;
		case 2: System.out.print("Hearts");
		break;
		case 3: System.out.print("Diamonds");
		break;
		}
		
	}
	/**
	 * Problem 3-18
	 */
	private static void costOfShipping() 
	{
		//Prompt user to enter weight of package.
		System.out.print("Please enter the weight of the package (in pounds): ");
		Scanner input = new Scanner(System.in);
		double weight = input.nextDouble();
		
		//checking the weight and determine the price.
		if(weight <= 0)
		{
			System.out.println("Invalid input.");
		}
		else if(weight > 20)
		{
			System.out.println("The package cannot be shipped.");
		}
		else if(weight > 0 && weight <= 1)
		{
			System.out.println("The package costs $3.50 to ship.");
		}
		else if(weight > 1 && weight <= 3)
		{
			System.out.println("The package costs $5.50 to ship.");
		}
		else if(weight > 3 && weight <= 10)
		{
			System.out.println("The package costs $8.50 to ship.");
		}
		else if(weight > 10 && weight <= 20)
		{
			System.out.println("The package costs $10.50 to ship.");
		}
	}

	/**
	 * Problem 3-15
	 */
	private static void lottery() 
	{
		//Generate a lottery number
		int lottery = (int) (Math.random()* 1000);
		
		// Prompt the user to enter a guess
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your lottery pick (three digits): ");
		
		int guess = input.nextInt();
		
		//Get digits from guess
		int guessDigit1 = guess / 100;
		int guessDigit2 = guess / 10; 
		int guessDigit3 = guess % 10;
		
		int guessLottery1 = lottery / 100;
		int guessLottery2 = lottery / 10; 
		int guessLottery3 = lottery % 10;
		
		System.out.println("The lottery number is " +lottery);
		
		// check the guess
		
		if(guess == lottery)
		{
			System.out.println("Exact match: you win $10,000");
		}
		else if((guessDigit1 == guessLottery2 || guessDigit1 == guessLottery3) 
				&& (guessDigit2 == guessLottery1 || guessDigit2 == guessLottery3)
				&& (guessDigit3 == guessLottery1 || guessDigit2 == guessLottery2))
				{
					System.out.println("Match all digits: you win $3,000");
				}
		else if (guessDigit1 == guessLottery1 ||
				guessDigit1 == guessLottery2 ||
				guessDigit1 == guessLottery3 ||
				guessDigit2 == guessLottery1 ||
				guessDigit2 == guessLottery2 ||
				guessDigit2 == guessLottery3 ||
				guessDigit3 == guessLottery1 ||
				guessDigit3 == guessLottery2 ||
				guessDigit3 == guessLottery3)
		{
			System.out.println("Match one digit: you win $1,000");
		}
		else
			System.out.print("Sorry, no match");
	}

	/**
	 * Problem 3-4
	 */
	private static void randomMonth() 
	{
		// randomly generating a number between 0-12 then adding one to make 0 exclusive and 12 inclusive.
		int month = (int) (Math.random() * 12);
		
		switch(month %12)
		{
		case 0: System.out.println("January");
		break;
		case 1: System.out.println("February");
		break;
		case 2: System.out.println("March");
		break;
		case 3: System.out.println("April");
		break;
		case 4: System.out.println("May");
		break;
		case 5: System.out.println("June");
		break;
		case 6: System.out.println("July");
		break;
		case 7: System.out.println("August");
		break;
		case 8: System.out.println("September");
		break;
		case 9: System.out.println("October");
		break;
		case 10: System.out.println("November");
		break;
		case 11: System.out.println("December");
		
		}
	}

	/**
	 * Problem 3-2
	 */
	private static void additionQuiz() 
	{
		//Created three numbers that are single ints
		int number1 = (int) (System.currentTimeMillis() % 10);
		int number2 = (int) (System.currentTimeMillis() / 10 % 10);
		int number3 = (int) (System.currentTimeMillis() / 100 % 10);
		
		//scanner and asking what the sum is
		Scanner input = new Scanner(System.in);

		System.out.print("What is " + number1 + " + " + number2 + " + " + number3 + " ? ");
		
		//Reading the input of the sum by user
		int answer = input.nextInt();
		
		//printing statement telling user if addition was true or false
		System.out.println(number1 + " + " + number2 + " + " + number3 + " = " + answer + " is " + (number1+number2+number3 == answer));

	}
	

}
