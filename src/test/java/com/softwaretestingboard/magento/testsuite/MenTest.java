package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.pages.MenPantsPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MenTest extends BaseTest {

    HomePage homePage = new HomePage();
    MenPantsPage menPantsPage = new MenPantsPage();

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        homePage.mouseHoverOnMenBottomsAndClick();
        menPantsPage.mouseHoverOnPantAndClick();
        menPantsPage.clickOnAddToCart();
        verifyTwoStrings("You added Cronus Yoga Pant to your shopping cart.", By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        menPantsPage.clickOnShoppingCart();
        verifyTwoStrings("Shopping Cart",By.xpath("//span[@class='base']"));
        verifyTwoStrings("Cronus Yoga Pant",By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        verifyTwoStrings("32",By.xpath("//dd[contains(text(),'32')]"));
        verifyTwoStrings("Black",By.xpath("//dd[contains(text(),'Black')]"));

    }
}
