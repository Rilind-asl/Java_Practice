	import java.util.Scanner;
	
	public class homeworkThree {
	
	/**
	* MAIN METHOD
	*
	*/
	public static void main(String[] args)
	{
		//UNCOMMENT THE METHOD YOU WANT TO RUN
			
		//countNumbers();
		computeFutureTuition();
		//commonDivisor();
		//findThePrimeFactors();
		//lottery();
	}
	/**
	* Problem 5.1
	*/
	public static void countNumbers()
	{
		//scanner and starting message.
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer, the input ends if it is 0: ");
		
		//necessary variables
		int number = input.nextInt();
		int positiveNumber = 0;
		int negativeNumber = 0;
		int total = 0;
		int count = 1;
		float average;
		
		//if the only number e1ntered is 0, output this.
		if(number == 0)
		{
		System.out.println("No numbers are entered except 0");
		}
		//checking the numbers and doing calculations
		if(number != 0)
		{
			while(number != 0)
			{
				if(number > 0)
				{
					positiveNumber++;
					total += number;
					number = input.nextInt();
					count++;
				}
				else if(number < 0)
				{
					negativeNumber++;
					total += number;
					number = input.nextInt();
					count++;
				}
			
			}
			//final calculation and output
			average = (float)total/count;
			System.out.println("The number of positives is "+positiveNumber+ "\nThe number of negative is " + negativeNumber + "\nThe total is " + total + "\nThe average is " + average);
		}
	}
	
	/**
	* Problem 5.7
	*/
	public static void computeFutureTuition()
	{
		//Variables declared
		double tuition = 10000;
		double interest = 1.05;
		int years = 10;
		double total = 0;
		int cost = 4;
		
		//for loop for the tuition increasing by 5% for 10 years
		for(int i = 0; i < years; i++)
		{
		tuition = tuition *interest;
		}
		
		//printing out the cost of tuition after 10 years
		System.out.println("The tuition after 10 years will cost: $" + (double)((int)(tuition*100))/100);
		
		//for loop for the cost of tuition after four years of school after taking into consideration 10 years of tuition change increase.
		for (int k = 0; k < cost; k++)
		{
		total += tuition;
		tuition = tuition*interest;
	}
	
	//print out the cost of tuition after four years of school.
	System.out.println("The total cost of four years of tuition after the tenth year will cost: $" +(double)((int)(total*100))/100 );
	}
	
	/**
	* Problem 5.14
	*/
	public static void commonDivisor()
	{
	//scanner for input integers
	Scanner input = new Scanner(System.in);
	System.out.print("Enter first positive integer: ");
	int inputOne = input.nextInt();
	System.out.print("Enter second positive integer: ");
	int inputTwo = input.nextInt();
	//variables
	int gcd = 1;
	int testNum = 0;
	//if statement to grab the first test number as the lowest of the two integers
	if(inputOne == 0 || inputTwo == 0)
	{
		System.out.println("You've entered in Zero as an integer which doesn't have a divisor.");
		System.exit(0);
	}
	if(inputOne > inputTwo)
	{
	testNum = inputTwo;
	}
	else
	testNum = inputOne;
	
	//if statement to check if the lowest of the two integers is the greatest common divisor
	if(inputOne%testNum == 0 && inputTwo%testNum == 0)
	{
	gcd = testNum;
	}
	//while statement to check if
	while(testNum <= inputOne && testNum <= inputTwo && testNum != 0)
	{
	//print statement used to check if numbers mod to == 0
	//System.out.println(inputOne + " % " + testNum+" : " + inputOne%testNum + " and " +inputTwo + " % " + testNum+" : " + inputTwo%testNum);
	//if statement to check new divisor testNum - 1
	if(inputOne%testNum == 0 && inputTwo%testNum == 0 && testNum>gcd)
	{
	gcd = testNum;
	}
	testNum--;
	}
	//printing out the greatest common divisor.
	System.out.println("The greatest common divisor of " + inputOne + " and " + inputTwo + " is " + gcd);
	
	}
	
	/**
	* Problem 5.16
	*/
	public static void findThePrimeFactors()
	{
	Scanner input = new Scanner(System.in);

	int number = input.nextInt();
	int factor = 2;
	while(factor <= number)
	{
		while(number % factor == 0)
		{
		System.out.print(factor + " ");
		number = number / factor;
		}
	factor++;
		}
	}
	
	/**
	* Problem 5.32
	*/
	public static void lottery()
	{
	// Generate a lottery number
	int lotteryNum1 = (int)(Math.random()*10);
	int lotteryNum2 = (int)(Math.random()*10);
	while(lotteryNum1 == lotteryNum2)
	{
	lotteryNum2 = (int)(Math.random()*10);
	}
	//Prompt user to enter a guess
	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter your lottery pick (two digits): ");
	
	//grabbing the guess integers
	int guess = input.nextInt();
	
	//get the digits from the guess
	int guessDigit1 = guess/10;
	int guessDigit2 = guess%10;
	
	//get digits from lottery number
	int lotteryDigit1 = lotteryNum1;
	int lotteryDigit2 = lotteryNum2;
	
	//printing out the lottery number
	System.out.println("The lottery number is " + lotteryNum1+""+lotteryNum2);
	
	//checking the guesses and printing out win or loss message
	if(guessDigit1 == lotteryDigit1 && guessDigit2 == lotteryDigit2)
	{
	System.out.println("Exact match: you win $10,000");
	}
	else if(lotteryDigit1 == guessDigit2 && lotteryDigit2 == guessDigit1 )
	{
	System.out.println("Match all digits: you win $3,000");
	}
	else if(lotteryDigit1 == guessDigit1 ||
	lotteryDigit1 == guessDigit2 ||
	lotteryDigit2 == guessDigit1 ||
	lotteryDigit2 == guessDigit2)
	{
	System.out.println("Match one digit: you win $1,000");
	}
	else
	System.out.println("Sorry, no match");
	
	}
	}