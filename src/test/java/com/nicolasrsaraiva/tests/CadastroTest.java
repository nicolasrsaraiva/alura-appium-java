package com.nicolasrsaraiva.tests;

import com.nicolasrsaraiva.AppiumDriverConfig;
import com.nicolasrsaraiva.pageObjects.CadastroPage;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CadastroTest {

    AppiumDriver driver;

    @Test
    public void cadastrarUsuarioComSucesso() {
        driver = AppiumDriverConfig.getInstance().driver;

        CadastroPage cadastroPage = new CadastroPage(driver);

        cadastroPage.clicarBotaoLoginCadastrarUsuario();
        cadastroPage.cadastrarUsuarioComSucesso("nicolas", "123");

        assertTrue(cadastroPage.verificarExistenciaBotaoLogar());
    }

    @Test
    public void naoCadastrarUsuarioComSenhasDiferentes() {
        driver = AppiumDriverConfig.getInstance().driver;
        CadastroPage cadastroPage = new CadastroPage(driver);

        cadastroPage.clicarBotaoLoginCadastrarUsuario();
        cadastroPage.naoCadastrarUsuarioComSenhasDiferentes("nicolas", "123", "321");

        Assert.assertEquals("Senhas não conferem", cadastroPage.obterMensagemErroCadastro());
        driver.navigate().back();
    }
}
