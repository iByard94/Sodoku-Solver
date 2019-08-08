import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Isaac Byard
 * This class is responsible for both drawing all of the games graphics,
 * and for controlling/handeling all of the character components. 
 */
public class Grid extends JPanel
{
	
static int SIZE = 9; //number of grid spaces. (this is a constant that should not be changed by the programmer.
private static int BASE_HEIGHT = 50; //the pixel height and width of the squares in the grid
	
JButton button = new JButton();
ControlPanel cPanel = new ControlPanel();
Listener listener = new Listener();
Numbers numbers = new  Numbers();
//int[] numArray = numbers.getNumArray();  THIS IS THE OLD NUMBER FUNCTIONS
int[] numArray = numbers.generateZeros(numbers.getGeneratedNumArray(), 25);
Solver solver = new Solver(numArray);


public void resetGame()
{
	repaint();
}


/**
 * the default constructor for the grid
 */
	public Grid()
	{
		cPanel.solve.addActionListener(listener);
		cPanel.solve.setActionCommand("solve");

		cPanel.generateEasy.addActionListener(listener);
		cPanel.generateEasy.setActionCommand("generateEasy");
		
		cPanel.generateMedium.addActionListener(listener);
		cPanel.generateMedium.setActionCommand("generateMedium");
		
		cPanel.generateHard.addActionListener(listener);
		cPanel.generateHard.setActionCommand("generateHard");
	}
	
/**
 * paintComponent is automatically called by the JPanel.
 * This is in charge of managing all the graphics. 
 */
	public void paintComponent(Graphics pen)
	{
		Graphics2D g2d =  (Graphics2D) pen;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Location location = new Location();
		int X_START_POS = 000;
		int Y_START_POS = 000;
		int xPos = X_START_POS;
		int yPos = Y_START_POS;
		pen.setColor(Color.WHITE);
		pen.fillRect(0, 0, 500, 500);
		pen.setColor(Color.BLACK);
		cPanel.repaint();
		int currentHeight = BASE_HEIGHT;
		int numberIndex = 0;
			for (int yIndex = 0; yIndex<SIZE; yIndex++)
			{
				for (int xIndex = 0; xIndex<SIZE; xIndex++)
				{ 
					
					pen.drawRect(location.getXLocation(xIndex, yIndex), location.getYLocation(xIndex, yIndex), currentHeight, currentHeight);
					pen.drawString(numbers.getString(numberIndex, numArray), location.getXLocation(xIndex, yIndex)+25, location.getYLocation(xIndex, yIndex)+25);
					numberIndex++; 
				}
				xPos = X_START_POS;
				yPos += currentHeight;
			}
				pen.drawLine(location.getXLocation(SIZE/3, 0)-1, location.getYLocation(SIZE/3,0 ), location.getXLocation(SIZE/3, SIZE-1)-1 , location.getYLocation(SIZE/3, SIZE-1)+getSquareSize());
				pen.drawLine(location.getXLocation((SIZE/3)*2, 0)-1, location.getYLocation((SIZE/3)*2,0 ), location.getXLocation((SIZE/3)*2, SIZE-1)-1 , location.getYLocation((SIZE/3)*2, SIZE-1)+getSquareSize());
				pen.drawLine(location.getXLocation(0, SIZE/3), location.getYLocation(0,SIZE/3 )-1, location.getXLocation(SIZE-1, SIZE/3)+getSquareSize() , location.getYLocation( SIZE-1, SIZE/3)-1);
				pen.drawLine(location.getXLocation(0, (SIZE/3)*2), location.getYLocation(0,(SIZE/3)*2 )-1, location.getXLocation(SIZE-1, (SIZE/3)*2)+getSquareSize() , location.getYLocation( SIZE-1, (SIZE/3)*2)-1);

				add(cPanel);
			cPanel.setLocation(500,0);
			cPanel.setSize(480,500);

	}
/**
 * 
 * @return the height of the square of one grid 
 */
	public static int getSquareSize()
	{
		return BASE_HEIGHT;
	}
/**
 * 
 * @author java?
 * this is the action listener for when the buttons are pressed
 *
 */
	private class Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) 
		{
			String action = event.getActionCommand();
			if (action.equals("solve"))
			{
					//solver.backtrack(0, numArray);
					numArray = solver.checkPuzzle(numArray).clone();
					//numArray = solver.getAnswers().clone();
					numbers = new  Numbers(numArray);
					revalidate();
					repaint();
			}
			else if (action.equals("generateEasy"))
			{
					//solver.backtrack(0, numArray);
					numArray = numbers.generateZeros(numbers.getGeneratedNumArray(), 25);
					revalidate();
					repaint();
			}
			else if (action.equals("generateMedium"))
			{
					//solver.backtrack(0, numArray);
					numArray = numbers.generateZeros(numbers.getGeneratedNumArray(), 50);
					revalidate();
					repaint();
			}
			else if (action.equals("generateHard"))
			{
					//solver.backtrack(0, numArray);
					numArray = numbers.generateZeros(numbers.getGeneratedNumArray(), 60);
					revalidate();
					repaint();
			}
		}
	}



}
