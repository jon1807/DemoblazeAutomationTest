import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class BaseMethods {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    static String getLetter(int randomStringLenght) {
        String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        letter = letter + letter.toLowerCase() + "1234567890";
        StringBuilder stringBuilder = new StringBuilder(randomStringLenght);
        for (int i = 0; i < randomStringLenght; i++) {
            int index = (int) (letter.length() * Math.random());
            stringBuilder.append(letter.charAt(index));
        }
        return stringBuilder.toString();
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String alert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void field(By locator, String text) {
        click(locator);
        driver.findElement(locator).sendKeys(text);
    }

    protected void actionCompletedMessage(String message) {
        assertEquals(message, alert());
    }

    protected void goToCartPage() {
        click(By.id("cartur"));
    }

    protected void addProductToCart() {
        click(By.linkText("Add to cart"));
    }

    protected void selectProduct(String name) {
        click(By.linkText(name));
    }

    protected void selectByCategories(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(name)));
        click(By.linkText(name));
    }

    protected void goToHomePage() {
        click(By.xpath("(//a[contains(@href, 'index.html')])[2]"));
    }

    protected void signUp() {
        click(By.id("signin2"));
        field(By.id("sign-username"), getLetter(8));
        field(By.id("sign-password"), getLetter(8));
        click(By.cssSelector("#signInModal .btn-primary"));
    }

    protected void logIn(String username, String password) {
        click(By.id("login2"));
        field(By.id("loginusername"), username);
        field(By.id("loginpassword"), password);
        click(By.cssSelector("#logInModal .btn-primary"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logInModal")));
    }

    public void deleteProduct() {
        do {
            click(By.linkText("Delete"));
        }
        while (isElementPresent(By.linkText("Delete")));

    }
}

