package identity.e2e.stepDefinitions;

import identity.e2e.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VisaConfirmationSteps {

    StartPage startPage;
    SelectNationalityPage selectNationalityPage;
    ReasonForTravelPage reasonForTravelPage;
    ResultPage resultPage;
    DurationOfStayPage durationOfStayPage;
    CommonPage commonPage;


    @And("I start visa check")
    public void i_start_visa_check() {
        startPage.clickStartNow();
    }

    @When("I select a nationality of {string}")
    public void iSelectANationalityOfAustralia(String nationality) {
        selectNationalityPage.selectNationality(nationality);
        commonPage.clickOnContinue();
    }

    @And("I select reason {string}")
    public void iSelectReasonTourism(String reason) {
        reasonForTravelPage.selectReasonForVisit(reason);
        commonPage.clickOnContinue();
    }

    @Then("I will be informed {string}")
    public void confirm_visa_result(String resultText) {
        resultPage.confirmResultMessage(resultText);
    }

    @And("I state I am intending to stay for {string} than 6 months")
    public void iStateIAmIntendingToStayForMoreThanMonths(String moreOrLess) {
        durationOfStayPage.selectLengthOfStay(moreOrLess);
        commonPage.clickOnContinue();
    }

    @Given("I am on the car valuation website")
    public void iAmOnTheCarValuationWebsite() {
        startPage.open();
    }
}
