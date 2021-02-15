import org.junit.Before;

public class BaseMethodsWithLogIn extends BaseMethods {
    @Before
    public void setUp() {
        super.setUp();
        logIn("test", "test");
    }
}
