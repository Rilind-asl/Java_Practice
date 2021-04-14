import java.util.Scanner;

public class homeworkFiveB {

	/**
	 * Problem 7.8 Average an array
	 * Write 2 overloaded methods that return the average of an array
	 */
	public static void main(String[] args) 
	{
		// Scanner and double array list
		Scanner input = new Scanner(System.in);
		double[] list2 = new double[10];
		
		// asking for double values
		System.out.print("Enter 10 double values: ");
		
		//starting from index 0
		int i = 0;
		
		//while the array has space add another double into the next index
		while (i < list2.length) 
		{
			list2[i] = input.nextDouble();
			i++;
		}
		
		// printing out the average value that was taken from one of the methods.
		System.out.println("The average value is " + average(list2));

	}
	
	// average in int format
	public static int average(int[] array) 
	{
		int average1 = 0;
		
		// go through the array adding on each number starting from end of the array
		for(int i = array.length; i > 0; i--)
		{
			average1 += array[i-1];
		}
		
		//returning the array divided by the length to get average
		return average1/array.length;
	}
	
	// average in double format
	public static double average(double[] array) 
	{
		double average2 = 0;
		
		// go through the array adding on each number starting from end of the array
		for(int i = array.length; i > 0; i--)
		{
			average2 += array[i-1];
		}
		
		//returning the array divided by the length to get average
		return average2/array.length;
	}

}
