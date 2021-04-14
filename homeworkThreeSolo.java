import java.util.Scanner;

public class homeworkThreeSolo {

	/**
	 * Main Method
	 * 
	 */
	public static void main(String[] args) 
	{
		//subtractionQuizLoop();
		//divisibleBy();
	}
	
	/**
	 * Problem 5-2
	 */
	public static void subtractionQuizLoop()
	{
		final int NUMBER_OF_QUESTIONS = 10; //number of Questions
		int correctCount = 0; //count of correc answers
		int count = 0; //count of number of questions
		long startTime = System.currentTimeMillis();
		String output = " "; //ouput initial empty
		
		Scanner input = new Scanner(System.in);
		
		while(count < NUMBER_OF_QUESTIONS)
		{
			//generating 2 numbers between 1-15 inclusive
			int number1 = (int)(Math.random() * 15)+1;
			int number2 = (int)(Math.random() * 15)+1;
			
			//if number1 < number2 swap them
			if(number1 < number2)
			{
				int temp = number1;
				number1 = number2;
				number2 = temp;
			}
			//prompt the user a question
			System.out.println("What is " + number1+ " - " + number2 + "? ");
			
			int answer = input.nextInt();
			
			//checking the answer and displaying result
			if(number1 - number2 == answer)
			{
				System.out.println("You are correct!");
				correctCount++;
			}
			else
				System.out.println("Your answer is wrong. \n" + number1+ " - " + number2 + " should be "+ (number1-number2));
			//increase count
			count++;
			
			output += "\n" + number1 + " - "+ number2 + " = "+answer+((number1-number2 == answer)? " correct": "wrong");
		}
		long endTime = System.currentTimeMillis();
		long testTime = endTime - startTime;
		
		System.out.println("Correct count is " + correctCount+ "\nTest time is "+testTime/1000 + " seconds\n "+output);
		
		
	}

	/**
	 * Problem 5-10
	 */
	public static void divisibleBy()
	{
		//variables
		int start = 100;
		int end = 1000;
		int count = 0;
		
		//while loop to check when to end
		while(start<end)
		{
			//if statement to see if number is divisible by both 5 and 6 with no remainder
			if(start%5 == 0 && start%6 == 0)
			{
				System.out.print(start+" ");
				count++; //count to only display 10 numbers per line
				if(count == 10)
				{
					System.out.println("");
					count = 0; //resetting count
				}
			}
			start++; //moving through the numbers between 100-1000
		}
	}
}
