package identity.e2e.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CommonPage extends PageObject {
    @FindBy(xpath = "//*[@id='current-question']/button")
    private WebElementFacade btncontinue;

    public void clickOnContinue() {
        clickOn(btncontinue);

    }
}
