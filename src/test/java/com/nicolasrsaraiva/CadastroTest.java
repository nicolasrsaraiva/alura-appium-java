package com.nicolasrsaraiva;

import com.nicolasrsaraiva.pageObjects.CadastroPage;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CadastroTest {
    @Test
    public void cadastrarUsuarioComSucesso() {
        AppiumDriver driver = AppiumDriverConfig.getInstance().driver;

        CadastroPage cadastroPage = new CadastroPage(driver);

        cadastroPage.clicarBotaoLoginCadastrarUsuario();
        cadastroPage.inserirValorCampoNome("nicolas");
        cadastroPage.inserirValorCampoSenha("123");
        cadastroPage.inserirValorCampoConfirmarSenha("123");
        cadastroPage.clicarBotaoCadastrar();
        assertTrue(cadastroPage.verificarExistenciaBotaoLogar());
    }

    @Test
    public void naoCadastrarUsuarioComSenhasDiferentes() {
        AppiumDriver driver = AppiumDriverConfig.getInstance().driver;
        CadastroPage cadastroPage = new CadastroPage(driver);

        cadastroPage.clicarBotaoLoginCadastrarUsuario();
        cadastroPage.inserirValorCampoNome("saraiva");
        cadastroPage.inserirValorCampoSenha("123");
        cadastroPage.inserirValorCampoConfirmarSenha("321");
        cadastroPage.clicarBotaoCadastrar();

        Assert.assertEquals("Senhas não conferem", cadastroPage.obterMensagemErroCadastro());
        driver.navigate().back();
    }

    @Test
    public void realizarLoginComUsuarioCadastrado(){
        AppiumDriver driver = AppiumDriverConfig.getInstance().driver;

        CadastroPage cadastroPage = new CadastroPage(driver);

        cadastroPage.inserirValorCampoIdUsuario("nicolas");
        cadastroPage.inserirValorCampoSenha("123");
        cadastroPage.clicarBotaoLogar();
        cadastroPage.verificarExistenciaActionBar();
        cadastroPage.clicarBotaoDeslogar();
    }

}
