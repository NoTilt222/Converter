package src.Controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ExamplesController {

    @FXML
    private Text text;

    public void initialize(){
        Requirements _requirements = new Requirements();
        String examples = _requirements.exampleString() + "\n" + _requirements.exampleMorseCode();
        text.setText(examples);
    }
}
