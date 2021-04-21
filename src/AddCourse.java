import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

@SuppressWarnings("serial")
/**
 * Used by HomeGui to alter the Data object through another GUI
 * 
 * @author Alex Wang, Connor Chow, Kamran Hussain
 * @version 4/17/2021
 */
public class AddCourse extends JFrame implements ActionListener {
	private JTextField inputCourseName, inputMeetingLink, inputCourseLink; //input variables
  	private String courseName, courseLink, meetingLink;
  	private JButton addClass;
  	private Data d;
  	private int num;
  
  
  	@SuppressWarnings("static-access")
	/**
	 * Creates an AddCourse 
	 * 
	 * @param d Data object used to store data of links and names
	 * @param num specified course that will be changed
	 */
	public AddCourse(Data d, int num) {
	    super("Class Scheduler");
	    
	    //Inputs params into fields
	    this.d = d;
	    this.num = num;
	    
	    //Panel
	    JPanel panel = new JPanel();
	    GridLayout layout = new GridLayout(3,3);
	    layout.setVgap(30);
	    panel.setLayout(layout);
	    panel.setBackground(new Color(200,200,200));
	    
	    //Course name label
	    JLabel nameLabel = new JLabel("   Course Name:\n");
	    nameLabel.setFont(new Font("Montserrat", Font.PLAIN, 17));
	    panel.add(nameLabel);
	    inputCourseName = new JTextField(20);
	    inputCourseName.setHorizontalAlignment(JTextField.RIGHT);
	    inputCourseName.setBackground(new Color(255,255,255));
	    inputCourseName.setFont(new Font("Montserrat", Font.PLAIN, 17));
	    inputCourseName.setText(d.getCourseName(num));
	    panel.add(inputCourseName);
	    
	    //Course link label
	    JLabel courseLabel = new JLabel("   Course Link:\n");
	    courseLabel.setFont(new Font("Montserrat", Font.PLAIN, 17));
	    panel.add(courseLabel);
	    inputCourseLink = new JTextField(20);
	    inputCourseLink.setHorizontalAlignment(JTextField.RIGHT);
	    inputCourseLink.setBackground(new Color(255,255,255));
	    inputCourseLink.setFont(new Font("Montserrat", Font.PLAIN, 17));
	    inputCourseLink.setText(d.getCourseLink(num));
	    panel.add(inputCourseLink);
	
	    //Meeting link label
	    JLabel linkLabel = new JLabel("   Meeting Link:\n");
	    linkLabel.setFont(new Font("Montserrat", Font.PLAIN, 17));
	    panel.add(linkLabel);
	    inputMeetingLink = new JTextField(20);
	    inputMeetingLink.setHorizontalAlignment(JTextField.RIGHT);
	    inputMeetingLink.setBackground(new Color(255,255,255));
	    inputMeetingLink.setFont(new Font("Montserrat", Font.PLAIN, 17));
	    inputMeetingLink.setText(d.getMeetingLink(num));
	    panel.add(inputMeetingLink);
	
	    //Add class button
	    JPanel footer = new JPanel();
	    GridLayout footLayout = new GridLayout(1,1);
	    footer.setLayout(footLayout);
	    addClass = new JButton();
	    addClass.setText("Add Class");
	    addClass.setBackground(new Color(79, 93, 117));
	    addClass.setForeground(Color.WHITE);
	    addClass.addActionListener(this);
	    addClass.setOpaque(false);
	    addClass.setBorderPainted(false);
	    this.add(addClass);
	    footer.add(addClass);
	    footer.setBackground(new Color(79, 93, 117));
	
	    //Container
	    Container c = getContentPane();
	    c.add(panel, BorderLayout.CENTER);
	    c.add(footer, BorderLayout.SOUTH);
	  }
	
	  /**
	   * Checks whether the addCourse button is called
	   * @pre semi-colons (;) cannot be used
	   * @param e ActionEvent for 'Add Course' button
	   */
	  public void actionPerformed(ActionEvent e) {
		ImageIcon logo = new ImageIcon("src/logo.png");
		 
		//Takes in user's input and replaces it in the Data file
	    courseName = inputCourseName.getText();
	    courseLink = inputCourseLink.getText();
	    meetingLink = inputMeetingLink.getText();
	    
	    //Checks if url is valid, then creates a string with all values
	    if((LinkOpener.urlValid(courseLink) == true && LinkOpener.urlValid(meetingLink) == true)) {    	
	    	String s = courseName + ";" + courseLink + ";" + meetingLink;
		    d.replaceStrings(num, s);
		    try {
				FileChanger.writeFile(d.returnStrings());
			} catch (IOException e1) {
				System.out.println("AddCourse writing file failed");
				e1.printStackTrace();
			}
		    System.out.println("No Error Called");
		    // sleeps
		    try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e1) {
				System.out.println("AddCourse sleep timer error.");
				e1.printStackTrace();
			}
		    
		    // destroys window
		    setVisible(false);
		    dispose();
		    
		    //updates HomeGui
		    HomeGui.refresh();
		} else {
			System.out.println("Error 400 Bad Request Error");
			ErrorMessage errorMessage1 = new ErrorMessage();
	    	errorMessage1.setBounds(500, 500, 300, 170);
	    	errorMessage1.setBackground(new Color(211,211,211));
	    	errorMessage1.setVisible(true);
	    	
	    	 ImageIcon logo1 = new ImageIcon("Resources/logo.png");
	    	errorMessage1.setIconImage(logo1.getImage());
		}
	    //Checks if error message is dismissed
	    if(ErrorMessage.isDismissed()==true) {
	    	 String s = courseName + ";" + courseLink + ";" + meetingLink;
	    	    d.replaceStrings(num, s);
	    	    try {
	    			FileChanger.writeFile(d.returnStrings());
	    		} catch (IOException e1) {
	    			System.out.println("AddCourse writing file failed");
	    			e1.printStackTrace();
	    		}
	    	    
	    	    // sleeps
	    	    try {
	    			TimeUnit.MILLISECONDS.sleep(200);
	    		} catch (InterruptedException e1) {
	    			System.out.println("AddCourse sleep timer error.");
	    			e1.printStackTrace();
	    		}
	    } 
	  }
}