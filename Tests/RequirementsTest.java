package src.Tests;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javafx.scene.control.TextArea;
import src.Controllers.Requirements;

import static org.junit.jupiter.api.Assertions.*;

class RequirementsTest {

    private Requirements requirements;
    @BeforeAll
    public static void setUpJavaFX() {
        // Initialize the JavaFX Toolkit if not already initialized
        if (Platform.isFxApplicationThread()) {
            new JFXPanel(); // Initializes the toolkit
        } else {
            Platform.startup(() -> new JFXPanel());
        }
    }

    @Test
    void groepsleden() {
        //Test to check if the array contains the correct names
        requirements = new Requirements();
        String[] result = requirements.groepsleden();

        String[] expected = {"Timothy Mentowidjojo", "Josh Kartadiwirja", "Shyfka Landveld", "Tarique Martowidjojo", "Yorina Lodirono"};
        assertArrayEquals(expected, result);
    }

    @Test
    void abs2morse() {
        requirements = new Requirements();
        String result = requirements.abs2morse("a");
        assertEquals(".-", result.trim());
    }

    @Test
    void morse2abc() {
        requirements = new Requirements();
        String result = requirements.morse2abc(".-");
        assertEquals("a", result.trim());
    }

    @Test
    void convert() {
        requirements = new Requirements();
        TextArea input = new TextArea("0");
        TextArea output = new TextArea();
        requirements.convert(input, output);
        assertEquals("-----", output.getText().trim());
    }

    @Test
    void swap() {
        requirements = new Requirements();
        TextArea input = new TextArea("Hello");
        TextArea output = new TextArea(".... . .-.. .-.. ---");
        requirements.swap(input, output);
        assertEquals(".... . .-.. .-.. ---", input.getText().trim());
        assertEquals("Hello", output.getText().trim());
    }

    @Test
    void clear() {
        requirements = new Requirements();
        TextArea input = new TextArea("a");
        TextArea output = new TextArea(".-");
        requirements.clear(input, output);
        assertTrue(input.getText().isEmpty());
        assertTrue(output.getText().isEmpty());
    }

    @Test
    void exampleMorseCode() {
        requirements = new Requirements();
        String result = requirements.exampleMorseCode();
        assertFalse(result.isEmpty());
        assertTrue(result.contains(".... .."));
    }

    @Test
    void exampleString() {
        requirements = new Requirements();
        String result = requirements.exampleString();
        assertFalse(result.isEmpty());
        assertTrue(result.contains("Hello World"));
    }

    @Test
    void explain() {
        Requirements _requirements = new Requirements();
        String result = _requirements.explain();
        assertFalse(result.isEmpty(), "The explanation string should not be empty");
    }
}