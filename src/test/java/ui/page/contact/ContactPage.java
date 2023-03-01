package ui.page.contact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class ContactPage {
    WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@id='contact-first-name']")
    WebElement firstNameField;

    @FindBy(xpath = "//div[@id='contact-last-name']")
    WebElement lastNameField;

    @FindBy(xpath = "//div[@id='contact-description']")
    WebElement contactDescription;
    public Map<String, String> getInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("first name", firstNameField.getText());
        info.put("last name", lastNameField.getText());
        info.put("contact description", contactDescription.getText());
        return info;
    }


}
