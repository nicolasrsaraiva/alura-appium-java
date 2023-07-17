package com.nicolasrsaraiva.tests;

import com.nicolasrsaraiva.AppiumDriverConfig;
import com.nicolasrsaraiva.pageObjects.LoginPage;
import com.nicolasrsaraiva.pageObjects.PagamentoPage;
import com.nicolasrsaraiva.pageObjects.ProdutosPage;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProdutosTest {
    AppiumDriver driver;

    @Before
    public void setUp(){
        driver = AppiumDriverConfig.getInstance().driver;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.preencherFormularioLogin("nicolas", "123");
    }

    @Test
    public void comprarProdutoComSucesso(){
        driver = AppiumDriverConfig.getInstance().driver;
        ProdutosPage produtosPage = new ProdutosPage(driver);
        PagamentoPage pagamentoPage = new PagamentoPage(driver);

        produtosPage.comprarProduto("Camisa");
        pagamentoPage.preencherInformacoesPagamento("213124212", "26/30", "142");
        Assert.assertTrue(pagamentoPage.validarCompraEfetuada());
    }
}
