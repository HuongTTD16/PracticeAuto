package objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class BasicObject {
	public WebDriver driver;
	public WebElement findTxtObject(String typeFind, String valueFind) {
		
		WebElement txtObject = null;
		if(typeFind == "ByClassName") {
			txtObject = driver.findElement(By.className(valueFind));
		}
		// timf theo cac type by kha
		
		return txtObject;
	}
	public void closeDriver() {
		driver.close();
	}
	public void sendKeyForObject(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	// event
	public void clickButton(WebElement element) {
		
	}
	
	public void clearDataThenSendValue(WebElement object, String value) {
		
	}
}
