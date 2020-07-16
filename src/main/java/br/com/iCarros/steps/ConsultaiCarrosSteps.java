package br.com.iCarros.steps;


import org.junit.Assert;

import br.com.iCarros.core.DriverFactory;
import br.com.iCarros.core.PDFGenerator;
import br.com.iCarros.core.YamlHelper;
import br.com.iCarros.pages.HomeiCarrosPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultaiCarrosSteps {

	public ConsultaiCarrosSteps() {
	
	}
	String modeloCarroResult;
	
	PDFGenerator pdfgenerator = new PDFGenerator();
	YamlHelper yaml = new YamlHelper();
	
	@Before(value = "@criarConsultaParaRetornarListaDeOfertas", order = 1)
	public void before(Scenario cenario) throws Exception {
		pdfgenerator.iniciaPDF(cenario);
	}
	

	@Given("^que estou na pagina de consulta do site iCarros$")
	public void que_estou_na_pagina_de_consulta_do_site_iCarros() throws Throwable {
		
		
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).clicarBotaoOKEntendi();
		pdfgenerator.conteudoPDF("que_estou_na_pagina_de_consulta_do_site_iCarros");
	}

	@Given("^seleciono a Marca \"([^\"]*)\"$")
	public void seleciono_a_Marca(String marca) throws Throwable {
	
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarMarca(marca);
		
		pdfgenerator.conteudoPDF("seleciono_a Marca");
	}

	@Given("^seleciono o Modelo \"([^\"]*)\"$")
	public void seleciono_o_Modelo(String modelo) throws Throwable {
	  
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarModelo(modelo);
		modeloCarroResult = modelo;
		pdfgenerator.conteudoPDF("seleciono_o_Modelo:"+modelo);
	}

	@Given("^seleciono o ano Minimo  \"([^\"]*)\" e Ano Maximo \"([^\"]*)\"$")
	public void seleciono_o_ano_Minimo_e_Ano_Maximo(String anoMin, String anoMax) throws Throwable {
	    
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarAnoMin(anoMin);
		pdfgenerator.conteudoPDF("seleciono_o_ano_Minimo_e_Ano_Maximo: "+anoMin);
		
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarAnoMax(anoMax);
		pdfgenerator.conteudoPDF("seleciono_o_ano_Minimo_e_Ano_Maximo: "+anoMax);
		
	}

	@Given("^seleciono o Preco minimo \"([^\"]*)\" e Preco Maximo \"([^\"]*)\"$")
	public void seleciono_o_Preco_minimo_e_Preco_Maximo(String precoMin, String precoMax) throws Throwable {
	   
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarPrecoMin(precoMin);
		pdfgenerator.conteudoPDF("seleciono_o_Preco_minimo: "+precoMin);
		
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarPrecoMax(precoMax);
		pdfgenerator.conteudoPDF("seleciono_o_Preco_maximo: "+precoMax);
		
	}

	@Given("^Defino a Localidade \"([^\"]*)\"$")
	public void defino_a_Localidade(String localidade) throws Throwable {
	    
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).escreverinputCidade(localidade);
		pdfgenerator.conteudoPDF("defino_a_Localidade: "+localidade);
		
	}

	@When("^clicar em Buscar$")
	public void clicar_em_Buscar() throws Throwable {
	    
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).clicarBotaoBuscar();

	}
	
	@Then("^deve retornar lista de carros com os criterios definidos na bsuca exibindo as ofertas$")
	public void deve_retornar_lista_de_carros_com_os_criterios_definidos_na_bsuca_exibindo_as_ofertas() throws Throwable {
	DriverFactory.page.GetInstance(HomeiCarrosPage.class).clicarCheckboxCambioAutomcatio();
		
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).pageUp();
		
		Assert.assertTrue(DriverFactory.page.GetInstance(HomeiCarrosPage.class).validarResultado(modeloCarroResult));
		pdfgenerator.conteudoPDF("deve_retorna_lista_de_carros_com_os_criterios_definidos_na_bsuca");
	}
	
	
	
	
	@After(value = "@criarConsultaParaRetornarListaDeOfertas", order = 2)
	public void finalizaPDF(Scenario cenario) throws Exception {
		pdfgenerator.fechaPDF("Fechar PDF");
	}

}
