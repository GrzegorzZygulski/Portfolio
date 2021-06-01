import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints; // for manual GridBag object adding
import java.awt.GridBagLayout;
import java.awt.Insets;

public class Kolejka extends JPanel {
	final static boolean shouldFill = true; // For GridBagContranits
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	private Guzik przenies;
	public static TekstArea[] kolejka;
	TekstArea textArea;
	/**
	 * textArea to referencja do pola tekstowego z mainPanel, rows oznacza ile ma
	 * <inputów> zrobić
	 */
	public Kolejka(TekstArea textArea, int rows) {

		this.setLayout(new GridBagLayout()); // here this==westPanels
		this.setMaximumSize(new Dimension(800, 500));
		this.textArea=textArea;

		GridBagConstraints c = new GridBagConstraints();// to flow i grid layout same wrzucały jeden po drugim, w
														// GridBayLotout samo to kontrolujesz
		c.insets = new Insets(5, 5, 5, 5); // padding
		c.gridheight = 1;

		kolejka = new TekstArea[20]; // zaalokownie miejsca w RAMie
		for (int gridX = 0; gridX < 20; gridX++) {
			kolejka[gridX] = new TekstArea("|");
			String gridXString= String.valueOf(gridX); // by iterator int na stringa przerobic
			kolejka[gridX].setName(gridXString);
			kolejka[gridX].setSize(180, 200);
			kolejka[gridX].setLineWrap(true);
			kolejka[gridX].setFont(new Font("Arial", Font.BOLD, 10));
			kolejka[gridX].setVisible(false);
			// kolejka[gridX].setVisible(false);
			/*
			 * kolejka[gridX].setText("P.P.H. Tretton Krzysztof Kmiecik\r\n" +
			 * "Bielkowo\r\n" + "73-108\r\n" + "Łąkowa 18\r\n" + "zachodniopomorskie\r\n" +
			 * "530 744 844 \r\n" + "www.tretton.pl\r\n" +
			 * "http://www.tretton.pl/kontakt\r\n" + "tretton@tretton.pl" );
			 */
			if (gridX < 10) {
				c.gridx = gridX;
				c.gridy = 1;
			} else {
				c.gridx = gridX - 10;
				c.gridy = 2;
			}
			this.add(kolejka[gridX], c); // this, czyli wyswietla
		}

		JLabel tytul = new JLabel("Kolejka", JLabel.CENTER);
		tytul.setFont(new Font("Arial", Font.BOLD, 28));
		c.gridwidth = 2;
		c.gridx = 4;
		c.gridy = 0;
		this.add(tytul, c);
		c.gridwidth = 1;

		przenies = new Guzik(textArea,kolejka,"▼ dodaj do kolejki"); // this bo guzik przyjmuje panel -textareaktory na zmieniac //
		c.gridwidth = 2;
		c.gridx = 9;
		c.gridy = 0;
		this.add(przenies, c);
		


	}
/** adds text from 'obszar roboczy' to 'kolejka'*/
	public static void add(TekstArea textArea) {
		for (TekstArea customer: kolejka) { // foreach customerin kolejka
			// System.out.println(textArea.getText()");
			if (customer.getText().contains("|") == true) { // customer zawiera znak | oznacza to  że to pole jest "puste bo rzadko w danych polskich | występuje
				System.out.println("tu wstawi wynik: "+ customer.getName());
				customer.setText(textArea.getText());
				customer.setVisible(true);
				break;
			}// end of foreach	
		}
	}
	/** adds text from 'kolejka' to 'preview/podglad'*/
	public static void dodajDoPreview(TekstArea[] inputy) {
		for (TekstArea customer: kolejka) { // foreach customerin kolejka
			// System.out.println(textArea.getText()");
			if (customer.getText().contains("|") != true) { // jeżli nie zawiera znaku |, to znaczy ze są tam jakieś dane
				System.out.println("biorę wynik z : "+ customer.getName());
				System.out.println(" i wstawię go ");
				customer.copyLine(inputy);
				customer.setText("|"); // czyscimy  korke po skopiowaniu
				customer.setVisible(false); //  ukrywamy  po skopiowaniu
				break;
			}// end of foreach	
		}
	}
}
