package com.nicolasrsaraiva;

import io.appium.java_client.MobileElement;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertTrue;

public class CadastroTest {
    @Test
    public void cadastrarUsuarioComSucesso() throws MalformedURLException {
        AppiumDriverConfig appiumDriver = new AppiumDriverConfig();
        MobileElement botaoCadastrarUsuario = (MobileElement) appiumDriver.driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastrarUsuario.click();
        MobileElement campoNome = (MobileElement)appiumDriver.driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        campoNome.sendKeys("nicolas");
        MobileElement campoSenha = (MobileElement)appiumDriver.driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        campoSenha.sendKeys("123");
        MobileElement campoConfirmarSenha = (MobileElement)appiumDriver.driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        campoConfirmarSenha.sendKeys("123");
        MobileElement botaoCadastrar = (MobileElement)appiumDriver.driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
        botaoCadastrar.click();
        MobileElement botaoLogar = (MobileElement)appiumDriver.driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");
        assertTrue(botaoLogar.isDisplayed());
    }

    public void naoCadastrarUsarioComSenhasDiferentes() throws MalformedURLException {
        AppiumDriverConfig appiumDriver = new AppiumDriverConfig();
    }
}
