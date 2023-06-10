package com.Snake.scene;

import com.Snake.Painter;
import com.Snake.SnakeGameApplication;
import com.Snake.model.Apple;
import com.Snake.model.Snake;
import javafx.animation.AnimationTimer;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Timer;

public class StartGame {
    // attribute
    private Apple apple;
    private Snake snake;
    private int count = 1;

    private  int framecount = 0;
    private Boolean running;
    private Timer timer;

    // populate those attributes
    public StartGame(){
        snake = new Snake(7, 9);
        apple = new Apple(12, 9);
        running=true;


    }

    public int getCount() {
        return count;
    }

    public void start(Stage stage) {
        Group root = new Group();
        Scene sc = new Scene(root);
        sc.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
                    if (key.getCode() == KeyCode.RIGHT) {
                        snake.direction = 0;
                    } else if (key.getCode() == KeyCode.DOWN) {
                        snake.direction = 1;
                    } else if (key.getCode() == KeyCode.LEFT) {
                        snake.direction = 2;
                    } else if (key.getCode() == KeyCode.UP) {
                        snake.direction = 3;
                    }
                });
        //where is it
        Canvas canvas = new Canvas(SnakeGameApplication.canvax, SnakeGameApplication.canvay);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        stage.setScene(sc);
        stage.show();

        new AnimationTimer() {
            public long lastupdate = 0;
            public long present = 0;


            public void handle(long currentNanoTime) {
                // Clear the canvas

//                Key(snake,);
                present = currentNanoTime - lastupdate;
                lastupdate = currentNanoTime;

                framecount++;


                gc.setFill(Color.LIGHTBLUE);
                gc.fillRect(0, 0, SnakeGameApplication.canvax, SnakeGameApplication.canvay);
                gc.setFill(Color.BLACK);
                gc.setTextBaseline(VPos.TOP);

                gc.fillText("Number: " + count, 20, 20);

                if (snake.isTouchingApple(apple) == true) {
                    apple.changeSpot();
                    count++;
                }
                if (snake.isTouchingWall() == true) {
                    stop();
                    StartEndScreen sc2 = new StartEndScreen();
                    sc2.start(stage,count);
                }
                if (snake.collusion() == true) {
                    stop();
                    StartEndScreen sc2 = new StartEndScreen();
                    sc2.start(stage,count);
                }
                Painter.paintBackground(gc);
                Painter.paintSnake(gc,snake);
                Painter.paintApple(gc,apple);
                Painter.paintScore(gc);

                //movement
                snake.pixelMove();
                System.out.println(snake.pixelx + " " + snake.pixely);
            }
        }.start();
    }

    public void stop(){
        stop();
    }
//    public void checkstop(){
//        if (snake.isTouchingWall() == true) {
//            stop();
//        }
//        if (snake.collusion() == true) {
//            stop();
//    }
}
