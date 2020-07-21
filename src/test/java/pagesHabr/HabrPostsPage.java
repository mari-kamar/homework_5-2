package pagesHabr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HabrPostsPage extends HabrBasePage{

    public List<WebElement> posts = driver.findElements(By.xpath("//h2[contains(@class, 'post__title')]/a"));
    private final String titlePostFirst = posts.get(0).getText();
    public List<WebElement> postAuthors = driver.findElements(By.xpath("//a[contains(@class, 'post__user-info user-info') and (@title='Автор публикации' )] "));

    public HabrPostsPage(WebDriver driver) {
        super(driver);
    }

    public HabrPostsPage openFirstPost() {
        posts.get(0).click();
        logger.info("First Post is open");
        return this;
    }

    public String getTitlePostFirst() {return titlePostFirst;}

    public HabrPostsPage openPostAuthor() {
        postAuthors.get(0).click();
        logger.info("First post author's info is open");
        return this;
    }
}
