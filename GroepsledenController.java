package src;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class GroepsledenController {

    @FXML
    private Text text;

    @FXML
    public void initialize(){
        String[] groepsleden = Groepsleden();
        StringBuilder groepsledenText = new StringBuilder();

        groepsledenText.append("De namen van de groepsleden zijn:\n");

        for (int i = 0; i < groepsleden.length; i++) {
            groepsledenText.append((i + 1) + ". " + groepsleden[i] + "\n");
        }

        text.setText(groepsledenText.toString());
    }

    public String[] Groepsleden(){
        return new String[]{"Timothy Mentowidjojo", "Josh Kartadiwirja", "Shyfka Landveld", "Tarique Martowidjojo", "Yorina Lodirono"};
    }
}
