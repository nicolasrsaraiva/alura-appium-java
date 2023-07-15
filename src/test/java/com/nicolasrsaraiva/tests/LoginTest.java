package com.nicolasrsaraiva.tests;

import com.nicolasrsaraiva.AppiumDriverConfig;
import com.nicolasrsaraiva.pageObjects.LoginPage;
import io.appium.java_client.AppiumDriver;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {

    @Test
    public void realizarLoginComUsuarioCadastrado(){
        AppiumDriver driver = AppiumDriverConfig.getInstance().driver;

        LoginPage loginPage = new LoginPage(driver);

        loginPage.preencherFormularioLogin("nicolas", "123");

        loginPage.verificarExistenciaActionBar();
        loginPage.deslogarUsuario();
        loginPage.verificarUsuarioTelaLogin();
    }

    @Test
    public void naoRealizarLoginComUsarioSemCadastro(){
        AppiumDriver driver = AppiumDriverConfig.getInstance().driver;

        LoginPage loginPage = new LoginPage(driver);

        loginPage.preencherFormularioLogin("nicolas", "321");
    }
}
