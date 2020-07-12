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

public class ValidarModeloEValorAVistaSteps {

	public ValidarModeloEValorAVistaSteps() {
		// TODO Auto-generated constructor stub
	}
	
	
	PDFGenerator pdfgenerator = new PDFGenerator();
	YamlHelper yaml = new YamlHelper();
	
	@Before(value = "@validarModeloEValorAVista", order = 2)
	public void before(Scenario cenario) throws Exception {
		pdfgenerator.iniciaPDF(cenario);
	}
	
	@Given("^acessar a pagina iCarros$")
	public void acessar_a_pagina_iCarros() throws Throwable {
	   		
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).clicarBotaoOKEntendi();
		pdfgenerator.conteudoPDF("acessar_a_pagina_iCarros");
	}

	@Given("^escolher a Marca \"([^\"]*)\"$")
	public void escolher_a_Marca(String marca) throws Throwable {
	   
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarMarca(marca);
		pdfgenerator.conteudoPDF("seleciono_a Marca");
	}

	@Given("^definir o Modelo \"([^\"]*)\"$")
	public void definir_o_Modelo(String modelo) throws Throwable {
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarModelo(modelo);
		pdfgenerator.conteudoPDF("definir_o_Modelo:"+modelo);
	}

	@Given("^dedfinir  um  ano Minimo  \"([^\"]*)\" e definir o ano Maximo \"([^\"]*)\"$")
	public void dedfinir_um_ano_Minimo_e_definir_o_ano_Maximo(String anoMin, String anoMax) throws Throwable {
	    
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarAnoMin(anoMin);
		pdfgenerator.conteudoPDF("dedfinir_um_ano_Minimo_e_definir_o_ano_Maximo: "+anoMin);
		
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarAnoMax(anoMax);
		pdfgenerator.conteudoPDF("dedfinir_um_ano_Minimo_e_definir_o_ano_Maximo: "+anoMax);
		
	}

	@Given("^escolher Preco minimo \"([^\"]*)\" e escolhe o Preco Maximo \"([^\"]*)\"$")
	public void escolher_Preco_minimo_e_escolhe_o_Preco_Maximo(String precoMin, String precoMax) throws Throwable {
	   
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarPrecoMin(precoMin);
		pdfgenerator.conteudoPDF("seleciono_o_Preco_minimo: "+precoMin);
		
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).selecionarPrecoMax(precoMax);
		pdfgenerator.conteudoPDF("seleciono_o_Preco_maximo: "+precoMax);
	}
	

@Given("^informo a cidade desejada \"([^\"]*)\"$")
public void informo_a_cidade_desejada(String localidade) throws Throwable {
  
	DriverFactory.page.GetInstance(HomeiCarrosPage.class).escreverinputCidade(localidade);
	pdfgenerator.conteudoPDF("informo_a_cidade_desejada: "+localidade);
}

	@When("^realizar a busca$")
	public void realizar_a_busca() throws Throwable {
	   
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).clicarBotaoBuscar();
		pdfgenerator.conteudoPDF("realizar_a_busca");
	}
	
	
	@Then("^na lista de resulta de busca deve ter os seguintes dados \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void na_lista_de_resulta_de_busca_deve_ter_os_seguintes_dados(String modeloResultadoListaCarro1, String valorAVistaCarro1, String modeloResultadoListaCarro2, String valorAVistaCarro2) throws Throwable {
	   
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).clicarCheckboxCambioAutomcatio();
		
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).pageUp();
		
		
		DriverFactory.page.GetInstance(HomeiCarrosPage.class).extrairDadosResultadoBuscaCarrosSalvarArquivo();
		
//		Assert.assertTrue(DriverFactory.page.GetInstance(HomeiCarrosPage.class).validarElementosResutladosBusca(modeloResultadoListaCarro1));
//		pdfgenerator.conteudoPDF("na_lista_de_resulta_de_busca_deve_ter_os_seguintes_dados: "+modeloResultadoListaCarro1);
		
//		Assert.assertTrue(DriverFactory.page.GetInstance(HomeiCarrosPage.class).validarElementosResutladosBusca(valorAVistaCarro1));
//		pdfgenerator.conteudoPDF("na_lista_de_resulta_de_busca_deve_ter_os_seguintes_dados: "+valorAVistaCarro1);
//		
//		Assert.assertTrue(DriverFactory.page.GetInstance(HomeiCarrosPage.class).validarElementosResutladosBusca(modeloResultadoListaCarro2));
//		pdfgenerator.conteudoPDF("na_lista_de_resulta_de_busca_deve_ter_os_seguintes_dados: "+modeloResultadoListaCarro2);
//		
//		Assert.assertTrue(DriverFactory.page.GetInstance(HomeiCarrosPage.class).validarElementosResutladosBusca(valorAVistaCarro2));
//		pdfgenerator.conteudoPDF("na_lista_de_resulta_de_busca_deve_ter_os_seguintes_dados: "+valorAVistaCarro2);
		
		
	}
		
	
	@After(value = "@validarModeloEValorAVista", order = 2)
	public void finalizaPDF(Scenario cenario) throws Exception {
		pdfgenerator.fechaPDF("Fechar PDF");

	}

}
