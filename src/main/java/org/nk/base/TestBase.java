package org.nk.base;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.time.Duration;

import org.apache.logging.log4j.Logger;


public class TestBase {
    public static WebDriver webDriver;
    public static Properties properties;
    private static final Logger logger = LogManager.getLogger(TestBase.class);

    public TestBase(){
        try{
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream(
                    System.getProperty("user.dir")+"\\src\\main\\org\\nk\\config\\config.properties"
            );
            properties.load(inputStream);
        }catch(FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

    /**
     * setup config for selenium based off of config.properties file
     * logging setup in case of failure
     */
    public static void initialization(){
        String browserName = properties.getProperty("browser");
        String browserDriverPath = System.getProperty("user.dir")+"\\src\\main\\resources\\org\\nk\\broswerdriver\\";
        Duration waitDuration = Duration.ofSeconds(10);
        Duration implicitWaitDuration = Duration.ofSeconds(60);

        logger.trace("Beginning initialization -- finding selenium driver");

        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", browserDriverPath + "chromedriver.exe");
            webDriver = new ChromeDriver();
            logger.trace("chrome driver selected");

        }else if (browserName.equalsIgnoreCase("ff")) {
            System.setProperty("webdriver.gecko.driver", browserDriverPath + "geckodriver.exe");
            webDriver = new FirefoxDriver();
            logger.trace("firefox driver selected");

        }else{
            logger.trace("No browser driver was selected -- should never happen");
        }


        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(waitDuration);
        webDriver.manage().timeouts().implicitlyWait(implicitWaitDuration);

        logger.trace("initialization complete");
    }
}
