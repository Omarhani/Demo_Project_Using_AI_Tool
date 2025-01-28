package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class PaymentDonePage extends MethodHandles {
    public PaymentDonePage(WebDriver driver) {
        super(driver);
    }
    private final By successMessage = By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");
    private final By deleteAccountLink=By.linkText("Delete Account");

    public String getPaymentSuccessMessage(){
        return getText(successMessage,5);
    }
    public DeleteAccountPage clickOnDeleteAccount()
    {
        click(deleteAccountLink,3);
        return new DeleteAccountPage(driver);
    }
}
