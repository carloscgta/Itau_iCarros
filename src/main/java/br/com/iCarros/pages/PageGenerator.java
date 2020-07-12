package br.com.iCarros.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.iCarros.core.DriverFactory;



public class PageGenerator extends DriverFactory {



	public WebDriver driver;


	//JAVA Generics to Create and return a New Page

    public PageGenerator(WebDriver driver) {
		// TODO Auto-generated constructor stub
    	this.driver= driver;
    }

	public  <TPage extends BasePage> TPage GetInstance (Class<TPage> Pageclass) throws Exception {

        try {

           //Initialize the Page with its elements and return it.

            return PageFactory.initElements(driver,  Pageclass);

        } catch (Exception e) {

            e.printStackTrace();
            
            throw e;

        }

    }
	
	
}
