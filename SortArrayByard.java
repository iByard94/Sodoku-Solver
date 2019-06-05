
/**
 * 
 * @author Isaac Byard
 * 
 * This algorithms efficiency is O(n^2) which is not very efficient.
 * Because of the nested for loops required to solve, this is not a
 * good choice of sorting algorithms.
 * 
 */

public class SortArrayByard 
{
	
	/**
	 * This method returns the largest integer (the number with the highest value) in a given array
	 * Efficiency: O(n) because the input data is directly proportioned to the time to solve. 
	 * @param array int[] 
	 * @return largest int the largest number in the array
	 */
	private int findLargestNumber(int[] array)
	{
		int largest = 1; //the range is [1, n]; therefore cannot be lower than 1
		for (int i =0; i<array.length;i++) //iterates through array
		{
			if (array[i]>largest) //if the array at position i is greater than largest
				largest = array[i]; //then largest equals that greater int
		}
		return largest; //returns the largest int in the array
	}
	
	/**
	 * This method counts the amount of times a number appears in an array
	 * Efficiency: O(n^2) because of the nested for loop
	 * @param unsorted int[] an unsorted array of integers
	 * @return count int[] the array that contains the number of appearances of a number
	 */
	private int[] arrayCount(int[] unsorted)
	{
		int len = unsorted.length; //get length of unsorted array
		int largest = findLargestNumber(unsorted); //finds the highest int in the array
		int[] count = new int[largest]; //create count array

		int numberOfI = 0; //initializes the counting variable for number of appearances of i
		for (int i = 1; i<=largest; i++)// 1 through the largest in in the array
		{ //iterates through the arrays range of numbers
			for (int pos = 0; pos<len; pos++)
			{ //iterates through the entire array starting at position 0
				if (unsorted[pos]==i) //if the array contains i at the position, the counting variable increases
					numberOfI++;
			}
			count[i-1] = numberOfI; //records the amount of times i is found in array
			numberOfI = 0; //resets the counting variable for next iteration
		}
		return count; //returns the array with the count of the input numbers
	}
	/**
	 * This method sorts the array of integers.
	 * Efficiency: O(n^2) because of the nested for loop
	 * @param unsorted int[] accepts an unsorted array of integers
	 * @return sorted int[] the final sorted array
	 */
	public int[] sort(int[] unsorted)
	{
		int len = unsorted.length;
		int[] sorted = new int[len]; //new empty array that will contain sorted list of integers.
		int[] count = arrayCount(unsorted);
		int pos = 0; //the position variable for sorted array
		for (int i = 0; i<count.length; i++) //iterates through int[] sorted
		{
			if (count[i]>0) //prevents array out of bounds exception by checking to see if count[i] > 0
				for (int n = 0; n<count[i];n++) //itterate as many times as count has for that number
				{
					sorted[pos] = i+1; //sorted position pos equals i+1 as many times as count iterates
					pos++; //the position is updated every time a number is added to array sorted
				}
		}
		return sorted; //returns the sorted array
	}
	
}
