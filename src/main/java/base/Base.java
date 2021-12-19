package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    protected static WebDriver webDriver;
    protected static WebDriverWait webDriverWait;
    public static String BaseUrl = "https://www.gittigidiyor.com/";

    /**
     * BeforeAll is used to signal that the annotated method should be executed before all tests in the current test class.
     *
     * @see <a href="https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/BeforeAll.html">Annotation Interface BeforeAll</a>
     * for more details.
     */
    @BeforeAll
    protected static void BeforeMethod(){
        System.setProperty("webdriver.chrome.driver","libraries/chromedriver.exe");
        ChromeOptions cOptions = new ChromeOptions();
        cOptions.addArguments("--disable-notifications");
        webDriver = new ChromeDriver(cOptions);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Bazı durumlarda 'navigate' daha mantıklı olabilir.
        webDriver.get(BaseUrl);
    }

    /**
     * Indicates that a driver can execute JavaScript, providing access to the mechanism to do so.
     * Because of cross domain policies browsers enforce your script execution may fail unexpectedly and without adequate error messaging. This is particularly pertinent when creating your own XHR request or when trying to access another frame. Most times when troubleshooting failure it's best to view the browser's console after executing the WebDriver request.
     * Set the position of the current window.
     * <p>
     * See <a href="https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/JavascriptExecutor.html">Interface JavascriptExecutor</a>
     * for more details.
     */
    protected static void Scroll(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        //Sayfanın sonuna gitmesi içi yapıldı daha sonra enum eklenerek geliştirilebilir.
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //https://www.nngroup.com/articles/response-times-3-important-limits/
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    /**
     * AfterAll is used to signal that the annotated method should be executed after all tests in the current test class.
     *
     * @see <a href="https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/AfterAll.html">Annotation Interface AfterAll</a>
     * for more details.
     */
    @AfterAll
    protected static void AfterMethod(){
        webDriver.quit();
    }
}
