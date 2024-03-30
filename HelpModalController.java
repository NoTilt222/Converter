package src;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class HelpModalController {
    @FXML
    private Text helpText;

    public void initialize() {
        helpText.setText(explain());
    }

    public String explain() {
        return """
                Klik op de knop 'Groepsleden' om de namen van de groepsleden te zien.
                
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
