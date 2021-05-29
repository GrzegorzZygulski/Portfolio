import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Guzik extends JButton implements MouseListener { // np. przycik wyœlij
	JPanel Panel;
	String text;
	tekstArea textArea;
	tekstArea[] inputy;

	Guzik(String tekst) {
		super(tekst); // showed title od button
		this.setFont(new Font("Arial", Font.PLAIN, 20));
		this.setName(tekst); // 4 source for mouselistener
		addMouseListener(this);
	}

	Guzik(tekstArea[] inputy, String tekst) { // np. przycik wyœlij
		super(tekst); // showed title od button
		this.setFont(new Font("Arial", Font.PLAIN, 20));
		this.setName(tekst); // 8r source for mouselistener
		this.inputy = inputy;
		addMouseListener(this);
	}
/** inputy[] czyli pojedyñcze pola tekstowe np. w kolejce lub wysy³ane do serwera. 
 *  Korzystj¹ z tego kontruktora przciski np.  => oraz  'dodaj do obszaru roboczego' */
	Guzik(tekstArea textArea, tekstArea[] inputy, String tekst) { 
		super(tekst); // showed title od button
		this.setFont(new Font("Arial", Font.PLAIN, 20));
		this.setName(tekst); // 8r source for mouselistener
		this.textArea = textArea;
		this.inputy = inputy;
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String source = e.getSource().toString(); // info o obiekcie zamienia na string, a nazwa w info
																	// od 7 znaku sie zaczyna
		System.out.println(source); // prints Name field of button

		if (source.contains("<=")) {
			System.out.println("sfotmatowane dane z textArea bierzemy do inputów");
			textArea.copyLine(inputy);
		}
		if (source.contains("wyœ")) {
			System.out.println("zbieramy z ma³ych pó³ i wysy³amy");
			webDriver driver = null;
			driver = new webDriver(driver, inputy);
		}
		if (source.contains("dodaj do kolejki")) {
			System.out.println("\n dodaj do kolejki");
			Kolejka.add(textArea); //do kolejki wstawiamy test z obszaru roboczego
		}
		if (source.contains("dodaj pierwszy z kolejki")) {
			System.out.println("\n dodaj pierwszy do kolejki");
			Kolejka.dodajDoPreview(inputy);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// throw new UnsupportedOperationException("Not supported yet."); //To change
		// body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// throw new UnsupportedOperationException("Not supported yet."); //To change
		// body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// throw new UnsupportedOperationException("Not supported yet."); //To change
		// body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// throw new UnsupportedOperationException("Not supported yet."); //To change
		// body of generated methods, choose Tools | Templates.
	}
}
