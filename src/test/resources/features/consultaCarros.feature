#encoding UTF-8
#Author: Carlos Almeida - carloscgta@gmail.com
#Feature: List of scenarios

 
@geralConsultaiCarros
Feature: Consulta Carros
 				Eu como usuário gostaria de acessar o site iCarros e realizar uma consulta de carros

  @criarConsultaParaRetornarListaDeOfertas
  Scenario Outline: Acessar site iCarros realizar uma consulta pelo modelo Astra Hatch ano 2008
    Given que estou na pagina de consulta do site iCarros
    And seleciono a Marca "<marca>"
    And seleciono o Modelo "<modelo>"
    And seleciono o ano Minimo  "<anoMinimo>" e Ano Maximo "<anoMaximo>"
    And seleciono o Preco minimo "<precoMin>" e Preco Maximo "<precoMax>"
    And Defino a Localidade "<localidade>"
    When clicar em Buscar
    Then deve retornar lista de carros com os criterios definidos na bsuca exibindo as ofertas
    Examples: 
      | marca  			| modelo 		| anoMinimo  	|anoMaximo  | precoMin 				| precoMax  				|localidade 			 	| 
    	| Chevrolet		|Astra Hatch	|De 2005  		|Até 2008  	| De R$ 14 mil    | Até R$ 20 mil  		|São Paulo - SP  	| 

    	
  @validarModeloEValorAVista
  Scenario Outline: Valide o modelo e o valor a vista do primeiro e do segundo carro da lista produzida pela consulta
    Given acessar a pagina iCarros
    And escolher a Marca "<marca>"
    And definir o Modelo "<modelo>"
    And dedfinir  um  ano Minimo  "<anoMinimo>" e definir o ano Maximo "<anoMaximo>"
    And escolher Preco minimo "<precoMin>" e escolhe o Preco Maximo "<precoMax>"
    And informo a cidade desejada "<localidade>"
    When realizar a busca
    Then na lista de resulta de busca deve ter os seguintes dados "<modeloResultadoListaCarro1>" "<valorAVistaCarro1>" "<modeloResultadoListaCarro2>" "<valorAVistaCarro2>"
    Examples: 
      | marca  			| modelo 		| anoMinimo  	|anoMaximo  | precoMin 				| precoMax  				|localidade 			 	| modeloResultadoListaCarro1		 			 													| valorAVistaCarro1			 	| modeloResultadoListaCarro2															| valorAVistaCarro2			|
    	| Chevrolet		|Astra Hatch	|De 2005  		|Até 2008  	| De R$ 17 mil    | Até R$ 20 mil  		|São Paulo - SP  	| Chevrolet Astra Hatch Advantage 2.0 (Flex) (Aut) 							| R$ 19.890,00 				 		| Chevrolet Astra Hatch Advantage 2.0 (Flex)						 	| R$ 19.900,00 					|
 
   @lerListaDeResultadoValidarValorAVista
  Scenario Outline: Ler a lista de carros criada na tabela anterior validando o valor a Vista
    Given ir para a pagina iCarros
    And realizar a escolha da Marca "<marca>"
    And realizar a escolha do Modelo "<modelo>"
    And realizar a escolha do ano Minimo  "<anoMinimo>" e do ano Maximo "<anoMaximo>"
    And realizar a escolha do preco "<precoMin>" e do Preco Maximo "<precoMax>"
    And definir a cidade "<localidade>"
    When clicar no botao Buscar
    Then aplicacao deve retornar a lista de resultado da busca com os seguintes dados "<modeloResultadoListaCarro1>" "<valorAVistaCarro1>" "<modeloResultadoListaCarro2>" "<valorAVistaCarro2>"
    Examples: 
      | marca  			| modelo 		| anoMinimo  	|anoMaximo  | precoMin 				| precoMax  				|localidade 			 	| modeloResultadoListaCarro1		 			 													| valorAVistaCarro1			 	| modeloResultadoListaCarro2															| valorAVistaCarro2			|
    	| Chevrolet		|Astra Hatch	|De 2005  		|Até 2008  	| De R$ 17 mil    | Até R$ 20 mil  		|São Paulo - SP  	| Chevrolet Astra Hatch Advantage 2.0 (Flex) (Aut) 							| R$ 19.890,00 				 		| Chevrolet Astra Hatch Advantage 2.0 (Flex)						 	| R$ 19.900,00 					|
      
      
      
      
      
      
      