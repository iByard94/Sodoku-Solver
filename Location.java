
/**
 * 
 * @author Isaac Byard
 * Location will create an array that can represent the pixles on a screen. 
 * Because it represents pixles on a screen, this class is used for graphics.
 * 
 *
 */
public class Location 
{
	/**
	 * Three dimensional array is necessary for containing both the Column position
	 * the Row position, and the final dimension toggles between y and x coordinates.
	 * for example:
	 * 		when referring to a 3 by  3 grid (like a tic tac toe grid) the square
	 * 		in the middle would be in column 2 in row 2. The point in the center of 
	 * 		the square would be point (1.5 , 1.5) this would be represented as:
	 * 		(remember index starts at 0, making row/column 2 = 1	
	 * 		[1][1][0] = 1.5 //that is the y coordinate for the center
	 * 		[1][1][1] = 1.5 //that is the x coordinate for the center
	 * Because the graphics library draws rectangles starting from the upper left 
	 * position, this array will find that position in pixels for the grid
	 */
	int coordinates [][][] = new int[9][9][2];
	int OFFSET = 25;
	public Location()
	{
		for (int y = 0; y < coordinates.length; y++)
		{
			for (int x = 0; x < coordinates.length; x++)
			{
				coordinates[y][x][0] = y * Grid.getSquareSize() + OFFSET; //y cordinate
				coordinates[y][x][1] = x * Grid.getSquareSize() + OFFSET; //x codinate
			}
		
		}
	}
/**
 * getXLocation
 * @param x grid location
 * @param y grid location
 * @return int[][][] with x the pixel location
 */
	public int getXLocation(int x, int y)
	{
		return coordinates[x][y][0];
	}
	/**getYLocation
	 * 
	 * @param x grid location
	 * @param y grid location
	 * @return int[][][] with y the pixel location
	 */
	public int getYLocation(int x, int y)
	{
		return coordinates[x][y][1];
	}
	
	

		
}
