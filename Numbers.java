

/**
 * This is responsible for generating numbers for the puzzle as well as generating empty spaces
 * @author Isaac Byard
 *
 */
import java.util.Random;
public class Numbers 
{

	Random random = new Random(); //used in generating numbers
	int[] numbers = new int[]{
			8,0,0,0,0,0,0,0,0,
			0,9,3,0,5,0,7,0,8,
			0,6,7,0,0,1,0,0,9,
			
			0,0,6,0,9,0,2,0,1,
			0,7,8,2,0,3,5,4,0,
			1,0,5,0,4,0,8,0,0,
			
			7,0,0,1,0,0,3,2,0,
			5,0,9,0,2,0,1,6,0,
			0,0,0,0,0,0,0,0,4};

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
	
	
	public String getString(int index, int[] puzzleArray)
	{
		int num = puzzleArray[index];
		if(num!=0)
		return Integer.toString(num);
		else
		return " ";
	}
	/**
	 * getNumArray 
	 * 
	 * Returns the standard puzzle for this class
	 * 
	 * @return numbers[]
	 */
	public int[] getNumArray()
	{
		return numbers;
	}
	
	/** getGeneratedNumArray
	 * 
	 * A clean way to retrieve generated numbers from other classes
	 * 
	 * @return
	 */
	public int[] getGeneratedNumArray()
	{
		return generateNumbers();
	}
	
	/** generateNumbers
	 * 
	 * Zero out the array
	 * Generate numbers on a for loop n=1-9
	 * the first time through the numbers can be random
	 * While the puzzle array is not full then:
	 * generate numbers
	 * if the number works horizontally,vertically, and in the grid then place the number
	 * otherwise regenerate the number
	 * 
	 * If it takes too many tries to create the puzzle, then it is most likely stuck. 
	 * To get un-stuck, restart the puzzle and count how many tries it took to successfully generate. 
	 * 
	 * @return puzzleArray 
	 */
	public int[] generateNumbers() 
	{
		int randPos=0; //instantiate the random position
		int puzzleArray[] = new int[81]; //create the puzzle array
		for(int i=0; i<81; i++){puzzleArray[i]=0;}//zero out the array
		int tooManyTries = 0;
		int tries = 1;
		while (!puzzleIsFull(puzzleArray)) //as long as the puzzle is not full:
		{
			tooManyTries++;
			if(tooManyTries>10000)
			{
				tooManyTries = 0 ; //reset the tooLong
				tries++;
				for(int i=0; i<81; i++){puzzleArray[i]=0;} //zero out puzzle
			}
			for (int i=0; i<9; i++)
			{
			randPos = random.nextInt(81);//generate a random location 0-80
			if (itWorksInColumn(i+1, puzzleArray, randPos)&&itWorksInRow(i+1, puzzleArray, randPos)&&itWorksInGrid(i+1, puzzleArray, randPos)) //if it works vertically, horizontally, and in the grid:
				{
					puzzleArray[randPos]=i+1; //Add that number to the puzzle. Because i is 0-8, it must add 1 every time
				
				}
			}
		}
		System.out.println("It took " + tries + " try(ies) to get this puzzle;"); //tell the console how many tries it took to successfully create the puzzle
		return puzzleArray;
	}
	
	/** generateZeros
	 * Adds zeros to the completed puzzle array. Method can add as many as 81 zeros to the puzzle. However, 
	 * the puzzle should contain at least 17 non-zero numbers to be solved
	 * 
	 * @param fullNumberArray
	 * @param numberOfZeros
	 * @return
	 */
	public int[] generateZeros(int[] fullNumberArray, int numberOfZeros)
	{
		int randPos=0; 
		for (int i = 0; i<numberOfZeros; i++)
		{
			randPos = random.nextInt(81);//generate a random location 0-80
			fullNumberArray[randPos]=0;
		}
		
		return fullNumberArray;
	}
	
	/** itWorksInRow
	 * 
	 * if num is not equal to any numbers in horizontal line then it works
	 * to find the row, use the position in the 81 size array
	 * find row, multiply by 9 to get beginning column in row
	 * go through each column in row to see if it matches the num
	 * 
	 * @param num = the number in question
	 * @param array = the array
	 * @param pos = the position
	 * @return
	 */
	private boolean itWorksInRow(int num, int[] array, int pos)
	{
		int row = (pos/9); //determine which row the number is on
		int startingColumn = row*9;
		int endingColumn = startingColumn+9;
		for (int i=startingColumn; i<endingColumn; i++) {
			if (array[i]==num && array[i]!=0)
				return false;
		}
		return true;
	}
	
	/** itWorksInColumn
	 * 
	 * if num is not equal to any numbers in verticle line then it works
	 * to find the column
	 * 
	 * @param num = the number in question
	 * @param array = the array
	 * @param pos = the position
	 * @return
	 */
	private boolean itWorksInColumn(int num, int[] array, int pos)
	{
		int column = (pos%9); //determine which column the number is on
		int startingRow = column;
		int endingRow = startingRow+72;
		for (int i=startingRow; i<=endingRow; i=i+9) {
			if (array[i]==num && array[i]!=0)
				return false;
		}
		return true;
	}
	
	/** itWorksInGrid
	 * 
	 * Determine the grid location based on the position provided. 
	 * Uses getGrid() to identify which numbers are also in the same grid. 
	 * If there are no numbers matching num, it will return true
	 * 
	 * @param num
	 * @param array
	 * @param pos
	 * @return
	 */
	private boolean itWorksInGrid(int num, int[] array, int pos)
	{
		int column = (pos%9); 
		int row = (pos/9); 
		int[] gridArray = new int[9];
		int gridLoc = row-(row%3)+(column/3);
		gridArray = getGrid(gridLoc, array);
		
		for (int i=0; i<9; i++) {
			if (gridArray[i]==num && gridArray[i]!=0)
				return false;
		}
		return true;
	}
	
	/** puzzleIsFull()
	 * 
	 * Checks the puzzle by running though the array looking for zeros
	 * 
	 * @param puzzleArray
	 * @return boolean
	 */
	private boolean puzzleIsFull(int[] puzzleArray) {
		for (int i=0;i<=80;i++)
		{
			if (puzzleArray[i]==0) 
			{
				return false;
			}
		}
		return true;
	}
	
	/** getGrid
	 * Borrowed from the puzzle class, this method helps isolate numbers used in the same grid
	 * it then compiles into one, 9 integer array.
	 * @param grid
	 * @param array
	 * @return
	 */
	int[] getGrid(int grid, int[] array)
	{
		int [] gridArray = new int[9];
		int numCount = 9*(grid-(grid%3))+3*(grid%3);
		for (int i = 0; i<9; i++)
		{
		gridArray[i] = array[numCount];
		numCount++;
		if (i==2)
			numCount = 9*(grid-(grid%3))+3*(grid%3) + 9;
		else if (i==5)
			numCount = 9*(grid-(grid%3))+3*(grid%3) + 18;
		}
		return gridArray;
		
	}
	
}


