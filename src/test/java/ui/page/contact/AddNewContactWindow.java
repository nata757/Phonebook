package ui.page.contact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewContactWindow {
    WebDriver driver;

    public AddNewContactWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='form-name']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='form-lastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='form-about']")
    WebElement aboutInput;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement saveButton;
    public void fillData(String firstName, String lastName, String about) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        aboutInput.clear();
        aboutInput.sendKeys(about);
        saveButton.click();
    }

}
