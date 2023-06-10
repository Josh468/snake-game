package com.Snake;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;


    @FXML
    Button start;
    Button end;
    @FXML
    protected void startGame() throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("end-stage.fxml"));
//        Stage window = (Stage) start.getScene().getWindow();
//        scene.setScene(Scene2);
    }

    @FXML
    protected void endGame() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("primary-stage.fxml"));
        Stage window = (Stage) end.getScene().getWindow();
        window.setScene(new Scene(root,500,500));
    }
//    public void Key(){}
//            addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
//        if (key.getCode() == KeyCode.RIGHT) {
//            snake.direction = 0;
//        } else if (key.getCode() == KeyCode.DOWN) {
//            snake.direction = 1;
//        } else if (key.getCode() == KeyCode.LEFT) {
//            snake.direction = 2;
//        } else if (key.getCode() == KeyCode.UP) {
//            snake.direction = 3;
//        }
//    }

}