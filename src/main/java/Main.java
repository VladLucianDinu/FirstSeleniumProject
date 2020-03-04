import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

//        login();
        addToCart();
//        searchAndSort();


    }

    public static void login() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        driver.quit();
    }

    public static void addToCart() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a"))).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.parent > ul > li.level1.nav-2-5.last > a")).click();
        driver.findElement(By.id("product-collection-image-405")).click();
        driver.findElement(By.cssSelector("#swatch15 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch78 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > div > a > span.label")).click();
        driver.close();


    }

    public static void searchAndSort() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.findElement(By.name("q")).sendKeys("bags");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        Select mydrpdwn = new Select(driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > select")));
        mydrpdwn.selectByVisibleText("Price");
        driver.findElement(By.className("sort-by-switcher sort-by-switcher--asc")).click();
        driver.close();
    }
}




