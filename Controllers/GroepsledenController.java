package src.Controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import src.Interfaces.IRequirements;

public class GroepsledenController {

    @FXML
    private Text text;

    @FXML
    public void initialize(){
        Requirements _requirements = new Requirements();
        String[] groepsleden = _requirements.groepsleden();
        StringBuilder groepsledenText = new StringBuilder();

        groepsledenText.append("De namen van de groepsleden zijn:\n");

        for (int i = 0; i < groepsleden.length; i++) {
            groepsledenText.append((i + 1) + ". " + groepsleden[i] + "\n");
        }

        text.setText(groepsledenText.toString());
    }
}
