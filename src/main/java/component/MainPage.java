package component;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    WebDriver webDriver;

    public MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
        Assertions.assertNotNull(webDriver,"Driver 'webDriver' is null.");
    }
    //data-cy header-search-input olan web elemanını arayacaktır.
    public WebElement searchComputer(){
        return webDriver.findElement(By.xpath("//input[@data-cy='header-search-input']"));
    }

    //data-cy search-find-button olan web elemanını arayacaktır.
    public WebElement submitFind(){
        return webDriver.findElement(By.xpath("//*[@data-cy='search-find-button']"));
    }

    public WebElement randomProduct(){
        List<WebElement> list = webDriver.findElements(By.cssSelector("div.pmyvb0-0 li"));
        return list.get((int) (Math.random() * list.size()));
    }

    public WebElement[] getProductDetail(){
        WebElement[] webElements = new WebElement[2];
        webElements[0] =  webDriver.findElement(By.id("sp-title"));
        webElements[1] = webDriver.findElement(By.id("sp-price-lowPrice"));
        return webElements;
    }

    public WebElement addToBasket(){
        return webDriver.findElement(By.id("add-to-basket"));
    }

    public WebElement goBasket(){
        return webDriver.findElement(By.className("header-cart-hidden-link"));
    }

    public WebElement getBasketPrice(){
        return webDriver.findElement(By.className("total-price"));
    }

    //todo Sorunlu olabilir üzerine geliştirme gelmesi lazım :)
    public WebElement[] getIncreaseProduct(){
        //todo
        WebElement[] webElements = new WebElement[2];
        webElements[0] = webDriver.findElement(By.className("umber-selection gg-form-item"));
        webElements[1] = webDriver.findElement(By.className("//*[@id=\"cart-item-515713503\"]/div[1]/div[4]/div/div[2]/select/option[2]"));
        return webElements;
    }

    public WebElement deleteProductInBasket(){
        //todo
        return webDriver.findElement(By.className("btn-delete btn-update-item"));
    }
}