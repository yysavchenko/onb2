import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
    public void testCalc() {
        driver.navigate().to("http://juliemr.github.io/protractor-demo");       // Step1 - to open Page
        String label = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(label, "Super Calculator");

        driver.findElement(By.xpath("//input[1]")).sendKeys("1");       // Step2 - to input values 1 and 2
                                                                                        // ???
        Assert.assertEquals(input1, "1");


        Select dropdown = new Select(driver.findElement(By.xpath("//select[@ng-model=‘operator’]"))); //initialize dropdown
        dropdown.selectByValue(‘ADDITION’); //select plus
        WebElement addition = driver.findElement(By.xpath(“//option[@value=[’ADDITION’]”)); //initialize plus element

                // Assert.assertEquals(addition.getAttribute("selected"), “selected”); //assert that attribute value equals “selected”


        driver.findElement(By.id(“gobutton”)).click();	//click on Go button
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(“//tbody/tr/td”))); // wait until first record in history table  is appear
                string result = driver.findElement(By.xpath[“//h2[“@class=’ng-binding’”]]).getText(); //get result text
                        Assert.assertEquals(“2”, result); //assert that result is 2



    }

    }




