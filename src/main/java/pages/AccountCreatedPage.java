package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class AccountCreatedPage extends MethodHandles {
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }
    public final By accountCreatedText = By.xpath("//h2[@class='title text-center']/b");
    public final By continueBtn = By.linkText("Continue");

    public String accountCreatedTxtVisible(){
        return getText(accountCreatedText , 3);
    }


    public HomePage clickOnContinueBtn(){
        click(continueBtn , 3);
        return new HomePage(driver);
    }
}
