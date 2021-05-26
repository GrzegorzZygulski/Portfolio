import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainPanel extends JPanel {

	public static final int HEIGHT = 980;
	public static final int WIDTH = 1906;
	public JPanel mainPanel;

		public tekstArea textArea;
	menu menu;
	Preview zPolamiPanel; // Preview
	Kolejka Kolejka; 
	private Guzik wyslij;

	public mainPanel(JFrame frame) {
		mainPanel = this;
		mainPanel.setLayout(new BorderLayout());

		menu = new menu(frame);
		JPanel northPanel = new JPanel(); // penel w panelu
		northPanel.setLayout(new FlowLayout());

		textArea = new tekstArea("Grzegorz Zygulski IT\nCosmpolita\n25-437\npl. im. Javy 2\nwszêdzio-polskie\n123-123-123\nhttps://github.com/GrzegorzZygulski\nhttps://github.com/GrzegorzZygulski\ngrzegorz.zygulski@gmail.com");
		zPolamiPanel = new Preview(textArea, 9);
		Kolejka = new Kolejka(textArea, 9);
		wyslij = new Guzik(Preview.inputy, "wyœlij");

		mainPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(zPolamiPanel, BorderLayout.WEST);
		mainPanel.add(Kolejka, BorderLayout.SOUTH);

		mainPanel.add(textArea, BorderLayout.CENTER);
		mainPanel.add(wyslij, BorderLayout.NORTH);
		mainPanel.setMinimumSize(new Dimension(500, 900));
		mainPanel.setVisible(true);
	}
}