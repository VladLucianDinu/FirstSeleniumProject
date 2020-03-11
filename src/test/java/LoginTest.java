import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Ignore
    @Test
    public void loginTest() {

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.linkText("ACCOUNT")).click();
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.name("login[username]")).sendKeys("vladselenium@mailinator.com");
        driver.findElement(By.name("login[password]")).sendKeys("vladselenium");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement welcomeMessage = driver.findElement(By.cssSelector("p.hello > strong"));
//        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals("Hello, Vlad Lucian Dinu!", welcomeMessage.getText());

    }

    @After
    public void closeDriver() {
        driver.close();
    }

}