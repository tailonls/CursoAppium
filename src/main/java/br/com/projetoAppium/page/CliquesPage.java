package br.com.projetoAppium.page;

import static br.com.projetoAppium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.com.projetoAppium.core.BasePage;

public class CliquesPage extends BasePage {

	public void cliqueLongo(){
		cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
	}
	
	public String obterTextoCampo(){
		return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
}
