package com.nicolasrsaraiva.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPage {
    private AppiumDriver driver;

    public CadastroPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_nome")
    private MobileElement campoNome;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_usuario")
    private MobileElement campoIdDoUsuario;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_senha")
    private MobileElement campoSenha;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/login_botao_logar")
    private MobileElement botaoLogar;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario")
    private MobileElement botaoLoginCadastrarUsuario;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_confirmar_senha")
    private MobileElement campoConfirmarSenha;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar")
    private MobileElement botaoCadastrar;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/action_bar")
    private MobileElement actionBar;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/menu_principal_deslogar")
    private MobileElement botaoDeslogar;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/erro_cadastro")
    private MobileElement mensagemErroCadastro;

    public void cadastrarUsuarioComSucesso(String nome, String senha){
        esperarElemento(campoNome);
        campoNome.sendKeys(nome);
        esperarElemento(campoSenha);
        campoSenha.sendKeys(senha);
        esperarElemento(campoConfirmarSenha);
        campoConfirmarSenha.sendKeys(senha);
        esperarElemento(botaoCadastrar);
        botaoCadastrar.click();
    }

    public void naoCadastrarUsuarioComSenhasDiferentes(String nome, String senha, String senhaErrada) {
        esperarElemento(campoNome);
        campoNome.sendKeys(nome);
        esperarElemento(campoSenha);
        campoSenha.sendKeys(senha);
        esperarElemento(campoConfirmarSenha);
        campoConfirmarSenha.sendKeys(senhaErrada);
        esperarElemento(botaoCadastrar);
        botaoCadastrar.click();
    }

    public void clicarBotaoLoginCadastrarUsuario(){
        esperarElemento(botaoLoginCadastrarUsuario);
        botaoLoginCadastrarUsuario.click();
    }

    public boolean verificarExistenciaBotaoLogar(){
        esperarElemento(botaoLogar);
        return botaoLogar.isDisplayed();
    }

    public String obterMensagemErroCadastro(){
        esperarElemento(mensagemErroCadastro);
        return mensagemErroCadastro.getText();
    }

    public void esperarElemento(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
