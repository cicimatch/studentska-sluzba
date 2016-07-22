package ivanVojnovic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ivanVojnovic.pages.Utils;

public class MenuPage {
	public WebDriver driver;
	public MenuPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public String getMinisText(){
		return Utils.waitForElementPresence(driver, By.xpath("//span[@class='logo-lg']/b"), 10).getText();
	}
	
	public WebElement getIstrazivaciLink() {
		return Utils.waitForElementPresence(driver, By.xpath("//a[@ui-sref='persons']"), 10);
	}
	
	public WebElement getInstitucijaLink() {
		return Utils.waitForElementPresence(driver, By.xpath("//a[@ui-sref='adminInstitution']"), 10);
	}
	
	//ovde su dugmad vezana za odjavu
	public WebElement getGrb() {
		return Utils.waitForElementPresence(driver, By.xpath("//a[@class='dropdown-toggle']"), 10);
	}
	
	public WebElement getOdjava() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[@translate='LOGOUT']"), 10);
	}
	
	
	


}
