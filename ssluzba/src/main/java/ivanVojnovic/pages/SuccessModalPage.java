package ivanVojnovic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ivanVojnovic.pages.Utils;

public class SuccessModalPage {

	//Konstruktor
	private WebDriver driver;
	public SuccessModalPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	//Modal koji se pojavljuje u gornjem desnom uglu za uspešno dodavanje
	public WebElement getModal() {
		return Utils.waitForElementPresence(driver,By.xpath("//h4[text()='SUCCESS']/.."),10);
		
	}
	
	//Dugme X na Modalu
	public WebElement getmodalX() {
		return Utils.waitForElementPresence(driver,By.xpath("//span[@class='fa fa-times']"),10);
	}
	//Dugme play or pause
	public WebElement getmodalP() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[@class='fa fa-play']"), 10);
	}
	
	//Model nestaje
	public void exitModal() {
		Actions action = new Actions(driver);
		WebElement modal = this.getModal();
		action.moveToElement(modal).build().perform();
		this.getmodalX().click();
	}
	
	//Proverava da li je modal prisutan u DOM stablu
	public boolean isPresentModal() {
		return Utils.isPresent(driver, By.xpath("//h4[text()='SUCCESS']/.."));
	}
	
}
