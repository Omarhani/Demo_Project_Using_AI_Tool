package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class DeleteAccountPage extends MethodHandles {
    public DeleteAccountPage(WebDriver driver)
    {
        super(driver);
    }
     // Locators
     private final By MessageDelete= By.xpath("//b[contains(text(),'Account Deleted!')]");
     private final By continueBtn= By.xpath("//a[contains(text(),'Continue')]");


    //Actions
    public String getMessageDelete()
    {
        return getText(MessageDelete,3);
    }
    public HomePage clickOnContinueBtn(){
        click(continueBtn,5);
        return new HomePage(driver);
    }
}
