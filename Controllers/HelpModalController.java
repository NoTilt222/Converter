package src.Controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class HelpModalController {
    @FXML
    private Text helpText;

    public void initialize() {
        Requirements _requirements = new Requirements();
        helpText.setText(_requirements.explain());
    }

}
