package br.com.projetoAppium.test;

import static br.com.projetoAppium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.projetoAppium.core.BaseTest;
import br.com.projetoAppium.page.MenuPage;

public class OpcaoEscondidaTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();

	@Test
	public void deveEncontrarOpcaoEscondida(){
		//scroll down
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		System.out.println("Começando");
		
		menu.scrollDown();
		
		//clicar menu
		menu.clicarPorTexto("Opção bem escondida");
		
		//verificar mensagem
		Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());
		
		//sair
		menu.clicarPorTexto("OK");
	}
}