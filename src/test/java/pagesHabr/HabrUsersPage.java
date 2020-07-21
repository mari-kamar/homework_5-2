package pagesHabr;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class HabrUsersPage extends HabrBasePage {

    private Actions actions = new Actions(driver);
    private By searchUserField = By.xpath("//*[@id=\"people_suggest\"]");
    private WebElement firstUserInList = driver.findElements(By.xpath("//ul[@id='peoples']/li[contains(@class, 'content-list__item_users')]/div/div/div/a")).get(0);

    public HabrUsersPage(WebDriver driver) {
        super(driver);
    }

    public HabrUsersPage search(String myUserSearch) {
        driver.findElement(searchUserField).sendKeys(myUserSearch);
        logger.info("Search page HABR is open");
        return this;
    }

    public HabrUsersPage openPersonalInfoFirstUser() {
        actions.click(firstUserInList).build().perform();
        return this;
    }
}
