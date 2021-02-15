import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertTrue;

public class LogIn extends BaseMethods {

    @Test
    public void logInTest() {
        logIn("test", "test");
        assertTrue(isElementPresent(By.id("nameofuser")));
    }
}
