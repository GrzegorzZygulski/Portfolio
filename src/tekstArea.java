import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.util.stream.Stream;

import javax.swing.JTextArea;


public class tekstArea extends JTextArea {
	public static int rows;	
	tekstArea(String tekst) {
		super(tekst);
		this.setEditable(true);
		this.setFont(new Font("Arial", Font.PLAIN, 24));
		this.setCaretColor(Color.red);

	}

	/** Dzieli tekst z obszaru roboczego na wersy i  kopiuje wers do input�w */
	public void copyLine(tekstArea[] inputy) {
		String dane = this.getText(); // takes text from Jtexarea
		rows = this.getLineCount(); // liczba lini w Jtextarea
		Stream<String> lines = dane.lines(); // by stringi dzieli�o to na stream konwertuje
		Object[] strings = lines.toArray(); // steam dzieli si� na linie

		for (int i = 0; i < rows; i++) {
			
		//	 System.out.println(inputy[i].getText()); System.out.println(strings[i]);
			 
			inputy[i].setText((String) strings[i]);	//  przerzuca z text area na inputy
			}

	}
}
