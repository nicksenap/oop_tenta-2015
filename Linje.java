import java.awt.*;
import java.io.Serializable;

public class Linje extends Figur implements FigurInterface,Serializable{

    public Linje(Punkt p1,Punkt p2){
        this.p2 = p1;
        this.p1 = p2;
    }
    public void rita(Graphics g){
        int x= p1.x<p2.x?p1.x:p2.x;
        int y= p1.y<p2.y?p1.y:p2.y;
        int m= p1.x>p2.x?p1.x:p2.x;
        int k= p1.y>p2.y?p1.y:p2.y;
        g.drawLine(x, y, m-x, k-y);
    }

    public boolean ärInnanför(Punkt p){
        return true;
    }

}
