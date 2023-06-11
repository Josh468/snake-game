package com.Snake.model;
import com.Snake.SnakeGameApplication;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;


public class Snake {
    private List<Point> body;
    private int size;
    //0=RIGHT, 1=down, 2=left, 3=up
    public int direction;
    public int speed;

    public int pixelx;

    public int pixely;

    public Snake (int x,int y) {
        Point t = new Point(x,y);

        body = new ArrayList<>();
        body.add(0,t);
        size=1;
        speed=1;
        direction=0;
        pixelx=70;
        pixely=90;
    }

    public List<Point> getBody(){
        return body;
    }

    public Integer getSize(){
        return size;
    }
    public void pixelMove(){

        if (direction == 0) {
            pixelx++;
            if (pixelx % 10 == 0) {
                move();
            }
        }
        if (direction == 1) {
            pixely++;
            if(pixely%10==0){
                move();
            }
        }
        if (direction == 2) {
            pixelx--;
            if(pixelx%10==0){
                move();
            }
        }
        if (direction == 3) {
            pixely--;
            if(pixely%10==0){
                move();
            }
        }
    }
    public void move() {

        if (direction == 0) {
            Point t = new Point(body.get(0).getX() + 1,body.get(0).getY());

            body.add(0, t);
            body.remove(body.size()-1);
        }
        if (direction == 1) {
            Point t = new Point(body.get(0).getX() ,body.get(0).getY() + 1);

            body.add(0, t);
            body.remove(body.size()-1);
        }
        if (direction == 2) {
            Point t = new Point(body.get(0).getX() - 1,body.get(0).getY() );

            body.add(0, t);
            body.remove(body.size()-1);
        }
        if (direction == 3) {
            Point t = new Point(body.get(0).getX() ,body.get(0).getY() - 1);

            body.add(0, t);
            body.remove(body.size()-1);
        }
    }
    public void grow(){
        size++;
        if (direction == 0) {
            Point t = new Point(body.get(0).getX() + 1, body.get(0).getY());
            body.add(0, t);
        }
        if (direction == 1) {
            Point t = new Point(body.get(0).getX() ,body.get(0).getY() + 1);

            body.add(0, t);

        }
        if (direction == 2) {
            Point t = new Point(body.get(0).getX() -1 ,body.get(0).getY() );

            body.add(0, t);

        }
        if (direction == 3) {
            Point t = new Point(body.get(0).getX() ,body.get(0).getY() - 1);

            body.add(0, t);

        }
    }
    public boolean isTouchingApple(Apple apple) {
        if (body.get(0).getX() == apple.getPoint().getX() && body.get(0).getY() == apple.getPoint().getY()){
            grow();
//            addSpeed();
        return true;
        }else {
            return false;
        }
    }
    public boolean isTouchingWall(){

        if (pixelx <= -1 || pixely <= -1000 || pixelx >=SnakeGameApplication.canvax-2 || pixely >= SnakeGameApplication.canvay-2){
            return true;
        }else{
            return false;
        }
    }
    public boolean collusion(){
        for (int i = 1; i < size; i++) {
            if (body.get(0).getX()==body.get(i).getX() && body.get(0).getY()==body.get(i).getY()){
                return true;

            }
        }
        return false;
    }



//    public void addSpeed(){
//        if (size%3==0){
//            speed++;
//            System.out.println("Hi");
//        }
//    }
}
