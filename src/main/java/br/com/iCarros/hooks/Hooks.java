package br.com.iCarros.hooks;

import org.junit.AfterClass;

import br.com.iCarros.core.DriverFactory;
import br.com.iCarros.core.PDFGenerator;
import br.com.iCarros.core.TipoDriver;
import br.com.iCarros.core.YamlHelper;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class Hooks {

	public Hooks() {
		// TODO Auto-generated constructor stub
	}
	
	PDFGenerator pdfgenerator;
	YamlHelper yamlhelper = new YamlHelper();
	
	
	@Before
	public void antesScenario(Scenario cenario) throws Exception {
		
		System.out.println("This will run before the Scenario");
		DriverFactory.getDriver(TipoDriver.CHROME)
		.get("https://www.icarros.com.br/principal/index.jsp");
		
		
	}

	
	@AfterClass
	public void depoisScenario(Scenario cenario) throws Exception {
		 System.out.println("This will run after the Scenario");
		 DriverFactory.encerraDriver();
		 
	}

}
