import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest {

    @Test
    public void addProductToCartTest() {
        // Open browser
        WebDriver browser = new FirefoxDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // Go to http://www.seleniumdemo.com
        browser.get("http://www.seleniumdemo.com");
        // Find and click Shop link
        browser.findElement(By.linkText("Shop")).click();
        // Find and click Add to cart
        browser.findElement(By.xpath("//a[@data-product_id='27']")).click();
        // Find and click View cart
        browser.findElement(By.xpath("//a[@title='View cart']")).click();
        // Find and getText about product name
        String productName = browser.findElement(By.xpath("//td[@data-title='Product']")).getText();
        System.out.println(productName);
        // Find and getText about product price
        String price = browser.findElement(By.xpath("//td[@data-title='Price']")).getText();
        System.out.println(price);
        // Find and getText about total price
        String total = browser.findElement(By.xpath("//td[@data-title='Total']")).getText();
        System.out.println(total);
        // Check that name, product price and total price are correct
        Assert.assertEquals(productName,"GIT basics");
        Assert.assertEquals(price,"1,00 zł");
        Assert.assertEquals(total,"1,00 zł");
        // Quit browser
        browser.quit();
    }

}
