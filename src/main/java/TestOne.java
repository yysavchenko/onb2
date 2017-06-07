import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.PropertyLoader;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by yysavchenko on 31.05.2017.
 */

public class TestOne {

    private WebDriver driver;

    @BeforeTest
    public void setup() {

        final File file = new File(PropertyLoader.loadProperty("path.webDriver"));
        System.setProperty(PropertyLoader.loadProperty("webDriver"), file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testCalc() throws InterruptedException {
        driver.navigate().to("http://juliemr.github.io/protractor-demo");       // Step1 - to open Page
        String label = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(label, "Super Calculator");

        driver.findElement(By.xpath("//*[@ng-model='first']")).sendKeys("1");       // Step2 - to input values 1 and 2
   //     String input1 = driver.findElement(By.xpath("//input[1]")).getText();
    //     Assert.assertEquals(input1, "1");

        driver.findElement(By.xpath("//*[@ng-model='second']")).sendKeys("2");
   //     String input2 = driver.findElement(By.xpath("//input[2]")).getText();
   //     Assert.assertEquals(input1, "2");

        Select dropdown = new Select(driver.findElement(By.xpath("//*[@ng-model='operator']")));    // Step3 - to select "+" in drop-down
        dropdown.selectByValue("ADDITION");
      //  String dropdown2 = driver.findElement(By.xpath("//html/body/div/div/form/select")).getText();
       // Assert.assertEquals(dropdown2, "ADDITION");

        driver.findElement(By.xpath("//*[@id='gobutton']")).click();               // Step4 - to click "Go!" and assert result
        Thread.sleep(5000);                                                 // govnokod
        String result = driver.findElement(By.xpath("//*[@class='ng-binding']")).getText();
        Assert.assertEquals(result, "3");

    }

    }




