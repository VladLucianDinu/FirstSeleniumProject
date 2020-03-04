import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    public static void main(String[] args) {
        LoginTest lgn = new LoginTest();
        lgn.loginTest();

    }

    public void loginTest() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.findElement(By.linkText("ACCOUNT")).click();
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.name("login[username]")).sendKeys("vladselenium@mailinator.com");
        driver.findElement(By.name("login[password]")).sendKeys("vladselenium");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        driver.close();
    }


}