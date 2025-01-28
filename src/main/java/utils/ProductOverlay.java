package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;

public class ProductOverlay {
    WebElement element;
    public ProductOverlay(WebElement element) {
        this.element=element;
    }

    private final By addToCartBtn= By.cssSelector(".btn");

    public void clickOnAddToCartBtn(){
        element.findElement(addToCartBtn).click();
    }
}
