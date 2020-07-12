package br.com.iCarros.pages;

import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageGenerator {
	
	
	public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	Properties prop = new Properties();

	// If we need we can use custom wait in BasePage and all page classes

	WebDriverWait wait = new WebDriverWait(this.driver, 40);
 
	// Click Method by using JAVA Generics (You can use both By or Webelement)


	public <T> void esperarAntesDeClicar(T elementAttr) throws InterruptedException {
		
		waitForElement(elementAttr);

	        
	}
	
	
	public <T> void click(T elementAttr) throws InterruptedException {

		waitForElement(elementAttr);
		((WebElement) elementAttr).click();

	}
	
	public <T> void pressionarEnter(T elementAttr) throws InterruptedException {

		waitForElement(elementAttr);
		((WebElement) elementAttr).sendKeys(Keys.ENTER);

	}
	
	// Wait generic method

	public <T> void waitForElement(T elementAttr) throws InterruptedException {
		//moverParaElemento(elementAttr);
		wait.until(ExpectedConditions. visibilityOf((WebElement) elementAttr));
		
		((WebElement) elementAttr).isDisplayed();
	}

	public <T> Boolean elementIsDisplayed(T elementAttr) throws InterruptedException {
		moverParaElemento(elementAttr);
		Boolean  isDisplayed=false;
		if(((WebElement) elementAttr).isDisplayed()) {
			 isDisplayed=true;
		}
		
		return isDisplayed;
	}

	
	// Write Text by using JAVA Generics (You can use both By or Webelement)

	public <T> void writeText(T elementAttr, String text) throws InterruptedException {
		moverParaElemento(elementAttr);
		((WebElement) elementAttr).sendKeys(text);

	}

	// Write Text by using JAVA Generics (You can use both By or Webelement)

	public <T> void clearText(T elementAttr) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));

		((WebElement) elementAttr).clear();

		((WebElement) elementAttr).sendKeys("");

	}

	
	// Read Text by using JAVA Generics (You can use both By or Webelement)

	public <T> String readText(T elementAttr) {

		wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));

		return ((WebElement) elementAttr).getText();
	

	}

	// Check if the element is visible (You can use both By or Webelement)

	public <T> boolean elementVisible(T elementAttr) {

		wait.until(ExpectedConditions.elementToBeClickable((WebElement) elementAttr));

		boolean b = false;

		try {

			if (((WebElement) elementAttr).isDisplayed()) {

				b = true;

			}

		} catch (Exception e) {

			return false;

		}

		return b;

	}

	public <T> void scrollToElement(T elementAttr) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ((WebElement) elementAttr));

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("window.scrollBy(0,200)", "");
	}
	
	
	

	public <T> void moverParaElemento(T elementAttr) throws InterruptedException {

		Actions builder = new Actions(driver);
		builder.moveToElement((WebElement) elementAttr).perform();
		
	}
	
	public <T> boolean listaUlElementos(T elementAttr, String texto) throws InterruptedException {
		
		boolean result = false;
		
		@SuppressWarnings("unchecked")
		List<WebElement> allElements = (List<WebElement>) driver.findElement((By) elementAttr); 

		for (WebElement element: allElements) {
		      System.out.println(element.getText());
		      if(element.getText().contains(texto))
		    	  result = true;
		    	  else
		    	  return false;
		}
		
		
		return result;
		
		
	}
	
	
	
	
	public <T> void pressionarPageUP() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor)driver;  
		jse.executeScript("scroll(400, 0)");
	}
	
	

	public <T> void dismissAlertPopup() throws InterruptedException {

		wait.until(ExpectedConditions.alertIsPresent());

		driver.switchTo().alert().dismiss();

	}

	
	// Read Text by using JAVA Generics (You can use both By or Webelement)

	public <T> void selectElement(T elementAttr, int index) {

		
		@SuppressWarnings("unchecked")
		List<WebElement> elements = (List<WebElement>) elementAttr;

		elements.get(index).click();

	}
	
	public <T> void selecionarMarcaDoDropDown(T elementAttr,String visibleText) {

		Select elementsOptionMarcas = new Select((WebElement) elementAttr);
		elementsOptionMarcas.selectByVisibleText(visibleText);

	}
	
	
	
	public <T> void selecionarItemDroDown(T elementAttr,String visibleText) throws InterruptedException {
		
		waitForElement(elementAttr);
		Select elementsOptionMarcas = new Select((WebElement) elementAttr);
		elementsOptionMarcas.selectByVisibleText(visibleText);

	}
	
	

	
	public <T> void selectGeneric(T elementAttr, String index) throws InterruptedException {
		
		moverParaElemento(elementAttr);
		Select selectMes = new Select((WebElement) elementAttr);
		selectMes.selectByVisibleText(index);
		
	
	}
	
	
		
	

}
