package br.com.iCarros.pages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeiCarrosPage extends BasePage {

	public HomeiCarrosPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		
	}
	
/***********************ELEMENTOS FORMULARIO CONSULTA*****************************************/
	
	@FindBy(xpath = "//button[@title='Marca']")
	public WebElement buttonMarca;
	
	@FindBy(xpath = "//*[@id='buscaForm']/div[2]/div[1]/div/div/div/div/div/div/input")
	public WebElement inputMarca;
	
	@FindBy(xpath = "//select[@id='sltMake']")
	public WebElement selectMarca;
	
	
	
	@FindBy(xpath = "//button[@class='btn-message']")
	public WebElement buttonOkEntendi;
	
	@FindBy(xpath = "//button[@title='Modelo']")
	public WebElement buttonModelo;
	@FindBy(xpath = "//*[@id='buscaForm']/div[2]/div[2]/div/div/div/div/div/div/input")
	public WebElement inputModelo;
	
	@FindBy(xpath = "//select[@id='sltModel']")
	public WebElement selectModel;
	
	
	@FindBy(xpath = "(//button[@class='btn dropdown-toggle btn-default'])[3]")
	public WebElement buttonYearMin;
	@FindBy(xpath = "//*[@id='buscaForm']/div[3]/div[1]/div/div/div/div/div/div/input")
	public WebElement inputYearMin;
	@FindBy(xpath = "//select[@id='sltYearMin']")
	public WebElement selectYearMin;
	
	
	@FindBy(xpath = "//button[@title='Ano máx.']")
	public WebElement buttonYearMax;
	@FindBy(xpath = "//*[@id='buscaForm']/div[3]/div[2]/div/div/div/div/div/div/input")
	public WebElement inputYearMax;
	@FindBy(xpath = "//button[@title='Ano máx.']")
	public WebElement selectYearMax;

	@FindBy(xpath = "(//button[@class='btn dropdown-toggle btn-default'])[5]")
	public WebElement buttonPriceMin;
	@FindBy(xpath = "//*[@id='buscaForm']/div[3]/div[3]/div/div/div/div/div/div/input")
	public WebElement inputPriceMin;
	@FindBy(xpath = "//select[@id='sltPriceMin']")
	public WebElement selectPriceMin;
	
	@FindBy(xpath = "//button[@title='Preço máx.']")
	public WebElement buttonPriceMax;
	@FindBy(xpath = "//*[@id='buscaForm']/div[3]/div[4]/div/div/div/div/div/div/input")
	public WebElement inputPriceMax;
	@FindBy(xpath = "//select[@id='sltPriceMax']")
	public WebElement selectPriceMax;
	
	@FindBy(xpath = "//span[@id='cidadeAbertoTexto']")
	public WebElement spanCidade;
	
	@FindBy(xpath = "//input[@id='cidade']")
	public WebElement inputCidade;
	
	
	@FindBy(xpath = "//button[@class='button button--primary button--large button--block']")
	public WebElement buttonBuscar;
	
			
	@FindBy(xpath = "(//*[@id='true']/span)[3]")
	public WebElement checkBoxCambioAutomatico;
	
	

	@FindBy(xpath = "//div[@class='sticky_conteudo']")
	public WebElement divResultadoBusca;
	
	
	@FindBy(xpath = "//ul[@class='listahorizontal']//li")
	public WebElement ulListaResultadosBusca2;
	
	
	@FindBy(xpath = "//ul[@class='listavertical']")
	public WebElement ulListaResultadosBusca3;
			
	@FindBy(xpath = "//ul[@class='listavertical']")
	public List<WebElement> ulListaResultadosBusca;
			
			
	/***********************MÉTODOS*****************************************/
	
	public void clicarBotaoOKEntendi() throws InterruptedException {
		
		click(buttonOkEntendi);
		
		
	}
	
	
	public void selecionarMarca(String textVisible) throws InterruptedException {
		
		click(buttonMarca);
		writeText(inputMarca, textVisible);
		pressionarEnter(inputMarca);
		//selecionarMarcaDoDropDown(selectMarca, textVisible);
		
	}
	
	
	public void selecionarModelo(String textVisible) throws InterruptedException {
		
		click(buttonModelo);
		click(buttonModelo);
		writeText(inputModelo, textVisible);
		pressionarEnter(inputModelo);
//		selecionarItemDroDown(selectModel, textVisible);

	}
	
	public void selecionarAnoMin(String textVisible) throws InterruptedException {

		click(buttonYearMin);
		writeText(inputYearMin, textVisible);
		pressionarEnter(inputYearMin);
//		selecionarItemDroDown(selectYearMin, textVisible);

		

	}
	
	public void selecionarAnoMax(String textVisible) throws InterruptedException {

		click(buttonYearMax);
		writeText(inputYearMax, textVisible);
		pressionarEnter(inputYearMax);
//		selecionarItemDroDown(selectYearMax, textVisible);
		

	}
	
	public void selecionarPrecoMin(String textVisible) throws InterruptedException {

		click(buttonPriceMin);
		writeText(inputPriceMin, textVisible);
		pressionarEnter(inputPriceMin);
//		selecionarItemDroDown(selectPriceMin, textVisible);
		
		
	}
	
	public void selecionarPrecoMax(String textVisible) throws InterruptedException {

		click(buttonPriceMax);
		writeText(inputPriceMax, textVisible);
		pressionarEnter(inputPriceMax);
//		selecionarItemDroDown(selectPriceMax, textVisible);
	
	}

