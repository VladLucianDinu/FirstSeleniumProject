import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegisterTest {

    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    @Ignore
    @Test
    public void registerNewUserTest() {

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("div > ul > li > a[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Vlad");
        driver.findElement(By.id("middlename")).sendKeys("Lucian");
        driver.findElement(By.id("lastname")).sendKeys("Dinu");
        driver.findElement(By.id("email_address")).sendKeys("newuser1@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("newuser");
        driver.findElement(By.id("confirmation")).sendKeys("newuser");
        driver.findElement(By.cssSelector("label[for='is_subscribed']")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        WebElement succesMessage = driver.findElement(By.cssSelector("li.success-msg span"));
        Assert.assertTrue(succesMessage.isDisplayed());
    }

    @Ignore
    @Test
    public void registerWithExistingAccountTest() {

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("div > ul > li > a[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Vlad");
        driver.findElement(By.id("middlename")).sendKeys("Lucian");
        driver.findElement(By.id("lastname")).sendKeys("Dinu");
        driver.findElement(By.id("email_address")).sendKeys("newuser1@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("newuser");
        driver.findElement(By.id("confirmation")).sendKeys("newuser");
        driver.findElement(By.cssSelector("label[for='is_subscribed']")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        WebElement errorMessage = driver.findElement(By.cssSelector("div.account-create > ul > li > ul > li > span"));
        Assert.assertEquals("There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.", errorMessage.getText());
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}


