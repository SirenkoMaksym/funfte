/*
 * created by max$
 */


package de.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;
    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://www.kleinanzeigen.de/s-autos/63322/c216l4514r20+autos.fuel_s:diesel+autos.shift_s:manuell");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }
}
