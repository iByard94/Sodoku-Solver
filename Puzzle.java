/**
 * arranges the numbers in the format of a sodoku puzzle.
 * @author Isaac Byard
 *
 */
public class Puzzle 
{
	Numbers numClass = new  Numbers();
	public Puzzle()
	{}

	
	public int[] getVerticle(int column, int[] array)
	{
		int [] columnArray = new int[9];
		int numCount = column;
		for (int i = 0; i<9; i++)
		{
			columnArray[i] = array[numCount];
			numCount += 9;
		}
		
		return columnArray;	
	}
	
	public int[] getHorizontal(int row, int[] array)
	{
		int [] rowArray = new int[9];
		int numCount = row*9;
		for (int i = 0; i<9; i++)
		{
			rowArray[i] = array[numCount];
			numCount++;
		}
		
		return rowArray;
	}
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
