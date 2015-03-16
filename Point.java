import java.awt.*;
import java.io.Serializable;

public class Point extends Figur implements FigurInterface, Serializable{

    public Point(Punkt p1){
        this.p1 = p1;
    }

    public void rita(Graphics g){

        int x = p1.x;

        int y = p1.y;

        g.fillOval(x,y,2,2);

    }
    public boolean ärInnanför(Punkt p){
        return true;
    }

}
