

import javax.swing.*;
/**
 * 
 * @author Isaac Byard
 *
 */
public class Window extends JFrame
{
	JFrame window = new JFrame("Frame Demo");
	JButton okButton = new JButton("OK");
	Grid grid = new Grid();
	
    		
/**
 * default constructor for the Window. Window is the JFrame. 
 * this constructor sets the window size, and adds the grid JPanel
 * to the Frame.
 */

	public Window()
	{

		setSize(815,520);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(grid);
		//add(okButton);
		setResizable(false);// disables resizing	
		grid.resetGame();
		revalidate();
		
	}
	
	
}
