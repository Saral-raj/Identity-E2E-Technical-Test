package identity.e2e.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.gov.uk/check-uk-visa")

public class StartPage extends PageObject {
    WebDriver driver = Serenity.getDriver();
    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/article/section[1]/a")
    private WebElementFacade startNowButton;

    public void clickStartNow() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", startNowButton);
        try {
            clickOn(startNowButton);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
        }
    }

}
