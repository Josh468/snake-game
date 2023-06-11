package com.Snake;

import com.Snake.scene.StartingScreen;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;

//75,95
public class SnakeGameApplication extends Application {


    public static int canvax = 500;
    public static int canvay = 500;




    @Override
    public void start(Stage stage) throws IOException {


        stage.setTitle("Snake");
        StartingScreen sc1 = new StartingScreen();
        sc1.start(stage);


    }


    public static void main(String[] args) {
        launch();
    }
}