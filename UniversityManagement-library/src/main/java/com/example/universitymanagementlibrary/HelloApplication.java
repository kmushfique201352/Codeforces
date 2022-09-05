package com.example.universitymanagementlibrary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.time.Duration;

public class HelloApplication extends Application {
    double x,y=0;
    @Override
    public void start(Stage stage) throws IOException {
        AlertBox.display("Connection","Connection Estimated");

        Parent root=FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        root.setOnMousePressed(evt ->{
            x=evt.getSceneX();
            y=evt.getSceneY();
        });
        root.setOnMouseDragged(evt ->{
            stage.setX(evt.getScreenX()-x);
            stage.setX(evt.getScreenY()-y);
        });
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}