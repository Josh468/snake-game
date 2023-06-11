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
//    public Snake snake = new Snake(7, 9);
//
//    // screen is 500,500 we split it by 10 so 50,50 and snake start at 7,9
//    public Apple apple = new Apple(12, 9);

    public int countdown = 2000;

    public Timer timer;
    public Label countlabel = new Label("Timer!!!");




    public static int framecount = 0;
    public static int canvax = 500;
    public static int canvay = 500;
//TODO : pixel not staying in middle problem unsolve



    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(SnakeGameApplication.class.getResource("primary-stage.fxml"));
//
//        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        VBox layout=new VBox();

        stage.setTitle("Snake");
        StartingScreen sc1 = new StartingScreen();
        sc1.start(stage);

//

//        public void simpleTimer(){
//            timer = new Timer(1000, new ActionListener) {
//                @Override
//                public  void actionPerformed(ActionEvent e){
//
//                }
//            };
//        }

//        reset();
//       public void reset(){
////            gameloop = new Gameloop(gc);
//            Painter.paintBackground(gc);
//            Painter.paintScore(gc);
//            Painter.paintSnake(gc);
//            Painter.paintApple(gc);
//        }
    }


    public static void main(String[] args) {
        launch();
    }
}