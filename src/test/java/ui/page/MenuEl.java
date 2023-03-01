package ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuEl {
    WebDriver driver;

    public MenuEl(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='navbar-nav mr-auto']/li[2]")
    private WebElement addNewContactMenuLink;

    public boolean isAddNewContactMenuLinkDisplayed() {
        return addNewContactMenuLink.isDisplayed();
    }
    public void clickToAddNewContactMenuLink() {
        addNewContactMenuLink.click();
    }

}
