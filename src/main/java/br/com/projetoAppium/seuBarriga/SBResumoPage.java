package br.com.projetoAppium.seuBarriga;

import static br.com.projetoAppium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.com.projetoAppium.core.BasePage;
import io.appium.java_client.MobileElement;

public class SBResumoPage extends BasePage {

	public void excluirMovimentacao(String desc) {
		MobileElement el = getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
		swipeElement(el, 0.9, 0.1);
		clicarPorTexto("Del");
	}
}
