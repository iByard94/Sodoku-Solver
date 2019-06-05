
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;

import javax.swing.*;
/**
 * 
 * @author Isaac Byard
 *
 */
public class Window extends javax.swing.JFrame
{
	JFrame window = new JFrame("Frame Demo");
	JButton okButton = new JButton("OK");
	Grid grid = new Grid();
/**
 * default constructor for the Window. Window is the JFrame. 
 * this constructor sets the window size, and adds the grid JPalel
 * to the Frame.
 */
	public Window()
	{

		window.setSize(815,520);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(grid);
		window.setResizable(false);// disables resizing
		
		
	}
	
	
}
