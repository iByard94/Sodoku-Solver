/**
 * This class is actually responsible for the solving of the puzzle.
 *
 * @author Isaac Byard
 *
 */
public class Solver 
{
	Puzzle puzzle = new Puzzle();
	SortArrayByard sorter = new SortArrayByard();
	int[] numGrid  = new int[81];
	int[] emptyLocs = new int[81];
	int[] universalAnswers = new int[81];

	
	Solver(int[] answers)
	{
		numGrid = answers.clone();
		emptyLocs = findEmpty(numGrid);
	}
	
	/**
	 * Checks for zeros, when it encounters a zero
	 * @param answers
	 * @return
	 */
	public int[] checkPuzzle(int[] answers)
	{
		int [] poss = new int[9];
		for (int loc = 0;loc<81;loc++)
		{
			if (answers[loc]==0)
			{
				int row = loc/9;
				int column = loc%9;
				int grid = row-(row%3)+(column/3);
				if (checkHorizontal(row,answers)!=0)
					answers[loc]=checkHorizontal(row,answers);
				else if (checkVerticle(column,answers)!=0)
					answers[loc]=checkVerticle(column,answers);
				else if (checkGrid(grid,answers)!=0)
					answers[loc]=checkGrid(grid,answers);
				else 
				{
					poss = possible(row, column, grid, answers);
					if (countZeros(poss)==8)
						answers[loc]=poss[0];
				}
						
			}
		}
	return answers;
	}
	
	/**
	 * Inserts possible numbers starting at lowest in possible array (guessing), 
	 * if it runs into a dead end where there are no possible numbers,
	 * then it backtracks until it reaches the grid from which the problem stemmed.
	 * @return
	 */
	public boolean backtrack(int loc, int[] answers)
	{
		int[] poss = new int[9];
		int row = rowLoc(loc);
		int column = columnLoc(loc);
		int grid = gridLoc(row, column);
		poss = possible (row, column, grid, answers); //find the possibilities for this current square
		
		/*if (loc == emptyLocs.length-1) // go through all possible in for loop    //BASE CASE
		return true;
		else
		{*/
			for (int i = 0; i<9; i++)
			{
				answers[loc] = poss[i];
				if (backtrack(loc+1, answers))
				{
				universalAnswers = answers.clone(); 
				return true;
				}
			}
			
		//}
		return false;

		/*

		if (poss[0] != 0 && !isBacking) //if possibility exists and its not backtracking
		{
				answers[emptyLocs[loc]] = poss[0]; //set the empty square to equal the absolutely first possibility
				return backtrack(loc+1, answers, false); //advance the next location moving forward
		}
		else if (isBacking) //if it is backing
		{
			int missingIndex = locateNextLargest(answers[emptyLocs[loc]], poss); //find the possibility index of the number in the grid.
			if (poss[missingIndex]!=0) //if there is another possibility
			{
				answers[emptyLocs[loc]] = poss[missingIndex]; //set the empty square to equal the next possibility
				return backtrack(loc+1, answers, false); //move forwards
			}
			else //if there is not another possibility
			{
				answers[emptyLocs[loc]] = 0; //set the current location to 0 
				return backtrack(loc-1, answers, true); //move backwards
			}
		}
		
		else //if it is moving forward and there is no possibility
		{
			answers[emptyLocs[loc]] = 0; // set location to 0
			return backtrack(loc-1, answers, true); //move backwards
		}*/
		

		
	}
	/*
	public boolean backtrack(int loc, int[] answers)
	{
		/*
		 * go through all possible in for loop
		 * 
		 * 
		 

		int[] poss = new int[9];
		int row = rowLoc(loc);
		int column = columnLoc(loc);
		int grid = gridLoc(row, column);
		//find the possibilities for this current square
		poss = possible (row, column, grid, answers);
		
		if (loc  == 80)
			return true;
		
			if (!backtrack(loc + 1, numGrid)) //if the recursion is still good and the there are still posibilities
			{
				for (int i = 0; i<9; i++)
				{
					if (numGrid[loc]==0)
					{
						numGrid[loc] = poss[i];
						return backtrack(loc + 1, numGrid);
					}
					if(poss[0]==0)
						return false;
			}
						
			}
			
			
		
		return false;
	}*/
	//backtrack array with possiblilities.
	/**
	 * 
	 * It gets stuck when it is guessing the next possibility after baktracking
	 * 
	 * @param loc
	 * @param answers
	 * @param isBacking
	 * @return
	 */
	/*
	
	public int[] backtrack(int loc, int[] answers, boolean isBacking)
	{
		int[] poss = new int[9];
		int row = rowLoc(emptyLocs[loc]);
		int column = columnLoc(emptyLocs[loc]);
		int grid = gridLoc(row, column);
		
		if (loc == 80) // go through all possible in for loop    //BASE CASE
			return answers;

		poss = possible (row, column, grid, answers); //find the possibilities for this current square

		if (poss[0] != 0 && !isBacking) //if possibility exists and its not backtracking
		{
				answers[emptyLocs[loc]] = poss[0]; //set the empty square to equal the absolutely first possibility
				return backtrack(loc+1, answers, false); //advance the next location moving forward
		}
		else if (isBacking) //if it is backing
		{
			int missingIndex = locateNextLargest(answers[emptyLocs[loc]], poss); //find the possibility index of the number in the grid.
			if (poss[missingIndex]!=0) //if there is another possibility
			{
				answers[emptyLocs[loc]] = poss[missingIndex]; //set the empty square to equal the next possibility
				return backtrack(loc+1, answers, false); //move forwards
			}
			else //if there is not another possibility
			{
				answers[emptyLocs[loc]] = 0; //set the current location to 0 
				return backtrack(loc-1, answers, true); //move backwards
			}
		}
		
		else //if it is moving forward and there is no possibility
		{
			answers[emptyLocs[loc]] = 0; // set location to 0
			return backtrack(loc-1, answers, true); //move backwards
		}
		

		
	}
*/
//backing without possibilities
	/* DUMB
	public int[] backtrack(int loc, int[] answers, boolean isBacking)
	{

		
		if (loc == 80) // go through all possible in for loop    //BASE CASE
			return answers;

		

		if (!isBacking) //if its not backtracking
		{
				answers[emptyLocs[loc]] = 1; //set the empty square to equal the absolute first possibility (1)
				return backtrack(loc+1, answers, false); //advance the next location moving forward
		}
		else if (isBacking) //if it is backing
		{
			
				answers[emptyLocs[loc]] ++; //go to the next possibility
				return backtrack(loc+1, answers, false); //move forwards
	
		}
		else
		{
			answers[emptyLocs[loc]] = 0; // set location to 0
			return backtrack(loc-1, answers, true); //move backwards
		}
		

		
	}*/