public void clicarBotaoBuscar() throws InterruptedException {
		
		click(buttonBuscar);
	}

public void escreverinputCidade(String texto) throws InterruptedException {
	
	click(spanCidade);
	writeText(inputCidade, texto);
}

public void clicarCheckboxCambioAutomcatio() throws InterruptedException {
	moverParaElemento(checkBoxCambioAutomatico);
	click(checkBoxCambioAutomatico);
	
}

public boolean validarElementosResutladosBusca(String texto) throws InterruptedException {

	boolean result = false;
	
	List<WebElement> allElements = ulListaResultadosBusca;

	for (WebElement element: allElements) {
	      System.out.println(element.getText());
	    
	      if(element.getText().contains(texto)) {
	    	  System.out.println("Contém o: "+texto);
	    	  result = true;
	      }
	      else {
	    		  return false;
	    	  }
	    	
	}
	
	
	return result;
	
}



public  boolean validarResultado(String numOfertas) throws InterruptedException {
	
	boolean result = false;
	moverParaElemento(divResultadoBusca);
	String textoDivDigital = divResultadoBusca.getText();
	System.out.println(textoDivDigital);
	if(textoDivDigital.contains(numOfertas)){
		
		result = true;
	}else {
		
		result = false;
	}
				
	return result;
	
	
}

public void pageUp() throws InterruptedException {
	moverParaElemento(divResultadoBusca);
	pressionarPageUP();
	pressionarPageUP();
	pressionarPageUP();
	pressionarPageUP();
	pressionarPageUP();
	
	
}


public void extrairDadosResultadoBuscaCarrosSalvarArquivo() throws InterruptedException, IOException {

	
	String textoDivResultadoBusca = ulListaResultadosBusca3.getText();
    System.out.println(textoDivResultadoBusca);


    String csvOutputFile = "tableResultadoBuscaiCarros.csv";

    try(FileWriter writecsv = new FileWriter("src/main/tableResultadoBuscaiCarros.csv")) {
        writecsv.append(textoDivResultadoBusca);
    }
	
	
}


public void salvarTextoEmTXTFile(){

String infoResultadoBuscaCarros =  ulListaResultadosBusca3.getText();
System.out.println(infoResultadoBuscaCarros);

File file = new File("src/main/infoResultadoBuscaCarros.text");

try {
  FileWriter fw = new FileWriter(file, true);
  fw.write(infoResultadoBuscaCarros);
  fw.flush();
  fw.close();
} catch (IOException e) {
  e.printStackTrace();
  System.out.println(e);
}

}

}
