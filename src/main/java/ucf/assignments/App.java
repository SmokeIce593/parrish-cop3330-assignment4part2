/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Cameron Parrish
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("DisplayItems.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("To-Do-Application");
        stage.setScene(scene);
        stage.show();

        /*
        Psuedocode:
        Load FXMLLoader and Scene
        Show stage
         */
    }

    public static void main(String[] args) {
        launch();
    }
}