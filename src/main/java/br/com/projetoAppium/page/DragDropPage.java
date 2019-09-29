package br.com.projetoAppium.page;

import static br.com.projetoAppium.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;

import br.com.projetoAppium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class DragDropPage extends BasePage {

	public void arrastar(String origem, String destino) {
		MobileElement inicio = getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
		MobileElement fim = getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));
		
		new TouchAction(getDriver())
			.longPress(inicio)
			.moveTo(fim)
			.release()
			.perform();
	}
	
	public String[] obterLista() {
		List<MobileElement> elements = getDriver().findElements(By.className("android.widget.TextView"));
		String[] retorno = new String[elements.size()];
		for(int i = 0; i < elements.size(); i++){
			retorno[i] = elements.get(i).getText();
//			System.out.print("\"" + retorno[i] + "\", ");
		}
		return retorno;
	}
}
