import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertTrue;

public class AddToCartTwoProduct extends BaseMethodsWithLogIn {
    @Test
    public void addToCartTwoProduct() {
        selectByCategories("Laptops");
        selectProduct("Sony vaio i7");
        addProductToCart();
        actionCompletedMessage("Product added.");
        goToHomePage();
        selectByCategories("Phones");
        selectProduct("Samsung galaxy s6");
        addProductToCart();
        actionCompletedMessage("Product added.");
        goToCartPage();
        assertTrue("Text is not eauals 'Sony vaio i7'", isElementPresent(By.xpath("//tbody[@id='tbodyid']/tr//td[contains(text(), 'Sony vaio i7')]")));
        assertTrue("Text is not eauals 'Samsung galaxy s6'", isElementPresent(By.xpath("//tbody[@id='tbodyid']/tr//td[contains(text(), 'Samsung galaxy s6')]")));
        deleteProduct();
    }
}
