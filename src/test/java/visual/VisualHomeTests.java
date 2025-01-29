package visual;

import base.VisualBaseTests;
import com.applitools.eyes.selenium.fluent.Target;
import org.testng.annotations.Test;

public class VisualHomeTests extends VisualBaseTests {

    @Test
    public void visualHeaderHomePage() {
        eyes.check(Target.region(homePage.getHeaderHomePage()));
    }

    @Test
    public void visualFooterHomePage() {
        eyes.check(Target.region(homePage.getFooterHomePage()));
    }


}