	/**
	 * computes the location of the row based on the square's numeric value
	 * @param loc
	 * @return
	 */
	private int rowLoc(int loc)
	{
		return loc/9;
	}
	/**
	 * computes the location of the column based on the square's numeric value
	 * @param loc
	 * @return
	 */
	private int columnLoc(int loc)
	{
		return loc%9;
	}
	/**
	 * computes the location of the grid based on the row and the column
	 * @param row
	 * @param column
	 * @return
	 */
	private int gridLoc(int row, int column)
	{
		return row-(row%3)+(column/3);
	}
	public int checkHorizontal(int row, int[] nums)
	{
		int[] array = puzzle.getHorizontal(row, nums);
		if (countZeros(array)==1)
		{
			return findMissing(array);
		}
		return 0;
	}
	public int checkVerticle(int column, int[] nums)
	{
		int[] array = puzzle.getVerticle(column,nums);
		if (countZeros(array)==1)
		{
			return findMissing(array);
		}
		return 0;
	}
	public int checkGrid(int grid, int[] nums)
	{
		int[] array = puzzle.getGrid(grid,nums);
		if (countZeros(array)==1)
		{
			return findMissing(array);
		}
		return 0;
	}

	public int [] possible (int row, int column, int grid, int[] nums)
	{
		int[] hNums = puzzle.getHorizontal(row, nums);
		int[] vNums = puzzle.getVerticle(column, nums);
		int[] gNums = puzzle.getGrid(grid, nums);
		int[] hPoss = findMultiMissing(hNums);
		int[] vPoss = findMultiMissing(vNums);
		int[] gPoss = findMultiMissing(gNums);
		int[] poss = new int[9];
		int curr = 0;
		
		for (int i=0;i<9;i++)
		{
			if (hPoss[i]!=0 && numExists(hPoss[i], vPoss)&&numExists(hPoss[i], gPoss))//if hPoss's number exists in vPoss, then
					{
						poss[curr]=hPoss[i];
						curr++;
					}
		}
		
		
		return poss;
	}
	
	private boolean numExists(int num, int[] numArray)
	{
		for (int i=0; i<9;i++)
		{
			if (num==numArray[i])
				return true;
		}
		return false;
	}
	private int[] findMultiMissing(int[] array)
	{
		int[] sortedArray = sorter.sort(array);
		int[] possibilities = new int[9];
		int nxtSpace = 0;
		boolean isThere = false;
		for (int i=0;i<9;i++)
		{
			for (int ii=0;ii<9;ii++)
			{
				if (sortedArray[ii]==i+1)
					isThere= true;
			}
			if (!isThere)
			{
				possibilities[nxtSpace]=i+1;
				nxtSpace++;
			}
			isThere=false;
		}
		return possibilities;
	}
	private int findMissing(int[] array)
	{
		int[] tmpArray = sorter.sort(array);
		for (int i=0;i<9;i++)
		{
			if (tmpArray[i]!=i+1)
				return i+1;
		}
		return 0;
	}
	private int countZeros(int[] array)
	{
		int count = 0;
		for (int i=0;i<array.length;i++)
		{
			if (array[i]==0)
				count++;
		}
		return count;
	}
	private int locateZero(int[] array)
	{
		for (int i=0;i<9;i++)
		{
			if (array[i]==0)
				return i;
		}
		return 0;
	}
	

	private int locateNextLargest(int numToFind, int[] array)
	{
		for (int i=0;i<9;i++)
		{
			if (array[i]>numToFind)
				return i;
		}
		return 0;
	}
	
	private int[] findEmpty(int[] answers)
	{
		int[] tmpEmptyLocations = new int[81];
		int i = 0;
		for (int loc = 0; loc<81; loc++)
		{
			if (answers[loc] == 0)
			{
				tmpEmptyLocations[i] = loc;
				i++;
			}
		}
		int[] emptyLocations = new int[i];
		for (int count = 0; count < i; count++)
		{
			emptyLocations[count] = tmpEmptyLocations[count];
		}
		return emptyLocations;
	}
	
	public int[] getAnswers()
	{
		return universalAnswers;
	}
}
