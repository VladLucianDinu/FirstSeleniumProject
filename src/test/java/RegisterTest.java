import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegisterTest {

    public static void main(String[] args) {

        RegisterTest rgs = new RegisterTest();
        rgs.registerTest();

    }

    public void registerTest() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Vlad");
        driver.findElement(By.id("middlename")).sendKeys("Lucian");
        driver.findElement(By.id("lastname")).sendKeys("Dinu");
        driver.findElement(By.id("email_address")).sendKeys("vladselenium@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("vladselenium");
        driver.findElement(By.id("confirmation")).sendKeys("vladselenium");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        driver.close();
    }


}
