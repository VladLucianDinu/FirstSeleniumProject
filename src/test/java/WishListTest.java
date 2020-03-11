import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WishListTest {

    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void wishListTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.linkText("ACCOUNT")).click();
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.name("login[username]")).sendKeys("vladselenium@mailinator.com");
        driver.findElement(By.name("login[password]")).sendKeys("vladselenium");
        driver.findElement(By.cssSelector("#send2")).click();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("#product-collection-image-384")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();
        WebElement wishlistMessage = driver.findElement(By.cssSelector("div.my-wishlist > ul > li > ul > li > span"));
        Assert.assertEquals("Park Row Throw has been added to your wishlist. Click here to continue shopping.",wishlistMessage.getText());
    }

    @After
    public void closeDriver() {
        driver.close();
    }

//    Park Row Throw has been added to your wishlist. Click here to continue shopping.
}

