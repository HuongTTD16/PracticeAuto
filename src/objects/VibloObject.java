package objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import config.SetupDriver;

public class VibloObject extends BasicObject {
	String URL = "https://accounts.viblo.asia/login";

	public VibloObject() throws Exception {
		this.driver = SetupDriver.buildSetupDriver();

		driver.get(URL); // Initialise Elements
		driver.manage().window().maximize(); // full screen
	}

	@FindBys({ @FindBy(xpath = "/html/body/div/div/div/div/div/div/div[3]/form/div[1]/div/div[2]"), })
	public List<WebElement> errorEmailFields;

	@FindBys({ @FindBy(xpath = "/html/body/div/div/div/div/div/div/div[3]/form/div[2]/div/div[2]"), })
	public List<WebElement> errorPassFields;

	public void sendValueForInputEmail(String email) {
		WebElement inputEmail = driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[3]/form/div[1]/div/div/input"));
		inputEmail.sendKeys(email);
	}

	public void sendValueForInputPassword(String pass) {
		WebElement inputPass = driver
				.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[3]/form/div[2]/div/div/input"));
		inputPass.sendKeys(pass);
	}

	public void clickLogin() {
		WebElement loginButton = driver
				.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]"));
		loginButton.click();
	}

}
