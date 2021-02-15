import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertTrue;

public class AddToCart extends BaseMethodsWithLogIn {
    @Test
    public void addToCart() {

        selectByCategories("Laptops");
        selectProduct("Sony vaio i7");
        addProductToCart();
        actionCompletedMessage("Product added.");
        goToCartPage();
        assertTrue("Text is not eauals 'Sony vaio i7'", isElementPresent(By.xpath("//tbody[@id='tbodyid']/tr//td[contains(text(), 'Sony vaio i7')]")));
        deleteProduct();
    }
}
