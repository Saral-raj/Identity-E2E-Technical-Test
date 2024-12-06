package identity.e2e.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends PageObject {

    @FindBy(xpath = "(//h2)[3]")
    WebElementFacade resultMessage;

    private String getResultMessage() {
        return resultMessage.getText();
    }

    public void confirmResultMessage(String expectedMessage) {
        Assert.assertTrue(getResultMessage().equalsIgnoreCase(expectedMessage));
    }
}
