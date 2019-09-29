package br.com.projetoAppium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTeste {

	@Test
	public void deveSomarDoisValores() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		desiredCapabilities.setCapability("appActivity", ".Calculator");

		AndroidDriver<MobileElement> driver = null;
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

		} catch (MalformedURLException e) {
			System.out.println("Erro ao iniciar driver do Appium: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}

		try {
			MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
			el3.click();
			MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("plus");
			el4.click();
			MobileElement el5 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
			el5.click();
			MobileElement el6 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");

			System.out.println("Resultado da soma: " + el6.getText());

			Assert.assertEquals("4", el6.getText());

		} catch (Exception e) {
			System.out.println("Erro ao interagir com elementos da tela: " + e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}

		driver.quit();
	}
}
