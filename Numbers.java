

/**
 * These numbers will have to go in sequence from 1 - 9
 * @author igbaf_000
 *
 */
public class Numbers 
{
	int[] numbers = new int[]{7,0,0,2,3,8,0,4,0,0,0,0,5,0,0,0,0,0,0,2,5,0,0,0,9,0,0,0,6,0,0,4,0,0,0,9,0,3,0,0,8,0,0,7,0,9,0,0,0,2,0,0,5,0,0,0,3,0,0,0,1,9,0,0,0,0,0,0,9,0,0,0,0,1,0,8,6,4,0,0,5}; //array starts at index 1
	int N = 9;
	public Numbers (int[] newArray)
	{
		numbers = newArray;
	}
	
	public Numbers ()
	{
		
		

		


		
	}
	
	public int getNum(int index)
	{
		
		return numbers[index];
	}
	public String getString(int index)
	{
		int num = numbers[index];
		if(num!=0)
		return Integer.toString(num);
		else
		return " ";
	}
	public int[] getNumArray()
	{
		return numbers;
	}
/*
	private int[] newPuzzle()
	{
		//0-8 have the numbers 1-9
	}*/
}
