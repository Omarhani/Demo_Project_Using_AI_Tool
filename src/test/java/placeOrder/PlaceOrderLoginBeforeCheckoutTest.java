package placeOrder;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ProductOverlay;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertTrue;

public class PlaceOrderLoginBeforeCheckoutTest extends BaseTests {
    @Test
    public void testPlaceOrderLoginBeforeCheckout() throws FileNotFoundException {
        assertTrue(homePage.homePageVisible(),"Home page is not visible");
        LoginPage loginPage=homePage.clickOnSignUpAndLoginLink();
        HomePage homePage1=loginPage.loginFeature(dataModel().Login.ValidCredentials.Email,dataModel().Login.ValidCredentials.Password);
        Assert.assertEquals(homePage1.getLoggedUsername(),"Logged in as eslam");
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