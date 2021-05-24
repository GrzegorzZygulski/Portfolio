import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class menu implements ActionListener {
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;
	JFrame frame;
	webDriver TMP; // do inicjalizacji danych

	class menuItem {
	}

	menu(JFrame frame) {
		this.frame = frame;// bo frame jest z parametru funkcji (konstruktora) w innej funkcji nawet tej
							// klasy bedzie unidetified, wiec tworzymy zmienna z o tej samej nazwie by nie
							// wymyœlaæ kolejnej nazwy i przypisujemy frame do niej

		// Create the menu bar.
		menuBar = new JMenuBar();

		/*---------------------------------------------		 Build the first menu. */
		menu = new JMenu("Dane logowania");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu);

		// a group of JMenuItems
		menuItem = new JMenuItem("URL Serwera");
		menuItem.setName("Menu1ItemA");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Login/e-mail");
		menuItem.setName("Menu1ItemB");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("password");
		menuItem.setName("Menu1ItemC");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		/*---------------------------------------------		 Build the second menu. */
		menu = new JMenu("Dane Pracy");
		menu.setMnemonic(KeyEvent.VK_B);
		menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu);

		// a group of JMenuItems
		menuItem = new JMenuItem("URL Pracy");
		menuItem.setName("Menu2itemA");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		/*---------------------------------------------		 Build the third menu. */
		menu = new JMenu("Ustawienia");
		menu.setMnemonic(KeyEvent.VK_C);
		menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu);

		// a group of JMenuItems
		menuItem = new JMenuItem("Tryb ciemny");
		menuItem.setName("Menu3itemA");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		// a group of JMenuItems
		menuItem = new JMenuItem("O programie");
		menuItem.setName("Autor");
		//menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		frame.setJMenuBar(menuBar);
		TMP = new webDriver(); // musi byæ tu webdrivwr bo dane logowania sa tu inicjalizowane
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getSource().toString(); // info o obiekcie zamienia na string, a nazwa w
		// info
		System.out.println(source+"\n"); // prints Name field of button
		
		if (source.contains("Menu1ItemA")) {
		
			webDriver.loginData[0] = JOptionPane.showInputDialog("Server URL: ", webDriver.loginData[0]);
		}
		if (source.contains("Menu1ItemB")) {

		
			TMP.loginData[1] = JOptionPane.showInputDialog("Login/email: ", TMP.loginData[1]);
		}
		if (source.contains("Menu1ItemC")) {
		
			TMP.loginData[2] = JOptionPane.showInputDialog("password: ", TMP.loginData[2]);
		}
		if (source.contains("Menu2itemA")) {
			
			webDriver.jobURL = JOptionPane.showInputDialog("Job URL: ", webDriver.jobURL);
		}
		if (source.contains("Autor")) {

			JOptionPane.showMessageDialog(frame, "Autorem programu jest: \n Grzegorz Zygulski",
					"O programie", JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
