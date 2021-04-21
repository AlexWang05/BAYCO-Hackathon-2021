import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Used by AddCourse to show an error-message popup
 * 
 * @author Alex Wang, Connor Chow, Kamran Hussain
 * @version 4/17/2021
 */
public class ErrorMessage extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static boolean dismissed = false;

	/**
	 * Creates an error message (no args as params)
	 */
	public ErrorMessage() {
		super("ERROR 400: BAD REQUEST ERROR");
		
		//Panel
		JPanel panel = new JPanel();
	    GridLayout layout = new GridLayout(2,1);
	    panel.setLayout(layout);
	    panel.setBackground(new Color(200,200,200));
	    
	    //Error labels
	    JLabel error = new JLabel("The link you added is invalid", SwingConstants.CENTER);
	    error.setFont(new Font("Montserrat", Font.PLAIN, 17));
	    panel.add(error, BorderLayout.CENTER);
	    
	    //Dismiss button
	    JPanel foot = new JPanel();
	    GridLayout footLayout = new GridLayout(1,1);
	    foot.setLayout(footLayout);
	    JButton dismiss = new JButton();
	    dismiss.setText("Dismiss");
	    dismiss.setBackground(new Color(79, 93, 117));
	    dismiss.setForeground(Color.WHITE);
	    dismiss.addActionListener(this);
	    dismiss.setOpaque(false);
	    dismiss.setOpaque(false);
	    dismiss.setBorderPainted(false);
	    this.add(dismiss);
	    foot.add(dismiss);
	    foot.setBackground(new Color(79, 93, 117));
	    
	    //Container
	    Container c = getContentPane();
	    c.add(panel, BorderLayout.CENTER);
	    c.add(foot, BorderLayout.AFTER_LAST_LINE);
	}

	@Override
	/**
	 * Checks if error is dismissed through button at bottom of the popup
	 * @param e ActionEvent for 'Dismiss' button
	 */
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
	    dispose();
	    dismissed = true;
	}
	
	/**
	 * Checks if popup is dismissed
	 * @return whether popup is dismissed or not
	 */
	public static boolean isDismissed() {
		return dismissed;
	}

}
