

import com.Snake.model.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Apple {
    private Point p;


    public Apple(int x, int y){
        p = new Point(x,y);


    }

    public Point getPoint(){
        return p;
    }

    public void setPoint(Apple t,int x, int y){
        t.p.x=x;
        t.p.y=y;
    }

    public void changeSpot(){
        System.out.println("change________________");
        p.x=(int) (Math.random() * 20 );
        p.y=(int) (Math.random() * 20 );


    }

    public void render(GraphicsContext gc){

        gc.setFill(Color.RED);

        gc.fillOval(p.x*10,p.y*10, 10, 10);


    }





}
