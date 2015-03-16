import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manip extends JPanel implements ActionListener{

    Control rek,kva,ova,cir,lin,del,pun;
    Mus view;

    public Manip( Mus view ){
        super();
        this.view = view;

        rek = new Control("REK");
        kva = new Control("KVA");
        ova = new Control("OVA");
        cir = new Control("CIR");
        lin = new Control("LIN");
        del = new Control("DEL");
        pun = new Control("PUN");

        add(rek);
        add(kva);
        add(cir);
        add(ova);
        add(lin);
        add(del);
        add(pun);
        listener();
        setBackground(Color.gray);
        setPreferredSize(new Dimension(446,50));
    }

    public void listener(){
        rek.addActionListener(this);
        rek.setActionCommand("rek");
        kva.addActionListener(this);
        kva.setActionCommand("kva");
        ova.addActionListener(this);
        ova.setActionCommand("ova");
        cir.addActionListener(this);
        cir.setActionCommand("cir");
        lin.addActionListener(this);
        lin.setActionCommand("lin");
        del.addActionListener(this);
        del.setActionCommand("del");
        pun.addActionListener(this);
        pun.setActionCommand("pun");
        }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("rek")){
            this.view.flag = 0;
    }
        if (e.getActionCommand().equals("kva")){
            this.view.flag = 1 ;
        }

        if (e.getActionCommand().equals("ova")){
            this.view.flag = 2;
        }

        if (e.getActionCommand().equals("cir")){
            this.view.flag = 3;
        }

        if (e.getActionCommand().equals("lin")){
            this.view.flag = 4;
        }

        if (e.getActionCommand().equals("pun")){
            this.view.flag = 5;
        }

        if (e.getActionCommand().equals("del")){
            this.view.flag = 6;
        }
    }


    }



