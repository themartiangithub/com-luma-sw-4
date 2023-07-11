package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.pages.DufflePage;
import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.pages.MenPantsPage;
import com.softwaretestingboard.magento.pages.ShoppingCartPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GearTest extends BaseTest {
    HomePage homePage = new HomePage();
    MenPantsPage menPantsPage = new MenPantsPage();
    DufflePage dufflePage = new DufflePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        homePage.mouseHoverOnGearAndClick();
        verifyTwoStrings("Overnight Duffle", By.xpath("//span[@class='base']"));
        dufflePage.changeQuantity("3");
        dufflePage.clickOnAddToCart();
        Thread.sleep(2000);
        verifyTwoStrings("You added Overnight Duffle to your shopping cart.", By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        menPantsPage.clickOnShoppingCart();
        verifyTwoStrings("Overnight Duffle", By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        String actual = getElement(By.xpath("//input[@title='Qty']")).getAttribute("value");
        Assert.assertEquals(actual, "3");
        verifyTwoStrings("$135.00", By.xpath("(//span[@class='cart-price']//span)[2]"));
        shoppingCartPage.changeQuantity("5");
        shoppingCartPage.clickOnUpdate();
        Thread.sleep(1000);
        verifyTwoStrings("$225.00",By.xpath("(//span[@class='cart-price']//span)[2]"));

    }
}
