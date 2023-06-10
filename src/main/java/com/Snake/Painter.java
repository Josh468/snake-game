package com.Snake;
import com.Snake.model.Apple;
import com.Snake.model.Point;
import com.Snake.model.Snake;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Painter {
    public Painter(GraphicsContext gc) {
    }

    public static void paintBackground(GraphicsContext gc){
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, SnakeGameApplication.canvax, SnakeGameApplication.canvay);
    }

    public static void paintScore(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.setTextBaseline(VPos.TOP);

        gc.fillText("Number: " + SnakeGameApplication.count, 20, 20);
    }
    public static void paintSnake(GraphicsContext gc, Snake snake){
        List<Point> p= snake.getBody();
        gc.setFill(Color.GREEN);
        gc.fillRect(p.get(0).getX() *10, p.get(0).getY() *10, 10, 10);
        gc.setFill(Color.DARKBLUE);
        for (int i = 1; i < p.size(); i++) {
            gc.fillRect(p.get(i).getX() *10, p.get(i).getY() *10, 10, 10);
        }
    }

    public static void paintApple(GraphicsContext gc, Apple apple){
        Point p=apple.getPoint();
        gc.setFill(Color.RED);
        gc.fillOval(p.x*10,p.y*10, 10, 10);
    }



}
