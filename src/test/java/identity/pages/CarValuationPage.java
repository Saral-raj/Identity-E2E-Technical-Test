package identity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarValuationPage {
    private WebDriver driver;
    private final String URL = "https://www.webuyanycar.com/";

    // Locators
    private By regInputFieldElement = By.name("vehicleReg");
    private By mileageInputFieldElement = By.id("Mileage");
    private By startValuationButton = By.id("btn-go");
    private By carDetailsSection = By.xpath("(//*[@class='d-table'])[2]");

    public CarValuationPage(WebDriver driver) {
        this.driver = driver;
    }

    public Map<String, Map<String, String>> getValuationDetails(List<String> registrationNumbers, List<String> mileageNumbers) {
        Map<String, Map<String, String>> results = new HashMap<>();

        for (int i = 0; i < registrationNumbers.size(); i++) {
            String regNumber = registrationNumbers.get(i);
            String mileage = mileageNumbers.size() > i ? mileageNumbers.get(i) : "0"; // Default mileage if not provided

            driver.get(URL);

            // Enter registration number
            WebElement regInputField = driver.findElement(regInputFieldElement);
            regInputField.clear();
            regInputField.sendKeys(regNumber);

            // Enter mileage (if applicable)
            if (!mileage.isEmpty()) {
                WebElement mileageInputField = driver.findElement(mileageInputFieldElement);
                mileageInputField.clear();
                mileageInputField.sendKeys(mileage);
            }

            // Click start valuation
            driver.findElement(startValuationButton).click();

            // Extract car details
            WebElement detailsSection = driver.findElement(carDetailsSection);
            String details = detailsSection.getText();

            // Parse details and store them in a nested map
            Map<String, String> carDetails = new HashMap<>();
            carDetails.put("details", details);
            carDetails.put("mileage", mileage);

            // Store in the main results map with regNumber as the key
            results.put(regNumber, carDetails);
        }
        return results;
    }
}