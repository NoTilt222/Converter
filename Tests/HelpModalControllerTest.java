package src.Tests;

import org.junit.jupiter.api.Test;
import src.HelpModalController;

import static org.junit.jupiter.api.Assertions.*;

class HelpModalControllerTest {

    @Test
    void explain_NotEmpty() {

        HelpModalController controller = new HelpModalController();
        String result = controller.explain();
        assertFalse(result.isEmpty(), "The explanation string should not be empty");
    }
}