import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Scenario {
    private final String[] todos = {"Meet a Friend", "Buy Meat", "clean the car", "Visit doctor"};
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;
    private WebDriverWait webDriverWaitVariable;

    public Scenario(WebDriver driver, JavascriptExecutor jsExecutor, WebDriverWait webDriverWaitVariable) {
        this.driver = driver;
        this.jsExecutor = jsExecutor;
        this.webDriverWaitVariable = webDriverWaitVariable;
    }

    public WebElement scenario(String technology) throws InterruptedException{
        // Open the website
        driver.get("https://todomvc.com/");
        Thread.sleep(2000);

        // Select the application based on the technology it's used to create it
        WebElement backBoneLink = webDriverWaitVariable.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText(technology)
                )
        );
        backBoneLink.click();

        // find the input field for todos and add 4 of them
        Thread.sleep(2000);
        WebElement todoInputField = webDriverWaitVariable.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("new-todo")
                )
        );

        for (String todo: this.todos) {
            todoInputField.sendKeys(todo);
            Thread.sleep(1000);
            todoInputField.sendKeys(Keys.RETURN);
            Thread.sleep(2000);
        }

        List<WebElement> checkboxes = driver.findElements(By.className(
                "toggle"
        ));

        // mark first and third item as completed
        checkboxes.get(0).click();
        Thread.sleep(2000);
        checkboxes.get(2).click();
        Thread.sleep(2000);

        // return the number of todos left wrapped in a WebElement object
        WebElement todoCount = driver.findElement(By.className("todo-count"));
        System.out.println(todoCount.getText());
        return todoCount;
    }
}
