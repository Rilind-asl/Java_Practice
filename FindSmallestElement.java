
public class homeworkFiveC 
{
	/**
	 * Exercise 7.9: Find the Smallest element
	 * 
	 */
	public static void main(String[] args) 
	{
		// creating a new array and in line scanner
		double[] numbers = new double[10];

		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("Enter ten double numbers: ");

		// loop to go through and grab all the doubles and place them into the array
		for (int i = 0; i < numbers.length; i++) 
		numbers[i] = input.nextDouble();

		// printing out the minimal value given a method that finds it.
		System.out.println("The minimal value is " + min(numbers));
	}
		
	// this method will take an array and find the minimum double in that array.
	public static double min(double[] list) 
	{
		// declaring a minimum value that will be returned
		double minimum = list[list.length-1];
		
		// goest through the array from the end 
		for(int i = list.length; i > 0; i--)
		{
			// if the index is smaller than the current minimum it swaps the minimum with this index
			if(i != 0 && list[i-1] < minimum)
			{
				minimum = list[i-1];
			}
		}
		
		// returns the minimum
		return minimum;

	}
	
}
