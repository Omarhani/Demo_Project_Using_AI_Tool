package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CheckoutPage extends MethodHandles {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    private final By addressLabel = By.xpath("//div[@class='step-one'] /h2[contains(text(),'Address Details')]");
    private final By reviewLabel = By.xpath("//div[@class='step-one'] /h2[contains(text(),'Review Your Order')]");
    private final By commentField = By.cssSelector(".form-control");
    private final By placeOrderBtn = By.xpath("//a[contains(text(),'Place Order')]");

    public boolean isAddressLabelVisible(){
        return isDisplayed(addressLabel,5);
    }
    public boolean isReviewLabelVisible(){
        return isDisplayed(reviewLabel,5);
    }
    private void insertCommentField(String text){
        sendKeys(commentField,5,text);
    }
    private void clickOnPlaceOrderBtn(){
        click(placeOrderBtn,5);
    }
    public PaymentPage checkoutFeature(String text){
        insertCommentField(text);
        clickOnPlaceOrderBtn();
        return new PaymentPage(driver);
    }
}
