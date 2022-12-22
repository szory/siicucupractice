package siicucupractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    public ProfilePage(){
        super();
    }

    @FindBy(css = "#center_column > h1")
    private WebElement profilePageHeader;

    public WebElement getProfilePageHeader(){
        return profilePageHeader;
    }
    public String getProfilePageHeaderText(){
        return profilePageHeader.getText();
    }
}
