package com.nicolasrsaraiva.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagamentoPage {
    private AppiumDriver driver;

    public PagamentoPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/pagamento_numero_cartao")
    private MobileElement campoNumeroCartao;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/pagamento_data_validade")
    private MobileElement campoDataValidade;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/pagamento_cvc")
    private MobileElement campoCVC;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/pagamento_botao_confirma_pagamento")
    private MobileElement botaoConfirmarPagamento;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/listaPagamentos")
    private MobileElement botaoListaPagamentos;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/item_pagamento_id")
    private MobileElement itemPagamento;

    public void preencherInformacoesPagamento(String numeroCartao, String dataValidade, String cvc){

        Actions actions = new Actions(driver);

        esperarElemento(campoNumeroCartao);
        actions.click(campoNumeroCartao).perform();
        actions.sendKeys(numeroCartao).perform();

        esperarElemento(campoDataValidade);
        actions.click(campoDataValidade).perform();
        actions.sendKeys(dataValidade).perform();

        esperarElemento(campoCVC);
        actions.click(campoCVC).perform();
        actions.sendKeys(cvc).perform();

        esperarElemento(botaoConfirmarPagamento);
        botaoConfirmarPagamento.click();
    }

    public boolean validarCompraEfetuada(){
        esperarElemento(botaoListaPagamentos);
        botaoListaPagamentos.click();

        esperarElemento(itemPagamento);
        return itemPagamento.getText().equals("1");
    }

    public void esperarElemento(MobileElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
