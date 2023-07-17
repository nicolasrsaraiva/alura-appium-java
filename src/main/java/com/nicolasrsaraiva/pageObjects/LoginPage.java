package com.nicolasrsaraiva.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private AppiumDriver driver;

    public LoginPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_usuario")
    private MobileElement campoIdDoUsuario;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_senha")
    private MobileElement campoSenha;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/login_botao_logar")
    private MobileElement botaoLogar;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/action_bar")
    private MobileElement actionBar;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/menu_principal_deslogar")
    private MobileElement botaoDeslogar;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/mensagem_erro_login")
    private MobileElement msgErroLogin;

    public boolean verificarExistenciaActionBar(){
        esperarElemento(actionBar);
        return actionBar.isDisplayed();
    }

    public boolean verificarUsuarioTelaLogin(){
        esperarElemento(botaoLogar);
        return botaoLogar.isDisplayed();
    }

    public void preencherFormularioLogin(String login, String senha){
        esperarElemento(campoIdDoUsuario);
        campoIdDoUsuario.sendKeys(login);
        esperarElemento(campoSenha);
        campoSenha.sendKeys(senha);
        esperarElemento(botaoLogar);
        botaoLogar.click();
    }

    public void deslogarUsuario(){
        esperarElemento(botaoDeslogar);
        botaoDeslogar.click();
    }

    public boolean verificarExistenciaMsgErroLogin(){
        esperarElemento(msgErroLogin);
        return msgErroLogin.isDisplayed();
    }

    public void esperarElemento(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
