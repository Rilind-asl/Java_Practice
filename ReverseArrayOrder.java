import java.util.Scanner;

public class homeworkFiveA 
{
	/**
	 * Homework 5A
	 * Exercise06_02.java: Enter 10 integers and
	 * display the numbers in reverse order
	 */

	public static void main (String[] args) 
	{
		// creating an array and scanner variable
		int[] num = new int[10];
		
		Scanner input = new Scanner(System.in);
		
		// this grabs and stores all the numbers into the array
		for (int i = 0; i < 10; i++) 
		{
		// Read a number
		System.out.print("Read a number: ");
	
		num[i] = input.nextInt();
		}

		// Display the array reversely
		System.out.print("The reversal of the input is ");
	
		 
		// reverses the input of number sequence given an array length
		for(int i = num.length; i > 0; i--)
		{
			System.out.print(num[i-1] + " ");
		}	
	}
	
}
