package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import objects.VibloObject;



public class NewTest {
	VibloObject vibloPage = null;
	String loginTitle = "Viblo - Login";
	String email = "tang.thi.diem.huong@sun-asterisk.com";
	String password = "Huong1642@@";
	String errorEmail = "Tên người dùng/email là bắt buộc";
	String errorPassword = "Mật khẩu là bắt buộc";
			
	@BeforeSuite
	public void initializeDriver() throws Exception {
		vibloPage = new VibloObject();
	}

	@Test (priority = 0)
	public void inputEmailAndPassCorrect() {
		vibloPage.sendValueForInputEmail(email);
		vibloPage.sendValueForInputPassword(password);
		vibloPage.clickLogin();	
		Assert.assertEquals(vibloPage.driver.getTitle(), loginTitle);
		vibloPage.closeDriver();
	}
	
	@Test (priority = 1)
	public void inputEmailAndPassBlank() throws Exception  {
		vibloPage = new VibloObject();
		Thread.sleep(3000);
		vibloPage.clickLogin();	
		Assert.assertEquals(vibloPage.errorEmailFields.get(0).getText(),errorEmail);
		Assert.assertEquals(vibloPage.errorPassFields.get(0).getText(),errorPassword);
		vibloPage.closeDriver();
	}
	

	@Test (priority = 2)
	public void inputPassBlank() throws Exception {
		vibloPage = new VibloObject();
		Thread.sleep(3000);
		vibloPage.sendValueForInputEmail(email);
		vibloPage.clickLogin();	
		Assert.assertEquals(vibloPage.errorPassFields.get(0).getText(),errorPassword);
		vibloPage.closeDriver();
	}
	
	@Test (priority = 2)
	public void inputEmailBlank() throws Exception {
		vibloPage = new VibloObject();
		Thread.sleep(3000);
		vibloPage.sendValueForInputPassword(password);
		vibloPage.clickLogin();	
		Assert.assertEquals(vibloPage.errorEmailFields.get(0).getText(),errorEmail);
		vibloPage.closeDriver();
	}

}
