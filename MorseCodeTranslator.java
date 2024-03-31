package src;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeTranslator {

    // Mapping between characters and Morse code strings
    public Map<Character, String> morseToTextMapping = new HashMap<Character, String>();
    // Mapping between Morse code strings and characters
    public Map<String, Character> textToMorseMapping = new HashMap<String, Character>();

    // Arrays to hold the characters and their corresponding Morse code representations
    char[] letter = { 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0', ' ' };

    public String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "/" };

    // Constructor for MorseCodeTranslator class, initializes the mappings
    public MorseCodeTranslator() {
        setupMap();
    }

    // Method to set up the mappings between characters and Morse code
    private void setupMap(){
        for (int i = 0; i < letter.length; i++) {
            morseToTextMapping.put(letter[i], morse[i]);
            textToMorseMapping.put(morse[i], letter[i]);
        }
    }
}
