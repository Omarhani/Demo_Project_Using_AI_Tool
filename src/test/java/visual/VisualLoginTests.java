package visual;

import base.VisualBaseTests;
import com.applitools.eyes.selenium.fluent.Target;
import org.testng.annotations.Test;

public class VisualLoginTests extends VisualBaseTests {

    @Test
    public void visualFullLoginPage(){
        homePage.clickOnSignUpAndLoginLink();
        eyes.check(Target.window());
    }
}
