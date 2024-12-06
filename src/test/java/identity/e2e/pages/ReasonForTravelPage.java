package identity.e2e.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class ReasonForTravelPage extends PageObject {

    WebElementFacade reasonToSelect;

    public void selectReasonForVisit(String reason) {
        reasonToSelect = find(By.xpath("//*[contains(text(),'" + reason + "')]"));
        clickOn(reasonToSelect);
    }


}


