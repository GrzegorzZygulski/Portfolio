import java.awt.EventQueue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // by by³y metody webdrivera
import org.openqa.selenium.WebElement; // by by³ typ lista elementów HTML
import java.util.List; // lista WebElement opiera sie na zwyklej javoskiej liscie
import org.openqa.selenium.firefox.*; // wpisujesz importa i potem PPM na projekt > Build Path.Configure.Libearies > rm Selenium modulepath (classpath ma zostac)

public class main {

	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MyFrame();
			}
		});
	}
}