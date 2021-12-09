import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ScenarioTest {
    private static WebDriver driver;
    private JavascriptExecutor jsExecutor;
    private WebDriverWait waitingVariable;
    private Scenario lab;

    @BeforeAll
    public static void initialize(){
        WebDriverManager.chromedriver().browserVersion("77.0.3865.40").setup();
    }

    @BeforeEach
    public void setDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        jsExecutor = (JavascriptExecutor) driver;
        waitingVariable = new WebDriverWait(driver, 50);
        lab = new Scenario(driver, jsExecutor, waitingVariable);
    }

    @Test
    public void testScript() throws InterruptedException{
        WebElement todoCount = lab.scenario("Backbone.js");
        ExpectedConditions.textToBePresentInElement(todoCount, "2 items left");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Backbone.js", "AngularJS", "React"})
    public void parametrizedTestScript(String technology) throws InterruptedException{
        WebElement todoCount = lab.scenario(technology);
        ExpectedConditions.textToBePresentInElement(todoCount, "2 items left");
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }
}
