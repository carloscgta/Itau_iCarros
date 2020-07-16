package br.com.iCarros.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "br.com.iCarros.steps", "br.com.iCarros.hooks"}, 
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:src/main/report/cucumber-reports/report.html"},
		 features = {"./src/test/resources/features" }, 
tags = { "@validarModeloEValorAVista" })

public class RunnerConsulta {

}
