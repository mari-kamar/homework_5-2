package casesHabr;

import com.example.demo.DemoApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import pagesHabr.HabrMainPage;

//@ActiveProfiles("dev")
@SpringBootTest(
        classes = DemoApplication.class
)
public class HabrSpringTest {
    public static Logger logger = LogManager.getLogger(HabrSpringTest.class);
    //public static final String browser = System.getProperty("browser");
    //public static String options = System.getProperty("options");

    @Autowired
    @Qualifier("chrome")
    WebDriver driver;

    @Test
    public void habrTest1() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        Assert.assertTrue(habrMainPage.getMainLogo().isDisplayed());
        logger.info("logo has link");
    }

    @Test
    public void habrTest2() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .auth();

        WebElement authTitle = driver.findElement(By.xpath("//div[contains(text(),'Вход')]"));
        Assert.assertEquals(authTitle.getText(), "Вход");
        logger.info("Title Вход is true");
    }



    @AfterEach
    public void closedown() {
        System.out.println("\nCLOSEDOWN");
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }
}
