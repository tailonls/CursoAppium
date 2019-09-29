package br.com.projetoAppium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.projetoAppium.core.BaseTest;
import br.com.projetoAppium.page.CliquesPage;
import br.com.projetoAppium.page.MenuPage;

public class CliquesTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();
	
	@Before
	public void setup(){
		menu.acessarCliques();
	}
	
	@Test
	public void deveRealizarCliqueLongo(){
		//clique longo
		page.cliqueLongo();
		
		//verificar texto
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}
	
	@Test
	public void deveRealizarCliqueDuplo(){
		page.clicarPorTexto("Clique duplo");
		page.clicarPorTexto("Clique duplo");
		
		Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
	}
}
