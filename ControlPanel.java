
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * 
 * @author Isaac Byard
 *
 *This control Panel is a JPanl inside the JPanel "Grid." This contains the images
 *for the button interface and for the text boxes. This class does not process any 
 *information itself (the button listeners are in the parent class, etc), however
 *the parent class does pass information into this. All of the text and button listeners
 *come directly from the parent class "Grid."
 */
public class ControlPanel extends JPanel
{

	JButton solve = new JButton("Solve");	


/**
 * paintComponent() is a method being overridden from the JPanel class.
 * it is automatically called. This is responsible for all the graphics of 
 * this ControlPanel. It sets the background with a dark gray rectangle.
 * It adds the buttons, text fields, and text areas to its panel. And it 
 * positions those items.
 */
	public void paintComponent(Graphics pen)
	{
		pen.setColor(Color.DARK_GRAY);
		pen.fillRect(000, 000, 700, 500);
	
		add(solve);

		solve.setBackground(Color.GREEN);

		solve.setSize(100,100);

		solve.setLocation(100,100);

	}
}
