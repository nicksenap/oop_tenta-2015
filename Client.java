import java.net.*;
import java.io.*;

class InputHelper extends Thread{
    ObjectInputStream in;
    Model model;
    Mus view;

    public InputHelper(ObjectInputStream in, Model m, Mus v){
	    this.in = in;
	    view = v;
	    model = m;
    }
    
    public void run(){
	Rektangel p=null;

        do{
            try{
		p=(Rektangel)in.readObject();
		model.addFigur(p);
		view.ritaAllaFigur();
	    }catch (IOException ioe){
                System.out.println("IOFEL-1!!!");
		closeConnection();
		System.exit(0);
	    }
	    catch (ClassNotFoundException cnfe){
		System.out.println("IOFEL-2!!!");
		System.exit(0);
	    }

	}while(p!=null);
    }

    public void closeConnection(){
	try{
	    in.close();
	}catch (Exception e){
	    e.printStackTrace();
	    }
    }
}

public class Client{
    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;
    InputHelper inputHelper;
    Model model;
    Mus view;
    public Client(InetAddress adress, int port) throws IOException{
	socket = new Socket(adress, port);
	model = new Model();
	view = new Mus(model, this);
	try{
	    out = new ObjectOutputStream(socket.getOutputStream());
	    in = new ObjectInputStream(socket.getInputStream());
	    inputHelper = new InputHelper(in,model,view);
	    inputHelper.start();
	}catch (IOException ioe){
	    System.out.println("IOFEL-3!");
	    System.exit(0);
	}
    }
    
    public void skickaObject(Object o){
	try{out.writeObject(o);
	} catch (IOException ioe){
	    System.out.println("IOFEL-4!!"+" "+ioe);
	    System.exit(0);
	}
	
    }


    public static void main(String[] args)throws IOException{

        new Client(InetAddress.getByName("127.0.0.1"), 1048);
    }    
}
