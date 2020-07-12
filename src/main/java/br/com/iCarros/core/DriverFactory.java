package br.com.iCarros.core;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.iCarros.pages.PageGenerator;



public class DriverFactory {

	public DriverFactory() {
		// TODO Auto-generated constructor stub
	}

	private static WebDriver driver;
	private static WebDriverWait wait;
	public static PageGenerator page;



	public static WebDriver getDriver(TipoDriver tipo) throws MalformedURLException {
		switch (tipo) {
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "//src//main//drivers/geckodriver");
			if (driver == null) {

				FirefoxOptions opcoes = new FirefoxOptions();
				//opcoes.addArguments("--headless");
				driver = new FirefoxDriver(opcoes);
				page = new PageGenerator(driver);
			}
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//src//main//drivers//chromedriver.exe");
			

			if (driver == null) {
				
				ChromeOptions opcoes = new ChromeOptions();
				//opcoes.addArguments("--headless");
				
				driver = new ChromeDriver(opcoes);
				page = new PageGenerator(driver);
			}
			break;
		default:
			break;
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;

	}


	public static Boolean webDriverNaoNulo() {
		return driver != null;
	}

	public static WebDriver encerraDriver() {
		if (driver != null) {
			driver.quit();
		}
		return driver;
	}

	public static WebDriver closeDriver() {
		if (driver != null) {
			driver.close();
		}
		return driver;
	}
}
