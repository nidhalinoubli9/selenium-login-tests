import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver(); // Make sure chromedriver is installed
        driver.manage().window().maximize();
    }

    @Test
    public void testSuccessfulLogin() {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button.radius"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        loginBtn.click();

        String message = driver.findElement(By.id("flash")).getText();
        assertTrue(message.contains("You logged into a secure area!"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
