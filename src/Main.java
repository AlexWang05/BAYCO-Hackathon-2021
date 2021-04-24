import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

	public static Image getIcon() {
		ImageIcon logo = new ImageIcon("Resources/logo.png");
		Image icon = logo.getImage();
		return icon;
	}
	public static void main(String[] args) {
		HomeGui courseWindow = new HomeGui();
	    courseWindow.setBounds(100, 100, 1200, 650);
	    courseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    courseWindow.setBackground(new Color(211,211,211));
	    courseWindow.setIconImage(getIcon());
		courseWindow.setVisible(true);
	}

}
