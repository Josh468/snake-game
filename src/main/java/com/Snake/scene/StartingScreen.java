package com.Snake.scene;

import com.Snake.SnakeGameApplication;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//import java.awt.*;


public class StartingScreen  {
    // instance variable, ie. properties or attributes

    // constructor populates those attributes
    public StartingScreen() {

    }
//
    public void start(Stage stage) {
        Label label = new Label("Snake Game");
        label.setFont(new Font("Serif", 50));
        label.setTextFill(Color.BLUE);
        Button button1 = new Button();
        button1.setText("Start");
        button1.setMinWidth(10);
        button1.setMinHeight(10);
        button1.setFont(new Font("Serif", 36));
        button1.setOnAction(e -> {
            StartGame sc2 = new StartGame();
            sc2.start(stage);
        });
//
        VBox root1 = new VBox(100);

        root1.getChildren().add(label);

        root1.getChildren().add(button1);
        root1.setAlignment(Pos.TOP_CENTER);

        root1.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene sc = new Scene(root1, SnakeGameApplication.canvax, SnakeGameApplication.canvay, Color.BEIGE);
        stage.setScene(sc);
        stage.show();
    }
}
//