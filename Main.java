package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // Entry point of the application
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("converterType.fxml"));
        Parent root = loader.load();

        // Get the controller instance
        ConverterTypeController controller = loader.getController();

        // Set the stage for the controller to manage
        controller.setStage(primaryStage);

        // Set the title of the primary stage
        primaryStage.setTitle("Choose Converter");

        // Set the scene with the root node loaded from FXML
        primaryStage.setScene(new Scene(root));

        // Display the primary stage
        primaryStage.show();
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
