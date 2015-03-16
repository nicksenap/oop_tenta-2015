import java.net.*;
import java.io.*;
import java.util.*;

class Servant extends Thread{
    Server server;
    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;
    
    public Servant(Server server, Socket socket){
	this.server=server;
	this.socket=socket;
	try{
	    in = new ObjectInputStream(socket.getInputStream());
	    out = new ObjectOutputStream(socket.getOutputStream());
	}catch(IOException ioe){
	    System.out.println("IOFEL!!!1");}
    }
    
    public void closeConnection(){
	try{
	    in.close();
	    out.close();
	    socket.close();
	    server.remove(this);
	}catch (Exception e){
	    e.printStackTrace();
	    }
    }
    
    public void run(){
	Object p=null;

        do{
	    try{   
		p=in.readObject();
		server.send(this,p);
	    }catch (IOException ioe){
		System.out.println("IOFEL!!!2");
		closeConnection();
		break;
	    }
	    catch (ClassNotFoundException cnfe){
		System.out.println("IOFEL!!!3");
		System.exit(0);
	    }

	}while(p!=null);
    }

    
    public void send(Object p){
	try{
	    out.writeObject(p);
	    out.flush();
	}catch (IOException ioe){System.out.println("IOFEL!!!4"+ioe);}
    }

}

class Server extends ServerSocket{
    
    ArrayList<Servant> servants;
    public Server(int port) throws IOException{
	    super(port);
	servants= new ArrayList<Servant>();
    }
    

    public  void send(Servant servant ,Object p){
	    for (Servant s:servants)
		if (s!=servant)
		    s.send(p);
	    
    }

    public void remove(Servant s){
	servants.remove(s);
    }
    
    public void starta(){
	while(true){
	    try{
		Socket socket=accept();
		Servant servant= new Servant(this, socket);
		servants.add(servant);
		servant.start();
	    }catch (IOException ioe){System.out.println("xIOFEL!!!5");}
	    
	    }
    }


    public static void main(String[] args)throws IOException{

        System.out.println("Server is running...");
        Server server=new Server(1048);
	    server.starta();

    }

}
