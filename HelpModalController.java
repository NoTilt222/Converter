package src;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class HelpModalController {
    @FXML
    private Text helpText;

    public void initialize() {
        helpText.setText(explain());
    }

    String explain() {
        return """
                1. Vul in het tekstveld een woord of tekst in.
                2. Klik op de knop 'Convert' om de tekst om te zetten naar morse code.
                3. Wilt u de tekstvelden legen? Klik dan op de knop 'Clear'.
                4. Wilt u de namen van de groepsleden zien? Klik dan op de knop 'Groepsleden'.""";
    }

}
