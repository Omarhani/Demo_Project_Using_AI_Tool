package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class PaymentPage extends MethodHandles {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    private final By nameField = By.cssSelector("[name='name_on_card']");
    private final By numberField = By.cssSelector("[name='card_number']");
    private final By cvcField = By.cssSelector("[name='cvc']");
    private final By monthField = By.cssSelector("[name='expiry_month']");
    private final By yearField = By.cssSelector("[name='expiry_year']");
    private final By submitBtn = By.cssSelector("#submit");

    private void insertNameField(String text){
        sendKeys(nameField,5,text);
    }
    private void insertNumberField(String text){
        sendKeys(numberField,5,text);
    }
    private void insertCVCField(String text){
        sendKeys(cvcField,5,text);
    }
    private void insertMonthField(String text){
        sendKeys(monthField,5,text);
    }
    private void insertYearField(String text){
        sendKeys(yearField,5,text);
    }
    private void clickOnSubmitBtn(){
        click(submitBtn,5);
    }
    public PaymentDonePage paymentFeature(String name,String num,String cvc,String month,String year){
        insertNameField(name);
        insertNumberField(num);
        insertCVCField(cvc);
        insertMonthField(month);
        insertYearField(year);
        clickOnSubmitBtn();
        return new PaymentDonePage(driver);
    }

}
