import java.awt.*;

public abstract class Figur implements FigurInterface{

    Punkt p1,p2;

    int x,y,m,k;

    public abstract void rita(Graphics g);

    public abstract boolean ärInnanför(Punkt p);
}
