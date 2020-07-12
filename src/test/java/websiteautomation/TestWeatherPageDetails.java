package websiteautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static commonUtils.ReadWriteFile.getTempValueFromConfigFile;
import static commonUtils.ReadWriteFile.insertUpdatedTempValueIntoConfigFile;

public class TestWeatherPageDetails {

    private static Logger log = LoggerFactory.getLogger(TestWeatherPageDetails.class);
    private static String URL = "https://www.ndtv.com/";
    public ChromeDriver driver;
    public String KEY_CITY_NAME = "cityName.value";
    public String expectedCity = getTempValueFromConfigFile(KEY_CITY_NAME);
    public String temp = "Temp in Degrees:";
    public String KEY_WEBSITE_TEMP = "webSite.tempValue";

    public TestWeatherPageDetails() throws IOException {
    }


    @BeforeTest
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.silentOutpuy", "true");

        ChromeOptions c = new ChromeOptions();
        c.addArguments("--disable-notifications");

        driver = new ChromeDriver(c);

        driver.get(URL);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        isTitlePresent();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void TestWeatherDetails() throws Exception {

        WebDriverWait w = findMoreMenuContextAndClick();

        findWeatherLinkAndClick(w);

        findSearchBoxAndClick(w);

        collectCityNameAndClickOnExpectedCity();

        String TempFromSite = selectCityAndGetTemperature(temp);
        String[] op = TempFromSite.split(" ");
        String x = op[3];
        insertUpdatedTempValueIntoConfigFile(KEY_WEBSITE_TEMP, x);

    }

    @AfterTest
    public void closeSite() {
        driver.close();
    }

    private WebDriverWait findMoreMenuContextAndClick() {
        driver.findElementByClassName("topnavmore").click();
        return new WebDriverWait(driver, 50);
    }

    private void findWeatherLinkAndClick(WebDriverWait w) {
        WebElement e1 = driver.findElementByLinkText("WEATHER");
        w.until(ExpectedConditions.elementToBeClickable(e1)).click();
    }

    private void findSearchBoxAndClick(WebDriverWait w) {
        WebElement e2 = driver.findElementByClassName("searchBox");
        Actions a = new Actions(driver);
        w.until(ExpectedConditions.elementToBeClickable(e2));
        a.sendKeys(expectedCity, Keys.ENTER).build().perform();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Pune']"))).click();
    }

    private void collectCityNameAndClickOnExpectedCity() {
        List<WebElement> list = driver.findElementsByXPath("(//*[@class='temperatureContainer']/following-sibling::*)");
        System.out.println(list.size());
        for (WebElement l : list) {
            if (expectedCity.equalsIgnoreCase(l.getText())) {
                System.out.println(l.getText());
                l.click();
            }
        }
    }

    private String selectCityAndGetTemperature(String cityName) {
        List<WebElement> CityDetailslist = driver.findElementsByXPath("(//span[@class='heading']/child::*)");
        System.out.println(CityDetailslist.size());
        List<WebElement> cityTem = CityDetailslist.stream().filter(l -> (l.getText()).contains(cityName)).collect(Collectors.toList());
        return cityTem.get(0).getText();
    }

    private void isTitlePresent() {
        if (driver.getTitle().contains("NDTV")) {
            log.info("Title Test Passed");
        } else {
            log.error("Title Test Failed --> Need More time to Load page");
        }
    }

}
