package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ViewCartPage extends MethodHandles {
    public ViewCartPage(WebDriver driver) {
        super(driver);
    }
    private final By cartDisplay = By.xpath("//*[@class='active']");
    private final By checkoutBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private final By register_LoginBtn = By.xpath("//u[contains(text(),'Register / Login')]");

    public boolean isCartDisplayed(){
       return isDisplayed(cartDisplay,5);
    }
    private void clickOnCheckoutBtn(){
        click(checkoutBtn,5);
    }
    private void clickOnRegister_LoginBtn(){
        click(register_LoginBtn,5);
    }

    public CheckoutPage redirectToCheckoutPage(){
        clickOnCheckoutBtn();
        return new CheckoutPage(driver);
    }

    public LoginPage viewCartPageFeature(){
        clickOnCheckoutBtn();
        clickOnRegister_LoginBtn();
        return new LoginPage(driver);
    }
}
