package com.nicolasrsaraiva.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProdutosPage {
    private AppiumDriver driver;

    public ProdutosPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/detalhes_produto_botao_comprar")
    private MobileElement botaoComprar;


    public void comprarProduto(String nome){
        MobileElement produto = (MobileElement) driver.findElementByXPath("//*[@text='"+nome+"']");
        esperarElemento(produto);
        produto.click();

        MobileElement produtoDetalhado = (MobileElement) driver.findElementByXPath(("//*[@text='"+nome+"']"));
        esperarElemento(produtoDetalhado);

        if(produtoDetalhado.isDisplayed()) {
            esperarElemento(botaoComprar);
            botaoComprar.click();
        }
     }

    public void esperarElemento(MobileElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
