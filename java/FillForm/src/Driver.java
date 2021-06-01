import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // by by³y metody webdrivera
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver implements WebDriver {
	static String[] loginData;
	static String jobURL;

	Driver() {
		loginData = new String[3];
		loginData[0] = "http://localhost/seleniumGit/DemoPage/"; // Server URL
		loginData[1] = "grzegorz.zygulski@gmail.com"; // login/email
		loginData[2] = "********"; // password
		jobURL = "https://localhost/seleniumGit/DemoPage/job.htm"; // must be protocol://host

	};

	Driver( WebDriver driver, TekstArea[] inputy) {
		super();
		String ProjectLocation = System.getProperty("user.dir"); // System means java machine, that here returns project
																	// URL
		System.setProperty("webdriver.gecko.driver", ProjectLocation + "\\libs\\seleniumjars\\geckodriver.exe"); // when
																													// system
																													// returns
																													// project
																													// folder
																													// it
																													// becomes
																													// dynamiclyy

		driver = new FirefoxDriver(); // WebDriver musi byæ bo tylko ta klasa ma metode get()
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1100));
		doLogin(driver);
		fillForm(inputy, driver);
	}
	
	void doLogin(WebDriver driver) {
		driver.get(loginData[0]); // opens FireFox and go to URL
		WebElement emailInput = driver.findElement(By.id("login"));
		WebElement passwordInput = driver.findElement(By.id("pass"));
		WebElement submit = driver.findElement(By.id("submit"));

		emailInput.sendKeys(loginData[1]);
		passwordInput.sendKeys(loginData[2]);
		submit.click();
		// after login
		if (driver.findElement(By.id("isFailture")).getText().contains("denied")) {
			driver.close();
			JOptionPane.showMessageDialog(MyFrame.frame, " access denied");
		}

	}

	void fillForm(TekstArea[] inputy, WebDriver driver) {
		//JOptionPane.showMessageDialog(MyFrame.frame, " access successful");
		driver.get(jobURL); // opens FireFox and go to URL
		//WebElement submit = driver.findElement(By.name("add"));
		int rows = inputy.length;
		System.out.println("iloœæ inputów: " + rows);
		for (int i = 0; i < rows; i++) {
			WebElement region_input = driver.findElement(By.name("jf[" + i + "]"));
			region_input.sendKeys(inputy[i].getText());
		}

		//submit.click();
		// System.out.println(driver.findElement(By.className("infobox")).getText());
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public WebElement findElement(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void get(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub

	}

	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

}
