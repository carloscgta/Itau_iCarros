package br.com.iCarros.steps;

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

public class LerListaDeResultadoValidarValorAVistaSteps {

	public LerListaDeResultadoValidarValorAVistaSteps() {
		// TODO Auto-generated constructor stub
	}
	
	PDFGenerator pdfgenerator = new PDFGenerator();
	YamlHelper yaml = new YamlHelper();
	
	@Before(value = "@lerListaDeResultadoValidarValorAVista", order = 1)
	public void before(Scenario cenario) throws Exception {
		pdfgenerator.iniciaPDF(cenario);
	}
	
	@Given("^ir para a pagina iCarros$")
	public void ir_para_a_pagina_iCarros() throws Throwable {

		DriverFactory.page.GetInstance(HomeiCarrosPage.class).clicarBotaoOKEntendi();
		pdfgenerator.conteudoPDF("ir_para_a_pagina_iCarros");
		
	}

	@Given("^realizar a escolha da Marca \"([^\"]*)\"$")
	public void realizar_a_escolha_da_Marca(String marca) throws Throwable {

		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarMarca(marca);
		pdfgenerator.conteudoPDF("realizar_a_escolha_da_Marca");		
		
	}

	@Given("^realizar a escolha do Modelo \"([^\"]*)\"$")
	public void realizar_a_escolha_do_Modelo(String modelo) throws Throwable {
	 
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarModelo(modelo);
		pdfgenerator.conteudoPDF("definir_o_Modelo:"+modelo);
		
	}

	@Given("^realizar a escolha do ano Minimo  \"([^\"]*)\" e do ano Maximo \"([^\"]*)\"$")
	public void realizar_a_escolha_do_ano_Minimo_e_do_ano_Maximo(String anoMin, String anoMax) throws Throwable {
	  
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarAnoMin(anoMin);
		pdfgenerator.conteudoPDF("realizar_a_escolha_do_ano_Minimo: "+anoMin);
		
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarAnoMax(anoMax);
		pdfgenerator.conteudoPDF("realizar_a_escolha_do_ano_Maximo: "+anoMax);
		
		
		
	}

	@Given("^realizar a escolha do preco \"([^\"]*)\" e do Preco Maximo \"([^\"]*)\"$")
	public void realizar_a_escolha_do_preco_e_do_Preco_Maximo(String precoMin, String precoMax) throws Throwable {
	 
		
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarPrecoMin(precoMin);
		pdfgenerator.conteudoPDF("realizar_a_escolha_do_preco_e_do_Preco_Maximo: "+precoMin);
		
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarPrecoMax(precoMax);
		pdfgenerator.conteudoPDF("realizar_a_escolha_do_preco_e_do_Preco_Maximo: "+precoMax);
		
		
	}

	@Given("^definir a cidade \"([^\"]*)\"$")
	public void definir_a_cidade(String localidade) throws Throwable {
	  

		DriverFactory.page.GetInstance(HomeiCarrosPage.class).escreverinputCidade(localidade);
		pdfgenerator.conteudoPDF("definir_a_cidade: "+localidade);
		
	}

	@When("^clicar no botao Buscar$")
	public void clicar_no_botao_Buscar() throws Throwable {
	    
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).clicarBotaoBuscar();
		pdfgenerator.conteudoPDF("clicar_no_botao_Buscar");
		
	}

	@Then("^aplicacao deve retornar a lista de resultado da busca com os seguintes dados \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void aplicacao_deve_retornar_a_lista_de_resultado_da_busca_com_os_seguintes_dados(String arg1, String arg2, String arg3, String arg4) throws Throwable {

		DriverFactory.page.GetInstance(HomeiCarrosPage.class).clicarCheckboxCambioAutomcatio();
		
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).pageUp();
		pdfgenerator.conteudoPDF("aplicacao_deve_retornar_a_lista_de_resultado_da_busca_com_os_seguintes_dados");
		
	}
	
	
	
	
	@After(value = "@lerListaDeResultadoValidarValorAVista", order = 2)
	public void finalizaPDF(Scenario cenario) throws Exception {
		pdfgenerator.fechaPDF("Fechar PDF");
	}


}
