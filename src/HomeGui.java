import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Used to show the GUI of the Linksaver and backend logistics
 * 
 * @author Alex Wang, Connor Chow, Kamran Hussain
 * @version 4/17/2021
 */
public class HomeGui extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private Data d;
	private JTextPane footer;
	private JTextPane title;
	private static JButton course1, course2, course3, course4, course5, course6, course7, course8;
	private static JButton editCourse1, editCourse2, editCourse3, editCourse4, editCourse5, editCourse6, editCourse7, editCourse8;
	
	@SuppressWarnings("deprecation")
	/**
	 * Creates a HomeGui (no args as parameters)
	 */
	public HomeGui() {
		super("Home");
		
		//data is initialized and inputted into HomeGui
		d = new Data(8);
		//file is checked and stored into Data object 'd'
		if(FileChanger.checkFile()) {
			FileChanger.readFile(d);
		}
		else {
			FileChanger.createFile();
			FileChanger.readFile(d);
		}
		
		//Panel
	    JPanel main = new JPanel();
	    GridLayout layout = new GridLayout(2,4);
	    layout.setVgap(5);
	    layout.setHgap(5);
	    main.setLayout(layout);
	    main.setBackground(new Color(255,255,255));
	
	    //Tile 1 & its edit button
	    course1 = new JButton();
	    course1.setText(Data.getCourseName(0));
	    course1.addActionListener(this);
	    this.add(course1);
	    
	    editCourse1 = new JButton();
	    editCourse1.setText("Edit");
	    editCourse1.setBackground(new Color(210,210,210));
	    editCourse1.addActionListener(this);
	    this.add(editCourse1);
	    course1.add(editCourse1);
	    
	    course1.setHorizontalAlignment(JTextField.CENTER);
	    course1.setBackground(new Color(191, 192, 192));
	    course1.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    main.add(course1);
	    
	    //Tile 2 & its edit button
	    course2 = new JButton();
	    course2.setText(Data.getCourseName(1));
	    course2.addActionListener(this);
	    this.add(course2);
	    
	    editCourse2 = new JButton();
	    editCourse2.setText("Edit");
	    editCourse2.setBackground(new Color(210,210,210));
	    editCourse2.addActionListener(this);
	    this.add(editCourse2);
	    course2.add(editCourse2);
	    
	    course2.setHorizontalAlignment(JTextField.CENTER);
	    course2.setBackground(new Color(191, 192, 192));
	    course2.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    main.add(course2);
	    
	    //Tile 3 & its edit button
	    course3 = new JButton();
	    course3.setText(Data.getCourseName(2));
	    course3.addActionListener(this);
	    this.add(course3);
	    
	    editCourse3 = new JButton();
	    editCourse3.setText("Edit");
	    editCourse3.setBackground(new Color(210,210,210));
	    editCourse3.addActionListener(this);
	    this.add(editCourse3);
	    course3.add(editCourse3);
	    
	    course3.setHorizontalAlignment(JTextField.CENTER);
	    course3.setBackground(new Color(191, 192, 192));
	    course3.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    this.add(course3);
	    main.add(course3);
	    
	    //Tile 4 & its edit button
	    course4 = new JButton();
	    course4.setText(Data.getCourseName(3));
	    course4.enable(false);
	    course4.addActionListener(this);
	    this.add(course4);
	    
	    editCourse4 = new JButton();
	    editCourse4.setText("Edit");
	    editCourse4.setBackground(new Color(210,210,210));
	    editCourse4.addActionListener(this);
	    this.add(editCourse4);
	    course4.add(editCourse4);
	    
	    course4.setHorizontalAlignment(JTextField.CENTER);
	    course4.setBackground(new Color(191, 192, 192));
	    course4.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    main.add(course4);
	    
	    //Tile 5 & its edit button
	    course5 = new JButton();
	    course5.setText(Data.getCourseName(4));
	    course5.addActionListener(this);
	    this.add(course5);
	    
	    editCourse5 = new JButton();
	    editCourse5.setText("Edit");
	    editCourse5.setBackground(new Color(210,210,210));
	    editCourse5.addActionListener(this);
	    this.add(editCourse5);
	    course5.add(editCourse5);
	    
	    course5.setHorizontalAlignment(JTextField.CENTER);
	    course5.setBackground(new Color(191, 192, 192));
	    course5.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    main.add(course5);
	    
	    //Tile 6 & its edit button
	    course6 = new JButton();
	    course6.setText(Data.getCourseName(5));
	    course6.addActionListener(this);
	    this.add(course6);
	    
	    editCourse6 = new JButton();
	    editCourse6.setText("Edit");
	    editCourse6.setBackground(new Color(210,210,210));
	    editCourse6.addActionListener(this);
	    this.add(editCourse6);
	    course6.add(editCourse6);
	    
	    course6.setHorizontalAlignment(JTextField.CENTER);
	    course6.setBackground(new Color(191, 192, 192));
	    course6.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    main.add(course6);
	    
	    //Tile 7 & its edit button
	    course7 = new JButton();
	    course7.setText(Data.getCourseName(6));
	    course7.addActionListener(this);
	    this.add(course7);
	    
	    editCourse7 = new JButton();
	    editCourse7.setText("Edit");
	    editCourse7.setBackground(new Color(210,210,210));
	    editCourse7.addActionListener(this);
	    this.add(editCourse7);
	    course7.add(editCourse7);
	    
	    course7.setHorizontalAlignment(JTextField.CENTER);
	    course7.setBackground(new Color(191, 192, 192));
	    course7.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    main.add(course7);
	    
	    //Tile 8 & its edit button
	    course8 = new JButton();
	    course8.setText(Data.getCourseName(7));
	    course8.addActionListener(this);
	    this.add(course8);
	    
	    editCourse8 = new JButton();
	    editCourse8.setText("Edit");
	    editCourse8.setBackground(new Color(210,210,210));
	    editCourse8.addActionListener(this);
	    this.add(editCourse8);
	    course8.add(editCourse8);
	    
	    course8.setHorizontalAlignment(JTextField.CENTER);
	    course8.setBackground(new Color(191, 192, 192));
	    course8.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    main.add(course8);
	
	    //Homepage header
	    JPanel header = new JPanel();
	    header.setBackground(new Color(79, 93, 117));
	    title = new JTextPane();
	    title.setText("Link Saver");
	    title.setEditable(false);
	    title.setAlignmentX(CENTER_ALIGNMENT);
	    title.setFont(new Font("Montserrat", Font.PLAIN, 40));
	    title.setForeground(new Color(255, 255, 255));
	    title.setBackground(new Color(79, 93, 117));
	    header.add(title);
	    
	    StyledDocument doc = title.getStyledDocument();
	    SimpleAttributeSet center = new SimpleAttributeSet();
	    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
	    doc.setParagraphAttributes(0, doc.getLength(), center, false);
	    
	    //Homepage footer
	    JPanel bottomFooter = new JPanel();
	    bottomFooter.setBackground(new Color(255, 255, 255));
	    footer = new JTextPane();
	    footer.setForeground(new Color(0,0,0));
	    footer.setText("Click \'edit\' to input information!");
	    footer.setEditable(false);
	    footer.setFont(new Font("Montserrat", Font.PLAIN, 20));
	    footer.setBackground(new Color(255, 255, 255));
	    bottomFooter.add(footer);
	    
	    StyledDocument doc2 = footer.getStyledDocument();
	    SimpleAttributeSet center2 = new SimpleAttributeSet();
	    StyleConstants.setAlignment(center2, StyleConstants.ALIGN_CENTER);
	    doc2.setParagraphAttributes(0, doc2.getLength(), center, false);
	    
	    //Container
	    Container c = getContentPane();
	    c.add(main, BorderLayout.CENTER);
	    c.add(header, BorderLayout.BEFORE_FIRST_LINE);
	    c.add(bottomFooter, BorderLayout.AFTER_LAST_LINE);
	  }

	@Override
	/**
	 * Checks when a button is called and redirects to the right process
	 * @param e ActionEvent from HomeGui JButtons
	 */
	public void actionPerformed(ActionEvent e) {
		ImageIcon logo = new ImageIcon("Resources/logo.png");
		
		if(e.getSource() == course1) {
			//Opens links for course1
			System.out.println("course1 called");
			LinkOpener.openLink(d.getCourseLink(0));
			LinkOpener.openLink(d.getMeetingLink(0));
		}
		if(e.getSource() == course2) {
			//Opens links for course2
			System.out.println("course2 called");
			LinkOpener.openLink(d.getCourseLink(1));
			LinkOpener.openLink(d.getMeetingLink(1));
		}
		if(e.getSource() == course3) {
			//Opens links for course3
			System.out.println("course3 called");
			LinkOpener.openLink(d.getCourseLink(2));
			LinkOpener.openLink(d.getMeetingLink(2));
		}
		if(e.getSource() == course4) {
			//Opens links for course4
			System.out.println("course4 called");
			LinkOpener.openLink(d.getCourseLink(3));
			LinkOpener.openLink(d.getMeetingLink(3));
		}
		if(e.getSource() == course5) {
			//Opens links for course5
			System.out.println("course5 called");
			LinkOpener.openLink(d.getCourseLink(4));
			LinkOpener.openLink(d.getMeetingLink(4));
		}
		if(e.getSource() == course6) {
			//Opens links for course6
			System.out.println("course6 called");
			LinkOpener.openLink(d.getCourseLink(5));
			LinkOpener.openLink(d.getMeetingLink(5));
		}
		if(e.getSource() == course7) {
			//Opens links for course7
			System.out.println("course7 called");
			LinkOpener.openLink(d.getCourseLink(6));
			LinkOpener.openLink(d.getMeetingLink(6));
		}
		if(e.getSource() == course8) {
			//Opens links for course8
			System.out.println("course8 called");
			LinkOpener.openLink(d.getCourseLink(7));
			LinkOpener.openLink(d.getMeetingLink(7));
		}
		if(e.getSource() == editCourse1) {
			//Opens an AddCourse for course1 to edit its links/name
			System.out.println("edit course1 called");
			AddCourse course = new AddCourse(d, 0);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
	    	course.setIconImage(logo.getImage());
		}
		if(e.getSource() == editCourse2) {
			//Opens an AddCourse for course2 to edit its links/name
			System.out.println("edit course2 called");
			AddCourse course = new AddCourse(d, 1);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
	    	course.setIconImage(logo.getImage());
		}
		if(e.getSource() == editCourse3) {
			//Opens an AddCourse for course3 to edit its links/name
			System.out.println("edit course3 called");
			AddCourse course = new AddCourse(d, 2);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
	    	course.setIconImage(logo.getImage());
		}
		if(e.getSource() == editCourse4) {
			//Opens an AddCourse for course4 to edit its links/name
			System.out.println("edit course4 called");
			AddCourse course = new AddCourse(d, 3);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
	    	course.setIconImage(logo.getImage());
		}
		if(e.getSource() == editCourse5) {
			//Opens an AddCourse for course5 to edit its links/name
			System.out.println("edit course5 called");
			AddCourse course = new AddCourse(d, 4);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
	    	course.setIconImage(logo.getImage());
		}
		if(e.getSource() == editCourse6) {
			//Opens an AddCourse for course6 to edit its links/name
			System.out.println("edit course6 called");
			AddCourse course = new AddCourse(d, 5);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
	    	course.setIconImage(logo.getImage());
		}
		if(e.getSource() == editCourse7) {
			//Opens an AddCourse for course7 to edit its links/name
			System.out.println("edit course7 called");
			AddCourse course = new AddCourse(d, 6);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
	    	course.setIconImage(logo.getImage());
		}
		if(e.getSource() == editCourse8) {
			//Opens an AddCourse for course8 to edit its links/name
			System.out.println("edit course8 called");
			AddCourse course = new AddCourse(d, 7);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
	    	course.setIconImage(logo.getImage());
		}
	}
	
	/**
	 * refreshes HomeGui to display the correct names
	 */
	public static void refresh() {
	    course1.setText(Data.getCourseName(0));
	    course2.setText(Data.getCourseName(1));
	    course3.setText(Data.getCourseName(2));
	    course4.setText(Data.getCourseName(3));
	    course5.setText(Data.getCourseName(4));
	    course6.setText(Data.getCourseName(5));
	    course7.setText(Data.getCourseName(6));
	    course8.setText(Data.getCourseName(7));
	}
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		HomeGui courseWindow = new HomeGui();
	    courseWindow.setBounds(500, 500, 1200, 650);
	    courseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    courseWindow.setBackground(new Color(211,211,211));
	    
	    ImageIcon logo = new ImageIcon("Resources/logo.png");
		courseWindow.setIconImage(logo.getImage());
	    
		courseWindow.setVisible(true);
	}
}