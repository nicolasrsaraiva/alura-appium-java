package com.nicolasrsaraiva;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CadastroTest {
    @Test
    public void cadastrarUsuarioComSucesso() {
        AppiumDriver driver = AppiumDriverConfig.getInstance().driver;

        MobileElement botaoCadastrarUsuario = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastrarUsuario.click();
        MobileElement campoNome = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        MobileElement campoSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        MobileElement campoConfirmarSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        MobileElement botaoCadastrar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");

        campoNome.sendKeys("nicolas");
        campoSenha.sendKeys("123");
        campoConfirmarSenha.sendKeys("123");
        botaoCadastrar.click();

        MobileElement botaoLogar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");

        assertTrue(botaoLogar.isDisplayed());
    }

    public void cadastrarUsuarioExistente() {
        AppiumDriver appiumDriver = AppiumDriverConfig.getInstance().driver;
    }

    @Test
    public void naoCadastrarUsuarioComSenhasDiferentes() {
        AppiumDriver driver = AppiumDriverConfig.getInstance().driver;

        MobileElement botaoCadastrarUsuario = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastrarUsuario.click();
        MobileElement campoNome = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        MobileElement campoSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        MobileElement campoConfirmarSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        MobileElement botaoCadastrar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");

        campoNome.sendKeys("nicolas");
        campoSenha.sendKeys("123");
        campoConfirmarSenha.sendKeys("321");
        botaoCadastrar.click();

        MobileElement msgErro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");

        Assert.assertEquals("Senhas não conferem", msgErro.getText());
        driver.navigate().back();
    }
}
