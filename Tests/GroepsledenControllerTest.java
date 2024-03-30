package src.Tests;

import org.junit.jupiter.api.Test;
import src.GroepsledenController;

import static org.junit.jupiter.api.Assertions.*;

class GroepsledenControllerTest {

    @Test
    void groepsleden() {
        GroepsledenController controller = new GroepsledenController();
        String[] result = controller.Groepsleden();

        String[] expected = {"Timothy Mentowidjojo", "Josh Kartadiwirja", "Shyfka Landveld", "Tarique Martowidjojo", "Yorina Lodirono"};
        assertArrayEquals(expected, result);
    }
}