package ivanVojnovic.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ivanVojnovic.pages.Utils;


public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	//geter i setter za Username 
	public WebElement getUserName() {
		return Utils.waitForElementPresence(driver, By.id("username"), 10);
	}
	
	public void setUserName(String userName) {
		WebElement userName1 = this.getUserName();
		userName1.clear();
		userName1.sendKeys(userName);
	}
	
	//getter i setter za password
	public WebElement getPassword() {
		return Utils.waitForElementPresence(driver, By.id("password"), 10);
	}
	
	public void setPassword(String password) {
		WebElement password1 = this.getPassword();
		password1.clear();
		password1.sendKeys(password);
	}
	
	//getter za dugme SignIn
	public WebElement getSignInBtn() {
		return Utils.waitForElementPresence(driver, By.className("btn-info"), 10);
	}
	
	//getter za dugme Cancel
	public WebElement getCancelBtn() {
		return Utils.waitForElementPresence(driver, By.className("btn-danger"), 10);
	}
	
	public WebElement getZaboravljenaLozinkaBtn() {
		return driver.findElement(By.xpath("//a[@ui-sref='forgotPassword']"));
	}
	
	public WebElement getLoginProblem() {
		return driver.findElement(By.xpath("//li[contains(text(),'Pogrešno korisničko ime ili lozinka!')]"));
	}
	
	public void navigateToPage(){
		driver.navigate().to("park.ftn.uns.ac.rs:8080/#/login");
	}
	
	//funkcija za popunjavanje 
	public void login (String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
		this.getSignInBtn().click();
	}
	
	//poruka o problemu sa logovanjem
	public WebElement getLogError(){
		return driver.findElements(By.xpath("//h4//span/following-sibling::text()")).get(1);
	}

}
