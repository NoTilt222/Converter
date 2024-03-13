package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // Entry point of the application
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Load the FXML file
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        // Set the title of the primary stage
        primaryStage.setTitle("Converter");
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
