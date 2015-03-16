import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Mus extends JFrame implements MouseListener, MouseMotionListener{

    int antalKlickningar = 1;
    int x,y,m,k=0;
    Manip manip = new Manip(this);

    Model model;

    Client c;
    int flag = 0;


    public Mus(Model m, Client c){

        super();
	    model=m;
	    this.c=c;
	    setSize(450,300);
        add(manip);
	    setLayout(new FlowLayout());
        setVisible(true);
	    addMouseListener(this);
	    addMouseMotionListener(this);

    }

    public void mouseExited(MouseEvent me){}

    public void mouseEntered(MouseEvent me){}

    public void mouseClicked(MouseEvent me){

	Graphics g = getGraphics();

        if(antalKlickningar%2!=0){
	    x = me.getX();
	    y = me.getY();
	    g.fillOval(x,y,2,2);
        antalKlickningar++;

    }else{
            m = me.getX();
            k = me.getY();

            Punkt p1 = new Punkt(m,k);
            Punkt p2 = new Punkt(x,y);

            Figur f = null;

            if (flag == 0){
                f = new Rektangel(p1,p2);
                model.addFigur(f);
                c.skickaObject(f);
                ritaAllaFigur();

            } else
            if (flag == 1){
                f = new Kvadrat(p1,p2);
                model.addFigur(f);
                c.skickaObject(f);
                ritaAllaFigur();
            }
            if (flag == 3){
                f = new Cirkel(p1,p2);
                model.addFigur(f);
                c.skickaObject(f);
                ritaAllaFigur();
            }else
            if (flag == 2){
                f = new Oval(p1,p2);
                model.addFigur(f);
                c.skickaObject(f);
                ritaAllaFigur();
            }else
            if (flag == 4){
                 f = new Linje(p1,p2);
                model.addFigur(f);
                c.skickaObject(f);
                ritaAllaFigur();

             }else if (flag == 6) {

                for (int i = 0;i<model.allaFigur.size();){

                    if (model.allaFigur.get(i).ärInnanför(p2)){
                       model.allaFigur.remove(i);

                        System.out.println("ta bort fg no. "+i);
                    }else {i++;}
                }this.repaint();
            }

            //System.out.println(antalKlickningar);
            antalKlickningar = 1;

	    }
    }


    public void ritaAllaFigur(){
        this.repaint();

    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (Figur f: model.allaFigur){
            f.rita(g);}
    }




    public void mouseReleased(MouseEvent me){}

    public void mousePressed(MouseEvent me){}

    public void mouseMoved(MouseEvent me){}

    public void mouseDragged(MouseEvent me){}

    public static void main(String[] args){
	//	Mus m=new Mus();
    }


}
