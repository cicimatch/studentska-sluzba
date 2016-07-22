package ivanVojnovic.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	// Helper koji pravi screenshot
	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
	}

	// Helper za element koji čekamo da bude klikabilan
	public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval))
				.until(ExpectedConditions.elementToBeClickable(selector));
		return element;
	}

	// Helper za element koji čekamo da se pojavi u DOM stablu
	public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval))
				.until(ExpectedConditions.presenceOfElementLocated(selector));
		return element;
	}

	// Helper za element koji čekamo da se pojavi title (ono gore u tabu)
	public static void waitForTitle(WebDriver driver, String title, int waitInterval) {
		(new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.titleIs(title));
	}

	// Helper da li n element (npr index) hvata exeption ako nije u DOM-u (inače ga čeka)
	public static boolean isPresent(WebDriver webdriver, By selector) {

		try {
			webdriver.findElement(selector);
		} catch (NoSuchElementException e) {

			return false;
		}
		return true;
	}

}
