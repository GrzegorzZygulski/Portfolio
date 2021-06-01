import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

public static JFrame frame;
	
	public MyFrame() {
		super("Filler");
		frame=this;
		JPanel panel = new MainPanel(frame);

		add(panel);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}