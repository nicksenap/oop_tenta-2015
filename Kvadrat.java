import java.awt.*;
import java.io.Serializable;

public class Kvadrat extends Figur implements FigurInterface,Serializable {

    public Kvadrat(Punkt p1, Punkt p2){

        this.p1=p1;
        this.p2=p2;

        this.x = p1.x<p2.x?p1.x:p2.x;
        this.y = p1.y<p2.y?p1.y:p2.y;
        this.m = p1.x>p2.x?p1.x:p2.x;
        this.k = p1.y>p2.y?p1.y:p2.y;

    }

    public  boolean ärInnanför(Punkt p){

        return p.x > x && p.x < m && p.y > y && p.y < k;
    }

    public void rita(Graphics g){

        g.drawRect(x,y,m-x,m-x);

    }
}
