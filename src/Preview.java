import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints; // for manual GridBag object adding
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

public class Preview extends JPanel {
	final static boolean shouldFill = true; // For GridBagContranits
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	private Guzik przenies;
	public static tekstArea[] inputy;
	private JLabel[] labels4input;

	/**
	 * textArea to referencja do pola tekstowego z mainPanel, rows oznacza ile ma
	 * <inputów> zrobić
	 */
	public Preview(tekstArea textArea, int rows) {

		this.setLayout(new GridBagLayout()); // here this==westPanels
		this.setMaximumSize(new Dimension(635, 500));

		GridBagConstraints c = new GridBagConstraints();// to flow i grid layout same wrzucały jeden po drugim, w
														// GridBayLotout samo to kontrolujesz
		c.insets = new Insets(5, 5, 5, 5); // padding

		if (shouldFill) {
			// natural height, maximum width
			c.fill = GridBagConstraints.HORIZONTAL;
		}

		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		c.gridheight = 1;

		inputy = new tekstArea[rows]; // zaalokownie miejsca w RAMie
		labels4input = new JLabel[rows]; // zaalokownie miejsca w RAMie
		labels4input[0] = new JLabel("nazwa");
		labels4input[1] = new JLabel("miejscowość");
		labels4input[2] = new JLabel("kod");
		labels4input[3] = new JLabel("ulica");
		labels4input[4] = new JLabel("województwo");
		labels4input[5] = new JLabel("telefon");
		labels4input[6] = new JLabel("www");
		labels4input[7] = new JLabel("www.kontakt");
		labels4input[8] = new JLabel("email");

		for (int gridY = 0; gridY < rows; gridY++) {
			inputy[gridY] = new tekstArea("pole " + gridY);
			inputy[gridY].setSize(500, 20);
			inputy[gridY].setLineWrap(true);
			inputy[gridY].setWrapStyleWord(true);

			c.gridx = 2;
			c.gridy = gridY + 1;
			this.add(inputy[gridY], c); // this, czyli westpanel

			c.gridx = 1;
			c.gridy = gridY + 1;
			this.add(labels4input[gridY], c); // this, czyli westpanel

		}
		c.gridwidth = 2;
		JLabel tytul = new JLabel("Podgląd", JLabel.CENTER);
		tytul.setFont(new Font("Arial", Font.BOLD, 28));		
		c.gridx = 1;
		c.gridy = 0;
		this.add(tytul, c);
		
		c.gridwidth = 3;
		przenies = new Guzik(textArea, inputy, "▲ dodaj pierwszy z kolejki"); // this bo guzik przyjmuje panel -textareaktory na zmieniac												// this.add(przenies); setVisible(true);
		c.gridheight = rows;
		c.gridx = 0;
		c.gridy = 10;
		this.add(przenies, c);

	

	}
}
