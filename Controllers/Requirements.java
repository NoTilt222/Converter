package src.Controllers;

import javafx.scene.control.TextArea;
import src.Interfaces.IRequirements;
import src.MorseCodeTranslator;

public class Requirements implements IRequirements {
    MorseCodeTranslator morseCodeTranslator = new MorseCodeTranslator();
    boolean morseToText = false; // Flag to indicate whether translation should be Morse to text or vice versa

    public String[] groepsleden(){
        return new String[]{"Timothy Mentowidjojo", "Josh Kartadiwirja", "Shyfka Landveld", "Tarique Martowidjojo", "Yorina Lodirono"};
    }

    public String abs2morse(String text){
        char[] characters = text.toLowerCase().toCharArray();
        StringBuilder morseString = new StringBuilder();

        for (char character : characters) {
            morseString.append(morseCodeTranslator.morseToTextMapping.get(character)).append(" ");
        }
        return String.valueOf(morseString);
    }

    public String morse2abc(String morse){
        String[] morseArray = morse.split(" ");

        StringBuilder morseString = new StringBuilder();

        for (String morsePart : morseArray) {
            morseString.append(morseCodeTranslator.textToMorseMapping.get(morsePart));
        }
        return String.valueOf(morseString);
    }

    public void convert(TextArea input, TextArea output){
        if(morseToText){
            output.setText(morse2abc(input.getText()));
        }else {
            output.setText(abs2morse(input.getText()));
        }
    }

    public void swap(TextArea input, TextArea output){
        String text = input.getText();
        String morse = output.getText();
        morseToText = !morseToText;
        output.setText(text);
        input.setText(morse);
    }

    public void clear(TextArea input, TextArea output){
        input.clear();
        output.clear();
    }

    public String exampleMorseCode(){
        return "Een voorbeeld morse code die u kunt gebruiken is \".... ..\" ";
    }

    public String exampleString(){
        return "Een voorbeeld tekst die u kunt gebruiken is \"Hello World\" ";
    }

    public String explain(){
        return """
                Klik op de knop 'Groepsleden' om de namen van de groepsleden te zien.
                Klik op de knop 'Voorbeelden' om voorbeelden te zien van tekst en morse code die u kunt gebruiken.
                
                Converteer tekst naar morse:
                1. Vul in het tekstveld een woord of tekst in.
                2. Klik op de knop 'Convert' om de tekst om te zetten naar morse code.
                3. Wilt u de tekstvelden legen? Klik dan op de knop 'Clear'.
                
                Converteer morse naar tekst:
                1. Klik op de cycle knop.
                2. Vul morse code in het tekstveld in.
                3. Klik op de knop 'Convert' om de morse code om te zetten naar tekst.
                4. Wilt u de tekstvelden legen? Klik dan op de knop 'Clear'.""";
    }
}
