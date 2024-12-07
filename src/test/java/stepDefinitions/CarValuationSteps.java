package stepDefinitions;

import identity.pages.CarValuationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static identity.utils.FileUtils.*;


public class CarValuationSteps {
    WebDriver driver;
    CarValuationPage carValuationPage;
    List<String> registrationNumbers;
    List<String> mileageNumbers;
    Map<String, Map<String, String>> actualOutput;

    @Given("the car input file {string} is loaded")
    public void loadCarInputFile(String InputFile) {
        Assert.assertTrue("Input file not found!", fileExists(InputFile));
    }

    @When("I extract vehicle registration numbers from the input file")
    public void extractVehicleRegistrationNumbers(String inputFile) {
        registrationNumbers = extractRegistrationNumbers(inputFile);
    }

    @When("I perform car valuation for each registration number")
    public void performCarValuation() {
        carValuationPage = new CarValuationPage(driver);
        actualOutput = carValuationPage.getValuationDetails(registrationNumbers, mileageNumbers);
        driver.quit();
    }

    @Then("I compare the actual {string} with the expected file {string}")
    public void iCompareTheActualWithTheExpectedFile(String ExpectedOutputFile) {
        boolean isMatch = compareOutputs(actualOutput, ExpectedOutputFile);
        if (!isMatch) {
            throw new AssertionError("Actual output does not match expected output.");
        }
    }



}


