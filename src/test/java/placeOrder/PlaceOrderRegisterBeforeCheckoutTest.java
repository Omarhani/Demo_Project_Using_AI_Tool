package placeOrder;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ProductOverlay;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertTrue;

public class PlaceOrderRegisterBeforeCheckoutTest extends BaseTests {
    @Test
    public void testPlaceOrderRegisterBeforeCheckout() throws FileNotFoundException {
        assertTrue(homePage.homePageVisible(),"Home page is not visible");
        LoginPage loginPage=homePage.clickOnSignUpAndLoginLink();
        RegisterPage registerPage=loginPage.redirectToRegisterPage(dataModel().Registration.ValidCredentials.RegisterEmail,dataModel().Registration.ValidCredentials.RegisterName);
        AccountCreatedPage accountCreatedPage=registerPage.registerFeature(dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.RegisterAccountPassword,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.FirstNameAddressA,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.LastNameAddressA,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.AddressNameA1,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.CountryAddressA,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.StateA,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.CityA,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.ZipCodeA,dataModel().RegistrationAccountForm.ValidRegisterAccountCredentials.MobileNumberA);
        Assert.assertEquals(accountCreatedPage.accountCreatedTxtVisible() , "ACCOUNT CREATED!");
        HomePage homePage1=accountCreatedPage.clickOnContinueBtn();
        Assert.assertEquals(homePage1.getLoggedUsername(),"Logged in as "+dataModel().Registration.ValidCredentials.RegisterName);
        ProductOverlay productOverlay =homePage1.addProductToViewCart(2);
        productOverlay.clickOnAddToCartBtn();
        homePage1.clickOnContinueShoppingBtn();
        ViewCartPage viewCartPage=homePage1.clickOnCartPage();
        assertTrue(viewCartPage.isCartDisplayed(),"Cart page is not visible");
        CheckoutPage checkoutPage=viewCartPage.redirectToCheckoutPage();
        assertTrue(checkoutPage.isAddressLabelVisible(),"Address is not visible");
        assertTrue(checkoutPage.isReviewLabelVisible(),"Review is not visible");
        PaymentPage paymentPage=checkoutPage.checkoutFeature(dataModel().Checkout.Comment);
        PaymentDonePage paymentDonePage=paymentPage.paymentFeature(dataModel().Payment.Name,dataModel().Payment.Number,dataModel().Payment.CVC,dataModel().Payment.Month,dataModel().Payment.Year);
        assertTrue(paymentDonePage.getPaymentSuccessMessage().contains("Congratulations! Your order has been confirmed!"));
        DeleteAccountPage deleteAccountPage=paymentDonePage.clickOnDeleteAccount();
        Assert.assertEquals(deleteAccountPage.getMessageDelete() , "ACCOUNT DELETED!");
    }
}
