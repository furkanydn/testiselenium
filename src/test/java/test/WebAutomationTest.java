package test;

import base.Base;
import component.MainPage;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WebAutomationTest extends Base {
    static Logger log = Logger.getLogger(Base.class.getName());
    protected String keyComp = "bilgisayar";
    protected String productPrice;
    private MainPage mainPage;

    @BeforeAll
    public void BeforeAll(){
        BeforeMethod();
        mainPage = new MainPage(webDriver);
    }

    @Test
    @Order(1)
    public void CheckAbilityToSearchQuery(){
        try {
            log.info("CheckAbilityToSearchQuery test started");
            log.debug("Typed \"computer\" in the search box.");
            mainPage.searchComputer().sendKeys(keyComp);
            log.debug("Clicked find button.");
            mainPage.submitFind().click();
            webDriverWait = new WebDriverWait(webDriver, Duration.ofMillis(500));
            log.info("CheckAbilityToSearchQuery test finished");
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail(keyComp+" word input test failed.");
            log.info(keyComp+" word input test failed.");
        }
    }

    @Test
    @Order(2)
    public void CheckAbilityToChangeWebsitePage(){
        try {
            log.info("CheckAbilityToChangeWebsitePage test started");
            log.debug("Scrolled page bottom.");
            Scroll();
            log.debug("Changed page number of two.");
            webDriver.get(Base.BaseUrl +"arama/?k=bilgisayar&sf=2");
            webDriverWait = new WebDriverWait(webDriver, Duration.ofMillis(500));
            log.info("CheckAbilityToChangeWebsitePage test finished");
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("Failed to go to page 2");
            log.info("Failed to go to page 2");
        }
        // Check URL Control
        String currentURL = webDriver.getCurrentUrl();
        String expectedURL = "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2";
        log.debug("Expected Url and Actual Url compared");
        Assertions.assertEquals(expectedURL,currentURL);
    }

    @Test
    @Order(3)
    public void CheckAbilityToChooseRandomItem(){
        try {
            log.info("CheckAbilityToChooseRandomItem test started");
            log.debug("Random product selected.");
            mainPage.randomProduct().click();
            webDriverWait = new WebDriverWait(webDriver, Duration.ofMillis(500));
            log.info("CheckAbilityToChooseRandomItem test finished");
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("Cant choose the random item");
            log.info("Cant choose the random item");
        }
    }

    @Test
    @Order(4)
    public void CheckAbilityToWriteProductInfo(){
        try {
            log.info("CheckAbilityToWriteProductInfo test started");
            WebElement[] productDetail = mainPage.getProductDetail();
            log.debug("Product title information received");
            String title = productDetail[0].getText();
            log.debug("Product price information received");
            productPrice = productDetail[1].getText();
            log.debug("Product Title: "+title+" Product Price:"+productPrice);
            webDriverWait = new WebDriverWait(webDriver, Duration.ofMillis(500));
            log.info("CheckAbilityToWriteProductInfo test finished");
        } catch (Exception exception){
            exception.printStackTrace();
            log.info("Cant write the product informations.");
        }
    }

    @Test
    @Order(5)
    public void CheckAbilityToAddProductToBasket(){
        try {
            log.info("CheckAbilityToAddProductToBasket test started");
            log.debug("Adding product to basket...");
            mainPage.addToBasket().click();
            log.debug("Added product to basket.");
            webDriverWait = new WebDriverWait(webDriver, Duration.ofMillis(500));
            log.info("CheckAbilityToAddProductToBasket test finished");
        } catch (Exception exception){
            exception.printStackTrace();
            log.info("Not added product to basket.");
        }
    }

    @Test
    @Order(6)
    public void CheckAbilityToComparePrice(){
        try {
            log.info("CheckAbilityToAddProductToBasket test started");
            log.debug("Clicking basket icon.");
            mainPage.goBasket().click();
            log.debug("Clicked basket icon.");
            log.debug("Getting price of product in basket.");
            String basketPrice = mainPage.getBasketPrice().getText();
            log.debug("Got price of product in basket.");
            log.info("Comparing price of product list and price of product in basket.");
            Assertions.assertEquals(productPrice,basketPrice);
            webDriverWait = new WebDriverWait(webDriver, Duration.ofMillis(500));
            log.info("CheckAbilityToAddProductToBasket test finished");
        } catch (Exception exception){
            exception.printStackTrace();
            log.info("Not compared two item.");
        }
    }

    @Test
    @Order(7)
    public void CheckAbilityToIncreaseProductInBasket(){
        try {
            log.info("CheckAbilityToIncreaseAndDeleteProductInBasket test started");
            WebElement[] getIncreaseProduct = mainPage.getIncreaseProduct();
            getIncreaseProduct[0].click();
            log.info("Increase product amount.");
            getIncreaseProduct[1].click();
            log.debug("Assert that the number of products is 2.");
            Assertions.assertEquals("2",getIncreaseProduct[1].getText());
            webDriverWait = new WebDriverWait(webDriver, Duration.ofMillis(500));
            log.info("CheckAbilityToIncreaseAndDeleteProductInBasket test finished");
        } catch (Exception exception){
            exception.printStackTrace();
            log.info("Cannot increase product amount");
        }
    }

    @Test
    @Order(8)
    public void CheckAbilityToDeleteProductInBasket(){
        try {
            log.info("CheckAbilityToDeleteProductInBasket test started");
            log.debug("Deleting product in basket.");
            mainPage.deleteProductInBasket().click();
            log.debug("Deleted product in basket.");
            webDriverWait = new WebDriverWait(webDriver, Duration.ofMillis(500));
            log.info("CheckAbilityToDeleteProductInBasket test finished");
        } catch (Exception exception){
            exception.printStackTrace();
            log.info("Cannot delete product in basket");
        }
    }

    @AfterAll
    public void AfterAll(){
        AfterMethod();
    }
}
