


import com.Snake.model.Apple;
import com.Snake.model.Snake;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.io.IOException;

//75,95
public class SnakeGameApplication extends Application {
    public Snake snake = new Snake(7, 9);

    // screen is 500,500 we split it by 10 so 50,50 and snake start at 7,9
    public Apple apple = new Apple(12, 9);


    public static int count = 1;

    public static int framecount = 0;
    public static int canvax = 500;
    public static int canvay = 500;

    public Button button1 = new Button();
//sepreate scene, view, controller mvc
    //we only want game loop here

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(SnakeGameApplication.class.getResource("primary-stage.fxml"));
//
//        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
//        stage.setScene(scene);
        stage.setTitle("Snake");

        Label label = new Label("Snake Game");
        label.setFont(new Font("Serif", 50));
        label.setTextFill(Color.BLUE);

        stage.show();
        button1 = new Button();
        button1.setText("Start");
        button1.setMinWidth(10);
        button1.setMinHeight(10);
        button1.setFont(new Font("Serif", 36));

        VBox root1 = new VBox(100);
        root1.getChildren().add(label);
        root1.getChildren().add(button1);
        root1.setAlignment(Pos.TOP_CENTER);
        Scene scene1 = new Scene(root1, 500, 500, Color.BEIGE);
        root1.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));


        Group root = new Group();

        Scene scene2 = new Scene(root);
        stage.setScene(scene1);

        Canvas canvas = new Canvas(canvax, canvay);
        root.getChildren().add(canvas);

        scene2.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
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
        //Move to game scene
        button1.setOnAction(e -> {
            stage.setScene(scene2);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            new AnimationTimer() {
                public long lastupdate = 0;
                public long present = 0;


                public void handle(long currentNanoTime) {
                    // Clear the canvas


                    present = currentNanoTime - lastupdate;
                    lastupdate = currentNanoTime;

                    framecount++;


                    gc.setFill(Color.LIGHTBLUE);
                    gc.fillRect(0, 0, canvax, canvay);
                    gc.setFill(Color.BLACK);
                    gc.setTextBaseline(VPos.TOP);

                    gc.fillText("Number: " + count, 20, 20);

                    if (snake.isTouchingApple(apple) == true) {
                        apple.changeSpot();
                        count++;
                    }
                    if (snake.isTouchingWall() == true) {
                        stop();
                    }
                    if (snake.collusion() == true) {
                        stop();
                    }
                    apple.render(gc);
                    snake.render(gc);

                    //movement
                    snake.pixelMove();
                    System.out.println(snake.pixelx + " " + snake.pixely);
                }
            }.start();
        });

//        applex = (int) (Math.random() * 502 + 10);
//        appley = (int) (Math.random() * 502 + 10);

        //game loop

//        GraphicsContext gc = canvas.getGraphicsContext2D();
//        new AnimationTimer() {
//            public long lastupdate = 0;
//            public long present = 0;
//
//
//            public void handle(long currentNanoTime) {
//                // Clear the canvas
//
//
//                present = currentNanoTime - lastupdate;
//                lastupdate = currentNanoTime;
//
//                framecount++;
////                System.out.println(currentNanoTime/Math.pow(10,9));
//
//                gc.setFill(Color.LIGHTBLUE);
//                gc.fillRect(0, 0, canvax, canvay);
//                gc.setFill(Color.BLACK);
//                gc.setTextBaseline(VPos.TOP);
//
//                gc.fillText("Number: " + count, 20, 20);
//
//                if (snake.isTouchingApple(apple)==true){
//                    apple.changeSpot();
//                    count++;
//                }
//                if (snake.isTouchingWall()==true){
//                   stop();
//                }
//
//                apple.render(gc);
//                snake.render(gc);
//
//                //movement
//              snake.pixelMove();
//              System.out.println(snake.pixelx+" "+ snake.pixely);


//            }



    }


    public static void main(String[] args) {
        launch();
    }
}


//                gc.setFill(Color.DARKBLUE);
//                for (int i = 0; i < count; i++) {
//                    gc.fillRect(snake.get(i).x,snake.get(i).y, 10, 10);
//                }

//                if (snake.direction == 0) {
//                    snake.pixelMove();
//                }
//                if (snake.direction == 2) {
//                    snake.pixelMove();
//                }
//                if (snake.direction == 1) {
//                    snake.pixelMove();
//                }
//                if (snake.direction == 3) {
//                    snake.pixelMove();
//                }
//                gc.setStroke(Color.BLACK);
//                gc.fillRect(snake.pixelx, snake.pixely, 1, 1);
//gc.setFill(Color.RED);
//gc.fillOval(applex, appley, 15, 15);

//check if close to apple and move applex and y somewhere else
//                if (listx.get(0)>=applex-20 && listx.get(0)<=applex+20 && listy.get(0)>=appley-20 && listy.get(0)<=appley+20){
//
//                    applex = (int) (Math.random()*12);
//                    appley = (int) (Math.random()*12);
//                    count++;
//                }

//                System.out.println(listx);
//                System.out.println(listy);