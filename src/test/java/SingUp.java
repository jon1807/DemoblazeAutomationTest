import org.junit.Test;

public class SingUp extends BaseMethods {

    @Test
    public void singUpTest() {
        signUp();
        actionCompletedMessage("Sign up successful.");
    }
}
